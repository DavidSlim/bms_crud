package biz_reg;

import HoldersLoginMsg.LoginGS;
import HoldersLoginMsg.holder;
import SfUtil.SfUtil;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.inject.Named;
import org.hibernate.Criteria;
import org.hibernate.Session;

@Named
@Stateless
public class BizRegPop implements Serializable {

    private int count;
    private @Inject
    holder holder;
    private @Inject
    LoginGS login_searcher;

    public BizRegPop() {
        login_searcher = new HoldersLoginMsg.LoginGS();
        holder = new HoldersLoginMsg.holder();
    }

    private final SfUtil sf = new SfUtil();

    public List<BizRegGS> getList_() {

        Session session = sf.SfUtil().openSession();

        session.beginTransaction();
        Criteria crit = session.createCriteria(BizRegGS.class);
        List<BizRegGS> lst_all = crit.list();
        return lst_all;
    }

    public List<BizRegGS> data_pop(int page, int pageLast) {

        Session session = sf.SfUtil().openSession();
        session.beginTransaction();
        Criteria crit = session.createCriteria(BizRegGS.class);

        if (!login_searcher.getSearcher().isEmpty()) {
            List<BizRegGS> list_ = crit.list();
            String to_search = login_searcher.getSearcher().toLowerCase();
            List<BizRegGS> list_search = list_.stream().filter(t -> t.getNameTrade().toLowerCase().contains(to_search)
                    || t.getNameDir1().toLowerCase().contains(to_search)
                    || t.getNameDir2().toLowerCase().contains(to_search)
                    || t.getIdNo().toLowerCase().contains(to_search)
                    || t.getBizId().toLowerCase().contains(to_search)
                    || t.getPinPriv().toLowerCase().contains(to_search)
                    || t.getPinBiz().toLowerCase().contains(to_search)
                    || t.getNameLegal().toLowerCase().contains(to_search)
                    || t.getNameTrade().toLowerCase().contains(to_search)
                    || t.getNameDir1().toLowerCase().contains(to_search)
                    || t.getNameDir2().toLowerCase().contains(to_search)
                    || t.getBizTelNo().toLowerCase().contains(to_search)
                    || t.getRentalLlordName().toLowerCase().contains(to_search)
            ).collect(Collectors.toList());
            setCount(list_search.size());
            holder.setMsg(getCount() + " Records Are All The Matching Search Items In DataBase");
            return CRUDHelper.CRUDHelper.safeSubList(list_search, page, pageLast);
        } else {
            List<BizRegGS> list_ = crit.list();
            if (list_.size() > 0) {
                setCount(list_.size());
                holder.setMsg(getCount() + " Records Are All The Records In The DataBase");
                return CRUDHelper.CRUDHelper.safeSubList(list_, page, pageLast);
            } else {
                return null;
            }
        }
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

}
