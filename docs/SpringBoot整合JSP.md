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
2. maven配置jsp资源路径
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
3. application中添加配置
   ```properties
   ## 这里目录是以webapp为根目录的相对路径配置
   spring.mvc.view.prefix=/pages/
   spring.mvc.view.suffix=.jsp
   ```
