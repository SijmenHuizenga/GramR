Link - Java EE & Guice
======================

In dit project wordt Guice gebruikt om maximale modulariteit te verzorgen. De volledige presentatie laag draait op dit moment binnen Tomcat met Java EE. Dit betekent dat 'mijn code' wodt gestart vanuit Tomcat. Het aanroepen van 'mijn code' gebeurt dus als volgt:

``Ik -> Start Tomcat -> Bekijkt Web.XML -> Zoek juiste Controller -> Start mijn code``

Het gedeelte `Zoek juiste controller` wil ik laten verzorgen door Guice zodat ik controllers makkenlijk kan vervangen. Guice moet dus inhaken op Java EE. Dit gebeurt als volgt:

Ik heb een WebFilter toegevoegd genaamd `GuiceWebFilter`. Dit filter wordt standaard verzorgd door de Guice Extention `com.google.inject.extensions:guice-servlet`. Dit filter verzorgt de initialisatie van Guice en verzorgt het kiezen van de juiste Controller.

Het `GuiceWebFilter` wil natuurlijk weten welke Guice Module hij moet gebruiken voor de Guice Configuratie. Normaalgesproken configureer je Guice met een `AbstractModule`, maar in dit geval (omdat Guice ook het kiezen van Controllers moet verzorgen) configureer ik Guice met een `ServletModule`. Mijn `ServletModule` heet `MyServletModule`.

Guice weet nog niet welke `ServletModule` hij moet gebruiken. Daarom gaat Guice opzoek naar een `GuiceServletContextListener`. Dit gebeurt via Java EE Listeners die geconfigureerd worden in de web.xml. Ik heb in mijn web.xml dus `MyGuiceServletContextListener` als listener toegevoegd. Deze listener geeft de juiste injector als Guice daar om vraagt (in mijn geval een Injector gemaakt uit `MyServletModule`).

Binnen `MyServletModule` registreer ik met behulp van de functie `serve` welke url door welke controller afgehandeld moet worden. Dit vervangt dus de `@WebServlet` annotatie die normaalgesproken voor deze taak wordt gebruikt. Bijvoorbeeld:

``serve("/example/*").with(ExamplePageController.class);``

Nu gaat het aanroepen van mijn code op de volgende manier:

``Ik -> Start Tomcat -> Bekijkt Web.XML -> Guice selecteert controller -> Start mijn code``