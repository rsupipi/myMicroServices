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

