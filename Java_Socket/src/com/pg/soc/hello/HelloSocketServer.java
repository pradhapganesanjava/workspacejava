package com.pg.soc.hello;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class HelloSocketServer {

	public static void main(String[] args) throws Exception {
		int port = 9999;
		ServerSocket socServ = new ServerSocket(port);
		System.out.println("server started at port : "+port);
		
		while(true){
			Socket socClient = socServ.accept();
			
			String clientMsg = readSocket(socClient);
			System.out.println(" client msg: "+clientMsg);
			if(clientMsg.contains("AVAIL")){
				PrintWriter po = writeSocket(socClient);
				po.write("Server is available.");
				po.flush();
			}else if(clientMsg.contains("ACK1")){
				System.out.println("Thanks for confirmation");				
			}
			if("TERMINATE".equals(clientMsg)){
				break;
			}
			
		}
		socServ.close();

		
		
	}

	private static PrintWriter writeSocket(Socket socClient) throws IOException {
		OutputStream socOS = socClient.getOutputStream();
		OutputStreamWriter osWrite = new OutputStreamWriter(socOS);
		PrintWriter po = new PrintWriter(osWrite);
		return po;
	}

	private static String readSocket(Socket socClient) throws IOException {
		BufferedReader bufRead = new BufferedReader(new InputStreamReader(socClient.getInputStream()));
		String clientMsg = bufRead.readLine();
		return clientMsg;
	}

}
