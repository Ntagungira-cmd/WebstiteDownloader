package URLConnection;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
//import java.util.regex.Matcher;
//import java.util.regex.Pattern;
import java.util.ArrayList;

public class WebsiteDownloader {
	 private static URL url;
private static ArrayList<String> getLinks(URL url) throws IOException {
    	String line;
    	BufferedReader br;
	    ArrayList<String> links = new ArrayList<String>();
		try {
			br = new BufferedReader(new InputStreamReader(url.openStream()));
		
			while ((line = br.readLine()) != null) {
			    if(line.contains("href")&&line.contains("<a")&&!(line.contains("https")||line.contains("http"))) {
			    	String link = line.split("href")[1].split("=\"")[1].split("\"")[0] + "\n";
			    	if (!(link.contains("#") || link.contains("mailto") || link.isEmpty()||link.contains("./"))) {
			    		
			    		 links.add(link);
                    }
	      
			    }
			}
		 return links;
		} catch (IOException ioe) {
		 ioe.printStackTrace();
		}
		return links; 
}

@SuppressWarnings("unused")
private static Integer getFileSize(URL website) throws IOException{
    Integer fileSize = 0;
    try{
        BufferedReader lineCounter = new BufferedReader(new InputStreamReader(website.openStream()));
        while( lineCounter.readLine() != null){
            fileSize++;
        }
        lineCounter.close();
        return fileSize;
    }
    catch(Exception e){
        e.getMessage();
    }
    return fileSize;
}
//private static String filterUnwantedKeywords(String sentence){
//    sentence = sentence.replace("../","");
//    sentence = sentence.replace("./","");
//    sentence = sentence.replace("\n","");
//    return sentence;
//}	
	public static void main(String[] args) throws IOException{
      try {
    	  Double percentage=0.0;
    	  String tempPath;
    	  String ln;
    	  int curLine=0;
	      url=new URL("https://awesomity.rw/");
	      String baseUrl=url.toString();
	      URL tempUrl;
	      ArrayList<String> links=WebsiteDownloader.getLinks(url);
	      String name = url.toString().split("https://")[1].replace("/","");
	      int i=0;
	      File Mypath=new File(name);
	      boolean dir=Mypath.mkdir();
	      while(!links.isEmpty()&&links.size()>i) {
		    	    tempUrl=new URL(baseUrl+links.get(i));
		    	    if(tempUrl.openStream()!=null) {
//		    	        Integer size=WebsiteDownloader.getFileSize(tempUrl);
			    		BufferedReader reader=new BufferedReader(new InputStreamReader(tempUrl.openStream()));
			    		tempPath="C://Users//ntagu//eclipse-workspace//socket_programming//"+name+"//"+"page"+i+".html";
			    		File newFile=new File(tempPath); 
			    		if(newFile.createNewFile()) {
			    			FileWriter myWriter = new FileWriter(tempPath);
				    		while((ln = reader.readLine()) != null) {
				    			myWriter.write(ln+"\n");			    			
						    	    }
				    		System.out.println("Downloaded: "+newFile);
				    		myWriter.close();
		    		        }
				    		
		    		}
		    	    i++;
	          }
      }catch(FileNotFoundException fne) {
    	 fne.getMessage(); 
      }catch(MalformedURLException mue) {
    	  System.out.println("Found some invalid Urls");
    	  mue.getMessage();
      }catch(SecurityException se) {
    	  se.printStackTrace();
      }
	}

}
