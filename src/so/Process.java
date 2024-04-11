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
	
	public static final List<Integer> numbers = Arrays.asList(1, 2, 4, 6, 10, 20, 50, 100);

	public List<String> processNames = Arrays.asList("Chrome", "Discord", "Firefox", "Steam", "Netflix", "LOL", "Valorant");

	/*	private int timeToExecute;
	private int priority;
	private List<Process> processes;
	private int instructions;*/
	
	public Process(int sizeMemory) {
		count++;
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
}
