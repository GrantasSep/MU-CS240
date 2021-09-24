// This is the Client Code, save as DateSocketClient.java
import java.net.*;
import java.io.*;
public class DateSocketClient {
public static void main(String[] args) throws IOException {
try {
System.out.println("Creating a socket connection to server on port 6013");
Socket sock = new Socket("127.0.0.1",6013);
InputStream in = sock.getInputStream();
// bin is the buffered input stream from the server
BufferedReader bin = new BufferedReader(new InputStreamReader(in));
String line;
System.out.println("Reading data from Server over socket connection");
while ( (line = bin.readLine()) != null)
System.out.println("The date received from the server was: "+line);
sock.close();
}
catch (IOException ioe) {
System.err.println(ioe);
}
}
}

