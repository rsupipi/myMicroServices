Console log

```properties
2020-03-16 13:55:06.786  INFO 9788 --- [  restartedMain] o.s.b.devtools.restart.ChangeableUrls    : The Class-Path manifest attribute in C:\Users\Ruchira.Supipi\.m2\repository\org\glassfish\jaxb\jaxb-runtime\2.3.2\jaxb-runtime-2.3.2.jar referenced one or more files that do not exist: file:/C:/Users/Ruchira.Supipi/.m2/repository/org/glassfish/jaxb/jaxb-runtime/2.3.2/jakarta.xml.bind-api-2.3.2.jar,file:/C:/Users/Ruchira.Supipi/.m2/repository/org/glassfish/jaxb/jaxb-runtime/2.3.2/txw2-2.3.2.jar,file:/C:/Users/Ruchira.Supipi/.m2/repository/org/glassfish/jaxb/jaxb-runtime/2.3.2/istack-commons-runtime-3.0.8.jar,file:/C:/Users/Ruchira.Supipi/.m2/repository/org/glassfish/jaxb/jaxb-runtime/2.3.2/stax-ex-1.8.1.jar,file:/C:/Users/Ruchira.Supipi/.m2/repository/org/glassfish/jaxb/jaxb-runtime/2.3.2/FastInfoset-1.2.16.jar,file:/C:/Users/Ruchira.Supipi/.m2/repository/org/glassfish/jaxb/jaxb-runtime/2.3.2/jakarta.activation-api-1.2.1.jar
2020-03-16 13:55:06.791  INFO 9788 --- [  restartedMain] .e.DevToolsPropertyDefaultsPostProcessor : Devtools property defaults active! Set 'spring.devtools.add-properties' to 'false' to disable

  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/
 :: Spring Boot ::        (v2.2.4.RELEASE)

2020-03-16 13:55:09.652  INFO 9788 --- [  restartedMain] c.c.c.ConfigServicePropertySourceLocator : Fetching config from server at : http://localhost:8888
2020-03-16 13:55:11.189  INFO 9788 --- [  restartedMain] c.c.c.ConfigServicePropertySourceLocator : Connect Timeout Exception on Url - http://localhost:8888. Will be trying the next url if available
2020-03-16 13:55:11.191  WARN 9788 --- [  restartedMain] c.c.c.ConfigServicePropertySourceLocator : Could not locate PropertySource: I/O error on GET request for "http://localhost:8888/application/default": Connection refused: connect; nested exception is java.net.ConnectException: Connection refused: connect
2020-03-16 13:55:11.194  INFO 9788 --- [  restartedMain] com.pipi.MyMicroServicesApplication      : No active profile set, falling back to default profiles: default
2020-03-16 13:55:13.097  INFO 9788 --- [  restartedMain] .s.d.r.c.RepositoryConfigurationDelegate : Bootstrapping Spring Data JPA repositories in DEFAULT mode.
2020-03-16 13:55:13.134  INFO 9788 --- [  restartedMain] .s.d.r.c.RepositoryConfigurationDelegate : Finished Spring Data repository scanning in 23ms. Found 0 JPA repository interfaces.
2020-03-16 13:55:13.173 ERROR 9788 --- [  restartedMain] o.s.boot.SpringApplication               : Application run failed

java.lang.IllegalStateException: Error processing condition on org.springframework.boot.autoconfigure.data.web.SpringDataWebAutoConfiguration.pageableCustomizer
	at org.springframework.boot.autoconfigure.condition.SpringBootCondition.matches(SpringBootCondition.java:60) ~[spring-boot-autoconfigure-2.2.4.RELEASE.jar:2.2.4.RELEASE]
	at org.springframework.context.annotation.ConditionEvaluator.shouldSkip(ConditionEvaluator.java:108) ~[spring-context-5.2.3.RELEASE.jar:5.2.3.RELEASE]
	at org.springframework.context.annotation.ConfigurationClassBeanDefinitionReader.loadBeanDefinitionsForBeanMethod(ConfigurationClassBeanDefinitionReader.java:184) ~[spring-context-5.2.3.RELEASE.jar:5.2.3.RELEASE]
	at org.springframework.context.annotation.ConfigurationClassBeanDefinitionReader.loadBeanDefinitionsForConfigurationClass(ConfigurationClassBeanDefinitionReader.java:144) ~[spring-context-5.2.3.RELEASE.jar:5.2.3.RELEASE]
	at org.springframework.context.annotation.ConfigurationClassBeanDefinitionReader.loadBeanDefinitions(ConfigurationClassBeanDefinitionReader.java:120) ~[spring-context-5.2.3.RELEASE.jar:5.2.3.RELEASE]
	at org.springframework.context.annotation.ConfigurationClassPostProcessor.processConfigBeanDefinitions(ConfigurationClassPostProcessor.java:331) ~[spring-context-5.2.3.RELEASE.jar:5.2.3.RELEASE]
	at org.springframework.context.annotation.ConfigurationClassPostProcessor.postProcessBeanDefinitionRegistry(ConfigurationClassPostProcessor.java:236) ~[spring-context-5.2.3.RELEASE.jar:5.2.3.RELEASE]
	at org.springframework.context.support.PostProcessorRegistrationDelegate.invokeBeanDefinitionRegistryPostProcessors(PostProcessorRegistrationDelegate.java:275) ~[spring-context-5.2.3.RELEASE.jar:5.2.3.RELEASE]
	at org.springframework.context.support.PostProcessorRegistrationDelegate.invokeBeanFactoryPostProcessors(PostProcessorRegistrationDelegate.java:95) ~[spring-context-5.2.3.RELEASE.jar:5.2.3.RELEASE]
	at org.springframework.context.support.AbstractApplicationContext.invokeBeanFactoryPostProcessors(AbstractApplicationContext.java:706) ~[spring-context-5.2.3.RELEASE.jar:5.2.3.RELEASE]
	at org.springframework.context.support.AbstractApplicationContext.refresh(AbstractApplicationContext.java:532) ~[spring-context-5.2.3.RELEASE.jar:5.2.3.RELEASE]
	at org.springframework.boot.web.servlet.context.ServletWebServerApplicationContext.refresh(ServletWebServerApplicationContext.java:141) ~[spring-boot-2.2.4.RELEASE.jar:2.2.4.RELEASE]
	at org.springframework.boot.SpringApplication.refresh(SpringApplication.java:747) [spring-boot-2.2.4.RELEASE.jar:2.2.4.RELEASE]
	at org.springframework.boot.SpringApplication.refreshContext(SpringApplication.java:397) [spring-boot-2.2.4.RELEASE.jar:2.2.4.RELEASE]
	at org.springframework.boot.SpringApplication.run(SpringApplication.java:315) [spring-boot-2.2.4.RELEASE.jar:2.2.4.RELEASE]
	at org.springframework.boot.SpringApplication.run(SpringApplication.java:1226) [spring-boot-2.2.4.RELEASE.jar:2.2.4.RELEASE]
	at org.springframework.boot.SpringApplication.run(SpringApplication.java:1215) [spring-boot-2.2.4.RELEASE.jar:2.2.4.RELEASE]
	at com.pipi.MyMicroServicesApplication.main(MyMicroServicesApplication.java:17) [classes/:na]
	at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method) ~[na:1.8.0_211]
	at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62) ~[na:1.8.0_211]
	at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43) ~[na:1.8.0_211]
	at java.lang.reflect.Method.invoke(Method.java:498) ~[na:1.8.0_211]
	at org.springframework.boot.devtools.restart.RestartLauncher.run(RestartLauncher.java:49) [spring-boot-devtools-2.2.4.RELEASE.jar:2.2.4.RELEASE]
Caused by: java.lang.IllegalStateException: Failed to introspect Class [org.springframework.data.web.config.HateoasAwareSpringDataWebConfiguration] from ClassLoader [sun.misc.Launcher$AppClassLoader@18b4aac2]
	at org.springframework.util.ReflectionUtils.getDeclaredMethods(ReflectionUtils.java:481) ~[spring-core-5.2.3.RELEASE.jar:5.2.3.RELEASE]
	at org.springframework.util.ReflectionUtils.doWithMethods(ReflectionUtils.java:358) ~[spring-core-5.2.3.RELEASE.jar:5.2.3.RELEASE]
	at org.springframework.util.ReflectionUtils.getUniqueDeclaredMethods(ReflectionUtils.java:414) ~[spring-core-5.2.3.RELEASE.jar:5.2.3.RELEASE]
	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.lambda$getTypeForFactoryMethod$2(AbstractAutowireCapableBeanFactory.java:743) ~[spring-beans-5.2.3.RELEASE.jar:5.2.3.RELEASE]
	at java.util.concurrent.ConcurrentHashMap.computeIfAbsent(ConcurrentHashMap.java:1688) ~[na:1.8.0_211]
	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.getTypeForFactoryMethod(AbstractAutowireCapableBeanFactory.java:742) ~[spring-beans-5.2.3.RELEASE.jar:5.2.3.RELEASE]
	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.determineTargetType(AbstractAutowireCapableBeanFactory.java:681) ~[spring-beans-5.2.3.RELEASE.jar:5.2.3.RELEASE]
	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.predictBeanType(AbstractAutowireCapableBeanFactory.java:649) ~[spring-beans-5.2.3.RELEASE.jar:5.2.3.RELEASE]
	at org.springframework.beans.factory.support.AbstractBeanFactory.isFactoryBean(AbstractBeanFactory.java:1604) ~[spring-beans-5.2.3.RELEASE.jar:5.2.3.RELEASE]
	at org.springframework.beans.factory.support.DefaultListableBeanFactory.doGetBeanNamesForType(DefaultListableBeanFactory.java:520) ~[spring-beans-5.2.3.RELEASE.jar:5.2.3.RELEASE]
	at org.springframework.beans.factory.support.DefaultListableBeanFactory.getBeanNamesForType(DefaultListableBeanFactory.java:491) ~[spring-beans-5.2.3.RELEASE.jar:5.2.3.RELEASE]
	at org.springframework.boot.autoconfigure.condition.OnBeanCondition.collectBeanNamesForType(OnBeanCondition.java:230) ~[spring-boot-autoconfigure-2.2.4.RELEASE.jar:2.2.4.RELEASE]
	at org.springframework.boot.autoconfigure.condition.OnBeanCondition.getBeanNamesForType(OnBeanCondition.java:223) ~[spring-boot-autoconfigure-2.2.4.RELEASE.jar:2.2.4.RELEASE]
	at org.springframework.boot.autoconfigure.condition.OnBeanCondition.getBeanNamesForType(OnBeanCondition.java:213) ~[spring-boot-autoconfigure-2.2.4.RELEASE.jar:2.2.4.RELEASE]
	at org.springframework.boot.autoconfigure.condition.OnBeanCondition.getMatchingBeans(OnBeanCondition.java:167) ~[spring-boot-autoconfigure-2.2.4.RELEASE.jar:2.2.4.RELEASE]
	at org.springframework.boot.autoconfigure.condition.OnBeanCondition.getMatchOutcome(OnBeanCondition.java:142) ~[spring-boot-autoconfigure-2.2.4.RELEASE.jar:2.2.4.RELEASE]
	at org.springframework.boot.autoconfigure.condition.SpringBootCondition.matches(SpringBootCondition.java:47) ~[spring-boot-autoconfigure-2.2.4.RELEASE.jar:2.2.4.RELEASE]
	... 22 common frames omitted
Caused by: java.lang.NoClassDefFoundError: org/springframework/hateoas/server/mvc/UriComponentsContributor
	at java.lang.ClassLoader.defineClass1(Native Method) ~[na:1.8.0_211]
	at java.lang.ClassLoader.defineClass(ClassLoader.java:763) ~[na:1.8.0_211]
	at java.security.SecureClassLoader.defineClass(SecureClassLoader.java:142) ~[na:1.8.0_211]
	at java.net.URLClassLoader.defineClass(URLClassLoader.java:468) ~[na:1.8.0_211]
	at java.net.URLClassLoader.access$100(URLClassLoader.java:74) ~[na:1.8.0_211]
	at java.net.URLClassLoader$1.run(URLClassLoader.java:369) ~[na:1.8.0_211]
	at java.net.URLClassLoader$1.run(URLClassLoader.java:363) ~[na:1.8.0_211]
	at java.security.AccessController.doPrivileged(Native Method) ~[na:1.8.0_211]
	at java.net.URLClassLoader.findClass(URLClassLoader.java:362) ~[na:1.8.0_211]
	at java.lang.ClassLoader.loadClass(ClassLoader.java:424) ~[na:1.8.0_211]
	at sun.misc.Launcher$AppClassLoader.loadClass(Launcher.java:349) ~[na:1.8.0_211]
	at java.lang.ClassLoader.loadClass(ClassLoader.java:357) ~[na:1.8.0_211]
	at java.lang.Class.getDeclaredMethods0(Native Method) ~[na:1.8.0_211]
	at java.lang.Class.privateGetDeclaredMethods(Class.java:2701) ~[na:1.8.0_211]
	at java.lang.Class.getDeclaredMethods(Class.java:1975) ~[na:1.8.0_211]
	at org.springframework.util.ReflectionUtils.getDeclaredMethods(ReflectionUtils.java:463) ~[spring-core-5.2.3.RELEASE.jar:5.2.3.RELEASE]
	... 38 common frames omitted
Caused by: java.lang.ClassNotFoundException: org.springframework.hateoas.server.mvc.UriComponentsContributor
	at java.net.URLClassLoader.findClass(URLClassLoader.java:382) ~[na:1.8.0_211]
	at java.lang.ClassLoader.loadClass(ClassLoader.java:424) ~[na:1.8.0_211]
	at sun.misc.Launcher$AppClassLoader.loadClass(Launcher.java:349) ~[na:1.8.0_211]
	at java.lang.ClassLoader.loadClass(ClassLoader.java:357) ~[na:1.8.0_211]
	... 54 common frames omitted

2020-03-16 13:55:13.177  WARN 9788 --- [  restartedMain] o.s.boot.SpringApplication               : Unable to close ApplicationContext

java.lang.IllegalStateException: Failed to introspect Class [org.springframework.data.web.config.HateoasAwareSpringDataWebConfiguration] from ClassLoader [sun.misc.Launcher$AppClassLoader@18b4aac2]
	at org.springframework.util.ReflectionUtils.getDeclaredMethods(ReflectionUtils.java:481) ~[spring-core-5.2.3.RELEASE.jar:5.2.3.RELEASE]
	at org.springframework.util.ReflectionUtils.doWithMethods(ReflectionUtils.java:358) ~[spring-core-5.2.3.RELEASE.jar:5.2.3.RELEASE]
	at org.springframework.util.ReflectionUtils.getUniqueDeclaredMethods(ReflectionUtils.java:414) ~[spring-core-5.2.3.RELEASE.jar:5.2.3.RELEASE]
	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.lambda$getTypeForFactoryMethod$2(AbstractAutowireCapableBeanFactory.java:743) ~[spring-beans-5.2.3.RELEASE.jar:5.2.3.RELEASE]
	at java.util.concurrent.ConcurrentHashMap.computeIfAbsent(ConcurrentHashMap.java:1688) ~[na:1.8.0_211]
	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.getTypeForFactoryMethod(AbstractAutowireCapableBeanFactory.java:742) ~[spring-beans-5.2.3.RELEASE.jar:5.2.3.RELEASE]
	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.determineTargetType(AbstractAutowireCapableBeanFactory.java:681) ~[spring-beans-5.2.3.RELEASE.jar:5.2.3.RELEASE]
	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.predictBeanType(AbstractAutowireCapableBeanFactory.java:649) ~[spring-beans-5.2.3.RELEASE.jar:5.2.3.RELEASE]
	at org.springframework.beans.factory.support.AbstractBeanFactory.isFactoryBean(AbstractBeanFactory.java:1604) ~[spring-beans-5.2.3.RELEASE.jar:5.2.3.RELEASE]
	at org.springframework.beans.factory.support.DefaultListableBeanFactory.doGetBeanNamesForType(DefaultListableBeanFactory.java:520) ~[spring-beans-5.2.3.RELEASE.jar:5.2.3.RELEASE]
	at org.springframework.beans.factory.support.DefaultListableBeanFactory.getBeanNamesForType(DefaultListableBeanFactory.java:491) ~[spring-beans-5.2.3.RELEASE.jar:5.2.3.RELEASE]
	at org.springframework.beans.factory.support.DefaultListableBeanFactory.getBeansOfType(DefaultListableBeanFactory.java:613) ~[spring-beans-5.2.3.RELEASE.jar:5.2.3.RELEASE]
	at org.springframework.beans.factory.support.DefaultListableBeanFactory.getBeansOfType(DefaultListableBeanFactory.java:605) ~[spring-beans-5.2.3.RELEASE.jar:5.2.3.RELEASE]
	at org.springframework.context.support.AbstractApplicationContext.getBeansOfType(AbstractApplicationContext.java:1242) ~[spring-context-5.2.3.RELEASE.jar:5.2.3.RELEASE]
	at org.springframework.boot.SpringApplication.getExitCodeFromMappedException(SpringApplication.java:869) [spring-boot-2.2.4.RELEASE.jar:2.2.4.RELEASE]
	at org.springframework.boot.SpringApplication.getExitCodeFromException(SpringApplication.java:857) [spring-boot-2.2.4.RELEASE.jar:2.2.4.RELEASE]
	at org.springframework.boot.SpringApplication.handleExitCode(SpringApplication.java:844) [spring-boot-2.2.4.RELEASE.jar:2.2.4.RELEASE]
	at org.springframework.boot.SpringApplication.handleRunFailure(SpringApplication.java:795) [spring-boot-2.2.4.RELEASE.jar:2.2.4.RELEASE]
	at org.springframework.boot.SpringApplication.run(SpringApplication.java:325) [spring-boot-2.2.4.RELEASE.jar:2.2.4.RELEASE]
	at org.springframework.boot.SpringApplication.run(SpringApplication.java:1226) [spring-boot-2.2.4.RELEASE.jar:2.2.4.RELEASE]
	at org.springframework.boot.SpringApplication.run(SpringApplication.java:1215) [spring-boot-2.2.4.RELEASE.jar:2.2.4.RELEASE]
	at com.pipi.MyMicroServicesApplication.main(MyMicroServicesApplication.java:17) [classes/:na]
	at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method) ~[na:1.8.0_211]
	at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62) ~[na:1.8.0_211]
	at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43) ~[na:1.8.0_211]
	at java.lang.reflect.Method.invoke(Method.java:498) ~[na:1.8.0_211]
	at org.springframework.boot.devtools.restart.RestartLauncher.run(RestartLauncher.java:49) [spring-boot-devtools-2.2.4.RELEASE.jar:2.2.4.RELEASE]
Caused by: java.lang.NoClassDefFoundError: org/springframework/hateoas/server/mvc/UriComponentsContributor
	at java.lang.ClassLoader.defineClass1(Native Method) ~[na:1.8.0_211]
	at java.lang.ClassLoader.defineClass(ClassLoader.java:763) ~[na:1.8.0_211]
	at java.security.SecureClassLoader.defineClass(SecureClassLoader.java:142) ~[na:1.8.0_211]
	at java.net.URLClassLoader.defineClass(URLClassLoader.java:468) ~[na:1.8.0_211]
	at java.net.URLClassLoader.access$100(URLClassLoader.java:74) ~[na:1.8.0_211]
	at java.net.URLClassLoader$1.run(URLClassLoader.java:369) ~[na:1.8.0_211]
	at java.net.URLClassLoader$1.run(URLClassLoader.java:363) ~[na:1.8.0_211]
	at java.security.AccessController.doPrivileged(Native Method) ~[na:1.8.0_211]
	at java.net.URLClassLoader.findClass(URLClassLoader.java:362) ~[na:1.8.0_211]
	at java.lang.ClassLoader.loadClass(ClassLoader.java:424) ~[na:1.8.0_211]
	at sun.misc.Launcher$AppClassLoader.loadClass(Launcher.java:349) ~[na:1.8.0_211]
	at java.lang.ClassLoader.loadClass(ClassLoader.java:357) ~[na:1.8.0_211]
	at java.lang.Class.getDeclaredMethods0(Native Method) ~[na:1.8.0_211]
	at java.lang.Class.privateGetDeclaredMethods(Class.java:2701) ~[na:1.8.0_211]
	at java.lang.Class.getDeclaredMethods(Class.java:1975) ~[na:1.8.0_211]
	at org.springframework.util.ReflectionUtils.getDeclaredMethods(ReflectionUtils.java:463) ~[spring-core-5.2.3.RELEASE.jar:5.2.3.RELEASE]
	... 26 common frames omitted
Caused by: java.lang.ClassNotFoundException: org.springframework.hateoas.server.mvc.UriComponentsContributor
	at java.net.URLClassLoader.findClass(URLClassLoader.java:382) ~[na:1.8.0_211]
	at java.lang.ClassLoader.loadClass(ClassLoader.java:424) ~[na:1.8.0_211]
	at sun.misc.Launcher$AppClassLoader.loadClass(Launcher.java:349) ~[na:1.8.0_211]
	at java.lang.ClassLoader.loadClass(ClassLoader.java:357) ~[na:1.8.0_211]
	... 42 common frames omitted


Process finished with exit code 0

```