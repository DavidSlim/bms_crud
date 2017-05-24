package biz_reg;

import javax.ejb.Stateless;
import javax.inject.Named;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import org.apache.commons.lang3.text.WordUtils;
import org.hibernate.validator.constraints.Email;

@Named
@Stateless
public class BizRegGS implements java.io.Serializable {

    private Integer id;
    private String bizId;
    private String idNo;
    @Size(max = 11, min = 11, message = "Pin Should Have A Min & Max Of 11 Characters")
    @Pattern(regexp = "[aApP]{1}[0-9]{9}[a-zA-Z]{1}$", message = "Wrong Pin Format Provided")
    private String pinPriv, pinBiz;
    private String nameLegal;
    private String nameDir1;
    private String nameDir2;
    private String nameTrade;
    private String bizType;
    private String bizNature;
    private String dateStart;
    private String dateVisit;
    private String blockNo;
    private String blockName;
    private String blockArea;
    private String bizFloorNo;
    private String bizOfficeNo;
    private String bizNeighbour;
    private String bizPobox;
    @Email(message = "Wrong Email Pattern Provided!")
    private String bizEmail;
    private String bizTelNo;
    private String rentalLlordTenant;
    private String rentalLlordName;
    private String rentalLlordNo;
    private Double rentalRentPaid;
    private String rentalUnitType;
    private Double rentalUnitsNo;
    private Double rentalUnitsRent;
    private Double empNo;
    private Double empPaye;
    private Double toCurr;
    private Double toPrev;
    private String itax;
    private String postedBy;
    private String toCurrComma, toPrevComma;
    private boolean boolLl, boolTt, boolBiztype;

    public BizRegGS() {
        this.bizId = "";
        this.idNo = "";
        this.pinPriv = "";
        this.nameLegal = "";
        this.nameDir1 = "";
        this.nameDir2 = "";
        this.nameTrade = "";
        this.pinBiz = "";
        this.bizType = "";
        this.bizNature = "";
        this.dateStart = "";
        this.dateVisit = "";
        this.blockNo = "";
        this.blockName = "";
        this.blockArea = "";
        this.bizFloorNo = "";
        this.bizOfficeNo = "";
        this.bizNeighbour = "";
        this.bizPobox = "";
        this.bizEmail = "";
        this.bizTelNo = "";
        this.rentalLlordTenant = "";
        this.rentalLlordName = "";
        this.rentalLlordNo = "";
        this.rentalRentPaid = 0.00;
        this.rentalUnitType = "";
        this.rentalUnitsNo = 0.00;
        this.rentalUnitsRent = 0.00;
        this.empNo = 0.00;
        this.empPaye = 0.00;
        this.toCurr = 0.00;
        this.toPrev = 0.00;
        this.toCurrComma = "";
        this.toPrevComma = "";
        this.itax = "";
        this.postedBy = "";
        this.boolBiztype = false;
        this.boolLl = false;
        this.boolTt = false;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBizId() {
        return this.bizId;
    }

    public void setBizId(String bizId) {
        this.bizId = bizId.toUpperCase();
    }

    public String getIdNo() {
        return this.idNo;
    }

    public void setIdNo(String idNo) {
        this.idNo = idNo;
    }

    public String getPinPriv() {
        return this.pinPriv;
    }

    public void setPinPriv(String pinPriv) {
        this.pinPriv = pinPriv.toUpperCase();
    }

    public String getNameLegal() {
        return this.nameLegal;
    }

    public void setNameLegal(String nameLegal) {
        this.nameLegal = WordUtils.capitalizeFully(nameLegal);
    }

    public String getNameDir1() {
        return this.nameDir1;
    }

    public void setNameDir1(String nameDir1) {
        this.nameDir1 = WordUtils.capitalizeFully(nameDir1);
    }

    public String getNameDir2() {
        return this.nameDir2;
    }

    public void setNameDir2(String nameDir2) {
        this.nameDir2 = WordUtils.capitalizeFully(nameDir2);
    }

    public String getNameTrade() {
        return this.nameTrade;
    }

    public void setNameTrade(String nameTrade) {
        this.nameTrade = WordUtils.capitalizeFully(nameTrade);
    }

    public String getPinBiz() {
        return this.pinBiz;
    }

    public void setPinBiz(String pinBiz) {
        this.pinBiz = pinBiz.toUpperCase();
    }

    public String getBizType() {
        return this.bizType;
    }

    public void setBizType(String bizType) {
        this.bizType = WordUtils.capitalizeFully(bizType);
    }

    public String getBizNature() {
        return this.bizNature;
    }

    public void setBizNature(String bizNature) {
        this.bizNature = WordUtils.capitalizeFully(bizNature);
    }

    public String getDateStart() {
        return this.dateStart;
    }

    public void setDateStart(String dateStart) {
        this.dateStart = dateStart;
    }

    public String getDateVisit() {
        return this.dateVisit;
    }

    public void setDateVisit(String dateVisit) {
        this.dateVisit = dateVisit;
    }

    public String getBlockNo() {
        return this.blockNo;
    }

    public void setBlockNo(String blockNo) {
        this.blockNo = blockNo.toUpperCase();
    }

    public String getBlockName() {
        return this.blockName;
    }

    public void setBlockName(String blockName) {
        this.blockName = WordUtils.capitalizeFully(blockName);
    }

    public String getBlockArea() {
        return this.blockArea;
    }

    public void setBlockArea(String blockArea) {
        this.blockArea = WordUtils.capitalizeFully(blockArea);
    }

    public String getBizFloorNo() {
        return this.bizFloorNo;
    }

    public void setBizFloorNo(String bizFloorNo) {
        this.bizFloorNo = WordUtils.capitalizeFully(bizFloorNo);
    }

    public String getBizOfficeNo() {
        return this.bizOfficeNo;
    }

    public void setBizOfficeNo(String bizOfficeNo) {
        this.bizOfficeNo = bizOfficeNo.toUpperCase();
    }

    public String getBizNeighbour() {
        return this.bizNeighbour;
    }

    public void setBizNeighbour(String bizNeighbour) {
        this.bizNeighbour = WordUtils.capitalizeFully(bizNeighbour);
    }

    public String getBizPobox() {
        return this.bizPobox;
    }

    public void setBizPobox(String bizPobox) {
        this.bizPobox = bizPobox.toUpperCase();
    }

    public String getBizEmail() {
        return this.bizEmail;
    }

    public void setBizEmail(String bizEmail) {
        this.bizEmail = bizEmail.toLowerCase();
    }

    public String getBizTelNo() {
        return this.bizTelNo;
    }

    public void setBizTelNo(String bizTelNo) {
        this.bizTelNo = bizTelNo.toUpperCase();
    }

    public String getRentalLlordTenant() {
        return this.rentalLlordTenant;
    }

    public void setRentalLlordTenant(String rentalLlordTenant) {
        this.rentalLlordTenant = WordUtils.capitalizeFully(rentalLlordTenant);
    }

    public String getRentalLlordName() {
        return this.rentalLlordName;
    }

    public void setRentalLlordName(String rentalLlordName) {
        this.rentalLlordName = WordUtils.capitalizeFully(rentalLlordName);
    }

    public String getRentalLlordNo() {
        return this.rentalLlordNo;
    }

    public void setRentalLlordNo(String rentalLlordNo) {
        this.rentalLlordNo = rentalLlordNo.toUpperCase();
    }

    public Double getRentalRentPaid() {
        return this.rentalRentPaid;
    }

    public void setRentalRentPaid(Double rentalRentPaid) {
        this.rentalRentPaid = rentalRentPaid;
    }

    public String getRentalUnitType() {
        return this.rentalUnitType;
    }

    public void setRentalUnitType(String rentalUnitType) {
        this.rentalUnitType = WordUtils.capitalizeFully(rentalUnitType);
    }

    public Double getRentalUnitsNo() {
        return this.rentalUnitsNo;
    }

    public void setRentalUnitsNo(Double rentalUnitsNo) {
        this.rentalUnitsNo = rentalUnitsNo;
    }

    public Double getRentalUnitsRent() {
        return this.rentalUnitsRent;
    }

    public void setRentalUnitsRent(Double rentalUnitsRent) {
        this.rentalUnitsRent = rentalUnitsRent;
    }

    public Double getEmpNo() {
        return this.empNo;
    }

    public void setEmpNo(Double empNo) {
        this.empNo = empNo;
    }

    public Double getEmpPaye() {
        return this.empPaye;
    }

    public void setEmpPaye(Double empPaye) {
        this.empPaye = empPaye;
    }

    public Double getToCurr() {
        return this.toCurr;
    }

    public void setToCurr(Double toCurr) {
        this.toCurr = toCurr;
    }

    public Double getToPrev() {
        return this.toPrev;
    }

    public void setToPrev(Double toPrev) {
        this.toPrev = toPrev;
    }

    public String getToCurrComma() {
        return "KSh " + String.format("%,.2f", toCurr);
    }

    public void setToCurrComma(String toCurrComma) {
        this.toCurrComma = toCurrComma;
    }

    public String getToPrevComma() {
        return "KSh " + String.format("%,.2f", toPrev);
    }

    public void setToPrevComma(String toPrevComma) {
        this.toPrevComma = toPrevComma;
    }

    public String getItax() {
        return this.itax;
    }

    public void setItax(String itax) {
        this.itax = itax;
    }

    public String getPostedBy() {
        return this.postedBy;
    }

    public void setPostedBy(String postedBy) {
        this.postedBy = postedBy;
    }

    public boolean isBoolLl() {
        return boolLl;
    }

    public void setBoolLl(boolean boolLl) {
        this.boolLl = boolLl;
    }

    public boolean isBoolTt() {
        return boolTt;
    }

    public void setBoolTt(boolean boolTt) {
        this.boolTt = boolTt;
    }

    public boolean isBoolBiztype() {
        return boolBiztype;
    }

    public void setBoolBiztype(boolean boolBiztype) {
        this.boolBiztype = boolBiztype;
    }

}
