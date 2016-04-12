# GramR
## H1 Inleiding
Voor het vak DEA heb ik de opdracht gekregen een ontwerp en implementatie van de cases GramR te maken. In dit verslag is het ontwerp en implementatiekeuzes te vinden. Alle teksten in diagrammen zijn in het Engels. Alle programmeer code is in het Engels. Alle documentatie binnen én buiten programmeercode zoals javadoc en verslagen zijn in het Nederlands. Zo kan binnen documentatie overzichtelijk verwezen worden naar termen in diagrammen en code.

## H2 Use case diagram
Het use-case diagram geeft aan welke acties door het systeem ondersteund moeten worden.
![Use Case Diagram](https://raw.githubusercontent.com/SijmenHuizenga/GramR/master/docs/verslag/verslag%20(1).png)

##H3 Domein model
In dit domeinmodel staan alle domeinen die bij binnen het domein gebruikt gaan worden. 
![Domein model](https://raw.githubusercontent.com/SijmenHuizenga/GramR/master/docs/verslag/verslag%20(2).png)

Er zijn een aantal veranderingen t.o.v het diageram zoals aangeleverd in de GramR casus:

* In het domeinmodel is een ID toegevoegd aan Photo. Wij verwachten dat in een later stadium het moeilijk wordt Photo’s in een database op te slaan en terug te halen zonder identificatienummer.
*  Privacy domein hernoemen naar PhotoPrivacy omdat dit beter weergeeft wat het domein doet. Het woord Privacy impliceert dat dit object ‘iets van privacy’ regelt, maar geeft niet aan dat het de privacy van een Photo regelt. Daarom hernoem we dit domein naar PhotoPrivacy.

##H4 Phisical Data Model 
In het PDM staan de fysieke tabellen binnen de tabellen. Dit komt redelijk overeen met het Domeinmodel.
![PDM](https://raw.githubusercontent.com/SijmenHuizenga/GramR/master/docs/verslag/verslag%20(3).png)

Er is gekozen om het de filter-structuur te implementeren binnen twee tabellen. Er zou een trigger gemaakt moeten worden om de  Buisness-Rule “Een Photo mag maar één Filter” binnen de database te behouden.

##H5 Deployment Diagram
In dit hoofdstuk wordt het Deployment Diagram behandeld. In een deployment diagram is te zien op welke manier de verschillende interne en externe fysieke systemen van de applicatie met elkaar in verbinding staan.

![deployment diagram](https://raw.githubusercontent.com/SijmenHuizenga/GramR/master/docs/verslag/verslag%20(4).png)

In dit deployment diagram zijn de verschillende omringende systemen rondom de GramR Application te zien. De Personal Computer is de fysieke machine van de eindgebruiker. De eindgebruiker draait een Web Client zoals Chrome of Firefox om de applicatie te gebruiken.

Requests vanuit de Client komen binnen in de Frontend van de GramR Application. De Frontend interpreteert de aanvraag en vraagt aan de Backend om de juiste antwoord data. De Frontend geeft deze data op de juiste manier weer en geeft de response aan de Client.

De werking binnen de GramR Application is verder uitgewerkt in het volgende hoofdstuk.

De GramR Application Backend verbindt met de Database server om data op te halen en verbindt met Flicker en Instagram om foto’s op te halen en te plaatsen. De verbinding met Flicker en Instagram wordt verder niet uitgewerkt.

De Backend en de Frontend van de GramR Applicatie zijn in dit diagram gescheiden, maar deze twee kunnen ook binnen één container draaien. Dit is modulair opgebouwd (zie Class Diagram). Door deze dit te ondersteunen wordt voldaan aan requirement 5 en 6. 

##H6 Packagediagram 
In dit hoofdstuk wordt het Package Diagram behandeld. Dit package diagram laat zien hoe de code in dit project wordt geordend. 

![Package Diagram](https://raw.githubusercontent.com/SijmenHuizenga/GramR/master/docs/verslag/verslag%20(5).png)

In het package diagram is elke use case weergegeven als een aparte package. Elke van deze packages heeft drie layers: de Presentation, Service en Data. Deze drie layers bevatten alle logica van onze applicatie. Domein Objecten die in een layer worden aangemaakt moeten ook door andere layers gelezen kunnen worden daarom is er een gezamenlijk package ‘common’. Deze zorgt ervoor dat Domein object over alle lagen beschikbaar zijn.

Dit is de code van de GramR applicatie als alles in één container draait en alles samen gecompileerd wordt. Maar deze applicatie kan ook in twee containers draaien. Als dit het geval is worden de packages uit elkaar gehaald:

* Frontend (oranje)
  * Common
  * Presentation
* Backend (blauw)
  * Common
  * Service
  * Data

In dit ontwerp is er voor gekozen om alle functionaliteiten van elke use case in een apart package te zetten, zie optie 1. Een andere mogelijkheid was geweest om de functionaliteiten per layer te bundelen en aan de hand daarvan alle packages te bepalen, zie optie 2. Uiteindelijk is er voor gekozen om dit niet te doen zodat de functionaliteiten gescheiden blijven. Hierdoor zijn deze beter aanpasbaar in tegenstelling tot de andere methode. Dit is in overeenstemming met requirement 7.

![Package Diagram opties](https://raw.githubusercontent.com/SijmenHuizenga/GramR/master/docs/verslag/verslag%20(6).png)

##H7 Class diagram 
Het klasse diagram laat álle klasse zien binnen een project. Als het klasse diagram in één keer hier wordt weergegeven zou het veel te groot worden. Daarom is het klasse diagram in meerdere onderdelen opgedeeld. 

###H7.1 Domein
Dit is het klasse diagram van alle domein klasse. Deze klasse zitten allemaal binnen de package ‘it.sijmen.gramr.common.pojo’

![Class Diagram Domain](https://raw.githubusercontent.com/SijmenHuizenga/GramR/master/docs/verslag/verslag%20(7).png)

Er is een FilterFactory. Deze klasse verzorgt het aanmaken van de verschillende filters. 

###H7.2 Presentation 
Er zijn een viertal packages ‘presentation’ (zie package diagram) die allemaal de alleen het package it.sijmen.gramr.photo.presentation zien. De structuur binnen de andere ‘presentation’ packages zullen het zelfde zijn, alleen worden daar andere functionaliteiten uitgewerkt. 

![Klasse diagram Presentation](https://raw.githubusercontent.com/SijmenHuizenga/GramR/master/docs/verslag/verslag%20(8).png)

(PhotoRestModel is niet geïmplementeerd in deze casus, deze is nu toegevoegd om het duidelijker te maken.)

Elk Presentation package bevat een of meerdere Controllers. Deze controllers extenden de klasse AbstractController. AbstractController extends HttpServlet en is daarmee een servlet. AbstractController voegt een aantal functionaliteiten toe die in alle controllers handig zijn. Bijvoorbeeld het zoeken van opzoeken van de huidige gebruiker. De Controllers zelf zijn verantwoordelijk voor één bepaalde pagina. Met behulp van Guice wordt de juiste URL gekoppeld aan de juiste Controller.

Controllers maken gebruik van Models om de data op te halen. Models zijn een interface die worden geïmplementeerd door verschillende type Models. Zo is hier een PhotoModel interface die wordt geïmplementeerd door PhotoDirectModel en PhotoRestModel. De keuze of de ene of de andere implementatie wordt gebruikt wordt gedaan door Guice. 

De geïmplementeerde models zijn zelf verantwoordelijk over de manier waarop ze aan de data komen. Zo zal PhotoDirectModel rechtstreeks de data van de Service laag ophalen, maar zal de PhotoRestModel dit via een REST request doen.

Binnen dit diagram zijn geen Views opgenomen. Views bevatten alle html-markup voor het weergeven van de pagina’s. Dit zijn geen echte klasse, ze zitten ook niet in een package. De Views zijn allemaal te vinden in de map ‘Frontend/web/WEBINF/pages’. Binnen de views is geen java code gebruikt. Er is alleen gebruik gemaakt van JSP en JSTL functies/tags.

###H7.3 Service
Er zijn een viertal packages ‘service’ (zie package diagram) die allemaal de zelfde structuur aan klasse bevatten. Hier laat ik alleen het package it.sijmen.gramr.photo.service zien. De structuur binnen de andere ‘service’ packages zullen het zelfde zijn, alleen worden daar andere functionaliteiten uitgewerkt

![Klasse diagram Service](https://raw.githubusercontent.com/SijmenHuizenga/GramR/master/docs/verslag/verslag%20(9).png)

Het middelpunt van dit diagram is de klasse PhotoService. Deze klasse verzorgt bepaalde functionaliteit. Dit doet hij door DAO’s en Domein klasse aan te spreken. Deze functionaliteit moet publiek gemaakt worden. Dit wordt gedaan door zogeheten ‘ServiceProviders’. De klasse abstracte PhotoServiceProvider kan worden geexten om de functionaliteit op een bepaalde manier naar buiten te brengen. Zo is er de  PhotoDirectServiceProvider die de service rechtsreeks aanspreekbaar maakt. Ook is er der PhotoRestServiceProvider die de service via REST aanspreekbaar maakt.

De PhotoServiceProvider extend de klasse AbstractServiceProvider en geeft daarbij de ServiceProvider type mee wat hij publiek wil maken. PhotoServiceProvider geeft dus door aan zijn parent AbstractServiceProvider dat hij een ServiecProvider van de PhotoService is. Met deze informatie kan AbstractServiceProvider een instantie aanmaken van de gegeven Service en die beschikbaar maken voor de child providers.

Omdat het startpunt van de Backend bij de Providers ligt (de Backend heeft geen main methode, maar wordt gestart vanuit de providers) moet de provider zorgen dat Guice geïnitialiseerd wordt. Zonder Guice kunnen de Services niet werken omdat deze DAO’s nodig hebben. De verantwoordenlijkheid van het initialiseren van Guice wordt gedaan binnen de klasse AbstractServiceProvider. Deze maakt een Guice Injector en maakt daarmee een instantie van de gegeven service. Zo kan al binnen de service @Inject worden gebruikt.

###H7.4 Presentation & Service Link
Als je nu een plaatje zou tekenen van de communicatie tussen de presentatie en service laag zou dat er als volgt uit komen te zien:

![Presentatie Service Link Klasse diagram](https://raw.githubusercontent.com/SijmenHuizenga/GramR/master/docs/verslag/verslag%20(10).png)

Het model praat met de service. Dit kan dus op verschillende manieren. 

Als nu een nieuw communicatie type moet worden toegevoegd, dan kan dit worden geïmplementeerd met behulp van twee klasse: Een model en een ServiceProvider.

###H7.5 Data 
Er zijn een viertal packages ‘data’ (zie package diagram) die allemaal de zelfde structuur aan klasse bevatten. Hier laat ik alleen het package it.sijmen.gramr.photo.data zien. De structuur binnen de andere ‘data’ packages zullen het zelfde zijn, alleen worden daar andere functionaliteiten uitgewerkt. 

![Klasse diagram Data](https://raw.githubusercontent.com/SijmenHuizenga/GramR/master/docs/verslag/verslag%20(11).png)
Het doel van dit onderdeel is data verzorgen. Dit begint bij de interface die aangeeft welke data er opgehaald moet worden. Deze interface kan door verschillende klasse geïmplementeerd worden (bijvoorbeeld voor verschillende type datasources). In dit geval wordt PhotoDAO alleen geïmplementeerd door PhotoJDBCDAO. Dit is een implementatie om via JDBC te verbinden met een Database.

Alle DAO’s moeten extenden van AbstractDAO. PhotoJDBCDAO extends niet rechtstreeks van AbstractDAO. Er zit een klasse genaamd JdbcDAO die de verbinding met de database regel. Ook zitten hier helper-methods die veelvorkomende JDBC acties autmoatiseren.

Het echté verbinding maken met een database wordt gedaan door de JdbcDatabaseConnectionFactory. Deze Factory maakt een connectie, vangt fouten af en houdt de connectie open zodat voor één request niet meerdere database connecties worden gemaakt. De data die deze factory nodig heeft (database connectie string, username en password) wordt geïnjecteerd door Guice. 

###H7.6 Service & Data Link 
Nu kan je een plaatje tekenen van de communicatie tussen de Service en de Data laag. Dit plaatje ziet er als volt uit:

![Klasse diagram Service en Data link](https://raw.githubusercontent.com/SijmenHuizenga/GramR/master/docs/verslag/verslag%20(12).png)

De Service vraagt om een PhotoDAO. De Guice Injector geeft dan de juiste de klasse PhotoJDBCDAO. Zo kan (zonder dat de service daar last van heeft) een andere data source implementatie worden gebruikt.


