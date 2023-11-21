package egovframework.atoz.main.model;


import java.util.Date;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class NoticDto {
	private int num;
	private String dep_name;
	private String emp_number;
	private String title;
	private String content;
	private Date dates;
}
