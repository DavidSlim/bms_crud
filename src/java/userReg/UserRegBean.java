package userReg;

import ConditionalNavs.NavConditions;
import HoldersLoginMsg.LoginGS;
import HoldersLoginMsg.TrueFalse;
import HoldersLoginMsg.holder;
import SfUtil.SfUtil;
import java.io.Serializable;
import java.util.*;
import java.util.stream.Collectors;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.*;
import org.hibernate.Criteria;
import org.hibernate.Session;

@Named
@ViewScoped
public class UserRegBean implements Serializable {

    private final SfUtil sf = new SfUtil();
    DateTime.date_time dt = new DateTime.date_time();
    String msg, yrId, regDate;
    private UserRegGS userReg_gs;
    private @Inject
    holder holder;
    private @Inject
    LoginGS login_searcher;
    private @Inject
    ConditionalNavs.NavConditions nav_;
    private @Inject
    TrueFalse true_false;

    public String message() {
        msg = userReg_gs.getSirName() + " " + userReg_gs.getOtherName() + " : " + userReg_gs.getIdNo() + " : "
                + userReg_gs.getPinNo() + userReg_gs.getEmail() + " : " + " : " + userReg_gs.getHierachy() + " : " + userReg_gs.getPhoneNo();
        return msg;
    }

    public void clean() {
        userReg_gs = new UserRegGS();
        String[] xx = {yrId, regDate};
        for (String string : xx) {
            string = "";
        }
    }

    public List<UserRegGS> data_pop() {

        Session session = sf.SfUtil().openSession();
        session.beginTransaction();

        Criteria crit = session.createCriteria(UserRegGS.class);
        List<UserRegGS> list_ = crit.list();
        if (!login_searcher.getSearcher().isEmpty()) {
            String to_search = login_searcher.getSearcher().toLowerCase();
            List<UserRegGS> list_searched = list_.stream().filter(t -> t.getEmail().toLowerCase().contains(to_search)
                    || t.getIdNo().toLowerCase().contains(to_search)
                    || t.getLoginName().toLowerCase().contains(to_search)
                    || t.getOtherName().toLowerCase().contains(to_search)
                    || t.getPhoneNo().toLowerCase().contains(to_search)
                    || t.getPinNo().toLowerCase().contains(to_search)
                    || t.getSirName().toLowerCase().contains(to_search)
            ).collect(Collectors.toList());
            return list_searched;
        } else {
            clean();
            if (list_.size() > 0) {
                return list_;
            } else {
                return null;
            }
        }
    }

    public void data_save() {
        Session session = sf.SfUtil().openSession();
        session.beginTransaction();

        Criteria crit = session.createCriteria(UserRegGS.class);
        List<UserRegGS> list_ = crit.list();
        List<UserRegGS> list_db = list_.stream().filter(t -> t.getIdNo().toLowerCase().contains(userReg_gs.getIdNo().toLowerCase())
                || t.getLoginName().toLowerCase().contains(userReg_gs.getLoginName().toLowerCase())
                || t.getPinNo().toLowerCase().contains(userReg_gs.getPinNo().toLowerCase())
        ).collect(Collectors.toList());
        if (!list_db.isEmpty()) {
            holder.setMsg("Sorry Cant Be Saved Because Record Exists");
        } else {
            userReg_gs.setYrId(dt.year());
            userReg_gs.setRegDate(dt.timePrint());

            userReg_gs.setPassword(userReg_gs.getIdNo());
            userReg_gs.setLoginName("T" + userReg_gs.getIdNo() + "/" + userReg_gs.getYrId());
            session.save(userReg_gs);
            clean();
            holder.setMsg("Data Inserted");

        }
    }

    public void data_update() {
        userReg_gs.setYrId(userReg_gs.getYrId());
        if (holder.getId_updt() > 0) {
            Session session = sf.SfUtil().openSession();
            session.beginTransaction();
            userReg_gs.setId(holder.getId_updt());
            userReg_gs.setPassword(userReg_gs.getIdNo());
            userReg_gs.setYrId(this.yrId);
            userReg_gs.setLoginName("T" + userReg_gs.getIdNo() + "/" + this.yrId);
            userReg_gs.setRegDate(this.regDate);

            session.update(userReg_gs);

            clean();
            holder.setMsg("Updated");
        } else {
            holder.setMsg("Sorry Cant Update Null Values... Select Biz Type To Be Updated");
        }
    }

    public void data_del(int id) {
        if (id == 0) {
        } else if (id != 0) {
            Session session = sf.SfUtil().openSession();
            session.beginTransaction();
            userReg_gs.setId(id);
            session.delete(userReg_gs);
            session.getTransaction().commit();
            session.close();
            clean();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Record Deleted"));
        } else {
        }
    }

    public void IntoFields(int id) {

        data_pop().stream().forEach((UserRegGS of_in) -> {
            if (of_in.getId() == id) {

                userReg_gs = new UserRegGS();
                holder.setId_updt(id);

                userReg_gs.setId(id);
                userReg_gs.setIdNo(of_in.getIdNo());
                userReg_gs.setPinNo(of_in.getPinNo());
                userReg_gs.setSirName(of_in.getSirName());
                userReg_gs.setOtherName(of_in.getOtherName());
                userReg_gs.setHierachy(of_in.getHierachy());
                userReg_gs.setEmail(of_in.getEmail());
                userReg_gs.setPhoneNo(of_in.getPhoneNo());
                userReg_gs.setLoginName(of_in.getLoginName());
                userReg_gs.setPassword(of_in.getPassword());
                userReg_gs.setYrId(of_in.getYrId());
                userReg_gs.setRegDate(of_in.getRegDate());

                this.yrId = userReg_gs.getYrId();
                this.regDate = userReg_gs.getRegDate();
            } else {
            }
        });

    }

    public UserRegBean() {
        userReg_gs = new UserRegGS();
        holder = new holder();
        nav_ = new NavConditions();
        true_false = new TrueFalse();
        login_searcher = new LoginGS();
    }

   
    public holder getHolder() {
        return holder;
    }

    public void setHolder(holder holder) {
        this.holder = holder;
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

    public UserRegGS getUserReg_gs() {
        return userReg_gs;
    }

    public void setUserReg_gs(UserRegGS userReg_gs) {
        this.userReg_gs = userReg_gs;
    }

}
