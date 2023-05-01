# Homework 8
## 1. 
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

## 12. 
See []().

## 13. Write a simple factory design pattern.
