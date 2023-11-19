1. pom添加依赖
    ```xml
    <dependencies>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>
        <dependency>
            <groupId>org.apache.tomcat.embed</groupId>
            <artifactId>tomcat-embed-jasper</artifactId>
        </dependency>
        <dependency>
            <groupId>javax.servlet</groupId>
            <artifactId>jstl</artifactId>
        </dependency>
        <dependency>
            <groupId>javax.servlet</groupId>
            <artifactId>javax.servlet-api</artifactId>
            <scope>provided</scope>
        </dependency>
    </dependencies>
    ```
2. springboot build plugin版本1.4.2, 高版本404错误
   ```xml
    <plugin>
       <groupId>org.springframework.boot</groupId>
       <artifactId>spring-boot-maven-plugin</artifactId>
       <version>1.4.2.RELEASE</version>
       <executions>
           <execution>
               <id>repackage</id>
               <goals>
                   <goal>repackage</goal>
               </goals>
           </execution>
       </executions>
   </plugin>
   ```
3. maven配置jsp资源路径
    ```xml
    <resources>
        <!-- 打包时将jsp文件拷贝到META-INF目录下-->
        <resource>
            <!-- 指定resources插件处理哪个目录下的资源文件 -->
            <directory>src/main/webapp</directory>
            <!--注意此次必须要放在此目录下才能被访问到-->
            <targetPath>META-INF/resources</targetPath>
            <includes>
                <include>**/**</include>
            </includes>
        </resource>
    </resources>
    ```
4. application中添加配置
   ```properties
   ## 这里目录是以webapp为根目录的相对路径配置
   spring.mvc.view.prefix=/pages/
   spring.mvc.view.suffix=.jsp
   ```
5. 必须使用jdk1.8 （使用17 Unable to open root Jar file 'war:.. shiro-web-1.13.0.jar）
6. webapp/pages/index.jsp
   ```jsp
   <%@ page contentType="text/html;charset=UTF-8" language="java" %>
   <html lang="en">
   <head>
       <title>Home</title>
   </head>
   <body>
       <h1>欢迎登录， ${user.username}</h1>
   </body>
   </html>
   ```
7. Controller编写
   ```java
   @Slf4j
   @Controller
   public class HelloController {
       @RequestMapping("/index")
       public String index(){
           return "index" ;
       }
   }
   ```
