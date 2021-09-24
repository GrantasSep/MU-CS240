public class Reader extends Thread {

// All threads which use the data being synchronised should 
// share the same DataAccessPolicyManager object to 
// coordinate access. The instance could be passed in to the 
// constructor for the Reader class.

private DataAccessPolicyManager2 accessManager;


   public Reader (DataAccessPolicyManager2 accessManager) {
   	this.accessManager = accessManager;
   }

   public void run() {
	while (true) {

	     accessManager.acquireReadLock();
            System.out.println("Reader acquired read lock");
            try{
                sleep ((int)(Math.random()*2000));
            }catch(Exception e){}

            System.out.println("Reader stopped Reading, releasing lock");
            accessManager.releaseReadLock();
            try{
                sleep ((int)(Math.random()*2000));
            }catch(Exception e){}

	}

   }
}

