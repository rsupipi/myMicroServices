#  Internationalization

***create 2 property files***

*message.properties*
```properties
good.morning.message=good Morming
```
*message_lk.properties*
```properties
good.morning.message=Ayubowan
```

- we can create class for each language. and add each propreties according to the language.

***MyMicroServicesApplication.java***
```java
@Bean
	public LocaleResolver localeResolver(){
		SessionLocaleResolver localeResolver = new SessionLocaleResolver();
		localeResolver.setDefaultLocale(Locale.US);
		return localeResolver;
	}

	@Bean
	public ResourceBundleMessageSource messageSource() {
		ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
		messageSource.setBasename("message");
		return messageSource;
	}
```

***HelloWordController.java***
```java
@RestController
@ResponseBody
public class HelloWordController {

    @Autowired
    private MessageSource messageSource;
    
    // Internalization =================================================
        @GetMapping("/hello-internalization")
        public String heollInternalization(@RequestHeader(name = "Accept-Language", required = false) Locale locale) {
          // return "good morning";
             return messageSource.getMessage("good.morning.message", null, locale);
        }
                
```

***output:***
the output will be displayed accorng to the language

## Localecontext holder

Advantage of this is, we do not need send in request parameter.

***HelloWordController.java***
```java
/** According to this we have to add locale in every request. Since it is is painful to use, we can use
     * LocalContextHolder instead of this.
     * */
    @GetMapping("/hello-internalization2")
    public String heollInternalization() {
        return messageSource.getMessage("good.morning.message", null, LocaleContextHolder.getLocale());
    }
```

***MyMicroServicesApplication.java***
```java
	/** locale with Locale Resolver*/
	@Bean
	public LocaleResolver localeResolver(){
//		SessionLocaleResolver localeResolver = new SessionLocaleResolver(); // remove
		AcceptHeaderLocaleResolver localeResolver = new AcceptHeaderLocaleResolver(); // add
		localeResolver.setDefaultLocale(Locale.US);
		return localeResolver;
	}

//	We can remove this and move the configuration to application.properties.
//	@Bean
//	public ResourceBundleMessageSource messageSource() {
//		ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
//		messageSource.setBasename("message");
//		return messageSource;
//	}
```

***application.properties***
```properties
spring.messages.basename=message
```

***output***

15_Internalization_AccepetHeader_default.PNG
16_Internalization_AccepetHeader_lk.PNG

