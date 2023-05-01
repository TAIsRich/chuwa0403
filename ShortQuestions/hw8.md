# HW8 - Part 1

## 4. What is JPA, and what is Hibernate?

JPA stands for **Java Persistence API, and it is a Java specification for object-relational mapping (ORM) frameworks**. JPA provides a standard API for mapping Java objects to relational database tables and vice versa. It allows developers to write Java code that interacts with the database without writing any SQL statements.

Hibernate, on the other hand, is an open-source ORM framework that implements the JPA specification. It is one of the most popular ORM frameworks for Java applications, providing a simple, efficient, and flexible way to map Java objects to relational database tables. Hibernate can be used with any database that supports SQL.

## 5. What is Hikari Pool and what is the benefits of connection pool?

**HikariPool is a high-performance JDBC connection pool library for Java applications.** It is one of the most popular and widely used connection pool libraries due to its excellent performance, reliability, and ease of use.

1. High performance: HikariPool is designed to be fast and efficient, with low overhead and minimal resource utilization.
2. Thread-safe: HikariPool is designed to be thread-safe, ensuring that connections are properly managed and shared across threads.
3. Automatic pool sizing: HikariPool can automatically adjust the size of the connection pool based on the application's needs, ensuring that there are enough connections available to handle the workload.
4. Configurable: HikariPool provides a wide range of configuration options, allowing developers to fine-tune the connection pool to meet the needs of their application.

As for the benefits of connection pooling, it is a technique used in software applications to manage and reuse database connections. The main benefits of connection pooling are:

1. Improved performance: Creating and closing database connections can be a time-consuming process. By reusing existing connections, connection pooling can improve the performance of database operations.
2. Reduced overhead: Establishing a new connection to a database requires communication with the database server, authentication, and authorization checks. Connection pooling can reduce this overhead by reusing existing connections.
3. Increased scalability: Connection pooling can help scale an application by reducing the number of resources needed to manage connections, allowing the application to handle more concurrent users.
4. Better resource management: Connection pooling can help prevent resource exhaustion by limiting the number of connections that an application can create.

## 6. What is the @OneToMany, @ManyToOne, @ManyToMany?

`@OneToMany` is used to define a one-to-many relationship between two entities. For example, a customer may have many orders. In this case, the `@OneToMany` annotation would be used to define the relationship between the `Customer` entity and the `Order` entity.

`@ManyToOne` is used to define the inverse side of a `@OneToMany` relationship. In the example above, the `@ManyToOne` annotation would be used to define the relationship between the `Order` entity and the `Customer` entity.

`@ManyToMany` is used to define a many-to-many relationship between two entities. For example, a student may be enrolled in many courses, and a course may have many students. In this case, the `@ManyToMany` annotation would be used to define the relationship between the `Student` entity and the `Course` entity.

* `@OneToMany` and `@ManyToOne`

  ```java
  @Entity
  @Table (
  		name = "posts"
  )
  public class Post {
      @Id
      @GeneratedValue(strategy = GenerationType.IDENTITY)
      private long id;
      
      // ...
          
      // mappedBu = "post" means there is an object in a comment called post
      @OneToMany(mappedBy = "post", cascade = CascadeType.ALL, orphanRemoval = true)
      private Set<Comment> comments = new HashSet<>();
      
      // ...
  }
  ```

  ```java
  @Entity
  @Table (
  		name = "comments"
  )
  public class Comment {
      @Id
      @GeneratedValue(strategy = GenerationType.IDENTITY)
      private long id;
      
      // ...
      
      @ManyToOne(fetch = FetchType.LAZY)
      // name = "post_id" refers to the post_id column in comment table
      @JoinColumn(name = "post_id", nullable = false)
      // This is the mappedBy thing in Post class
      private Post post;
  }
  ```

`@ManyToMany` is used to define a many-to-many relationship between two entities. For example, a student may be enrolled in many courses, and a course may have many students. In this case, the `@ManyToMany` annotation would be used to define the relationship between the `Student` entity and the `Course` entity.

* ```java
  @Entity
  @Table (
  		name = "students"
  )
  public class Student {
      @Id
      @GeneratedValue
      private long id;
      
      //...
      
      @ManyToMany
      @JoinTable(
      	name = "enrollments",
          joinColumns = { @JoinColumn(name = "student_id")},
          inverseJoinColumns = { @JoinColumn(name = "course_id")}
      )
      private Set<Course> courses = new HashSet<>();
      
      //..
  }
  ```

  ```java
  @Entity
  @Table (
  		name = "courses"
  )
  public class Course {
      @Id
      @GeneratedValue(strategy = GenerationType.IDENTITY)
      private long id;
      
      // ...
      
      @ManyToMany(mappedBy = "courses")
      private Set<Student> stduents = new HashSet<>();
  }
  ```

## 7. What is the cascade = CascadeType.ALL, orphanRemoval = true? What are the other CascadeType and their features? In which situation we choose which one?

`cascade = CascadeType.ALL` refers to all cascade operations on owning entity applied to related entity.

`orphanRemoval = true` means once the parent of this table/record is removed, we need to remove this table/record.

| Cascade Rule              | Function                                                     | When to use                                                  |
| ------------------------- | ------------------------------------------------------------ | ------------------------------------------------------------ |
| `CascadeType.ALL`         | Apply all cascade operations (PERSIST, REMOVE, REFRESH, DETACH, MERGE) | Use this when you want all operations to be cascaded to associated entities. |
| `CascadeType.PERSIST`     | This operation is used to save a new entity to the database. | Use this when you want to persist associated entities when the owning entity is persisted. |
| `CascadeType.MERGE`       | This operation is used to update an existing entity in the database. | Use this when you want to merge associated entities when the owning entity is merged. |
| `CascadeType.REMOVE`      | This operation is used to delete an entity from the database. | Use this when you want to delete associated entities when the owning entity is deleted. |
| `CascadeType.REFRESH`     | This operation is used to refresh the state of an entity from the database. | Use this when you want to refresh associated entities when the owning entity is refreshed. |
| `CascadeType.DETACH`      | This operation is used to detach an entity from the persistence context. | Use this when you want to detach associated entities when the owning entity is detached. |
| `CascadeType.REPLICATE`   | This operation is used to replicate an entity to another database or cluster. | Use this when you want to replicate associated entities when the owning entity is replicated. |
| `CascadeType.SAVE_UPDATE` | This operation is used to save or update an entity in the database, depending on whether the entity is new or already exists in the database. | Use this when you want to save or update associated entities when the owning entity is saved or updated. |

## 8. What is the fetch = FetchType.LAZY, fetch = FetchType.EAGER? What is the difference? In which situation you choose which one?

| Fetch Rule        | Function                                                     | When to use                                                  |
| ----------------- | ------------------------------------------------------------ | ------------------------------------------------------------ |
| `FetchType.Lazy`  | Lazy fetch fetches the records only when they are needed.    | When the associated entities are not always needed, or when they are only needed in specific cases. |
| `FetchType.Eager` | Eager fetch is the default fetch type used by Hibernate but it is not always the most efficient. Eager fetch means that when a record is fetched from the database, all the associated records from related tables are also fetched. | When the associated entities are always needed, or when they are needed in the majority of cases. |

## 9. What is the rule of JPA naming convention? Shall we implement the method by ourselves? Could you list some examples?

| SQL Keyword | Example                          | SQL Script                             |
| :---------- | :------------------------------- | :------------------------------------- |
| And         | findByLastNameAndFirstName(a, b) | Where last name = a and first name = b |
| Or          | findByLastNameOrFirstName(a, b)  | Where last name = a or first name = b  |
| Between     | findByStartDateBetween(a, b)     | Where start date between a and b       |
| IsNull      | findByAgeIsNull()                | Where age is null                      |
| (Is)NotNull | findByAgeIsNotNull()             | Where age I not null                   |
| OrderBy     | findByAgeOrderByLastNameDesc(a)  | Where age = a order by last name       |
| In          | findByAgeIn(a[])                 | Where age in a[]                       |
| NotIn       | findByAgeNotIn(a[])              | Where age not in a[]                   |
| True        | findByActiveTrue()               | Where active = true                    |
| False       | findByActiveFalse()              | Where active = false                   |
| IgnoreCase  | findByFirstNameIgnoreCase(a)     | Where UPPER(First Name) = UPPER(a)     |

**We don't need to implement the method body.**

```java
// DAO
@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
    List<Post> findByTitle(String title);
    
    List<Post> findByContent(String content);
}

// Service
@Service
public class PostServiceImpl implements PostService {
    
    @Autowired
    private PostRepository postRepository;
    
    public List<Post> findPostByTitle(String title) {
        return postRepository.findByTitle(title);
    }
    
    public List<Post> findPostByContent(String content) {
        return postRepository.findByContent(content);
    }
}
```

 # HW8 - Part2

## 3. What is JPQL?

JPQL stands for Java Persistence Query Language. It is a platform-independent query language used to retrieve data from databases using JPA. JPQL is similar to SQL, but instead of querying tables and columns, it queries entities and their attributes.

JPQL is defined in terms of the object model, rather than the database schema, which means that queries are written using entity names, field names, and relationships between entities, rather than table and column names. JPQL queries are then translated by the JPA provider into SQL queries that can be executed against the database.

## 4. What is @NamedQuery and @NamedQueries?

`@NamedQuery` and `@NamedQueries` are JPA annotations that allow developers to define named queries in their entity classes.

`@NamedQuery` is used to define a single named query in an entity class. The named query can be executed by calling the `createQuery()` method on the `EntityManager` interface, passing the name of the query as a parameter.

```java
//DAO
@Repository
public class PostJPQLRepositoryImpl implements PostJPQLRepository {
    
    @PersistenceContenxt
    EntityManager entityManager;
    
    @Override
    public List<Post> getAllPostsWithJPQL() {
        posts = entityManager.createNamedQuery("get_all_posts", Post.class);
        return posts.getResultList();
    }
}

//Entity
@Entity
@Table (
		name = "posts",
    	uniqueConstraints = {
            @UniqueConstraint(columnNames = {"title"})
        }
)
@NamedQuery(name = "get_all_posts", query = "select p from p")
public class Post {
    //...
}
```

`@NamedQueries` is used to define multiple named queries in an entity class. The `@NamedQueries` annotation takes an array of `@NamedQuery` annotations, each of which defines a single named query.

```java
@Entity
@NamedQueries({
    @NamedQuery(
        name = "Employee.findByFirstName",
        query = "SELECT e FROM Employee e WHERE e.firstName = :firstName"
    ),
    @NamedQuery(
        name = "Employee.findByLastName",
        query = "SELECT e FROM Employee e WHERE e.lastName = :lastName"
    )
})
public class Employee {
    // ...
}

```

## 5. What is @Query? In which Interface we write the sql or JPQL?

`@Query` is a JPA annotation that allows developers to define custom queries directly in their repository interfaces using JPQL or native SQL.

The `@Query` annotation is used to annotate a method in a repository interface and specify the JPQL or SQL query to execute. The query can include named parameters, which are replaced with actual values when the query is executed.

To define a custom JPQL query in a repository interface to retrieve all `Employee` entities with a matching `email`, you can use the `@Query` annotation as follows:

```java
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    
    @Query("SELECT e FROM Employee e WHERE e.email = :email")
    List<Employee> findByEmail(String email);
    
}
```

```java
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    
    @Query(value = "SELECT * FROM employee WHERE email = :email", nativeQuery = true)
    List<Employee> findByEmail(String email);
    
}
```

## 6. What is HQL and Criteria Queries?


HQL (Hibernate Query Language) and Criteria Queries are two alternatives to JPQL for querying data using Hibernate, which is a popular implementation of the JPA specification.

HQL is similar to JPQL, but it provides some additional features specific to Hibernate. HQL queries are defined using the Hibernate-specific syntax, which is similar to SQL syntax but operates on Hibernate entities instead of database tables. HQL queries can include advanced features such as subqueries, joins, and projections, making them a powerful tool for querying complex data.

## 7. What is Entity Manager?

The `EntityManager` is the primary interface for interacting with the persistence context in JPA. It provides methods for performing common CRUD (create, read, update, delete) operations on entities, as well as advanced features such as transaction management, caching, and query execution.

The `EntityManager` is responsible for managing the lifecycle of entities, which includes persisting new entities, retrieving existing entities, modifying and deleting existing entities, and detaching entities from the persistence context. The `EntityManager` also provides a number of methods for querying entities, including JPQL queries and native SQL queries.

To use the `EntityManager`, you first need to obtain an instance of it from a `EntityManagerFactory`, which is typically configured in the `persistence.xml` file. You can then use the `EntityManager` to perform various operations on entities within a transactional context.

## 8. What is SessionFactory and Session?

`SessionFactory` is a factory for creating `Session` objects, which provide a connection to the database and manage the persistence context for a Hibernate application. The `SessionFactory` is typically created once for the lifetime of the application and cached for reuse. The `SessionFactory` is responsible for initializing Hibernate and managing the configuration of the persistence context.

`Session` is a lightweight object that represents a single unit of work with the database. A `Session` is created by the `SessionFactory` and provides methods for performing CRUD (create, read, update, delete) operations on entities, as well as advanced features such as transaction management, caching, and query execution. A `Session` represents a single conversation between the application and the database and is not thread-safe.

## 9. What is Transaction? how to manage your transaction?

In Hibernate, transactions are managed using the `Transaction` interface, which provides methods for starting and committing transactions, as well as rolling back transactions in case of errors.

To manage transactions in Hibernate, you typically follow these steps:

1. Obtain a `Session` from the `SessionFactory`.
2. Start a new transaction using the `Transaction` interface.
3. Perform database operations within the transaction, such as saving or retrieving entities.
4. Commit the transaction using the `Transaction` interface when the operations are complete.
5. Close the `Session`.

```java
@Test
void test SessionFactory() {
    // 1. 根据配置文件创建 Session Factory
    SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
    
    // 2. Session Factory 创建出一个 Session
    Session session = sessionFactory.openSession();
    
    // 创建 Transaction 变量
    Transaction transaction = null;
    
    try {
        // 3. Session 开始一个 Transaction
        transaction = session.beginTransaction();
        
        // 4. 执行 txn
        post.setTitle(post.getTitle() + LocalDateTime.now());
        post.setCreateDateTime(LocalDateTime.now());
        post.setUpdateDateTime(LocalDateTime.now());
        
        Post savedPost = (Post) session.merge(post);
        System.out.println(savePost);
        
        // 5. Commit txn，要么成功，要么失败，是一个原子操作
        transaction.commit();
    } catch (Exceptio e) {
        if (transaction != null) {
            // txn 失败，执行回滚操作
            transaction.rollback();
        }
    } finally {
        // 6. Close session
        session.cose();
    }
}
```

# 10. What is hibernate Caching?

Hibernate caching is a mechanism used by Hibernate to reduce the number of database queries required to retrieve data by caching data in memory. Hibernate caching can greatly improve application performance by reducing the amount of time required to access data from the database.

* First Level:

  Hibernate first level cache is **session specific**, that's why **when we are getting the same data in same session there is no query fired** whereas in other session a query is fired to load the data.

* Second Level:

  It is used to cache entities and query results that are frequently accessed across multiple sessions. When the same entity or query result is later retrieved again in another sessions, it is retrieved from the second-level cache instead of the database.

If an instance is already in the first-level cache, it is returned from there. If an instance is not found in the first-level cache, and the corresponding instance state is cached in the second-level cache, then the data is fetched from there and an instance is assembled and returned. Otherwise, the necessary data are loaded from the database and an instance is assembled and returned.

## 11. What is the difference between first-level cache and second-level cache?

| First Level Cache                                            | Second Level Cache                                           |
| ------------------------------------------------------------ | ------------------------------------------------------------ |
| This is local to the Session Object and cannot be shared between multiple sessions. | This cache is maintained at the SessionFactory level and shared among all sessions in Hibernate. |
| This cache is enabled by default and there is no way to disable it. | This is disabled by default, but we can enable it through configuration. |
| The first level cache is available only until the session is open, once the session is closed, the first level cache is destroyed. | The second level cache is available through the application's lid cycle, it is only destroyed and recreated when an application is restarted. |



