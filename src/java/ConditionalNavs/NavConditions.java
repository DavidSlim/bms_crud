package ConditionalNavs;

import java.io.Serializable;
import javax.ejb.Stateless;
import javax.inject.Named;

@Named("nav_")
@Stateless
public class NavConditions implements Serializable {

    public String bizRegStarter() {/*?faces-redirect=true*/
        return "/BizRegOthers/BizRegStart.xhtml";
    }

    public String bizReg() {
        return "/BizReg/BizReg.xhtml";
    }

    public String bizReg1Company() {
        return "/BizReg/BizReg1Company.xhtml";
    }

    public String bizReg2Turnover() {
        return "/BizReg/BizReg2Turnover.xhtml";
    }

    public String bizReg3Rental() {
        return "/BizReg/BizReg3Rental.xhtml";
    }

    public String bizReg4Paye() {
        return "/BizReg/BizReg4Paye.xhtml";
    }

    public String bizReg5Contacts() {
        return "/BizReg/BizReg5Contacts.xhtml";
    }

    public String bizReg6Final() {
        return "/BizReg/BizReg6Final.xhtml";
    }

    public String bizRegPop() {
        return "/BizRegOthers/BizRegPop.xhtml";
    }

    public String bizRegPopRedirect() {
        return "/BizRegOthers/BizRegPop.xhtml?faces-redirect=true";
    }

    public String bizType() {
        return "/BizType/biz_type_reg.xhtml";
    }

    public String hierachy() {
        return "/Hierachy/Hierachy.xhtml";
    }

    public String usersReg() {
        return "/UsersReg/user_reg.xhtml";
    }

    public String login_form() {
        return "/Login/login_form.xhtml";
    }

    public String login_form_redrkt() {
        return "/Login/login_form.xhtml?faces-redirect=true";
    }

    public String layout_temp() {
        return "/template/web_view/layout.xhtml";
    }
}
