package edu.kh.network.ex1.client;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client복습 {

	public void start() {
		String ip = "127.0.0.1";
		int port = 8000;
		
		Socket socket = null; // 클라이언트 - 서버 연결
		
		InputStream is = null;
		OutputStream os = null;
		
		BufferedReader br = null;
		PrintWriter pw = null;
		
		try {
			socket = new Socket(ip, port); // ip주소+포트번호와 연결되는 소켓 생성
			// 입출력 스트림 생성
			if(socket != null) {
				is = socket.getInputStream();
				os = socket.getOutputStream();
				// 보조 스트림
				br = new BufferedReader(new InputStreamReader(is));
				pw = new PrintWriter(os);
			}
			
			// 서버 -> 클라이언트로 전달된 메세지 입력
			String serverMessage = br.readLine();
			
			// 클라이언트 -> 서버 메세지 전달
			Scanner sc = new Scanner(System.in);
			System.out.println("전달할 메세지 : ");
			String clientMessage = sc.next();
			
			pw.print(clientMessage);
			pw.flush();
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(br != null) br.close();
				if(pw != null) pw.close();
				if(socket != null) socket.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
	}

}
