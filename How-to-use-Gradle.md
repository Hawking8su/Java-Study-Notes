# How to use Gradle in IDEA

Reference:

- [在IDEA里gradle配置和使用](!https://blog.csdn.net/achenyuan/article/details/80682288)
- [Gradle 入门--只此一篇](!https://www.jianshu.com/p/001abe1d8e95)
- [Gradle的使用教程-知乎](!https://zhuanlan.zhihu.com/p/95205583)

Background: because IDEA has built-in Gradle plug-ins, so you won't need to install gradle locally for using gradle in an IDEA project.

Step 1: Create new project --> Gradle

![image-20210717231151921](.\How-to-use-Gradle.assets\image-20210717231151921.png)

Step 2: The project will start to build automatically, after it finishes, modify `build.gradle` file: 

```groovy
plugins {
    id 'java'
}

group 'org.example'
version '1.0-SNAPSHOT'

repositories {
//    mavenCentral()
    maven { url "http://maven.aliyun.com/nexus/content/groups/public/" }  // change maven source to aliyun
}

dependencies {
    testImplementation 'org.junit.jupiter:junit-jupiter-api:5.7.0'
    testRuntimeOnly 'org.junit.jupiter:junit-jupiter-engine:5.7.0'
    compile 'org.codehaus.groovy:groovy-jsr223:3.0.7'  // Example: add external jar file use `compile`
}

test {
    useJUnitPlatform()
}

// this line deal with encoding error.
tasks.withType(JavaCompile) {
    options.encoding = 'UTF-8'
}
```



Step 3: Rebuild the project for the former changes to be effective: Build --> Reload Gradle Project

![image-20210717231625127](.\How-to-use-Gradle.assets\image-20210717231625127.png)



Step 4: Check if the target dependencies appeared in the External libraries.

![image-20210717232055678](.\How-to-use-Gradle.assets\image-20210717232055678.png)



Done!