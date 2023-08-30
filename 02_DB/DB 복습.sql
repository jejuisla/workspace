-- DML 
-- 데이터 조작 언어

-- INSERT 
-- INSERT INTO 테이블명 VALUES(값);
-- 테이블에 새로운 행을 추가

CREATE TABLE EMPLOYEE4 AS SELECT * FROM EMPLOYEE;
CREATE TABLE DEPARTMENT3 AS SELECT * FROM DEPARTMENT;
SELECT * FROM EMPLOYEE4;
-------------------------------------------------------------
INSERT INTO EMPLOYEE2
VALUES(900, '장채현', '901123-2345678', 'jang_ch@kh.or.kr', '01012341234','D1', 'J7', 'S3', 4300000, 0.2, 200, SYSDATE, NULL, 'N');

SELECT * FROM EMPLOYEE4;

ROLLBACK;


INSERT INTO EMPLOYEE4(EMP_NAME, EMP_ID, EMP_NO, EMAIL, PHONE, DEPT_CODE, JOB_CODE, SAL_LEVEL, SALARY)
VALUES('장채현', 900, '901123-2345678', 'jang_ch@kh.or.kr', '01012341234', 'D1', 'J7', 'S3', 4300000);
-- 테이블명(컬럼명, 컬럼명...) VALUES(데이터값, 데이터값...);

-- 테이블에서는 EMP_ID EMP_NAME 순이지만 INSERT할 때 컬럼명 순서 바뀌어도 값만 잘 넣으면 됨
-- 선택안된 컬럼은 NULL이 들어감


-- UPDATE
-- 테이블에 기록된 컬럼의 값을 수정
-- UPDATE 테이블명 SET 컬럼명 = 바꿀값 WHERE 조건식;

SELECT * FROM DEPARTMENT3
WHERE DEPT_ID = 'D9';

UPDATE DEPARTMENT3
SET DEPT_ID = 'D0'
WHERE DEPT_ID = 'D9';

SELECT * FROM DEPARTMENT3;

ROLLBACK;

SELECT * FROM EMPLOYEE4;

UPDATE EMPLOYEE4 SET BONUS = 0.1
WHERE BONUS IS NULL;
ROLLBACK;

-- 조건절을 설정하지 않으면 모든 행에 적용

-- UPDATE시 서브쿼리 사용 가능
-- UPDATE 테이블명 SET 컬럼명 = (서브쿼리)

SELECT * FROM EMPLOYEE4;

UPDATE EMPLOYEE4 SET SALARY = (SELECT SALARY FROM EMPLOYEE4 WHERE EMP_NAME = '유재식') BONUS = (SELECT BONUS FROM EMPLOYEE4 WHERE EMP_NAME = '유재식')
WHERE EMP_NAME = '방명수';

--UPDATE EMPLOYEE4 SET BONUS = (SELECT BONUS FROM EMPLOYEE4 WHERE EMP_NAME = '유재식')
--WHERE EMP_NAME = '방명수';

SELECT SALARY , BONUS
FROM EMPLOYEE4
WHERE EMP_NAME IN('유재식','방명수');

ROLLBACK;


SELECT EMP_NAME , SALARY, BONUS 
FROM EMPLOYEE4
WHERE EMP_NAME IN ('노옹철','전형돈','정중하','하동운','유재식');

UPDATE EMPLOYEE4
SET (SALARY,BONUS) = (SELECT SALARY, BONUS
					FROM EMPLOYEE4
					WHERE EMP_NAME = '유재식')
WHERE EMP_NAME IN ('노옹철','전형돈','정중하','하동운');

ROLLBACK;


-- MERGE
-- 구조가 같은 두 개의 테이블을 하나로 합치는 기능
-- 테이블에서 지정하는 조건의 값이 존재하면 UPDATE, 존재하지 않으면 INSERT


-- DELETE
-- 테이블의 행을 삭제
-- DELETE FROM 테이블명 WHERE 조건;
-- 조건을 설정하지 않으면 모든 행 삭제

SELECT * FROM EMPLOYEE4;

DELETE FROM EMPLOYEE4 WHERE EMP_NAME = '이태림';

ROLLBACK;


-------------------------------------------------------------------------
-- TCL
-- 트랜잭션 제어 언어

/* EX) INSERT 수행 --------------------------------> DB 반영(X)
   
     INSERT 수행 --> 트랜잭션에 추가 --> COMMIT --> DB 반영(O)
 * */

-- COMMIT , ROLLBACK, SAVEPOINT

-- COMMIT : 메모리 버퍼에 임시 저장된 데이터 변경사항을 DB에 반영
-- ROLLBACK : 메모리 버퍼에 임시 저장된 데이터 변경 사항을 삭제하고 마지막 COMMIT 상태로 돌아감
-- SAVEPOINT : 메모리 버퍼에 저장 지점을 정의하여 ROLLBACK 수행 시 저장 지점까지만 ROLLBACK

-- 한번 COMMIT된 내용은 ROLLBACK으로는 취소 불가

----------------------------------------------------------------------
-- DDL
-- 데이터 정의 언어
-- CREATE, ALTER, DROP
-- 객체를 만들고 수정하고 삭제 등 데이터의 전체 구조를 정의하는 언어 -> DB관리자, 설계자가 사용


-- CREATE
 /*CREATE TABLE 테이블명(
  * 	컬럼명 자료형(크기)
  * 	컬럼명 자료형(크기)
		...)
  *  */ 

/* 자료형
 * *NUMBER
 * *CHAR
 * *VARCHAR2
 * *DATE
 * BLOB
 * CLOB
 * */

CREATE TABLE MEMBER(
	MEMBER_ID VARCHAR2(20),
	MEMBER_PW VARCHAR2(50),
	MEMBER_NAME VARCHAR2(10),
	MEMBER_SSN CHAR(14),
	ENROLL_DATE DATE DEFAULT SYSDATE
	
);
   
-- 컬럼에 주석 달기
-- COMMENT ON COLUMN 테이블명.컬럼명 IS '주석';

INSERT INTO MEMBER
VALUES('MEM01', '123ABC', '홍길동', '990123-1234567', DEFAULT);
--> 테이블에서 DEFAULT는 SYSDATE여서 SYSDATE 삽입
-- 미작성 시 DEFAULT값이 반영


-- CONSTRAINT(제약조건)
-- 특정 컬럼에 설정하는 제약 / 데이터 무결성 보장을 목적으로 함

-- 제약조건의 종류
-- PRIMARY KEY(기본키)
-- NOT NULL(NULL 안됨)
-- UNIQUE(중복안됨)
-- CHECK(지정된 값만 삽입,수정 가능)
-- FOREIGN KEY(다른 테이블의 기본키 또는 UNIQUE가 설정된 컬럼을 참조) --> 다른 테이블의 값을 가져다 사용


-- [NOT NULL]
-- 삽입/수정 시 NULL값을 허용하지 않음


-- [UNIQUE]
-- 컬럼에 입력 값에 대해서 중복을 제한
-- UNIQUE 제약 조건이 설정된 컬럼에 NULL 값은 중복 삽입 가능
-- 제약조건명 지정 시 -> CONSTRAINT 제약조건명 UNIQUE

CONSTRAINT USER_ID_U UNIQUE(USER_ID) --> USER_ID에 USER_ID_U 라는 이름의 UNIQUE 제약조건 설정(테이블 레벨)

-- UNIQUE 복합키 -> 두개 이상의 컬럼을 묶어서 하나의 UNIQUE 제약조건을 설정, 지정된 모든 컬럼의 값이 일치해야 중복으로 판단 (1,2) != (1,3) / (1,2) == (1,2)
-- 복합키는 테이블 레벨로만 설정 가능

CONSTRAINT USER_ID_NAME_U UNIQUE(USER_ID, USER_NAME) --> USER_ID와 USER_NAME에 USER_ID_NAME_U라는 이름의 UNIQUE 제약조건 설정


-- [PRIMARY KEY]
-- 식별자(IDENTIFIER) 역할
-- NOT NULL + UNIQUE 제약조건의 의미

-- 한 테이블당 한개망 설정할 수 있음
-- 한 개 컬럼에 설정할 수 있고 여러개의 컬럼을 묶어서도 가능

    USER_NO NUMBER PRIMARY KEY, -- 컬럼 레벨, 이름 지정 X
    USER_NO NUMBER CONSTRAINT USER_NO_PK PRIMARY KEY, -- 컬럼 레벨, 이름 지정 O

 CONSTRAINT USER_NO_PK PRIMARY KEY(USER_NO) -- 테이블 레벨

-- PRIMARY KEY 복합키 -> 테이블 레벨에서만 가능

 
 
-- [FOREIGN KEY]
-- 참조된 다른 테이블의 컬럼이 제공하는 값만 사용가능

-- 컬럼레벨
-- 컬럼명 자료형(크기) [CONSTRAINT 이름] REFERENCES 참조할 테이블명 [(참조할컬럼)] [삭제룰]

-- 테이블레벨
-- [CONSTRAINT 이름] FOREIGN KEY (적용할컬럼명) REFERENCES 참조할테이블명 [(참조할컬럼)] [삭제룰]

-- ** 참조될 수 있는 컬럼은 PRIMARY KEY컬럼, UNIQUE가 지정된 컬럼만 가능

REFERNCES USER_GRADE(GRADE_CODE) -> USER_GRADE 테이블에서 GRADE_CODE 컬럼을 참조 --> 컬럼레벨 , 이름 미지정

CONSTRAINT GRADE_CODE_FK1 FOREIGN KEY(GRADE_CODE) REFERENCES USER_GRADE(GRADE_CODE) 
--> 현재 테이블의 GRADE_CODE 컬럼에 GRADE_CODE_FK1 이라는 이름으로 USER_GRADE 테이블의 GRADE_CODE컬럼을 참조하는 외래키 설정

-- NULL 사용 가능

-- 참조하는 컬럼에서 제공하는 값이 아닌 다른 값을 사용하면 외래키 제약조건에 위배되어 오류 발생
-- 참조하는 테이블 = 자식 테이블 / 참조 당하는 테이블 = 부모 테이블

-- FOREIGN KEY 삭제 옵션
-- 부모 테이블의 데이터 삭제 시 자식 테이블의 데이터를 어떤식으로 처리할 지에 대한 내용 설정 가능

-- 1) ON DELETE RESTIRICTED로 기본 지정
-- 외래키로 지정된 컬럼에서 사용하고 있는 값일 경우 제공하는 컬럼의 값은 삭제 불가
DELETE FROM USER_GRADE
WHERE GRADE_CODE = 20; -> 20은 외래키로 참조되고 있지 않아서 삭제 가능

-- 2) ON DELETE SET NULL
-- 부모키 삭제시 자식키를 NULL로 변경
CONSTRAINT GRADE_CODE_FK2 FOREIGN KEY(GRADE_CODE) REFERENCES USER_GRADE2(GRADE_CODE)
ON DELETE SET NULL

-- 3) ON DELETE CASCADE
-- 부모키 삭제시 자식키도 함께 삭제됨
-- 부모키 삭제시 값을 사용하는 자식 테이블의 해당하는 행이 삭제가 됨
 
 
 
-- [CHECK]
-- 컬럼에 기록되는 값에 조건 설정을 할 수 있음
-- CHECK(컬럼명 비교연산자 비교값) -> 비교값은 리터럴만 사용가능 변하는 값이나 함수는 불가
CONSTRAINT GENDER_CHECK CHECK(GENDER IN('남','여'));
--> CONSTRAINT 제약조건명 CHECK(컬럼명 비교연산자(비교값))



-- 서브쿼리를 이용한 테이블 생성
-- 컬럼명, 데이터 타입, 값이 복사되고 제약조건은 NOT NULL만 복사됨

-- 1) 테이블 전체 복사
--> CREATE TABLE 테이블명 AS SELECT 컬럼명 FROM 복사할 테이블명
CREATE TABLE EMPLOYEE_COPY2 AS SELECT * FROM EMPLOYEE;

SELECT * FROM EMPLOYEE_COPY2;


-- 2) JOIN 후 원하는 컬럼만 복사
CREATE TABEL EMP_COPY3
AS SELECT EMP_NAME, NVL(DEPT_TITLE,'없음') AS DEPT_TITLE, JOB_NAME
	FROM EMPLOYEE
	JOIN JOB USING(JOB_CODE)
	LEFT JOIN DEPARTMENT ON(DEPT_ID = DEPT_CODE)
	ORDER BY EMP_ID;
--> EMP_NAME,  NVL(DEPT_TITLE,'없음') AS DEPT_TITLE, JOB_NAME 이 컬럼만 복사


-- 3) 테이블의 형태(컬럼명, 데이터 타입)만 복사
--> 데이터가 없는 빈 테이블로 복사
--> 조건식 결과를 무조건 FALSE로 만들면 가능




-- ALTER 

-- ALTER -> 수정 가능한 것(컬럼, 제약조건, 이름변경)
-- ALTER TABLE 테이블명 ADD|MODIFY|DROP 수정할 내용


--> 제약조건 추가
-- ALTER TABLE 테이블명 ADD [CONSTRAINT 제약조건명] PRIMARY KEY(컬럼명)
-- ALTER TABLE 테이블명 ADD [CONSTRAINT 제약조건명] 
--  FOREIGN KEY(컬럼명) REFERENCES 참조 테이블명(참조컬럼명)
     --> 참조 테이블의 PK를 기본키를 FK로 사용하는 경우 참조컬럼명 생략 가능
                                                                                                                                                      
-- ALTER TABLE 테이블명 ADD [CONSTRAINT 제약조건명] UNIQUE(컬럼명)
-- ALTER TABLE 테이블명 ADD [CONSTRAINT 제약조건명] CHECK(컬럼명 비교연산자 비교값)

--ALTER TABLE 테이블명 ADD UNIQUE(USER_ID)
--ALTER TABLE 테이블명 ADD CONSTRAINT USER_ID_PK PRIMARY KEY(USER_ID) 
--ALTER TABLE 테이블명 ADD CONSTRAINT USER_ID_FK FOREIGN KEY(USER_ID) REFERENCES SAL_GRADE

-- NOT NULL 제약조건을 추가할려면 MODIFY를 사용
-- ALTER TABLE 테이블명 MODIFY 컬럼명 NOT NULL


--> 제약조건 삭제
-- ALTER TABLE 테이블명 DROP CONSTRAINT 제약조건명
-- ALTER TABLE DEPT_COPY DROP CONSTRAINT DEPT_COPY_TITLE_U

-- NOT NULL 제거 시 MODIFY 사용
--ALTER TABLE 테이블명 MODIFY 컬럼명 CONSTRAINT 컬럼값 NULL


-- 컬럼 추가 : ALTER TABLE 테이블명 ADD(컬럼명 자료형[DEFAULT '값'])
-- 컬럼 수정 : ALTER TABLE 테이블명 MODIFY 컬럼명 데이터타입 -> 데이터타입 변경
--			ALTER TABLE 테이블명 MODIFY 컬럼명 DEFAULT '값' -> 기본값 변경

--> 데이터타입 수정 시 컬럼에 저장된 데이터 크기 미만으로 변경할 수 없음

-- 컬럼 삭제 : ALTER TABLE 테이블명 DROP (삭제할 컬럼명)
--			ALTER TABLE 테이블명 DROP COLUMN 삭제할 컬럼명

--> 테이블에는 최소 1개 이상의 컬럼이 존재해야 되기 때문에 모든 컬럼 삭제 X

---> 추가는 ADD , 수정은 MODIFY, 삭제는 DROP
ALTER TABLE DEPT_COPY2
ADD(CNAME VARCHAR2(20))

ALTER TABLE DEPT_COPY2 ADD(LNAME VARCHAR2(20) DEFAULT '한국')

ALTER TABLE DEPT_COPY2 MODIFY DEPT_ID VARCHAR2(3)

ALTER TABLE DEPT_COPY2 MODIFY LNAME DEFAULT '대한민국'


-- * DML을 수행하여 트랜잭션에 변경사항이 저장된 상태에서 COMMIT/ROLLBACK 없이 DDL을 수행하게되면 
--   DDL 수행과 동시에 선형 DML이 자동으로 COMMIT 되버림
-->  따라서 DML 과 DDL을 혼용해서 사용하지 말자



-- 테이블 삭제

-- DROP TABLE 테이블명 [CASCADE CONSTRAINT]

DROP TABLE DEPT_COPY2 ;

-- 자식 -> 부모 테이블 순서로 삭제하기
-- CASCADE CONSTRAINTS 사용


