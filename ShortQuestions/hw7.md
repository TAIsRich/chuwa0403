# 1.  List all of the new annotations to your annotaitons.md and explain its role.
## annotations.md
# 2.  how do you do the debug?
## create a copy of the code and start to go step by step debug. Try to locate the error and fix from there. Write specific test case to help to fix the bug.
# 3.  What is DTO, VO, Payload, DO, model?
## Data transfer object (DTO), formerly known as value objects or VO, is a design pattern used to transfer data between software application subsystems. DTOs are often used in conjunction with data access objects to retrieve data from a database.
## VO(Value Object) represents itself a fixed set of data and is similar to a Java enum. A Value Object's identity is based on their state rather than on their object identity and is immutable.
## Payload refers to the data or information that is sent by the client in a request to the server or the data that is returned by the server in response to a request. The payload typically contains the data that needs to be processed or manipulated by the server, such as a JSON or XML object, or sometimes binary data like images or videos.
# 4.  What is @JsonProperty("description_yyds")?
## Marker annotation that can be used to define a non-static method as a "setter" or "getter" for a logical property accessor (depending on its signature), or a non-static Object field to be used (serialized, deserialized) as a logical property (to assign value or get value from)
# 5.  do you know what is jackson?
## Jackson is a very popular and efficient java based library to serialize or map java objects to JSON and vice versa. 
# 6. What is spring-boot-stater?
## Spring Boot Starters are dependency descriptors that can be added under the <dependencies> section in pom.xml. These starters give all the dependencies under a single name.
## a. what dependencies in the below starter? do you know any starters?
### Starter for building web, including RESTful, applications using Spring MVC. Uses Tomcat as the default embedded container.
# 7. do you know  @RequestMapping(value = "/users", method = RequestMethod.POST) ? could you list CRUD by this style?
## @RequestMapping(value="...", method=RequestMethod.GET)
## @RequestMapping(value="...", method=RequestMethod.DELETE)
# 8.  What is ResponseEntity? why do we need it?
## ResponseEntity represents the whole HTTP response: status code, headers, and body. As a result, we can use it to fully configure the HTTP response.
# 9.  What is ResultSet in jdbc? and describe the flow how to get data using JDBC
## A ResultSet object maintains a cursor that points to the current row in the result set. The term "result set" refers to the row and column data contained in a ResultSet object. First, load the JDBC driver and create a connection to the database. Then, create a Statement and execute the query to get a ResultSet. Next, traverse and process the ResultSet.
# 10. What is the ORM framework?
## Object-relational mapping (ORM) is a way to align programming code with database structures. ORM uses metadata descriptors to create a layer between the programming language and a relational database.
# 11. Learn how to use ObjectMapper by this example.
## Omaper.java
# 12. What is the serialization and desrialization?
## Serialization is a mechanism of converting the state of an object into a byte stream. Deserialization is the reverse process where the byte stream is used to recreate the actual Java object in memory.
# 13. use stream api to get the average of the array [20, 3, 78, 9, 6, 53, 73, 99, 24, 32].
```
import java.util.Arrays;
public class Strapi {
	public static void main(String[] args) {
		int[] arr = new int[]{0, 3, 78, 9, 6, 53, 73, 99, 24, 32};
	    int sum = Arrays.stream(arr).sum();
        double avg = Arrays.stream(arr).average().orElse(Double.NaN);
        System.out.print(sum+" "+avg);
	}
}
```
# 14. 抄写，https://github.com/TAIsRich/springboot-
## Redbook
# 15. 抄写 https://github.com/TAIsRich/springboot-redbook/tree/04_comm
## Redbook
# 16. Try to write the CRUD api for a new application Cassandra-Blog
## Cassandra-Blog