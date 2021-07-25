package com.springrain.dao;


import com.springrain.entity.AreaCode;
import com.springrain.vo.CityVO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.scheduling.annotation.Async;

import java.util.Collection;
import java.util.List;

@Mapper
public interface AreaCodeDao {



    List<AreaCode> getAllAreaCodes();

    // 按省份分组统计城市名称及其对应数量按数量升序
    List<CityVO> getAllCityVOs();
}
