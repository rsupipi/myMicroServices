# Validation

***UserController.java***
```java
    @PostMapping("/users3")
    public ResponseEntity<Object> createUser3(@Valid @RequestBody User user) {
        User savedUser = userService.save(user);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(savedUser.getId()).toUri();
        return ResponseEntity.created(location).build();
    }
```

***User.java***
```java
public class User {
    private int id;

    @Size(min = 2) // validate the size for 2 letters
    private String name;

    @Past // validate this should be a past date
    private Date birthDate;
}
```

***output :***
12_validation.PNG
status: 400 Bad request

## custom validation

***CustomizedResponseEntityExceptionHandler.java***
```java
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
            HttpHeaders headers, HttpStatus status, WebRequest request) {
//        ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), ex.getMessage(),
//                ex.getBindingResult().toString());

        ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), "Validation Faild",
                ex.getBindingResult().toString());

        return new ResponseEntity<>(exceptionResponse, HttpStatus.BAD_REQUEST);
    }
```

******
```java
    @PostMapping("/users3")
    public ResponseEntity<Object> createUser3(@Valid @RequestBody User user) {
        User savedUser = userService.save(user);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(savedUser.getId()).toUri();
        return ResponseEntity.created(location).build();
    }
```

```java
public class User {
    private int id;

    @Size(min = 2 , message = "Name should have at least 2 char") // validate the size for 2 letters
    private String name;

    @Past // validate this should be a past date
    private Date birthDate;
}
```