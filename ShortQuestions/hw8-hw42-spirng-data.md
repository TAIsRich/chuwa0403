## part1

###what is JPA? and what is Hibernate?

JPA (Java Persistence API) is a specification in Java EE (Enterprise Edition) for object-relational mapping (ORM) frameworks. It provides a set of interfaces and annotations that define the standard way of mapping Java objects to relational databases. JPA allows developers to work with persistent data using a high-level object-oriented API, abstracting away the underlying database details.

Hibernate, on the other hand, is a popular open-source implementation of the JPA specification. It is one of the most widely used ORM frameworks in the Java ecosystem. Hibernate provides an implementation of the JPA interfaces and annotations, allowing developers to easily map Java objects to relational databases and perform database operations using a rich set of APIs.



### What is Hikari? what is the benefits of connection pool?


HikariCP is a high-performance JDBC connection pool for Java applications. Connection pooling is a technique used to manage and reuse database connections, providing several benefits:

1. Improved performance: Connection pooling reduces the overhead of creating and closing database connections for each request, resulting in faster response times and improved application performance.
2. Resource optimization: Connection pooling allows multiple clients to share a fixed number of database connections, optimizing resource usage and preventing resource exhaustion.
3. Connection reuse: With connection pooling, idle connections can be reused instead of being closed, eliminating the need to establish a new connection for each database interaction.
4. Connection management: Connection pooling handles connection acquisition and release, ensuring proper management and preventing connection leaks.
5. Scalability: Connection pooling enables efficient resource utilization, allowing applications to handle a larger number of concurrent requests without overwhelming the database server.
6. Tunable configuration: Connection pool settings can be adjusted to optimize performance based on specific application requirements and database server capabilities.



### What is the @OneToMany, @ManyToOne, @ManyToMany? write some examples.

The annotations `@OneToMany`, `@ManyToOne`, and `@ManyToMany` are used in JPA to establish relationships between entities in a relational database. Here are some examples of how these annotations are used:

1. `@OneToMany`: This annotation is used to define a one-to-many relationship between two entities. It is typically used when one entity has a collection of related entities. For example:

```java
@Entity
public class Post {
    @Id
    private Long id;
    private String title;

    @OneToMany(mappedBy = "post")
    private List<Comment> comments;
}

@Entity
public class Comment {
    @Id
    private Long id;
    private String content;

    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;
}
```

In this example, the `Post` entity has a one-to-many relationship with the `Comment` entity. One post can have multiple comments, and each comment belongs to a single post.

2. `@ManyToOne`: This annotation is used to define a many-to-one relationship between two entities. It is typically used when multiple entities are associated with a single entity. For example:

```java
@Entity
public class Order {
    @Id
    private Long id;
    private String orderNumber;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;
}

@Entity
public class Customer {
    @Id
    private Long id;
    private String name;

    @OneToMany(mappedBy = "customer")
    private List<Order> orders;
}
```

In this example, the `Order` entity has a many-to-one relationship with the `Customer` entity. Multiple orders can be associated with a single customer.

3. `@ManyToMany`: This annotation is used to define a many-to-many relationship between two entities. It is typically used when multiple entities can be associated with multiple entities of another type. For example:

```java
@Entity
public class Student {
    @Id
    private Long id;
    private String name;

    @ManyToMany
    @JoinTable(name = "student_course",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "course_id"))
    private List<Course> courses;
}

@Entity
public class Course {
    @Id
    private Long id;
    private String name;

    @ManyToMany(mappedBy = "courses")
    private List<Student> students;
}
```

In this example, the `Student` entity has a many-to-many relationship with the `Course` entity. A student can enroll in multiple courses, and a course can have multiple students.

These annotations help define and map the relationships between entities in a database, enabling efficient and convenient querying and data management.

### What is the cascade = CascadeType.ALL, orphanRemoval = true? and what are the other CascadeType and their features? In which situation we choose which one?

The `cascade` attribute in JPA is used to specify the cascade operations that should be applied to the associated entities when performing certain operations on the owning entity. The `orphanRemoval` attribute, when set to `true`, indicates that any child entity that is no longer associated with the owning entity should be automatically removed from the database.

Here is an explanation of `cascade = CascadeType.ALL` and `orphanRemoval = true`, along with other `CascadeType` options and their features:

1. `CascadeType.ALL`: This cascade type applies all the available cascade operations (`PERSIST`, `MERGE`, `REMOVE`, `REFRESH`, and `DETACH`) to the associated entities. It ensures that all the related entities are persisted, updated, removed, or refreshed along with the owning entity.

2. `orphanRemoval = true`: When `orphanRemoval` is set to `true`, it allows the removal of child entities that are no longer associated with the owning entity. If a child entity is removed from the collection or disassociated from the owning entity, it will be automatically deleted from the database.

Other `CascadeType` options include:

- `CascadeType.PERSIST`: This cascade type is used to persist the associated entities when the owning entity is persisted.
- `CascadeType.MERGE`: It cascades the merge operation to the associated entities when the owning entity is merged.
- `CascadeType.REMOVE`: This cascade type applies the remove operation to the associated entities when the owning entity is removed.
- `CascadeType.REFRESH`: It cascades the refresh operation to the associated entities when the owning entity is refreshed.
- `CascadeType.DETACH`: This cascade type detaches the associated entities when the owning entity is detached.

The choice of which cascade type to use depends on the desired behavior and requirements of your application. It is important to consider the relationships between entities and determine which cascade operations should be applied to maintain data integrity and consistency. For example, if you want to automatically persist associated entities when persisting the owning entity, you can use `CascadeType.PERSIST`. If you want to cascade all operations, including removal of associated entities, you can use `CascadeType.ALL`.

### What is the fetch = FetchType.LAZY, fetch = FetchType.EAGER? what is the difference? In which situation you choose which one?

In JPA, the `fetch` attribute is used to define the fetching strategy for associations (relationships) between entities. There are two options: `FetchType.LAZY` and `FetchType.EAGER`.

1. `FetchType.LAZY`: With this strategy, the associated entities are not immediately loaded from the database when the owning entity is retrieved. Instead, they are loaded lazily, meaning they are fetched from the database only when accessed for the first time. Lazy loading can help improve performance by avoiding unnecessary database queries and loading only the necessary data when needed.

2. `FetchType.EAGER`: This strategy fetches the associated entities eagerly along with the owning entity. When the owning entity is retrieved, the associated entities are also fetched from the database immediately. Eager loading is useful when you know that the associated entities will always be needed and you want to minimize additional queries.

The choice between `FetchType.LAZY` and `FetchType.EAGER` depends on the specific requirements and usage patterns of your application. Consider the following factors when making a decision:

- Performance: If the associated entities are large or there are many of them, lazy loading can help reduce the initial loading time and memory usage. Eager loading may result in unnecessary data retrieval and increased response time.

- Navigational needs: If you frequently access the associated entities after loading the owning entity, eager loading can be more efficient, as it avoids additional round-trips to the database. Lazy loading is suitable when the associated entities are not always needed or accessed infrequently.

- Data consistency: Eager loading ensures that all the necessary data is loaded upfront, which can be important for certain operations that require the complete set of related entities. Lazy loading, on the other hand, allows you to load only the required data, potentially improving performance and reducing memory footprint.

In general, it's recommended to use lazy loading (`FetchType.LAZY`) for associations unless there is a specific need for immediate loading of associated entities (`FetchType.EAGER`).

### What is the rule of JPA naming convention? Shall we implement the method by ourselves? Could you list some examples?

The general rule for JPA naming convention is to use a combination of camel case and underscore-separated words. Here are some key conventions:

1. Entity Class Naming:
   - Use singular nouns for entity class names.
   - Capitalize the first letter of each word.
   - Use camel case for multi-word class names.

2. Table Naming:
   - Use plural nouns for table names.
   - Convert camel case to underscore-separated lowercase words.

3. Column Naming:
   - Use camel case for column names.
   - Convert camel case to underscore-separated lowercase words.

4. Relationship Naming:
   - Use the name of the related entity as the property name in the owning entity.
   - Use the name of the owning entity with "_id" suffix as the foreign key column name in the related entity.

It's important to note that JPA provides flexibility to customize the naming conventions by using annotations and explicit mappings. If the default naming conventions don't match your requirements, you can provide custom names using annotations such as `@Table`, `@Column`, `@JoinColumn`, etc. Additionally, you can implement your own naming strategies by extending JPA's `PhysicalNamingStrategy` or `ImplicitNamingStrategy` interfaces.

Examples:

1. Entity Class Naming:
```java
@Entity
public class User { ... }

@Entity
public class ProductCategory { ... }

@Entity
public class OrderItem { ... }
```

2. Table Naming:
```java
@Entity
@Table(name = "users")
public class User { ... }

@Entity
@Table(name = "product_categories")
public class ProductCategory { ... }

@Entity
@Table(name = "order_items")
public class OrderItem { ... }
```

3. Column Naming:
```java
@Entity
@Table(name = "users")
public class User {
    @Column(name = "first_name")
    private String firstName;
    
    @Column(name = "creation_date")
    private LocalDate creationDate;
    
    // ...
}
```

4. Relationship Naming:
```java
@Entity
@Table(name = "order_items")
public class OrderItem {
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;
    
    // ...
}

@Entity
@Table(name = "users")
public class User {
    @OneToMany(mappedBy = "user")
    private List<Order> orders;
    
    // ...
}
```

## Part2

### What is JPQL?

JPQL (Java Persistence Query Language) is a query language used to perform database queries in a JPA (Java Persistence API) application. It is a SQL-like language that allows developers to write database queries using entity and attribute names, rather than directly interacting with the underlying database tables and columns.

JPQL provides a platform-independent way to query and manipulate entities in an object-oriented manner. It allows developers to write queries that are agnostic to the specific database implementation, making it easier to switch between different database vendors without changing the queries.

With JPQL, developers can perform various operations such as selecting entities, filtering data, joining entities, aggregating results, and executing updates or deletes. JPQL queries are written using a syntax similar to SQL, but operate on entity objects rather than database tables.

### What is @NamedQuery and @NamedQueries?

Annotations used to define named queries that can be reused across multiple parts of an application. These annotations allow developers to define queries as part of the entity class itself, making it more organized and centralized.

- `@NamedQuery`: It is used to define a single named query for an entity. The `@NamedQuery` annotation is placed above a method in the entity class and specifies a unique name for the query, along with the JPQL query string.

Example:
```java
@Entity
@NamedQuery(name = "findUserByName", query = "SELECT u FROM User u WHERE u.name = :name")
public class User {
    // Entity fields and methods
}
```

- `@NamedQueries`: It is used to define multiple named queries for an entity. The `@NamedQueries` annotation is placed at the class level of the entity and accepts an array of `@NamedQuery` annotations.

Example:
```java
@Entity
@NamedQueries({
    @NamedQuery(name = "findUserByName", query = "SELECT u FROM User u WHERE u.name = :name"),
    @NamedQuery(name = "findUserByAge", query = "SELECT u FROM User u WHERE u.age = :age")
})
public class User {
    // Entity fields and methods
}
```

By using `@NamedQuery` and `@NamedQueries`, developers can write queries once and reuse them throughout the application, improving code maintainability and reducing redundancy. These named queries can be executed using the JPA `EntityManager` or `Query` objects.

### What is @Query? In which Interface we write the sql or JPQL?

In Spring Data JPA, `@Query` is an annotation used to define custom queries directly in repository interfaces. It allows developers to write custom SQL or JPQL (Java Persistence Query Language) queries to fetch data from the database.

The `@Query` annotation can be placed on a method in a repository interface and accepts the query string as a parameter. The query string can include named parameters that are mapped to method parameters or can use native SQL syntax.

Example using JPQL:
```java
public interface UserRepository extends JpaRepository<User, Long> {
    @Query("SELECT u FROM User u WHERE u.age > :age")
    List<User> findByAgeGreaterThan(int age);
}
```

Example using native SQL:
```java
public interface UserRepository extends JpaRepository<User, Long> {
    @Query(value = "SELECT * FROM users WHERE age > :age", nativeQuery = true)
    List<User> findByAgeGreaterThan(int age);
}
```

The `@Query` annotation provides flexibility to write complex queries that cannot be derived from method names alone. It allows developers to directly write SQL or JPQL statements and leverage advanced query capabilities.

The `@Query` annotation is used in repository interfaces, which extend the `JpaRepository` or other related interfaces provided by Spring Data JPA.

### What is HQL and Criteria Queries?

HQL (Hibernate Query Language) is an object-oriented query language provided by Hibernate, an ORM (Object-Relational Mapping) framework for Java. HQL is a powerful query language that allows developers to express database queries in terms of Java objects and their relationships, rather than writing traditional SQL queries.

With HQL, developers can write queries using familiar object-oriented syntax and work with entity classes and their properties directly. HQL queries are translated by Hibernate into the appropriate SQL statements to interact with the database.

Example of an HQL query:
```java
String hql = "FROM User u WHERE u.age > :age";
Query query = session.createQuery(hql);
query.setParameter("age", 18);
List<User> users = query.list();
```

Criteria Queries, on the other hand, provide a programmatic and type-safe way to construct queries using the Criteria API. The Criteria API allows developers to build queries dynamically using a set of predefined classes and methods. Criteria Queries are useful when the query logic needs to be built dynamically based on runtime conditions.

Example of a Criteria Query:
```java
CriteriaBuilder cb = session.getCriteriaBuilder();
CriteriaQuery<User> criteriaQuery = cb.createQuery(User.class);
Root<User> root = criteriaQuery.from(User.class);
criteriaQuery.select(root).where(cb.gt(root.get("age"), 18));
List<User> users = session.createQuery(criteriaQuery).getResultList();
```

Both HQL and Criteria Queries provide alternatives to writing raw SQL queries and offer more flexibility and type-safety when working with database queries in Hibernate. Developers can choose the approach that best suits their needs and preferences.

### What is EnityManager?

The EntityManager is an interface in JPA (Java Persistence API) that provides a set of methods to perform CRUD (Create, Read, Update, Delete) operations on entities in the database. It acts as a bridge between the application and the underlying persistence provider, allowing developers to interact with the database using entity objects.

The EntityManager is responsible for managing the lifecycle of entities, including persisting, retrieving, updating, and removing them. It handles the transaction management and provides a set of APIs to query and manipulate entities.

Example code:
```java
EntityManagerFactory emf = Persistence.createEntityManagerFactory("myPersistenceUnit");
EntityManager em = emf.createEntityManager();

// Creating and persisting a new entity
EntityTransaction tx = em.getTransaction();
tx.begin();

User user = new User();
user.setName("John Doe");
user.setEmail("john@example.com");

em.persist(user);

tx.commit();

// Retrieving an entity
User retrievedUser = em.find(User.class, 1L);

// Updating an entity
retrievedUser.setName("Jane Smith");
em.merge(retrievedUser);

// Deleting an entity
em.remove(retrievedUser);

em.close();
emf.close();
```

### What is SessionFactory and Session?

In Hibernate, the SessionFactory and Session are two important interfaces that represent the core components of the Hibernate ORM (Object-Relational Mapping) framework.

SessionFactory:
- The SessionFactory is a thread-safe, immutable, and heavyweight object responsible for creating and managing Session objects.
- It is typically created during the application startup and represents a single database connection pool.
- The SessionFactory is responsible for loading Hibernate configuration, mapping files, and creating Session instances.
- It is expensive to create, so typically, one SessionFactory is created for the entire application.

Session:
- The Session is a lightweight object that provides an interface to interact with the database.
- It represents a single unit of work or a database session.
- The Session acts as a factory for creating persistent objects, querying the database, and managing transactions.
- It wraps a JDBC connection and internally uses a transaction manager to manage database transactions.
- The Session is not thread-safe and should be used in a single-threaded manner or synchronized externally.

In summary, the SessionFactory is responsible for creating and managing the Session objects, which are used to perform database operations and manage transactions in Hibernate.

```java
// Creating SessionFactory (usually done during application startup)
SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

// Opening a new Session
Session session = sessionFactory.openSession();

try {
    // Begin transaction
    session.beginTransaction();

    // Perform database operations
    // ...

    // Commit transaction
    session.getTransaction().commit();
} catch (Exception e) {
    // Rollback transaction in case of exception
    session.getTransaction().rollback();
} finally {
    // Close the session
    session.close();
}

// Closing the SessionFactory (usually done during application shutdown)
sessionFactory.close();
```

### What is Transaction? how to manage your transaction?

A transaction is a logical unit of work that ensures the integrity and consistency of database operations. In Spring, you can manage transactions using various mechanisms:

1. Declarative Transaction Management:
   - Using `@Transactional` annotation on methods or classes.
   - Configuring transaction attributes like propagation behavior, isolation level, etc., in XML or Java-based configuration.
2. Programmatic Transaction Management:
   - Using `TransactionTemplate` to programmatically manage transactions.
   - Using `PlatformTransactionManager` to explicitly begin, commit, or rollback transactions.
3. Aspect-Oriented Transaction Management:
   - Using Spring AOP to intercept methods and apply transactional behavior using aspects.
   - Configuring aspects in XML or Java-based configuration.
4. Integration with ORM frameworks:
   - Leveraging ORM-specific transaction management mechanisms such as Hibernate's `Session`, JPA's `EntityManager`, or MyBatis's `SqlSession`.
5. Transactional boundaries:
   - Determining the scope of a transaction, whether it's at the method level, service layer, or across multiple services.

It's important to choose the appropriate transaction management approach based on the specific requirements of your application.

### What is hibernate Caching?

the mechanism that can improve application performance by reducing database access and network traffic. It involves storing frequently accessed data in memory, allowing subsequent requests for the same data to be served from the cache instead of querying the database.

Hibernate provides several levels of caching:

1. First-level Cache (Session Cache):
   - Enabled by default for each Hibernate `Session`.
   - Stores objects within the scope of a session.
   - Ensures that multiple requests for the same object within a session are served from the cache.

2. Second-level Cache:
   - Shared cache across multiple sessions.
   - Requires a cache provider implementation, such as Ehcache or Infinispan.
   - Improves performance by caching data that is accessed frequently across sessions.

3. Query Cache:
   - Stores the results of queries to avoid executing the same query multiple times.
   - Works in conjunction with the second-level cache.
   - Provides a caching mechanism for the results of named queries or queries with explicit caching instructions.

Caching can significantly improve application performance by reducing the number of database queries and the associated overhead. However, it requires careful configuration and consideration of cache eviction, expiration, and cache consistency to ensure data integrity.

### What is the difference between first-level cache and second-level cache?

First-level Cache (Session Cache):

- Bound to the Hibernate `Session` instance.
- Stores objects associated with that session.
- Exists only for the duration of a single session.
- Provides transaction-level cache isolation.
- Enables automatic dirty checking and optimistic locking.
- Enhances performance for repeated access of the same objects within a session.

Second-level Cache:

- Shared cache across multiple Hibernate `Session` instances.
- Exists independently of any specific session.
- Can be shared by multiple sessions or even multiple application instances.
- Provides a global cache for frequently accessed data across sessions.
- Requires a separate cache provider implementation (e.g., Ehcache, Infinispan).
- Improves performance by reducing database hits and network traffic.

In summary, the first-level cache is specific to a session and provides individual session-level caching, while the second-level cache is shared across multiple sessions and provides a shared, global cache for improved performance and data sharing between sessions.

### Write a simple factory design pattern

```java
public interface Session {
    void execute(String query);
}

public class DatabaseSession implements Session {
    @Override
    public void execute(String query) {
        System.out.println("Executing query in DatabaseSession: " + query);
    }
}

public class FileSession implements Session {
    @Override
    public void execute(String query) {
        System.out.println("Executing query in FileSession: " + query);
    }
}

public class SessionFactory {
    public Session createSession(String type) {
        if (type.equalsIgnoreCase("database")) {
            return new DatabaseSession();
        } else if (type.equalsIgnoreCase("file")) {
            return new FileSession();
        }
        throw new IllegalArgumentException("Invalid session type: " + type);
    }
}

public class Main {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new SessionFactory();
        
        Session databaseSession = sessionFactory.createSession("database");
        databaseSession.execute("SELECT * FROM users");
        
        Session fileSession = sessionFactory.createSession("file");
        fileSession.execute("Read data from file");
    }
}
```

In this example, we have an interface `Session` that defines the common behavior for different types of sessions. The `DatabaseSession` and `FileSession` classes implement this interface and provide specific implementations for executing queries.

The `SessionFactory` class acts as a factory and provides a method `createSession()` that creates instances of different session types based on the input. The `Main` class demonstrates how to use the factory to create and execute queries in different types of sessions.

This factory design pattern allows us to abstract the session creation process and create sessions of different types based on a common interface. It provides flexibility and allows for easy extensibility when adding new session types in the future.