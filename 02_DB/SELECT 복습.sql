/* SELECT 작성법 
 * 
 * SELECT 컬럼명 | *
 * FROM 테이블명
 * WHERE 조건식;
 * 
 * */


SELECT EMP_ID , EMP_NAME , SALARY * 12
FROM EMPLOYEE;
--> EMPLOYEE 테이블에서 모든 사원의 사번, 이름, 연봉(급여*12)를 조회

-- SYSDATE : 현재 시간
-- DUAL : 가짜 테이블(단순 데이터 조회 시 임시 테이블)

SELECT SYSDATE -1, SYSDATE , SYSDATE +1
FROM DUAL;
--> 현재시간 하루 전, 현재 시간, 현재 시간 하루 후

SELECT SYSDATE + (1/24)
FROM DUAL;
--> 현재시간 + 1시간



-- <컬럼 별칭 지정>

-- 별칭 지정 방법
-- 1) 컬럼명 AS 별칭 : 문자O, 띄어쓰기 X, 특수문자 X
-- 2) 컬럼명 AS "별칭" : 문자O, 띄어쓰기 O, 특수문자 O
-- 3) 컬럼명 별칭 : 문자O, 띄어쓰기 X, 특수문자 X
-- 4) 컬럼명 "별칭" : 문자O, 띄어쓰기 O, 특수문자 O

-- "" 의미
-- 1. 대/소문자 구분
-- 2. 특수문자, 띄어쓰기 인식

SELECT EMP_ID 사번, EMP_NAME "사원 이름", SALARY 급여
FROM EMPLOYEE;
--> 사원 이름에서 띄어쓰기가 있기 때문에 "" 사용


-- 연결 연산자 || : 문자열 이어쓰기
SELECT EMP_NAME, SALARY + 1000000 || '원'
FROM EMPLOYEE;
--> EMPLOYEE 테이블에서 모든 사원의 이름, 급여+100만'원' 조회



/* WHERE 절 */

-- 테이블에서 조건을 충족하는 행을 조회할 때 사용
-- WHERE 절에는 조건식(TRUE/FALSE)만 작성


/*3*/SELECT EMP_ID , EMP_NAME , SALARY * 12
/*1*/FROM EMPLOYEE
/*2*/WHERE SALARY * 12 <= 50000000;
--> 1) EMPLOYEE 테이블에서
--  2) 연봉(급여*12)이 5천만원보다 이하인 사원의
--  3) 사번, 이름, 연봉 을 조회

SELECT EMP_ID , EMP_NAME , SALARY 
FROM EMPLOYEE
WHERE SALARY BETWEEN 3000000 AND 5000000;
--> EMPLOYEE 테이블에서 급여가 300만 이상 500만 이하인 사원의
-- 사번 이름 급여 조회


-- EMPLOYEE 테이블에서
-- 부서코드가 'D5', 'D6', 'D9'인 사원의
-- 이름, 부서코드, 급여 조회

-- 1) 첫번째 방법
SELECT EMP_NAME 이름, DEPT_CODE 부서코드, SALARY 급여
FROM EMPLOYEE
WHERE DEPT_CODE = 'D5' OR DEPT_CODE = 'D6' OR DEPT_CODE = 'D9';

-- 2) 두번째 방법
SELECT EMP_NAME , DEPT_CODE , SALARY 
FROM EMPLOYEE
WHERE DEPT_CODE IN('D5','D6','D9');



-- NULL 처리 연산

-- IS NULL : 컬럼 값이 NULL이면 TRUE
-- IS NOT NULL : 컬럼 값이 NULL이 아니면 TRUE
SELECT EMP_NAME DEPT_CODE 
FROM EMPLOYEE 
WHERE DEPT_CODE IS NULL;
--> EMPLOYEE 테이블에서 DEPT_CODE가 NULL인 사원의 이름, 부서코드 조회



/*LIKE
 * 
 * [작성법]
 * WHERE 컬럼명 LIKE '패턴'
 * 
 * '%' - 어떤 문자든 포함됨(있어도 되고 없어도 됨)
 * 
 * '%A' : A로 끝나는 문자열
 * 'A%' : A로 시작하는 문자열
 * '%A%' : A가 포함된 문자열
 * 
 * 
 * '_' - 글자 수
 * 
 * 'A_' : A 뒤에 아무거나 한 글자만 있는 문자열
 * (AB,A1,A가)
 * 'A___' : A 뒤에 아무거나 3글자만 있는 문자열
 * */

SELECT EMP_ID , EMP_NAME 
FROM EMPLOYEE
WHERE EMP_NAME LIKE '전%돈';
--> EMPLOYEE 테이블에서 이름이 '전'으로 시작해서 '돈'으로 끝나는 사원의
-- 사번, 이름을 조회


SELECT EMP_NAME , EMAIL 
FROM EMPLOYEE
WHERE EMAIL LIKE '_____@%';
--> EMPLOYEE 테이블에서 이메일의 아이디(@앞의 글자)의 글자수가 5글자인 사원의
-- 이름, 이메일 조회



-- EMPLOYEE 테이블에서 이메일의 아이디 중 '_'앞 쪽 글자의 수가 3글자인 사원의
-- 사번, 이름, 이메일 조회

--> 와일드카드 표기법 '_'와 기준으로 삼을 문자열 '_'이 둘 다 와일드카드로 해석되어
--  조건식의 의미가 의도와 다르게 작성됨

--> ESCAPE 옵션을 사용
-- ESCAPE : 와일드카드의 의미를 벗어나 단순 문자열로 인식
-- 범위 : 특수문자 뒤 한 글자
SELECT EMP_ID , EMP_NAME , EMAIL 
FROM EMPLOYEE
WHERE EMAIL LIKE '___!_%' ESCAPE '!';



-- 날짜(DATE) 타입은 비교가 가능






