## Bean and Services

```java
@RestController
public class UserController {

    @Autowired
    private UserDaoService userService;

    // get all ==================================================
    @GetMapping("/users")
    public List<User> retrieveAllUsers() {
        return userService.findAll();
    }

    // get by ID ==================================================
    @GetMapping("/users1/{id}")
    public User retrieveUser1(@PathVariable int id) {
        return userService.findOne(id);
    }

    @GetMapping("/users2/{id}")
    public User retrieveUser2(@PathVariable int id) {
        User user = userService.findOne(id);
        if (user == null) {
            throw new UserNotFoundException("id - " + id);
        }
        return user;
    }

    // save  ==================================================
    @PostMapping("/users1")
    public User createUser1(@RequestBody User user) {
        return userService.save(user);
    }

    /**
     * returning status code and Location URI
     **/
    @PostMapping("/users2")
    public ResponseEntity<Object> createUser2(@RequestBody User user) {
        User savedUser = userService.save(user);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(savedUser.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

    // delete ==================================================


}
```

URL: GET -> http://localhost:8080/users/2

Response:
```json
{
    "id": 2,
    "name": "mala",
    "birthDate": "2020-02-24T05:17:50.850+0000"
}
```

URL: GET -> http://localhost:8080/users

Response:
```json
[
    {
        "id": 1,
        "name": "sama",
        "birthDate": "2020-02-24T05:17:50.850+0000"
    },
    {
        "id": 2,
        "name": "mala",
        "birthDate": "2020-02-24T05:17:50.850+0000"
    },
    {
        "id": 3,
        "name": "amara",
        "birthDate": "2020-02-24T05:17:50.850+0000"
    }
]
```

URL: POST -> http://localhost:8080/users
Request:
```json
{
    "id": 0,
    "name": "kamala",
    "birthDate": "2000-02-24T05:17:50.850+0000"
}
```
09_PostCreateNewUser.PNG

Response:
```json
{
    "id": 4,
    "name": "kamala",
    "birthDate": "2000-02-24T05:17:50.850+0000"
}
```

* with status code:
10_PostCreateNewUser_statusCode.PNG

# Exception Handling

***Exception***
```java
/** Returning the Status code */
@ResponseStatus(HttpStatus.NO_CONTENT)
public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(String message) {
        super(message);
    }
}
```

***Controller***
```java
    @GetMapping("/users2/{id}")
    public User retrieveUser2(@PathVariable int id) {
        User user = userService.findOne(id);
        if (user == null) {
            throw new UserNotFoundException("id - " + id);
        }
        return user;
    }
```