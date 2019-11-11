dependencies for spring mvc:
- Spring Core jar files
- Spring Web jar files
- JSP + JSTL jar files (If you are using any another view technology then load the corresponding jar files).
if it was maven project:
 <!-- https://mvnrepository.com/artifact/org.springframework/spring-webmvc -->  
<dependency>  
    <groupId>org.springframework</groupId>  
    <artifactId>spring-webmvc</artifactId>  
    <version>5.1.1.RELEASE</version>  
</dependency>  
  
<!-- https://mvnrepository.com/artifact/javax.servlet/javax.servlet-api -->  
<dependency>    
    <groupId>javax.servlet</groupId>    
    <artifactId>servlet-api</artifactId>    
    <version>3.0-alpha-1</version>    
</dependency>  

steps:
0- active package scan in spring config file:
    <context:component-scan base-package="org.j2os"/>

1- active mvc in spring config file:
    <mvc:annotation-driven/>
and Define Spring MVC view resolver 
    <bean id="viewResolver" class="org.springframework.web.servlet.view.InternalResourceViewResolver">  
            <property name="prefix" value="/WEB-INF/jsp/"></property>  
            <property name="suffix" value=".jsp"></property>          
         </bean>  
    </beans>  

2- add spring servlet and its url mapping in web.xml

3- write @Controller and @Component classes

some common SpringMVC annotations:

@Controller.
@RequestMapping (or getmapping or ...)
@PathVariable( /../{name})
@RequestParam (for each parameter   /..?name=ali
@ModelAttribute. (get whole parameters as an object   /../..?name=ali&id=5)
@RequestBody  ( {"name":"ali","id":"5"})
@ResponseBody  (returns json))
@RequestHeader and @ResponseHeader.

