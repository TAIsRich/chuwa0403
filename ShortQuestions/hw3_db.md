# 1. MySQL - Relational Database
## 1. Create oms_company_address table
```
CREATE TABLE IF NOT EXISTS oms_company_address(
id bigint AUTO_INCREMENT PRIMARY KEY,
address_name varchar(200),
send_status  int(1),
receive_status  int(1),
name varchar(64),
phone varchar(64),
province varchar(64),
city varchar(64),
region varchar(64),
detail_address varchar(200)
) 
```

## 2. Insert some random data to oms_company_address table
```
INSERT INTO oms_company_address (address_name, send_status, receive_status, name, phone, province, city, region, detail_address)
VALUES ('home', 0, 0, 'tom', '13311322111', 'BEJ', 'BEJ', 'HD', 'Some Addr');
```

## 3. Write a SQL query to fetch all data from oms_company_address `table
`SELECT * FROM oms_company_address;`

## 4. Write a SQL query to fetch top 3 records from oms_company_address table 
`SELECT * FROM oms_company_address LIMIT 3;`


## 5. Update oms_company_address table to set all phone to 666-6666-8888
`UPDATE oms_company_address set phone = '666-6666-8888';`

## 6. Delete one entry from oms_company_address table
`DELETE FROM oms_company_address WHERE id=1;`

## 7. (Optional)You can also try to create other tables that listed above

# 2. MongoDB - Non-SQL Database
## 1. Create testDB
```
test > use hw3Company
switched to db hw3Company
```

## 2. Create oms_company_address collection (method: createCollection() )
```
hw3Company > db.createCollection("oms_company_address")
{ ok: 1 }
```

## 3. Insert few random entries to oms_company_address collection (method: insert() )
```
db.oms_company_address.insertOne({
  address_name: 'company', 
  send_status: 1, 
  receive_status: 0, 
  name: 'Alice', 
  phone:  '919-567-899', 
  address: {
    province: 'Tokyo', 
    city: 'Tokyo', 
    region: 'TK', 
    detail_address: "Asada Mesh Co., Ltd. Hideaki HAYASHI"
  }
})

```

## 4. Read one entry from oms_company_address collection (method: find() )
```
hw3Company > db.oms_company_address.findOne({name: "Alice"})
{
  _id: ObjectId("64332dad26441b9cb06ca0ca"),
  address_name: 'company',
  send_status: 1,
  receive_status: 0,
  name: 'Alice',
  phone: '919-567-899',
  address: {
    province: 'Tokyo', 
    city: 'Tokyo', 
    region: 'TK', 
    detail_address: "Asada Mesh Co., Ltd. Hideaki HAYASHI"
  }
}
```

## 5. Read all entries from oms_company_address collection (method: find() )
`hw3Company > db.oms_company_address.find()`

## 6. Update one entry from oms_company_address collection(method:update()or save()) 
```
hw3Company > db.oms_company_address.updateMany({name:  "Alice"}, {$set: {name: "Alice"}})
{
acknowledged: true,
insertedId: null,
matchedCount: 0,
modifiedCount: 0,
upsertedCount: 0
}
```

## 7. Remove one entry from oms_company_address collection(method:remove())
```
hw3Company > db.oms_company_address.deleteOne({name: "Alice"})
{ acknowledged: true, deletedCount: 1 }
```


## 8. (Optional)You can also try to create other tables that listed above