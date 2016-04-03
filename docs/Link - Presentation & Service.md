Link - Presentation & Service
=============================

Binnen de applicatie moet de Presentatie en de Service laag op verschillende manieren kunnen communiceren. Binnen deze testomgeving gaat de communicatie heel direct: De Presentatie laag kan rectstreeks methodes aanroepen op de Service laag omdat ze samen gecompileerd zijn en samen binnen één container draaien. Maar deze applicatie moet ontworpen worden zodat hij eventueel later op verschillende machines kan draaien en dat dan de communicatie tussen de Presentatie en de Service laag via REST JSON gaat. Er moet dus een ontwerp zijn wat deze modulariteit ondersteunt. 

Presentatie kant
----------------
Aan de Presentatie kant heb je te maken met een Controler die aan een Model om data vraagt. Die Controller heeft er geen baat bij op welke manier het Model aan zijn data komt. Het Model krijgt dus natuurlijk de verantwoordelijkheid om (op welke manier dan ook) de data van de Service laag op te halen. 

Nu is het zo dat er voor één Model, meerdere manieren zijn om de data van de Service laag op te halen. Dan kom je dus uit op een volgend ontwerp:

![controller model abstraction](https://raw.githubusercontent.com/SijmenHuizenga/GramR/master/docs/diagrams/controller%20model%20abstraction.png)

Te zien is dat de Controller via een Interface toegang krijgt tot een van de implementaties van het Model, maar hij weet niet welke. Dit wordt namenlijk geregeld door Guice Dependency Injection. Op deze manier kan Snel en Makkenlijk gewisseld worden van Model-Implementatie.

Service kant
------------
Aan de andere kant bij de Service laag is het net omgekeerd. Bijvoorbeeld:
``De communicatie tussen presentatie en service laag gaat via een simpel HTTP request. Dit betekent dat op de service laag een http server draait. Deze http server ontvangt het request, ontcijfert het request en vraagt aan de juiste domein-klasse om het antwoord. Daarna zet hij dit antwoord om in de juiste http response.``
Een ander voorbeeld
``De communicatie tussen presentatie en service laag gaat direct door functie-aanroepen. De service-laag geeft de vraag door aan de juiste domein-klasse en retrnt het juiste antwoord.``

In deze twee voorbeelden wordt de service-laag op heel verschillende manieren aangesproken en moet dit worden omgezet naar een éénduidige vraag naar de domein-klasse. Dit is precies omgekeerd van de Presentatie kant waarbij één vraag op verschillende manieren afgehandeld moest worden. De oplossing voor de service laag is als volgt:

![service abstraction](https://raw.githubusercontent.com/SijmenHuizenga/GramR/master/docs/diagrams/service%20abstraction.PNG)

Te zien is dat er meerdere extenties zijn op de abstracte klasse Service. De klasse Service
verzorgt en protected methode waarmee de 'ruwe' data vanuit de Domein klasse kan worden gehaald. Deze data mogen de child-klasse omzetten naar een eigen gewenste formaat. De child-klasse hebben in dit ontwerp geen rechtstreekste toegang tot de domein klasse. 

Omdat ook binnen de service laag gewerkt wordt met Dependency Injection met behulp van Guice moet iemand de verantwoordelijkheid krijgen om Guice te starten. Ik heb gekozen om deze verantwoordelijkheid te leggen bij de abstracte Service klasse. 

De keuze over welke Service implementatie gebruikt wordt is geheel afhankelijk van de gebruiker. Als de gebruiker de Service laag start via de `main` methode in de `HttpService` klasse, dan accepteert de Service laag requests via HTTP. Als er methodes worden aangeroepen via de `DirectService` klasse dan gaat dit ook goed. De keuze over welke service wordt gebruikt ligt dus bij de eindgebruiker.

Totaal
------
Het totale plaatje ziet er dan als volgt uit:
![presntation service class diagram](https://raw.githubusercontent.com/SijmenHuizenga/GramR/master/docs/diagrams/presentation%20service%20klass%20diagram.PNG)