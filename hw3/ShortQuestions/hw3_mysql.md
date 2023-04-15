# 1.
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
) ENGINE=INNODB DEFAULT CHARSET=utf8mb4;
```

# 2.
```sql
INSERT INTO oms_company_address (id, address_name, send_status, receive_status, name, phone, province, city, region, detail_address) VALUES (1, 'address1', 0, 1, 'test1', '111-222-3333', 'AZ', 'Tempe', 'region1', 'degtafasfda');
INSERT INTO oms_company_address (id, address_name, send_status, receive_status, name, phone, province, city, region, detail_address) VALUES (2, 'address2', 1, 1, 'test2', '222-333-4444', 'CA', 'San Jose', 'region2', 'safasdf');
```

# 3. 
```sql
SELECT * FROM oms_company_address;
```

# 4.
```sql
SELECT * FROM oms_company_address LIMIT 3;
```

# 5.
```sql
UPDATE oms_company_address SET phone = '666-6666-8888';
```

# 6.
```sql
DELETE FROM oms_company_address WHERE id = 2;
```

# 7.
