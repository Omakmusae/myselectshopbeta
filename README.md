
Project - myselectshopbeta
===

> 자바, 스프링 학습을 위해서 `Naver Open API`, `Restful API`, `로그인기능`를 이용하여 진행하는 상품 가격 비교 프로젝트. 

## 개발환경

|도구|버전|
|:---:|:---:|
| Framework |Spring Boot 2.2.1 |
| OS |Windows 10, Ubuntu 18.04|
| IDE |IntelliJ IDEA Ultimate |
| JDK |JDK 1.8+|
| DataBase |MongoDB Server 4.2.1|
| Build Tool | Gradle 4.8.1 |

## 개발 방법
<details><summary>세부정보</summary>

* 개발과 관련된 모든 이야기는 [Issues](https://github.com/donghL-dev/Reactive-Blog/issues)에서 진행합니다.

* `API` 및 도메인 명세를 기반으로 개발을 진행하며, 명세에 변경사항이 생길 경우 빠른 시일내에 최신화 합니다.

* **Fork**를 통한 `PR`을 지향합니다.

* 아래와 같은 `Git Workflow`를 지향하며 지키려고 노력합니다. ([참고](https://nvie.com/posts/a-successful-git-branching-model/?))

    <img width=750, height=850, src="https://camo.githubusercontent.com/7f2539ff6001fe7700853313e7cdb7fd4602e16a/68747470733a2f2f6e7669652e636f6d2f696d672f6769742d6d6f64656c4032782e706e67">

</details>

## 실행 방법
<details><summary>세부정보</summary>

* 준비사항.

    * `Gradle` or `IntelliJ IDEA`

    * `JDK` (>= 1.8)

    * `Spring Boot` (>= 2.x)

* 저장소를 `clone`

    ```bash
    $ git clone https://github.com/donghL-dev/Reactive-Blog.git
    ```

* 데이터 베이스는 `MongoDB`를 사용해야 합니다.

* 프로젝트 내 `Reactive-Blog\src\main\resources` 경로에 `application.yml` 생성.

    * 밑의 양식대로 내용을 채운 뒤, `application.yml`에 삽입.
    <br>

    ```yml
    spring:
        data:
            mongodb:
                host: # 본인의 DB 서버 주소를 넣으면 되는데, 왠만하면 localhost입니다.
                port: # 본인의 DB 서버 PORT 왠만하면 27017입니다.
                database: # 본인의 데이터베이스 이름을 기재하시면 됩니다.
    ```

* `IntelliJ IDEA`(>= 2018.3)에서 해당 프로젝트를 `Open`

    * 또는 터미널을 열어서 프로젝트 경로에 진입해서 다음 명령어를 실행.

    * `Windows 10`

        ```bash
        $ gradlew bootRun
        ```

    * `Ubuntu 18.04`

        ```
        $ ./gradlew bootRun
        ```

</details>

## Dependencies
<details><summary>세부정보</summary>

* `Spring Reactive Web`

* `Spring Data Reactive MongoDB`

* `Embedded MongoDB Database`

* `Spring Security`

* `Lombok`

</details>

## 도메인 명세

* [도메인 명세 문서](https://www.notion.so/dhlab/52ff6bb691934fbabeca5287bc32dffb)

## API 명세 
<details><summary>세부정보</summary>

* 모든 `API`에 대한 반환은 `Content-Type: application/json; charset=utf-8`를 기본으로 합니다.

* 인증(`auth`)은 `HTTP` 헤더를 사용해서 진행됩니다.<br>

    | Key | Value |
    |:---:|:---:|
    | Content-Type | `application/json` |
    | Authorization | `token` |

* `Response`
    
    * `Default Success Code`

        ```json
        {
            "body": {
                "status": "200 OK",
                "message": "Your request has been successfully processed."
            }
        }
        ```

* 대표적인 에러 코드

    * `401 for Unauthorized requests`



* End Point

    * 사용자 및 로그인 <br><br>

    | Title | HTTP Method | URL | Request | Response | Auth
    |:---:|:---:|:---:|:---:|:---:|:---:|
    | `Registration` | `POST` | `/api/users` | `{ "user":{ "username": "sangkon", "email": "me@sangkon.com", "password": "qwer1234" } }` | `User` | `NO`
    | `Authentication` | `POST` | `/api/users/login` | `{ "user":{ "email": "demo@demo.com", "password": "X12345678" } }` | `User` | `No`
    | `Authentication expiration` | `POST` | `/api/users/logout` |  | `Default Success Code` | `YES`
    | `Current User` | `GET` | `/api/user` |  | `Current User` | `YES`
    | `Update User` | `PUT` | `/api/user` | `{ "user":{ "email": "me@sangkon.com", "bio": "Java developer", "image": "image URL" } }` | `User` | `YES`
    | `Get Profile` | `GET` | `/api/profiles/:username` |  | `Profile` | `NO`
    | `Fallow User` | `POST` | `/api/profiles/:username/follow` |  | `Profile` | `YES`
    | `Unfallow User` | `DELETE` | `/api/profiles/:username/follow` |  | `Profile` | `YES`
    

</details>

## Reference
<details><summary>세부정보</summary>
<br>

* [Spring Seucrity 적용 및 JWT 토큰 관련 참고 페이지](https://medium.com/@ard333/authentication-and-authorization-using-jwt-on-spring-webflux-29b81f813e78?)

</details>
