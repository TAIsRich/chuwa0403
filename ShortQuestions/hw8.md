## Part 1
### 1. List all of the annotations you learned from class and homework to annotaitons.md
Please see annotations.md
### 2. Type the Comment feature for the class project.
### 3. In postman, call of the APIs in PostController and CommentController.

### 4. what is JPA? and what is Hibernate?
JPA (Java Persistence API) is a java specification of object-relational mapping (ORM) frameworks. JPA provides a standard API for mapping Java objects to relational database tables. Hibernate is an ORM framework that implements the JPA specification. It is widely used with the Spring Framework.

### 5. What is Hiraki? what is the benefits of connection pool?
Hikari is a high-performance connection pool using JDBC for Java applications. Connection pooling is a technique used to optimize the usage of database connections by reusing existing connections instead of creating new ones for every database interaction.
Benefits of connection pool: Improved performance, Scalability, Better resource management, Better connection management.

### 6. What is the @OneToMany, @ManyToOne, @ManyToMany? write some examples.
@OneToMany defines a one-to-many relationship between two entities.
@ManyToOne defines a many-to-one relationship between two entities.
```
@Entity
public class Post {
    @Id
    private long id;
    
    @OneToMany(mappedBy = "post")
    private Set<Comment> comments;
}

@Entity
public class Comments {
    @Id
    private long id;

    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;
}
```

@ManyToMany defines a many-to-many relationship between two entities.
```
@Entity
public class User {
    @Id
    private Long id;
    
    @ManyToMany(mappedBy = "users")
    private List<Role> roles;
}

@Entity
public class Role {
    @Id
    private Long id;
    
    @ManyToMany
    @JoinTable(
        name = "user_role",
        joinColumns = @JoinColumn(name = "role_id"),
        inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private List<User> users;
}
```

### 7. What is the cascade = CascadeType.ALL, orphanRemoval = true? and what are the other CascadeType and their features? In which situation we choose which one?
cascade = CascadeType.ALL means all cascade operations on owning entity will be applied to related entity. orphanRemoval = true means once the parent entity is removed, the children entities that are no longer associated with the parent entity will be removed. An orphaned entity is an entity that is not referenced by any other entities in the database.
CascadeType.PERSIST: Use this when you want to ensure that related entities are persisted along with the main entity.
CascadeType.MERGE: Use this when you want to ensure that changes to related entities are merged when the main entity is updated.
CascadeType.REMOVE: Use this when you want to ensure that related entities are removed along with the main entity. 
CascadeType.REFRESH: Use this when you want to ensure that related entities are refreshed along with the main entity. 
CascadeType.DETACH: Use this when you want to ensure that related entities are detached along with the main entity.

### 8. What is the fetch = FetchType.LAZY, fetch = FetchType.EAGER? what is the difference? In which situation you choose which one?
FetchType.LAZY and FetchType.EAGER are two options to decide how associated entities should be loaded when loading an entity with JPA. By default, eager loading is for ManyToOne or OneToOne relationships; lazy loading is for OneToMany or ManyToMany relationships.

| Fetch Type | When to use |
| --- | --- |
| FetchType.LAZY | When the associated entities are not always needed, or when they are only needed in specific cases. The associated entity is not loaded from the database until you actually access its properties. |
| FetchType.Eager | When the associated entities are always needed, or when they are needed in the majority of cases. The associated entity is immediately loaded from the database along with the main entity. |

### 9. What is the rule of JPA naming convention? Shall we implement the method by ourselves? Could you list some examples?
We don't need to implement the method by ourselves. JPA provides default method implementations for basic CRUD operations (Create, Read, Update, Delete) through the EntityManager interface. 
Examples:
| SQL Keyword | Example | SQL Script |
| --- | --- | --- |
| And | findByLastNameAndFirstName(a, b) | Where last name = a and first name = b |
| Or | findByLastNameOrFirstName(a, b) | Where last name = a or first name = b |
| In | findByAgeIn(a[ ]) | Where age in a[ ] |
| IsNull | findByAgeIsNull() | Where age is null |

### 10. Try to use JPA advanced methods in your class project. In the repository layer, you need to use the naming convention to use the method provided by JPA.

### 11. (Optional) Check out a new branch(https://github.com/TAIsRich/springboot-redbook/tree/hw02_01_jdbcTemplate) from branch 02_post_RUD, replace the dao layer using JdbcTemplate.

### 12. (Optional) use JDBC to read the data from database.

## Part 2
### 1. List all of the annotations you learned from class and homework to annotaitons.md
Please see annotations.md

### 2. type the code, you need to checkout new branch from branch 02_post_RUD, name the new branch with https://github.com/TAIsRich/springboot-redbook/tree/hw05_01_slides_JPQL.

### 3. What is JPQL?
JPQL (Java Persistence Query Language) is a query language used to retrieve data from databases using JPA. Instead of SQL operating directly on tables and columns, JPQL operates on entities and their properties. 

### 4. What is @NamedQuery and @NamedQueries?
@NamedQuery and @NamedQueries are annotations used in JPA to define named queries. @NamedQuery is used to define a single named query. @NamedQueries is used to define multiple named queries. It takes an array of @NamedQuery annotations as its value.
```
@Entity
@NamedQueries({
    @NamedQuery(name = "Employee.findByLastName",
        query = "SELECT e FROM Employee e WHERE e.lastName = :lastName"),
    @NamedQuery(name = "Employee.findAll",
        query = "SELECT e FROM Employee e")
})
```

### 5. What is @Query? In which Interface we write the sql or JPQL?
@Query is a JPA annotation that allows developers to define custom queries with JPQL, SQL in repository interface.
```
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

### 6. What is HQL and Criteria Queries?
HQL (Hibernate Query Language) is a query language using Hibernate. HQL is similar to SQL in syntax, but it operates on Hibernate's object model rather than on the database tables directly.

### 7. What is EnityManager?
EntityManager is the primary interface in the JPA that provides the mechanism for managing entities in a persistence context. It provides methods of CRUD (Create, Read, Update, Delete) operations on entities, as well as managing transactions, caching, and query execution.

### 8. What is SessionFactory and Session?
SessionFactory and Session are classes in Hibernate that are used to create and manage database connections and transactions.
SessionFactory is a heavyweight, thread-safe and immutable factory for creating Session instances. It is typically created at application startup and shared throughout the application. The SessionFactory is responsible for initializing Hibernate configuration settings, creating database connections, and managing the mapping between Hibernate entities and database tables.
Session is a lightweight, non-thread-safe object that represents a single unit of work with the database. It provides methods for CRUD operations, as well as for querying the database using Hibernate Query Language (HQL) or Criteria API.

### 9. What is Transaction? how to manage your transaction?
A transaction is a single unit of work consists of one or more database operations. If one operation in the transaction fails, the entire transaction must be rolled back to its previous state, leaving the database in its original state.

### 10. What is hibernate Caching?
Hibernate caching is a mechanism that allows frequently accessed data to be stored temporarily in memory, reducing the numbers of database queries required to retrieve data from the database repeatedly. It can greatly improve application performance by reducing the amount of time required to access data from the database.

### 11. What is the difference between first-level cache and second-level cache?
First-level cache: is associated with a specific Hibernate Session. It stores entities that have been retrieved from the database during the current Session. When an entity is accessed again within the same Session, Hibernate checks the first-level cache first before hitting the database again.
Second-level cache: is shared by all Sessions within a Hibernate SessionFactory. It stores entities that have been retrieved from the database by any Session in the SessionFactory.
When an entity is accessed again by any Session within the SessionFactory, if it is already present in the first-level cache, it is returned from there, if not found in the first-level cache, Hibernate checks the second-level cache first before hitting the database again.

### 12. How do you understand @Transactional? (不要clone，要⾃⼰抄写并测试transactional，https://github.com/TAIsRich/tutorial-transaction)

### 13. Write a simple factory design pattern.
```
public interface Vehicle {
    void drive();
}

public class Car implements Vehicle {
    @Override
    public void drive() {
        System.out.println("Driving a car...");
    }
}

public class Truck implements Vehicle {
    @Override
    public void drive() {
        System.out.println("Driving a truck...");
    }
}

public class VehicleFactory {
    public static Vehicle createVehicle(String type) {
        if (type.equalsIgnoreCase("car")) {
            return new Car();
        } else if (type.equalsIgnoreCase("truck")) {
            return new Truck();
        } else {
            throw new IllegalArgumentException("Invalid vehicle type: " + type);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Vehicle car = VehicleFactory.createVehicle("car");
        car.drive();

        Vehicle truck = VehicleFactory.createVehicle("truck");
        truck.drive();
    }
}

```