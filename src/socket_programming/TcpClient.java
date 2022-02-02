package socket_programming;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class TcpClient {

	public static void main(String[] args) {
		try {
			Socket socket=new Socket("192.168.1.46",5000);
			OutputStream out_to_server=socket.getOutputStream();
			DataOutputStream request_to_send=new DataOutputStream(out_to_server);
			request_to_send.writeUTF("Hello My Server");
			InputStream in_from_server=socket.getInputStream();
			DataInputStream response= new DataInputStream(in_from_server);
			System.out.println("The server responded: "+response.readUTF());
			socket.close();
		}catch(Exception e) {
			e.getMessage();
		}

	}

}
