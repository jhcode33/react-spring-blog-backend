게시판 만들기 (Spring boot + React)
=

>작업기간: 09.26~10.06(10일)

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


### 🛠️구현기능

- 게시판 기능
    - 모든 게시글 및 특정 게시글 조회
    - 게시글 검색 (제목, 내용, 작성자)
    - 게시글 작성 [회원]
    - 게시글 수정 [회원, 게시글 작성자]
    - 게시글 삭제 [회원, 게시글 작성자]
    - 게시글 답글 작성 [회원]

- 댓글 기능
    - 댓글 조회
    - 댓글 작성 [회원]
    - 댓글 수정 [회원, 댓글 작성자]
    - 댓글 삭제 [회원, 댓글 작성자]

- 회원 기능 + JWT
    - 회원가입
    - 로그인/로그아웃

## 2. 구조 및 설계
### 📦DB 설계
<img width="575" alt="DB-ERD" src="https://github.com/jhcode33/react-spring-blog-backend/assets/125725072/0a8b5201-7e37-4185-949b-284120ae8aa5">
<img width="575" alt="BoardTable" src="https://github.com/jhcode33/react-spring-blog-backend/assets/125725072/4d1b77de-99dc-4d77-8cd2-7724e14d6c08">
<img width="575" alt="CommentTable" src="https://github.com/jhcode33/react-spring-blog-backend/assets/125725072/7c46572e-0c52-4347-8388-40bdd8356db5">
<img width="575" alt="FileTable" src="https://github.com/jhcode33/react-spring-blog-backend/assets/125725072/c50f8267-01d8-4c54-a066-7abf1cf6684a">
<img width="575" alt="MemberTable" src="https://github.com/jhcode33/react-spring-blog-backend/assets/125725072/e33d8344-7988-4b72-bd82-583a4fee7218">

<br>

### 🛰️API 설계
<img width="575" alt="MemberAPI" src="https://github.com/jhcode33/react-spring-blog-backend/assets/125725072/a16121d2-fc55-4761-9fda-d1af53b60eb1">
<img width="575" alt="BoardAPI" src="https://github.com/jhcode33/react-spring-blog-backend/assets/125725072/5467f0b6-e585-4881-8923-07087080acc6">
<img width="575" alt="CommentAPI" src="https://github.com/jhcode33/react-spring-blog-backend/assets/125725072/b6b80f61-1c1f-44df-bcd5-e3ba2e678a0f">
<img width="575" alt="MemberTable" src="https://github.com/jhcode33/react-spring-blog-backend/assets/125725072/c6ee6ea3-6bfd-45af-bccf-eb9e41053089">


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
## 5. 트러블 슈팅🤔
## 6. 회고📝