public class Writer extends Thread {

// All threads which use the data being synchronised should 
// share the same DataAccessPolicyManager object to 
// coordinate access. The instance could be passed in to the 
// constructor for the Writer class.

private DataAccessPolicyManager2 accessManager;


   public Writer (DataAccessPolicyManager2 accessManager) {
   	this.accessManager = accessManager;
   }

   public void run() {
	while (true) {

	    accessManager.acquireWriteLock();
            System.out.println("Writer acquired write lock");
            try {
                sleep ((int)(Math.random()*2000));
            } catch(Exception e){}

            System.out.println("Writer stopped writing, releasing lock");
            accessManager.releaseWriteLock();
            try {
                sleep ((int)(Math.random()*2000));
            } catch(Exception e){}
	}

   }
}

