package socket_programming;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpServer {

	public static void main(String[] args){
		try {
		    ServerSocket serverSocket=new ServerSocket(5000);
			Socket socket = serverSocket.accept();
		    InputStream input_from_client= socket.getInputStream();
			DataInputStream request= new DataInputStream(input_from_client);
			System.out.println("Request from client:"+request.readUTF());
			OutputStream responseOutToClient= socket.getOutputStream();
			DataOutputStream response=new DataOutputStream(responseOutToClient);
			response.writeUTF("Heard from client");
			serverSocket.close();
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
				
	}

}
