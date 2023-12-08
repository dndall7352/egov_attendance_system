package egovframework.atoz.main.department.service;

/**
 * @Class Name : DepartmentVO.java
 * @Description : Department VO class
 * @Modification Information
 *
 * @author kke
 * @since 23-12-04
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class DepartmentVO extends DepartmentDefaultVO{
    private static final long serialVersionUID = 1L;
    
    /** DEP_NUMBER */
    private java.math.BigDecimal depNumber;
    
    /** COM_NAME */
    private String comName;
    
    /** DEP_NAME */
    private java.lang.String depName;
    
    public java.math.BigDecimal getDepNumber() {
        return this.depNumber;
    }
    
    public void setDepNumber(java.math.BigDecimal depNumber) {
        this.depNumber = depNumber;
    }
    
    public String getComName() {
        return this.comName;
    }
    
    public void setComName(String comName) {
        this.comName = comName;
    }
    
    public java.lang.String getDepName() {
        return this.depName;
    }
    
    public void setDepName(java.lang.String depName) {
        this.depName = depName;
    }
    
}
