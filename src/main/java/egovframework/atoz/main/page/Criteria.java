package egovframework.atoz.main.page;

import lombok.Data;

@Data
public class Criteria {
	private int pageNum;
	private int amount;
	
	private String searchType = "all";
	private String searchName = "";
	
	public Criteria() {
		this(1, 5);
	}
	
	public Criteria(int pageNum, int amount) {
		this.pageNum = pageNum;
		this.amount = amount;
	}
}
