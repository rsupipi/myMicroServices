# versioining

32_versioning.PNG

- 1st we need to save the name as in PersonV1.java
```java
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PersonV1 {
    private String name;
}
```

- But in later, we decided to have both first name and last name.
```java
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PersonV2 {
    private Name name;
}
```

```java
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Name {
    private String firstName;
    private String lastName;
}

```

- but the old consumers are expecting that as old way. So we have to create two methods for expose the services.

## 1. Versioning with URIs

```java
@RestController
public class PersonVersioningController {

    @GetMapping("v1/person")
    public PersonV1 personV1(){
        return new PersonV1("Ruchira Supipi");
    }

    @GetMapping("v2/person")
    public PersonV2 personV2(){
        return new PersonV2(new Name("Ruchira", "Supipi"));
    }
}
```

otput:
33_versioning_V1.PNG
34_versioning_V2.PNG

## 2. Using URI parameters

PersonVersioningController.java
```java
    @GetMapping(value = "person/param", params = "version=1")
    public PersonV1 personParamV1(){
        return new PersonV1("Ruchira Supipi");
    }

    @GetMapping(value = "person/param", params = "version=2")
    public PersonV2 personParamV2(){
        return new PersonV2(new Name("Ruchira", "Supipi"));
    }
```

output:
35_versioning_V1_URI_parameter.PNG
35_versioning_V2_URI_parameter.PNG

## 3. Using Header

PersonVersioningController.java
```java
    @GetMapping(value = "person/headers", headers = "version=1")
    public PersonV1 personHeaderV1(){
        return new PersonV1("Ruchira Supipi");
    }

    @GetMapping(value = "person/headers", headers = "version=2")
    public PersonV2 personHeaderV2(){
        return new PersonV2(new Name("Ruchira", "Supipi"));
    }
```
output:
37_versioning_V1_header.PNG
38_versioning_V2_header.PNG

## 4. Produces/ Content negotiation/ Accept Versioning

PersonVersioningController.java
```java
    @GetMapping(value = "person/produces", produces = "application/pipi.company.app-v1+json")
    public PersonV1 personProducesV1(){
        return new PersonV1("Ruchira Supipi");
    }

    @GetMapping(value = "person/produces", produces = "application/pipi.company.app-v2+json")
    public PersonV2 personProducesV2(){
        return new PersonV2(new Name("Ruchira", "Supipi"));
    }
```

- Here we are usig Accep header, So it call accept header versioning.

output:
39_versioning_V1_producer.PNG
40_versioning_V2_producer.PNG

## comparison

1. URI versioning
       eg: Twitter
       
2. Request parameter
       eg: Amazon

3. (Custom) headers versioning.
       eg: Microsoft

4. Media Type ("content negotiation" or "accept header")
       eg: github

***URI pollution***
[1] & [2] -> do so.

***Misuse of HTTP header***
[3] & [4] -> no 
because http headers are never intend for versioning.

***Caching***
[3] & [4] -> Can't cache the request, because they use same URI.
but in the [1] & [2]-> can
 
***Executing request on the browser***
[3] & [4] -> can't execute in normal browser.
 The user should have some technical knowledge and need to install
some browser plugins.

***API documentation***
[1] & [2] -> easy generating documentation

* So no perfect solution.