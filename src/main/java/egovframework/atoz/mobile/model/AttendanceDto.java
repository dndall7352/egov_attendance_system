package egovframework.atoz.mobile.model;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AttendanceDto {
	private String emp_number;
	private Date dates;
	private String att_name;
	private String dep_name;
	private int connet_code;
}
