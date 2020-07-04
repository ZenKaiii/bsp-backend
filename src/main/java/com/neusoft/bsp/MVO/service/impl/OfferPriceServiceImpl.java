package com.neusoft.bsp.MVO.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.neusoft.bsp.MVO.entity.OfferPrice;
import com.neusoft.bsp.MVO.mapper.OfferPriceMapper;
import com.neusoft.bsp.MVO.service.OfferPriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service ("OfferPriceService")
public class OfferPriceServiceImpl implements OfferPriceService {
    @Autowired
    OfferPriceMapper OfferPriceMapper;

    @Override
    public int insert(OfferPrice OfferPrice) {
       return OfferPriceMapper.insert(OfferPrice);
    }

    @Override
    public int update(OfferPrice OfferPrice) {
       return OfferPriceMapper.update(OfferPrice);
    }

    @Override
    public int delete(int offerPriceid) {
        return 0;
    }

    @Override
    public OfferPrice getById(int offerPriceid) {
        return null;
    }

    @Override
    public List<OfferPrice> getAll() {
       return OfferPriceMapper.getAll();
    }

    @Override
    public List<OfferPrice> getAllByFilter(Map<String, Object> map) {
       return OfferPriceMapper.getAllByFilter(map);
    }

    @Override
    public PageInfo<OfferPrice> getAllByFilter(Integer pageNum, Integer pageSize) {
       return this.getAllByFilter(pageNum,pageSize,new HashMap());
    }

    @Override
    public PageInfo<OfferPrice> getAllByFilter(Integer pageNum, Integer pageSize, Map<String, Object> map) {
       PageHelper.startPage(pageNum,pageSize,true);
       List<OfferPrice> OfferPrices = OfferPriceMapper.getAllByFilter(map);
       return new PageInfo<>(OfferPrices);
    }}
