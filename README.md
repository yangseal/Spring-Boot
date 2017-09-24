# Spring-Boot 和 thymeleaf 的练习

 thymeleaf中避免对HTML5语法的严格检查具体做法:

在springboot 的applications.yml中添加spring.thymeleaf.mode属性##
 	` spring.thymeleaf.mode=LEGACYHTML5`
## 在Maven配置的pom.xml文件中添加依赖包 ##
    <dependency>
    			<groupId>net.sourceforge.nekohtml</groupId>
    			<artifactId>nekohtml</artifactId>
    			<version>1.9.22</version>
    </dependency>
    
    