package com.neusoft.bsp.BVO.service.impl;

import com.neusoft.bsp.BVO.entity.Pro;
import com.neusoft.bsp.BVO.entity.Wit;
import com.neusoft.bsp.BVO.repository.BrdRepository;
import com.neusoft.bsp.BVO.repository.ProRepository;
import com.neusoft.bsp.BVO.repository.WitRepository;
import com.neusoft.bsp.BVO.service.ProService;
import com.neusoft.bsp.BVO.vo.ProVO;
import com.neusoft.bsp.MVO.entity.Brand;
import com.neusoft.bsp.MVO.entity.Product;
import com.neusoft.bsp.MVO.mapper.BrandMapper;
import com.neusoft.bsp.MVO.mapper.ImgMapper;
import com.neusoft.bsp.MVO.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProServiceImpl implements ProService {

    @Autowired
    ProRepository proRepository;
    @Autowired
    WitRepository witRepository;
    @Autowired
    ImgMapper imgMapper;
    @Autowired
    BrdRepository brdRepository;

    @Override
    public ProVO findProVOById(Integer proId) {
        Pro pro = proRepository.getProByProId(proId);
        return new ProVO(pro.getProId(),
                pro.getTitle(),
                pro.getRetailPrice(),
                pro.getSkuCd(),
                brdRepository.getBrdByBrdId(proId).getNameCn(),
                pro.getStockseting(),
                imgMapper.getUrlByProId(pro.getProId()));
    }

    @Override
    public List<ProVO> findAllProduct() {
        List<Pro> pros = proRepository.findAll();
        List<ProVO> proVOS = new ArrayList<>();

        for (Pro pro : pros) {
            proVOS.add(new ProVO(pro.getProId(),
                    pro.getTitle(),
                    pro.getRetailPrice(),
                    pro.getSkuCd(),
                    brdRepository.getBrdByBrdId(pro.getProId()).getNameCn(),
                    pro.getStockseting(),
                    imgMapper.getUrlByProId(pro.getProId())));
        }

        return proVOS;
    }

    @Override
    public List<Wit> findAllWitByDsrId(Integer dsrId) {
        return witRepository.findAllWitByDsrId(dsrId);
    }

    @Override
    public List<ProVO> findProductByWit(Integer dsrId) {
        List<Pro> products = new ArrayList<>();
        List<ProVO> proVOS = new ArrayList<>();
        List<Wit> wits = witRepository.findAllWitByDsrId(dsrId);
        for (Wit wit : wits) {
            products.add(proRepository.getProByProId(wit.getProId()));
        }
        for (Pro product : products) {
            proVOS.add(findProVOById(product.getProId()));
        }
        return proVOS;
    }

    @Override
    public void addWitbyDsrIdAndProId(Integer dsrId, Integer proId) {
        Wit wit = new Wit();
        wit.setDsrId(dsrId);
        wit.setProId(proId);
        witRepository.saveAndFlush(wit);
    }


    @Override
    public void deleteWitById(Integer witId) {
        List<Wit> wits = new ArrayList<>();
        wits.add(witRepository.findWitByWitId(witId));
        witRepository.deleteInBatch(wits);
    }


}
