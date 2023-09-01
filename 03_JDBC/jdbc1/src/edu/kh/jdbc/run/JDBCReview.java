package edu.kh.jdbc.run;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class JDBCReview {
	public static void main(String[] args) {
		
		// 부서명이 총무부인 해당 부서에 근무하는 모든 사원의
		// 사번, 이름, 부서명, 직급명을 직급코드 오름차순 조회
		
		Connection conn = null; // DB 연결 정보를 저장한 객체
		Statement stmt = null; // DB에 SQL 수행 -> 결과 반환 받는 객체
		ResultSet rs = null; //SELECT 결과를 저장하는 객체
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			String type = "jdbc:oracle:thin:@";	// thin -> 드라이버 종류
			String host = "115.90.212.20"; // DB 서버 컴퓨터 IP 주소				
			String port = ":10000"; // DB 서버 컴퓨터 내에서 DB 프로그램 번호			
			String dbName = ":ORCL"; // DB 이름
			
			String userName = "a230724_kjm";	// 사용자 계정		
			String pw = "qwer1234"; // 비밀번호			
			
			conn = DriverManager.getConnection(type+host+port+dbName, userName, pw);
			
			Scanner sc = new Scanner(System.in);
			
			System.out.print("부서명 입력 : ");
			String input = sc.next();
			
			// 입력받은 문자열이 저장된 변수를 sql에 추가할 때
			// 양쪽에 홑따옴표(' ')를 반드시 작성해야 한다.
			String sql = "SELECT EMP_ID, EMP_NAME, DEPT_TITLE, JOB_NAME\r\n"
					+ "FROM EMPLOYEE\r\n"
					+ "JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID)\r\n"
					+ "JOIN JOB USING(JOB_CODE)\r\n"
					+ "WHERE DEPT_TITLE = '"+input+"'\r\n"
					+ "ORDER BY JOB_CODE";
			
			stmt = conn.createStatement();
			// 연결된 DB와 대화(SQL 수행/결과 반환)를 하기위한 객체 생성
			
			rs = stmt.executeQuery(sql);
			
			boolean flag = true; // true이면 조회결과 없음, false면 없음(임의로 설정 가능)
			
			while(rs.next()) {
				flag = false; // while문 한 번이라도 수행되면 false
				
				String empId = rs.getString("EMP_ID"); // 현재 행의 EMP_ID 컬럼 값을 String 형태로 얻어와 저장
				String empName = rs.getString("EMP_NAME");
				String deptTitle = rs.getString("DEPT_TITLE");
				String jobName = rs.getString("JOB_NAME");
				
				System.out.printf("%s / %s / %s / %s \n", empId, empName, deptTitle, jobName);
				}
			if(flag) { // while문 종료 후 flag = true -> 조회 결과 없음
				System.out.println("일치하는 부서가 없습니다.");
			}
			
			
		} catch (Exception e) { // 예외 최상위 부모로 모든 예외 잡아서 처리
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) rs.close();
				if(stmt != null) stmt.close();
				if(conn != null) conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}
}
