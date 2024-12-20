# ShareWare
##### 팀원 : 권지혜(팀장), 김민지, 김아름, 박재빈, 정은진 


## Contents
### [1. 개요](#개요)
### [2. 설계의 주안점](#설계의-주안점)
### [3. 사용기술 및 개발환경](#사용기술-및-개발환경)
### [4. 프로젝트 기능 구현](#프로젝트-기능-구현)
### [5. 보고서](#보고서)
### [6. ERD](#ERD)

## 개요
코로나 장기화로 재택근무를 시행하거나 사무실 밖에서 업무를 처리하는 등의 비대면 업무를 공유해야 하는 일이 더욱 많아지고
있다. ShareWare는 코로나로 인해 어려워진 의사소통을 보다 원활하도록 회사 내 커뮤니케이션을 돕는 기능과 더 빠르고 편리한 
업무처리를 위한 서비스를 제공한다. 


## 설계의 주안점
* 전자결재
* 개인과 전체 일정 관리(캘린더) 
* 근태관리 (출퇴근 기록, 연차/휴가 조회)
* 전자투표가 가능한 자유 게시판 
* 회의실 사용 현황 파악 및 예약 
* 채팅

## 사용기술 및 개발환경
|Category | Detail |
| ------- | ------ |
| FrontEnd | HTML5, JS, CSS3, Nexacro-Platform 17|
| BackEnd  | Java(JDK 1.8), JSP |
| FrameWork| Spring, Mybatis |
| OS       | Windows 10, 11 |
| IDE      | Eclipse, GitHub |
| Server   | Apatch Tomcat(v8.5) |
| DataBase | Oracle(11g) - SQL Developer |

## 프로젝트 기능 구현
* 권지혜
  + 전자결재 
    + 문서 양식 4종류(기안서/품의서/휴가신청서/지출결의서)
    + 결재자 및 참조자 선택
    + 결재 요청
    + 임시 저장
    + 반려 문서 재상신
  + 알림
    + 전자결재 알림(결재 요청/완료/반려)
    + 공지사항 알림
    + 일정 알림
  + 채팅 
    + 사용자 초대
    + 개인/그룹 채팅 가능
    + 채팅방 생성/나가기
  + 관리자 페이지
    +  사원 관리
    +  승인 메일 관리
  
* 김민지
  + 근태관리 
     + 출퇴근 등록
     + 연차/휴가 사용 신청 및 조회
  + 조직도
     + 주소록 검색 및 조회 가능  
  + 관리자 페이지
     + 근태현황 조회
     + 연차관리 조회

* 김아름 
  + 게시판 
     + 자유 게시판 (투표기능, 댓글) 
     + 공지사항 게시판 
     + 파일 공유가 가능한 자료실 
  + 회의실 예약
     + 날짜, 시간, 회의실을 선택해 예약
     + 예약 취소 가능

 * 박재빈 
   + 일정 관리 
     + 개인 일정 등록 가능
     + 전사 일정 조회가능 
   + 메일
     + 받은 메일함
     + 보낸 메일함
     + 내게 쓴 메일함
     + 보낸 승인 메일함
     + 중요 메일함
     + 첨부 메일함
     + 즐겨찾는 그룹
     + 임시 저장함
 
 * 정은진
   + 업무일지 
     + 일일 업무일지 
     + 주간 업무일지 
   + 프로젝트 관리 
     + 중요공지사항
     + 업무진행현황 
     + 업무진행률(그래프)

## 보고서
### [ShareWare.pdf](https://github.com/1129khNexapring/ShareWare/files/8842049/ShareWare.pdf)
### [ShareWare_UseCase.pdf](https://github.com/1129khNexapring/ShareWare/files/8842050/ShareWare_UseCase.pdf)
### [ShareWare_Wireframe.pdf](https://github.com/1129khNexapring/ShareWare/files/8842051/ShareWare_Wireframe.pdf)
### [ShareWare_FlowChart.pdf](https://github.com/1129khNexapring/ShareWare/files/8842052/ShareWare_FlowChart.pdf)
### [ShareWare_ERD.pdf](https://github.com/1129khNexapring/ShareWare/files/8842053/ShareWare_ERD.pdf)
### [ShareWare_ClassDiagram.pdf](https://github.com/1129khNexapring/ShareWare/files/8842054/ShareWare_ClassDiagram.pdf)
### [ShareWare_SequenceDiagram.pdf](https://github.com/1129khNexapring/ShareWare/files/8842055/ShareWare_SequenceDiagram.pdf)

## ERD
![erd](https://user-images.githubusercontent.com/97680096/171777191-c342807c-3b1a-4cd6-ace8-cbd9e7108e6c.png)
