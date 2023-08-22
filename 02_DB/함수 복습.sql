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

