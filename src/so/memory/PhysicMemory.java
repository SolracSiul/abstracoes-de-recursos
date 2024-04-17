package so.memory;

import java.util.ArrayList;
import java.util.List;

public class PhysicMemory {
	
	private Integer totalSize = 0;
	
	private Integer qntPages = 0; //calculado a partir
	
	private Integer qntSubProcessPerPage = 0;
	
	private List<Block> blocksOfMemory = new ArrayList<>();
	
	
	public PhysicMemory(Integer totalSize,Integer qntSubProcessPerPage) {
		int pages = (int) Math.ceil(totalSize/qntSubProcessPerPage);
		this.qntPages = pages;
		this.totalSize = totalSize;
		this.qntSubProcessPerPage = qntSubProcessPerPage;
		for(int i = 0; i < qntSubProcessPerPage; i++) {
			blocksOfMemory.add(new Block(pages,"BL-" + String.valueOf(i)));
		}
	}


	public Integer getTotalSize() {
		return totalSize;
	}


	public void setTotalSize(Integer totalSize) {
		this.totalSize = totalSize;
	}


	public Integer getQntPages() {
		return qntPages;
	}


	public void setQntPages(Integer qntPages) {
		this.qntPages = qntPages;
	}


	public Integer getQntSubProcessPerPage() {
		return qntSubProcessPerPage;
	}


	public void setQntSubProcessPerPage(Integer qntSubProcessPerPage) {
		this.qntSubProcessPerPage = qntSubProcessPerPage;
	}


	public List<Block> getBlocksOfMemory() {
		return blocksOfMemory;
	}


	public void setBlocksOfMemory(List<Block> blocksOfMemory) {
		this.blocksOfMemory = blocksOfMemory;
	}



	
	
	
	
	
	

}
