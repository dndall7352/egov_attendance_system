package egovframework.atoz.main.model;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CompanyDto {
	private int com_number;
	private String com_name;
	private byte[] com_ci;
	
	public CompanyDto(CompanyVo vo) throws IOException{
		final String DIR = "C:/resources/company/";
		this.com_number = vo.getCom_number();
		this.com_name = vo.getCom_name();
				
		byte[] imageBytes = null;
		if(vo.getCom_ci() != null) {
			vo.setCom_ci(DIR+vo.getCom_ci());
			
			File imageFile = new File(vo.getCom_ci());
			imageBytes = Files.readAllBytes(imageFile.toPath());
		}
		this.com_ci = imageBytes;
	}
}
