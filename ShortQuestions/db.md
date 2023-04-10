## SQL
### 1.
```
CREATE TABLE IF NOT EXISTS oms_company_address(
    id bigint,
    address_name varchar(200),
    send_status int(1),
    receive_status int(1),
    name varchar(64),
    phone varchar(64),
    province varchar(64),
    city varchar(64),
    region varchar(64),
    detail_address varchar(200),
    PRIMARY KEY(id)
) 
```

### 2.
```
INSERT INTO oms_company_address (id, address_name, send_status, receive_status, name, phone, province, city, region, detail_address) 
VALUES (1, 'Home', 0, 1, 'Rat', '111-1111-1111', 'CA', 'Irvine', 'Orange', 'addtime');

INSERT INTO oms_company_address (id, address_name, send_status, receive_status, name, phone, province, city, region, detail_address) 
VALUES (2, 'Work', 1, 0, 'Dog', '222-222-2222', 'CA', 'KoreanTown', 'Los Angeles', 'Add');
```
### 3.
```
SELECT * FROM oms_company_address;
```

### 4.
```
SELECT * FROM oms_company_address LIMIT 3;
```

### 5.
```
UPDATE oms_company_address 
SET phone = '666-6666-8888';
```

### 6.
```
DELETE FROM oms_company_address 
WHERE id = 2;
```
## MongoDB
### 1.
```
use test
```

### 2.
```
db.createCollection("oms_company_address")
```

### 3.
```
db.oms_company_address.insertMany([
   { id: 1, address_name: "HOME", send_status: 0, receive_status: 1, name: "Rat", phone: "111-1111-1111", province: "CA", city: "Irvine", region: "Orange", detail_address: "Add" },
   { id: 2, address_name: "WORK", send_status: 1, receive_status: 0, name: "Dag", phone: "222-222-2222", province: "CA", city: "KoreanTown", region: "Los Angeles", detail_address: "ADD" }
])
```

### 4.
```
db.oms_company_address.findOne({id: 2})
```

### 5.
```
db.oms_company_address.find({})
```

### 6.
```
db.oms_company_address.update({ phone: "111-1111-1111" }, { $set: { phone: "666-6666-8888" }})
```

### 7. 
```
db.oms_company_address.remove({id: 2})
```