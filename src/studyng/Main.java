package studyng;

public class Main {

	public static void main(String[] args) {
		System.out.println("Hello World");
		
		for (int i= 0; i <=1 ;i++) {
			Multithread myThread = new Multithread(i);
			//myThread.start();
		}
		Multithread myThread = new Multithread();
		 int blockSize[] = {300}; 
	     int processSize[] = {99,99,120}; 
	     int m = blockSize.length; 
	     int n = processSize.length; 
	     myThread.firstFit(blockSize,m, processSize,n);
		//esse código executa em outra thread
		//throw new RuntimeException();
	}
}
