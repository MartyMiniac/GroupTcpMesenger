import java.net.*;
import java.io.*;
public class MesengerServer
{
      static Socket s;
      public static void main(String[] args) throws Exception
      {
          getmsg2 ob = new getmsg2();
          ServerSocket sers = new ServerSocket(5001);
          System.out.println("Server Online");
          s = sers.accept( );                          
          BufferedReader kr = new BufferedReader(new InputStreamReader(System.in));
          OutputStream os = s.getOutputStream(); 
          PrintWriter pw = new PrintWriter(os, true);
          InputStream is = s.getInputStream();
          BufferedReader rr = new BufferedReader(new InputStreamReader(is));
          ob.start();
          String rmsg, smsg;               
          while(true)
          {   
            smsg = kr.readLine(); 
            pw.println(smsg);             
            pw.flush();
          }               
        } 
}     
class getmsg2 extends Thread
{
        public void run()
        {
            try
            {
                MesengerServer ob = new MesengerServer();
                 InputStream is = ob.s.getInputStream();
                 BufferedReader rr = new BufferedReader(new InputStreamReader(is));     
                String rmsg;    
                while(true)
                {
                    if((rmsg = rr.readLine()) != null)
                    {
                        System.out.println(rmsg);
                    }  
                }
            }
            catch(Exception e)
            {}
        }
}              
