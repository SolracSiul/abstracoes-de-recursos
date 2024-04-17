package so.memory;

import java.util.ArrayList;
import java.util.List;

public class Block {
	
	private String id;
	
	private List<Page> pages = new ArrayList<>();
	
	private Integer qntPagesInBlock;
	
	private Boolean used = Boolean.FALSE;
	
	public Block(Integer qntPagesInBlock,String id) {
		this.qntPagesInBlock = qntPagesInBlock;
		this.id = id;
		for (int i = 0; i < qntPagesInBlock; i++) {
			pages.add(new Page("PG-" + String.valueOf(i)));
		}
	
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public List<Page> getPages() {
		return pages;
	}

	public void setPages(List<Page> pages) {
		this.pages = pages;
	}

	public Integer getQntPagesInBlock() {
		return qntPagesInBlock;
	}

	public void setQntPagesInBlock(Integer qntPagesInBlock) {
		this.qntPagesInBlock = qntPagesInBlock;
	}

	public Boolean getUsed() {
		return used;
	}

	public void setUsed(Boolean used) {
		this.used = used;
	}
	
	
	

}
