package so;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import so.memory.AdressMemory;

public class Process {
	private String name;
	private String id;
	private int sizeInMemory; //tamanho da memoria
	private AdressMemory adress;


	public static final List<Integer> numbers = Arrays.asList(1, 2, 4, 6, 10, 20, 50, 100);

	public List<String> processNames = Arrays.asList("Chrome", "Discord", "Firefox", "Steam", "Netflix", "LOL", "Valorant");

	/*	private int timeToExecute;
	private int priority;
	private List<Process> processes;
	private int instructions;*/
	
	public Process() {
		this.id = generateId(); //Gerando id
		this.sizeInMemory = generateRandomNumber();
		this.name = generateCustomName();
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

	public AdressMemory getAdress() {
		return adress;
	}

	public void setAdress(AdressMemory adress) {
		this.adress = adress;
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
