package so;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import so.memory.AdressMemory;

public class Process {
	private String id;
	//tamanho da memoria
	private int sizeInMemory;
	private int timeToExecute;
	private int priority;
	private List<Process> processes;
	private int instructions;
	private AdressMemory adress;
	
	public Process() {
		this.id = UUID.randomUUID().toString();
		Random r = new Random();
		List<Integer> numbers = Arrays.asList(1,2,4,6,10,20,50,100);
		this.sizeInMemory = numbers.get(r.nextInt(numbers.size()));
	}
}
