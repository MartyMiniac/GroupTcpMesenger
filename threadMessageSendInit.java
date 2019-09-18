class threadMessageSendInit
{
    public void main(String s)
    {
        sList lst = new sList();
        for(int a=0; a<10; a++)
        {            
            try
            {
                threadMessageSSend ob = new threadMessageSSend(lst.s[a],s);
                ob.start();
            }
            catch(Exception e){}
        }
    }
}
