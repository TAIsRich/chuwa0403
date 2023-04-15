# 1.
```mongodb
use test
```

# 2.
```mongodb
db.createCollection("oms_company_address")
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

# 5.
```mongodb
db.oms_company_address.find({})
```

# 6.
```mongodb
db.oms_company_address.update({ name: "address1" }, { $set: { name: "address1Update" }})
```

# 7.
```mongodb
db.oms_company_address.remove({id: 2})
```