# Whitelabel Error Page
    "status": 404,
    "error": "Not Found",
`06_Error_Whitelable.PNG`

1. The Application class (eg: SpringAppApplication.java) should be at the root level, as well as the controller classes
can be placed under the same level or maybe in a subdirectory. This application class should be denoted using 
`@SpringBootApplication` or `extends SpringBootApplication`

2. You may miss @RestController annotation at top of the controller class.

3. Or can be missed the mapping annotation.( `@PostMapping("/save")` or `@GetMapping("/id")` etc.)

4. finally just check whether you are entering the correct request mapping address(URL) you may miss a slash or 
`@RequestMapping("/customer")`(if the annotation available in your controller class) or spellings error in the URL.