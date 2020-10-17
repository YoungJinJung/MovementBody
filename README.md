# Food Diary

## Due Date
> 1st Due ( ~ 10.20) -> About Food  
> 2nd Due ( ~ 12.20) -> About Food & Body & Exercise
>

## Tech Stack
> ###UI
>> Kotlin
>
> ###BackEnd
>> SpringBoot(2.3.3)  
>> JDK 1.8  
>> MySQL  
>> JPA or MyBatis
>
> ###Infa
>> GitHub(Source Repository)  
>> Jenkins(CI/CD)  
>> GCP(Cloud Env.)  
>
> ###Development Tools
>> Notion  
>> Skype  
>> Slack
>
>
## Commit Rule
> #### 1. 모든 작업은 브랜치를 따서 개인 브랜치로 진행
> #### 2. 하나의 기능이 완성된 후, commit & push 그전까지는 local branch에 가지고 있을 것
> #### 3. Commit 규칙은 다음과 같다.
>> #### 1. 브랜치 이름은 feature-(git에 등록한 issue번호) 
>> ##### issue는 github페이지의 code옆의 issue탭에서 등록 혹은 조회, 수정, 삭제 가능
>> ##### 예시 : 음식 관련 목록 조회 API기능을 구현한다면, feature-#1, 다 구현한 후 master 브랜치에 머지하도록 한다.(master 브랜치에 직접 수정 하지 말 것.)
>> #### 2. 브랜치에 commit을 할 때는 커밋 이름은 다음 규칙을 따른다.
>>> ##### keyword: feat(기능구현), fix(기능수정), temp(중간커밋), doc(문서), chore(복붙이나 단순작업)
>>> ##### 위의 키워드를 prefix로 한다. 그 다음은 backend 혹은 패키지 이름으로 한다.
>>> ##### 예시 - feat(controller) : 음식 관련 API 구현 
>>> ##### 이 commit 이름이 되고, 무엇을 수정하였는지 아래에 적는다.  
