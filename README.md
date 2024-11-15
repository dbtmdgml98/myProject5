# 일정 관리 앱 서버 만들기

## 일정 API 명세서

|기능|Method|URL|Request|Response|상태코드|
|:---:|:---:|:---:|:-----:|:-----:|:-----:|
|일정 등록|POST|/api/schedules|요청 body|등록 정보|201 Created, 204 NO CONTENT|
|특정 일정 조회|GET|/api/schedules/{id}||단건 응답 정보|200 OK, 204 NO CONTENT|
|전체 일정 조회|GET|/api/schedules||다건 응답 정보|200 OK, 204 NO CONTENT|
|일정 수정|PATCH|/api/schedules/{id}|요청 body|수정 정보|200 OK, 204 NO CONTENT|
|일정 삭제|DELETE|/api/schedules/{id}|||200 OK, 204 NO CONTENT|

<details>
    <summary>일정 등록</summary> 
    
- 설명

|기능|Method|URL|Request|Response|상태코드|
|:---:|:---:|:---:|:-----:|:-----:|:-----:|
|일정 등록|POST|/api/schedules|요청 body|등록 정보|201 Created, 204 NO CONTENT|

- 요청

일정 관리 앱에서 등록할 일정의 데이터를 JSON 형식으로 요청합니다.

|파라미터|타입|필수여부|설명|
|:---:|:---:|:---:|:-----:|
|toDoTitle|String|Y|할일 제목(255자를 넘을 수 없습니다.)|
|toDoContents|String|N|할일 내용|
|userName|String|Y|유저명|


- 참고사항
  
POST /api/schedules

Content-Type: application/json

- 요청 예시
```json

{
    "toDoTitle" : "제목",
    "toDoContents" : "내용",
    "userName" : "홍길동"
}
```
  
- 응답

응답에 성공하면 결괏값을 JSON 형식으로 반환합니다.

|파라미터|타입|필수여부|설명|
|:---:|:---:|:---:|:-----:|
|id|String|Y|일정 고유 식별자|
|toDoTitle|String|Y|할일 제목|
|toDoContents|String|N|할일 내용|

- 참고사항
  
HTTP/1.1 201 Created

Content-Type: application/json

- 응답 예시
```json
{
    "id": 1,
    "toDoTitle": "제목",
    "toDoContents": "내용"
}
```
    
</details>

<details>
    <summary>특정 일정 조회</summary> 

- 설명

|기능|Method|URL|Request|Response|상태코드|
|---|---|---|---|---|---|
|특정 일정 조회|GET|/api/schedules/{id}||단건 응답 정보|200 OK, 204 NO CONTENT|

- 요청 X

- 참고사항
  
GET /api/schedules/{id}

- 응답
  
응답에 성공하면 결괏값을 JSON 형식으로 반환합니다.

|파라미터|타입|필수여부|설명|
|:---:|:---:|:---:|:-----:|
|id|String|Y|일정 고유 식별자|
|toDoTitle|String|Y|할일 제목|
|toDoContents|String|N|할일 내용|

- 참고사항
  
HTTP/1.1 200 OK

Content-Type: application/json

- 응답 예시
```json
{
    "id": 1,
    "toDoTitle": "제목",
    "toDoContents": "내용"
}
```

    
</details>

<details>
    <summary>전체 일정 조회</summary> 

- 설명

|기능|Method|URL|Request|Response|상태코드|
|---|---|---|---|---|---|
|전체 일정 조회|GET|/api/schedules||다건 응답 정보|200 OK, 204 NO CONTENT|

- 요청 X

- 참고사항
  
GET /api/schedules

- 응답
  
응답에 성공하면 결괏값을 JSON 형식으로 반환합니다.

|파라미터|타입|필수여부|설명|
|:---:|:---:|:---:|:-----:|
|id|String|Y|일정 고유 식별자|
|toDoTitle|String|Y|할일 제목|
|toDoContents|String|N|할일 내용|

- 참고사항
  
HTTP/1.1 200 OK

Content-Type: application/json

- 응답 예시
```json
[
    {
        "id": 1,
        "toDoTitle": "제목",
        "toDoContents": "내용"
    },

    {
        "id": 2,
        "toDoTitle": "제목2",
        "toDoContents": "내용2"
    }
]
```
</details>

<details>
    <summary>일정 수정</summary> 
- 설명

|기능|Method|URL|Request|Response|상태코드|
|---|---|---|---|---|---|
|일정 수정|PATCH|/api/schedules/{id}|요청 body|수정 정보|200 OK, 204 NO CONTENT|   
- 요청

일정 관리 앱에서 수정할 일정의 데이터를 JSON 형식으로 요청합니다.

|파라미터|타입|필수여부|설명|
|:---:|:---:|:---:|:-----:|
|toDoTitle|String|N|할일 제목|
|toDoContents|String|N|할일 내용|
|userName|String|N|유저명|


- 참고사항
  
PATCH /api/schedules/{id}

Content-Type: application/json

- 요청 예시
```json

{
    "toDoTitle": "수정된 제목",
    "toDoContents": "수정된 내용",
    "userName": "김수정"
}
```

- 응답
  
응답에 성공하면 결괏값을 JSON 형식으로 반환합니다.

|파라미터|타입|필수여부|설명|
|:---:|:---:|:---:|:-----:|
|id|String|Y|일정 고유 식별자|
|toDoTitle|String|Y|할일 제목|
|toDoContents|String|N|할일 내용|

- 참고사항
  
HTTP/1.1 200 OK

Content-Type: application/json

- 응답 예시
```json
{
    "id": 1,
    "toDoTitle": "수정된 제목",
    "toDoContents": "수정된 내용"
}
```
    
</details>

<details>
    <summary>일정 삭제</summary> 
    
- 설명

|기능|Method|URL|Request|Response|상태코드|
|---|---|---|---|---|---|
|일정 삭제|DELETE|/api/schedules/{id}|||200 OK, 204 NO CONTENT|

- 요청 X

- 참고사항
  
DELETE /api/schedules/{id}

- 응답 X

- 참고사항
  
HTTP/1.1 200 OK
    
</details>


## 일정 SQL 작성

### CREAT (일정 테이블 생성)

```mysql
-- 테이블 생성 (schedule)
CREATE TABLE schedule
(
        id BIGINT AUTO_INCREMENT PRIMARY KEY COMMENT '일정 고유 식별자',
        user_id BIGINT COMMENT '사용자 고유 식별자',
        created_at DATETIME(6) COMMENT '작성일',
        modified_at DATETIME(6) COMMENT '수정일',
        to_do_title VARCHAR(255) NOT NULL COMMENT '할일 제목',
        to_do_contents LONGTEXT COMMENT '할일 내용'

);

```

### INSERT (일정 등록)
```mysql
-- schedule 테이블에 데이터 삽입
INSERT INTO schedule (id, user_id, created_at, modified_at, to_do_title, to_do_contents) VALUES('1', '1', 2024-11-01', '2024-11-15', '제목', '내용');
INSERT INTO schedule (id, user_id, created_at, modified_at,  to_do_title, to_do_contents) VALUES('2', '2', '2024-11-15', '2024-11-20', '제목2', '내용2');

```

### SELECT (특정 일정 조회 & 전체 일정 조회)
  
```mysql
-- schedule 식별자로 단건 조회
SELECT * FROM schedule WHERE id = 1;

-- schedule 전체 조회
SELECT * FROM schedule;

```

### UPDATE (일정 수정)

```mysql
-- schedule_id가 1인 일정의 to_do_title을 '수정된 제목'으로 업데이트
UPDATE schedule SET to_do_title = '수정된 제목' WHERE id = '1';

```
  
### DELETE (일정 삭제)

```mysql
-- 식별자 1번의 schedule 삭제
DELETE FROM schedule WHERE id = 1;

```








## 유저 API 명세서

|기능|Method|URL|Request|Response|상태코드|
|:---:|:---:|:---:|:---:|:---:|:---:|
|유저 등록|POST|/api/users|요청 body|등록 정보|201 Created, 204 NO CONTENT|
|특정 유저 조회|GET|/api/users/{id}||단건 응답 정보|200 OK, 204 NO CONTENT|
|유저 삭제|DELETE|/api/users/{id}|||200 OK, 204 NO CONTENT|

<details>
    <summary>유저 등록</summary> 

- 설명

|기능|Method|URL|Request|Response|상태코드|
|---|---|---|---|---|---|
|유저 등록|POST|/api/users|요청 body|등록 정보|201 Created, 204 NO CONTENT|

- 요청
  
유저가 등록할 데이터를 JSON 형식으로 요청합니다.

|파라미터|타입|필수여부|설명|
|:---:|:---:|:---:|:-----:|
|userName|String|Y|유저 이름 (255자를 넘을 수 없습니다.)|
|email|String|Y|유저 이메일 (255자를 넘을 수 없습니다.)|
|password|String|Y|유저 비밀번호 (255자를 넘을 수 없습니다.)|


- 참고사항
  
POST /api/users

Content-Type: application/json

- 요청 예시
```json

{
    "userName" : "홍길동",
    "email" : "a@a.com",
    "password" : "1234"
}
```

- 응답
  
응답에 성공하면 결괏값을 JSON 형식으로 반환합니다.

|파라미터|타입|필수여부|설명|
|:---:|:---:|:---:|:-----:|
|id|String|Y|유저 고유 식별자|
|userName|String|Y|유저 이름 (255자를 넘을 수 없습니다.)|
|email|String|Y|유저 이메일 (255자를 넘을 수 없습니다.)|

- 참고사항
  
HTTP/1.1 200 OK

Content-Type: application/json

- 응답 예시
```json
{
    "id": 1,
    "userName": "홍길동",
    "email": "a@a.com"
}
```

</details>

<details>
    <summary>특정 유저 조회</summary> 
    
- 설명

|기능|Method|URL|Request|Response|상태코드|
|---|---|---|---|---|---|
|특정 유저 조회|GET|/api/users/{id}||단건 응답 정보|200 OK, 204 NO CONTENT|

- 요청 X

- 참고사항
  
GET /api/users/{id}


- 응답
  
응답에 성공하면 결괏값을 JSON 형식으로 반환합니다.

|파라미터|타입|필수여부|설명|
|:---:|:---:|:---:|:-----:|
|userName|String|Y|유저 이름 (255자를 넘을 수 없습니다.)|
|email|String|Y|유저 이메일 (255자를 넘을 수 없습니다.)|

- 참고사항
  
HTTP/1.1 200 OK

- 응답 예시
```json
{
    "userName": "홍길동",
    "email": "a@a.com"
}
```

</details>


<details>
    <summary>유저 삭제</summary> 
    
- 설명

|기능|Method|URL|Request|Response|상태코드|
|---|---|---|---|---|---| 
|유저 삭제|DELETE|/api/users/{id}|||200OK, 204 NO CONTENT|

- 요청 X

- 참고사항
  
DELETE /api/users/{id}

- 응답 X
  
- 참고사항
 
HTTP/1.1 200 OK

</details>
           

## 유저 SQL 작성

### CREAT (유저 테이블 생성)

```mysql
-- 테이블 생성 (user)
CREATE TABLE user
(
    id BIGINT AUTO_INCREMENT PRIMARY KEY COMMENT '유저 고유 식별자',
    user_name VARCHAR(255) NOT NULL COMMENT '유저명',
    created_at DATETIME(6) COMMENT '작성일',
    modified_at DATETIME(6) COMMENT '수정일',
    email VARCHAR(255) COMMENT '유저 이메일',
    password VARCHAR(255) NOT NULL COMMENT '유저 비밀번호'
);

```

### INSERT (유저 등록)
```mysql
-- user 테이블에 데이터 삽입
INSERT INTO user (id, user_name, created_at, modified_at, email, password) VALUES('1', '홍길동', '2024-11-15', '2024-11-16', 'a@a.com', '1234');
INSERT INTO user (id, user_name, created_at, modified_at, email, password) VALUES('2', '김길동', '2024-11-01', '2024-11-06', 'b@b.com', '1234');
```

### SELECT (특정 유저 조회)
  
```mysql
-- user 식별자로 단건 조회
SELECT * FROM user WHERE id = 1;

```
  
### DELETE (유저 삭제)

```mysql
-- 식별자 1번의 user 삭제
DELETE FROM user WHERE id = 1;
```



## ERD 설계
    - E(Entity. 개체)
        - 구현 할 서비스의 영역에서 필요로 하는 데이터를 담을 개체를 의미합니다.
            - ex) '일정', '유저'
            
    - A(Attribute. 속성)
        - 각 개체가 가지는 속성을 의미합니다.
            - ex) 
            
            일정 : '일정 id', '할일 제목', '할일 내용'
            유저 : '유저 id', '유저명', '이메일', '비밀번호'
            
    - R(Relationship. 관계)
        - 개체들 사이의 관계를 정의합니다.

        한 명의 유저는 여러개의 일정을 작성할 수 있다(단방향). 이때, 유저와 일정의 관계는 일대다(1:N) 관계입니다.
        -> 일정은 '유저 id(유저 고유 식별자)'를 속성으로 갖는다!

<img width="581" alt="스크린샷 2024-11-15 오후 4 26 47" src="https://github.com/user-attachments/assets/b7bd69b4-32d2-41fd-9c9a-8741abae57cf">
