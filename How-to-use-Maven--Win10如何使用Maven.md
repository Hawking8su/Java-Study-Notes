# Win10如何使用Maven - How to use Maven 

## 一、Windows10 如何在本地安装Maven:

详见：https://blog.csdn.net/pan_junbiao/article/details/104264644

第一步：下载Maven

第二步：设置环境变量

第三步：修改 .m2/settings 配置：

修改1:

```xml
<!-- 设置本地仓库位置 -->
<localRepository>D:\maven-local-repository</localRepository>

```

修改2：在`<mirrors>...<\mirrors>` 中间增加

```xml
    <!-- 配置中央仓库的镜像（改用：阿里云中央仓库镜像）-->
    <mirror>        
      <id>alimaven</id>
      <name>aliyun-maven</name>
      <mirrorOf>central</mirrorOf>
      <url>http://maven.aliyun.com/nexus/content/groups/public</url>
    </mirror>
```



## 二、如何在IDEA中使用Maven -- How to use Maven in IDEA:

IntelliJ IDEA Professional中集成了Maven环境，所以不需要在本地安装Maven也可以使用。

第0步：设置Settings

![image-20210717234837585](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20210717234837585.png)

第1步：新建Project--> Maven

![image-20210717232320747](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20210717232320747.png)



第2步：修改pom.xml:

```xml
 <groupId>MavenTestProject</groupId>
    <artifactId>MavenTestProject</artifactId>
    <version>1.0-SNAPSHOT</version>
	<!-- 推荐配置，建议copy -->
    <properties>
        <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
        <encoding>UTF-8</encoding>
        <java.version>1.8</java.version>
        <maven.compiler.source>1.8</maven.compiler.source>
        <maven.compiler.target>1.8</maven.compiler.target>
    </properties>

<!-- 配置依赖包，增加后需要reload project，见下一步 -->
    <dependencies>
        <dependency>
            <groupId>com.google.guava</groupId>
            <artifactId>guava</artifactId>
            <version>28.0-jre</version>
        </dependency>
        <dependency>
            <groupId>org.codehaus.groovy</groupId>
            <artifactId>groovy-all</artifactId>
            <version>3.0.7</version>
            <type>pom</type>
        </dependency>
    </dependencies>
```



第3步：右击pom.xml --> Maven --> reload project

![image-20210717233731245](./How-to-use-Maven--Win10如何使用Maven.assetsimage-20210717233731245.png)

注意：如果是第一次配置Maven，且上述步骤失败，则可以先尝试以下操作：

- Terminal --> 确认在pom.xml所在的文件夹 --> 输入： `mvn install -U`



验证：看到External Libraries 有配置的依赖包，即可验证配置无误。

![image-20210717234731852](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20210717234731852.png)

