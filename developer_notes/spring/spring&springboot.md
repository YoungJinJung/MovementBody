# Spring과 SpringBoot

## Contents

---

### Spring Framework란?

- 흔히 Spring이라고 말하는 것은 Spring Framework를 지칭(최신 버전 5.2.8 - 2020.09.04기준)
- J2EE 개발을 위한 오픈 소스 프레임 워크
- 종속 객체 생성 및 조립을 해주는 프레임 워크(뒤의 특징에서 자세히)
- 주요 특징

    1)  IoC(Inversion of Control)

    - Spring에서는 사용자가 직접 객체를 만들어서 사용하는 것이 아니라 Spring 컨테이너에서 관리하고 있는 객체를 가져다 사용하는 방식
    - 제어권이 사용자가 아닌 Spring에 있다하여 IoC라고 한다.
    - 즉, Java 객체의 LifeCycle를 Spring이 관리

    2) DI(Dependency Injection)

    - 설정파일이나 어노테이션을 통해 객체 간의 의존성을 관리
        - 생성자 DI
        - Setter DI
        - 멤버변수 DI
        - ** 세 가지 방법으로 DI를 제공할 수 있다.

    3) AOP(Aspect Orientied Programing)

    - 관심사를 따로 모아서 프로그램한다라는 개념
    - Spring은 트랜젝션이나 로깅, 보안과 같이 공통적으로 필요로 하는 모듈들을 실제 핵심 모듈에서 분리해서 적용 할 수 있다.

    4) POJO

    - Spring 컨테이너에 저장되는 Java객체는 특정한 인터페이스를 구현하거나, 특정클래스를 상속받지 않아도 된다.
    - extend나 Implements 가 없고, setter와 getter 메서도로 이루어진 순수한 java beans

### SpringBoot란?

- SpringBoot는 Spring을 사용하는 프로젝트를 간편하게 set-up 할 수 있는 Spring Framework 의 sub project개념(최신 버전 2.4.0 - 2020.09.04기준)
- 내부에 기본적으로 내장 WAS(tomcat)이 있기 때문에 별도의 WAS(Web Application Server)를 설치할 필요가 없음.
- springboot-starter을 통한 dependency 자동화
- XML설정을 하지 않아도 된다.

### 왜 SpringBoot?

- 생각하는 방향은 우리는 서비스를 실제로 제공할 것이 아니고, 대규모의 서비스가 아니기 때문에 굳이 WAS가 필요가 없음.
- 따라서, 내장 WAS를 갖는 Springboot가 맞다고 생각함.
- 만약에 더 큰 기능이 필요하고 Thread Pool이나 DB Pool관리 혹은 클러스터 구성 등과 같은 부분까지 필요하다면 weblogic 혹은 tomcat과 같은 오픈소스 was를 사용하는 것도 고려해볼 만 할것으로 보임.

## Reference

---

**Spring Framework :**

[https://ooeunz.tistory.com/56](https://ooeunz.tistory.com/56)

[https://feeva.github.io/posts/이제는-spring-boot를-써야할-때다](https://feeva.github.io/posts/%EC%9D%B4%EC%A0%9C%EB%8A%94-spring-boot%EB%A5%BC-%EC%8D%A8%EC%95%BC%ED%95%A0-%EB%95%8C%EB%8B%A4)

[https://sas-study.tistory.com/274](https://sas-study.tistory.com/274)

[https://getinthere.tistory.com/11?category=813090](https://getinthere.tistory.com/11?category=813090)

**DI :**

 [https://gmlwjd9405.github.io/2018/11/09/dependency-injection.html](https://gmlwjd9405.github.io/2018/11/09/dependency-injection.html)

**POJO :**

 [https://m.blog.naver.com/weekamp/186678831](https://m.blog.naver.com/weekamp/186678831)