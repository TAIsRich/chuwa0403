# MySQL

## 1.  Create  oms_company_address  table
```mysql
CREATE TABLE oms_company_address (
    id BIGINT NOT NULL AUTO_INCREMENT,
    address_name VARCHAR(200),
    send_status  INT1,
    receive_status  INT1,
    name VARCHAR(64),
    phone VARCHAR(64),
    province VARCHAR(64),
    city VARCHAR(64),
    region VARCHAR(64),
    detail_address VARCHAR(200),
    PRIMARY KEY (id)
);
```

## 2.  Insert some random data to  oms_company_address  table
```mysql
INSERT INTO oms_company_address (address_name, send_status, receive_status, name, phone, province, city, region, detail_address)
VALUES
('Home', 1, 1, 'John Doe', '1234567890', 'California', 'Los Angeles', 'Beverly Hills', '123 Main Street'),
('Work', 0, 1, 'Jane Smith', '0987654321', 'New York', 'New York City', 'Manhattan', '456 Park Avenue'),
('Office', 1, 0, 'Bob Johnson', '5554443333', 'Texas', 'Houston', 'Downtown', '789 Business Road');
```

## 3.  Write a SQL query to fetch all data from  oms_company_address  `table
```mysql
SELECT * FROM oms_company_address;
```

## 4.  Write a SQL query to fetch top 3 records from  oms_company_address  table
```mysql
SELECT * FROM oms_company_address LIMIT 3;
```

## 5.  Update  oms_company_address  table to set all  phone to 666-6666-8888
```mysql
UPDATE oms_company_address
SET phone = '666-6666-8888';
```

## 6.  Delete one entry from  oms_company_address  table
```mysql
DELETE FROM oms_company_address WHERE id = 1;
```

## 7.  (Optional) You can also try to create other tables that listed above

# MongoDB

## 1.  Create  test DB
1. Open the MongoDB shell using the command mongo in your terminal.
2. Switch to the default test database by running the command use test.
3. Create a collection (table) in the test database using the db.createCollection() method. For example, db.createCollection("users") creates a collection named users in the test database.

## 2.  Create  oms_company_address  collection  (method: createCollection() )
```mongodb-json
test.createCollection("oms_company_address", {
   validator: { $jsonSchema: {
      bsonType: "object",
      required: [ "id", "address_name", "send_status", "receive_status", "name", "phone", "province", "city", "region", "detail_address" ],
      properties: {
         id: {
            bsonType: "int",
            description: "must be an integer and is required"
         },
         address_name: {
            bsonType: "string",
            description: "must be a string and is required"
         },
         send_status: {
            bsonType: "int",
            description: "must be an integer and is required"
         },
         receive_status: {
            bsonType: "int",
            description: "must be an integer and is required"
         },
         name: {
            bsonType: "string",
            description: "must be a string and is required"
         },
         phone: {
            bsonType: "string",
            description: "must be a string and is required"
         },
         province: {
            bsonType: "string",
            description: "must be a string and is required"
         },
         city: {
            bsonType: "string",
            description: "must be a string and is required"
         },
         region: {
            bsonType: "string",
            description: "must be a string and is required"
         },
         detail_address: {
            bsonType: "string",
            description: "must be a string and is required"
         }
      }
   }},
   validationLevel: "strict",
   validationAction: "error"
})

```

## 3.  Insert few random entries to  oms_company_address  collection (method: insert() )
```mongodb-json
db.oms_company_address.insert({
    id: 1,
    address_name: "Home",
    send_status: 1,
    receive_status: 0,
    name: "John Doe",
    phone: "123-456-7890",
    province: "California",
    city: "Los Angeles",
    region: "Downtown",
    detail_address: "123 Main St"
})
```

## 4.  Read one entry from  oms_company_address  collection (method: find() )
```mongodb-json
db.oms_company_address.findOne({id: 1})
```

## 5.  Read all entries from  oms_company_address  collection (method: find() )
```mongodb-json
db.oms_company_address.find({})
```

## 6.  Update one entry from  oms_company_address collection (method: update() or save() )
```mongodb-json
db.oms_company_address.update(
   { _id: ObjectId("6150762b8871f9c539005230") },
   {
     $set: {
       phone: "777-7777-7777",
       address_name: "New Address"
     }
   }
)
```

## 7.  Remove one entry from  oms_company_address collection (method: remove() )
```mongodb-json
db.oms_company_address.remove({id: 1})
```
