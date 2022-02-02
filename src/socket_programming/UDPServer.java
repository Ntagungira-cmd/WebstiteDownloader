package socket_programming;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPServer {

	public static void main(String[] args){
		try {
		 DatagramSocket serverSocket = new DatagramSocket(7000);
		 while(true) {
			 byte[] buffer=new byte[1024];
			 DatagramPacket dprequest=new DatagramPacket(buffer,buffer.length);
			 serverSocket.receive(dprequest);
			 String ClientResponse=new String(dprequest.getData(),0,dprequest.getLength());
			 System.out.println(ClientResponse);
			 InetAddress ip=dprequest.getAddress();
			 int clientPort=dprequest.getPort();
			 String responseToClient="Recieved Request From Client on port: "+clientPort+"with ip: "+ip;
			 byte[] response=responseToClient.getBytes();
			 DatagramPacket dpresponse=new DatagramPacket(response,response.length,ip,clientPort);
			 serverSocket.send(dpresponse);
		 }
		 }catch(Exception e) {
			 e.getMessage();
		 } 
		
		  
	}

}
