package so;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.UUID;

public class NewProcess {
	private String id_newProcess;
	private String name;
	private int size;
	
	public static final List<Integer> numbers = Arrays.asList(1, 2, 4, 6, 10, 20, 50, 100);
	public List<String> processNames = Arrays.asList("Chrome", "Discord", "Firefox", "Steam", "Netflix", "LOL", "Valorant");
	
	public NewProcess() {
		this.id_newProcess = generateId(); 
		this.size = generateRandomNumber();
		this.name = generateCustomName();
	}
	private String generateId(){
		return UUID.randomUUID().toString();
	}
	private String generateCustomName() {
		Random r = new Random();
        return processNames.get(r.nextInt(processNames.size()));
	}
	
	public String getId_newProcess() {
		return id_newProcess;
	}
	private int generateRandomNumber(){
		int start = 1;
		int end = 140;
		Random random = new Random();
		return random.nextInt(end-start +1) + start;
	}
	
	public void setId_newProcess(String id_newProcess) {
		this.id_newProcess = id_newProcess;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}

}
