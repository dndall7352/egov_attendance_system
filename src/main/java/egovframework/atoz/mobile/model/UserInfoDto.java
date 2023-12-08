package egovframework.atoz.mobile.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserInfoDto {
	private String emp_number;
	private String name;
	private String dep_name;
	private String phone;
	private String rank_name;
	private String photo;
}
