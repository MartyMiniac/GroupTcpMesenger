import java.net.*;
import java.io.*;
import java.util.*;
public class MesengerClient2
{
   static Socket s; 
  public static void main(String[] args) throws Exception
  {
      Scanner in = new Scanner(System.in);
      System.out.print("Enter the Client IP :");
      String inpip=in.nextLine();
      System.out.print("Enter you Name :");
      String t=in.nextLine();
      s = new Socket(inpip, 4999); 
      BufferedReader rtemp = new BufferedReader(new InputStreamReader(s.getInputStream()));
      String temp="";
        while(true)
        {
            if((temp = rtemp.readLine()) != null)
            {
                break;
            }  
        }
      s = new Socket(inpip, Integer.parseInt(temp)); 
     BufferedReader kr = new BufferedReader(new InputStreamReader(System.in));
     OutputStream os = s.getOutputStream(); 
     PrintWriter pw = new PrintWriter(os, true);
     BufferedReader rr = new BufferedReader(new InputStreamReader(s.getInputStream()));
     System.out.println("Client Ready");
     getmsg ob = new getmsg();
     ob.start();
     String rmsg, smsg;               
     while(true)
     {
        smsg = kr.readLine();
          smsg=t+" : "+smsg;
        pw.println(smsg);
        pw.flush(); 
      }                
    }                    
}        
class getmsg extends Thread
{
        public void run()
        {
            try
            {
                MesengerClient2 ob = new MesengerClient2();
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
