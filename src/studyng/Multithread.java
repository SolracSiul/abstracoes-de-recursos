package studyng;
import java.lang.management.*;
public class Multithread extends Thread{

	public Multithread() {
		super();
	}
	private int threadNumber;
	
	public Multithread(int threadNumber) {
		this.threadNumber = threadNumber;
	}
	@Override
	public void run() {
		for(int i = 1; i <=2; i++) {
			System.out.println(i+ " from this thread " + threadNumber);
			printMemoryUsage();
			//if(threadNumber == 3) {
			//	throw new RuntimeException();
			//}
		}
		try {
			Thread.sleep(1000);
		}catch(InterruptedException e) {
			
		}
		
	}
	private void printMemoryUsage() {
        MemoryMXBean memoryBean = ManagementFactory.getMemoryMXBean();
        MemoryUsage heapMemoryUsage = memoryBean.getHeapMemoryUsage();
        MemoryUsage nonHeapMemoryUsage = memoryBean.getNonHeapMemoryUsage();

        System.out.println("Heap Memory Usage:");
        //tamanho inicial da memória heap - espaço disponibilizado
        System.out.println("   Initial: " + heapMemoryUsage.getInit());
        //espaço que realmente utilizou
        System.out.println("   Used: " + heapMemoryUsage.getUsed());
        // quantidade que a JVM disponiblizou
        System.out.println("   Committed: " + heapMemoryUsage.getCommitted());
        //quantidade máxima de memória que poderá utilizar
        System.out.println("   Max: " + heapMemoryUsage.getMax());

        System.out.println("Non-Heap Memory Usage:");
        System.out.println("   Initial: " + nonHeapMemoryUsage.getInit());
        System.out.println("   Used: " + nonHeapMemoryUsage.getUsed());
        System.out.println("   Committed: " + nonHeapMemoryUsage.getCommitted());
        System.out.println("   Max: " + nonHeapMemoryUsage.getMax());

        System.out.println("--------------------");
    }
	static void firstFit(int blockSize[], int numberBlock, int processSize[], int numberProcess) {
	    int allocation[] = new int[numberProcess];
	    
	    for (int i = 0; i < allocation.length; i++) {
	        allocation[i] = -1;
	        for (int j = 0; j < numberBlock; j++) {
	            for (int k = 0; k < numberProcess; k++) {
	                if (blockSize[j] >= processSize[k] && allocation[k] == -1) {
	                    allocation[k] = j; 
	                    blockSize[j] -= processSize[k];
	                    break;
	                }
	            }
	        }
	    }
	    
	    System.out.println("\nProcess No.\tProcess Size\tBlock no."); 
	    for (int i = 0; i < numberProcess; i++) {
	        System.out.print(" " + (i+1) + "\t\t" + processSize[i] + "\t\t"); 
	        if (allocation[i] != -1) {
	            System.out.print(allocation[i] + 1); 
	        } else {
	            System.out.print("Not Allocated"); 
	        }
	        System.out.println(); 
	    } 
	}
	static void worstFit() {
		System.out.println("em progresso");
	}
	static void bestFit() {
		System.out.println("em progresso");
	}
	
	
}
