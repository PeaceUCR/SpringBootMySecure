# SpringBootMySecure

Use H2 as default in mem database at http://localhost:8080/console , configured at application.properties

Define Entity in User
Learn the annotation used in entity

Define the Repo works on the User
Some methods are already defined based on the User properties, 'plase be careful with the name of the method'
https://github.com/PeaceUCR/SpringBootMySecure/blob/jpaEntityCRUDwithH2DB/src/main/java/com/example/mysecuredemo/repo/UserRepository.java
CRUD operations work on User

appInit.java
use repo to do the operations, when the system started
Spring APP Event 
https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/context/event/ContextRefreshedEvent.html
https://stackoverflow.com/questions/20275952/java-listen-to-contextrefreshedevent


