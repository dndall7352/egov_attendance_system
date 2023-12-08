package egovframework.atoz.mobile.model;

import java.util.Date;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ScheduleDto {
	private String emp_number;
	private String sch_name;
	private Date start_time;
	private Date end_time;
}
