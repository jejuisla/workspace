package edu.kh.network.ex1.server;

import java.io.BufferedReader;
import java.io.IOException;
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
		int port = 5000;
		
		ServerSocket serverSocket = null;
		Socket clientSocket = null;
		
		InputStream is = null;
		OutputStream os = null;
		
		BufferedReader br = null;
		PrintWriter pw = null;
		
		// 소켓, 스트림 참조 변수를 try, finally 모두 사용할 수 있도록 try구문 밖에 작성
		try {
			serverSocket = new ServerSocket(port);
			clientSocket = serverSocket.accept();
			
			is = clientSocket.getInputStream();
			os = clientSocket.getOutputStream();
			
			br = new BufferedReader(new InputStreamReader(is));
			pw = new PrintWriter(os);
			
			Date now = new Date();
			
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			
			String Message = sdf.format(now);
			// pw = printWriter -> 서버에서 클라이언트로 출력
			pw.println(Message);
			pw.flush();
			
			// br = bufferedReader -> 클라이언트에서 서버로 입력
			String ClientMessage = br.readLine();
			
			System.out.println(ClientMessage);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(br != null) br.close();
				if(pw != null) pw.close();
				
				if(serverSocket != null) serverSocket.close();
				if(clientSocket != null) clientSocket.close();
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
	}

}
