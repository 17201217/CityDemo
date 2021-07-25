package com.springrain.service.impl;

import com.springrain.dao.AreaCodeDao;
import com.springrain.entity.AreaCode;
import com.springrain.service.AreaCodeService;
import com.springrain.util.AreaCodeConstant;
import com.springrain.util.ToolUtil;
import com.springrain.vo.CityVO;
import com.springrain.vo.ProvinceVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
@Slf4j
public class AreaCodeServiceImpl implements AreaCodeService, AreaCodeConstant {

    @Autowired
    private AreaCodeDao areaCodeDao;


    /*
       条件不同时执行不同的操作
       1. - 获取省份Map，结构：Map<String, String>    key 省份名称；   value 省份ID
       2. - 获取各自省份包含城市map，结构：Map<String, Set<String>>  key 省份名称，value 城市名称Set
       3. - 获取城市map，结构Map<String, String> key：城市名称，value：areaCode
       4. - 构建省份List，按照省份ID排序，这里没有使用set发现会有很多重复值
       5. - 构建一个Map，可以把城市cityID翻译成中文名称（注意有坑）
       可以将List转化为Map然后使用 List<Map<String,Object>>，list中添加转化后的map后返回给控制层，这里为了简单起见并没有进行封装
     */
    @Override
    public List<AreaCode> getAllAreaCodes(String condtion) {

        List<AreaCode> areaCodesList = areaCodeDao.getAllAreaCodes();

        if (condtion.equals(FIRST_CONDITION)) {
            log.info("第一个例子");
            Map<String, String> map1 = areaCodesList.stream().collect(Collectors.toMap(AreaCode::getProvinceName, AreaCode::getProvinceId,
                    (value1, value2) -> {
                        return value2;
                    }));
            map1.forEach((key, value) -> {
                log.info("key: " + key + " value: " + value);
            });
        } else if (condtion.equals(SECOND_CONDITION)) {
            log.info("第二个例子");
            Map<String, Set<String>> map2 = areaCodesList.stream().collect(Collectors.toMap(AreaCode::getProvinceName,
                    s -> {
                        Set<String> cityNameSet = new HashSet<>();
                        cityNameSet.add(s.getCityName());
                        return cityNameSet;
                    },
                    (value1, value2) -> {
                        return value2;
                    }));
            map2.forEach((key, value) -> {
                log.info("key: " + key + " value: " + value);
            });
        } else if (condtion.equals(THIRD_CONDITION)) {
            log.info("第三个例子");
            Map<String, String> map3 = areaCodesList.stream().collect(Collectors.toMap(AreaCode::getCityName, AreaCode::getAreaCode,
                    (value1, value2) -> {
                        return value2;
                    }));
            map3.forEach((key, value) -> {
                log.info("key: " + key + " value: " + value);
            });
        } else if (condtion.equals(FORTH_CONDITION)) {
            log.info("第四个例子");
            // - 构建省份List，按照省份ID排序
            List<ProvinceVO> provinceList = areaCodesList.stream().map(
                    e -> new ProvinceVO(e.getProvinceId(), e.getProvinceName()))
                    .collect(Collectors.toList());
            provinceList.forEach(e ->
                    log.info(e.getProvinceId() + "," + e.getProvinceName())
            );

            // 这里的排序只是其中的一种方法，加上reversed()使其变为降序排序
            Collections.sort(provinceList, Comparator.comparing(ProvinceVO::getProvinceId).reversed());
            provinceList.forEach(e ->
                    log.info(e.getProvinceId() + "," + e.getProvinceName())
            );
        } else {
            log.info("第五个例子");
            List<String> cityIdList = areaCodesList.stream().map(AreaCode::getCityId).collect(Collectors.toList());
            // List<String> areaCodeList = areaCodesList.stream().map(AreaCode::getAreaCode).collect(Collectors.toList());
            Map<String, Object> map = new HashMap<>();

            // 遍历城市id输出状态码以及对应的城市名称 undo---------一个城市id看可能对应多个城市名称
            cityIdList.forEach(e ->
                    log.info(ToolUtil.findById(e, areaCodesList).toString())
            );

        }

        return areaCodeDao.getAllAreaCodes();
    }


    @Override
    public List<CityVO> getAllCityVOs() {
        return areaCodeDao.getAllCityVOs();
    }


    @Override
    public void test() {
        System.out.println("pjm");
    }
}
