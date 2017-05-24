package ResetterInitializer;

import HoldersLoginMsg.*;
import HoldersLoginMsg.TrueFalse;
import biz_reg.BizRegGS;
import biz_type.biztype_getset;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import userReg.UserRegGS;

@Named
@ViewScoped
public class WashWashMe implements java.io.Serializable {

    private @Inject
    BizRegGS biz_reg;
    private @Inject
    biztype_getset biz_type;
    private @Inject
    UserRegGS user_reg;
    private @Inject
    LoginGS login;
    private @Inject
    TrueFalse true_f;
    private @Inject
    holder hold;

    public void init() {
        hold = null;
        biz_reg = null;
        biz_type = null;
        user_reg = null;
        true_f = null;
        login = null;
    }

    public WashWashMe() {

    }

    public BizRegGS getBiz_reg() {
        return biz_reg;
    }

    public void setBiz_reg(BizRegGS biz_reg) {
        this.biz_reg = biz_reg;
    }

    public biztype_getset getBiz_type() {
        return biz_type;
    }

    public void setBiz_type(biztype_getset biz_type) {
        this.biz_type = biz_type;
    }

    public UserRegGS getUser_reg() {
        return user_reg;
    }

    public void setUser_reg(UserRegGS user_reg) {
        this.user_reg = user_reg;
    }

    public LoginGS getLogin() {
        return login;
    }

    public void setLogin(LoginGS login) {
        this.login = login;
    }

    public TrueFalse getTrue_f() {
        return true_f;
    }

    public void setTrue_f(TrueFalse true_f) {
        this.true_f = true_f;
    }

    public holder getHold() {
        return hold;
    }

    public void setHold(holder hold) {
        this.hold = hold;
    }
}
