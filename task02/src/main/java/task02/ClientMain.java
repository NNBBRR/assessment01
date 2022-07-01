package task02;

import java.io.IOException;
import java.net.Socket;

public class ClientMain 
{
    public static void main( String[] args ) throws IOException
    {
        Socket sock = new Socket("68.183.239.26", 80);

		System.out.printf(" connected\n");

		Session sess = new Session(sock);
		sess.start();

        
    }
}
