import java.net.*;
import java.io.*;

public class WorkerThread extends Thread
{
	int connectionNumber;
	Socket client;

	public WorkerThread(Socket client, int connectionNumber)
	{
		this.client = client;
		this.connectionNumber = connectionNumber;		
		
	}
	
	public void run(){
	try{	
		System.out.println("Connection Accepted");
		PrintWriter pout = new PrintWriter(client.getOutputStream(),true);
		pout.println(new java.util.Date().toString());
		pout.println("Finished Processing Client "+connectionNumber);
		client.close();
		}
		catch(IOException ioe){
			System.err.println(ioe);
		}
	}
}

