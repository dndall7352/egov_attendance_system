package egovframework.atoz.main.scode.service;

import lombok.Data;

@Data
public class SCodeVO {

	private int code_group;
	private int com_number;
	private String code_group_name;
	private String c_note;
	private int code;
	private String code_name;
	private String cg_note;

	public int getCode_group() {
		return code_group;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getCode_name() {
		return code_name;
	}

	public void setCode_name(String code_name) {
		this.code_name = code_name;
	}

	public void setCode_group(int code_group) {
		this.code_group = code_group;
	}

	public int getCom_number() {
		return com_number;
	}

	public void setCom_number(int com_number) {
		this.com_number = com_number;
	}

	public String getCode_group_name() {
		return code_group_name;
	}

	public void setCode_group_name(String code_group_name) {
		this.code_group_name = code_group_name;
	}


}
