/* 단일행 함수 */

SELECT EMP_NAME , EMAIL , LENGTH(EMAIL) "이메일 길이" 
FROM EMPLOYEE
WHERE length(EMAIL)<=12
ORDER BY "이메일 길이";
-- EMPLOYEE 테이블에서
-- 사원명, 이메일, 이메일 길이 조회
-- 이메일 길이가 12이하 | 행 만 조회
-- 이메일 길이 오름차순 조회


-- INSTR(문자열 | 컬럼명, '찾을 문자열'[,찾을 시작 위치[,순])
-- 찾을 시작 위치부터 지정된 순번째 찾은 문자열의 시작 위치를 반환


SELECT 'AABAACAABBAA',INSTR('AABAACAABBAA','B')
FROM DUAL;
-- 문자열에서 맨 앞에 있는 'B'의 위치를 조회

-- 문자열 검색을 5번부터 시작해서 두번째 나오는 'B'의 위치를 조회
SELECT 'AABAACAABBAA', INSTR('AABAACAABBAA','B',5,2) 
FROM DUAL; 


-- SUBSTR(문자열 | 컬럼명, 시작위치 [,길이])
-- 문자열을 시작 위치부터 지정된 길이만큼 잘라내서 반환

SELECT SUBSTR('ABCDEFG',3,3)
FROM DUAL; -- CDE

SELECT SUBSTR('ABCDEFG',3)
FROM DUAL; -- CDEFG


-- EMPLOYEE 테이블에서
-- 사원명, 이메일 아이디만(@앞에까지 문자열)을
-- 이메일 아이디 오름 차순으로 조회
SELECT EMP_NAME , SUBSTR(EMAIL, 1,INSTR(EMAIL,'@')-1) "아이디"
FROM EMPLOYEE
ORDER BY "아이디";



-- TRIM ([[옵션] 문자열 | 컬럼명 FROM] 문자열 | 컬럼명)
-- 주어진 문자열의 앞쪽|뒤쪽|양쪽에 존재하는 지정된 문자열을 제거

-- LEADING(앞쪽), TRAILING(뒤쪽), BOTH(양쪽, 기본값)
SELECT '   K   H   ',
	TRIM (LEADING ' ' FROM '   K   H   '),
	TRIM (TRAILING ' ' FROM '   K   H   '),
	TRIM (BOTH ' ' FROM '   K   H   ')
FROM DUAL;
-- 'K   H   '
-- '   K   H'
-- 'K   H'


-- REPLACE(문자열 | 컬럼명, 찾을 문자열, 바꿀 문자열)
SELECT REPLACE(NATIONAL_NAME,'한국','대한민국')
FROM NATIONAL;


-- MOD(숫자 | 컬럼명, 나눌 값 ) : 나머지
SELECT MOD (105,100) FROM DUAL;


-- CEIL : 올림, FLOOR : 내림, ROUND : 반올림

-- TRUNC : 버림

-- 날짜 관련 함수
-- SYSDATE: 현재 시간
-- SYSDATESTAMP : 현재 시간(ms포함) 

-- MONTHS_BETWEEN : 두 날짜 사이의 개월 수를 반환


SELECT EMP_ID , EMP_NAME , HIRE_DATE , CEIL(MONTHS_BETWEEN(SYSDATE, HIRE_DATE) / 12) "N년차"
FROM EMPLOYEE;
-- EMPLOYEE 테이블에서 모든 사원의
-- 사번, 이름, 입사일, N년차 조


-- ADD_MONTHS(날짜,숫자) : 날짜를 숫자만큼의 개월수를 더하여 반환
SELECT ADD_MONTHS(SYSDATE,-1), SYSDATE, ADD_MONTHS(SYSDATE,1) FROM DUAL;
--> 현재 시간-1달 , 현재 시간, 현재 시간+1

SELECT LAST_DAY(SYSDATE) FROM DUAL;
--> 해당 월의 마지막 날짜


-- EXTRACT(YEAR | MONTH | DAY FROM 날짜)
-- 지정된 날짜의 년 | 월 | 일을 추출하여 정수로 반환



/* TO_CHAR(날짜 | 숫자 [, 포맷]) : 문자열로 변환
 * 
 * 숫자 -> 문자열
 * 포맷 
 * 1) 9 : 숫자 한 칸을 의미, 오른쪽 정렬
 * 2) 0 : 숫자 한 칸을 의미, 오른쪽 정렬, 빈 칸에 0을 추가
 * 3) L : 현재 시스템이나 DB에 설정된 나라의 화폐 기호
 * 4) , : 숫자의 자릿수 구분
 * */


SELECT TO_CHAR(SYSDATE,'YYYY/MM/DD') FROM DUAL;
-- 2023/08/23

-- TO_DATE(문자열 | 숫자 [, 포맷])
-- 문자열 또는 숫자를 날짜 형식으로 변환

SELECT TO_DATE('22-08-2023','DD-MM-YYYY') FROM DUAL;


/* 연도 패턴 Y,R의 차이점 */
-- 연도가 두자리만 작성되어 있는 경우
-- 50미만(0~49) : Y,R 둘 다 누락된 연도 앞부분의 현재 세기(2000년대) 추가
-- 50이상(50~99) : Y는 현재 세기(2000년대) 추가, R은 이전 세기(1900년대) 추가


-- <NULL 처리 함수>
--(NULL 처리 연산 : IS NULL, IS NOT NULL)

-- NVL(컬럼명, 컬럼 값이 NULL일 경우 변경할 값)

SELECT EMP_NAME, SALARY, NVL(BONUS,0)
FROM EMPLOYEE;
--> EMPLOYEE 테이블에서 이름, 급여, 보너스 조회
-- 보너스가 없으면 0으로 대체 -> 보너스에 NULL값이 있으면 0으로 대체


/* 선택 함수 */
-- DECODE(컬럼명 | 계산식 , 조건1, 결과1, 조건2, 결과2,...[,아무것도 만족 X])

-- 컬럼명 | 계산식 의 값이 일치하는 조건이 있으면
-- 해당 조건 오른쪽에 작성된 결과가 반환된다.

-- 모든 조건 불만족 시 [,아무것도 만족 X]가 반환됨


SELECT EMP_NAME, EMP_NO, DECODE( SUBSTR(EMP_NO,8,1),1,'남자',2,'여자') 성별
FROM EMPLOYEE;

-- CASE 
--     WHEN 조건1 THEN 결과1
--     WHEN 조건2 THEN 결과2
--     WHEN 조건3 THEN 결과3
--     ELSE 결과
-- END

-- CASE는 계산식 | 컬럼 값을 범위로 지정할 수 있다.

