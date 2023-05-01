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
An entitymanager manages connection to a database as well as to database operations. EntityManager is associated with a PersistentContext

## 8. What is SessionFactory and Session?

## 9. What is Transaction? how to manage your transaction?

## 10. What is hibernate Caching?

## 11. What is the difference between first-level cache and second-level cache?

## 12. 
See []().

## 13. Write a simple factory design pattern.
