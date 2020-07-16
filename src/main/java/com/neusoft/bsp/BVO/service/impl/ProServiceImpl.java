package com.neusoft.bsp.BVO.service.impl;

import com.neusoft.bsp.BVO.entity.Wit;
import com.neusoft.bsp.BVO.repository.WitRepository;
import com.neusoft.bsp.BVO.service.ProService;
import com.neusoft.bsp.MVO.entity.Product;
import com.neusoft.bsp.MVO.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProServiceImpl implements ProService {

    @Autowired
    ProductMapper productMapper;
    @Autowired
    WitRepository witRepository;

    @Override
    public List<Product> findAllProduct() {
        return productMapper.getAll();
    }

    @Override
    public List<Wit> findAllWitByDsrId(Integer dsrId) {
        return witRepository.findAllWitByDsrId(dsrId);
    }

    @Override
    public List<Product> findProductByWit(Integer dsrId) {
        List<Product> products = new ArrayList<>();
        List<Wit> wits = witRepository.findAllWitByDsrId(dsrId);
        for (Wit wit : wits) {
            products.add(productMapper.getById(wit.getProId()));
        }
        return products;
    }

    @Override
    public void deleteWitById(Integer witId) {
        List<Wit> wits = new ArrayList<>();
        wits.add(witRepository.findWitByWitId(witId));
        witRepository.deleteInBatch(wits);
    }
}
