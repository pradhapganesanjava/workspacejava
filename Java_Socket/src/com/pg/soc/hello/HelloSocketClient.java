package com.pg.soc.hello;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class HelloSocketClient {

	public static void main(String...str) throws Exception{
		String ip = "localhost";
		int port = 9999;
		
		Socket soc = new Socket(ip,port);
		
		String sendMsg = "Hi.. this Pradhap";
		String avail = "Client: AVAIL: Are you available?";
		String ack1 = "Client: ACK1: Acknowledge";
		
		System.out.println("Client: server communication START");
		
		OutputStreamWriter osWriter = new OutputStreamWriter(soc.getOutputStream());
		PrintWriter po = new PrintWriter(osWriter);
		po.write(avail);
		po.flush();

		InputStream socIs = soc.getInputStream();
		InputStreamReader isReader = new InputStreamReader(socIs);
		BufferedReader bufReader = new BufferedReader(isReader);
		
		String availConf = bufReader.readLine();
		System.out.println("Client: AVAIL: "+availConf);
		
		po.write(ack1);
		po.flush();
		
		po.write(sendMsg);
		po.flush();
		
		String msgReceived = bufReader.readLine();
		System.out.println("Client: MSG: server ack ? "+msgReceived);

		po.write("TERMINATE");
		po.flush();
		
		soc.close();
		
		System.out.println("Client: server communication complete");
		
	}
}
