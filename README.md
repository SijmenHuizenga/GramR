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


