package edu.kh.network.ex1.server;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Server복습 {

	public void start() {
		int port = 8000;
		
		ServerSocket serverSocket = null;
		Socket clientSocket = null;
		
		InputStream is = null;
		OutputStream os = null;
		
		BufferedReader br = null;
		PrintWriter pw = null;
		try {
			serverSocket = new ServerSocket(port);
			
			clientSocket = serverSocket.accept();
			
			is = clientSocket.getInputStream(); // 클라이언트 -> 서버
			os = clientSocket.getOutputStream(); // 서버 -> 클라이언트
			
			br = new BufferedReader(new InputStreamReader(is));
			pw = new PrintWriter(os);
			
			// 서버 -> 클라이언트 메세지 전달
			Date now = new Date(); 
			
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			
			String message = sdf.format(now) + "서버 접속 성공";
			// 전달 = 출력 -> PrintWritter -> pw 사용
			pw.print(message);
			pw.flush(); // 밀어내는 코드 , 미작성 시 클라이언트 쪽으로 출력되지않음
			
			// 클라이언트 -> 서버 메세지 받기
			String message2 = br.readLine(); // 클라이언트로 부터 메세지 받아와야 하니깐
											// 입력 보조 스트림인 br을 사용
			String clientIP = clientSocket.getInetAddress().getHostAddress();
			
		
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			// 소켓, 스트림 생성 역순으로 close() 구문 작성
			try {
				if(br != null) br.close();
				if(pw != null) pw.close();
				// is,os.close() 는 보조 스트림 close()작성 시 자동 추가
				
				if(clientSocket != null) clientSocket.close();
				if(serverSocket != null) serverSocket.close();
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
