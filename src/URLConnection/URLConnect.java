package URLConnection;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class URLConnect {

	public static void main(String[] args) {
		try {
		    URL url=new URL("https://igihe.com/");
		    URLConnection igiheConn=url.openConnection();
		    BufferedReader reader=new BufferedReader(new InputStreamReader(igiheConn.getInputStream()));
		    String line=null;
		    while((line=reader.readLine())!=null) {
		    	System.out.println(line);
		    }
		}catch(Exception e) {
			e.getMessage();
		}
	}

}
