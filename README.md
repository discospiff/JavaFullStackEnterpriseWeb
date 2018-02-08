# Java Full Stack Enterprise Web Application Development
Full stack enterprise web development with Java, Tomcat, Spring, Dependency Injection, Maven, JSF, PrimeFaces, JSON, Hibernate

This repository is the companion of a playlist on Full Stack Enteprise Web, available at https://www.youtube.com/watch?v=fWPFXROMWbk&list=PL73qvSDlAVVhIVQX7d36glpQllxCIxEyR

Glossary

Term|	Definition
--- | ---
Tomcat | Web server.  Interprets .xml, .html, and .class files and runs them.  Handles http requests.
JSF	| Java Server Faces.  A Java-based UI and rendering engine for dynamic web pages.  Also handles navigation.
Managed Bean |	A Java class properly annotated so that JSF can access it.
PrimeFaces |	Rich UI library plugin for JSF.
Spring |	Handles object instantiation and dependency management.  Will be used for Camel configuration as well.
Maven |	XML-based build tool for Java apps.  Automatically handles build dependencies.
Scrum |	Agile development methodology
Sprint |	A set period of time during which specific work has to be completed to create a functional, working piece of software.
Product Backlog |	A high level list of (non-technical) features that can be added to an application.  
Story |	An individual feature.  Measured in story points.
Story Points |	A relative complexity measure for stories.  Use Fibonacci numbers.  This is NOT a reflection of time; only relative complexity.
Sprint Task |	A list of technical tasks required to complete a story.
Sprint Planning |	A meeting at the start of a Sprint where we task out stories into sprint tasks.
Sprint Review	| Review and demonstrate functionality.
Stand Up Meetings	| A meeting that usually takes place every 24hrs within a team to talk about what has been accomplished, what will be accomplished before the next stand up meeting, and any roadblocks that are preventing you to complete work. The team usually stands so these meetings do not run too long.
Backlog Grooming	| The process of adding new user stories to the backlog, re-prioritizing existing stories as needed, creating estimates for previously un-estimated stories, and decomposing large stories into smaller stories or tasks
Sprint Retrospective |	Build productivity by discussing what went well, what didn't go well.  Alternatively, use start-stop-continue format.
Definition of Done | A Story can only be complete when it meets the Definition of Done.  This means more than just code compiled and committed; it also has to be reviewed, tested, and unit tests written.
Scrum Product Owner |	Plans the release and is accountable for the end product.
Scrum Master | Facilitator role not to be confused with a management role. Considered a coach for staying on task and on target.
Scrum Team | Self organizing group of implementors, independently coordinate with other departments.
ORM	| Object Relational Mapping; technology used to easily map a Java object to a Relational Database.
Stakeholder |	Anyone external to the team with a vested interest in the outcome of the team's work.
Business Logic	| The programming that manages communication between an end user interface and a database. The main components of business logic are business rules and workflows.
DAO	| Data Access Object, is an object that provides an abstract interface to some type of database or other persistence mechanism
Dependency Injection	| A software design pattern that implements inversion of control for resolving dependencies. A dependency is an object that can be used (a service). An injection is the passing of a dependency to a dependent object (a client) that would use it.
DTO	| A Data Transfer Object is an object that is used to encapsulate data, and send it from one subsystem of an application to another. DTOs are most commonly used by the Services layer in an N-Tier application to transfer data between itself and the UI layer.
Mockito |	Mockito is a mocking framework, Java-based library that is used for effective unit testing of Java applications.
Web API	| A framework that makes it easy to build HTTP services that reach a broad range of clients, including browsers and mobile devices
API	| Application program interface (API) is a set of routines, protocols, and tools for building software applications. An API specifies how software components should interact and APIs are used when programming graphical user interface (GUI) components.
EclEmma |	It is unit testing code coverage tool. It shows how much of a code base is covered by unit test. When we write new code, the number of coverage should always increase, not decrease.

Example DTO interface:

interface PersonDTO {

  String getName();

  void setName(String name);

}

Example DAO interface:

interface PersonDAO {

PersonDTO findById(long id);

void save(PersonDTO person);

}

Annotations

Name | Description
--- | ---
@Named | Provide a name to identify this object, once created.  Used in autowiring/dependency injection.
@ManagedBean | Makes this bean available for JSF to use
@Scope	| How long should this bean remain in memory?

"session" : the object should remain in memory for the entire time the user is logged in to the web session.

"request" : generate a new object with each http (web page) request.


Important Files

Filename | 	Purpose
--- | ---
web.xml | 	Configuration for a Java-based web application.
pom.xml | 	Configuration for Maven.  Build dependencies go here.
faces-config.xml | 	JSF configuration file.  Navigation rules go here.
applicationContext.xml | 	Spring configuration files.  Java bean definitions and component-scan go here.
*.css	 | Stylesheet to provide consistent styling (font, etc.) across a website.
*.xhtml	 | Where we put HTML markup and JSF tags to create the UI of our application.
