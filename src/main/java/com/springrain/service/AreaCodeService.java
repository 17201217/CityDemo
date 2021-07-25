package com.springrain.service;

import com.springrain.entity.AreaCode;
import com.springrain.vo.CityVO;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

public interface AreaCodeService {

    List<AreaCode> getAllAreaCodes(String condition);

    List<CityVO> getAllCityVOs();

    void test();

}
