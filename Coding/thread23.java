public class ThreadSynchronizer
{
    public static void main(String[] args)
    {
        int threadCnt = Integer.parseInt(args[0]);
        ReentrantLock lckArray[] = new ReentrantLock[threadCnt + 1];
        for (int i = 0; i < threadCnt + 1; i++)
        {
            ReentrantLock lck = new ReentrantLock();
            lck.lock();
            lckArray[i] = lck;
        }
        for (int i = 0; i < threadCnt; i++)
        {
            Thread th = new Thread(new Printer(lckArray, i + 1));
            th.start();
        }
        for (int i = 1; i < threadCnt + 1; i++)
        {
            lckArray[i].unlock();
            while (!lckArray[i].isLocked())
            {
            }
        }
        lckArray[0].unlock();
    }
}
class Printer implements Runnable
{
    private ReentrantLock[] lckArray;
    private int index;
    Printer(ReentrantLock[] lckArray, int startValue)
    {
        this.lckArray = lckArray;
        this.index = startValue;
    }
    @Override public void run()
    {
        ReentrantLock prevLock = null;
        int printCounter = index;
        for (int counter = 0; printCounter <= 1000; counter++)
        {
            int remCounter = counter % lckArray.length;
            int incCounter = lckArray.length - remCounter;
            int indexPostion = index + incCounter;
            int curElementIndex = indexPostion % lckArray.length;
            lckArray[curElementIndex].lock();
            if (prevLock != null)
                prevLock.unlock();
            prevLock = lckArray[curElementIndex];
            if (curElementIndex == 0)
            {
                System.out.println("Printed by Thread " + index + " " + printCounter);
                printCounter = printCounter + lckArray.length - 1;
            }
        }
        if (prevLock != null)
        {
            if (prevLock.isHeldByCurrentThread())
                prevLock.unlock();
        }
    }
}