import java.net.*;
import java.io.*;
class threadMessageS2 extends Thread
{
      static Socket s;
      int prt;
      threadMessageS2(Socket sacpt)
      {
          s=sacpt;
      }
      public void run()
      {
          try
          {
              String t=(s+"").substring((s+"").length()-5,(s+"").length()-1)+" Joined";
              System.out.println(t);
              threadMessageSendInit sendmsg = new threadMessageSendInit();
              sendmsg.main(t);
              BufferedReader kr = new BufferedReader(new InputStreamReader(System.in));
              OutputStream os = s.getOutputStream(); 
              PrintWriter pw = new PrintWriter(os, true);
              InputStream is = s.getInputStream();
              BufferedReader rr = new BufferedReader(new InputStreamReader(is));
              recive();      
            }
            catch(Exception e)
            {}
      } 
      void recive()
      {
           try
            {
                threadMessageSendInit objt = new threadMessageSendInit();
                //sListTotMSI2 objt2 = new sListTotMSI2();
                 InputStream is = s.getInputStream();
                 BufferedReader rr = new BufferedReader(new InputStreamReader(is));     
                String rmsg;    
                while(true)
                {
                    if((rmsg = rr.readLine()) != null)
                    {
                        System.out.println(rmsg);
                        objt.main(rmsg);
                        //objt2.main(rmsg);
                    }  
                }
            }
            catch(Exception e)
            {}
      }
}
