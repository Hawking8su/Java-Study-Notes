# IDEA Gradle项目编译报错：编码GBK的不可映射字符

参考：https://blog.csdn.net/dKnightL/article/details/79950305

报错信息：

![image-20210718000254083](.\IDEA Gradle项目编译报错-编码GBK的不可映射字符.assets\image-20210718000254083.png)

原因定位：

- 排除IDEA配置原因：新建一个非Maven、非Gradle的纯Java project，注释中添加中文，编辑执行无报错
- 定位为Gradle配置原因：新建一个Gradle project, 注释中添加中文，编辑执行报错

解决步骤：

- 在build.gradle文件中最下方添加下面配置

  ```groovy
  tasks.withType(JavaCompile) {
      options.encoding = 'UTF-8'
  }
  ```

- Build --> Reload Gradle Project

![image-20210717231625127](E:\04_Blog\00_GithubRepos\Java-Study-Notes\IDEA Gradle项目编译报错-编码GBK的不可映射字符.assets\image-20210717231625127.png)



