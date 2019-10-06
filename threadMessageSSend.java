import java.net.*;
import java.io.*;
class threadMessageSSend extends Thread
{
      Socket s;
      String sndmsg;
      threadMessageSSend(Socket skt, String sstring)
      {
          sndmsg=sstring;
          s=skt;
      }
      public void run()
      {
          try
          {                   
              OutputStream os = s.getOutputStream(); 
              PrintWriter pw = new PrintWriter(os, true);
              String rmsg, smsg;  
                pw.println(sndmsg);             
                pw.flush();
          }
          catch(Exception e){}
        } 
}                 
