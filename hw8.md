### Q1: List all of the annotations you learned from class and homework to   annotaitons.md
see `annotations.md`

### Q2: Type the Comment feature for the class project.
see `springboot-redbook-04_comment`

### Q3: In postman, call of the APIs in PostController and CommentController.

Done

### Q4: what is JPA? and what is Hibernate?

JPA stands for Java Persistence API, which is a Java specification for Object-Relational Mapping (ORM) that defines a standard for mapping Java objects to relational databases. JPA provides a set of interfaces and annotations that allow developers to define entity classes, their relationships, and how they are persisted to a database. JPA is part of the Java EE platform and is used in many Java-based enterprise applications.

Hibernate, on the other hand, is a popular open-source ORM framework that implements the JPA specification. Hibernate provides a powerful and flexible solution for mapping Java objects to relational databases and managing the persistence of those objects. Hibernate supports a wide range of database vendors and is highly configurable to meet the specific needs of an application. Hibernate also provides a number of additional features beyond the JPA specification, such as caching, lazy loading, and query optimization.

In summary, JPA is a Java specification for ORM, while Hibernate is an ORM framework that implements the JPA specification and provides additional features.

### Q5: What is Hiraki? what is the benefits of connection pool?

HikariCP is a popular high-performance JDBC connection pool for Java applications.

A connection pool is a cache of database connections that are ready for use by an application. When an application needs to access a database, it requests a connection from the pool rather than creating a new connection each time. When the application is finished using the connection, it returns it to the pool for reuse by another application request. This reduces the overhead of creating and destroying connections, which can be expensive and time-consuming.

Here are some benefits of using a connection pool, like Hikari:

1. Improved performance: Since creating and destroying database connections can be a time-consuming process, connection pooling can significantly improve the performance of database access by reducing the number of connections that need to be created.

2. Resource management: Connection pools can help manage resources by limiting the number of connections that can be created. This can prevent an application from overwhelming the database server and causing performance issues.

3. Scalability: Connection pools can help applications scale by allowing multiple connections to be used simultaneously. This allows applications to handle more requests without impacting performance.

4. Customization: Connection pools, like Hikari, offer a wide range of configuration options to customize how connections are managed. This allows developers to optimize performance and resource usage for their specific application needs.

In summary, using a connection pool like Hikari can significantly improve the performance, resource management, scalability, and customization of database access in Java applications.

### Q6: What is the @OneToMany, @ManyToOne, @ManyToMany? write some examples.

@OneToMany: Used to define a one-to-many relationship between two entities. For example, a customer can have multiple orders.
````
 @Entity
public class Customer {
   @Id
   private Long id;
   
   private String name;

   @OneToMany(mappedBy = "customer")
   private List<Order> orders;
   
   // getters and setters
}

@Entity
public class Order {
   @Id
   private Long id;

   private LocalDate orderDate;

   @ManyToOne
   @JoinColumn(name = "customer_id")
   private Customer customer;
   
   // getters and setters
}

````


@ManyToOne: Used to define a many-to-one relationship between two entities. For example, an order can have only one customer.

````
@Entity
public class Customer {
   @Id
   private Long id;
   
   private String name;

   @OneToMany(mappedBy = "customer")
   private List<Order> orders;
   
   // getters and setters
}

@Entity
public class Order {
   @Id
   private Long id;

   private LocalDate orderDate;

   @ManyToOne
   @JoinColumn(name = "customer_id")
   private Customer customer;
   
   // getters and setters
}

````

@ManyToMany: Used to define a many-to-many relationship between two entities. For example, a student can enroll in multiple courses and a course can have multiple students.
````
@Entity
public class Student {
   @Id
   private Long id;
   
   private String name;

   @ManyToMany(mappedBy = "students")
   private List<Course> courses;
   
   // getters and setters
}

@Entity
public class Course {
   @Id
   private Long id;

   private String name;

   @ManyToMany
   @JoinTable(name = "enrollment",
       joinColumns = @JoinColumn(name = "course_id"),
       inverseJoinColumns = @JoinColumn(name = "student_id"))
   private List<Student> students;
   
   // getters and setters
}

````

### Q7: What is the cascade = CascadeType.ALL, orphanRemoval = true? and what are the other CascadeType and their features? In which situation we choose which one?


In JPA, the `cascade` and `orphanRemoval` attributes are used to specify how changes made to an entity should be propagated to its related entities. Here is an explanation of these attributes and other CascadeType options:

`cascade = CascadeType.ALL`: Specifies that all entity operations (including persist, merge, remove, refresh, and detach) should be cascaded to the related entity.

`orphanRemoval = true`: Specifies that when an entity is removed from its relationship, it should also be removed from the database. This only applies to entities that are not referenced by any other entities.

`cascade = CascadeType.PERSIST`: Specifies that the `persist()` operation should be cascaded to the related entity.

`cascade = CascadeType.MERGE`: Specifies that the `merge()` operation should be cascaded to the related entity.

`cascade = CascadeType.REMOVE`: Specifies that the `remove()` operation should be cascaded to the related entity.

`cascade = CascadeType.REFRESH`: Specifies that the `refresh()` operation should be cascaded to the related entity.

`cascade = CascadeType.DETACH`: Specifies that the `detach()` operation should be cascaded to the related entity.


When choosing which CascadeType to use, you need to consider the relationships between your entities and how changes to one entity should affect the others. For example, if you have a parent entity that has a list of child entities, you may want to use `CascadeType.ALL` and `orphanRemoval = true` to ensure that all changes made to the parent and its children are propagated correctly. However, if you have a read-only relationship between entities, you may not need to use any cascading options at all. It is important to choose the appropriate CascadeType based on the specific requirements of your application.


### Q8: What is the fetch = FetchType.LAZY, fetch = FetchType.EAGER? what is the difference? In which situation you choose which one?

In JPA, `fetch` is an attribute used to specify how a related entity should be loaded from the database. There are two options for the `fetch` attribute:

1. `FetchType.LAZY`: Specifies that the related entity should be loaded lazily when it is accessed for the first time. This means that the related entity will not be loaded immediately when the parent entity is retrieved from the database.

2. `FetchType.EAGER`: Specifies that the related entity should be loaded eagerly along with the parent entity. This means that the related entity will be loaded immediately when the parent entity is retrieved from the database.

Here is an example of how to use the `fetch` attribute in JPA:

```
@Entity
public class Customer {
    @Id
    private Long id;

    @OneToMany(mappedBy = "customer", fetch = FetchType.LAZY)
    private List<Order> orders;

    // getters and setters
}
```

In this example, the `orders` attribute is marked as `FetchType.LAZY`, which means that the orders will not be loaded from the database until they are accessed for the first time.

When choosing between `FetchType.LAZY` and `FetchType.EAGER`, you need to consider the performance implications of loading related entities. If you have a large number of related entities, using `FetchType.EAGER` may result in slower performance due to the additional database queries required to load the related entities. On the other hand, if you frequently access the related entities, using `FetchType.LAZY` may result in additional database queries and slower performance due to the lazy loading mechanism.

In general, it is recommended to use `FetchType.LAZY` for related entities that are not frequently accessed and `FetchType.EAGER` for related entities that are frequently accessed. However, the appropriate choice of `fetch` attribute depends on the specific requirements of your application and should be determined through performance testing and analysis.

### Q9: What is the rule of JPA naming convention? Shall we implement the method by ourselves? Could you list some examples?

JPA has a naming convention for entities, properties, and relationships. Following this convention can help make your code more readable and easier to maintain. Here are the general rules for JPA naming convention:

1. Entity names should be singular and in TitleCase. For example, `Customer`, `Order`, `Product`.

2. Property names should be in camelCase and should describe the property's purpose. For example, `firstName`, `lastName`, `emailAddress`.

3. Relationship names should be in camelCase and should describe the relationship between the entities. For example, `orders`, `customers`, `products`.

4. Join table names should be in the form of `entity1_entity2` and should be in lowercase. For example, `customer_order`, `product_category`.

5. Foreign key column names should be in the form of `entityName_id` and should be in lowercase. For example, `customer_id`, `product_id`.

6. For composite primary keys, the entity should have a separate class to represent the composite key. The composite key class should have properties that correspond to the primary key columns, and the properties should follow the naming convention for properties.

It is not necessary to implement the JPA naming convention manually because most JPA implementations will automatically map your entities, properties, and relationships to the database. However, it is important to follow the naming convention when defining your entities and properties to ensure consistency and readability in your code.

Here are some examples of JPA entities and properties following the naming convention:

```
@Entity
@Table(name = "customers")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @OneToMany(mappedBy = "customer")
    private List<Order> orders;

    // getters and setters
}

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @ManyToMany
    @JoinTable(name = "order_product",
        joinColumns = @JoinColumn(name = "order_id"),
        inverseJoinColumns = @JoinColumn(name = "product_id"))
    private List<Product> products;

    // getters and setters
}

@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "product_name")
    private String productName;

    @ManyToMany(mappedBy = "products")
    private List<Order> orders;

    // getters and setters
}
```

In these examples, the entities and properties follow the JPA naming convention, making the code more readable and consistent.

### Q10: Try to use JPA advanced methods in your class project. In the repository layer,  you need to use the naming convention to use the method provided by JPA.

I create ```findByPostId``` methond in `springboot-redbook-04_comment` project.

see details in `springboot-redbook-04_comment`

### Q11: type the code, you need to checkout new branch from branch 02_post_RUD, name the new branch with https://github.com/TAIsRich/springboot-redbook/tree/hw05_01_slides_JPQL.

see `springboot-redbook-hw05_01_slides_JPQL`

### Q12: What is JPQL?

JPQL (Java Persistence Query Language) is a query language used to perform database operations on JPA entities. JPQL is similar to SQL, but instead of working with tables and columns, it works with JPA entities and their properties.

JPQL is independent of the database and can be used with any JPA implementation. It supports querying of objects based on their properties and relationships, allowing for more natural and intuitive querying of data.

JPQL is executed using the JPA EntityManager's `createQuery()` method, which takes a JPQL query string as input and returns a `TypedQuery` or `Query` object, depending on the query result type.

Here's an example of a simple JPQL query that selects all `Customer` entities:

```
TypedQuery<Customer> query = entityManager.createQuery("SELECT c FROM Customer c", Customer.class);
List<Customer> customers = query.getResultList();
```

In this example, the JPQL query `"SELECT c FROM Customer c"` selects all `Customer` entities and returns them as a `List<Customer>`. The `createQuery()` method takes two parameters: the JPQL query string and the result type, which in this case is `Customer.class`.

JPQL supports a wide range of query types, including SELECT, UPDATE, DELETE, and JOIN queries, as well as aggregate functions, grouping, and sorting. It also supports named parameters and positional parameters for passing values to the query.

JPQL provides a powerful and flexible way to query JPA entities, and it is a key component of JPA's data access capabilities.

### Q13: What is @NamedQuery and @NamedQueries?

`@NamedQuery` and `@NamedQueries` are annotations in JPA that are used to define named queries. Named queries are JPQL queries that are defined in the entity class and can be executed multiple times with different parameters.

The `@NamedQuery` annotation is used to define a single named query in an entity class. The annotation takes two parameters: the name of the query, and the JPQL query string.

Here's an example of a `@NamedQuery` annotation:

```
@Entity
@NamedQuery(name = "findCustomerById", query = "SELECT c FROM Customer c WHERE c.id = :id")
public class Customer {
    // ...
}
```

In this example, the `@NamedQuery` annotation defines a named query called `findCustomerById` that selects a `Customer` entity by its `id` property.

The `@NamedQueries` annotation is used to define multiple named queries in an entity class. The annotation takes an array of `@NamedQuery` annotations as its value.

Here's an example of a `@NamedQueries` annotation:

```
@Entity
@NamedQueries({
    @NamedQuery(name = "findAllCustomers", query = "SELECT c FROM Customer c"),
    @NamedQuery(name = "findCustomerByEmail", query = "SELECT c FROM Customer c WHERE c.email = :email")
})
public class Customer {
    // ...
}
```

In this example, the `@NamedQueries` annotation defines two named queries: `findAllCustomers` and `findCustomerByEmail`. Both queries are defined using `@NamedQuery` annotations, and they select all `Customer` entities and select a `Customer` entity by its `email` property, respectively.

Named queries provide a convenient way to define and reuse common queries in your application. You can execute named queries using the `EntityManager`'s `createNamedQuery()` method, which takes the name of the query and any parameters as input.

### Q14: What is @Query? In which Interface we write the sql or JPQL?


`@Query` is an annotation in Spring Data JPA that is used to define custom queries using JPQL or native SQL. It is used to annotate a method in a repository interface, and the query string is defined as the value of the annotation.

Here's an example of a `@Query` annotation that defines a JPQL query:

```
@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    @Query("SELECT c FROM Customer c WHERE c.email = :email")
    Customer findByEmail(@Param("email") String email);
}
```

In this example, the `@Query` annotation defines a JPQL query that selects a `Customer` entity by its `email` property. The `:email` parameter is a named parameter that is passed in as a method argument using the `@Param` annotation.

The query string can also be a native SQL query, in which case you can use the `nativeQuery` attribute of the `@Query` annotation to indicate that the query is a native SQL query. Here's an example:

```
@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    @Query(value = "SELECT * FROM customers WHERE email = :email", nativeQuery = true)
    Customer findByEmail(@Param("email") String email);
}
```

In this example, the `value` attribute of the `@Query` annotation contains a native SQL query that selects a `Customer` entity by its `email` property.

The custom query can be defined in any interface that extends `CrudRepository`, `PagingAndSortingRepository`, or `JpaRepository`, depending on the specific needs of your application. The interface method should be named according to Spring Data JPA's naming conventions, and the query string should be defined using the `@Query` annotation.

### Q15: What is HQL and Criteria Queries?

HQL (Hibernate Query Language) and Criteria Queries are two different ways to write queries in Hibernate.

HQL is a query language that is similar to SQL, but it operates on objects instead of tables. HQL is used to write queries against Hibernate's persistent objects and entities. HQL queries are compiled into SQL queries at runtime, so they can be database-independent.

Here's an example of an HQL query:

```
Query query = session.createQuery("FROM Customer WHERE email = :email");
query.setParameter("email", "john.doe@example.com");
List<Customer> customers = query.list();
```

In this example, the HQL query selects all `Customer` objects that have an email address of "john.doe@example.com". The query is compiled into SQL at runtime and executed against the database.

Criteria Queries are a type-safe way to write queries in Hibernate. Criteria Queries allow you to build query criteria using a set of predefined classes and methods. Criteria Queries can be used to construct queries that are both database-independent and type-safe.

Here's an example of a Criteria Query:

```
CriteriaBuilder builder = session.getCriteriaBuilder();
CriteriaQuery<Customer> query = builder.createQuery(Customer.class);
Root<Customer> root = query.from(Customer.class);
query.select(root).where(builder.equal(root.get("email"), "john.doe@example.com"));
List<Customer> customers = session.createQuery(query).getResultList();
```

In this example, the Criteria Query selects all `Customer` objects that have an email address of "john.doe@example.com". The query is constructed using the `CriteriaBuilder`, `CriteriaQuery`, and `Root` classes, and the `equal` method is used to specify the query criteria. The resulting Criteria Query is executed against the database using the `createQuery` method of the `Session` object.

Both HQL and Criteria Queries have their own advantages and disadvantages. HQL is easier to write and more flexible, but it can be less type-safe and more prone to errors. Criteria Queries are more type-safe and less error-prone, but they can be more verbose and harder to write. The choice between HQL and Criteria Queries depends on the specific needs of your application.

### Q16: What is EnityManager?

The `EntityManager` is the primary interface between Java Persistence API (JPA) and the application. It is used to manage the persistence of entities in a database.

The `EntityManager` is responsible for performing the following tasks:

1. Managing the lifecycle of entities: The `EntityManager` manages the state of entities and tracks changes to them. It can create new entities, read existing ones, update and delete them, and query the database for entities.

2. Providing transactional support: The `EntityManager` provides transactional support for operations performed on entities. It ensures that all changes to entities are made in the context of a transaction and are either committed or rolled back as a single unit.

3. Caching entities: The `EntityManager` caches entities that have been recently accessed or modified. This improves performance by reducing the number of database queries required to access or modify entities.

4. Generating queries: The `EntityManager` can generate JPQL queries based on criteria provided by the application. These queries can be executed to retrieve entities from the database.

To use the `EntityManager`, you first obtain an instance of it from a `EntityManagerFactory`. You can then use the `EntityManager` to perform operations on entities.

Here's an example of using the `EntityManager` to persist a new entity:

```
EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("my-persistence-unit");
EntityManager entityManager = entityManagerFactory.createEntityManager();
EntityTransaction transaction = entityManager.getTransaction();

try {
    transaction.begin();

    Customer customer = new Customer();
    customer.setFirstName("John");
    customer.setLastName("Doe");
    customer.setEmail("john.doe@example.com");
    entityManager.persist(customer);

    transaction.commit();
} catch (Exception e) {
    transaction.rollback();
} finally {
    entityManager.close();
}
```

In this example, a new `EntityManager` is obtained from an `EntityManagerFactory`, and a new `Customer` entity is created and persisted using the `persist` method of the `EntityManager`. The transaction is then committed, and the `EntityManager` is closed.

### Q17: What is SessionFactory and Session?

The `SessionFactory` and `Session` are two important interfaces in the Hibernate framework.

The `SessionFactory` is responsible for creating new `Session` instances, which are used to interact with the database. The `SessionFactory` is typically created at application startup and is expensive to create, so it should be created once and reused throughout the life of the application.

The `Session` is a short-lived object that represents a single unit of work with the database. It is obtained from a `SessionFactory` and is used to perform database operations, such as inserting, updating, and deleting records, querying the database for data, and managing transactions. A `Session` should be used for a single unit of work and then closed to release the underlying database connections and other resources.

Here's an example of using the `SessionFactory` and `Session` to retrieve a `Customer` entity by its ID:

```
SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
Session session = sessionFactory.openSession();
Transaction transaction = session.beginTransaction();

try {
    Customer customer = session.get(Customer.class, 1L);
    System.out.println(customer.getFirstName() + " " + customer.getLastName());
    transaction.commit();
} catch (Exception e) {
    transaction.rollback();
} finally {
    session.close();
}
```

In this example, a new `SessionFactory` is created using a `Configuration` object that is loaded from a Hibernate configuration file. A new `Session` is then obtained from the `SessionFactory`, and a new transaction is started using the `beginTransaction` method. The `get` method of the `Session` is used to retrieve a `Customer` entity with an ID of 1, and the entity's name is printed to the console. Finally, the transaction is committed or rolled back, and the `Session` is closed to release the underlying database connections and other resources.

Note that the code example above is just a basic example to demonstrate the usage of the `SessionFactory` and `Session`. In a real-world application, you should always use try-with-resources or close the `Session` and `SessionFactory` in a finally block to ensure that resources are properly released.

### Q18: What is Transaction? how to manage your transaction?

A transaction is a logical unit of work that consists of one or more database operations, such as reading, writing, or modifying data. Transactions are used to ensure data consistency and integrity, and to prevent data corruption in multi-user environments.

In a Java application, transactions are managed by the transaction manager, which is responsible for coordinating the transactional behavior of the underlying data source. The transaction manager ensures that all database operations are either committed or rolled back as a single unit of work.

To manage transactions in a Java application that uses JPA or Hibernate, you can use the `EntityManager` or `Session` objects, respectively. Both of these objects provide methods for starting, committing, and rolling back transactions.

### Q19: What is hibernate Caching?

Hibernate caching is a mechanism used to improve the performance of database operations by reducing the number of round-trips between the application and the database. Hibernate caching is implemented by storing data in memory, either in the JVM heap or in an external cache, such as Redis or Memcached.

There are three types of caching in Hibernate:

1. First-level cache: This is the default cache that Hibernate provides for every `Session` object. It stores the entity instances that have been loaded or saved in the current `Session`. The first-level cache is also known as the "session cache" or "transactional cache", because it's tied to a specific session or transaction.

2. Second-level cache: This is a shared cache that can be used across multiple `Session` objects. It's implemented by an external cache provider, such as Ehcache or Hazelcast, and it stores the entity instances that have been loaded or saved in any `Session`. The second-level cache is also known as the "global cache" or "shared cache", because it can be shared by multiple sessions or transactions.

3. Query cache: This is a cache that stores the results of a query, so that the same query can be executed again without hitting the database. The query cache is implemented by an external cache provider, and it's configured separately from the first- and second-level caches.

Hibernate caching can significantly improve the performance of database operations, especially for read-intensive applications, because it reduces the number of database round-trips and avoids the overhead of ORM mapping. However, caching can also introduce some complexity and overhead, especially for write-intensive applications, because it requires careful management of cache consistency and eviction. Therefore, caching should be used judiciously and with a good understanding of its implications.

### Q20: What is the difference between first-level cache and second-level cache?

The main difference between first-level cache and second-level cache in Hibernate is that:

- First-level cache (also known as Session cache) is a cache that is associated with a single Hibernate `Session`. The first-level cache stores the persistent objects (entities) that are retrieved or saved by the current `Session`. It is enabled by default and there is no way to disable it. It is a transaction-scoped cache, which means that the cache is cleared when the current transaction is committed or rolled back.

- Second-level cache (also known as SessionFactory cache) is a cache that is shared across multiple Hibernate `Session` instances. The second-level cache stores the persistent objects that are retrieved or saved by any `Session`. It is not enabled by default and it requires explicit configuration. It is a session-scoped cache, which means that the cache is cleared when the current `SessionFactory` is closed.

The first-level cache is optimized for reducing the number of database queries within a single `Session`, while the second-level cache is optimized for reducing the number of database queries across multiple `Session` instances. The first-level cache is usually smaller and faster than the second-level cache, but it has limited scope and lifetime. The second-level cache is usually larger and slower than the first-level cache, but it can be shared across multiple `Session` instances and it has a longer lifetime.

In summary, the first-level cache is a short-lived cache that is associated with a single `Session`, while the second-level cache is a long-lived cache that is shared across multiple `Session` instances.

### Q21: How do you understand @Transactional? (不要clone，要自己抄写并测试  transactional，https://github.com/TAIsRich/tutorial-transaction)

see `tutorial-transaction-main`

### Q22: Write a simple factory design pattern.

see `MavenProject`
