# 1.  List all of the annotations you learned from class and homework to annotaitons.md
## annotations.md
# 2.  Type the Comment feature for the class project.
## .java
# 3.  In postman, call of the APIs in PostController and CommentController.
```

```
# 4.  what is JPA? and what is Hibernate?
## Java Persistence API is a specification of Java which is used to access, manage, and persist data between Java object and relational database. It is considered as a standard approach for Object Relational Mapping.JPA can be seen as a bridge between object-oriented domain models and relational database systems. Being a specification, JPA doesn't perform any operation by itself. Thus, it requires implementation. So, ORM tools like Hibernate, TopLink, and iBatis implements JPA specifications for data persistence. Hibernate is a Java framework which is used to store the Java objects in the relational database system. It is an open-source, lightweight, ORM (Object Relational Mapping) tool. Hibernate is an implementation of JPA. So, it follows the common standards provided by the JPA.
# 5.  What is Hiraki? what is the benefits of connection pool?
## HikariCP is a very fast lightweight Java connection pool. The API and overall codebase is relatively small and highly optimized. Benifits are: -Constantly opening and closing connections can be expensive. Cache and reuse. -When activity spikes you can limit the number of connections to the database. This will force code to block until a connection is available. This is especially helpful in distributed environments. -Split out common operations into multiple pools. For instance you can have a pool designated for OLAP connections and a pool for OLTP connections each with different configurations.
# 6.  What is the  @OneToMany, @ManyToOne, @ManyToMany? write some examples.
## They are JPA annotations when using Hibernate.
```
@Entity
@Table(name = "university")
public class University {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "university_id")
    private List<Student> students;
}
```
```
@Entity
@Table(name="course")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Double fee;
    @ManyToMany(mappedBy = "courses")
    private Set<Student> students;
}
```
```
@Entity
@Table(name = "student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @ManyToOne
    @JoinColumn(name = "university_id")
    private University university;
}
```
# 7.  What is the  cascade = CascadeType.ALL, orphanRemoval = true? and what are the other CascadeType and their features? In which situation we choose which one?
## The meaning of CascadeType.ALL is that the persistence will propagate (cascade) all EntityManager operations to the relating entities. Other CascadeType are PERSIST, REMOVE, REFRESH, MERGE, DETACH. orphanRemoval is an entirely ORM-specific thing. It marks child entity to be removed when it's no longer referenced from the parent entity.
# 8.  What is the  fetch = FetchType.LAZY, fetch = FetchType.EAGER? what is the difference? In which situation you choose which one?
## EAGER loading of collections means that they are fetched fully at the time their parent is fetched. So if you have Course and it has List<Student>, all the students are fetched from the database at the time the Course is fetched. LAZY on the other hand means that the contents of the List are fetched only when you try to access them. For example, by calling course.getStudents().iterator(). Calling any access method on the List will initiate a call to the database to retrieve the elements.
# 9.  What is the rule of JPA naming convention? Shall we implement the method by ourselves? Could you list some examples?
## Spring data JPA has its own naming conventions for methods. Following these conventions we can build sophisticated queries. These conventions are called also called as method name strategies. These strategies have defined set of keyword to use in method names. Based on the formed method name, method performs predefined operations.
```
Query q = em.createQuery("SELECT S FROM STUDENT S WHERE S.studentID = :studentID");
Query q = em.createQuery("SELECT S FROM STUDENT S WHERE S.studentID = :studentID");
@Entity
@Table(name = "AUTHORS")
public class Author {
    @Column(name = "author_name")
    private String name;
}
```
# 10. Try to use JPA advanced methods in your class project. In the repository layer, you need to use the naming convention to use the method provided by JPA.
##

# 1.  List all of the annotations you learned from class and homework to annotaitons.md
## annotations.md
# 2.  type the code, you need to checkout new branch from branch 02_post_RUD, name the new branch with https://github.com/TAIsRich/springboot-redbook/tree/hw05_01_slides_JPQL.
##
# 3.  What is JPQL?
## PQL is Java Persistence Query Language defined in JPA specification. It is used to create queries against entities to store in a relational database. JPQL is developed based on SQL syntax. But it won’t affect the database directly.
# 4.  What is @NamedQuery and @NamedQueries?
## A named query is a static HQL or SQL query with a fixed query string and defined either using @NamedQuery annotation or an XML file. We can refer to a named query by its name, in the runtime, when we need to execute it. Hibernate’s @NamedQuery annotation extends JPA’s @NamedQuery annotation with some additional features.
# 5.  What is @Query? In which Interface we write the sql or JPQL?
## The @Query annotation takes precedence over named queries, which are annotated with @NamedQuery or defined in an orm.xml file.
# 6.  What is HQL and Criteria Queries?
## HQL is to perform both select and non-select operations on the data, but Criteria is only for selecting the data, we cannot perform non-select operations using criteria. HQL is suitable for executing Static Queries, where as Criteria is suitable for executing Dynamic Queries.
# 7.  What is Enity Manager?
## The EntityManager is an API that manages the lifecycle of entity instances. An EntityManager object manages a set of entities that are defined by a persistence unit. Each EntityManager instance is associated with a persistence context.
# 8.  What is SessionFactory and Session?
## SessionFactory is a factory class for Session objects. It is available for the whole application while a Session is only available for particular transaction. Session is short-lived while SessionFactory objects are long-lived. SessionFactory provides a second level cache and Session provides a first level cache.
# 9.  What is Transaction? how to manage your transaction?
## Transactions refer to a series of actions that must all complete successfully. Hence, if one or more action fails, all other actions must back out leaving the state of the application unchanged. transaction command.
# 10. What is hibernate Caching?
## Hibernate caching acts as a layer between the actual database and your application. It reduces the time taken to obtain the required data — as it fetches from memory instead of directly hitting the database. It is very useful when you need to fetch the same kind of data multiple times.
# 11. What is the difference between first-level cache and second-level cache?
## The first level cache is associated with the Session Object, while the second-level cache is associated with the SessionFactory object. This means first-level cache's scope is limited to session-level while second-level cache's scope is at the application level.
# 12. How do you understand @Transactional? (不要clone，要自己抄写并测试 transactional，https://github.com/TAIsRich/tutorial-transaction)
## The @Transactional annotation is the metadata that specifies the semantics of the transactions on a method. 
# 13. Write a simple factory design pattern.
## Sfdp.java