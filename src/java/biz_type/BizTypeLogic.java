package biz_type;

import HoldersLoginMsg.holder;
import SfUtil.SfUtil;
import java.io.Serializable;
import java.util.List;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import org.hibernate.Session;

@Named
@ViewScoped
public class BizTypeLogic implements Serializable {

    SfUtil sf = new SfUtil();

    String msg;
    private @Inject
    biztype_getset biztype_gs;
    private @Inject
    holder holder;

    public String message() {
        msg = biztype_gs.getBiz_type();
        return msg;
    }

    public void clean() {

        biztype_gs = new biztype_getset();
        // holder = new holder();

    }

    public List<biztype_getset> pop_data() {
        Session session = sf.SfUtil().openSession();
        session.beginTransaction();

        List<biztype_getset> list_hibernated = session.createCriteria(biztype_getset.class).list();

        if (list_hibernated.size() > 0) {
            clean();
            return list_hibernated;
        } else {
            clean();
            return null;
        }
    }

    public void data_save() {
        Session session = sf.SfUtil().openSession();
        session.beginTransaction();

        session.save(biztype_gs);
        session.getTransaction().commit();

        session.close();
        clean();
        holder.setMsg("Data Inserted");
    }

    public void data_update() {
        if (holder.getId_updt() > 0) {
            Session session = sf.SfUtil().openSession();

            session.beginTransaction();

            biztype_gs.setId(holder.getId_updt());
            session.update(biztype_gs);
            session.getTransaction().commit();
            session.close();
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
            biztype_gs.setId(id);
            session.delete(biztype_gs);
            session.getTransaction().commit();
            session.close();
            clean();
            holder.setMsg("Deleted");
        } else {
        }

    }

    public void IntoFields(int id) {
        for (biztype_getset of_in : pop_data()) {
            if (of_in.getId() == id) {
                biztype_gs = new biztype_getset();
                biztype_gs.setId(id);
                biztype_gs.setBiz_type(of_in.getBiz_type());
            } else {
            }
        }
        holder.setId_updt(id);
    }

    public BizTypeLogic() {
        biztype_gs = new biztype_getset();
    }

    public biztype_getset getBiztype_gs() {
        return biztype_gs;
    }

    public void setBiztype_gs(biztype_getset biztype_gs) {
        this.biztype_gs = biztype_gs;
    }

    public holder getHolder() {
        return holder;
    }

    public void setHolder(holder holder) {
        this.holder = holder;
    }
}
