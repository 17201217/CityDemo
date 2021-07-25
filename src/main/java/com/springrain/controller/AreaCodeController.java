package com.springrain.controller;

import com.springrain.entity.AreaCode;
import com.springrain.service.AreaCodeService;
import com.springrain.util.ToolUtil;
import com.springrain.vo.CityVO;
import com.springrain.vo.ProvinceVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;

@Slf4j
@CrossOrigin
@Controller
@RequestMapping("/areacode")
public class AreaCodeController {

    @Autowired
    private AreaCodeService areaCodeService;

    @ResponseBody
    @RequestMapping(path = "/cityname_count/list", method = RequestMethod.GET)
    public List<CityVO> selectCityVO() {
        List<CityVO> cityVOsList = areaCodeService.getAllCityVOs();
        return cityVOsList;
    }

    // 没有将日志写入到文件中，需要改进
    @RequestMapping("/test/jdk")
    @ResponseBody
    public void jdkFeature() {
        List<CityVO> cityVOsList = areaCodeService.getAllCityVOs();
        cityVOsList.forEach(item -> {
            log.info(item.getCityName()+"....."+item.getAmount());
        });

    }

    /*
       根据前台输入的不同条件做不同操作
     */
    @ResponseBody
    @RequestMapping("/areacodeList/{condition}")
    public List<AreaCode> selectAreaCodes(@PathVariable("condition") String condition) {

        List<AreaCode> areaCodesList = areaCodeService.getAllAreaCodes(condition);

        return areaCodesList;
    }


}
