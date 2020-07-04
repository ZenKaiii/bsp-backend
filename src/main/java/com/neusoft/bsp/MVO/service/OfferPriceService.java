package com.neusoft.bsp.MVO.service;

import com.github.pagehelper.PageInfo;
import com.neusoft.bsp.MVO.entity.OfferPrice;

import java.util.List;
import java.util.Map;

public interface OfferPriceService {

    int insert(OfferPrice offerPrice);

    int update(OfferPrice offerPrice);

    int delete(int offerPriceid);

    OfferPrice getById(int offerPriceid);

    List<OfferPrice> getAll();

    List<OfferPrice> getAllByFilter(Map<String, Object> map);

    PageInfo<OfferPrice> getAllByFilter(Integer pageNum, Integer pageSize);

    PageInfo<OfferPrice> getAllByFilter(Integer pageNum, Integer pageSize, Map<String, Object> map);
}
