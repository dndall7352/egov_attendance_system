package egovframework.atoz.main.authority.service;

/**
 * @Class Name : AuthorityVO.java
 * @Description : Authority VO class
 * @Modification Information
 *
 * @author kke
 * @since 23-12-04
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class AuthorityVO extends AuthorityDefaultVO{
    private static final long serialVersionUID = 1L;
    
    /** AUT_NUMBER */
    private java.math.BigDecimal autNumber;
    
    /** PAGE_CODE */
    private java.math.BigDecimal pageCode;
    
    public java.math.BigDecimal getAutNumber() {
        return this.autNumber;
    }
    
    public void setAutNumber(java.math.BigDecimal autNumber) {
        this.autNumber = autNumber;
    }
    
    public java.math.BigDecimal getPageCode() {
        return this.pageCode;
    }
    
    public void setPageCode(java.math.BigDecimal pageCode) {
        this.pageCode = pageCode;
    }
    
}
