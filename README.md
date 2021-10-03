# mysql-json
spring data with mysql support json datatype

This example allow u to save a whole json content( no type definition yet) to mysql database under mysql JSON datatype, instead of using varchar(255)

# Requirement

You must have runnable mysql database, gradle and java 11.
Go to application.properties to apply proper data source configuration.

# Use

You can construct Post request to create car with metadata as json content

POST localhost:8080/cars

```
  {
    "name":"huydai",
    "metadata": {
        "name": "khanh"
    }
  }
```

And deserialized way can be tested with `GET localhost:8080/cars`
