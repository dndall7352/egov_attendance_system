package egovframework.atoz.main.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserVo {
	private String emp_number;
	private int com_number;
	private int dep_number;
	private int aut_number;
	private String password;
	private String name;
	private int rank_code;
	private String phone;
	private String photo;
	private String token;
	private String use_pass;
	
	
}
