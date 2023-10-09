게시판 만들기 (Spring boot + React)
=

>작업기간: 2023.09.26 ~ 2023.10.06 (10일) <br>
>📑Backend Repository: https://github.com/jhcode33/react-spring-blog-backend <br>
>📑Frontend Repository: https://github.com/jhcode33/react-spring-blog-frontend

React와 Spring boot를 활용한 SPA 게시판 프로젝트입니다. 아래와 같은 문제에 대해 고민하며 프로젝트를 진행했고, 최선의 해결책을 찾아서 코드를 작성했습니다. 

- 회원 인증/인가(JWT)
- N + 1 문제
- Entity 양방향 관계, JSON 직렬화 문제


# 📚목차
- [프로젝트 소개와 기능](#1-소개와-기능)
  - [프로젝트 소개](#소개) 
  - [구현 기능](#구현기능)

- [프로젝트 구조 및 설계](#2-구조-및-설계)
    - [DB 설계](#DB-설계)
    - [API 설계](#API-설계)

- [기술 스택](#3-기술-스택)
  - [백엔드](#Backend)
  - [프론트엔드](#Frontend)

- [실행 화면](#4-실행-화면)
- [트러블 슈팅](#5-트러블-슈팅)

- [회고](#6-회고)
    - [아쉬운 점](#1-아쉬운-점)
    - [후기](#2-후기)


## 1. 소개와 기능
### 💬소개
> 지금까지 배운 것을 기반으로 SPA 방식의 프로젝트를 처음으로 구현해보았습니다. <br>
> 웹 프로그래밍의 기본 소양으로 여겨지는 게시판을 직접 만들어 보면서, 
> 효율적인 데이터 처리와 데이터 변환 등 다양한 개발 문제에 직면하고 해결책을 찾아갔습니다.

- CRUD + Rest API + SPA
- 개발 기간 : 2023.09.26 ~ 2023.10.06
- 참여 인원 : 1명

<br>

### 🛠️구현기능

- **게시판 기능**
    - 모든 게시글 및 특정 게시글 조회
    - 게시글 검색 (제목, 내용, 작성자)
    - 게시글 작성 [회원]
    - 게시글 수정 [회원, 게시글 작성자]
    - 게시글 삭제 [회원, 게시글 작성자]
    - 게시글 답글 작성 [회원]

- **댓글 기능**
    - 댓글 조회
    - 댓글 작성 [회원]
    - 댓글 수정 [회원, 댓글 작성자]
    - 댓글 삭제 [회원, 댓글 작성자]

- **회원 기능 + JWT**
    - 회원가입
    - 로그인/로그아웃

<br>

## 2. 구조 및 설계
### 📦DB 설계

---
<img width="575" alt="DB-ERD" src="https://github.com/jhcode33/react-spring-blog-backend/assets/125725072/0a8b5201-7e37-4185-949b-284120ae8aa5">
<img width="575" alt="BoardTable" src="https://github.com/jhcode33/react-spring-blog-backend/assets/125725072/4d1b77de-99dc-4d77-8cd2-7724e14d6c08">
<img width="575" alt="CommentTable" src="https://github.com/jhcode33/react-spring-blog-backend/assets/125725072/7c46572e-0c52-4347-8388-40bdd8356db5">
<img width="575" alt="FileTable" src="https://github.com/jhcode33/react-spring-blog-backend/assets/125725072/c50f8267-01d8-4c54-a066-7abf1cf6684a">
<img width="575" alt="MemberTable" src="https://github.com/jhcode33/react-spring-blog-backend/assets/125725072/e33d8344-7988-4b72-bd82-583a4fee7218">

<br><br>

### 🛰️API 설계

---
<img width="575" alt="MemberAPI" src="https://github.com/jhcode33/react-spring-blog-backend/assets/125725072/a16121d2-fc55-4761-9fda-d1af53b60eb1">
<img width="575" alt="BoardAPI" src="https://github.com/jhcode33/react-spring-blog-backend/assets/125725072/5467f0b6-e585-4881-8923-07087080acc6">
<img width="575" alt="CommentAPI" src="https://github.com/jhcode33/react-spring-blog-backend/assets/125725072/b6b80f61-1c1f-44df-bcd5-e3ba2e678a0f">
<img width="575" alt="MemberTable" src="https://github.com/jhcode33/react-spring-blog-backend/assets/125725072/c6ee6ea3-6bfd-45af-bccf-eb9e41053089">

<br>

## 3. 기술 스택
### 📌Backend
| 기술                | 버전     |
|-------------------|--------|
| Spring Boot       | 3.1.4  |
| Spring Web        | 3.1.0  |
| Spring Security   | 3.0.4  |
| Spring Data Jpa   | 3.0.4  |
| Bean Validation   | 3.1.0  |
| JSON Web Token    | 0.11.5 |
| MySQL Connector J | 8.0.32 |

### 🎨Frontend
| 기술                  | 버전      |
|---------------------|---------|
| NodeJS              | 16.16.0 |
| React               | 18.2.0  |
| axios               | 0.27.2  |
| react-axios         | 2.0.6   |
| react-dom           | 18.2.0  |
| react-js-pagination | 3.0.3   |
| react-router        | 6.3.0   |
| react-router-dom    | 6.3.0   |
| react-scripts       | 5.0.1   |


## 4. 실행 화면

- Main

  <img width="575" alt="FrontEnd-Main" src="https://github.com/jhcode33/react-spring-blog-backend/assets/125725072/308af2ac-17ee-4091-b60c-c1c926d8afbe">

- Join

  <img width="575" alt="FrontEnd-Join" src="https://github.com/jhcode33/react-spring-blog-backend/assets/125725072/f5e7db67-3527-4dab-aaa1-5ac3dbb2056f">
  <img width="575" alt="isExistEmail" src="https://github.com/jhcode33/react-spring-blog-backend/assets/125725072/08b84255-082f-4dba-b668-5dd36517ca9b">
  <img width="575" alt="Join" src="https://github.com/jhcode33/react-spring-blog-backend/assets/125725072/4da4830c-4c29-4f0f-b025-df6b3b29cb84">

- List

  <img width="575" alt="FrontEnd-List" src="https://github.com/jhcode33/react-spring-blog-backend/assets/125725072/129a287c-8b16-4157-9a3a-b1bb57ab0a54">

- SearchList

  <img width="575" alt="Search" src="https://github.com/jhcode33/react-spring-blog-backend/assets/125725072/e689a1b1-ec08-46fb-bd5c-a70745351f77">
  <img width="575" alt="Searching" src="https://github.com/jhcode33/react-spring-blog-backend/assets/125725072/5f6366e0-31db-4458-85ce-dde37e4245ff">

- BoardWrite

  <img width="575" alt="Write" src="https://github.com/jhcode33/react-spring-blog-backend/assets/125725072/32f3b3bf-0018-4c90-b6c5-c3dc752ddf8b">
  <img width="575" alt="BoardWrite" src="https://github.com/jhcode33/react-spring-blog-backend/assets/125725072/df630b7c-1284-4961-9a57-650a13ace425">

- BoardUpdate

  <img width="575" alt="BoardUpdate" src="https://github.com/jhcode33/react-spring-blog-backend/assets/125725072/02cf74f7-786f-447f-8fad-aa0689edbabe">

- Details

  <img width="575" alt="Details" src="https://github.com/jhcode33/react-spring-blog-backend/assets/125725072/705dcf5f-d93b-454b-9267-1176628fd20c">

- Details-login

  <img width="575" alt="Details_login" src="https://github.com/jhcode33/react-spring-blog-backend/assets/125725072/090b59ee-a450-4fda-bb8c-b8ba72c74b76">

- Comment

  <img width="575" alt="CommentPaging" src="https://github.com/jhcode33/react-spring-blog-backend/assets/125725072/658f15a5-4149-404d-942e-2509a564726b">

- File-Download

  <img width="575" alt="FileDownload" src="https://github.com/jhcode33/react-spring-blog-backend/assets/125725072/9030bde2-02fb-468c-b649-05e1c05713f0">

## 5. 트러블 슈팅🤔
### N + 1 해결 => @BatchSize

- Jh's Notion:  <a href="https://jhcode33.notion.site/OneToMany-Paging-N-1-8e04fd0b85ba4a829f496ba0ed2be02e?pvs=4">@OneToMany Paging, N + 1 해결</a>

  <img width="575" alt="boards" src="https://github.com/jhcode33/react-spring-blog-backend/assets/125725072/8684a3c2-e293-456d-b0f5-023c122bdae2">
  <img width="575" alt="comments" src="https://github.com/jhcode33/react-spring-blog-backend/assets/125725072/cdf2e135-2fd5-467c-bcab-ad3dd5791a03">
  
  연관된 Comment Entity를 in 쿼리로 한 번에 가져옵니다. N + 1의 문제를 1 + 1로 해결합니다. 자세한 것을 링크에 기록해두었습니다.

<br>

### DTO에 관한 생각

- Jh's Notion:  <a href="https://jhcode33.notion.site/DTO-128ec14ad6c445d7af846e0a777ca61a?pvs=4">DTO에 관한 생각</a>

  <img width="575" alt="fromEntity" src="https://github.com/jhcode33/react-spring-blog-backend/assets/125725072/f861e613-d654-45fe-97f8-bda52394520f">
  <img width="575" alt="ofEntity" src="https://github.com/jhcode33/react-spring-blog-backend/assets/125725072/bbefa15d-bce0-4b58-bd19-862f6d64dd85">

  Request와 Response로 정확한 데이터를 주고 받고, JSON 직렬화 문제를 해결하기 위해 DTO 클래스를 사용했습니다.
  Entity를 응답으로 반환하는 것이 아닌 DTO로 매핑하여 반환할 수 있도록 static 메소드를 통해서 DTO <-> 엔티티 간의 변환을 했습니다.


## 6. 회고📝
### 1. 아쉬운 점

- React는 처음이라 프론트 작업을 할 때 시간이 많이 소요되었습니다. 
  백엔드 API에 집중하던 시간보다 프론트엔드 작업에 소모했던 시간이 더 많아서 아쉽습니다.
  그로 인해 JWT, Security 등 관련 코드를 깊게 볼 시간이 부족했던 점이 많이 아쉬웠습니다.

- JWT 관련 로직을 조금 더 자세하게 들여다보고 싶었지만 간단하게 구성만 한 부분이 아쉽습니다. 작업 기간인 10일 이후에도 꾸준히 보강해서 업그레이드 해보겠습니다.
- 테스트 코드를 작성하지 못한게 아쉽습니다. PostMan을 통해서 모든 로직을 검증했지만, 테스트 코드로 검증했다면 조금 더 이슈나 에러 관리에 쉽지 않았을까라는 생각을 합니다.



### 2. 후기

지금까지 배워왔던 것을 토대로 SPA 블로그를 처음 구현했습니다. React가 처음이지만, 처음이라도 관련 자료를 찾아보면서 ‘구현’할 수 있도록 노력했습니다. 배웠던 것만 사용하는 것이 아니라, 배우지 않은 부분도 부딪히면서 구현하고 완성시키려고 했던 시간들이 가장 기억에 남습니다.

강의와, 책에서 공부한 예제들과 블로그 및 여러 커뮤니티에서 문제와 에러에 대한 해결책을 찾을 수 있었습니다. “DTO ↔ Entity 간에 변환 로직을 어떻게, 어디에 작성해야 하는지”, “N + 1 문제를 어떻게 해결하는지” 등 문제에 대해 고민하고, 올바르게 검색하는 방법을 통해서 해결책을 찾아 갔습니다.

프로젝트를 통해 배웠던 기술들을 사용해 보면서 앞으로 내가 필요한 기술과 더욱 채워야할 지식 등을 더 잘 알 수 있게 되었습니다. 탄탄하고 체계적인 설계와 테스트 코드가 얼마나 중요한지 깨닫는 시간이었습니다. 새로운 기술과 코드에 두려워하지 않고, 체계적이고 튼튼한 서비스를 구축하는 개발자가 되어야겠다고 다짐하게 되는 프로젝트였습니다.

긴 글 읽어주셔서 감사합니다! 🤗