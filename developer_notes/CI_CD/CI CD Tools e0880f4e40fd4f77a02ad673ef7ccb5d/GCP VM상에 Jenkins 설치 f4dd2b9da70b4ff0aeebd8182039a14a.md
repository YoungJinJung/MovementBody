# GCP VM상에 Jenkins 설치

[https://medium.com/@gouthamravella/installing-jenkins-with-ubuntu-1804-lts-on-google-compute-engine-gcp-bb8e610c31fc](https://medium.com/@gouthamravella/installing-jenkins-with-ubuntu-1804-lts-on-google-compute-engine-gcp-bb8e610c31fc)

## GCP VM Resource

- Compute Engine 으로 Resource 생성
- Ubuntu 18.04 LTS
- HTTP트래픽 허용, HTTPS 트래픽 허용
- ~~Resource Network Configuration?~~

## Jenkins Prerequisites

- 1GB RAM
- JDK 8

```bash
$ sudo apt-get update
```

```bash
$ sudo apt-get install openjdk-8-jdk
```

## Jenkins Install

- Ubuntu LTS 용 Jenkins 설치 ([https://www.jenkins.io/doc/book/installing/](https://www.jenkins.io/doc/book/installing/))

```bash
$ wget -q -O - [https://pkg.jenkins.io/debian-stable/jenkins.io.key](https://pkg.jenkins.io/debian-stable/jenkins.io.key) | sudo apt-key add -
```

```bash
$ sudo sh -c 'echo deb [https://pkg.jenkins.io/debian-stable](https://pkg.jenkins.io/debian-stable) binary/ > \
    /etc/apt/sources.list.d/jenkins.list'
$ sudo apt-get update
$ sudo apt-get install jenkins
```

## Port Configuration (Optional)

Default port : 8080

- 다른 프로세스에서 8080포트 사용시 Jenkins 포트 변경

```bash
$ sudo netstat -tnlp
```

```bash
$ sudo nano /etc/default/jenkins
HTTP_PORT=8080 to **HTTP_PORT=(port_number) 8082?**
```

## Jenkins Start & Status Check

```bash
$ sudo service jenkins start
```

```bash
$ sudo systemctl status jenkins (Jenkins 상태 확인)
```

## VM Resource Network Filewall Rules

GCP 구조가 **프로젝트**안에 **리소스**가 있는 형태로 구성됨.

리소스(VM)안에서 방화벽, 네트워크 포트 등 설정해주어도 해당 리소스의 GCP 프로젝트 단에서 네트워크 및 방화벽 설정이 필요함

![GCP%20VM%E1%84%89%E1%85%A1%E1%86%BC%E1%84%8B%E1%85%A6%20Jenkins%20%E1%84%89%E1%85%A5%E1%86%AF%E1%84%8E%E1%85%B5%20f4dd2b9da70b4ff0aeebd8182039a14a/Untitled.png](GCP%20VM%E1%84%89%E1%85%A1%E1%86%BC%E1%84%8B%E1%85%A6%20Jenkins%20%E1%84%89%E1%85%A5%E1%86%AF%E1%84%8E%E1%85%B5%20f4dd2b9da70b4ff0aeebd8182039a14a/Untitled.png)

VM 리소스 네트워크 세부정보 보기 → 방화벽 → 방화벽(규칙) 만들기

- 네트워크 : default
- 우선순위 : 1000
- 트래픽 방향 : 수진
- 대상 : 지정된 대상 태그 (연결할 VM인스턴스(리소스)에 달린 네트워크 태그 입력. VM만들때 네트워크 태그 안 달았으면 방화벽 규칙에 태그 먼저 지정하고 해당 네트워크 태그을 VM에 달아주기)
- 소스필터 : IP 범위
- 소스 IP 범위 : 0.0.0.0/0
- 프로토콜 및 포트 : 지정된 프로토콜 및 포트. tcp : 8080 (허용할 포트번호)

## Setting

브라우저에서 Jenkins 접근 후 기본 setting 해야함

**(VM Resource 외부IP):(jenkins port)**로 브라우저에서 접속

or

**localhost:(jenkins port)**로 브라우저에서 접속

비밀번호 확인 후 브라우저에 Administrator Password 입력

```bash
$ sudo cat /var/lib/jenkins/secrets/initialAdminPassword
```

Install suggested plugins

Admin 계정 생성

## Slack 알림 연동

[https://dnight.tistory.com/entry/Jenkins-Slack-알림-연동](https://dnight.tistory.com/entry/Jenkins-Slack-%EC%95%8C%EB%A6%BC-%EC%97%B0%EB%8F%99)

Jenkins 자체의 알림은 브라우저에서 (주소:포트)로 접속해 Jenkins 세팅

Slack으로의 알림은 Slack 내의 jenkins app으로 들어가 setting configure

## History

Jenkins 설치 자체는 간단하지만 클라우드 VM상에서 기본적인 설치 및 설정하는데 문제가 있음

GCP 구조가 (프로젝트 → 리소스)로 구성됨.

리소스(VM)안에서 방화벽, 네트워크 포트 등 설정해주어도 해당 리소스의 GCP 프로젝트 단에서 네트워크 및 방화벽 설정이 필요함

VM에서 Jenkins의 포트가 default인 8080으로 설정했으면 GCP 프로젝트 단의 방화벽 규칙에도 추가해줘야함. 즉 VM에 접근시 GCP 프로젝트단에서 네트워크 한 번 거르고 VM에서 거르는 방식

현재 우분투 VM에 Jenkins 설치하는데 **GCP 프로젝**트의 방화벽 규칙, **VM**의 ufw, **jenkins**의 포트 모두 맞춰주고 netstat 확인했는데 외부브라우저에서 접근이 안됨. → **주소 입력 잘못했음**

VM이 ping은 받는데 다른 방식의 접근은 안되고 있음. Jenkins 포트 뿐만 아니라 테스트용으로 설치한 아파치 서버도 응답이 안옴. 

VM 방화벽 규칙에 Jenkins 포트 수신과 송신 규칙 추가해도 반응

**우선은 클라우드 VM 말고 WSL 로컬로 test**

- [x]  Local (WSL) with Private Slack Channel → WSL가 systemd(systemctl) 지원 X
- [x]  GCP with Private Slack Channel
- [x]  GCP with Public Slack Channel
- [ ]  Test Jenkins Item lists
- [ ]  (GCP + K8s + Docker + jenkins + Github + jenkins Item Stack) with Public Slack Channel