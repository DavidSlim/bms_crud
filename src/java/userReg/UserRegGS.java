package userReg;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.ejb.Stateless;
import javax.inject.Named;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import org.apache.commons.lang3.text.WordUtils;
import org.hibernate.validator.constraints.Email;

@Named
@Stateless
public class UserRegGS implements java.io.Serializable {

    private Integer id;
    private String sirName;
    private String otherName;
    private String idNo;
    @Size(max = 11, min = 11, message = "Pin Should Have A Max & Min Of 11 Characters")
    @Pattern(regexp = "[aApP]{1}[0-9]{9}[a-zA-Z]{1}$", message = "Incorrect Pin Format Provided!")
    private String pinNo;
    private String hierachy;
    private String phoneNo;
    @Email(message = "Incorrect Email Pattern!")
    private String email;
    private String loginName;
    private String password;
    private String regDate;
    private String yrId;

    public UserRegGS() {
        this.sirName = "";
        this.otherName = "";
        this.idNo = "";
        this.pinNo = "";
        this.hierachy = "";
        this.phoneNo = "";
        this.email = "";
        this.loginName = "";
        this.password = "";
        this.yrId = "";
        this.regDate = "";
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSirName() {
        return sirName;
    }

    public void setSirName(String sirName) {
        this.sirName = WordUtils.capitalizeFully(sirName);
    }

    public String getOtherName() {
        return otherName;
    }

    public void setOtherName(String otherName) {
        this.otherName = WordUtils.capitalizeFully(otherName);
    }

    public String getIdNo() {
        return idNo;
    }

    public void setIdNo(String idNo) {
        this.idNo = idNo.toUpperCase();
    }

    public String getPinNo() {
        return pinNo;
    }

    public void setPinNo(String pinNo) {
        this.pinNo = pinNo.toUpperCase();
    }

    public String getHierachy() {
        return hierachy;
    }

    public void setHierachy(String hierachy) {
        this.hierachy = hierachy;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo.toUpperCase();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email.toLowerCase();
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        try {
            this.password = EncryptDecrypt.EncryptDecrypt.encrypt(password, "SlimSoft-23/10X1988");
        } catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException | UnsupportedEncodingException | IllegalBlockSizeException | BadPaddingException ex) {
            Logger.getLogger(UserRegGS.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }

    public String getRegDate() {
        return regDate;
    }

    public void setRegDate(String regDate) {
        this.regDate = regDate;
    }

    public String getYrId() {
        return yrId;
    }

    public void setYrId(String yrId) {
        this.yrId = yrId;
    }

}
