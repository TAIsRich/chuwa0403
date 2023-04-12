Q2

The annotation @Column(columnDefinition = "varchar(255) default 'John Snow'") is used to specify the details of the column "name". It tells the database to create a column of datatype varchar with a length of 255 characters, and set a default value of 'John Snow' for the column if no value is specified during insertion.

The annotation @Column(name="STUDENT_NAME", length=50, nullable=false, unique=false) is used to specify the details of the column "studentName". It tells the database to create a column with the name "STUDENT_NAME", of datatype varchar with a length of 50 characters, and to ensure that the column does not allow null values (nullable=false). Additionally, the "unique" property is set to false, which means that multiple rows in the table can have the same value for this column.

Q3

The default column names for these fields would be "firstName" and "operatingSystem" .

Q4

- Presentation Layer

The presentation layer handles the HTTP requests, translates the JSON parameter to object, and authenticates the request and transfer it to the business layer. In short, it consists of views i.e., frontend part.

- Business Layer

The business layer handles all the business logic. It consists of service classes and uses services provided by data access layers. It also performs authorization and validation.

- Persistence Layer

The persistence layer contains all the storage logic and translates business objects from and to database rows.

- Database Layer

In the database layer, CRUD (create, retrieve, update, delete) operations are performed.

Q5

Request layer -> Network layer -> Server layer -> Application layer -> Response layer -> Network layer -> Response layer.

Q6

application.properties is a plain text file that contains key-value pairs of configuration properties. These properties can be used to configure various aspects of a Spring Boot application, such as database connection settings, server port, logging configuration, and more.

On the other hand, application.yml is a YAML file format that also contains configuration properties. YAML is a human-readable data serialization format and is often easier to read and write than properties files.

