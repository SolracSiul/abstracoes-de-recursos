package so.memory;

import java.util.ArrayList;
import java.util.List;

public class PhysicMemory {
	
	private Integer totalSize = 0;
	
	private Integer qntPages = 0; //calculado a partir
	
	private Integer qntSubProcessPerPage = 0;
	
	private List<Page> pagesMemory = new ArrayList<>();
	
	
	public PhysicMemory(Integer totalSize,Integer qntSubProcessPerPage) {
		int pages = (int) Math.ceil(totalSize/qntSubProcessPerPage);
		this.qntPages = pages;
		this.totalSize = totalSize;
		this.qntSubProcessPerPage = qntSubProcessPerPage;
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


	public List<Page> getPagesMemory() {
		return pagesMemory;
	}


	public void setPagesMemory(List<Page> pagesMemory) {
		this.pagesMemory = pagesMemory;
	}
	
	
	
	
	
	

}
