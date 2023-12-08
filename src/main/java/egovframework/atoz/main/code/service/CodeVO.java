package egovframework.atoz.main.code.service;

/**
 * @Class Name : CodeVO.java
 * @Description : Code VO class
 * @Modification Information
 *
 * @author kke
 * @since 23-12-04
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class CodeVO extends CodeDefaultVO{
    private static final long serialVersionUID = 1L;
    
    /** CODE */
    private java.math.BigDecimal code;
    
    /** CODE_GROUP */
    private java.math.BigDecimal codeGroup;
    
    /** P_CODE */
    private java.math.BigDecimal PCode;
    
    /** CODE_NAME */
    private java.lang.String codeName;
    
    /** DETH */
    private java.math.BigDecimal deth;
    
    public java.math.BigDecimal getCode() {
        return this.code;
    }
    
    public void setCode(java.math.BigDecimal code) {
        this.code = code;
    }
    
    public java.math.BigDecimal getCodeGroup() {
        return this.codeGroup;
    }
    
    public void setCodeGroup(java.math.BigDecimal codeGroup) {
        this.codeGroup = codeGroup;
    }
    
    public java.math.BigDecimal getPCode() {
        return this.PCode;
    }
    
    public void setPCode(java.math.BigDecimal PCode) {
        this.PCode = PCode;
    }
    
    public java.lang.String getCodeName() {
        return this.codeName;
    }
    
    public void setCodeName(java.lang.String codeName) {
        this.codeName = codeName;
    }
    
    public java.math.BigDecimal getDeth() {
        return this.deth;
    }
    
    public void setDeth(java.math.BigDecimal deth) {
        this.deth = deth;
    }
    
}
