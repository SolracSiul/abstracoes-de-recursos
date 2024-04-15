package so;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

public class Process {
	private String name;
	private String id;
	private int sizeInMemory;
	private List<String> processes;
	private  Integer count = 0;
	private int timeToExecute;
	private PriorityProcessType priorityType;
	
	public static final List<Integer> numbers = Arrays.asList(1, 2, 4, 6, 10, 20, 50, 100);

	public List<String> processNames = Arrays.asList("Chrome", "Discord", "Firefox", "Steam", "Netflix", "LOL", "Valorant");

	public Process(int sizeMemory) {
		count++;
		Random rand = new Random();
		
		PriorityProcessType[] priorityList = PriorityProcessType.values();
		this.priorityType = priorityList[rand.nextInt(priorityList.length)];
		
		
		List<Integer> givenList = Arrays.asList(100,200,300,400,500,600,800,900,1000,2000);
		this.timeToExecute = givenList.get(rand.nextInt(givenList.size()));
		this.id = "P" + count;
		this.sizeInMemory = sizeMemory;
		this.processes = this.getProcesses();
	}
	public List<String> getProcesses(){
		if(this.processes == null) {
			this.processes = new LinkedList<>();
			for(int i =0; i < this.sizeInMemory ; i++ ) {
				String spId = this.getId() + i;
				this.processes.add(spId);
			}
		}
		return this.processes;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getSizeInMemory() {
		return sizeInMemory;
	}
	public void setSizeInMemory(int sizeInMemory) {
		this.sizeInMemory = sizeInMemory;
	}
	private int generateRandomNumber(){
		Random r = new Random();
		return numbers.get(r.nextInt(numbers.size()));
	}
	private String generateCustomName() {
		Random r = new Random();
        return processNames.get(r.nextInt(processNames.size()));
	}
	private String generateId(){
		return UUID.randomUUID().toString();
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getTimeToExecute() {
		return timeToExecute;
	}
	public void setTimeToExecute(int timeToExecute) {
		this.timeToExecute = timeToExecute;
	}
	public PriorityProcessType getPriorityType() {
		return priorityType;
	}
	public void setPriorityType(PriorityProcessType priorityType) {
		this.priorityType = priorityType;
	}
}
