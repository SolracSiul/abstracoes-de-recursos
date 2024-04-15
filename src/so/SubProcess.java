package so;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class SubProcess {
	private String id;
	private int instructionsNumber;
	public static int count;
	
	public SubProcess(String processID, int instructionsNumber) {
		count++;
		this.id = processID + count;
		this.instructionsNumber = instructionsNumber;
		
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getInstructions() {
		return instructionsNumber;
	}
	public void setInstructions(int instructionsNumber) {
		this.instructionsNumber = instructionsNumber;
	}
}
