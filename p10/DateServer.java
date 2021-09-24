// This is the Server code, save as DateServer.java
import java.net.*;
import java.io.*;
 
public class DateServer {
   public static void main(String[] args) throws IOException {
      try {
         // This creates a listener socket 
         ServerSocket sock = new ServerSocket(6013);

         while (true) {
	    int connectionNumber =+ 1;
            Socket client = sock.accept();
            // pout is the output stream to the client
            WorkerThread exe = new WorkerThread(client,connectionNumber);
	    exe.run();
            client.close();
         }
      }
      catch (IOException ioe) {
         System.err.println(ioe);
      }
   }
}


