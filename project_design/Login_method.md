# 로그인 방법

# 로그인 방안

---

1. 직접 구현한다.
    - 이 때는 정책이나 보안 방법(암호화 등)에 대한 고려가 필요
2. **구글이나 카카오, 네이버 아이디를 활용**
    - 이 때는 각 아이디와 닉네임만 맵핑해서 사용하면 되지 않을까라는 생각
    - 자세한 방법은 찾아봐야할 것으로 보여짐.
    - 구글서버에 요청 및 Spring으로 토큰 받아서. DB에 저장할지, 메모리에 저장할지. (OAuth)

3. 로그인 유지

~~4. (Additional) 아이디 찾기, 비밀번호 찾기~~

# 선행 과제

---

1. 일단 APP UI에서 어떻게 처리하는지를 찾아봐야하고,
    1.  UI에서 로그인이 되고 닉네임을 입력할 때 체크로직을 넣는 것이 좋을 거 같음.
2. back로는 ID와 닉네임 정도만 넘겨줄것인지?
3. 이를 어떻게 저장할지(별도 테이블?)

## Reference

---

- [http://yoonbumtae.com/?p=2652](http://yoonbumtae.com/?p=2652)
- [https://engkimbs.tistory.com/849](https://engkimbs.tistory.com/849)
- [https://codesource.io/setting-up-google-authentication-in-a-kotlin-android-app/](https://codesource.io/setting-up-google-authentication-in-a-kotlin-android-app/)