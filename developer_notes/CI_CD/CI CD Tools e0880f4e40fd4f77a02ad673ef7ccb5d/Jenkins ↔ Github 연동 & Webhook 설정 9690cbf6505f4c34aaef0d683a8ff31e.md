# Jenkins ↔ Github 연동 & Webhook 설정

웹 브라우저에서 Jenkins 접속 (GCP 프로젝트상 VM외부IP:포트)

젠킨스 메인화면에서 New Item, Free Style Project

General → GitHub project 선택

Project URL에 Github Repo URL 추가

소스 코드 관리 → Git 체크

Repository URL → Clone하는데 쓰이는 URL 추가 (Repo 주소.git)

**Credentials Add**

ID/PW 로 접근할 경우 Kind를 Username with password

Username → Github ID (로그인용 ID가 아닌 Profile에서 보이는 ID)

Password → Github PW

ID → 해당 아이템에서 사용될 구분용 ID

Credentials Add로 추가한 뒤에 추가한 Credentials 선택해줘야함.

## Webhook 설정

github에 push가 발생하면 jenkins에 알리는 용도

**젠킨스 메인**에서 Jenkins 관리 - 시스템 설정에서 Jenkins Location이 localhost가 아닌 외부에서 접근할 수 있는 도메인이나 ip여야함. 

**Github 프로젝트 설정**에서 Webhook 메뉴에서 add webhook.

Payload URL : **Jenkins 주소**/github-webhook/ → 마지막에 "/" 필수, 

나머지 default 값으로 두고 add webhook

젠킨스 item → 구성 → 빌드 유발

Github hook trigger for GITScm polling 선택