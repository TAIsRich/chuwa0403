# HW8

Claudia Feng

Part 1

1. List all of the annotations you learned from class and homework to annotaitons.md

   

2. Type the Comment feature for the class project.

   

3. In postman, call of the APIs in PostController and CommentController.

   

4. what is JPA? and what is Hibernate?

   JPA (Java Persistence API) is a specification or a set of guidelines for managing the persistence of Java objects in a relational database. It is a part of the Java EE framework and provides a standardized way to map Java objects to database tables, perform CRUD operations, and manage transactions. JPA allows developers to work with an object-oriented model while abstracting the underlying database details, making it easier to switch between different database systems.

   Hibernate is a popular open-source Object-Relational Mapping framework for Java that provides an implementation of the JPA specification. It allows Java developers to map Java objects to relational database tables and perform database operations using Java code, rather than writing SQL queries directly. Hibernate simplifies the development process by automating many common tasks related to database persistence, such as caching, transaction management, and connection pooling. In addition to JPA, Hibernate also offers its own native API and additional features that go beyond the JPA specification, such as a powerful query language called HQL (Hibernate Query Language).

   

5. What is Hiraki? what is the benefits of connection pool?

   HikariCP (commonly referred to as Hikari) is a high-performance, lightweight, and reliable JDBC (Java Database Connectivity) connection pool implementation for Java applications. It is designed to handle connections between a Java application and a relational database, and it's known for its fast and efficient performance. HikariCP optimizes connection management by minimizing lock contention, using efficient data structures, and offering configuration options that allow developers to fine-tune its behavior.

   Connection pooling is a technique used to manage and reuse database connections to improve application performance and reduce resource usage. The main benefits of connection pooling are:

   1. Improved performance: Establishing a new connection to a database can be a time-consuming process. Connection pools maintain a set of active connections that can be quickly reused by the application, reducing the overhead of establishing new connections for each request.

   2. Efficient resource usage: Opening a large number of connections can consume significant system resources (memory, CPU, and network bandwidth). Connection pooling helps to limit the number of open connections, reducing resource consumption and helping to prevent system overload.

   3. Simplified connection management: Connection pools handle the lifecycle of connections, including opening, closing, and recycling them. This abstracts away connection management details from the application code, simplifying development and reducing the likelihood of connection leaks.

   4. Load balancing and failover: Some connection pool implementations, like HikariCP, can distribute connections across multiple database instances, providing load balancing and failover capabilities. This can help to distribute workload evenly across database servers and improve application reliability.

   5. Configurable behavior: Connection pools often provide configuration options that allow developers to fine-tune connection management according to the specific needs of their application, such as setting connection timeouts, maximum and minimum pool sizes, and idle connection management.

      

6. What is the @OneToMany, @ManyToOne, @ManyToMany? write some examples.

   `@OneToMany`, `@ManyToOne`, and `@ManyToMany` are JPA (Java Persistence API) annotations used to define relationships between entities in an object-relational mapping context. They help map the associations between Java objects and database tables, allowing developers to work with complex object models more easily.

   1. `@OneToMany`: This annotation represents a one-to-many relationship between two entities, where one entity has a collection of the other entity. For example, consider a `Department` entity that has many `Employee` entities:

   ```java
   @Entity
   public class Department {
       @Id
       @GeneratedValue(strategy = GenerationType.AUTO)
       private Long id;
       private String name;
   
       @OneToMany(mappedBy = "department", cascade = CascadeType.ALL)
       private List<Employee> employees;
   }
   
   @Entity
   public class Employee {
       @Id
       @GeneratedValue(strategy = GenerationType.AUTO)
       private Long id;
       private String name;
   
       @ManyToOne
       @JoinColumn(name = "department_id")
       private Department department;
   }
   
   ```

   2. `@ManyToOne`: This annotation represents a many-to-one relationship between two entities, where multiple instances of one entity are associated with a single instance of the other entity. In the example above, the `Employee` entity has a `@ManyToOne` relationship with the `Department` entity.

   3. `@ManyToMany`: This annotation represents a many-to-many relationship between two entities, where multiple instances of one entity are associated with multiple instances of the other entity. An example would be a `Student` entity and a `Course` entity, where a student can be enrolled in multiple courses, and a course can have multiple students:

   ```java
   @Entity
   public class Student {
       @Id
       @GeneratedValue(strategy = GenerationType.AUTO)
       private Long id;
       private String name;
   
       @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
       @JoinTable(name = "student_course",
                  joinColumns = @JoinColumn(name = "student_id"),
                  inverseJoinColumns = @JoinColumn(name = "course_id"))
       private Set<Course> courses;
   }
   
   @Entity
   public class Course {
       @Id
       @GeneratedValue(strategy = GenerationType.AUTO)
       private Long id;
       private String name;
   
       @ManyToMany(mappedBy = "courses")
       private Set<Student> students;
   }
   
   ```

   

7. What is the cascade = CascadeType.ALL, orphanRemoval = true? and what are the other CascadeType and their features? In which situation we choose which one?

   1. `cascade = CascadeType.ALL`: The `cascade` attribute of a JPA relationship annotation specifies the operations that should be propagated (cascaded) from the parent entity to the associated child entities. `CascadeType.ALL` means that all operations (persist, merge, remove, refresh, and detach) will be cascaded from the parent to the child entities. This is useful when you want to perform an operation on a parent entity and have the same operation automatically applied to its associated child entities.
   2. `orphanRemoval = true`: This attribute is used in `@OneToMany` and `@OneToOne` relationships to specify that child entities that are no longer associated with a parent entity should be automatically removed from the database. This helps to maintain data integrity and prevents orphaned records.

   There are five `CascadeType` options available in JPA:

   1. `CascadeType.PERSIST`: When persisting a parent entity, the associated child entities will also be persisted.
   2. `CascadeType.MERGE`: When merging a detached parent entity, the associated detached child entities will also be merged.
   3. `CascadeType.REMOVE`: When removing a parent entity, the associated child entities will also be removed.
   4. `CascadeType.REFRESH`: When refreshing a parent entity, the associated child entities will also be refreshed.
   5. `CascadeType.DETACH`: When detaching a parent entity, the associated child entities will also be detached.
   6. `CascadeType.ALL`: A combination of all the above cascade types (persist, merge, remove, refresh, and detach).

   Choosing the appropriate CascadeType depends on the specific requirements of your application and the desired behavior of the entity relationships. Some common scenarios include:

   - Use `CascadeType.PERSIST` when you want to persist child entities along with the parent entity. For example, when adding a new order and its order items to the database, you can persist the order and cascade the persist operation to the order items.

   - Use `CascadeType.REMOVE` when you want to delete child entities when the parent entity is deleted. For example, when deleting a blog post, you may want to delete all associated comments.

   - Use `CascadeType.MERGE` when you want to update child entities when the parent entity is updated. For example, when updating a customer's address, you may want to update the associated orders' shipping addresses as well.

   - Use `CascadeType.ALL` when you want all persistence operations to be propagated from the parent to the child entities. This can be useful when managing complex object graphs where multiple entities are interconnected, and you want to apply the same operations to all related entities.

     

8. What is the fetch = FetchType.LAZY, fetch = FetchType.EAGER? what is the difference? In which situation you choose which one?

   1. `FetchType.LAZY`: Lazy fetching means that the related entities will not be loaded from the database when the parent entity is retrieved. Instead, they will only be loaded when explicitly accessed for the first time. Lazy fetching is beneficial for performance, as it avoids loading unnecessary data, especially when dealing with large collections or complex object graphs. This is the default fetching strategy for `@OneToMany` and `@ManyToMany` relationships.

      Use `FetchType.LAZY` when you want to optimize performance and minimize the amount of data loaded from the database. This is a good choice when you don't always need the related entities or when working with large collections or complex object graphs.

   2. `FetchType.EAGER`: Eager fetching means that the related entities will be loaded from the database at the same time as the parent entity. This can be useful when you know that the related entities will be accessed frequently or when dealing with small datasets. However, it can lead to performance issues if used indiscriminately, as it may result in loading a large amount of unnecessary data. Eager fetching is the default strategy for `@OneToOne` and `@ManyToOne` relationships.

      Use `FetchType.EAGER` when you know that the related entities will be accessed frequently, or when dealing with small datasets where performance is not a concern. This can help to reduce the number of database queries and simplify application code by ensuring that related entities are always available when needed.

   

9. What is the rule of JPA naming convention? Shall we implement the method by ourselves? Could you list some examples?

   1. Entity Naming Conventions:
      - Use PascalCase for entity class names, e.g., `Employee`, `Department`.
      - Entity class names should be singular nouns.
      - Annotate entity classes with `@Entity`.
      - By default, JPA maps the entity class name to a database table with the same name. If you want to specify a different table name, use the `@Table` annotation with the `name` attribute, e.g., `@Table(name = "employees")`.
   2. Attribute Naming Conventions:
      - Use camelCase for attribute names, e.g., `firstName`, `lastName`.
      - Attribute names should be singular nouns.
      - By default, JPA maps attribute names to database column names using the same name. If you want to specify a different column name, use the `@Column` annotation with the `name` attribute, e.g., `@Column(name = "first_name")`.
   3. Relationship Naming Conventions:
      - Use camelCase for relationship attributes.
      - Name the relationship attributes according to the related entity, e.g., `department` for a `Department` entity, `employees` for a collection of `Employee` entities.
      - Annotate relationship attributes with the appropriate relationship annotations, such as `@OneToOne`, `@OneToMany`, `@ManyToOne`, or `@ManyToMany`.

   Some examples of repository method naming conventions:

   - `findBy<AttributeName>`: Find entities by a specific attribute, e.g., `findByFirstName(String firstName)`.

   - `findBy<AttributeName>And<AnotherAttributeName>`: Find entities by multiple attributes, e.g., `findByFirstNameAndLastName(String firstName, String lastName)`.

   - `findBy<RelationshipAttributeName>_<RelatedEntityAttributeName>`: Find entities by an attribute of a related entity, e.g., `findByDepartment_Name(String departmentName)`.

   - `countBy<AttributeName>`: Count entities by a specific attribute, e.g., `countByLastName(String lastName)`.

     

10. Try to use JPA advanced methods in your class project. In the repository layer, you need to use the naming convention to use the method provided by JPA.

    

11. (Optional) Check out a new branch(https://github.com/TAIsRich/springboot-redbook/tree/hw02_01_jdbcTemplate) from branch 02_post_RUD, replace the dao layer using JdbcTemplate.

    

12. (Optional) use JDBC to read the data from database.



Part 2

1. List all of the annotations you learned from class and homework to annotaitons.md

   

2. type the code, you need to checkout new branch from branch **02_post_RUD**, name the new branch with **https://github.com/TAIsRich/springboot-redbook/tree/hw05_01_slides_JPQL**.

   

3. What is JPQL?

   JPQL (Java Persistence Query Language) is a platform-independent query language defined by the Java Persistence API (JPA) specification. It provides a way to query and retrieve data from relational databases using an object-oriented approach, rather than using SQL directly. 

   JPQL queries are similar in syntax to SQL, but instead of operating on database tables and columns, they operate on entity classes and their attributes. 

   

4. What is @NamedQuery and @NamedQueries?

   `@NamedQuery` and `@NamedQueries` are annotations in JPA (Java Persistence API) used to define reusable, static JPQL (Java Persistence Query Language) queries. They allow you to create and store queries with a specific name, which can then be invoked in your application code by referring to that name.

   

5. What is @Query? In which Interface we write the sql or JPQL?

   `@Query` is an annotation used in JPA-based applications, such as those using Spring Data JPA, to define custom queries directly on repository methods. The `@Query` annotation allows you to write JPQL (Java Persistence Query Language) or native SQL queries for a specific method, providing a more flexible way to perform complex or custom database operations that might not be possible or efficient using the standard JPA repository method naming conventions.

   You typically use the `@Query` annotation on methods within a repository interface that extends a JPA repository, such as `JpaRepository`, `CrudRepository`, or `PagingAndSortingRepository`. By adding the `@Query` annotation to a method in the repository interface, you can define the query to be executed when that method is called.

   

6. What is HQL and Criteria Queries?

   HQL (Hibernate Query Language) and Criteria Queries are two query methods provided by Hibernate. They enable you to perform queries on your database using an object-oriented approach, abstracting the underlying database schema and SQL.

   

7. What is EnityManager?

   `EntityManager` is a core interface in the Java Persistence API (JPA) that provides methods for managing and interacting with persistent entities in a Java application. It is responsible for managing the lifecycle of entities, including operations such as persisting, updating, deleting, and retrieving entities from the database. `EntityManager` also plays a crucial role in managing transactions, querying, and caching within the context of a JPA persistence unit.

   

8. What is SessionFactory and Session?

   1. `SessionFactory`: This interface is responsible for creating and managing `Session` instances in a Hibernate application. A `SessionFactory` is typically created during the application's startup, using the Hibernate configuration (either from an XML file or programmatically). The configuration defines the database connection settings, mapping files or annotated classes, and various other Hibernate properties.

   2. `Session`: This interface is responsible for managing the lifecycle of entities and performing database operations, such as persisting, updating, deleting, and retrieving entities. A `Session` also plays a crucial role in managing transactions, querying, and caching within the context of a Hibernate persistence unit.

      

9. What is Transaction? how to manage your transaction?

   A transaction is a sequence of one or more operations that are executed as a single unit of work to ensure data consistency and integrity in a database. Transactions follow the ACID properties (Atomicity, Consistency, Isolation, and Durability) to guarantee that the database remains in a consistent state even if some operations fail or multiple transactions are executed concurrently.

   Managing transactions in a Java application usually involves the following steps:

   1. Begin the transaction: Start a new transaction by marking the beginning of the operations that need to be executed as a single unit of work.

   2. Perform the operations: Execute the database operations, such as creating, updating, deleting, or querying records, within the scope of the transaction.

   3. Commit or rollback the transaction: If all the operations are successful, commit the transaction to permanently save the changes to the database. If any operation fails or an error occurs, rollback the transaction to undo the changes and maintain the database's consistent state.

      

10. What is hibernate Caching?

    Hibernate caching is a technique used in Hibernate, a popular Java-based ORM (Object-Relational Mapping) framework, to improve the performance of database operations by reducing the number of round trips to the database. Hibernate provides two levels of caching: first-level cache and second-level cache.

    

11. What is the difference between first-level cache and second-level cache?

    1. First-level cache (Session cache): The first-level cache is associated with the Hibernate `Session` and is enabled by default. It stores the entities that have been loaded or persisted within the scope of the current `Session`. When an entity is requested from the `Session`, Hibernate first checks the first-level cache. If the entity is present in the cache, it is returned directly, avoiding a database query. However, if the entity is not found in the cache, Hibernate performs a query to retrieve the entity from the database.

    The first-level cache is primarily meant to optimize the performance of database operations within a single `Session`. Since the cache is tied to the `Session`, its lifespan is limited to the duration of the `Session`. When the `Session` is closed or cleared, the cache is also cleared.

    2. Second-level cache (SessionFactory cache): The second-level cache is associated with the Hibernate `SessionFactory` and is an optional feature that needs to be explicitly configured. It is designed to cache entities across multiple `Session`s and is shared by all `Session`s created by the same `SessionFactory`. The second-level cache is useful for caching read-heavy, immutable, or infrequently changing data that can be reused across different transactions and application requests.

       

12. How do you understand @Transactional? (不要clone，要自己抄写并测试 transactional，https://github.com/TAIsRich/tutorial-transaction)

    

13. Write a simple factory design pattern.

