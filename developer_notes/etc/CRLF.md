# CRLF 관련

각 platform (OS, app)등에서 문자를 보여주는 방식은 어느정도 표준화 되어있지만 약간씩 다름.

ASCII, 유니코드 등 문자표가 존재하며 이를 어떤 방식으로 바꿔서 보여줄지가 인코딩 방식이며 다양한 인코딩 방식이 존재함.

대표적으로 유니코드의 경우 가변 인코딩 방식인 UTF-8이 존재하고 웹에서 URL 인코딩을 하는데 사용되는 URL escape code 같은 것도 존재함.

ASCII에서부터 시작해서 유니코드로 이어져오는 명맥이 있으니 추가적인 정보는 알아서 찾아볼 것

띄어쓰기는 표현하는데 있어 보통 CRLF 방식을 사용함.

CR : Carriage Return (\r)

LF : Line Feed (\n)

(TMI. 타자기 시절부터 줄바꿈을 위해 사용하던 방식인데 입력기와 종이가 움직이는 방식으로 Carriage Return하면 커서를 맨 앞으로 이동. Line Feed 하면 종이를 한 줄 올리는 것)

컴퓨터에서도 같은 의미로 CR과 LF의 조합인 CRLF를 띄어쓰기로 사용했지만 굳이 2Byte를 사용하는 것보다 메모리/스토리지 절약을 위해 CR 혹은 LF 만 사용하기로함.

MS기반 플랫폼에서는 CRLF(\r\n)을 기본으로 사용함.

Unix/Linux 기반 플랫폼에서는 LF(\n)만을 줄바꿈으로 사용함.

Mac 초기 버전은 CR(\r)을 사용했지만 최근엔 LF 사용.

해당 시스템에서 사용하는 default 방식이 위와 같은 것이고 반드시 사용해야 하는 것은 아님. Application 단에서 적절히 처리 가능.

대부분 사용하는 윈도우 기반 플랫폼 (메모장 등)은 CRLF을 기본으로 사용할 것이고 Linux에서 text editor나 terminal에선 LF를 사용.

예를 들어 리눅스에서 만든 text파일을 윈도우에서 읽으면 띄어쓰기 인식 못할 수 있음.

윈도우에서 많이 사용하는 notepad++ 앱을 사용하면 CRLF를 전부 LF로 바꾸거나 LF를 전부 CRLF로 쉽게 바꿀 수 있음.

추가로 git 명령어 사용시 명령어로 자동 CRLF 수정 옵션 설정 가능함. push할 때 설정한 옵션으로 띄어쓰기 인코딩 모두 바꿔서 올라감. 

```bash
$ git config --global core.autocrlf false
```