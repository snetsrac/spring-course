## Spring configuration using XML

This simple application demonstrates the use of an XML config file to configure and initialize a Spring application context. This allows for inversion of control by decoupling the configuration from the java code. The Spring framework uses the config information to initialize and manage the lifecycle of objects, called beans in this case. The config file defines which java classes will be used to generate each bean.

### Dependency Injection

Bean dependencies can be defined in multiple ways. First, a dependency can be injected as an argument to the constructor along with a corresponding ```<constructor-arg>``` element within the ```<bean>``` element. This allows for specific implementations to be swapped out without requiring modification of the code. A second method is to define a setter method for the class. A corresponding ```<property>``` element with nested ```<value>``` element is defined in the config file. The setter method must be of the form "setMethodName", which corresponds to a property with a name="methodName" attribute. A third method is to use a ```<property>``` element with a ref attribute with the id of the bean that is a dependency.

### Property Literals

Literal properties can also be defined by using a value attribute on the ```<property>``` element. Additionally, literals can be moved into a separate file and loaded with a ```<context:property-placeholder>``` element.
