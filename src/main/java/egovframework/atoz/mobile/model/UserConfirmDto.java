package egovframework.atoz.mobile.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserConfirmDto {
	private String emp_number;
	private String phone;
	private int com_number;
	
}
