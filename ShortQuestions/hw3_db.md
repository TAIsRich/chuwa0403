# MySQL - Relational Database
## 1. Create oms_company_address table
```sql
CREATE TABLE IF NOT EXISTS oms_company_address(
    id bigint AUTO_INCREMENT PRIMARY KEY,
    address_name varchar(200),
    send_status int(1),
    receive_status int(1),
    name varchar(64),
    phone varchar(64),
    province varchar(64),
    city varchar(64),
    region varchar(64),
    detail_address varchar(200)
) ENGINE=INNODB DEFAULT CHARSET=utf8;

```
## 2. Insert some random data to oms_company_address table
```sql
INSERT INTO oms_company_address (id, address_name, send_status, receive_status, name, phone, province, city, region, detail_address) VALUES (1, 'school', 0, 1, 'antoine', '222-6666-8888', 'CA', 'LA', 'LA', 'USC');
INSERT INTO oms_company_address (id, address_name, send_status, receive_status, name, phone, province, city, region, detail_address) VALUES (2, 'irvine', 1, 0, 'tom', '555-6666-8888', 'CA', 'Irvine', 'Irvine', 'company');
```

## 3. Write a SQL query to fetch all data from oms_company_address table
```sql
SELECT * FROM oms_company_address;
```

## 4. Write a SQL query to fetch top 3 records from oms_company_address table
```sql
SELECT * FROM oms_company_address LIMIT 3;
```

## 5. Update oms_company_address table to set all phone to 666-6666-8888
```sql
UPDATE oms_company_address SET phone = '666-6666-8888';
```

## 6. Delete one entry from oms_company_address table
```sql
DELETE FROM oms_company_address WHERE id = 1;
```

# MongoDB - Non-SQL Database

## 1. Create test DB
```mongodb
use test
```

## 2. Create oms_company_address collection (method: createCollection() )
```mongodb
db.createCollection("oms_company_address")
```

## 3. Insert few random entries to oms_company_address collection (method: insert() )
```mongodb
db.oms_company_address.insertMany([
   { id: 1, address_name: "school", send_status: 0, receive_status: 1, name: "antoine", phone: "222-6666-8888", province: "CA", city: "LA", region: "LA", detail_address: "USC" },
   { id: 2, address_name: "irvine", send_status: 1, receive_status: 0, name: "tom", phone: "555-6666-8888", province: "CA", city: "Irvine", region: "Irvine", detail_address: "company" }
])
```

## 4. Read one entry from oms_company_address collection (method: find() )
```mongodb
db.oms_company_address.findOne({id: 1})
```

## 5. Read all entries from oms_company_address collection (method: find() )
```mongodb
db.oms_company_address.find({})
```

## 6. Update one entry from oms_company_address collection(method:update() or save())
```mongodb
db.oms_company_address.update({ name: "antoine" }, { $set: { name: "jerry" }})
```

## 7. Remove one entry from oms_company_address collection(method:remove())
```mongodb
db.oms_company_address.remove({id: 1})
```