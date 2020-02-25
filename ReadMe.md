# Exception Handling

## create custom class for handling 

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

`11_content_notFound.PNG`

## Implementing Generic Exception Handling For All Resources

```java
@ControllerAdvice /* to be applicable across all controller */
@RestController /** this is a kind of controller */
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

// handle all exception
    @ExceptionHandler(Exception.class)
    public final ResponseEntity<Object> handleAllException(Exception ex, WebRequest request){
        ExceptionResponse exceptionResponse = new ExceptionResponse(
                new Date(), ex.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

// handle notFound exception
    @ExceptionHandler(UserNotFoundException.class)
    public final ResponseEntity<Object> handleNotFoundException(UserNotFoundException ex, WebRequest request){
        ExceptionResponse exceptionResponse = new ExceptionResponse(
                new Date(), ex.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(exceptionResponse, HttpStatus.NOT_FOUND);
    }
}
```