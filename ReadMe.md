## Annotations

```java
@RequestMapping(method = RequestMethod.GET, path = "hello")

@GetMapping("hello")
@PostMapping("user")
@DeleteMapping("user/{id}")
@PutMapping("user/{id}")
``` 

## REST project

***1. HelloWordController.java controller***
```java
@RestController
public class HelloWordController {

    //@RequestMapping(method = RequestMethod.GET, path = "hello")
    @GetMapping("hello")    /** This is short and sweet**/
    public String helloWorld(){
        return "hello pipi";
    }
}
```

***output:***
URL: http://localhost:8080/hello

hello pipi