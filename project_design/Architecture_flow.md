# 전체적인 Flow 정리

![%E1%84%8C%E1%85%A5%E1%86%AB%E1%84%8E%E1%85%A6%E1%84%8C%E1%85%A5%E1%86%A8%E1%84%8B%E1%85%B5%E1%86%AB%20Flow%20%E1%84%8C%E1%85%A5%E1%86%BC%E1%84%85%E1%85%B5%203d2eb53f18504f6fae00f730405ad8f2/MovementBody().png](%E1%84%8C%E1%85%A5%E1%86%AB%E1%84%8E%E1%85%A6%E1%84%8C%E1%85%A5%E1%86%A8%E1%84%8B%E1%85%B5%E1%86%AB%20Flow%20%E1%84%8C%E1%85%A5%E1%86%BC%E1%84%85%E1%85%B5%203d2eb53f18504f6fae00f730405ad8f2/MovementBody().png)

1. Kotlin을 활용하여 Application 파트 개발
    1. Application에서는 Back-End Server로 RestAPI를 통한 요청
2. 요청을 받은 Back-End Server는 SpringBoot로 개발
    - 서버에는 RestAPI를 통해 온 요청대로 처리로직을 태우고
    - DB와 직접적인 통신을 한다.
3. 응답 받은 Kotlin back-end에서는 받은 데이터를 토대로 APP UI Update