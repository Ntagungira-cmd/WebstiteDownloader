package socket_programming;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPClient {

	public static void main(String[] args){
	
		try {
		DatagramSocket socket=new DatagramSocket();
	    String request="Hello Server This is from client";	
	    byte[]  requestbytes=request.getBytes();
	    InetAddress ip=InetAddress.getLocalHost();
	    DatagramPacket dprequest=new DatagramPacket(requestbytes,requestbytes.length,ip,7000);
	    socket.send(dprequest);
	    byte[] buffer=new byte[1024];
	    DatagramPacket dpresponse=new DatagramPacket(buffer,1024);
	    socket.receive(dpresponse);
	    String response=new String(dpresponse.getData(),0,dpresponse.getLength());
	    System.out.println(response);
	    socket.close();
		}catch(Exception e) {
			e.getMessage();
		}
		
	}

}
