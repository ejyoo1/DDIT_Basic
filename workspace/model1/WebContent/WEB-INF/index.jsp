<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

1. 디비하고 연결하는 구조 작성(mysql.jar) 설정 -> maven project 컴버트
2. 빈2개 필요 로그인용, 게시물용
3. jsp 1개 (로그인 처리) -> jsp(게시물용)
	login -> loginProc -> bbs



create table tbl_board(
    bno number,
    title varchar2(200) not null,
    content varchar2(255),
    writer varchar2(50) not null,
    regdate date default sysdate not null,
    viewcnt number default 0,
    replycnt number default 0
);
create table tbl_user(
    IDX NUMBER,
    UserID VARCHAR2(50) NOT NULL,
    UserPW VARCHAR2(50) NOT NULL,
    REGDATE DATE DEFAULT SYSDATE
);

create sequence bno_index increment by 1 start with 1;
CREATE SEQUENCE IDX_INDEX INCREMENT BY 1 START WITH 1;

insert into tbl_board (bno,title,content,writer) values(bno_index.nextval,'jsp','jsp는 자바로만든 서버페이지 입니다.','guest');

drop table tbl_board;

insert into tbl_board (bno,title,content,writer) values(bno_index.nextval,'servlet','servlet은 자바로 만드는 서버코드입니다.','guest');
insert into tbl_user (idx,UserID,UserPW) values(IDX_INDEX.nextval,'guest','1234');
insert into tbl_user (idx,UserID,UserPW) values(IDX_INDEX.nextval,'kkk','1111');

--전체 게시물 가져오기
select * from tbl_board order by bno_index desc;

select * from tbl_user;

--로그인
select * from tbl_user where userid='guest' and userpw='1234';