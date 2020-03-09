# Filtering For RESTful Service

## 1. Static Filtering

If we want to skip some attribute in the bean we use filtering.

eg: we should remove the password field from the response.

## ignore in property level.
***
```java
public class SomeBean {
    private String id;
    private String name;

    @JsonIgnore // since this is a password we shouldn't send this with the response.
    private String password;

    // getters and setters
    
}
```
***Before ignore:***    28_Without_filtering.PNG
```json
{
    "id": "C001",
    "name": "Sama",
    "password": "sama@123"
}
```
***After ignore:***     29_With_filtering.PNG
```json
{
    "id": "C001",
    "name": "Sama"
}
```

## Bean level filtering
```java
/** This is not a good approach since we are hardcoding values */
@JsonIgnoreProperties(value = {"name"})
public class SomeBean {
    private String id;
    private String name;
}
```

output:
```json
{
    "id": "C001"
}
```