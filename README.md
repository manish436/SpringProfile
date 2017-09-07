# SpringProfile
Spring applications is using YAML configuration files.

The relative path of application.yml file is /myApplication/src/main/resources/application.yml.

```java
spring:
    profiles: test
name: test-YAML
environment: test
servers: 
    - www.abc.test.com
    - www.xyz.test.com
 
---
spring:
    profiles: prod
name: prod-YAML
environment: production
servers: 
    - www.abc.com
    - www.xyz.com
```


To load a set of related properties from a properties file, we will create a bean class
```java
@Configuration
@EnableConfigurationProperties
@ConfigurationProperties
public class YAMLConfig {
  
    private String name;
    private String environment;
    private List<String> servers = new ArrayList<>();
    // standard getters and setters
}
```

The relative path for properties file is /myApplication/src/main/resources/application.properties.
```java
spring.profiles.active=prod
```

```java
@RestController
public class SimpleController {

	@Autowired
	YAMLConfig configurations;

	@RequestMapping(value = "/config", method = RequestMethod.GET)
	public String getEmployees() {
		return "hello name is " + configurations.getName();
	}
}
```

## Manish Gour.

Ref: http://www.baeldung.com/spring-yaml
