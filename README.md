# TODO LIST
기술구조
--------
```
SPRING
- JPA
- SPRINGBOOT
- SECURITY
- HTML
DBMS 
- MySQL
```

개요
--------
```
기본 CRUD를 이용한 TODO 프로그램을 구현해 봤습니다.

회원
- 로그인(SECURITY적용)
- 회원 가입
- 회원 정보 수정
- 회원 정보 조회

TODO
- TODO등록
- TODO수정
- TODO삭제
- TODO검색
- TODO상세보기

```

ERD
-------

![erd](https://user-images.githubusercontent.com/113006951/209290560-a7c84380-faf2-4b75-a18f-1f9a84e0fc39.JPG)
```

```
회원
--------
```
- 회원가입 (ROLE - USER 자동INSERT)
```
![회원가입](https://user-images.githubusercontent.com/113006951/209263647-5501f597-9120-4337-a967-aff47ef58389.png)
```
- 회원DB
```
![회원DB](https://user-images.githubusercontent.com/113006951/209263703-547f8576-705e-4639-8c86-9589d4342124.png)
```
- 내정보조회(USER)
```
![내정보](https://user-images.githubusercontent.com/113006951/209264580-4735f169-6c3d-4d70-b99c-f31661b9d97b.png)
```
- 회원정보조회(ADMIN)
```
![회원리스트](https://user-images.githubusercontent.com/113006951/209265402-9964e09c-5dee-4f2e-9ae3-0b39cd09e207.png)
```
- 로그인 폼(SECURITY 기본화면)
```
![SECURITY로그인](https://user-images.githubusercontent.com/113006951/209263822-b7e6a47c-8403-4ac7-b005-883155d52dd2.png)
```
- 로그인 전 홈페이지(회원가입, 로그인 버튼 활성화)
```
![로그인전](https://user-images.githubusercontent.com/113006951/209263875-f0616639-384a-4140-bac7-647dbd028ec4.png)
```
- 로그인 후 홈페이지(USER - 로그아웃, 내정보 버튼 활성화 / ADMIN - 회원리스트 버튼 활성화)
```
![로그인후](https://user-images.githubusercontent.com/113006951/209263933-ce13b72b-2500-4940-82c9-77a628cea79b.png)


TODO등록
--------
```
- 전체목록
```
![TODO리스트](https://user-images.githubusercontent.com/113006951/209263971-574a20b8-bac4-46e5-91f3-553adddf3967.png)
```

- 글등록 (작성자는 로그인중인 회원)
```
![TODO등록](https://user-images.githubusercontent.com/113006951/209264018-d99c7819-2e7b-4cc9-968c-1ba68653ea41.png)
```
- 수정 (작성자는 수정불가)
```
![TODO수정](https://user-images.githubusercontent.com/113006951/209264057-6d32b404-633f-4820-baed-1fe8fb26ef16.png)
```
- 수정후
```
![TODO수정후](https://user-images.githubusercontent.com/113006951/209264326-a8abeee7-29b2-4114-8c43-59d4e9cacae6.png)
```
-삭제 (삭제 전 확인 ALERT)
```
![TODO삭제](https://user-images.githubusercontent.com/113006951/209264199-92edb49f-0e6b-4fe4-8ebf-a4114150f58a.png)
```
-상세보기(수정, 삭제 버튼 활성화)
```
![TODO상세보기](https://user-images.githubusercontent.com/113006951/209264276-f598715c-89d6-4746-a9e6-9c6f7b3cd47d.png)
```
-검색 (날짜 및 키워드 검색 후 리스트로 출력)
```
![검색옵션](https://user-images.githubusercontent.com/113006951/209264505-2fc00880-b442-443f-b74c-f9b3ec09f51f.png)
```

```
기능
--------
```
-데이터베이스 연결로 데이터 저장
-날짜와 키워드로 검색
-권한설정으로 ADMIN은 회원리스트 출력
  USER는 내정보 출력


```
