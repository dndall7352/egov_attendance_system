package egovframework.atoz.main.companyInfo.service;

import java.math.BigDecimal;

import org.springframework.web.multipart.MultipartFile;

/**
 * @Class Name : CompanyInfoVO.java
 * @Description : CompanyInfo VO class
 * @Modification Information
 *
 * @author johj
 * @since 2023-12-07
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class CompanyInfoVO extends CompanyInfoDefaultVO{
    private static final long serialVersionUID = 1L;
    
    /** COM_NUMBER */
    private BigDecimal comNumber;
    
    /** NUM */
    private BigDecimal num;
    
    /** COM_NAME */
    private String comName;
    
    /** COM_CI */
    private String comCi;
    
    /** COM_EMAIL */
    private String comEmail;
    
    /** CEO_NAME */
    private String ceoName;
    
    /** ZIP_CODE */
    private BigDecimal zipCode;
    
    /** ADDRESS1 */
    private String address1;
    
    /** ADDRESS2 */
    private String address2;
    
    /** NOTE */
    private String note;
    
    /** ZIP_CODE */
    private BigDecimal zip_code;
    
    /** ADDRESS1 */
    private String address_1;
    
    /** ADDRESS2 */
    private String address_2;
    
    private int use;
    
    private String ceoPhone;
    
    private String uuid;
    
    private String name;
    
    private String phone;
    
    private String password;
    
    private String empNumber;
    
    private String id;
    
    // 파일 업로드 관련 변수
 	private MultipartFile uploadFile;
 	private String fileName;
 	
	public BigDecimal getComNumber() {
		return comNumber;
	}
	public void setComNumber(BigDecimal comNumber) {
		this.comNumber = comNumber;
	}
	public BigDecimal getNum() {
		return num;
	}
	public void setNum(BigDecimal num) {
		this.num = num;
	}
	public String getComName() {
		return comName;
	}
	public void setComName(String comName) {
		this.comName = comName;
	}
	public String getComCi() {
		return comCi;
	}
	public void setComCi(String comCi) {
		this.comCi = comCi;
	}
	public String getComEmail() {
		return comEmail;
	}
	public void setComEmail(String comEmail) {
		this.comEmail = comEmail;
	}
	public String getCeoName() {
		return ceoName;
	}
	public void setCeoName(String ceoName) {
		this.ceoName = ceoName;
	}
	public BigDecimal getZipCode() {
		return zipCode;
	}
	public void setZipCode(BigDecimal zipCode) {
		this.zipCode = zipCode;
	}
	public String getAddress1() {
		return address1;
	}
	public void setAddress1(String address1) {
		this.address1 = address1;
	}
	public String getAddress2() {
		return address2;
	}
	public void setAddress2(String address2) {
		this.address2 = address2;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public MultipartFile getUploadFile() {
		return uploadFile;
	}
	public void setUploadFile(MultipartFile uploadFile) {
		this.uploadFile = uploadFile;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public int getUse() {
		return use;
	}
	public void setUse(int use) {
		this.use = use;
	}
	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmpNumber() {
		return empNumber;
	}
	public void setEmpNumber(String empNumber) {
		this.empNumber = empNumber;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCeoPhone() {
		return ceoPhone;
	}
	public void setCeoPhone(String ceoPhone) {
		this.ceoPhone = ceoPhone;
	}
	public BigDecimal getZip_code() {
		return zip_code;
	}
	public void setZip_code(BigDecimal zip_code) {
		this.zip_code = zip_code;
	}
	public String getAddress_1() {
		return address_1;
	}
	public void setAddress_1(String address_1) {
		this.address_1 = address_1;
	}
	public String getAddress_2() {
		return address_2;
	}
	public void setAddress_2(String address_2) {
		this.address_2 = address_2;
	}
}
