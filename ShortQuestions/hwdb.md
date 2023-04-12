# 1.  Create  oms_company_address  table
``` 
CREATE TABLE oms_company_address (
	id integer,
    address_name varchar(200),
    send_status integer(1),
  	receive_status integer(1),
    name varchar(64),
    phone varchar(64),
  	city varchar(64),
    region varchar(64),
  	detail_address varchar(64)
);
```
# 2.  Insert some random data to  oms_company_address  table
```
INSERT INTO oms_company_address VALUES (1124, 'CIGO', 1, 0, 'Ann', '555-4646-4374', 'NewYork', 'USA', 'oahoihyqwohro' );
INSERT INTO oms_company_address VALUES (1924, 'SKOL', 1, 1, 'Amy', '375-6485-9078', 'London', 'UK', 'gqreahrqyt4qw');
INSERT INTO oms_company_address VALUES (1175, 'WRHO', 0, 0, 'Jay', '157-8676-45045', 'Xian', 'China', 'oahoihydfsfbsdgqwohro');
INSERT INTO oms_company_address VALUES (1457, 'WBIOF', 0, 0, 'Lee', '786-4378-1373', 'Miami', 'USA', 'wetqtrq');
INSERT INTO oms_company_address VALUES (1452, 'VUIGFI', 1, 0, 'Koi', '672-7846-3879', 'Tokyo', 'Japan', 'wetwetwet');
```
# 3.  Write a SQL query to fetch all data from  oms_company_address  `table
```
SELECT * FROM oms_company_address;
```
# 4.  Write a SQL query to fetch top 3 records from  oms_company_address  table
```
SELECT *from oms_company_address limit 0,3;
```
# 5.  Update  oms_company_address  table to set all  phone to 666-6666-8888
```
UPDATE oms_company_address 
SET phone = '666-6666-8888' ;
```
# 6.  Delete one entry from  oms_company_address  table
```
DELETE FROM oms_company_address WHERE id = 1124;
```
# 7.  (Optional) You can also try to create other tables that listed above
```
CREATE TABLE oms_order_return_reason  (
	id bigint primary key,
    name varchar(200),
    sort integer(1),
  	status integer(1),
    create_time datetime,
);
```

# 1.  Create  test DB
```
use test
```
# 2.  Create  oms_company_address  collection  (method: createCollection() )
```
db.createCollection("oms_company_address")
```
# 3.  Insert few random entries to  oms_company_address  collection (method: insert() )
```
db.users.insertMany([
   {id : 1124,address_name : 'CIGO',send_status : 1,receive_status : 0,name : 'Ann',phone : '55546464374',city : 'NewYork',region : 'USA',detail_address : 'oahoihyqwohro'},
   {id : 1924,address_name : 'SKOL',send_status : 1,receive_status : 1,name : 'Amy',phone : '37564859078',city : 'London',region : 'UK',detail_address : 'gqreahrqyt4qw'},
   {id : 1175,address_name : 'WRHO',send_status : 0,receive_status : 0,name : 'Jay',phone : '157867645045',city : 'Xian',region : 'China',detail_address : 'oahoihydfsfbsdgqwohro'},
   {id : 1457,address_name : 'WBIOF',send_status : 0,receive_status : 0,name : 'Lee',phone : '78643781373',city : 'Miami',region : 'USA',detail_address : 'wetqtrq'},
   {id : 1452,address_name : 'VUIGFI',send_status : 1,receive_status : 0,name : 'Koi',phone : '67278463879',city : 'Tokyo',region : 'Japan',detail_address : 'wetwetwet'}
])
```
# 4.  Read one entry from  oms_company_address  collection (method: find() )
```
db.users.find({id: 1175});
```
# 5.  Read all entries from  oms_company_address  collection (method: find() )
```
db.users.find()
```
# 6.  Update one entry from  oms_company_address collection (method: update() or save() )
```
db.users.updateOne( { id: 1175 }, { $set: { phone: '45615684789' } } ) 
```
# 7.  Remove one entry from  oms_company_address collection (method: remove() )
```
db.users.remove({id: 1175});
```
# 8.  (Optional) You can also try to create other tables that listed above
```
db.createCollection('oms_order_return_reason ')
db.users.insertMany([
   {id : 1124, name : 'CIGO', sort : 1, status : 0, name : 'Ann', create_time : ISODate("2022-05-04T12:00:53.307Z")},
])
```