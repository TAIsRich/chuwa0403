# Part 1


## 1. List all of the annotations you learned from class and homework to annotaitons.md

check annotations.md


## 2. Type the Comment feature for the class project.


## 3. In postman, call of the APIs in PostController and CommentController.


## 4. what is JPA? and what is Hibernate?
JPA (Java Persistence API) is a Java specification for Object-Relational Mapping (ORM) that defines a standard way of mapping Java objects to relational databases. It provides a set of interfaces and annotations to define the mapping between Java classes and database tables. JPA is a part of Java EE and it allows Java developers to use ORM frameworks in their applications without being tightly coupled to any particular implementation.

Hibernate, on the other hand, is an ORM framework that implements the JPA specification. It is one of the most popular ORM frameworks in the Java ecosystem and provides a powerful and flexible way of working with relational databases in Java. Hibernate provides a wide range of features, such as transparent persistence, automatic dirty checking, caching, and lazy loading, to name a few. It is widely used in enterprise applications and has a large community of developers contributing to its development and maintenance.

## 5. What is Hiraki? what is the benefits of connection pool?

Hikari is a JDBC connection pool library for Java applications. It provides high-performance, highly optimized, and lightweight database connections.

When an application interacts with a database, establishing a new connection each time can be slow and inefficient. A connection pool helps to address this issue by creating a pool of pre-established database connections that can be reused by the application as needed. This eliminates the need for establishing a new connection each time the application interacts with the database and can improve performance significantly.

The benefits of using a connection pool like Hikari include:

Reduced overhead: A connection pool can significantly reduce the overhead of creating and destroying connections for each request, leading to better performance and reduced resource consumption.

Scalability: Connection pooling helps in scaling up the application as it can handle multiple requests simultaneously by maintaining a pool of established connections.

Better resource management: Connection pools can help to manage resources more efficiently by limiting the number of connections that are created at any given time, thus preventing resource starvation and maximizing resource utilization.

Improved reliability: Connection pools can help to improve the reliability of the application by automatically managing failed connections and replacing them with new ones as needed. This can help to ensure that the application continues to function properly even in the event of database connectivity issues.

## 6. What is the `@OneToMany`, `@ManyToOne`, `@ManyToMany`? write some examples.
In JPA, `@OneToMan`y, `@ManyToOne`, and `@ManyToMany` are annotations used to establish relationships between entities.

`@OneToMany` indicates a one-to-many relationship between two entities, where one entity can have multiple instances of the other entity. For example, a Department entity can have multiple Employee entities working for it. In this case, the Department entity would have a `@OneToMany` relationship with the Employee entity.
```java
@Entity
public class Department {
    @Id
    private Long id;

    @OneToMany(mappedBy = "department")
    private List<Employee> employees;
}

@Entity
public class Employee {
    @Id
    private Long id;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;
}
```
`@ManyToOne` indicates a many-to-one relationship between two entities, where multiple instances of one entity can be associated with a single instance of another entity. For example, multiple Employee entities can be associated with a single Department entity. In this case, the Employee entity would have a `@ManyToOne` relationship with the Department entity.
```java
@Entity
public class Department {
    @Id
    private Long id;

    private String name;

    // getters and setters
}

@Entity
public class Employee {
    @Id
    private Long id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;

    // getters and setters
}
```

`@ManyToMany` indicates a many-to-many relationship between two entities, where each entity can have multiple instances of the other entity associated with it. For example, a Book entity can have multiple Author entities, and each Author entity can have multiple Book entities. In this case, both the Book and Author entities would have a `@ManyToMany` relationship with each other.
```java
@Entity
public class Book {
    @Id
    private Long id;

    private String title;

    @ManyToMany(mappedBy = "books")
    private List<Author> authors;

    // getters and setters
}

@Entity
public class Author {
    @Id
    private Long id;

    private String name;

    @ManyToMany
    @JoinTable(name = "author_book",
            joinColumns = @JoinColumn(name = "author_id"),
            inverseJoinColumns = @JoinColumn(name = "book_id"))
    private List<Book> books;

    // getters and setters
}
```


## 7. What is the `cascade = CascadeType.ALL`, `orphanRemoval = true`? and what are the other CascadeType and their features? In which situation we choose which one?
`cascade = CascadeType.ALL` and `orphanRemoval = true` are JPA annotations that are used to specify the cascading behavior of an entity.

`CascadeType.ALL` means that all the operations performed on the parent entity will also be performed on its associated child entities. This includes operations like persist, merge, remove, detach, and refresh.

`orphanRemoval = true` specifies that when a child entity is removed from the parent entity, it should also be deleted from the database. This is useful in cases where the child entity is only associated with a single parent entity and doesn't have any other references.

There are other cascade types available in JPA:

`CascadeType.PERSIST`: specifies that when a new parent entity is persisted, all its associated child entities should also be persisted.

`CascadeType.MERGE`: specifies that when a parent entity is merged, all its associated child entities should also be merged.

`CascadeType.REMOVE`: specifies that when a parent entity is removed, all its associated child entities should also be removed.

`CascadeType.REFRESH`: specifies that when a parent entity is refreshed, all its associated child entities should also be refreshed.

`CascadeType.DETACH`: specifies that when a parent entity is detached, all its associated child entities should also be detached.

The choice of cascade type depends on the specific requirements of the application. For example, if a child entity should be deleted automatically when its parent entity is deleted, `CascadeType.REMOVE` should be used. If a child entity should be persisted automatically when its parent entity is persisted, CascadeType.PERSIST should be used.

## 8. What is the `fetch = FetchType.LAZY`, `fetch = FetchType.EAGER`? what is the difference? In which situation you choose which one?
In JPA, fetch defines how the entity's related entities are loaded from the database when the entity is queried. There are two types of fetch strategies: LAZY and EAGER.

LAZY fetch strategy means that the related entities will only be loaded from the database when the relationship is actually accessed. This can improve performance because it avoids loading data that may not be needed.

EAGER fetch strategy means that the related entities will be loaded from the database along with the main entity. This can be useful when the related entities are always needed, as it avoids additional database queries later on.

To specify the fetch strategy, you can use the fetch attribute on the @ManyToOne, @OneToOne, @OneToMany, or @ManyToMany annotations.

For example, consider a Person entity with a OneToMany relationship with Address entities:
```java
@Entity
public class Person {
    @OneToMany(mappedBy = "person", fetch = FetchType.LAZY)
    private List<Address> addresses;
    // ...
}
```

In this example, the addresses list will only be loaded from the database when it is accessed, due to the LAZY fetch strategy. If EAGER was used instead, the addresses list would be loaded from the database along with the Person entity.

When choosing between LAZY and EAGER, you should consider the performance and usability implications of each strategy. LAZY can improve performance by avoiding unnecessary database queries, but may require additional code to handle lazy loading. EAGER can simplify code by loading all related entities upfront, but may negatively impact performance if the related entities are not always needed.

## 9. What is the rule of JPA naming convention? Shall we implement the method by ourselves? Could you list some examples?

The JPA naming convention defines how entity classes and their properties are mapped to database tables and columns. It follows a set of default rules that can be overridden using annotations. Some of the important rules are:

Entity classes are named using PascalCase and must be annotated with `@Entity`.

Properties of an entity class are named using camelCase and must be annotated with `@Column`.

Primary keys are named "id" and must be annotated with `@Id`.

Foreign keys are named as the entity class name followed by "_id" and must be annotated with `@JoinColumn`.

Many-to-many association tables are named as the concatenation of the two entity class names in alphabetical order.

You do not need to implement these rules yourself, as JPA will automatically map the entity classes to database tables and columns based on these conventions. However, you can override these defaults using annotations such as `@Table`, `@Column`, `@JoinColumn`, etc.


## 10. Try to use JPA advanced methods in your class project. In the repository layer, you need to use the naming convention to use the method provided by JPA.


## 11. (Optional) Check out a new branch(https://github.com/TAIsRich/springboot-redbook/tree/hw02_01_jdbcTemplate) from branch 02_post_RUD, replace the dao layer using JdbcTemplate.


## 12. (Optional) use JDBC to read the data from database.



# Part 2


## 1. List all of the annotations you learned from class and homework to annotaitons.md
check annotations.md


## 2. type the code, you need to checkout new branch from branch 02_post_RUD, name the new branch with https://github.com/TAIsRich/springboot-redbook/tree/hw05_01_slides_JPQL.


## 3. What is JPQL?
JPQL (Java Persistence Query Language) is a query language defined in the JPA specification for querying data from a relational database using JPA entities. It is an object-oriented query language that allows you to write queries using the entity classes and properties rather than the database table and column names. JPQL queries are similar to SQL queries but are written in a platform-independent way, allowing them to be executed on any JPA-compliant database.

JPQL supports a wide range of query operations, including selection, filtering, grouping, ordering, and aggregation. You can use JPQL to retrieve a single entity, a collection of entities, or a projection of one or more properties of an entity. JPQL also supports joins between entities and subqueries.

JPQL queries are defined as string literals that are parsed and validated at runtime by the JPA provider. The syntax of JPQL is similar to SQL, but with some differences, such as the use of object and property names instead of table and column names.


## 4. What is `@NamedQuery` and `@NamedQueries`?
In JPA, the `@NamedQuery` and `@NamedQueries` annotations are used to define named queries that can be used to retrieve persistent objects from the database.

`@NamedQuery` is used to define a single named query, which is a statically defined query string that is associated with an entity class or mapped superclass. The query is defined using JPQL (Java Persistence Query Language).

Here's an example of using `@NamedQuery`:
```java
@Entity
@NamedQuery(name = "User.findByUsername",
            query = "SELECT u FROM User u WHERE u.username = :username")
public class User {
    //...
}
```
In the above example, we define a named query named User.findByUsername that retrieves a user by their username. The query is defined using JPQL.

`@NamedQueries` is used to define multiple named queries that are associated with an entity class or mapped superclass. The queries are defined as an array of `@NamedQuery` annotations.

Here's an example of using `@NamedQueries`:

```java
@Entity
@NamedQueries({
    @NamedQuery(name = "User.findByUsername",
                query = "SELECT u FROM User u WHERE u.username = :username"),
    @NamedQuery(name = "User.findByEmail",
                query = "SELECT u FROM User u WHERE u.email = :email")
})
public class User {
    //...
}
```
In the above example, we define two named queries User.findByUsername and User.findByEmail using `@NamedQueries`. Both queries retrieve a user by either their username or email.


## 5. What is `@Query`? In which Interface we write the sql or JPQL?
`@Query` is a JPA annotation that can be used to define custom queries using SQL or JPQL (Java Persistence Query Language). It is commonly used to perform complex database operations that cannot be achieved using the default JPA query methods.

You can use `@Query` on repository methods defined in an interface that extends the JpaRepository or CrudRepository interface. You can specify the SQL or JPQL query as a string parameter to the `@Query` annotation.

Here's an example of using `@Query` to define a custom JPQL query in a repository interface:

```java
public interface UserRepository extends JpaRepository<User, Long> {
 
    @Query("SELECT u FROM User u WHERE u.firstName = :firstName")
    List<User> findByFirstName(@Param("firstName") String firstName);
 
}
```

In this example, the `@Query` annotation is used to define a JPQL query that selects all User entities whose firstName property matches a given parameter. The :firstName parameter is replaced with the actual parameter value passed to the findByFirstName method using the `@Param` annotation.


## 6. What is HQL and Criteria Queries?
HQL (Hibernate Query Language) is a language that is similar to SQL but is used for querying Hibernate-managed objects instead of relational database tables. It is an object-oriented query language and can work with any persistent object. HQL is used to perform CRUD operations and retrieve objects from the database using the Hibernate ORM framework.

Criteria Queries is a type-safe alternative to HQL that provides a more object-oriented and type-safe way to build queries. It is a programmatic way of building queries with type-safety, code-reuse, and better readability. Criteria Queries are used to construct queries using a set of classes and methods that represent various parts of a query, such as SELECT, WHERE, JOIN, etc.

Both HQL and Criteria Queries are used to perform operations on Hibernate-managed objects and have their own benefits and use cases. HQL provides a more SQL-like syntax and is useful for complex queries that cannot be easily expressed using Criteria Queries. Criteria Queries, on the other hand, provide a more type-safe way to build queries and are useful when the query needs to be built programmatically at runtime.


## 7. What is EnityManager?
`EntityManager` is a core interface in JPA that manages the lifecycle of entities in the persistence context. It is responsible for managing and coordinating the entity state transitions (such as persisting, merging, removing, or refreshing entities) and providing a high-level API for querying entities.

`EntityManager` can be used to create, read, update, and delete entities from the database. It maintains a cache of managed entities, which are the objects that represent the entities in the application's memory. The `EntityManager` is also responsible for ensuring that changes to managed entities are persisted to the database, either explicitly or implicitly.

The `EntityManager` is created using the `EntityManagerFactory` and is typically obtained from a container-managed `EntityManagerFactory` instance in a Java EE environment or by instantiating an `EntityManagerFactory` directly in a Java SE environment.


## 8. What is SessionFactory and Session?
In Hibernate, SessionFactory is an interface that provides a factory for creating Session objects. It is a thread-safe object that is typically instantiated during the application startup and initialized with the necessary configuration information such as database connection details, mapping metadata, and caching settings.

Session is a short-lived object that represents a single unit of work with the database. It provides APIs for querying, inserting, updating, and deleting database records. A Session object is created by calling the openSession() method of SessionFactory. It is not thread-safe and should be created and used within the context of a single thread.

In summary, SessionFactory provides a factory for creating Session objects, while Session provides an interface for working with the database.


## 9. What is Transaction? how to manage your transaction?
In the context of databases, a transaction is a set of one or more operations that should be executed as a single, indivisible unit of work. Transactions ensure that a set of operations is either completely executed or completely rolled back in case of failure, maintaining the consistency and integrity of the data.

In Java, transactions can be managed using the Java Transaction API (JTA) or using the Hibernate-specific transaction API. The basic steps to manage transactions are as follows:

Begin the transaction: This is the first step of a transaction, where a new transaction is started.

Execute database operations: Once the transaction is started, the database operations are executed.

Commit or Rollback the transaction: After the successful execution of the database operations, the transaction can be committed, which saves the changes permanently. In case of any failure, the transaction can be rolled back, which undoes all the changes made within the transaction.

In Spring, transactions can be managed using the @Transactional annotation, which can be applied to classes or methods. This annotation provides a declarative way to define transactions, which simplifies the code and improves the maintainability.

There are two ways to define transactions using the @Transactional annotation:

Class-level: In this approach, the @Transactional annotation is applied to the class, and all the methods of the class become transactional.

Method-level: In this approach, the @Transactional annotation is applied to individual methods, and only those methods become transactional.

By default, Spring transactions are REQUIRED and use the underlying transaction manager to manage transactions. Other transactional behaviors can be specified using the propagation, isolation, and readOnly attributes of the @Transactional annotation.


## 10. What is hibernate Caching?
Hibernate caching is a mechanism that allows you to store frequently accessed data in a cache memory to improve application performance by reducing the number of database hits. Caching can be implemented at multiple levels such as the session-level cache, the second-level cache, and the query-level cache.

The session-level cache is associated with a particular Hibernate session and is enabled by default. It stores the objects that have been retrieved from the database during a session so that they can be easily accessed later without having to query the database again.

The second-level cache is a shared cache that can be used across multiple sessions in an application. It caches data at the entity and collection level so that multiple sessions can access the same data without having to query the database repeatedly.

The query-level cache caches the results of frequently executed queries so that the same query does not have to be executed repeatedly, which can lead to significant performance improvements.

Hibernate supports several caching providers such as Ehcache, Infinispan, Hazelcast, and more. You can configure caching in Hibernate by specifying cache regions, eviction policies, and other parameters in the Hibernate configuration file or programmatically using the Hibernate API.

To manage the cache effectively, you should have a clear understanding of your application's data access patterns, the size and frequency of the data being accessed, and the cache implementation options available.



## 11. What is the difference between first-level cache and second-level cache?
In Hibernate, the first-level cache is also known as the session cache. It is a mandatory cache that is automatically created and managed by the Hibernate framework. The first-level cache is maintained within the boundaries of a single session and helps in reducing the number of database queries. Whenever a session retrieves an object from the database, Hibernate stores it in its session cache, and the next time the same object is requested, it can be easily retrieved from the cache instead of querying the database again.

On the other hand, the second-level cache is an optional cache that is maintained across sessions and can be shared among multiple sessions. It is used to cache data that is frequently used but doesn't change frequently. By storing data in the second-level cache, Hibernate avoids the overhead of querying the database frequently.

The main difference between the first-level cache and the second-level cache is their scope. The first-level cache is available only within a session, while the second-level cache can be shared among multiple sessions. Additionally, the first-level cache is mandatory and managed by Hibernate, while the second-level cache is optional and can be managed by the developer.


## 12. How do you understand @Transactional? (不要clone，要⾃⼰抄写并测试 transactional，https://github.com/TAIsRich/tutorial-transaction)


## 13. Write a simple factory design pattern.
```java
public interface Animal {
    void makeSound();
}

public class Dog implements Animal {
    public void makeSound() {
        System.out.println("Woof!");
    }
}

public class Cat implements Animal {
    public void makeSound() {
        System.out.println("Meow!");
    }
}

public class AnimalFactory {
    public Animal createAnimal(String animalType) {
        if (animalType == null) {
            return null;
        }
        if (animalType.equalsIgnoreCase("dog")) {
            return new Dog();
        } else if (animalType.equalsIgnoreCase("cat")) {
            return new Cat();
        }
        return null;
    }
}

public class Main {
    public static void main(String[] args) {
        AnimalFactory animalFactory = new AnimalFactory();

        Animal dog = animalFactory.createAnimal("dog");
        dog.makeSound(); // Output: "Woof!"

        Animal cat = animalFactory.createAnimal("cat");
        cat.makeSound(); // Output: "Meow!"
    }
}
```
In this example, we have an interface `Animal` with a method `makeSound()`. We also have two classes that implement the `Animal` interface: `Dog` and `Cat`.

The `AnimalFactory` class has a method `createAnimal(String animalType)` that takes in a String representing the type of animal to create. If the `animalType` is `"dog"`, it returns a new `Dog` object. If the `animalType` is `"cat"`, it returns a new `Cat` object. If the `animalType` is anything else or `null`, it returns `null`.

Finally, in the `Main` class, we create an instance of `AnimalFactory` and use it to create `Dog` and `Cat` objects, which we then call the `makeSound()` method on.
