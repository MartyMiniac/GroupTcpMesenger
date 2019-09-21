import java.util.*;
import javax.sound.sampled.*;
class clientSound extends Thread
{
    public float SAMPLE_RATE = 8000f;
    public int hz=800, msecs=1000;
    public double vol=1.0;        
    byte[] buf = new byte[(int)SAMPLE_RATE * msecs / 1000];  
    AudioFormat af;
    clientSound()
    {      
        for (int i=0; i<buf.length; i++) 
        {
            double angle = i / (SAMPLE_RATE / hz) * 2.0 * Math.PI;
            buf[i] = (byte)(Math.sin(angle) * 127.0 * vol);
            vol=vol*0.9992;
        }
        for (int i=0; i < SAMPLE_RATE / 100.0 && i < buf.length / 2; i++)
        {
            buf[i] = (byte)(buf[i] * i / (SAMPLE_RATE / 100.0));
            buf[buf.length-1-i] =
            (byte)(buf[buf.length-1-i] * i / (SAMPLE_RATE / 100.0));
        }    
        af = new AudioFormat(SAMPLE_RATE,8,1,true,false);
    }
    public void run()
    {                
        try
        {
            SourceDataLine sdl = AudioSystem.getSourceDataLine(af);
            sdl.open(af);
            sdl.start();
            sdl.write(buf,0,buf.length);
            sdl.drain();
            sdl.close();
        }
        catch(Exception e){}
    }
}
