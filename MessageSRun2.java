import java.net.*;
class MessageSRun2
{
    static Socket s[] = new Socket[10];
    public static void main(String args[])throws Exception
    {
        sList slst = new sList();
        joinMessageServer join = new joinMessageServer();
        for(int a=5001; a<=5010; a++)
        {
            join.main(a);
            ServerSocket srs = new ServerSocket(a);
            s[a-5001] = srs.accept( );    
            threadMessageS2 ob = new threadMessageS2(s[a-5001]);
            ob.start();
            slst.addSocket(s[a-5001]);
        }
    }
}
