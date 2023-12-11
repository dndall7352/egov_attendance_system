package egovframework.atoz.main.notic.service;
/**
 * @Class Name : NoticVO.java
 * @Description : Notic VO class
 * @Modification Information
 *
 * @author kke
 * @since 2023-12-07
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class NoticVO extends NoticDefaultVO{
    private static final long serialVersionUID = 1L;
    
    /** NUM */
    private java.math.BigDecimal num;
    
    /** EMP_NUMBER */
    private java.lang.String empNumber;
    
    /** COM_NUMBER */
    private java.math.BigDecimal comNumber;
    
    /** DEP_NUMBER */
    private java.math.BigDecimal depNumber;
    
    /** TITLE */
    private java.lang.String title;
    
    /** CONTENT */
    private java.lang.String content;
    
    /** DATES */
    private java.sql.Date dates;
    
    public java.math.BigDecimal getNum() {
        return this.num;
    }
    
    public void setNum(java.math.BigDecimal num) {
        this.num = num;
    }
    
    public java.lang.String getEmpNumber() {
        return this.empNumber;
    }
    
    public void setEmpNumber(java.lang.String empNumber) {
        this.empNumber = empNumber;
    }
    
    public java.math.BigDecimal getComNumber() {
        return this.comNumber;
    }
    
    public void setComNumber(java.math.BigDecimal comNumber) {
        this.comNumber = comNumber;
    }
    
    public java.math.BigDecimal getDepNumber() {
        return this.depNumber;
    }
    
    public void setDepNumber(java.math.BigDecimal depNumber) {
        this.depNumber = depNumber;
    }
    
    public java.lang.String getTitle() {
        return this.title;
    }
    
    public void setTitle(java.lang.String title) {
        this.title = title;
    }
    
    public java.lang.String getContent() {
        return this.content;
    }
    
    public void setContent(java.lang.String content) {
        this.content = content;
    }
    
    public java.sql.Date getDates() {
        return this.dates;
    }
    
    public void setDates(java.sql.Date dates) {
        this.dates = dates;
    }
    
}
