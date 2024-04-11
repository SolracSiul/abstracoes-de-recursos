package so;

public class SubProcess {
	private String id;
	private int timeToExecute;
	private int instructionsNumber;
	private static int count;
	
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
	public int getTimeToExecute() {
		return timeToExecute;
	}
	public void setTimeToExecute(int timeToExecute) {
		this.timeToExecute = timeToExecute;
	}
	public int getInstructions() {
		return instructionsNumber;
	}
	public void setInstructions(int instructionsNumber) {
		this.instructionsNumber = instructionsNumber;
	}
}
