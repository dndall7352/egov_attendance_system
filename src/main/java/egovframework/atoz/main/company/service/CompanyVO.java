package egovframework.atoz.main.company.service;

/**
 * @Class Name : CompanyVO.java
 * @Description : Company VO class
 * @Modification Information
 *
 * @author kke
 * @since 23-12-04
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class CompanyVO extends CompanyDefaultVO{
    private static final long serialVersionUID = 1L;
    
    /** COM_NUMBER */
    private java.math.BigDecimal comNumber;
    
    /** COM_NAME */
    private java.lang.String comName;
    
    /** COM_CI */
    private java.lang.String comCi;
    
    public java.math.BigDecimal getComNumber() {
        return this.comNumber;
    }
    
    public void setComNumber(java.math.BigDecimal comNumber) {
        this.comNumber = comNumber;
    }
    
    public java.lang.String getComName() {
        return this.comName;
    }
    
    public void setComName(java.lang.String comName) {
        this.comName = comName;
    }
    
    public java.lang.String getComCi() {
        return this.comCi;
    }
    
    public void setComCi(java.lang.String comCi) {
        this.comCi = comCi;
    }
    
}
