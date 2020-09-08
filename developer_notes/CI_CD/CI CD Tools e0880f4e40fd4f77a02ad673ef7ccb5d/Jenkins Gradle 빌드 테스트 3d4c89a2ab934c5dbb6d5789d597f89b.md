# Jenkins Gradle 빌드 테스트

Jenkins Item → 구성

![Jenkins%20Gradle%20%E1%84%87%E1%85%B5%E1%86%AF%E1%84%83%E1%85%B3%20%E1%84%90%E1%85%A6%E1%84%89%E1%85%B3%E1%84%90%E1%85%B3%203d4c89a2ab934c5dbb6d5789d597f89b/Untitled.png](Jenkins%20Gradle%20%E1%84%87%E1%85%B5%E1%86%AF%E1%84%83%E1%85%B3%20%E1%84%90%E1%85%A6%E1%84%89%E1%85%B3%E1%84%90%E1%85%B3%203d4c89a2ab934c5dbb6d5789d597f89b/Untitled.png)

Build Now 했을 때 Build Fail

```
Started by user MovementBody
Running as SYSTEM
Building in workspace /var/lib/jenkins/workspace/Jenkins-Test
The recommended git tool is: NONE
using credential joohyung
 > git rev-parse --is-inside-work-tree # timeout=10
Fetching changes from the remote Git repository
 > git config remote.origin.url https://github.com/YoungJinJung/MovementBody.git # timeout=10
Fetching upstream changes from https://github.com/YoungJinJung/MovementBody.git
 > git --version # timeout=10
 > git --version # 'git version 2.17.1'
using GIT_ASKPASS to set credentials 
 > git fetch --tags --progress -- https://github.com/YoungJinJung/MovementBody.git +refs/heads/*:refs/remotes/origin/* # timeout=10
 > git rev-parse refs/remotes/origin/master^{commit} # timeout=10
 > git rev-parse refs/remotes/origin/origin/master^{commit} # timeout=10
Checking out Revision 728242e7200572c27e3a615ddd966cb6fb3ad2dc (refs/remotes/origin/master)
 > git config core.sparsecheckout # timeout=10
 > git checkout -f 728242e7200572c27e3a615ddd966cb6fb3ad2dc # timeout=10
Commit message: "feat(base) : modify gradle build script "
 > git rev-list --no-walk 728242e7200572c27e3a615ddd966cb6fb3ad2dc # timeout=10
[Gradle] - Launching build.
[Jenkins-Test] $ /var/lib/jenkins/workspace/Jenkins-Test/gradlew build
**/usr/bin/env: ‘sh\r’: No such file or directory**
Build step 'Invoke Gradle script' changed build result to FAILURE
Build step 'Invoke Gradle script' marked build as failure
Finished: FAILURE
```

/usr/bin/env: ‘sh\r’: No such file or directory

이 부분이 문제인데 환경변수 설정에서 CRLF 차이로 인한 에러

gradlew 파일의 첫 줄에 shell 실행 커맨드 인코딩에 문제가 있음.

1. git 설정에서 autocrlf false로 바꿔줘야함

```bash
$ git config --global core.autocrlf false
```

2. "리눅스 환경"에서 gradlew 파일 첫 줄 띄어쓰기 직접 수정해서 다시 push 하거나

윈도우에서 notepad++로 CRLF → LF 수정

![Jenkins%20Gradle%20%E1%84%87%E1%85%B5%E1%86%AF%E1%84%83%E1%85%B3%20%E1%84%90%E1%85%A6%E1%84%89%E1%85%B3%E1%84%90%E1%85%B3%203d4c89a2ab934c5dbb6d5789d597f89b/Untitled%201.png](Jenkins%20Gradle%20%E1%84%87%E1%85%B5%E1%86%AF%E1%84%83%E1%85%B3%20%E1%84%90%E1%85%A6%E1%84%89%E1%85%B3%E1%84%90%E1%85%B3%203d4c89a2ab934c5dbb6d5789d597f89b/Untitled%201.png)

빌드 완료되면 /var/lib/jenkins/workspace/Jenkins-Test/ 안에 기서 저것 생김

/var/lib/jenkins/workspace/Jenkins-Test/build/**libs** 안에 war 파일

$ java -jar **MovementBody-0.0.1-SNAPSHOT.war**

실행은 되는데 SpringBoot내장 아파치 톰캣에서 8080포트 요구함. 기존 젠킨스에서 8080포트 사용중이기 때문에 이 부분 수정해줘야함

포트 지정 후 위 명령어 실행시 Hello World 페이지 조회 가능

Shell 상에서 아래와 같이 나오고 VM의 8080로 웹브라우저에서 접근시 hello World 조회가능
지금 보여진건 jenkins 서버에서 테스트용으로 돌린거고 실제 spingboot가 돌아가는건 서비스 VM이어야함.

![Jenkins%20Gradle%20%E1%84%87%E1%85%B5%E1%86%AF%E1%84%83%E1%85%B3%20%E1%84%90%E1%85%A6%E1%84%89%E1%85%B3%E1%84%90%E1%85%B3%203d4c89a2ab934c5dbb6d5789d597f89b/Untitled%202.png](Jenkins%20Gradle%20%E1%84%87%E1%85%B5%E1%86%AF%E1%84%83%E1%85%B3%20%E1%84%90%E1%85%A6%E1%84%89%E1%85%B3%E1%84%90%E1%85%B3%203d4c89a2ab934c5dbb6d5789d597f89b/Untitled%202.png)

![Jenkins%20Gradle%20%E1%84%87%E1%85%B5%E1%86%AF%E1%84%83%E1%85%B3%20%E1%84%90%E1%85%A6%E1%84%89%E1%85%B3%E1%84%90%E1%85%B3%203d4c89a2ab934c5dbb6d5789d597f89b/Untitled%203.png](Jenkins%20Gradle%20%E1%84%87%E1%85%B5%E1%86%AF%E1%84%83%E1%85%B3%20%E1%84%90%E1%85%A6%E1%84%89%E1%85%B3%E1%84%90%E1%85%B3%203d4c89a2ab934c5dbb6d5789d597f89b/Untitled%203.png)

![Jenkins%20Gradle%20%E1%84%87%E1%85%B5%E1%86%AF%E1%84%83%E1%85%B3%20%E1%84%90%E1%85%A6%E1%84%89%E1%85%B3%E1%84%90%E1%85%B3%203d4c89a2ab934c5dbb6d5789d597f89b/Untitled%204.png](Jenkins%20Gradle%20%E1%84%87%E1%85%B5%E1%86%AF%E1%84%83%E1%85%B3%20%E1%84%90%E1%85%A6%E1%84%89%E1%85%B3%E1%84%90%E1%85%B3%203d4c89a2ab934c5dbb6d5789d597f89b/Untitled%204.png)