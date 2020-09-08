# Jenkin 서버에 Gradle 설치

[https://guides.gradle.org/executing-gradle-builds-on-jenkins/](https://guides.gradle.org/executing-gradle-builds-on-jenkins/)

```bash
$ git clone [https://github.com/gradle/gradle-site-plugin.git](https://github.com/gradle/gradle-site-plugin.git)
$ cd gradle-site-plugin
```

```bash
$ ./gradlew build

BUILD SUCCESSFUL
14 actionable tasks: 14 executed
```

```bash
**Build Error**
**> Task :signArchives** FAILED
FAILURE: Build failed with an exception.
● What went wrong:
A problem was found with the configuration of task ':signArchives'.
> No value has been specified for property 'signatory.keyId'.
```

Jenkins 서버에 gradle 설치할 필요 없이 jenkins 내장 gradle 사용하면 됨.