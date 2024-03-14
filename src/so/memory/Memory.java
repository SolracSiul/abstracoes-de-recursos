package so.memory;

import java.util.Random;
import java.util.UUID;

public class Memory {
	private String id_memory;
	private int tamanho;
	private boolean alocado;
	private String id_Process;
	private Integer tamanhoDoProcesso;
	private String nomeDoProcesso;
	
	public Memory() {
		 this.id_memory = generateId();
		 this.alocado = false;
		 this.id_Process = null;
		 this.tamanhoDoProcesso = null;
		 this.tamanho = generateRandomInt();
		 this.nomeDoProcesso = null;
	}

	public String getId_memory() {
		return id_memory;
	}

	public void setId_memory(String id_memory) {
		this.id_memory = id_memory;
	}

	public int getTamanho() {
		return tamanho;
	}

	public void setTamanho(int tamanho) {
		this.tamanho = tamanho;
	}

	public boolean isAlocado() {
		return alocado;
	}

	public void setAlocado(boolean alocado) {
		this.alocado = alocado;
	}

	public String getId_Process() {
		return id_Process;
	}

	public void setId_Process(String id_Process) {
		this.id_Process = id_Process;
	}
	private String generateId(){
		return UUID.randomUUID().toString();
	}
	private static int generateRandomInt() {
		int start = 1;
		int end = 2666;
		Random random = new Random();
		return random.nextInt(end-start +1) + start;
	}

	public Integer getTamanhoDoProcesso() {
		return tamanhoDoProcesso;
	}

	public void setTamanhoDoProcesso(Integer tamanhoDoProcesso) {
		this.tamanhoDoProcesso = tamanhoDoProcesso;
	}

	public String getNomeDoProcesso() {
		return nomeDoProcesso;
	}

	public void setNomeDoProcesso(String nomeDoProcesso) {
		this.nomeDoProcesso = nomeDoProcesso;
	}

	@Override
	public String toString() {
	    return "Memory [id_memory=" + id_memory.split("-")[0] + ", tamanhoDaMemoria=" + tamanho + ", alocado=" + alocado +
	            ", id_Process=" + ((id_Process != null) ? id_Process.split("-")[0] : id_Process) +
	            ", tamanhoDoProcesso=" + tamanhoDoProcesso + ", nomeDoProcesso=" + nomeDoProcesso + "]";
	}

}
