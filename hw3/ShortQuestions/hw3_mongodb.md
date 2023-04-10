# 1.
```mongodb
use test
```

# 2.
```mongodb
use test
```

# 3.
```mongodb
db.oms_company_address.insertMany([
   { id: 1, address_name: "address1", send_status: 1, receive_status: 1, name: "name1", phone: "111-222-3333", province: "ab", city: "city1", region: "region1", detail_address: "xxxxxxx" },
   { id: 2, address_name: "address2", send_status: 1, receive_status: 0, name: "name2", phone: "222-333-4444", province: "cd", city: "city2", region: "region2", detail_address: "xxxxxxx" }
])
```

# 4.
```mongodb
db.oms_company_address.findOne({id: 2})
```

#5. 