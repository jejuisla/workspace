package edu.kh.network.ex1.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client복습 {

	public void start() {
		String ip = "127.0.0.1";
		int port = 5000;
		
		Socket socket = null;
		InputStream is = null;
		OutputStream os = null;
		
		BufferedReader br = null;
		PrintWriter pw = null;
		try {

			socket = new Socket(ip,port);
			// 소켓이 생성됨과 동시에 서버로 연결 요청
		
			if(socket != null) {

				is = socket.getInputStream();
				os = socket.getOutputStream();
				
				br= new BufferedReader(new InputStreamReader(is));
				pw = new PrintWriter(os);
								// readLine() - 한 줄 읽기
				String message = br.readLine(); // 서버에서 클라이언트로 보낸 메세지 입력
				System.out.println(message);
				
				Scanner sc = new Scanner(System.in);
				System.out.println("보내고 싶은 말 : ");
				String clientMessage = sc.next();
				
				pw.println(clientMessage); // 클라이언트에서 서버로 메세지 출력
				pw.flush();// 스트림에 작성된 내용을 강제로 밀어내는 코드
							// 미작성시 출력이 되지않음
				
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				// finally는 예외여부 상관없이 무조건 실행하기 때문에
				// 메모리 누수를 방지하기 위해서 닫아야하는 close() 코드를 사용해야함
				// close()코드는 스트림, 소켓을 생성한 역순으로 작성해야함
				if(br != null) br.close();
				if(pw != null) pw.close();
				
				if(socket != null) socket.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}			
			
		}
	}

