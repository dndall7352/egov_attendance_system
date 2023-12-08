package egovframework.atoz.mobile.model;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDto {
	private String emp_number;
	private String name;
	private String dep_name;
	private String phone;
	private String rank_name;
	private byte[] photo;
	
	public EmployeeDto(UserInfoDto info) throws IOException{
		final String DIR = "C:/resources/";
		this.emp_number = info.getEmp_number();
		this.name = info.getName();
		this.dep_name = info.getDep_name();
		this.phone = info.getPhone();
		this.rank_name = info.getRank_name();
		
		byte[] imageBytes = null;
		if(info.getPhoto() != null) {
			info.setPhoto(DIR+info.getPhoto());
			File imageFile = new File(info.getPhoto());
			imageBytes = Files.readAllBytes(imageFile.toPath());
		}
		this.photo = imageBytes;
	}
}
