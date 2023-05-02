## 1. List all of the annotations you learned from class and homework to annotaitons.md
1. @Bean: In Spring Framework, @Bean is a method-level annotation that is used to indicate that a method is used to produce a bean which can be managed by the Spring container. When a class is annotated with @Configuration, Spring treats the class as a source of bean definitions. Within the class, methods annotated with @Bean are used to define the beans.
2. @NamedQueries is used to define multiple named queries for a single entity. It takes an array of @NamedQuery annotations as a parameter.
3. @OneToMany: This annotation is used to define a one-to-many relationship between two entities. In this relationship, one instance of an entity is associated with multiple instances of another entity.
4. @ManyToOne: This annotation is used to define a many-to-one relationship between two entities. In this relationship, multiple instances of an entity are associated with one instance of another entity. 
5. @ManyToMany: This annotation is used to define a many-to-many relationship between two entities. In this relationship, multiple instances of each entity are associated with multiple instances of the other entity. 
6. @NamedQuery annotation is used to define a named query for a single entity. It takes two parameters: name and query. The name parameter is the name of the query, and the query parameter is the JPQL query string. Once the named query is defined, it can be called by its name from the EntityManager to retrieve the results

## 2. Type the Comment feature for the class project.
See coding folder

## 4. what is JPA? and what is Hibernate?
JPA (Java Persistence API) is a Java API that defines a standard interface for persisting Java objects to relational databases. JPA provides a set of annotations and APIs that allow developers to map Java classes to database tables and manipulate data using Java objects. JPA is part of the Java EE (Enterprise Edition) platform and is included in most Java application servers.

Hibernate is an open-source Java-based framework that implements the JPA API and provides additional features for object-relational mapping (ORM). Hibernate is one of the most popular and widely used ORM frameworks for Java. Hibernate provides a wide range of features such as caching, lazy loading, and query optimization that help developers to improve the performance of their applications.

## 5. What is Hiraki? what is the benefits of connection pool?
Hikari is a lightweight, high-performance JDBC connection pool for Java applications.

A connection pool is a cache of database connections that are pre-established and can be reused by multiple requests or threads. When an application needs to connect to a database, it can obtain a connection from the pool, use it to perform database operations, and then return the connection back to the pool for reuse. This avoids the overhead of creating a new database connection every time a request is made and can improve the performance of the application.

The benefits of using a connection pool, such as Hikari, include:

- Improved performance: Creating a new connection to the database is an expensive operation in terms of both time and resources. Connection pooling allows you to reuse existing connections, which can improve the performance of your application by reducing the time spent establishing new connections.

- Efficient resource utilization: Connection pooling allows you to limit the number of active connections to the database, which can help prevent resource exhaustion and ensure that database resources are used efficiently.

- Simplified code: Connection pooling libraries like Hikari handle the management of connections for you, which means you don't have to write code to manage connections, close them, or handle errors that may occur during the process.

- Scalability: Connection pooling allows your application to handle a larger number of concurrent requests without having to create a new connection for each request, which can help your application scale to handle more users or higher levels of traffic.

## 6. What is the @OneToMany, @ManyToOne, @ManyToMany? write some examples.

@OneToMany, @ManyToOne, and @ManyToMany are Java annotations used in the Java Persistence API (JPA) to define relationships between entities in an object-relational mapping (ORM) framework such as Hibernate. They are used to represent one-to-many, many-to-one, and many-to-many relationships between entities in a database.
```
@Entity
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL)
    private List<Book> books;
}

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author author;
}
```
```
@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
        name = "student_course",
        joinColumns = @JoinColumn(name = "student_id"),
        inverseJoinColumns = @JoinColumn(name = "course_id")
    )
    private Set<Course> courses;
}

@Entity
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;

    @ManyToMany(mappedBy = "courses")
    private Set<Student> students;
}
```
7. What is the cascade = CascadeType.ALL, orphanRemoval = true? and what
are the other CascadeType and their features? In which situation we choose
which one?
cascade = CascadeType.ALL and orphanRemoval = true are options used in JPA to define how related entities should be handled when a parent entity is updated or deleted. These options are usually set on the "one" side of a one-to-many or many-to-many relationship.

CascadeType is an enumeration that defines different cascade operations. The available cascade types are:

- CascadeType.PERSIST: When the parent entity is persisted, the related child entities are also persisted.
- CascadeType.MERGE: When the parent entity is merged, the related child entities are also merged.
- CascadeType.REMOVE: When the parent entity is removed, the related child entities are also removed.
- CascadeType.REFRESH: When the parent entity is refreshed, the related child entities are also refreshed.
- CascadeType.DETACH: When the parent entity is detached, the related child entities are also detached.
- CascadeType.ALL: Includes all of the above cascade operations.
Choosing the right CascadeType depends on your specific use case and how you want to manage related entities when performing operations on the parent entity. CascadeType.ALL is commonly used when you want all the cascade operations to be applied to the child entities automatically.

orphanRemoval = true is an option that can be used in one-to-many or one-to-one relationships. When orphanRemoval = true, if a child entity is removed from the parent's collection of related entities, it will be automatically removed (deleted) from the database. This is useful when you want to ensure that there are no orphaned entities left in the database without a corresponding parent.

## 8. What is the fetch = FetchType.LAZY, fetch = FetchType.EAGER? what is the difference? In which situation you choose which one?

FetchType.LAZY and FetchType.EAGER are options used in JPA to define how related entities should be loaded from the database when the parent entity is retrieved. These options are typically set on the "one" side of a one-to-many, many-to-one, or many-to-many relationship.

FetchType.LAZY (default): With lazy fetching, related entities are not loaded from the database immediately when the parent entity is retrieved. Instead, they are loaded on-demand when you access the related entities for the first time. This can be more efficient in situations where you don't always need to access the related entities, as it reduces the amount of data that needs to be loaded from the database.

FetchType.EAGER: With eager fetching, related entities are loaded from the database immediately when the parent entity is retrieved. This can be useful in situations where you know you will always need to access the related entities, as it avoids the need for additional database queries to load the related entities later. However, it can also lead to performance issues if you are loading large amounts of unnecessary data from the database.

## 9. What is the rule of JPA naming convention? Shall we implement the method by ourselves? Could you list some examples?
In JPA, there are several naming conventions to consider when defining entities, fields, and methods. Following these conventions can help improve code readability and maintainability. Here are some general rules for JPA naming conventions:

- Entity class names: Entity classes should be named using PascalCase (capitalizing the first letter of each word), and they should be singular nouns that represent the underlying database table. For example: Product, Customer, Order.

- Entity field names: Field names in entity classes should be named using camelCase (capitalizing the first letter of each word except the first), and they should represent the corresponding columns in the database table. For example: firstName, lastName, emailAddress.

- Repository or DAO (Data Access Object) interface names: The names of the interfaces for repositories or DAOs should be formed by combining the entity name with the word "Repository" or "DAO". For example: ProductRepository, CustomerDAO.

- Repository or DAO method names: Method names in repositories or DAOs should follow the conventions defined by the CrudRepository or JpaRepository interfaces when using Spring Data JPA, or use descriptive verb-noun combinations when using plain JPA. For example: findById, findAll, save, deleteById, findByName.

## 10. Try to use JPA advanced methods in your class project. In the repository layer, you need to use the naming convention to use the method provided by JPA.
Please see coding folder

## 11. type the code, you need to checkout new branch from branch 02_post_RUD, name the new branch with https://github.com/TAIsRich/springboot-redbook/ tree/hw05_01_slides_JPQL.
Please see coding JPQL

## 12. What is JPQL?
JPQL, or Java Persistence Query Language, is a query language used in Java Persistence API (JPA) to perform operations on relational databases using an object-oriented approach. JPQL is similar to SQL but operates on Java objects (entities) and their relationships, rather than directly on database tables and columns.

## 13. What is @NamedQuery and @NamedQueries?
@NamedQuery and @NamedQueries are annotations used in Java Persistence API (JPA) to define reusable, static JPQL (Java Persistence Query Language) queries that can be executed by your application. These annotations allow you to define queries directly in your entity classes and give them a name, making it easier to manage and organize your queries.

@NamedQuery is used to define a single named query, while @NamedQueries is used to group multiple @NamedQuery annotations together.

## 14. What is @Query? In which Interface we write the sql or JPQL?
@Query is an annotation used in Spring Data JPA to define custom JPQL (Java Persistence Query Language) or native SQL queries directly on repository interfaces. It allows you to define custom query methods that are not automatically generated by Spring Data JPA based on method naming conventions.

You typically use the @Query annotation in a repository interface that extends JpaRepository, CrudRepository, or another Spring Data JPA repository interface.

## 15. What is HQL and Criteria Queries?
HQL (Hibernate Query Language):
HQL is a powerful and expressive object-oriented query language, similar to JPQL (Java Persistence Query Language). It allows you to perform database operations using an object-oriented approach. HQL operates on persistent objects and their properties rather than directly on database tables and columns.

Criteria Queries:
Criteria Queries are an alternative, programmatic way of querying a database using Hibernate. They provide a type-safe, flexible, and dynamic API for constructing queries in a more object-oriented manner. Criteria Queries can be useful when you need to build complex queries dynamically based on user input or other conditions.

## 16. What is EnityManager?
EntityManager is a central interface in the Java Persistence API (JPA) that provides API methods to perform various operations on entities and their relationships. It is responsible for managing the persistence context, which is a set of managed entity instances that are being persisted, updated, or removed from the database.

## 19. What is SessionFactory and Session?
SessionFactory and Session are core interfaces in Hibernate, a popular Object-Relational Mapping (ORM) framework for Java.

SessionFactory: The SessionFactory is a thread-safe, immutable, and heavy-weight object responsible for creating and managing Session instances. It is typically created once during application initialization and shared across the application. The SessionFactory also holds Hibernate configuration information, such as database connection properties, caching settings, and mapped entity classes.

Session: A Session is a light-weight, non-thread-safe object that represents a single unit of work with the database. It provides methods to perform CRUD operations on entities, execute HQL (Hibernate Query Language) queries, and manage transactions.

## 18. What is Transaction? how to manage your transaction?
A transaction is a sequence of operations that are executed as a single unit of work, ensuring data consistency and integrity in a database system. Transactions follow the ACID properties:

Atomicity: A transaction is atomic, meaning either all of its operations are executed successfully, or none of them are. If any operation fails, the entire transaction is rolled back, and the database is left in a consistent state.
Consistency: A transaction ensures that the database transitions from one consistent state to another. All data integrity constraints are satisfied before and after the transaction.
Isolation: A transaction is isolated from other transactions, meaning their operations are not visible to one another until they are completed. This prevents concurrency issues like dirty reads, non-repeatable reads, and phantom reads.
Durability: Once a transaction is committed, its changes to the database are permanent. The system ensures that the data remains consistent even in case of failures.
In Java Persistence API (JPA), transactions are managed using the EntityTransaction interface, which is obtained from the EntityManager. The EntityTransaction provides methods to begin, commit, and rollback transactions.

## 19. What is hibernate Caching?
Hibernate caching is a performance optimization feature provided by Hibernate, an Object-Relational Mapping (ORM) framework for Java. It allows you to store frequently accessed data in memory, reducing the number of database queries and improving the overall performance of your application.

## 20. What is the difference between first-level cache and second-level cache?
The first-level cache is a session-scoped cache enabled by default in Hibernate, while the second-level cache is an optional, application-scoped cache that requires explicit configuration and is shared across multiple sessions. The first-level cache is useful for reducing redundant queries within a single transaction, while the second-level cache is helpful for caching frequently accessed data across multiple transactions to improve application performance..

## 21. How do you understand @Transactional?
@Transactional is an annotation provided by the Spring Framework to declaratively manage transactions in a Spring-based application. It enables developers to apply transaction management rules to methods without explicitly handling the transaction lifecycle in the code. When a method annotated with @Transactional is executed, the Spring Framework takes care of starting, committing, or rolling back the transaction based on the method's execution outcome.

## 22. Write a simple factory design pattern.
```
interface Product {
    void showProductName();
}

class ProductA implements Product {
    @Override
    public void showProductName() {
        System.out.println("Product A");
    }
}

class ProductB implements Product {
    @Override
    public void showProductName() {
        System.out.println("Product B");
    }
}

class ProductFactory {
    public static Product createProduct(String productType) {
        if (productType == null) {
            return null;
        }

        if (productType.equalsIgnoreCase("A")) {
            return new ProductA();
        } else if (productType.equalsIgnoreCase("B")) {
            return new ProductB();
        }

        return null;
    }
}

public class FactoryPatternExample {
    public static void main(String[] args) {
        // Create product instances using the factory
        Product productA = ProductFactory.createProduct("A");
        Product productB = ProductFactory.createProduct("B");

        // Use the created product instances
        productA.showProductName();
        productB.showProductName();
    }
}
```

