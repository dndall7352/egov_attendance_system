package egovframework.atoz.main.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CompanyVo {
	private int com_number;
	private String com_name;
	private String com_ci;
}
