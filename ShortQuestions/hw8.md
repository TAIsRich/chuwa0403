# List all of the annotations you learned from class and homework to annotaitons.md
See annotations.md
# Type the Comment feature for the class project.
# In postman, call of the APIs in PostController and CommentController.
# what is JPA? and what is Hibernate?
`JPA (Java Persistence API)` is a Java specification for Object-Relational Mapping (ORM) that allows developers to map Java objects to relational database tables using annotations or XML configurations. JPA provides a standard way for developers to interact with relational databases from within their Java applications, and it allows for vendor-independent persistence solutions.

`Hibernate` is an open source object-relational mapping framework. It encapsulates JDBC with a very lightweight object. It establishes a mapping relationship between POJO and database tables. It is a fully automatic ORM framework. Hibernate can automatically generate SQL statements. Automatic execution allows Java programmers to use object programming thinking to manipulate the database as they wish.
# What is Hiraki? what is the benefits of connection pool?
`Hikari` is the default DataSource implementation with Spring Boot 2. This means we need not add explicit dependency in the pom. xml. The spring-boot-starter-jdbc and spring-boot-starter-data-jpa resolve it by default. To sum up, you require no other steps with Spring Boot 2.

Connection pool can improbe performace, reduce resource usage, improve application reliability and provide a better conneciton management.
# What is the @OneToMany, @ManyToOne, @ManyToMany? write some examples.
- `@OneToMany`
```
@Entity
public class Customer {

    @OneToMany(mappedBy = "customer")
    private List<Order> orders;

}

@Entity
public class Order {

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

}
```
- `ManyToOne`
```
@Entity
public class Book {

    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author author;

}

@Entity
public class Author {

    @OneToMany(mappedBy = "author")
    private List<Book> books;

}
```
- `@ManyToMany`
```
@Entity
public class Student {

    @ManyToMany(mappedBy = "students")
    private List<Course> courses;

}

@Entity
public class Course {

    @ManyToMany
    @JoinTable(name = "student_course",
               joinColumns = @JoinColumn(name = "course_id"),
               inverseJoinColumns = @JoinColumn(name = "student_id"))
    private List<Student> students;

}
```
# What is the cascade = CascadeType.ALL, orphanRemoval = true? and what are the other CascadeType and their features? In which situation we choose which one?
`CascadeType.ALL` This cascade type is used to specify that all changes (i.e., inserts, updates, and deletes) made to the parent entity should also be applied to its associated child entities.

`orphanRemoval=true`: This attribute is used to specify that child entities that are no longer associated with a parent entity should be removed from the database. This is useful in situations where child entities cannot exist independently of their parent entity.

Here are some other CascadeType:
- `CascadeType.PERSIST`: This cascade type is used to specify that when a new parent entity is persisted, its associated child entities should also be persisted.

- `CascadeType.MERGE`: This cascade type is used to specify that when a detached parent entity is merged with a managed entity, its associated child entities should also be merged.

- `CascadeType.REMOVE`: This cascade type is used to specify that when a parent entity is deleted, its associated child entities should also be deleted.

- `CascadeType.REFRESH`: This cascade type is used to specify that when a parent entity is refreshed, its associated child entities should also be refreshed.

- `CascadeType.DETACH`: This cascade type is used to specify that when a parent entity is detached, its associated child entities should also be detached.
# What is the fetch = FetchType.LAZY, fetch = FetchType.EAGER? what is the difference? In which situation you choose which one?
`fetch = FetchType.LAZY` Lazy loading means that the associated entities are not loaded until they are accessed via a method call.
`fetch = FetchType.EAGER` Eager loading means that the associated entities are loaded along with the parent entity, which can result in a performance overhead if the associated entities are not actually needed.
# What is the rule of JPA naming convention? Shall we implement the method by ourselves? Could you list some examples?
- Entity classes should be named in singular form, with the first letter of each word capitalized.
- Entity class fields should be named in camelCase, with the first letter of the first word in lowercase.
- Primary key fields should be named id, and should be of a numeric type such as Long or Integer.
- Foreign key fields should be named according to the name of the relationship and the name of the target entity's primary key field.
Some examples:
- `findByLastnameAndFirstName(a,b)`
- `findByLastnameOrFirstName(a,b)`
- `findByStartDateBetween(a,b)`
- `findByAgelsNull`
- `findByAgeOrderByLastNameDesc(a)`
- `findByActiveTrue`
- `deleteAll()`
- `deleteById(ID id)`
- `existById(ID id)`
# What is JPQL?
JPQL is a query language that allows developers to execute database queries using object-oriented syntax, without being tied to any specific database management system (DBMS). 
# What is @NamedQuery and @NamedQueries?
`@NamedQuery` is used to define a named query in a JPA entity class.

`@NamedQueries` allows developers to define multiple named queries in a single entity class.
# What is @Query? In which Interface we write the sql or JPQL?
`@Query` is a JPA annotation that allows developers to define custom SQL or JPQL queries to be executed by JPA. It can be used to execute complex queries that cannot be expressed using JPA's query methods or named queries.

We write sql od JPQL in JPA repository interface.
# What is HQL and Criteria Queries?
HQL (Hibernate Query Language) is an object-oriented query language and it can be used to query Hibernate-managed entities in a way that is independent of the underlying database. 

Criteria queries are an alternative to HQL for querying Hibernate-managed entities. Criteria queries are object-oriented, type-safe, and allow developers to build queries using a fluent API. Criteria queries can be used to express complex queries that would be difficult to express using HQL or JPQL.
# What is EnityManager?
The EntityManager is a core interface in the Java Persistence API (JPA) that provides an abstraction layer over the underlying database. It is responsible for managing the lifecycle of entities, which are Java objects that represent database records, as well as for performing database operations such as inserting, updating, and deleting data.
# What is SessionFactory and Session?
`SessionFactory` is responsible for creating and configuring Session instances, which are used to interact with the database. 

`Session` interface is typically obtained from the SessionFactory, and it represents a single unit of work with the database. Once a Session is obtained, it can be used to manage entities, query the database, and perform various other operations.
# What is Transaction? how to manage your transaction?
Transaction is a set of related database operations that are executed as a single unit of work, with the guarantee that either all of the operations will succeed, or none of them will be applied to the database.

We can use the `@Transactional` annotation to mark a method as transactional. This annotation ensures that the method is executed within a transaction and that the transaction is either committed or rolled back at the end of the method.
# What is hibernate Caching?
Hibernate caching is a mechanism that allows Hibernate to store frequently accessed data in memory, reducing the number of database queries needed to retrieve that data. This can improve application performance by reducing the amount of time spent waiting for data to be retrieved from the database.
# What is the difference between first-level cache and second-level cache?
The first-level cache is limited to the scope of a single session, the second-level cache can improve performance across the entire application by reducing the number of queries issued to the database. 
