# ShareWare
##### 팀원 : 권지혜(팀장), 김민지, 김아름, 박재빈, 정은진 


## Contents
### [1. 개요](#개요)
### [2. 설계의 주안점](#설계의-주안점)
### [3. 사용기술 및 개발환경](#사용기술-및-개발환경)
### [4. 프로젝트 기능 구현](#프로젝트-기능-구현)
### [5. 주요 기능](#주요-기능)
### [6. Document](#Document)

## 개요
코로나 장기화로 재택근무를 시행하거나 사무실 밖에서 업무를 처리하는 등의 비대면 업무를 공유해야 하는 일이 더욱 많아지고
있다. ShareWare는 코로나로 인해 어려워진 의사소통을 보다 원활하도록 회사 내 커뮤니케이션을 돕는 기능과 더 빠르고 편리한 
업무처리를 위한 서비스를 제공한다. 


## 설계의 주안점
* 전자결재()
* 개인과 전체 일정 관리(캘린더) 
* 근태관리 (출퇴근, 연차/휴가 일수)
* 전자투표가 가능한 자유게시판 
* 회의실 사용현황 파악 및 예약 
* 채팅 

## 사용기술 및 개발환경
|Category | Detail |
| ------- | ------ |
| FrontEnd | HTML5, JS, CSS3, Nexacro-Platform 17|
| BackEnd  | Java(JDK 1.8), JSP |
| FrameWork| Spring, Mybatis, jQuery |
| OS       | Windows 10, 11 |
| IDE      | Eclipse, GitHub |
| Server   | Apatch Tomcat(v8.5) |
| DataBase | Oracle(11g) - SQL Developer |

![개발환경](https://user-images.githubusercontent.com/97680096/171772108-c4f928bc-284b-4f08-8d0a-3e599c5d567d.png)

## 프로젝트 기능 구현
* 권지혜
  + 전자결재 
    + 기안서
    + 품의서
    + 휴가신청서
    + 지출결의서
  + 알림
    + 공지사항 알림
    + 결재 처리 여부 알림
    + 일정 알림
  + 채팅 
    + 사원 초대 가능 
    + 채팅 
  
* 김민지
  + 근태관리 
     + 출퇴근 등록
     + 연차/휴가 사용 신청 및 조회
  + 조직도관리
     + 주소록 검색및 조회가능  

* 김아름 
  + 게시판 
     + 자유 게시판 
     + 공지사항 게시판 
     + 파일 공유가 가능한 자료실 
  + 회의실 예약
     + 날짜, 시간, 회의실을 선택해 예약

 * 박재빈 
   + 일정 관리 
     + 개인 일정 등록 가능
     + 전사 일정 조회가능 
   + 메일 
     + 내게 쓴 메일 
 
 * 정은진
   + 업무일지 
     + 일일 업무일지 
     + 주간 업무일지 
   + 프로젝트 관리 
     + 중요공지사항
     + 업무진행현황 
     + 업무진행률(그래프)

## 주요 기능

### 1. 로그인 화면
![image](https://user-images.githubusercontent.com/97680096/171772427-19bfd122-730a-46b4-8e6b-a27bccb23516.png)

### 2. 메인 화면
![image](https://user-images.githubusercontent.com/97680096/171772547-f4ad4f31-ddf9-4518-a2e4-b95254a33e79.png)

### 3. 기본 정보 조회
![image](https://user-images.githubusercontent.com/97680096/171772615-bf35abf4-2227-439a-b923-a9279b6d1cf4.png)

### 4. 알림창 팝업
![image](https://user-images.githubusercontent.com/97680096/171774114-970531fe-ae00-426e-a89d-e635ca01bdcd.png)

### 5. 프로젝트 관리 
![image](https://user-images.githubusercontent.com/97680096/171774316-2131e527-e2d0-4a31-a24c-c3149378a7be.png)

### 6. 프로젝트 생성 
![image](https://user-images.githubusercontent.com/97680096/171774358-1c1701be-89fc-4e2f-83f5-dbfd56b926dd.png)

### 7. 프로젝트 메인 
![image](https://user-images.githubusercontent.com/97680096/171774441-dc079ba0-168d-402c-9aa1-ce00f443d4c2.png)

### 8. 프로젝트 정보
![image](https://user-images.githubusercontent.com/97680096/171774478-a0882577-d74a-4363-b3a5-11f65cc91ef9.png)

### 9. 중요공지사항 
![image](https://user-images.githubusercontent.com/97680096/171774535-2e688937-8d50-4fe9-855e-0e904eb12cff.png)

### 10. 중요공지사항 작성
![image](https://user-images.githubusercontent.com/97680096/171774569-4d7fd73e-9347-4ab6-8383-a5d9aa30a513.png)

### 11. 업무진행현황
![image](https://user-images.githubusercontent.com/97680096/171774598-6b7c07b9-09fb-4b76-9537-11112e96965b.png)

### 12. 업무진행현황 작성
![image](https://user-images.githubusercontent.com/97680096/171774645-a01a14c4-6aba-4df8-9cfc-3af50c07d8f4.png)

### 13. 업무진행률 등록 
![image](https://user-images.githubusercontent.com/97680096/171774729-70697075-b1ff-4012-87a7-56e154f5191d.png)
![image](https://user-images.githubusercontent.com/97680096/171774741-03109b1a-4c35-436e-9516-301392bee818.png)

### 14. 일일 업무일지
![image](https://user-images.githubusercontent.com/97680096/171774772-fc6f2d98-effe-42aa-8bd2-ea7463814ae5.png)

### 15. 일일 업무일지 작성
![image](https://user-images.githubusercontent.com/97680096/171774804-3dd781e3-c02c-4919-9f26-11cca0ade74f.png)

### 16. 주간 업무일지
![image](https://user-images.githubusercontent.com/97680096/171774869-5e9b0572-81dc-4566-b18d-0849e931381b.png)

### 17. 주간 업무일지 작성
![image](https://user-images.githubusercontent.com/97680096/171774910-bd95a661-d7d7-4db0-b361-c68f1832cf4f.png)

### 18. 근태관리 
![image](https://user-images.githubusercontent.com/97680096/171774993-c5890f98-8786-401b-8744-4071450aec49.png)

### 19. 연차 관리 
![image](https://user-images.githubusercontent.com/97680096/171775032-1090966e-c202-4eb7-b08a-b07d0ac28dc7.png)

### 20. 휴가신청
![image](https://user-images.githubusercontent.com/97680096/171775080-7f0f1ca1-38bf-4bb8-ba5b-a1e04d0be43a.png)

### 21. 조직도 
![image](https://user-images.githubusercontent.com/97680096/171775136-1e503248-9fca-460b-beca-6128c977b3bd.png)

### 22. 주소록
![image](https://user-images.githubusercontent.com/97680096/171775162-fe5b1354-d249-4d86-9d7a-7cb165579f5d.png)

### 23. 자유게시판 
![image](https://user-images.githubusercontent.com/97680096/171775198-5d0d92de-a648-421e-a862-45db4574f831.png)

### 24. 자유게시판 작성
![image](https://user-images.githubusercontent.com/97680096/171775240-edef9d5c-f4ec-4301-ac8d-295a7c53e260.png)

### 25. 공지게시판 
![image](https://user-images.githubusercontent.com/97680096/171775289-b19f7329-d818-4804-b882-f07f45097dc5.png)

### 26. 자료실 
![image](https://user-images.githubusercontent.com/97680096/171775310-6e5964f5-476f-45f5-9e38-a7e17ebfce16.png)

### 27. 자료실 작성 
![image](https://user-images.githubusercontent.com/97680096/171775381-2f9fdbaa-48bd-4702-a466-a1493e9f13fe.png)

### 28. 회의실 예약 
![image](https://user-images.githubusercontent.com/97680096/171775427-2b17b770-3482-4fa9-beeb-3f52222dd014.png)

### 29. 회의실 예약 확인 
![image](https://user-images.githubusercontent.com/97680096/171775459-d774c808-884f-4397-be9e-227193f881d4.png)

### 30. 기안 문서함
![image](https://user-images.githubusercontent.com/97680096/171775488-51ea6121-1ec0-46d2-a0a8-7647a0935e91.png)

### 31. 결재 문서함
![image](https://user-images.githubusercontent.com/97680096/171775523-b1fc81f8-295f-4292-b37b-687dcce54bd0.png)

### 32. 참조 문서함 
![image](https://user-images.githubusercontent.com/97680096/171775563-19d57db7-e2c2-4721-a39b-62c4a0f9cd99.png)

### 33. 임시 저장함
![image](https://user-images.githubusercontent.com/97680096/171775685-112ca319-3ee2-494b-b673-069aa7d8236f.png)

### 34. 결재 문서 양식선택 
![image](https://user-images.githubusercontent.com/97680096/171775737-0f9cfddd-8a62-471d-9c88-7c5495e32d73.png)

### 35. 기안서 
![image](https://user-images.githubusercontent.com/97680096/171775766-90c2bf94-3209-4ed0-ab17-6a06f85c7a66.png)

### 36. 품의서
![image](https://user-images.githubusercontent.com/97680096/171775794-f13cb641-99cf-4e22-81cb-19e50481a6ff.png)

### 37. 지출결의서 
![image](https://user-images.githubusercontent.com/97680096/171775833-dc2e3f0e-39dc-40c4-b914-6e2a26678341.png)

### 38. 채팅방 목록
![image](https://user-images.githubusercontent.com/97680096/171775867-b0add8bb-1283-4df0-9278-0d2f8ee8083c.png)

### 39. 채팅방 생성 
![image](https://user-images.githubusercontent.com/97680096/171775906-04d12cd9-4a20-4a7a-8f49-bdda76f09eda.png)

### 40. 채팅방 
![image](https://user-images.githubusercontent.com/97680096/171776136-3e525318-86ea-4040-93f2-86636e62df51.png)

### 41. 월간 일정 
![image](https://user-images.githubusercontent.com/97680096/171776229-f5b1f1e2-b202-47cf-9be9-b7cf7b68ed52.png)

### 42. 메일 작성 
![image](https://user-images.githubusercontent.com/97680096/171776597-4596e3c8-75e4-4f44-be67-c05a086a2790.png)

### 47. 받은 메일함
<img width="1272" alt="받은메일" src="https://user-images.githubusercontent.com/97680096/171776902-73272803-1b3e-48ea-a8c6-8d178123b72c.png">

### 48. 보낸 메일함 

<img width="1272" alt="보낸메일" src="https://user-images.githubusercontent.com/97680096/171776911-8bc77c88-5a6f-49de-b1cc-4a04012a7113.png">


### 2. ERD
![erd](https://user-images.githubusercontent.com/97680096/171777191-c342807c-3b1a-4cd6-ace8-cbd9e7108e6c.png)


