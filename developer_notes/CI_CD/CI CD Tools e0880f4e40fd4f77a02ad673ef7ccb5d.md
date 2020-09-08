# CI/CD Tools

**GCP**

Jenkins VM **34.64.92.19:8082**

MySQL VM **34.64.92.98**

**GCP VM**

- [x]  Jenkins 설치
- [ ]  ~~Gradle 설치~~
- [x]  DB 서버

**Coupling**

- [x]  Slack - Notion 연동
- [x]  Slack - Github 연동
- [x]  Slack - Jenkins 연동
- [x]  Jenkins - Github 연동 (+Webhook)

GCE 인스턴스의 경우 인스턴스별로 SSH가 제공되는데 SQL인스턴스는 프로젝트단의 Shell인 Cloud Shell을 통해서 접근함. 

[GCP VM상에 Jenkins 설치](CI%20CD%20Tools%20e0880f4e40fd4f77a02ad673ef7ccb5d/GCP%20VM%E1%84%89%E1%85%A1%E1%86%BC%E1%84%8B%E1%85%A6%20Jenkins%20%E1%84%89%E1%85%A5%E1%86%AF%E1%84%8E%E1%85%B5%20f4dd2b9da70b4ff0aeebd8182039a14a.md)

[Jenkins ↔ Github 연동 & Webhook 설정](CI%20CD%20Tools%20e0880f4e40fd4f77a02ad673ef7ccb5d/Jenkins%20%E2%86%94%20Github%20%E1%84%8B%E1%85%A7%E1%86%AB%E1%84%83%E1%85%A9%E1%86%BC%20&%20Webhook%20%E1%84%89%E1%85%A5%E1%86%AF%E1%84%8C%E1%85%A5%E1%86%BC%209690cbf6505f4c34aaef0d683a8ff31e.md)

[Jenkin 서버에 Gradle 설치](CI%20CD%20Tools%20e0880f4e40fd4f77a02ad673ef7ccb5d/Jenkin%20%E1%84%89%E1%85%A5%E1%84%87%E1%85%A5%E1%84%8B%E1%85%A6%20Gradle%20%E1%84%89%E1%85%A5%E1%86%AF%E1%84%8E%E1%85%B5%20243f55fdfd7d49cea9e714ee4a1d15e0.md)

[Jenkins Gradle 빌드 테스트](CI%20CD%20Tools%20e0880f4e40fd4f77a02ad673ef7ccb5d/Jenkins%20Gradle%20%E1%84%87%E1%85%B5%E1%86%AF%E1%84%83%E1%85%B3%20%E1%84%90%E1%85%A6%E1%84%89%E1%85%B3%E1%84%90%E1%85%B3%203d4c89a2ab934c5dbb6d5789d597f89b.md)

[DataBase](CI%20CD%20Tools%20e0880f4e40fd4f77a02ad673ef7ccb5d/DataBase%20c364e91a466344c095106351d478d15d.md)

서버에 mySQL 설치 → 젠킨스랑 같은 VM? 다른 VM?

JUnit연동