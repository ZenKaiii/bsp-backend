package com.neusoft.bsp.BVO.service.impl;

import com.neusoft.bsp.BVO.entity.Pro;
import com.neusoft.bsp.BVO.entity.SysUser;
import com.neusoft.bsp.BVO.entity.Wit;
import com.neusoft.bsp.BVO.exception.BvoException;
import com.neusoft.bsp.BVO.repository.*;
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
    @Autowired
    PdnRepository pdnRepository;
    @Autowired
    SysUserRepository sysUserRepository;

    @Override
    public ProVO findProVOById(Integer proId) {
        Pro pro = proRepository.getProByProId(proId);
        if (pro == null || brdRepository.getBrdByBrdId(pro.getBrdId())==null){
            throw new BvoException("proId有误或数据库有误");
        }
        return new ProVO(pro.getProId(),
                pro.getTitle(),
                pro.getRetailPrice(),
                pro.getSkuCd(),
                brdRepository.getBrdByBrdId(pro.getBrdId()).getNameCn(),
                pro.getStockseting(),
                pdnRepository.getPdnByProId(proId).getDescription(),
                imgMapper.getUrlByProId(pro.getProId()));
    }

    @Override
    public List<ProVO> findAllProduct() {
        List<Pro> pros = proRepository.findAll();
        List<ProVO> proVOS = new ArrayList<>();

        for (Pro pro : pros) {
            if (brdRepository.getBrdByBrdId(pro.getBrdId())==null){
                throw new BvoException("pro数据库中brdId有误");
            }
            if (imgMapper.getUrlByProId(pro.getProId()) == null){
                proVOS.add(new ProVO(pro.getProId(),
                        pro.getTitle(),
                        pro.getRetailPrice(),
                        pro.getSkuCd(),
                        brdRepository.getBrdByBrdId(pro.getBrdId()).getNameCn(),
                        pro.getStockseting(),
                        pdnRepository.getPdnByProId(pro.getProId()).getDescription(),
                        ""));
            } else {
                proVOS.add(new ProVO(pro.getProId(),
                        pro.getTitle(),
                        pro.getRetailPrice(),
                        pro.getSkuCd(),
                        brdRepository.getBrdByBrdId(pro.getBrdId()).getNameCn(),
                        pro.getStockseting(),
                        pdnRepository.getPdnByProId(pro.getProId()).getDescription(),
                        imgMapper.getUrlByProId(pro.getProId())));

            }
        }

        return proVOS;
    }

    @Override
    public List<Wit> findAllWitByUserId(Integer userId) {
        return witRepository.findAllWitByDsrId(sysUserRepository.getSysUserByUserId(userId).getManBuyerId());
    }

    @Override
    public List<ProVO> findProductByWit(Integer userId) {
        List<Pro> products = new ArrayList<>();
        List<ProVO> proVOS = new ArrayList<>();
        List<Wit> wits = witRepository.findAllWitByDsrId(sysUserRepository.getSysUserByUserId(userId).getManBuyerId());
        for (Wit wit : wits) {
            products.add(proRepository.getProByProId(wit.getProId()));
        }
        for (Pro product : products) {
            proVOS.add(findProVOById(product.getProId()));
        }
        return proVOS;
    }

    @Override
    public void addWitbyDsrIdAndProId(Integer userId, Integer proId) {
        Wit wit = new Wit();
        SysUser sysUser = sysUserRepository.getSysUserByUserId(userId);
        wit.setDsrId(sysUser.getManBuyerId());
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
