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


