package ListsAndMaps;

import DateTime.date_time;
import SfUtil.SfUtil;
import biz_reg.BizRegGS;
import java.util.List;
import javax.inject.Inject;
import org.hibernate.Criteria;
import org.hibernate.Session;

public class AutOCodes {

    private final SfUtil sf = new SfUtil();
    private @Inject
    BizRegGS bizreg_gs;
    date_time dt = new date_time();

    public String biz_code() {

        bizreg_gs = new BizRegGS();
        Session session = sf.SfUtil().openSession();
        session.beginTransaction();
        Criteria crit = session.createCriteria(BizRegGS.class);

        List<BizRegGS> list_ = crit.list();

        int idd = list_.stream().map(BizRegGS::getId).reduce((a, h) -> h).orElse(0);

        return ("BZN" + String.format("%08d", (idd + 1)) + "/" + dt.year()).toUpperCase();

    }
}
