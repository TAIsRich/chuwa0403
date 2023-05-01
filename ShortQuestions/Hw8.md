# Homework 8 Part 1
## 1. 
Done.
## 2. 
See []().

## 3. What is JPQL?
JPQL stands for java persistent query language. It is a query language used to perform database queries in Java applications that use JPA. JPQL has the similar syntac with 
SQL, but instead use Java objects rather than relational database tables.

## 4. What is @NamedQuery and @NamedQueries?
@NamedQuery specifies a static named query in the JPQL. Queries are scoped to the persistent unit, which makes them available to all entity classes within the persistence unit.. It is a predefined query that can be executed using the JPA entitymanager 
interface. With @NamedQuery, you can define a query as a named query within an entity class using JPQL syntax. The named query can then be referenced by name in code to execute the query.

@NamedQueries can specify sveral @NamedQuery inside.

## 5. What is @Query? In which Interface we write the sql or JPQL?
It is used to declare custom queries to be executed by Spring repositories. With @Query, you can define a custom query along with any parameters that the query may require.
Use @Param to define the dynamic query values in the function parameters modified by @Query.

## 6. What is HQL and Criteria Queries?
Hibernate Query Language (HQL) is an object-oriented query language, similar to SQL, but instead of operating on tables and columns, HQL works with persistent objects and their properties. HQL queries are translated by Hibernate into conventional SQL queries, which in turns perform action on database.

Criteria Queries allows developers to manipulate objects and in turn data available in RDBMS tables.

## 7. What is EnityManager?
An entitymanager manages connection to a database as well as to database operations. EntityManager is associated with a PersistentContext. All operations that are performed in a specific session are stored inside the PersistentContext. Entity manager is the interface to the persistent context. All operations on the entity goes through the EntityManager.

## 8. What is SessionFactory and Session?
Session factory is a thread safe factory to create hibernate session. It is responsible for initializing hibernate configuration settings, caching metadata, and creating new sessions to access meta data.

Session provides a persistence context for Hibernate to interact with database. It is used to get a physical connection with a database. It is used to perform CRUD.

## 9. What is Transaction? how to manage your transaction?
A transaction represents a unit of work. If one step fail, then the transaction fails. Add annotations @Transactional on the method that needs to be a transaction.

## 10. What is hibernate Caching?
Hibernate caching is a mechanism provided by Hibernate to improve the performance of database access by reducing the number of database round trips. Caching allows frequently accessed data to be stored in memory, which can reduce the reponse time.

## 11. What is the difference between first-level cache and second-level cache?
|First level | Second level|
|----|----|
|Maintained by each session, not shared | SessionFactory level cache, shared by all sessions|
|Enabled by default, no way to disable it | Disabled by default|
|Available until the session is open, destroyed when close | Available through the application life cycle|

First level -> second level -> database.

## 12. How do you understand @Transactional
@Transactional is called, Spring starts a transaction before the method executes, and commits the transaction after the method completes. If an exception is thrown during the method execution, Spring rolls back the transaction.

@Transactional can be applied at the class or method level. When applied at the class level, it applies to all methods in the class.

@Transactional is a powerful feature of Spring Framework that simplifies the management of transactions in your application. By using @Transactional, you can ensure that database operations are atomic, consistent, isolated, and durable, which are the key properties of a transaction.

Spring uses a transaction manager to manage transactions. It can be added and application by @EnableTransactionManagement.

See []().

## 13. Write a simple factory design pattern.
```
public abstract class Car {
    abstract public void whistle();
    private String name;
}
  
public class Porsche implements Car {
    public Porsche() {
        this.name = "Benz";
    }
    public void whistle() {
        
    }
}

public class Benz implements Car {
    public Benz(String name) {
        this.name = "Porsche";
    }
    public void whistle() {
        
    }
}

public class CarFactory {
    public void makeACar(String name) {
        Car car;
        if (name == "Benz") {
            car = new Benz();
        } else if (name == "Porsche") {
            car = new Porsche();
        }
        car.whistle();
    }
}
```

# Part 2
## 1. 
Done.

## 2.
Done in Hw7.

## 3.
DOne.

## 4. what is JPA? and what is Hibernate?
JPA is a java specification that offers java applications that written in Java for mapping objects to relational database. It offers a management mechanism for persistence and object relational mapping system. JPA is responsible for defining mappings internally. JPA defines a set of interfaces and annotations that provide a high level abstraction over relational databases. This allows developeres to interact with java objects rather than SQL.

Hibernate is an implementation of JPA and provide additional features. It is an object relational mapping framework. 

Some key features:
1. ORM: Hibernate provides a set of annotations and XML configuration files that allow developers to map Java objects to database tables and columns.
2. Automatic schema generation: Hibernate can generate database schema automatically based on the entity mappings defined in Java classes.
3. Querying: Hibernate provides a powerful query language called Hibernate Query Language (HQL) that allows developers to query entities using object-oriented syntax, rather than SQL.
4. Caching: Hibernate supports caching of frequently accessed data, which can significantly improve the performance of database access.
5. Transactions: Hibernate provides transaction management capabilities, allowing developers to specify transaction boundaries and manage transactions in a declarative manner.







## 5. What is Hiraki? what is the benefits of connection pool?
Hiraki is a JDBC datasource implementation that provides a connection pooling mechanism. 

1. faster application start time. Because they don't need to establish new database connection.
2. reduce overhead. by reusing exists connection
3. improve scalability: connecting pools allows multiple threads to share a limit number of connections, enbaling the application to handle more concurrent users and requests
4. improved performance. by reuse exixts connections.

## 6. What is the  @OneToMany, @ManyToOne, @ManyToMany? write some examples.
@OneToMany: One source entity can be matched to many target entity.
```
@Entity
public class Order {

    @Id
    private Long id;

    @OneToMany(mappedBy = "order") // The mappedBy attribute specifies that the relationship is mapped by the order field in the OrderItem entity.
    private List<OrderItem> items;

}
```

@ManyToOne: Several source entity can be matched to one target Entity
```
@Entity
public class OrderItem {

    @Id
    private Long id;

    @ManyToOne
    @JoinColumn(name = "order_id") // foreign key
    private Order order;

}
```
@ManyToMany: several source entity can be matched to one or more target entity
```
@Entity
public class Book {

    @Id
    private Long id;

    @ManyToMany(mappedBy = "books")
    private List<Author> authors;
}

@Entity
public class Author {

    @Id
    private Long id;

    @ManyToMany
    @JoinTable(name = "book_author",
               joinColumns = @JoinColumn(name = "author_id"),
               inverseJoinColumns = @JoinColumn(name = "book_id"))
    private List<Book> books;

}
```
## 7. What is the  cascade = CascadeType.ALL, orphanRemoval = true? and what are the other CascadeType and their features? In which situation we choose which one?
Cascading refers to the ability to automatically propagate the state of an entity (i.e., an instance of a mapped class) across associations between entities. For example, if you have a Customer entity that has a one-to-many relationship with an Order entity, you can define cascading to specify that when a customer is deleted, all of their orders should be deleted as well.

1. CascadeType.ALL: is a cascading type in Hibernate that specifies that all state transitions (create, update, delete, and refresh) should be cascaded from the parent entity to the child entities. When we want any operations on parent entity will be propogated to child entities.
2. CascadeType.PERSIST
3. CascadeType.MERGE
4. CascadeType.REMOVE
5. CascadeType.REFRESH
6. CascadeType.DETACH
7. CascadeType.REPLICATE
8. CascadeType.SAVE_UPDATE


## 8. What is the  fetch = FetchType.LAZY, fetch = FetchType.EAGER? what is the difference? In which situation you choose which one?

## 9. What is the rule of JPA naming convention? Shall we implement the method by ourselves? Could you list some examples?

## 10. Try to use JPA advanced methods in your class project. In the repository layer, you need to use the naming convention to use the method provided by JPA.
