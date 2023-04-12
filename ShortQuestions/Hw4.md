# Homework 4
## 1. 
See [annotations.md](./annotations.md)

## 2. 
```
@Column(columnDefinition = "varchar(255) default 'John Snow'")
private String name;
```
Create a default value "John Snow" for name. The name should fit in char array of length 255.

```
@Column(name="STUDENT_NAME", length=50, nullable=false, unique=false)
private String studentName;
```
The column name is STUDENT_NAME, element length is 50, element cannot be nullable and it is not unique;

## 3. 
