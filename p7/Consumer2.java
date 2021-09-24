import java.util.Date;
public class Consumer2 implements Runnable 
{
 	private Buffer buffer;
	int ID;

	public Consumer2(Buffer buffer,int id) 
	{
 	this.buffer = buffer;
	this.ID = id;
 	}
 	public void run() 
	{
 	Date message;
 	while (true) 
	{
 	try 
	{
 	Thread.sleep(1000); // sleep for 1000 ms
 	} catch (InterruptedException e) {}
 	message = (Date) buffer.remove();
 	// consume the item
 	System.out.println("consumer "+ID+" Removed "+ message);
 	}
 	}
}
