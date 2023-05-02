## 1. List all of the annotations you learned from class and homework to annotaitons.md

1. @Query is an annotation in Spring Data JPA that allows developers to define custom JPQL (Java Persistence Query Language) or native SQL queries to execute against a database. It provides a powerful and flexible way to define complex queries that cannot be expressed using the repository query methods.
2. @NamedQuery annotation is used to define a named query for a single entity. It takes two parameters: name and query. The name parameter is the name of the query, and the query parameter is the JPQL query string. Once the named query is defined, it can be called by its name from the EntityManager to retrieve the results
3. @NamedQueries is used to define multiple named queries for a single entity. It takes an array of @NamedQuery annotations as a parameter.
4. @OneToMany: This annotation is used to define a one-to-many relationship between two entities. In this relationship, one instance of an entity is associated with multiple instances of another entity.
5. @ManyToOne: This annotation is used to define a many-to-one relationship between two entities. In this relationship, multiple instances of an entity are associated with one instance of another entity. 
6. @ManyToMany: This annotation is used to define a many-to-many relationship between two entities. In this relationship, multiple instances of each entity are associated with multiple instances of the other entity. 
7. @JoinTable: This annotation is used to define a many-to-many relationship between two entities. It is used to create a join table that maps the two entities in the relationship.
8. @Bean: In Spring Framework, @Bean is a method-level annotation that is used to indicate that a method is used to produce a bean which can be managed by the Spring container. When a class is annotated with @Configuration, Spring treats the class as a source of bean definitions. Within the class, methods annotated with @Bean are used to define the beans.

## 2. Type the Comment feature for the class project.

See Coding/redbook_comment in branch Bowei_Xu/hw7

## 3. In postman, call of the APIs in PostController and CommentController.

### Post
```
post http://localhost:8080/api/v1/posts
{
    "title":"post11",
    "description":"post11",
    "content":"hello"
}

response
{
    "id": 12,
    "title": "post11",
    "description": "post11",
    "content": "hello"
}

get http://localhost:8080/api/v1/posts

response
{
    "isLast": true,
    "pageNo": 0,
    "pageSize": 10,
    "totalElements": 10,
    "totalPages": 1,
    "content": [
        {
            "id": 3,
            "title": "This is title 3",
            "description": "LA",
            "content": "LA is a beautiful city"
        },
        {
            "id": 4,
            "title": "This is title 4",
            "description": "SF",
            "content": "SF is a beautiful city"
        },
        {
            "id": 5,
            "title": "This is title 4",
            "description": "SF",
            "content": "SF is a beautiful city"
        },
        {
            "id": 6,
            "title": "title test2023-04-30T21:27:41.042905",
            "description": "description test",
            "content": "content test"
        },
        {
            "id": 7,
            "title": "title test2023-04-30T21:30:25.092911",
            "description": "description test",
            "content": "content test"
        },
        {
            "id": 8,
            "title": "title test2023-04-30T21:31:31.998889",
            "description": "description test",
            "content": "content test"
        },
        {
            "id": 9,
            "title": "title test2023-04-30T21:38:36.415509",
            "description": "description test",
            "content": "content test"
        },
        {
            "id": 10,
            "title": "This is title",
            "description": "This is description",
            "content": "This is Content ..."
        },
        {
            "id": 11,
            "title": "This is title 11",
            "description": "This is description 11 ",
            "content": "This is Content 11 ..."
        },
        {
            "id": 12,
            "title": "post11",
            "description": "post11",
            "content": "hello"
        }
    ]
}

get http://localhost:8080/api/v1/posts/3

response
{
    "id": 3,
    "title": "This is title 3",
    "description": "LA",
    "content": "LA is a beautiful city"
}

put http://localhost:8080/api/v1/posts/3

response
{
    "id": 3,
    "title": "post2",
    "description": "Irvine",
    "content": "Irvine is a beautiful city"
}

delete http://localhost:8080/api/v1/posts/3

response
Post entity deleted successfully.
```

### Comment
```
post http://localhost:8080/api/v1/posts/4/comments
{
    "name":"comment1",
    "email":"abc@abc.com",
    "body":"good"
}

response
{
    "id": 2,
    "name": "comment1",
    "email": "abc@abc.com",
    "body": "good"
}

get http://localhost:8080/api/v1/posts/4/comments

response
[
    {
        "id": 2,
        "name": "comment1",
        "email": "abc@abc.com",
        "body": "good"
    },
    {
        "id": 3,
        "name": "comment2",
        "email": "abc@123.com",
        "body": "ok"
    }
]

get http://localhost:8080/api/v1/posts/4/comments/2

response
{
    "id": 2,
    "name": "comment1",
    "email": "abc@abc.com",
    "body": "good"
} 

put http://localhost:8080/api/v1/posts/4/comments/2
{
    "name":"comment2_update",
    "email":"abc@abc123.com",
    "body":"good"
}

response
{
    "id": 2,
    "name": "comment2_update",
    "email": "abc@abc123.com",
    "body": "good"
}

delete http://localhost:8080/api/v1/posts/4/comments/2

response
Comment deleted Successfully

```

## 4. What is JPA? and what is Hibernate?

JPA (Java Persistence API) is a Java specification that provides a standard way to manage the persistence (storage and retrieval) of Java objects in a relational database. JPA allows developers to write code that interacts with databases without having to write SQL statements directly. Instead, developers define the structure and relationships of their Java objects using annotations or XML configurations, and JPA takes care of mapping the objects to the database tables.

Hibernate is a popular implementation of the JPA specification. It provides an object-relational mapping (ORM) framework that allows developers to map Java objects to database tables and vice versa. Hibernate is often used as a replacement for traditional JDBC (Java Database Connectivity) code, as it simplifies the code needed to interact with a database and makes it more object-oriented. Hibernate provides many additional features on top of the JPA specification, such as caching, lazy loading, and optimistic locking, that can improve performance and simplify the code required for certain common database operations. However, because Hibernate is an implementation of JPA, developers can still use the standard JPA API if they prefer.

## 5. What is Hikari? what is the benefits of connection pool?

Hikari is an open-source, high-performance JDBC connection pool for Java applications. A connection pool is a cache of database connections that allows an application to reuse existing connections, rather than creating a new connection each time one is needed. This can improve performance and reduce the load on the database server. Hikari is known for its excellent performance, scalability, and reliability. It is designed to be lightweight and fast, with a small memory footprint and low CPU usage. Hikari also includes features such as connection timeout management, connection validation, and transaction management.

Benefits:

1. Improved performance: Creating and tearing down database connections can be time-consuming and resource-intensive. By reusing existing connections from a pool, an application can avoid the overhead of creating new connections and reduce the overall time spent on database operations.
2. Scalability: A connection pool can help an application scale to handle increased traffic or load. By limiting the number of connections to the database, a connection pool can prevent the database from becoming overloaded and improve overall application performance.
3. Connection reuse: When using a connection pool, an application can reuse existing connections rather than creating new ones each time a connection is needed. This can reduce the overall load on the database and improve the efficiency of the application.
4. Connection management: A connection pool can manage database connections for an application, including opening and closing connections, handling connection timeouts, and managing database transactions. This can simplify the development process and reduce the risk of errors.
5. Resource utilization: By limiting the number of connections to the database, a connection pool can help to optimize the use of resources such as memory and network bandwidth. This can help an application run more efficiently and reduce costs.

```
HikariConfig config = new HikariConfig();
config.setJdbcUrl("jdbc:mysql://localhost/redbook");
config.setUsername("root");
config.setPassword("root1234");

HikariDataSource ds = new HikariDataSource(config);
Connection conn = ds.getConnection();
// use the connection for database operations
conn.close();

ds.close();

```

## 6. What is the @OneToMany, @ManyToOne, @ManyToMany? write some examples.

@OneToMany, @ManyToOne, and @ManyToMany are JPA annotations used to define the relationships between entities in a relational database.

1. @OneToMany: This annotation is used to define a one-to-many relationship between two entities. In this relationship, one instance of an entity is associated with multiple instances of another entity.

```
@Entity
public class Customer {

   @Id
   private Long id;

   @OneToMany(mappedBy = "customer")
   private List<Order> orders;
}

@Entity
public class Order {

   @Id
   private Long id;

   @ManyToOne
   @JoinColumn(name = "customer_id")
   private Customer customer;
}

```
In the Customer entity, @OneToMany is used to map the association with the Order entity. 

2. @ManyToOne: This annotation is used to define a many-to-one relationship between two entities. In this relationship, multiple instances of an entity are associated with one instance of another entity. 

```
@Entity
public class Order {

   @Id
   private Long id;

   @ManyToOne
   @JoinColumn(name = "customer_id")
   private Customer customer;
}

@Entity
public class Customer {

   @Id
   private Long id;

   @OneToMany(mappedBy = "customer")
   private List<Order> orders;
}

```
In the Order entity, @ManyToOne is used to map the association with the Customer entity. 

3. @ManyToMany: This annotation is used to define a many-to-many relationship between two entities. In this relationship, multiple instances of each entity are associated with multiple instances of the other entity.

```
@Entity
public class Student {

   @Id
   private Long id;

   @ManyToMany(mappedBy = "students")
   private List<Course> courses;
}

@Entity
public class Course {

   @Id
   private Long id;

   @ManyToMany
   @JoinTable(
      name = "course_student",
      joinColumns = @JoinColumn(name = "course_id"),
      inverseJoinColumns = @JoinColumn(name = "student_id"))
   private List<Student> students;
}

```

## 7. What is the cascade = CascadeType.ALL, orphanRemoval = true? and what are the other CascadeType and their features? In which situation we choose which one?

In JPA (Java Persistence API), the CascadeType and orphanRemoval are used to define how the state transitions of a parent entity will propagate to its associated child entities. When we remove the relationship between a parent and child, the child record becomes an orphan record meaning that it does not have a parent record. The CascadeType.ALL and orphanRemoval=true are used together to specify that when the state of a parent entity is modified, the same modification should be applied to all associated child entities, and if a child entity is removed from the parent's collection, it should also be deleted from the database. 

Other CascadeType options include:

1. CascadeType.PERSIST: Use this when you want to ensure that new child entities are persisted whenever a parent entity is persisted.
2. CascadeType.MERGE: Use this when you want to ensure that changes to child entities are merged with the database whenever the parent entity is merged.
3. CascadeType.REMOVE: Use this when you want to ensure that child entities are deleted when their parent entity is deleted. 
4. CascadeType.REFRESH: Use this when you want to ensure that changes to child entities are refreshed from the database whenever the parent entity is refreshed. 
5. CascadeType.DETACH: Use this when you want to detach child entities from the persistence context when the parent entity is detached. 

## 8. What is the fetch = FetchType.LAZY, fetch = FetchType.EAGER? what is the difference? In which situation you choose which one?

In JPA (Java Persistence API), the FetchType is used to specify how related entities should be loaded from the database. There are two options: FetchType.LAZY and FetchType.EAGER.

When FetchType.LAZY is used, the related entities are not loaded from the database until they are accessed for the first time. This can improve performance by reducing the number of database queries that are executed. However, it can also lead to LazyInitializationExceptions if the related entities are accessed outside of a transaction or persistence context.

When FetchType.EAGER is used, the related entities are loaded from the database immediately when the parent entity is loaded. This can simplify code by avoiding LazyInitializationExceptions, but it can also lead to performance issues if the related entities are not actually needed.

F@OneToMany: This annotation is used to define a one-to-many relationship between two entities. In this relationship, one instance of an entity is associated with multiple instances of another entity.etchType.LAZY situations:

1. When the related entities are large or expensive to load, and are not always needed
2. When you want to avoid unnecessary database queries and improve performance
3. When you want to avoid LazyInitializationExceptions by ensuring that the related entities are accessed within a transaction or persistence context

FetchType.EAGER situations:

1. When the related entities are small and always needed, and the overhead of loading them is negligible
2. When you want to simplify code by avoiding LazyInitializationExceptions
3. When you know that the related entities will be accessed soon after the parent entity is loaded

## 9. What is the rule of JPA naming convention? Shall we implement the method by ourselves? Could you list some examples?

1. Entity naming convention: The name of the entity class should be in singular form and the first letter of each word should be capitalized.
2. Attribute naming convention: The name of an attribute should be in camel case, and the first letter should be lowercase. 
3. Id attribute naming convention: The primary key attribute of an entity should be named id.
4. Relationship naming convention: The name of a relationship attribute should be in camel case, and should describe the relationship between the two entities. 
5. Join column naming convention: The default name for a join column is the name of the referencing attribute plus the name of the referenced primary key column. 

In terms of implementing the methods, JPA provides default implementations for many of the basic CRUD (Create, Read, Update, Delete) operations. However, you can also define your own methods in the repository interface using method names that follow a specific convention. 

```
public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findByFirstName(String firstName);
}
```

```
public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findByFirstNameAndLastName(String firstName, String lastName);
    List<User> findByFirstNameOrLastName(String firstName, String lastName);
}
```

```
public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByNameContaining(String name);
}
```

```
public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findByTotalPriceGreaterThan(BigDecimal amount);
}
```

```
public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findByStatusIn(List<Status> statuses);
}
```

## 10. Try to use JPA advanced methods in your class project. In the repository layer, you need to use the naming convention to use the method provided by JPA.

See Coding/redbook_comment in branch Bowei_Xu/hw7

## 11. Check out a new branch(https://github.com/TAIsRich/springboot-red book/tree/hw02_01_jdbcTemplate) from branch 02_post_RUD, replace the dao layer using JdbcTemplate.

See Coding/jdbcTemplate

## 12. use JDBC to read the data from database.

```
import java.sql.*;

public class JdbcExample {

    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/redbook";
        String username = "root"; 
        String password = "root1234"; 
        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM posts");

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String title = resultSet.getString("title");
                String description = resultSet.getString("description");
                String content = resultSet.getString("content");

                System.out.println("Post ID: " + id);
                System.out.println("Post title: " + title);
                System.out.println("Post description: " + description);
                System.out.println("Post content: " + content); 
            }

            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
```

## 13. type the code, you need to checkout new branch from branch 02_post_RUD, name the new branch with https://github.com/TAIsRich/springboot-redbook/tree/hw05_01_slides_JPQL.

See Coding/JPQL

## 14. What is JPQL?

JPQL stands for Java Persistence Query Language. It is a language that is similar to SQL but is used to write database queries in a technology-independent manner for JPA (Java Persistence API) based applications. JPQL is used to retrieve data from a database using entity objects, rather than directly using database tables and columns like in SQL.

JPQL supports a variety of syntax for querying and filtering data, including SELECT, FROM, WHERE, GROUP BY, HAVING, and ORDER BY clauses. JPQL queries are written using entity and attribute names instead of table and column names. This makes JPQL queries more abstract and portable across different databases and persistence providers.

## 15. What is @NamedQuery and @NamedQueries?

@NamedQuery annotation is used to define a named query for a single entity. It takes two parameters: name and query. The name parameter is the name of the query, and the query parameter is the JPQL query string. Once the named query is defined, it can be called by its name from the EntityManager to retrieve the results.

@NamedQueries is used to define multiple named queries for a single entity. It takes an array of @NamedQuery annotations as a parameter.

## 16. What is @Query? In which Interface we write the sql or JPQL?

@@OneToMany: This annotation is used to define a one-to-many relationship between two entities. In this relationship, one instance of an entity is associated with multiple instances of another entity.Query is a Spring Data JPA annotation that allows developers to define custom JPQL (Java Persistence Query Language) or native SQL queries to execute against a database. 

@Query can be used in both repository interfaces and implementations. When used in a repository interface, the JPQL or SQL query is defined directly in the annotation. When used in a repository implementation, the query is defined as a string in the method body and passed to @Query as a value. 

```
@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

    @Query("select p from Post p where p.id = ?1 or p.title = ?2")
    Post getPostByIDOrTitleWithJPQLIndexParameters(Long id, String title);
}
```

## 17. What is HQL and Criteria Queries?

HQL (Hibernate Query Language) is a Hibernate-specific query language similar to SQL but uses class and property names instead of table and column names. It is used to query Hibernate's persistent objects and supports a wide range of queries such as SELECT, UPDATE, DELETE, and INSERT.

```
String hql = "FROM Post p WHERE p.title LIKE :keyword OR p.description LIKE :keyword";
Query query = session.createQuery(hql);
query.setParameter("keyword", "%Java%");
List<Post> posts = query.list();
```

Criteria Queries provide a programmatic way to build queries using Java classes and methods. It allows you to create type-safe queries without using any string literals. It provides a way to construct queries using the Hibernate Query API, which provides a higher level of abstraction over HQL.

```
CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
CriteriaQuery<Post> criteriaQuery = criteriaBuilder.createQuery(Post.class);
Root<Post> root = criteriaQuery.from(Post.class);
Predicate predicate = criteriaBuilder.or(
    criteriaBuilder.like(root.get("title"), "%Java%"),
    criteriaBuilder.like(root.get("description"), "%Java%")
);
criteriaQuery.where(predicate);
List<Post> posts = entityManager.createQuery(criteriaQuery).getResultList();
```

## 18. What is EntityManager?

EntityManager is a central interface in the Java Persistence API (JPA) that manages the persistence lifecycle of entities in a Java application. It is responsible for persisting, retrieving, and deleting entities from a database, as well as managing the relationships between entities.

An EntityManager instance represents a transactional context and is used to interact with the persistence context. It provides methods for persisting entities, querying the database, and managing the entity lifecycle. It also manages the entity cache, which stores recently accessed entities to improve performance.

In JPA, the EntityManager is typically obtained from an entity manager factory, which is created by the persistence provider (e.g. Hibernate, EclipseLink). The entity manager factory is configured with persistence properties, such as the database connection URL, username, and password. Once an EntityManager is obtained, it can be used to perform CRUD (create, read, update, delete) operations on entities, as well as execute JPQL, Criteria, and native SQL queries.

## 19. What is SessionFactory and Session?

SessionFactory and Session are central interfaces in Hibernate, a popular Java persistence framework that implements the JPA specification. SessionFactory is responsible for creating new Session instances, which represent a connection to the database. The SessionFactory is typically created once per application and is thread-safe, while Session instances are created per transaction or request and are not thread-safe.

Session is similar to EntityManager in JPA and is responsible for managing the persistence of entities. It provides methods for CRUD operations, as well as more advanced features like caching, lazy loading, and transactions. The Session is the primary interface for interacting with Hibernate and is used to perform various operations like saving, updating, deleting, or querying entities. It also provides APIs for loading related entities and associations lazily or eagerly, controlling the cache, and performing batch operations.

The SessionFactory is responsible for creating Session instances, which represent a connection to the database and allow applications to interact with the persistence layer in Hibernate.

## 20. What is Transaction? how to manage your transaction?

A transaction is a unit of work that must be completed in its entirety or not at all. In the context of database operations, a transaction typically consists of a series of database operations, such as inserting, updating, or deleting records, that must be treated as a single atomic operation. Transactions ensure that the data remains consistent and valid, even in the event of failures or errors.

In a Java application that uses JPA or Hibernate, transactions are typically managed using the EntityManager or Session APIs. Transactions are started using the beginTransaction() method and committed or rolled back using the commit() or rollback() methods.

```
EntityManager entityManager = entityManagerFactory.createEntityManager();
EntityTransaction transaction = entityManager.getTransaction();

try {
    transaction.begin();

    // Perform database operations here

    transaction.commit();
} catch (Exception e) {
    if (transaction.isActive()) {
        transaction.rollback();
    }
    throw e;
}@OneToMany: This annotation is used to define a one-to-many relationship between two entities. In this relationship, one instance of an entity is associated with multiple instances of another entity. finally {
    entityManager.close();
}
```

## 21. What is hibernate Caching?

Hibernate caching is a mechanism used by the Hibernate framework to reduce the number of database queries required to execute a query by caching data in memory. By caching data in memory, Hibernate can avoid making expensive database queries for the same data repeatedly, which can significantly improve the performance of an application.

1. First-level cache - also known as the session cache, is enabled by default in Hibernate and stores the persistent objects associated with a particular session. This cache can be accessed using the get() and load() methods of the Session interface.
2. Second-level cache - is a shared cache that stores data across sessions, allowing multiple sessions to access the same data without needing to query the database. Hibernate supports several second-level cache providers, including Ehcache, Infinispan, and Hazelcast.
3. Query cache - stores the results of a query in memory, so that subsequent requests for the same query can be served from the cache instead of executing the query again.


## 22. What is the difference between first-level cache and second-level cache?

1. First-level cache
Hibernate first level cache is session specific, that’s why when we are getting the same data in same session there is no query fired whereas in other session query is fired to load the data.
2. Second-level cache 
When an entity instance is looked up by its id and if second-level caching is enabled for that entity, the following happens:
a. If an instance is already present in the first-level cache, it is returned from there
b. If an instance is not found in the first-level cache, and the corresponding instance state is cached in the second-level cache, then the data is fetched from there and an instance is assembled and returned
c. Otherwise, the necessary data are loaded from the database and an instance is assembled and returned

The main difference between first-level cache and second-level cache in Hibernate is their scope and the way they are managed.

First-level cache, also known as session cache, is a cache that is associated with a particular Hibernate session. It is enabled by default and stores the persistent objects associated with that session. This cache can be accessed using the get() and load() methods of the Session interface. The first-level cache has a very short lifespan and is destroyed as soon as the session is closed.

On the other hand, the second-level cache is a shared cache that can store data across multiple Hibernate sessions. It is not enabled by default and must be explicitly configured in the Hibernate configuration file. The second-level cache can be used to cache entity objects, collections, and queries. It has a longer lifespan than the first-level cache and can survive beyond the scope of a single session. The second-level cache can be accessed using the SessionFactory interface.

The first-level cache is used to avoid unnecessary database queries during a single Hibernate session, while the second-level cache is used to avoid unnecessary database queries across multiple Hibernate sessions. The first-level cache is useful for read-heavy workloads, while the second-level cache is useful for read-write workloads and for reducing the load on the database. It's worth noting that both caches can work together to improve the overall performance of a Hibernate-based application.

## 23. How do you understand @Transactional?

@Transactional is an annotation used in Spring Framework to indicate that a method or a class should be executed within a transaction. When a method or a class is annotated with @Transactional, Spring Framework automatically creates a transaction around the annotated code, executes it, and commits the transaction if the code completes without any exceptions. If an exception is thrown, Spring rolls back the transaction and re-throws the exception. The @Transactional annotation can be used at both method and class levels. When used at the class level, all public methods of that class are executed within a transaction. When used at the method level, only that method is executed within a transaction.
The @Transactional annotation can also be used with parameters to specify the transactional behavior. For example, @Transactional(readOnly=true) can be used to indicate that the transaction should be read-only and any attempt to modify the database should result in an exception.

See Coding/transaction

## 24. Write a simple factory design pattern

See Coding/MavenProject/src/main/java/com/chuwa/learn/Factory/ in Bowei_Xu/notes

Or another example 
```
interface Product {
    void displayInfo();
}

class ProductA implements Product {
    @Override
    public void displayInfo() {
        System.out.println("This is product A");
    }
}

class ProductB implements Product {
    @Override
    public void displayInfo() {
        System.out.println("This is product B");
    }
}

class ProductFactory {
    public static Product createProduct(String type) {
        switch (type) {
            case "A":
                return new ProductA();
            case "B":
                return new ProductB();
            default:
                throw new IllegalArgumentException("Invalid product type: " + type);
        }
    }
}

Product productA = ProductFactory.createProduct("A");
productA.displayInfo(); 

Product productB = ProductFactory.createProduct("B");
productB.displayInfo(); 
```