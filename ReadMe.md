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
URL: http://localhost:8080/hello

***output:***
```json
hi pipi
```

## Returen bean

```java
    @GetMapping("hello-bean")
    public Message helloBean(){
        return new Message("hi pipi");
    }
```

* getters and setters should be define of the bean.

URL: http://localhost:8080/hello-bean

***output:***
```json
{
    "myMessage": "hi pipi"
}
```


## Add path variables

```java
    @GetMapping("hello/user/{name}")
    public Message helloPathVariable(@PathVariable String name){
        return new Message(String.format("Hello %s", name));
    }
```

* getters and setters should be define of the bean.

URL: http://localhost:8080/hello-bean

***output:***
```json
{
    "myMessage": "Hello RuchiraSupipi"
}
```

