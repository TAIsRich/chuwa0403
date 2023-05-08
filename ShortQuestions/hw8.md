# hw42-Spring-Data 
1. see [annotations](/ShortQuestions/annotations.md)
2. see [redbook](/Coding/redbook/)
3. 
4. JPA: Java Persistence API. It is a Java specification for object-relational mapping that provides a standard way to map Java objects to relational database tables and vice versa. JPA provides a set of APIs for managing relational data in Java applications.
Hibernate: It is an open-source object-relational mapping framework for Java. It provides a set of APIs for mapping Java objects to relational database tables and vice versa. 
5. Hikari: It is a high-performance JDBC connection pooling library for Java applications. Connection pooling is a technique that enables multiple clients to share a cached set of databse connections, reducing the overhead of creating new database connections for every client request.
6. `@OneToMany`: one-to-many relationship. Map a collection of child entites to a single parent entity. 
`@ManyToOne`: many-to-one relationship. Several entites map to one entity.
`@ManyToMany`: several entites can be matched to one or more entites.
```
@Entity
public class Auther{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToMany(mappedBy = "author", cascade = CascadeType.all)
    private List<Book> books;
}

@Entity
public class Book{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    private Author author;

    @ManyToMany(cascade = CascadeType.ALL)
    private List<BookStore> stores;
}

@Entity
public class BookStore{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToMany(mappedBy = "book", cascade = CascadeType.ALL)
    private List<Book> books;

}
```
7. `cascade = CascadeType.ALL` means that it will propagate all EntityManager operations to the relating entities. Any change happens on this Entity must cascade to the related entity. `orphanRemoval = true` means that dependent entites are removed when the relationship to their parent entity is destroyed. Cascade type:
    - ALL: propagates all operations, from a parent to a child entity 
    - PERSIST: propages the persist (save) operation from a parent to a child entity
    - MERGE: propagates the merge operation from a parent to a child
    - REMOVE/DELETE: propagates the remove operation from parent to child entity
    - DETACH: the child entity will also get removed from the persistent context.
    - LOCK: the child entity is locked when the parent is locked
    - REFRESH: refresh operations reread the value of a given instance from the database. The child entity also get reloaded from the database when the parent entity is refreshed.
    - REPLICATE: the sync operation will propagate to child entites when performed on the parent entity.
    - SAVE_UPDATE: propagate save, update and saveOrUpdate.

8. `fetch = FetchType.LAZY` means when a replationship is marked as lazy, the related entity is not loaded from the database until it is actually accesed by the application. It is useful when we have a large number of related entites and we want to avoid loading them all at once. `fetch = FetchType.EAGER`means the related entity is loaded from the database immediately when the parent entity is loaded. It is useful when we know that we will always need the related entity when we access the parent entity ant it avoid the overhead of additional database queries.

9. JPA naming convention:
    - Entity class naming convention: Entity classes should be named using the singular form of the table name, with the first letter capitalized. table "coustomers"->"Customer"
    - Property naming convention: Property names should be in CamelCase, starting with a lowercase letter. "firstName"
    - Primary key naming convention: should be named "id", with a data type that corresponds to the database primary key type.
    - Table naming convention: JPA maps entity classes to database tables with the same name as class. To specify a different name, use `@Table`
    - Relationship naming convention: should be named using a conbination of the name of the taret entity class and the property name in the owning entity class.
    - Join table naming convention: many-to-many relationship is defined, JPA creates a join table to store the relationship. It is named using the names of the two entites being joined, in alphabetical order.
    - Query rules: use key words And, Or, between, isNull, isNotNull, in, not in, find by etc. Method parameters should be in entityes.
    
    We don't need to implement this ourselves.

    findByNameAndDescription(String name, String description)
10. see [redbook](/Coding/redbook/)
11. see [redbook](/Coding/redbook/)

# hw42-Spring-Data 2
1. see [annotations](/ShortQuestions/annotations.md)
2. see [redbook](/Coding/redbook/)
3. JPQL: Java Persistence Query Language. It is a query language used tot retrieve data from relational databases using the Java Persistence APIT(JPA). It is a SQL-like language that allows developers to write databse queries in terms of Java objects rather than database tables. 
4. `@NamedQuery`: Define a single named query for an enitty. The annotation is added to the enitty class and includes a unique name for the query and the JPQL query string that defines the query.
`@NamedQueries`: attaching multiple named queries to the same enitty class, it could contain multiple `@NamedQuery`

5. `@Query`: An annotation used in Spring Data JPA to define custom queries using JPQL, SQL or other languages. We write SQL or JPQL in JpaRepository interface.
```
// standard query writing in JPQL
@Query("select p from Post p)
List<Post> findAll();

// native queries with SQL
@Query(value = "select p from Posts")
List<Post> findAll();
```

6. HQL: Hibernate Query Language is an object-oriented query language, similar to SQL, but instead of operating on tables and columns, HQL works with persistent objects and their properties. HQL queries are translated by Hibernate into conventional SQL queries to perform action on database
Criteria Queries: write queries without doing rao SQL as well as gives us some object-oriented control over the queries.

7. EntityManager: It is an interface in JPA that provides a set of methods for manageing persistence operations on entites. It is associated with a PersistenceContext. All operations that are performed in a specific session are stored inside the PersisitenceContext. EntityManager is the interface to the PersistenceContext. All operations on the entity go through the EntityManager. We will declare an EntityManager object in our cass and mark it tiwh the `@PersistenceContext` annotation.

8. SessionFactory: A factory class that creates and manages Session interfaces. It is responsible for initializing and configuring Hibernate and privides a way to create Session instances. It is created only once during the application startup process.
Session: The session object provides an interface between the application and data stored in the database.

9. Transaction: represents a unit of work. If one step fail, then the transaction fails. How to manage: Add annotation `@Transaction` on the method.

10. Hibernate caching: A mechanism provided by Hibernate to improve the performance of database access by reducing the number of database round trips. Caching allows frequently accessed data to be stored in memory, which can reduce the reponse time.

11. first-level cache VS second-level cache: first-level cache is bound to a single Hibernate Session instance and maintained at the Session level. The second level cache is mainteained at the SessionFactory level and available to all Sessions. 

12. see [Transaction](/Coding/hw8/transaction/)

13. 
```
public interface Shape{
    void draw();
}

public class Circle implements Shape{
    public void draw(){
        System.out.println("circle");
    }
}

public class Rectangle implements Shape{
    public void draw(){
        System.out.println("rectangle");
    }
}

public class ShapeFactory{
    public Shape createShape(String type){
        if(type.equals("circle"))
            return new Circle();
        if(type.equals("rectangle))
            return new Rectangle();
        return null;
    }
}

public class Main {
    public static void main(String[] args) {
        ShapeFactory factory = new ShapeFactory();
        Shape c = factory.createShape("circle");
        c.draw();
    }
}
```

