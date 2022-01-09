## Annotation Demo App

This simple app is a demonstration of how to configure a Spring app using annotations instead of xml. A very short xml config file is still needed in order to enable component scanning, which the Spring framework uses to detect the annotations and perform configuration and bean initialization.

### Component Scanning

In order for annotation-based configuration to work, the Spring framework needs to know firstly that it needs to scan the source for component definitions, and secondly the components need to be marked as such. To enable component scanning, use the ```<context:component-scan base-component="com.example.package">``` element in the XML configuration file. No other elements are needed. Next, label each component class using the @Component annotation.

### Dependency Injection

Dependencies can be injected in multiple ways using the @Autowired annotation. This annotation can be applied to a constructor, a setter method, any other method, or directly to the field itself.

### Qualifiers

If there are multiple dependencies that implement the same required interface, then it is necessary to use the ```@Qualifier("beanName")``` annotation to specify a single implementation. The default bean ID is the name of the component class with a lower case first letter, unless both the first and second letter are capitalized, in which case the class name is used as-is. For example, the ```HappyFortuneService``` class has a default bean ID of ```happyFortuneService``` and the ```RESTFortuneService``` has a default bean ID of ```RESTFortuneService```.

If using constructor injection, then the ```@Qualifier("beanName")``` annotation immediately precedes the dependency's type inside the function's argument list (```public ClassName(@Qualifier("beanName") DependencyType dependency) {} ```), otherwise it can be placed either in the same location as above or before the function signature right after the ```@Autowired``` annotation.
