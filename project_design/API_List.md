# API 정리 문서

# 목차

1. 식단 입력
```
> Input 
    {
        "userName" : "test",
        "foodKey" : 1,
        "foodName" : "milk",
        "time"     : timestamp?Date?
    }

> Output  
    {
        "result":1000(Error Code 출력)/2000
    }
```
2. 음식 검색 기능
```
> Input 
    {
        "foodName" : "milk" , 
        "foodCode" : "etc" (optional)
    }

> Output  
    {
        "result":1000(Error Code 출력)/2000,
        "foodName" : "milk",
        "foodKcal" : 123,
        "Nutritions" : {
            "탄":~~,
            "단":~~,
            "지":~~
        }        
    }
```
3. 식단 히스토리 조회(일별, 주별)
```
> Input 
 {  
        "userName":"Test",
        "type": D     
 }  
> Output  
    {
        "result":1000(Error Code 출력)/2000,
        "FoodHistory":{
            "morning":{
            },
            "lunch":{
            },
            "dinner":{
            }
        }
    }
```
4. 현재 부족한 영양소 조회
```
> Input 
    {
        "userName" : "Test",
        
    }  
> Output  
    {
        "result":1000(Error Code 출력)/2000,
        "Nutritions" : {
                    "탄":~~,
                    "단":~~,
                    "지":~~
                }
    }
```
5. 추천 음식 조회
```
> Input 
 {  
     "basicKcal" : 1234(int),  
     "movement"  : 3(1~5단계)     
 }  
> Output  
    {
        "result":1000(Error Code 출력)/2000,
        "recommandFoodList":{
        }
    }
```
6. 현재(오늘)까지의 kcal 섭취량 조회
```
> Input 
    {  
        "userName" : "test",
        "time" : timestamp(ms)(double)  
    } 
> Output  
    {
        "result":1000(Error Code 출력)/2000
        "totalKcal" : 2000,
        "remainKcal" : 500,
        "eatingKcal" : 1500,
        "eatingList" : {
            "food1" : "milk",
            "food2" : "bread",
             ...
         }
    }
```
7. 기초 대사량 입력(활동량에 따라)
```
> Input 
    {
        "baseKcal" : 1234(int),  
        "movement"  : 3(1~5단계)     
    }
> Output  
    {
        "result":1000(Error Code 출력)/2000
    }
```
8. 권장 대사량 조회
```
> Input 
    {  
        "userName" : "test",  
    } 
> Output  
    {
        "result":1000(Error Code 출력)/2000,
        "DailyKcal" : 2000,
        "movement" : 3
    }
```
