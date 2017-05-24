package biz_reg;

import ConditionalNavs.NavConditions;
import DateTime.date_time;
import HoldersLoginMsg.holder;
import ListsAndMaps.AutOCodes;
import Paginator.PaginationHelper;
import SfUtil.SfUtil;
import java.util.*;
import java.util.stream.Collectors;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.*;
import org.hibernate.*;

@Named
@SessionScoped
public class BizRegBean implements java.io.Serializable {

    private final SfUtil sf = new SfUtil();
    private @Inject
    BizRegGS bizreg_gs;
    private @Inject
    HoldersLoginMsg.LoginGS login_cred;
    private @Inject
    holder holder;
    private @Inject
    BizRegPop biz_reg_pop;
    private ListsAndMaps.AutOCodes ac;
    private final NavConditions nav_;

    private final date_time dt = new date_time();

    public BizRegBean() {
        biz_reg_pop = new BizRegPop();
        bizreg_gs = new BizRegGS();
        login_cred = new HoldersLoginMsg.LoginGS();
        holder = new HoldersLoginMsg.holder();
        nav_ = new NavConditions();
    }

    public void clean() {
        bizreg_gs = new BizRegGS();
    }

    public String message() {
        String msg = bizreg_gs.getBizId() + " " + bizreg_gs.getIdNo() + " : " + bizreg_gs.getPinPriv() + " : "
                + bizreg_gs.getNameLegal() + " : " + bizreg_gs.getNameTrade() + " : " + bizreg_gs.getPinBiz() + " : "
                + bizreg_gs.getBizTelNo() + " " + dt.date();
        return msg;
    }

    public void enable_biztype() {
        if ("SoleProprietor".equals(bizreg_gs.getBizType())) {
            bizreg_gs.setBoolBiztype(true);
            bizreg_gs.setPinBiz(bizreg_gs.getPinPriv());
            bizreg_gs.setNameDir1("N/A");
            bizreg_gs.setNameDir2("N/A");
        } else if (!"SoleProprietor".equals(bizreg_gs.getBizType())) {
            bizreg_gs.setBoolBiztype(false);
        } else {
        }
    }

    public void enable_lltt() {
        if ("Tenant".equals(bizreg_gs.getRentalLlordTenant())) {

            bizreg_gs.setBoolLl(true);
            bizreg_gs.setBoolTt(false);

            bizreg_gs.setRentalUnitsRent(0.00);
            bizreg_gs.setRentalUnitsNo(0.00);

        } else if (!"Tenant".equals(bizreg_gs.getRentalLlordTenant())) {

            bizreg_gs.setBoolLl(false);
            bizreg_gs.setBoolTt(true);

            bizreg_gs.setRentalLlordName("N/A");
            bizreg_gs.setRentalLlordNo("N/A");
            bizreg_gs.setRentalRentPaid(0.00);

        } else {
        }

    }

    public void data_save() {
        Session session = sf.SfUtil().openSession();
        session.beginTransaction();

        Criteria crit = session.createCriteria(BizRegGS.class);
        List<BizRegGS> lst_db = crit.list();
        List<BizRegGS> lst_chk_db = lst_db.stream().filter(t -> t.getIdNo().equals(bizreg_gs.getIdNo())
                && t.getPinPriv().equals(bizreg_gs.getPinPriv())
                && t.getPinBiz().equals(bizreg_gs.getPinBiz())
                && t.getNameTrade().equals(bizreg_gs.getNameTrade())
        ).collect(Collectors.toList());

        if (!lst_chk_db.isEmpty()) {
            holder.setMsg("Sorry " + bizreg_gs.getIdNo() + " " + bizreg_gs.getPinPriv() + " " + bizreg_gs.getPinBiz() + " " + bizreg_gs.getNameTrade() + " Cant Be Saved Because Record Exists");
            session.close();
        } else {
            ac = new AutOCodes();
            bizreg_gs.setBizId(ac.biz_code());
            bizreg_gs.setPostedBy(login_cred.getLogName());
            bizreg_gs.setDateStart(dt.date() + " " + dt.time());
            bizreg_gs.setDateVisit(dt.date() + " " + dt.time());

            session.save(bizreg_gs);
            session.getTransaction().commit();

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Data Inserted"));
            clean();
        }
    }

    public void data_update() {
        if (holder.getId_updt() > 0) {

            bizreg_gs.setId(holder.getId_updt());
            bizreg_gs.setDateVisit(dt.date() + " : " + dt.time());
            Session session = sf.SfUtil().openSession();
            session.beginTransaction();

            session.update(bizreg_gs);
            session.getTransaction().commit();
            session.close();

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Record Updated"));
            clean();

        } else {
            FacesContext.getCurrentInstance()
                    .addMessage(null, new FacesMessage("Sorry Cant Update Null Values... Select Biz Type To Be Updated"));
        }
    }

    public void data_del(int id) {
        if (id == 0) {
        } else if (id != 0) {
            bizreg_gs.setId(id);
            Session session = sf.SfUtil().openSession();
            session.beginTransaction();
            session.delete(bizreg_gs);
            session.getTransaction().commit();
            session.close();
            clean();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Record Deleted"));
        }
    }

    public void IntoFields(int id) {

        biz_reg_pop.getList_().stream().forEach((BizRegGS of_in) -> {
            if (of_in.getId() == id) {

                bizreg_gs = new BizRegGS();
                holder.setId_updt(id);

                bizreg_gs.setBizId(of_in.getBizId());
                bizreg_gs.setIdNo(of_in.getIdNo());
                bizreg_gs.setPinPriv(of_in.getPinPriv());
                bizreg_gs.setNameLegal(of_in.getNameLegal());
                bizreg_gs.setNameDir1(of_in.getNameDir1());
                bizreg_gs.setNameDir2(of_in.getNameDir2());
                bizreg_gs.setNameTrade(of_in.getNameTrade());
                bizreg_gs.setPinBiz(of_in.getPinBiz());
                bizreg_gs.setBizType(of_in.getBizType());
                bizreg_gs.setBizNature(of_in.getBizNature());
                bizreg_gs.setDateStart(of_in.getDateStart());
                bizreg_gs.setDateVisit(of_in.getDateVisit());
                bizreg_gs.setBlockNo(of_in.getBlockNo());
                bizreg_gs.setBlockName(of_in.getBlockName());
                bizreg_gs.setBlockArea(of_in.getBlockArea());
                bizreg_gs.setBizFloorNo(of_in.getBizFloorNo());
                bizreg_gs.setBizOfficeNo(of_in.getBizOfficeNo());
                bizreg_gs.setBizNeighbour(of_in.getBizNeighbour());
                bizreg_gs.setBizPobox(of_in.getBizPobox());
                bizreg_gs.setBizEmail(of_in.getBizEmail());
                bizreg_gs.setBizTelNo(of_in.getBizTelNo());
                bizreg_gs.setRentalLlordTenant(of_in.getRentalLlordTenant());
                bizreg_gs.setRentalLlordName(of_in.getRentalLlordName());
                bizreg_gs.setRentalLlordNo(of_in.getRentalLlordNo());
                bizreg_gs.setRentalRentPaid(of_in.getRentalRentPaid());
                bizreg_gs.setRentalUnitType(of_in.getRentalUnitType());
                bizreg_gs.setRentalUnitsNo(of_in.getRentalUnitsNo());
                bizreg_gs.setRentalUnitsRent(of_in.getRentalUnitsRent());
                bizreg_gs.setEmpNo(of_in.getEmpNo());
                bizreg_gs.setEmpPaye(of_in.getEmpPaye());
                bizreg_gs.setToCurr(of_in.getToCurr());
                bizreg_gs.setToPrev(of_in.getToPrev());
                bizreg_gs.setItax(of_in.getItax());
                bizreg_gs.setPostedBy(of_in.getPostedBy());

            } else {
            }
        });
        holder.setMsg("");
    }

    ////Pagination Strt;
    private Paginator.PaginationHelper pagination;
    private int selectedItemIndex;
    private List<BizRegGS> listAll = null;

    public PaginationHelper getPagination() {
        if (pagination == null) {
            pagination = new PaginationHelper(7) {
                @Override
                public int getItemsCount() {
                    return biz_reg_pop.getCount();
                }

                @Override
                public List createPageDataList() {
                    return new ArrayList<>(biz_reg_pop.data_pop(getPageFirstItem(), getPageFirstItem() + getPageSize()));
                }
            };
        }
        return pagination;
    }

    public List<BizRegGS> getListAll() {
        if (listAll == null) {
            listAll = getPagination().createPageDataList();
        }
        return listAll;
    }

    private void recreateModel() {
        listAll = null;
    }

    private void recreatePagination() {
        pagination = null;
    }

    private void updateCurrentItem() {
        int count = biz_reg_pop.getCount();
        if (selectedItemIndex >= count) {

            // selected index cannot be bigger than number of items:
            selectedItemIndex = count - 1;

            // go to previous page if last page disappeared:
            if (pagination.getPageFirstItem() >= count) {

                pagination.previousPage();
            }
        }
        if (selectedItemIndex >= 0) {
            bizreg_gs = biz_reg_pop.data_pop(selectedItemIndex, selectedItemIndex + 1).get(0);
        }
    }

    public String next() {
        getPagination().nextPage();
        recreateModel();
        return nav_.bizRegPop();
    }

    public String lastPage() {
        getPagination().lastPage();
        recreateModel();
        return nav_.bizRegPop();
    }

    public String previous() {
        getPagination().previousPage();
        recreateModel();
        return nav_.bizRegPop();
    }

    public String firstPage() {
        getPagination().firstPage();
        recreateModel();
        return nav_.bizRegPop();
    }

    public int count() {
        return biz_reg_pop.getCount();
    }

    ////Pagination End
    public BizRegGS getBizreg_gs() {
        return bizreg_gs;
    }

    public void setBizreg_gs(BizRegGS bizreg_gs) {
        this.bizreg_gs = bizreg_gs;
    }

    public HoldersLoginMsg.holder getHolder() {
        return holder;
    }

    public void setHolder(HoldersLoginMsg.holder holder) {
        this.holder = holder;
    }

    public HoldersLoginMsg.LoginGS getLogin_cred() {
        return login_cred;
    }

    public void setLogin_cred(HoldersLoginMsg.LoginGS login_cred) {
        this.login_cred = login_cred;
    }

}
