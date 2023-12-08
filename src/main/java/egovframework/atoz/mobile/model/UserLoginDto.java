package egovframework.atoz.mobile.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserLoginDto {
	private String emp_number;
	private String password;
}
