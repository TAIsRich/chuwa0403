# 1.
`@Repository`: This annotation is used to indicate that the class is a repository or a data access object (DAO) in Spring Data. It is a specialization of the `@Component` annotation and is used to manage the persistence layer in a Spring application.

`@Entity`: This annotation is used to mark a class as a JPA entity. It is used to map a Java class to a database table using JPA annotations.

`@Transactional`: This annotation is used to mark a method, class, or interface as transactional in Spring. It is used to manage database transactions in Spring applications.

`@Query`: This annotation is used to define a custom query in Spring Data JPA. It is used to create dynamic queries using JPA Criteria API or JPQL.

`@Id`: This annotation is used to mark a field as the primary key of an entity in JPA. It is used to map a primary key column in a database table to a Java class field.

`@GeneratedValue`: This annotation is used to specify the generation strategy for a primary key field in JPA. It is used to generate unique primary keys for entities in a database table.

`@JoinColumn`: This annotation is used to specify a foreign key column in JPA. It is used to map a foreign key column in a database table to a Java class field.

`@OneToOne`, `@OneToMany`, `@ManyToOne`, `@ManyToMany`: These annotations are used to specify the type of relationship between entities in JPA. They are used to map associations between entities in a database table to Java class fields.


# 2.
See Coding 1

# 3.
JPQL stands for Java Persistence Query Language. It is a platform-independent query language used to query data from databases in JPA. JPQL is similar to SQL, but instead of operating on tables and columns, it operates on entities and their attributes. JPQL queries are written in a syntax similar to SQL and are then translated by the JPA provider into SQL statements that are executed against the database. JPQL is used in Spring Data JPA to create dynamic queries using the `@Query` annotation.

# 4.
`@NamedQuery` and `@NamedQueries` are annotations used in JPA to define named queries that can be used to query data from the database.

`@NamedQuery` is used to define a single named query in a JPA entity. The named query is defined as a string value in the annotation, which is used as the JPQL query. The named query can then be executed by calling `EntityManager.createNamedQuery()` method with the name of the named query.

`@NamedQueries` is used to define multiple named queries in a JPA entity. It takes an array of `@NamedQuery` annotations as its value, where each annotation represents a named query.

# 5.
`@Query` is an annotation used in Spring Data JPA to define custom queries to retrieve data from a database using SQL or JPQL. It allows you to write queries as string values within the annotation and execute them using Spring Data JPA.

The `@Query` annotation can be used on methods of a Spring Data JPA repository interface. By default, the query is executed using JPQL, but it can be configured to use native SQL queries by setting the `nativeQuery` attribute to `true`.

# 6.
HQL stands for Hibernate Query Language. It is a powerful object-oriented query language used to query data from databases in Hibernate, which is an ORM (Object-Relational Mapping) tool. HQL is similar to SQL, but instead of operating on tables and columns, it operates on objects and their properties. HQL queries are written in a syntax similar to SQL and are then translated by Hibernate into SQL statements that are executed against the database. HQL is used in Spring Data JPA to create dynamic queries using the `@Query` annotation.

Criteria Queries is a programmatic, type-safe way of constructing queries in Hibernate. Criteria Queries are used to build dynamic queries using the Criteria API, which is a set of classes and interfaces provided by Hibernate. Criteria Queries use a type-safe object-oriented API to build queries, which makes it less error-prone and easier to use than HQL. Criteria Queries are useful when the query needs to be constructed dynamically at runtime, based on user input or other conditions.

In Spring Data JPA, you can use both HQL and Criteria Queries to create dynamic queries. HQL is used with the `@Query` annotation, while Criteria Queries are used with the `CriteriaQuery` interface. Both HQL and Criteria Queries provide a powerful and flexible way of querying data from databases in Spring Data JPA.


# 7.
EntityManager is a core interface in the Java Persistence API (JPA) that provides methods for managing entities in a database. It is used to interact with the persistence context, which is a set of managed entities that are associated with a database transaction. The EntityManager is responsible for performing CRUD (Create, Read, Update, Delete) operations on entities and manages their lifecycle.

The EntityManager is created by the persistence provider, which is usually Hibernate in Spring Data JPA, and is injected into Spring-managed beans using the `@PersistenceContext` annotation. The EntityManager is associated with a persistence context, which represents the set of managed entities that are associated with the current transaction. When entities are retrieved from the database using the EntityManager, they are added to the persistence context and become managed entities.

The EntityManager provides methods for persisting new entities, retrieving existing entities, updating entities, and deleting entities from the database. It also provides methods for executing JPQL and native SQL queries against the database.

In Spring Data JPA, you can use the EntityManager to perform CRUD operations on entities, execute queries, and manage the persistence context in a Spring-managed environment.

# 8.
SessionFactory and Session are core interfaces in the Hibernate ORM (Object-Relational Mapping) tool used to interact with the database.

SessionFactory is an interface that is responsible for creating and managing database connections in Hibernate. It is a factory for creating Session instances, which represent a single unit of work with the database. The SessionFactory is created at application startup and is thread-safe, which means that it can be shared among multiple threads.

Session is an interface that represents a single unit of work with the database in Hibernate. It is used to perform database operations such as CRUD (Create, Read, Update, Delete) operations and queries. The Session is created by the SessionFactory and is not thread-safe, which means that it should be used by a single thread only.

The SessionFactory is responsible for managing the Session objects and providing them to the application as needed. When the application needs to interact with the database, it obtains a Session from the SessionFactory, performs the necessary operations, and then closes the Session. The SessionFactory maintains a pool of database connections and manages the transaction boundaries.

In Spring Data JPA, the SessionFactory and Session interfaces are not used directly. Instead, the EntityManager interface is used, which provides a higher-level abstraction over these interfaces. However, understanding the SessionFactory and Session interfaces is still important for understanding how Hibernate works under the hood.

# 9.

A transaction is a logical unit of work that is executed as a single, atomic operation in a database. It is a sequence of database operations that are executed as a single unit of work, such that if any of the operations fail, the entire transaction is rolled back, and the database is returned to its original state.

In Spring Data JPA, transactions are managed by the transaction manager. The transaction manager is responsible for starting, committing, and rolling back transactions. Transactions are managed using the `@Transactional` annotation in Spring.

The `@Transactional` annotation can be used on classes or methods. When used on a class, all methods in the class are included in the transaction. When used on a method, only that method is included in the transaction.

The `@Transactional` annotation has several attributes that can be used to customize the behavior of the transaction. For example, the `readOnly` attribute can be used to indicate that the transaction is read-only and does not require a write lock on the database. The `isolation` attribute can be used to specify the transaction isolation level. The `propagation` attribute can be used to specify the transaction propagation behavior.

By default, transactions are managed using the declarative transaction management approach in Spring. This means that the transaction manager handles the transaction automatically, and you don't need to write any transaction management code. However, if you need more fine-grained control over the transaction management, you can use the programmatic transaction management approach.

In the programmatic transaction management approach, you can use the `TransactionTemplate` class to manage transactions programmatically. The `TransactionTemplate` class provides methods for starting, committing, and rolling back transactions. It also provides methods for executing database operations within a transaction.


# 10.
Hibernate caching is a mechanism used to improve the performance of database operations in Hibernate by reducing the number of database queries that need to be executed. Caching allows Hibernate to store the results of database queries in memory, so that subsequent requests for the same data can be retrieved from the cache instead of the database.

# 11.
First-level cache is a cache of entities that is associated with a single Hibernate Session. The first-level cache is enabled by default in Hibernate, and it stores entities that have been loaded or saved in the current session. When an entity is loaded from the database, it is stored in the first-level cache, and subsequent requests for the same entity are retrieved from the cache instead of the database.

Second-level cache is a cache of entities that is shared among multiple Hibernate Sessions. The second-level cache is not enabled by default in Hibernate, and it needs to be configured manually. When an entity is loaded from the database, it is stored in the second-level cache, and subsequent requests for the same entity are retrieved from the cache instead of the database.

# 13.
```java
// Define an interface for creating objects
interface AnimalFactory {
    Animal createAnimal();
}

// Create concrete implementations of the factory interface
class DogFactory implements AnimalFactory {
    public Animal createAnimal() {
        return new Dog();
    }
}

class CatFactory implements AnimalFactory {
    public Animal createAnimal() {
        return new Cat();
    }
}

// Define the product interface
interface Animal {
    void makeSound();
}

// Create concrete implementations of the product interface
class Dog implements Animal {
    public void makeSound() {
        System.out.println("Woof!");
    }
}

class Cat implements Animal {
    public void makeSound() {
        System.out.println("Meow!");
    }
}

// Create a client that uses the factory to create products
class AnimalClient {
    private AnimalFactory factory;

    public AnimalClient(AnimalFactory factory) {
        this.factory = factory;
    }

    public void playWithAnimal() {
        Animal animal = factory.createAnimal();
        animal.makeSound();
    }
}

// Use the client to create and play with animals
public class Main {
    public static void main(String[] args) {
        AnimalClient dogClient = new AnimalClient(new DogFactory());
        AnimalClient catClient = new AnimalClient(new CatFactory());

        dogClient.playWithAnimal(); // Output: Woof!
        catClient.playWithAnimal(); // Output: Meow!
    }
}

```
---
# HW part2

# 4. 
JPA stands for Java Persistence API. It is a Java specification for Object-Relational Mapping (ORM) that defines a set of interfaces and annotations for mapping Java objects to relational databases. JPA provides a standardized way of interacting with databases in Java, allowing developers to write database-agnostic code that can be easily ported to different databases. Spring Data JPA is a popular implementation of JPA in the Spring Framework.

Hibernate is an ORM (Object-Relational Mapping) tool that implements the JPA specification. It is a popular open-source framework that provides an easy-to-use API for mapping Java objects to relational databases. Hibernate allows developers to interact with databases using object-oriented concepts, such as classes, objects, and inheritance, instead of dealing with low-level SQL queries. Hibernate supports a wide range of databases and provides powerful features such as caching, lazy loading, and optimistic locking.

# 5. 
Hikari is a high-performance JDBC connection pool for Java that provides fast, lightweight, and reliable connections to a database. It is designed to be easy to use and configure, with a simple and intuitive API. Hikari is widely used in enterprise applications and is considered one of the best JDBC connection pools for Java.

Connection pooling is a technique used to improve the performance and scalability of database applications by reusing database connections instead of creating a new connection every time a database operation is performed. Connection pooling involves creating a pool of database connections and allocating them to application threads as needed. When a thread is finished with a connection, it returns it to the pool instead of closing it, so that the connection can be reused by another thread.

Connection pooling provides several benefits, including:

1. Improved performance: By reusing database connections, connection pooling reduces the overhead of creating and closing connections, which can improve the performance of database operations.

2. Better scalability: Connection pooling can help to improve the scalability of database applications by reducing the number of database connections that need to be created.

3. Reduced resource usage: Connection pooling can help to reduce the number of resources used by a database application, such as memory and CPU, by reusing database connections.

4. Enhanced reliability: Connection pooling can help to improve the reliability of database applications by preventing resource exhaustion and reducing the likelihood of database connection errors.

In summary, Hikari is a high-performance JDBC connection pool for Java, and connection pooling is a technique used to improve the performance and scalability of database applications by reusing database connections.

# 6.

`@OneToMany`, `@ManyToOne`, and `@ManyToMany` are JPA annotations used to define relationships between entities in a database. These annotations are used to define how multiple entities are related to each other and how they can be queried.

`@OneToMany` is used to define a one-to-many relationship between two entities, where one entity has a collection of another entity. For example, consider the relationship between a `Department` entity and an `Employee` entity. A department can have many employees, but each employee belongs to only one department. Here is an example of how this relationship can be defined using `@OneToMany`:

```java
@Entity
public class Department {
    @Id
    private Long id;
    
    @OneToMany(mappedBy = "department")
    private List<Employee> employees;
    // ...
}

@Entity
public class Employee {
    @Id
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;
    // ...
}
 @Entity
public class Book {
    @Id
    private Long id;
    
    @ManyToMany(mappedBy = "books")
    private List<Author> authors;
    // ...
}

@Entity
public class Author {
    @Id
    private Long id;
    
    @ManyToMany
    @JoinTable(
        name = "book_author",
        joinColumns = @JoinColumn(name = "author_id"),
        inverseJoinColumns = @JoinColumn(name = "book_id"))
    private List<Book> books;
    // ...
}
```

# 7.
`cascade = CascadeType.ALL` and `orphanRemoval = true` are JPA annotations that are used to define how related entities are handled when their parent entity is deleted.

`cascade = CascadeType.ALL` is used to propagate all entity state transitions from a parent entity to its associated child entities. This means that if an operation is performed on the parent entity (such as saving or deleting), the same operation will be propagated to its child entities. This can simplify database operations by allowing developers to perform operations on the parent entity only.

`orphanRemoval = true` is used to specify that child entities should be removed when they are no longer associated with their parent entity. This is useful when the relationship between the parent and child entities is considered to be a composition relationship, where the child entity should not exist without the parent entity.

- `CascadeType.PERSIST`: propagates the `persist()` operation to related entities.
- `CascadeType.MERGE`: propagates the `merge()` operation to related entities.
- `CascadeType.REMOVE`: propagates the `remove()` operation to related entities.
- `CascadeType.REFRESH`: propagates the `refresh()` operation to related entities.
- `CascadeType.DETACH`: propagates the `detach()` operation to related entities.

# 8.
`fetch = FetchType.LAZY` and `fetch = FetchType.EAGER` are JPA annotations that are used to define how related entities are fetched from the database.

`fetch = FetchType.LAZY` is used to indicate that the related entities should be loaded lazily. This means that the related entities will not be fetched from the database until they are actually accessed. Lazy loading can improve performance by reducing the amount of data that needs to be fetched from the database.

`fetch = FetchType.EAGER` is used to indicate that the related entities should be loaded eagerly. This means that the related entities will be fetched from the database immediately when the parent entity is fetched. Eager loading can simplify database operations by allowing developers to access all related entities at once without having to perform additional database queries.

The choice of `fetch` type depends on the specific requirements of the application. Generally speaking, it is a good idea to use lazy loading for relationships that may not always be accessed, or for relationships with a large number of related entities. This can help to reduce the amount of data that needs to be fetched from the database and improve performance.

# 9.
JPA uses a naming convention to automatically generate SQL statements based on the names of the entities and their attributes. This convention can be useful for reducing the amount of boilerplate code required to interact with the database. The naming convention follows these rules:

1. Entity names are in PascalCase and match the name of the table in the database.
2. Attribute names are in camelCase and match the name of the column in the database.
3. Many-to-many relationships are represented by a join table with the names of the two entities separated by an underscore.

For example, consider an entity `Customer` with attributes `id`, `firstName`, and `lastName`. The corresponding database table and columns might be named `customer`, `id`, `first_name`, and `last_name`. Similarly, if the `Customer` entity has a many-to-many relationship with an entity `Order`, the join table might be named `customer_order`.

While it is possible to implement the methods for interacting with the database manually, using the JPA naming convention can simplify the process by reducing the amount of boilerplate code required. However, it is important to note that the naming convention is not always sufficient, and custom queries and mappings may be required in certain situations.

Examples:
- `findById(Long id)`: finds an entity by its primary key.
- `findAll()`: returns all entities of a given type.
- `findByAttributeName(Type value)`: finds entities by a specific attribute value.
- `deleteById(Long id)`: deletes an entity by its primary key.






