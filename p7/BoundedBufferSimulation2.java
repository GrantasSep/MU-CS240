public class BoundedBufferSimulation2 {
 public static void main (String args[]) {
 Buffer buffer = new Buffer();
 
 // Create one producer and one consumer process
 Thread producer1 = new Thread(new Producer2(buffer,1));
 Thread producer2 = new Thread(new Producer2(buffer,2));
 Thread consumer1 = new Thread(new Consumer2(buffer,1));
 Thread consumer2 = new Thread(new Consumer2(buffer,2));
 producer1.start();
 consumer1.start();
 producer2.start();
 consumer2.start();
 }
}
