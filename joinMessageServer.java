import java.net.*;
import java.io.*;
public class joinMessageServer
{
      static Socket s;
      public static void main(int prt) throws Exception
      {
          ServerSocket sers = new ServerSocket(4999);
          s = sers.accept( );                          
          BufferedReader kr = new BufferedReader(new InputStreamReader(System.in));
          OutputStream os = s.getOutputStream(); 
          PrintWriter pw = new PrintWriter(os, true);
          InputStream is = s.getInputStream();
          BufferedReader rr = new BufferedReader(new InputStreamReader(is));
          String smsg=prt+"";   
          pw.println(smsg);             
          pw.flush();  
          sers.close();
          s.close();
        } 
}
