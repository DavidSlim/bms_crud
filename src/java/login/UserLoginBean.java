package login;

import ConditionalNavs.NavConditions;
import HoldersLoginMsg.LoginGS;
import SfUtil.SfUtil;
import HoldersLoginMsg.TrueFalse;
import java.io.Serializable;
import java.util.*;
import java.util.stream.Collectors;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.*;
import org.hibernate.*;
import userReg.UserRegGS;

@Named
@SessionScoped
public class UserLoginBean implements Serializable {

    private final SfUtil sf = new SfUtil();

    String msg;
    private @Inject
    UserRegGS userReg_gs;
    private @Inject
    LoginGS login_cred;
    private @Inject
    ConditionalNavs.NavConditions nav_;
    private @Inject
    TrueFalse true_false;

    public String message() {
        return msg;
    }

    @PostConstruct
    public void clean() {
        userReg_gs = new UserRegGS();
        login_cred = new LoginGS();
        true_false = new TrueFalse();
    }

    public String log_In() {
        Session session = sf.SfUtil().openSession();
        session.beginTransaction();

        Criteria crit = session.createCriteria(UserRegGS.class);

        List<UserRegGS> list_ = crit.list();

        List<UserRegGS> list_crd = list_.stream().filter((d) -> (d.getLoginName().equalsIgnoreCase(userReg_gs.getLoginName())
                && d.getPassword().equals(EncryptDecrypt.EncryptDecrypt.encrypt(userReg_gs.getPassword(), "SlimSoft-23/10X1988")))
        ).collect(Collectors.toList());

        list_crd.stream().forEach(d -> {
            login_cred.setDepartment(d.getHierachy());
            if (null == login_cred.getDepartment()) {
            } else {
                switch (login_cred.getDepartment()) {
                    case "Supervisor":
                        true_false.setDisabledColDel(false);
                        true_false.setDisabledTF(true);
                        true_false.setDisabledListItem(true);
                        true_false.setDisabledSave(true);
                        true_false.setDisabledEdit(true);
                        break;
                    case "Return Processing":
                        true_false.setDisabledColDel(true);
                        true_false.setDisabledTF(true);
                        break;
                    case "Administrator":
                        true_false.setDisabledColDel(true);
                        true_false.setDisabledTF(false);
                        true_false.setDisabledListItem(false);
                        true_false.setDisabledSave(false);
                        true_false.setDisabledEdit(false);
                        break;
                    default:
                        break;
                }
            }
        });

        if (list_crd.size() == 1) {
            login_cred.setLogName(userReg_gs.getLoginName());
            login_cred.setDepartment(userReg_gs.getHierachy());
            login_cred.setLoggedIn(true);
            /*HttpSession http_sess = SessionUtils.getSession();
            http_sess.setAttribute("login_name", userReg_gs.getLoginName());*/
            return nav_.bizRegStarter();
        } else {
            true_false = new TrueFalse();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,
                    "Sorry Incorrect Login Credentials Provided!!.. If you think this is an error please consult the administrator", null));
            return nav_.login_form();
        }

    }

    public String log_Out() {
        clean();
        // FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        login_cred.setLoggedIn(false);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
                "Logout success!", null));
        return nav_.layout_temp();
    }

    public UserLoginBean() {
        userReg_gs = new UserRegGS();
        login_cred = new LoginGS();
        nav_ = new NavConditions();
        true_false = new TrueFalse();
    }

    public UserRegGS getUserReg_gs() {
        return userReg_gs;
    }

    public void setUserReg_gs(UserRegGS userReg_gs) {
        this.userReg_gs = userReg_gs;
    }

    public LoginGS getLogin_cred() {
        return login_cred;
    }

    public void setLogin_cred(LoginGS login_cred) {
        this.login_cred = login_cred;
    }

    public NavConditions getNav_() {
        return nav_;
    }

    public void setNav_(NavConditions nav_) {
        this.nav_ = nav_;
    }

    public TrueFalse getTrue_false() {
        return true_false;
    }

    public void setTrue_false(TrueFalse true_false) {
        this.true_false = true_false;
    }

}
