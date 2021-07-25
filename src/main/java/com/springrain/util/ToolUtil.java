package com.springrain.util;

import com.springrain.entity.AreaCode;
import org.apache.commons.lang3.StringUtils;

import java.util.*;

public class ToolUtil implements AreaCodeConstant{

    private ToolUtil() {
    }

    public static Map findById(String id, List<AreaCode> list) {

        Map<String, Object> map = new HashMap<>();
        if (StringUtils.isNotBlank(id)) {
            List<AreaCode> areaCodeLists = new ArrayList<>();
            areaCodeLists = list;
            Optional areaCodeOptional = areaCodeLists.stream().filter(item -> item.getCityId().equals(id)).findFirst();
            if (areaCodeOptional.isPresent()) {
                // 存在
                AreaCode areaCode = (AreaCode) areaCodeOptional.get();
                map.put(CITY_KEY, areaCode.getCityName());
            } else {
                map.put(CITY_KEY, "输入的城市id有误");
            }
        } else {
            throw new RuntimeException("运行出错");
        }
        return map;
    }
}
