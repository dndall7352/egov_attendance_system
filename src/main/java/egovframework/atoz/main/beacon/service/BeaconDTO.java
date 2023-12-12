package egovframework.atoz.main.beacon.service;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BeaconDTO extends BeaconDefaultVO{
	private int beacon_number;
	private String uuid;
	private String com_name;
	private int com_number;
	private int major;
	private int minor;
	private int use;
	private String note;
}
