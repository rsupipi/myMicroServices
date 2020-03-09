# Filtering For RESTful Service

## 1. Static Filtering

If we want to skip some attribute in the bean we use filtering.

eg: we should remove the password field from the response.

```java
@RestController
public class FilteringContorller {
    @GetMapping("/filtering")
    public SomeBean retriveSomeBean1() {
        return new SomeBean("C001", "Sama", "sama@123");
    }

    @GetMapping("/filtering-list")
    public List<SomeBean> retriveSomeBeanList1() {
        return Arrays.asList(
                new SomeBean("C001", "Sama", "sama@123"),
                new SomeBean("C002", "Mala", "mala@123"));
    }
}
```

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


## 2. Dynamic Filtering

***Controller.class***
```java
@RestController
public class FilteringContorller {
/** Filter the response according to the method*/

 // send only id , name
    @GetMapping("/filtering2")
    public MappingJacksonValue retriveSomeBean2() {
        SomeBean2 someBean2 = new SomeBean2("C001", "Sama", "sama@123");

        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("id", "name");
        FilterProvider filterProvider = new SimpleFilterProvider().addFilter("SomeBeanFilter", filter);

        MappingJacksonValue mappingValue = new MappingJacksonValue(someBean2);
        mappingValue.setFilters(filterProvider);

        return mappingValue;
    }

    // send only name, password
    @GetMapping("/filtering-list2")
    public MappingJacksonValue retriveSomeBeanList2() {

        List<SomeBean2> someBeanList = Arrays.asList(
                new SomeBean2("C001", "Sama", "sama@123"),
                new SomeBean2("C002", "Mala", "mala@123"));

        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("name", "password");
        FilterProvider filterProvider = new SimpleFilterProvider().addFilter("SomeBeanFilter", filter);

        MappingJacksonValue mappingValue = new MappingJacksonValue(someBeanList);
        mappingValue.setFilters(filterProvider);

        return mappingValue;
    }

}
```

***bean class***
```java
@JsonFilter("SomeBeanFilter")// add filter to the bean.
public class SomeBean2 {
    private String id;
    private String name;
    private String password;

}
```

***output***
30_filtering_dynamic.PNG
31_filtering_dynamic.PNG

Step 26 - Versioning RESTful Services - Basic Approach with URIs
VIDEO
