package ListsAndMaps;

import SfUtil.SfUtil;
import java.io.Serializable;
import java.util.*;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.*;

@Named
@ApplicationScoped
public class ListsAndMaps implements Serializable {
    // Map<String, String> map = list_.stream().collect(toMap(biztype_getset::getBiz_type, biztype_getset::getBiz_type, (s, a) -> s + ", " + a));

    private final SfUtil sf = new SfUtil();
    private Enum2MapGS enum_maps_gs;

    public Map<String, String> hierachy_listmeth() {
        enum_maps_gs = new Enum2MapGS();
        List<Enum2MapGS.HierachyVals> hierachyList = new ArrayList<>(EnumSet.allOf(Enum2MapGS.HierachyVals.class));
        Map<String, String> hierachyMap = new HashMap<>();
        hierachyList.forEach((lst) -> {
            hierachyMap.put(lst.toString(), lst.toString());
        });
        return hierachyMap;
    }

    public Map<String, String> biz_type_listmeth() {
        enum_maps_gs = new Enum2MapGS();
        List<Enum2MapGS.BizTypeVals> bizTypeList = new ArrayList<>(EnumSet.allOf(Enum2MapGS.BizTypeVals.class));
        Map<String, String> bizTypeMap = new HashMap<>();
        bizTypeList.forEach(e -> {
            bizTypeMap.put(e.toString(), e.toString());
        });
        return bizTypeMap;
    }

    public ListsAndMaps() {
        enum_maps_gs = new Enum2MapGS();
    }

}
