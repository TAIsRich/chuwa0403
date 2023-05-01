
# hw8.1

## 1. List all of the annotations you learned from class and homework to annotaitons.md

Check ShortQuetions/annotations.md

## 2. Type the Comment feature for the class project.

Check MavenProject/hw8

## 3. In postman, call of the APIs in PostController and CommentController.

Done

## 4. what is JPA? and what is Hibernate?

JPA stands for Java Persistence API, which is a standard interface for managing relational data in Java applications. It provides a set of interfaces and annotations for defining object-relational mappings and querying databases using object-oriented criteria.

Hibernate is a popular implementation of JPA and provides additional features on top of JPA, such as caching, lazy loading, and interceptors. It is a powerful and flexible ORM (Object-Relational Mapping) framework that simplifies the development of Java applications that need to interact with a relational database. Hibernate also provides a high level of abstraction from the underlying database, making it easier to develop database-independent applications.

## 5. What is Hiraki? what is the benefits of connection pool?

Hikari is a lightweight connection pool for Java apps that efficiently manages database connections. It reduces the overhead and latency involved in creating new connections for each request. By creating and managing a set of pre-initialized connections, Hikari assigns and releases connections as needed, reusing them instead of creating new ones for each request. This improves application performance and reduces the load on the database server.

*benifits*

**Improved performance:** Reusing connections from the pool can reduce the overhead of establishing new connections, leading to faster database access and improved application performance.

**Resource efficiency:** A connection pool can ensure that database connections are used efficiently, avoiding resource contention and reducing the load on the database server.

**Scalability:** Connection pools can support a large number of concurrent connections, allowing applications to scale to handle high levels of traffic.

**Connection management:** A connection pool can manage connection errors and provide configurable timeout settings, allowing applications to handle connection issues gracefully.

## 6. What is the @OneToMany, @ManyToOne, @ManyToMany? write some examples.


**@ManyToOne and @JoinColumn** 

@ManyToOne is used to define a many-to-one relationship between two entities, where multiple instances of one entity can be associated with a single instance of another entity. 


For example, suppose there are two entity classes: Order and Customer. An order can only belong to one customer, but a customer can have multiple orders. In the Order entity class, @ManyToOne annotation can be used to establish a many-to-one relationship with the Customer entity class:

```java
@Entity
public class Order {
  @Id
  private Long id;
  
  // other fields
  
  @ManyToOne
  private Customer customer;
  
  // getters and setters
}
```

This tells the JPA framework that there is a many-to-one relationship between the Order entity class and the Customer entity class in the database table, which means that multiple Order records can correspond to one Customer record.

@JoinColumn is used to define the column used for the association between entities. When used in combination with @ManyToOne, it specifies the foreign key column in the owning entity that references the primary key of the related entity.

```java
@Entity
public class Order {
  @Id
  private Long id;
  
  // other fields
  
  @ManyToOne
  @JoinColumn(name = "customer_id")
  private Customer customer;
  
  // getters and setters
}
```

In this example, @JoinColumn annotation is used to specify the name of the foreign key column. This will create a column named "customer_id" in the database to establish the many-to-one relationship between the Order and Customer entity classes.

**@OneToMany**

@OneToMany is a Java annotation used in Object-Relational Mapping (ORM) frameworks, such as Hibernate or JPA (Java Persistence API). It is used to define a one-to-many relationship between two entities in a database schema.

In a one-to-many relationship, one instance of an entity (the "one" side) can be associated with multiple instances of another entity (the "many" side"). For example, a customer can have multiple orders, or a university can have multiple students.

Using @OneToMany, we can annotate a field in an entity class that represents the "many" side of the relationship. This field typically holds a collection (e.g. a List or a Set) of instances of the other entity.

```java
@Entity
public class Customer {
 
    @OneToMany(mappedBy = "customer")
    private List<Order> orders;
 
    // other fields and methods
}
```
**@ManyToMany** 

@ManyToMany is a JPA annotation used to define a many-to-many relationship between two entities. In a many-to-many relationship, an instance of one entity can be related to multiple instances of another entity, and vice versa.

In JPA, a many-to-many relationship is implemented using an intermediary table that holds the foreign keys of both entities. The @ManyToMany annotation is typically used to define this intermediary table and the relationships between the entities.

**@JoinTable**

@JoinTable is a JPA annotation used in object-relational mapping to define the association between two entities in a many-to-many relationship. It is used to join the tables of the two entities that have a many-to-many relationship.

```java
/**
* sku和inventory是M:N的关系
* 仓库ID，表示可以下单到哪些仓库
*/
@ManyToMany(fetch = FetchType.LAZY)
@JoinTable(name = "sku_inventory",
joinColumns = @JoinColumn(name = "sku_id"),
inverseJoinColumns = @JoinColumn(name =
"inventory_id"))
private Set<PmsInventory> pmsInventories = new HashSet<>();

```

## 7. What is the cascade = CascadeType.ALL, orphanRemoval = true? and what are the other CascadeType and their features? In which situation we choose which one?

The CascadeType.ALL means that all operations (persist, merge, remove, refresh) made on the parent entity will be cascaded to its related entities. The orphanRemoval = true means that if an entity is removed from the collection of related entities, it will be deleted from the database as well.

Other CascadeType options include:

**CascadeType.PERSIST:** when the parent entity is persisted, the related entities will also be persisted

**CascadeType.MERGE:** when the parent entity is merged, the related entities will also be merged

**CascadeType.REMOVE:** when the parent entity is deleted, the related entities will also be deleted

**CascadeType.REFRESH:** when the parent entity is refreshed, the related entities will also be refreshed

**CascadeType.DETACH:** when the parent entity is detached, the related entities will also be detached

## 8. What is the fetch = FetchType.LAZY, fetch = FetchType.EAGER? what is the
difference? In which situation you choose which one?

FetchType.EAGER, on the other hand, specifies that the associated entities should be fetched eagerly, which means that they will be loaded from the database immediately when the main entity is loaded. This can be useful when you know that you will always need the associated entities and want to avoid additional database queries.



FetchType.LAZY specifies that the associated entities should be fetched lazily, which means that they will only be loaded from the database when they are accessed for the first time. This can be beneficial for performance, as it avoids loading unnecessary data from the database.

FetchType.EAGER, on the other hand, specifies that the associated entities should be fetched eagerly, which means that they will be loaded from the database immediately when the main entity is loaded. This can be useful when you know that you will always need the associated entities and want to avoid additional database queries.

## 9.What is the rule of JPA naming convention? Shall we implement the method by ourselves? Could you list some examples?

The JPA naming convention refers to the naming conventions for defining entity classes, tables, properties, and other entities in JPA. Naming according to conventions can improve the readability and maintainability of code, and following naming conventions can facilitate JPA's automatic generation of SQL and query statements based on naming, reducing the amount of manually written code. Generally, JPA naming conventions include provisions for entity classes, tables, properties, and queries.

We don't need to implement the method by ourselves.

```java
public interface CommentRepository extends JpaRepository<Comment,Long> {
    List<Comment> findByPostId(long postId);
}

```

## 10. Try to use JPA advanced methods in your class project. In the repository layer,you need to use the naming convention to use the method provided by JPA.

Check MavenProject/hw8



# hw8.2

## 1. List all of the annotations you learned from class and homework to annotaitons.md

Check ShortQuetions/annotations.md

## 2. type the code, you need to checkout new branch from branch 02_post_RUD

Check MavenProject/hw8

## 3. What is JPQL?

JPQL stands for Java Persistence Query Language. It is a query language used to perform database operations on Java objects, particularly those managed by JPA. JPQL is similar to SQL in terms of syntax and structure but operates on Java objects rather than database tables. It allows developers to write database queries in a platform-independent manner, which can then be executed on various databases using JPA. JPQL is particularly useful in situations where complex queries are required that cannot be easily expressed using JPA's built-in methods.

## 4. What is @NamedQuery and @NamedQueries?

In JPA, @NamedQuery and @NamedQueries are used to define pre-defined JPQL queries that can be executed multiple times with different parameter values.

@NamedQuery is used to define a single JPQL query that can be executed by its name.
```java
@NamedQuery(name = "findAllEmployees", query = "SELECT e FROM Employee e")

```

@NamedQueries is used to define multiple named JPQL queries that can be executed by their respective names.
```java
@NamedQueries({
    @NamedQuery(name = "findAllEmployees", query = "SELECT e FROM Employee e"),
    @NamedQuery(name = "findEmployeesByDepartment", query = "SELECT e FROM Employee e WHERE e.department = :department")
})

```

## 5. What is @Query? In which Interface we write the sql or JPQL?

@Query is a JPA annotation that is used to define custom SQL or JPQL (Java Persistence Query Language) queries directly in a Spring Data repository method. It allows developers to write complex queries that cannot be achieved with the standard JPA methods.In an interface that extends JpaRepository, @Query can be added to a method to specify a custom JPQL or SQL query. 

```java
   @Query("select p from Post p where p.id = ?1 or p.title = ?2")
    Post getPostByIDOrTileWithJPQLIndexParameters(Long id, String title);

    @Query("select P from Post p where p.id = :key or p.title = :title ")
    Post getPostByIDOrTileWithJPQLNamedParameters(@Param("key") Long id,
                                                @Param("title") String title);


    @Query(value = "select * from posts p where p.id = ?1 or p.title = ?2 p.update_date_time",nativeQuery = true)
    Post getPostByIDOrTileWithSQLIndexParameters(Long id, String title);

    @Query(value = "select * from posts p where p.id = :key or p.title = :title ",nativeQuery = true)
    Post getPostByIDOrTileWithSQLNamedParameters(@Param("key") Long id,
                                                  @Param("title") String title);
```

## 6. What is HQL and Criteria Queries?

HQL (Hibernate Query Language) is a query language provided by Hibernate that allows developers to write database-independent queries for data retrieval. HQL is similar to SQL but uses object-oriented terms instead of table names and columns.

Criteria Queries is a programmatic way of building queries using Hibernate's Criteria API. This API provides a type-safe, object-oriented approach to building queries, making it easier to maintain and modify the code.

Example of HQL:
```java
String hql = "FROM Employee WHERE department = :deptName";
Query query = session.createQuery(hql);
query.setParameter("deptName", "Sales");
List<Employee> employees = query.list();
```

## 7. What is EnityManager?

The EntityManager is a core interface in the JPA API that is responsible for managing the lifecycle of entity instances in the persistence context. It provides methods for querying the database, persisting and removing entities, and managing transactions.

## 8. What is SessionFactory and Session?

SessionFactory and Session are classes in Hibernate, a popular Object-Relational Mapping (ORM) framework for Java.

**SessionFactory**is a factory class that creates Session objects, which are used to communicate with the database. It is typically created only once during application startup and is thread-safe, allowing multiple threads to use the same instance.

**Session** is an interface that provides an API for managing database operations, such as creating, updating, deleting, and querying records. It is a lightweight object that is created and destroyed for each transaction or conversation between the application and the database.

## 9. What is Transaction? how to manage your transaction?

In the context of databases, a transaction is a series of operations performed as a single unit of work that must be executed in its entirety or not at all. In other words, if one operation in the transaction fails, the entire transaction must be rolled back to its previous state, leaving the database in its original state.

There are several ways to manage transactions in JPA, including programmatic transaction management and declarative transaction management. In programmatic transaction management, the developer manually manages the transaction by using the EntityManager.getTransaction() method to start a transaction, and then calling the commit() or rollback() methods as needed. In declarative transaction management, the transaction is managed by the container or framework, based on annotations or configuration files.
```java
@Service
public class MyService {
    
    @Autowired
    private MyRepository repository;

    @Transactional
    public void saveData(MyData data) {
        // perform some database operations using repository methods
        repository.save(data);
        // other database operations
    }
}

```

## 10. What is hibernate Caching?

Hibernate caching is a mechanism that allows frequently accessed data to be stored temporarily in memory, reducing the need to retrieve it from the database repeatedly. It can improve application performance by reducing the amount of time spent waiting for data to be fetched from the database.

Hibernate provides several caching strategies, including:

**First-level cache (also known as session cache):** This cache is associated with the Hibernate Session object and is used to store entity instances that are currently in use by the application. It is enabled by default and can be configured to use different eviction policies.

**Second-level cache:** This cache is shared across all sessions and stores entity data, query results, and other objects. It can be configured to use different cache providers, such as Ehcache or Hazelcast, and can be enabled at the entity or query level.

**Query cache:** This cache stores the results of queries, allowing them to be reused without having to execute the query again. It can be enabled at the query level and is particularly useful for frequently executed read-only queries.

## 11. What is the difference between first-level cache and second-level cache?

**First-level cache (also known as session cache):** This cache is associated with the Hibernate Session object and is used to store entity instances that are currently in use by the application. It is enabled by default and can be configured to use different eviction policies.

**Second-level cache:** This cache is shared across all sessions and stores entity data, query results, and other objects. It can be configured to use different cache providers, such as Ehcache or Hazelcast, and can be enabled at the entity or query level.

## 12-13

Check MavenProject/hw8
