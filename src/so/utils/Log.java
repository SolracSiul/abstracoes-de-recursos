package so.utils;

public class Log {
    private int sizeProcess;
    private int sizeMemory;
    private String idProcess;
    
    public Log(int sizeProcess, String idProcess) {
        this.sizeProcess = sizeProcess;
        this.idProcess = idProcess;
        this.sizeMemory = 128;
    }
    
    public void showBit() {
    	  StringBuilder sb = new StringBuilder("[ ");
      	    for (int i = 0; i < sizeProcess; i++) {
    	        sb.append(idProcess.split("-")[0]);
    	        if (i < sizeProcess - 1) {
    	            sb.append(" | ");
    	        }
    	    }
       	    for (int i = sizeProcess; i < sizeMemory; i++) {
    	        sb.append(" | null");
    	    }    	    
    	    sb.append(" ]");
    	    System.out.println(sb.toString());
       
    } 
}

