import java.net.*;
class sList
{
    public static Socket s[] = new Socket[10];
    int p=0;
    void addSocket(Socket sacpt)
    {
        s[p]=sacpt;
        p++;
    }
}
