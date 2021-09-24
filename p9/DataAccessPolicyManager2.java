public class DataAccessPolicyManager2
// This class implements methods to solve the second readers writers problem
// Writers are prioritised over readers 
{
    private int readCount, writeCount;
    private Semaphore mutexReadCount, mutexWriteCount;
    private Semaphore wrt, rdr;
 
   public DataAccessPolicyManager2 () 
  {
	readCount = 0;
        writeCount = 0;
        mutexReadCount = new Semaphore(1);
        mutexWriteCount = new Semaphore(1);
        wrt = new Semaphore(1);
        rdr = new Semaphore (1);
   }

   public void acquireReadLock() 
   {
	rdr.acquire(); 
        mutexReadCount.acquire();
        readCount = readCount + 1;
        if (readCount == 1) wrt.acquire(); 
        mutexReadCount.release();
        rdr.release(); 
   }	

   public void releaseReadLock() 
   {
        mutexReadCount.acquire();
        readCount = readCount - 1;
        if (readCount == 0) wrt.release();
        mutexReadCount.release();
   }

   public void acquireWriteLock() 
   {
	mutexWriteCount.acquire();
        writeCount = writeCount+1;
        if (writeCount == 1) rdr.acquire();
        mutexWriteCount.release();
        wrt.acquire();
   }
 
   public void releaseWriteLock() 
  {
	 wrt.release();
        mutexWriteCount.acquire();
        writeCount = writeCount - 1;
        if (writeCount==0) rdr.release();
        mutexWriteCount.release();
	wrt.release();
   }
}

