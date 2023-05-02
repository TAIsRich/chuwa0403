# HW8
## PART I
### 1.  List all of the annotations you learned from class and homework to annotations.md
See `ShortQuestions/annotations`
### 2.  Type the Comment feature for the class project.
Code see `Coding/hw8/comment`
### 3.  In postman, call of the APIs in PostController and CommentController.
### 4.  What is JPA? and what is Hibernate?
JPA (Java Persistence API) is a **specification** for mapping Java objects to relational databases. 
It provides a set of interfaces and annotations that define how entities can be mapped to relational tables, how to query them, and how to manage their lifecycle. 
JPA is a standard API provided by Java EE and can be used with any compliant ORM framework.

Hibernate is an ORM **framework** that implements the JPA specification. 
It is a popular ORM framework that maps Java objects to a **relational** database. 
Hibernate is not part of the Java EE standard, but it is widely used and supported by the Spring Framework.

Hibernate is often used as a JPA provider because it implements the JPA specification and provides additional features and performance optimizations on top of it. 
_Hibernate can be used with any compliant JPA provider, or it can be used as a standalone ORM framework without using the JPA API_.

In summary, JPA is a specification for ORM in Java, while Hibernate is an ORM framework that implements the JPA specification and provides additional features. 
Hibernate is one of the most widely used ORM frameworks.  

JPA是Java Persistence API的规范，而Hibernate是一个实现了JPA规范的ORM框架。Hibernate是JPA的一个提供者，但是JPA也可以由其他框架来实现。
### 5.  What is Hikari? what is the benefits of connection pool?
`HikariCP` is a high-performance **connection pool** for Java applications. Its benefits include faster connection acquisition, better resource management, improved scalability, simplified code, and improved performance.
1. Faster connection acquisition:   
Frequently creating and destroying a new database connection is expensive, particularly for remote databases.   
Connection pooling allows applications to reuse existing connections, which can significantly reduce the time needed to acquire a new connection.

2. Better resource management:   
It can help to ensure that resources like database connections are used efficiently.     
By limiting the number of connections can be created, connection pools prevent the application from overloading the database server.

3. Improved scalability:   
As the number of **concurrent users** increases, connection pooling can help to ensure that the application **remains responsive**.   
By reusing connections, connection pooling can allow the application to handle more requests without overloading the database server.

4. Simplified code:   
Connection pooling libraries like `HikariCP` can help to simplify the code required to manage database connections.   
By handling connection creation and management automatically, connection pools can reduce the amount of code required to interact with the database.

5. **Improved performance**:   
Connection pools like HikariCP are designed to be lightweight and efficient, which can improve the performance of database-driven applications.


### 6.  What is the  @OneToMany, @ManyToOne, @ManyToMany? write some examples.
- `@OneToMany` defines a one-to-many relationship between two entities, like one `Author` has many `Book`
- `@ManyToOne` defines a many-to-one relationship between two entities, like many `Book` belong to one `Author`

```
@Entity
public class Author {
    @Id
    private Long id;
    
    // mappedBy tells that the relation is mapped by the author field in the Book class
    @OneToMany(mappedBy = "author")
    private List<Book> books;
    
    
    // getters and setters
}

@Entity
public class Book {
    @Id
    private Long id;
    
    // JoinColumn tells that the foreign key in this Book table is called author_id which maps to the primary key in the Author table
    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author author;
    
    // getters and setters
}
```
The `mappedBy` attribute in the `@OneToMany` annotation indicates that the relationship is mapped by the `author` field in the `Book` class  
`@JoinColumn(name = "author_id")` annotation means that the foreign key column in the `Book` table that maps to the primary key of the `Author` table is named as `author_id`.

- `@ManyToMany` defines a many-to-many relationship between two entities, like a `User` can have many `Role`, on the other hand, a `Role` can be the role of many `User`
```aidl
@Entity
public class User {
    @Id
    private Long id;
    
    @ManyToMany(mappedBy = "users")
    private List<Role> roles;
    
    // getters and setters
}

@Entity
public class Role {
    @Id
    private Long id;
    
    @ManyToMany
    @JoinTable(
        name = "user_role",
        joinColumns = @JoinColumn(name = "role_id"),
        inverseJoinColumns = @JoinColumn(name = "user_id"))
    private List<User> users;
    
    // getters and setters
}
```
The `mappedBy` attribute in the `@ManyToMany` annotation in the `User` class indicates that the relationship is mapped by the `users` field in the `Role` class. 
The `@JoinTable` annotation in the `Role` class is used to specify the name of the join table and the foreign key columns used to join the `User` and `Role` tables.

### 7. Cascading
1. What is the  `cascade = CascadeType.ALL, orphanRemoval = true`?  
   - `cascade = CascadeType.ALL` means that all entity operations (e.g., persist, merge, remove) should be cascaded to the related entities. Like if a parent entity is deleted, then all the child entities associated with it will also be deleted.  
   - `orphanRemoval = true` means that any child entities that are no longer associated with the parent entity should be removed.   
   An orphaned entity is an entity that is no longer referenced by any other entity in the database  
   If a child entity is removed from the collection of a parent entity or the parent entity itself is deleted, then any child entities that are no longer referenced by any other entity will be deleted as well
2. what are the other CascadeType and their features? In which situation we choose which one?
   1. `CascadeType.PERSIST`:   
   When a new entity is persisted, any related entities that are not yet persisted will also be persisted.  
   Use this when you want to ensure that related entities are persisted along with the main entity. For example, when creating a new order, you might want to persist the order items at the same time.
   2. `CascadeType.MERGE`:   
   When an entity is merged, any related entities that have been changed will also be merged.  
      Use this when you want to ensure that changes to related entities are merged when the main entity is updated. For example, when updating a user's profile, you might also want to update their address.
   3. `CascadeType.REMOVE`:   
   When an entity is removed, any related entities will also be removed.  
   Use this when you want to ensure that related entities are removed along with the main entity. For example, when deleting a user, you might also want to delete their associated orders.
   4. `CascadeType.REFRESH`:   
   When an entity is refreshed, any related entities will also be refreshed.  
      Use this when you want to ensure that related entities are refreshed along with the main entity. For example, when reloading a product page, you might also want to reload the product reviews.
   5. `CascadeType.DETACH`:   
   When an entity is detached, any related entities will also be detached.
      Use this when you want to ensure that related entities are detached along with the main entity. For example, when caching an entity, you might want to cache all its related entities as well.  

**Extra info about methods provided by the JPA EntityManager interface**:  
- `persist()`: This method is used to make a new entity instance managed and persistent. When this method is called, the JPA provider generates an **INSERT** statement to persist the entity data to the database.  
**In short, it's to save an entity to the database**
- `merge()`: This method is used to update the state of an entity that is already managed by the persistence context. When this method is called, the JPA provider generates an **UPDATE** statement to update the entity data in the database.
- `refresh()`: This method is used to synchronize the state of an entity instance with the state of the corresponding entity in the database. When this method is called, the JPA provider retrieves the entity data from the database and updates the entity instance with the new data.
- `detach()`: This method is used to remove an entity instance from the persistence context, effectively detaching it from the persistence context. When this method is called, the JPA provider will no longer track changes to the entity instance, and changes made to the entity instance will not be persisted to the database.  

**Extra info about persistence context vs database**:  
In the context of JPA, the persistence context represents the set of all managed entity instances that are currently associated with a particular EntityManager. 
The persistence context acts as an **in-memory cache** of entity data that is used **to reduce the number of database operations required to perform certain operations** on entities.

When you query for an entity using JPA, the entity is loaded into the persistence context, which means that any subsequent changes made to that entity will be tracked by the persistence context. 
When you call `entityManager.persist()` to persist a new entity instance, the entity is also added to the persistence context.

The persistence context is a key feature of JPA because it allows for efficient management of entity data. 
**By keeping track of changes made to entity instances in memory, JPA is able to reduce the number of database operations required to persist entity data**.

On the other hand, the database is the actual storage location where entity data is persisted. 
When you persist an entity using JPA, the entity data is eventually written to the database. Similarly, when you load an entity using JPA, the entity data is retrieved from the database.

In summary, the **persistence context is an in-memory cache of entity data used by JPA to optimize database operations**, while the **database is the actual storage location where entity data is persisted**.

### 8.  What is the  fetch = FetchType.LAZY, fetch = FetchType.EAGER? what is the difference? In which situation you choose which one?  
`FetchType.LAZY` and `FetchType.EAGER` are two options to decide how associated entities should be loaded when loading an entity with JPA.  
By default, eager loading is for `ManyToOne` or `OneToOne` relationships; lazy loading is for `OneToMany` or `ManyToMany` relationships

With `FetchType.LAZY`, the associated entity is not loaded from the database until you actually access its properties. This can be useful for optimizing performance, as it **avoids loading unnecessary data** from the database.  
But it can also lead to additional database queries if you access the associated entity multiple times.  
So, it should be used when you have a large number of associated entities or when you only need to access the associated entity occasionally  

With `FetchType.EAGER`, the associated entity is immediately loaded from the database along with the main entity. This can be useful for optimizing performance **when you know that you will always need the associated entity**, as it **avoids additional database queries later on**.   
However, it can also lead to performance problems if you have a large number of associated entities or if the associated entity contains a large amount of data.

### 9.  What is the rule of JPA naming convention? Shall we implement the method by ourselves? Could you list some examples?
JPA provides default method implementations for basic CRUD operations (Create, Read, Update, Delete) through the EntityManager interface. This allows us to perform CRUD operations without actually implementing them.  
Here are some examples:  
Here are some examples:
- `findBy[AttributeName]`: Finds entities by the given attribute value.
- `findBy[AttributeName]In`: Finds entities with attribute values in the given collection.
- `findBy[AttributeName]And[OtherAttributeName]`: Finds entities that match both attribute values.
- `findDistinctBy[AttributeName]`: Finds distinct entities by the given attribute value.
- `countBy[AttributeName]`: Counts the number of entities with the given attribute value.
- `deleteBy[AttributeName]`: Deletes entities with the given attribute value.  

But we can always use the `@Query` annotation to customize those complicated queries
### 10. Try to use JPA advanced methods in your class project. In the repository layer, you need to use the naming convention to use the method provided by JPA.
Code see `Coding/hw8/comment`
### 11. (Optional) Check out a new branch(https://github.com/TAIsRich/springboot-redbook/tree/hw02_01_jdbcTemplate) from branch 02_post_RUD, replace the dao layer using JdbcTemplate.
### 12. (Optional) use JDBC to read the data from database.
 
## PART II
### 1.  List all the annotations you learned from class and homework to annotations.md
See `ShortQuestions/annotations`

### 2.  type the code, you need to checkout new branch from branch 02_post_RUD, name the new branch with https://github.com/TAIsRich/springboot-redbook/tree/hw05_01_slides_JPQL.
Code see `Coding/hw8/jpql`

### 3.  What is JPQL?
JPQL (Java Persistence Query Language) is a query language used to retrieve data from databases using JPA. JPQL is similar to SQL , but **it operates on entities and their properties** instead of tables and columns.

### 4.  What are @NamedQuery and @NamedQueries?
`@NamedQuery` and `@NamedQueries` are annotations used in JPA to define named queries.   
A **named query** is a **pre-defined query** with a **unique name** that can be **reused** in multiple places **within an application**.  
- `@NamedQuery` is used to define a single named query
- @NamedQueries is used to define multiple named queries in a single annotation. It takes an array of @NamedQuery annotations as its value.

```aidl
@Entity
@NamedQueries({
    @NamedQuery(name = "Employee.findByLastName",
        query = "SELECT e FROM Employee e WHERE e.lastName = :lastName"),
    @NamedQuery(name = "Employee.findAll",
        query = "SELECT e FROM Employee e")
})
public class Employee {
    //...
}
```
**Additional info**: If you're using Spring Boot with JPA, you don't need to configure anything special to use @NamedQuery.

### 5.  What is @Query? In which Interface we write the sql or JPQL?
`@Query` is an annotation in Spring Data JPA that allows developers to define custom JPQL, SQL, or native queries directly in repository methods in a **repository** interface.     
Spring Data JPA supports both JPQL and SQL queries with the `@Query` annotation. To use a native SQL query, developers need to set the `nativeQuery` attribute of the `@Query` annotation to true.  

**@Query with SQL vs JPQL**  
```aidl
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    // JPQL query
    @Query("SELECT e FROM Employee e WHERE e.department.id = :departmentId")
    List<Employee> findByDepartmentId(@Param("departmentId") Long departmentId);

    // SQL query
    @Query(value = "SELECT * FROM employee WHERE department_id = :departmentId", 
           nativeQuery = true)
    List<Employee> findByDepartmentIdSql(@Param("departmentId") Long departmentId);
}
```
**About ":"**:   
the expression `:departmentId` in the above queries is a named parameter that is used to bind the value of the `departmentId` parameter passed to the method.  
Jpql语句用的不是db里的table名(posts)，而是entity的class名(Post)

**Difference between `@Query` and `@NameQuery`**  
The main difference between @Query and @NamedQuery is that @Query is a Spring Data JPA annotation used to define custom JPQL, SQL directly in repository methods, while @NamedQuery is a JPA annotation used to define named queries that are stored in the entity class or mapped superclass.
- **Query location**:   
With `@NamedQuery`, the query is defined in the **entity** class or mapped superclass, and it **can be accessed by its unique name from any repository that manages that entity**.   
With `@Query`, the query is defined in a **repository** method, and it can only be accessed from that method.
- **Query definition**:   
With `@NamedQuery`, the query is defined as a **string** value of the annotation, and it **must be a JPQL query**.   
With `@Query`, the query can be defined as a **JPQL, SQL, or native query string**, and it **can include named parameters**, SpEL expressions, and other dynamic elements.

### 6.  What is HQL and Criteria Queries?
HQL (Hibernate Query Language) is a query language for Hibernate. HQL is similar to SQL in syntax, but **it operates on Hibernate's object model rather than on the database tables** directly.
```aidl
String hql = "FROM Employee WHERE department.id = :departmentId";
List<Employee> employees = session.createQuery(hql, Employee.class)
                                 .setParameter("departmentId", departmentId)
                                 .getResultList();
```
Criteria queries are another way to query data using Hibernate, but they use a type-safe and object-oriented API rather than a query language. Criteria queries allow you to build up a query step-by-step using method calls on a CriteriaBuilder object, and they can be easier to read and maintain than HQL queries in some cases.
```aidl
CriteriaBuilder cb = session.getCriteriaBuilder();
CriteriaQuery<Employee> query = cb.createQuery(Employee.class);
Root<Employee> employee = query.from(Employee.class);
query.where(cb.equal(employee.get("department").get("id"), departmentId));
List<Employee> employees = session.createQuery(query).getResultList();
```
In above example, we first obtain a `CriteriaBuilder` object from the session, which we can use to create a `CriteriaQuery` object for the `Employee` entity class. We then use the `from()` method to obtain a `Root` object for the `Employee` entity, which we can use to build up the query using various methods on the `CriteriaBuilder` object. Finally, we execute the query using `createQuery()` and obtain the results using `getResultList()`.
### 7.  What is EntityManager?
`EntityManager` is a core interface in the JPA that provides the mechanism for managing entities in a persistence context. 
It is responsible for CRUD (Create, Read, Update, Delete) operations on entities, as well as managing transactions and ensuring the consistency of the entity state  

An EntityManager instance represents a session with the database, and provides methods for creating, retrieving, updating and deleting entities. It is responsible for tracking the state of entities and synchronizing them with the database as needed.  

To declare an EntityManager object in the class, we mark it with the `@PersistenceContext` annotation. `@PersistenceContext` is used to inject an instance of `EntityManager` into a Spring bean
```aidl
@Repository
@Transactional
public class PostJPQLRepositoryImpl implements PostJPQLRepository {
    @PersistenceContext
    EntityManager entityManager;
    ...
    
    public Post insertPost(Post post) { // post中可以無ID
        return entityManager.merge(post);
    } 
}
```
### 8.  What is SessionFactory and Session?
`SessionFactory` and `Session` are both classes in Hibernate that are used to **create and manage database connections and transactions**.

`SessionFactory` is a **thread-safe** and **immutable** factory for **creating Session instances**. 
It is typically **created at application startup** and **shared throughout the application**. 
The `SessionFactory` is **responsible for initializing Hibernate configuration settings**, **creating database connections**, and **managing the mapping between Hibernate entities and database tables**.

`Session` is a lightweight and **non-thread-safe** object that represents **a single unit of work with the database**. It **provides methods for CRUD** operations, as well as for **querying the database** using Hibernate Query Language (HQL) or Criteria API.

In general, **_the SessionFactory is responsible for creating Session instances and managing the database connection_**, while the **_Session is responsible for executing queries and managing transactions_**. 
You can create multiple `Session` instances from a single `SessionFactory`, but each `Session` should be used only for a single unit of work and then closed to release the database connection.

### 9.  What is Transaction? how to manage your transaction?
A transaction is **a logical unit of work** that **groups one or more database operations** into a single **atomic** operation.   
A transaction ensures that either all of the operations are successfully completed or none of them are applied to the database if one of them failed.
So it's all succeed or all fail  

Use the `@Transactional` annotation in Spring. This annotation can be applied to a method or to a class.  
Use `@Transactional` on the methods to perform database operations that need to be executed atomically.  
If `@Transactional` applied to a class, that means that all public methods of the class are transactional

### 10. What is hibernate Caching?
Hibernate caching is a mechanism that allows Hibernate to **avoid repeated database access** by **storing frequently accessed data in memory**. 
This can significantly improve the performance of an application by reducing the number of database queries needed to retrieve data.

### 11. What is the difference between first-level cache and second-level cache?
- First-level cache (also known as session-level cache):   
   This is a cache that is **associated with a specific Hibernate `Session`**.
   It stores entities that have been retrieved from the database during the current `Session`.
   When an entity is accessed **again** within the same `Session`, Hibernate **checks the first-level cache first before hitting the database again**.
- Second-level cache (also known as session factory-level cache):   
   This is a cache that is **shared by all `Sessions` within a Hibernate `SessionFactory`**.
   It _stores entities that have been retrieved from the database by any `Session` in the `SessionFactory`_.   
   When an entity is accessed again by any `Session` within the `SessionFactory`, if it is already present in the first-level cache, it is returned from there,
   if not found in the first-level cache, Hibernate checks the second-level cache first before hitting the database again.


### 12. How do you understand @Transactional? (不要clone，要自己抄写并测试transactional，https://github.com/TAIsRich/tutorial-transaction)
`@Transactional` allows to perform multiple database operations as a single atomic unit  
Code see `Coding/hw8/transaction`

### 13. Write a simple factory design pattern.
Code see `Coding/hw8/factory`