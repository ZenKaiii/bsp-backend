package com.neusoft.bsp.MVO.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.neusoft.bsp.MVO.entity.Brand;
import com.neusoft.bsp.MVO.entity.Img;
import com.neusoft.bsp.MVO.mapper.BrandMapper;
import com.neusoft.bsp.MVO.service.BrandService;
import com.neusoft.bsp.MVO.service.ImgService;
import com.neusoft.bsp.MVO.service.ManufacturerService;
import com.neusoft.bsp.MVO.vo.BrandVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service ("brandService")
public class BrandServiceImpl implements BrandService {
    @Autowired
    BrandMapper brandMapper;

    @Autowired
    ManufacturerService manufacturerService;
    @Autowired
    ImgService imgService;


    @Override
    public int alterBrand(BrandVo brandVo, int userId) {
        if(brandVo==null){
            return 0;
        }
        Brand brand=this.getById(brandVo.getBrd_id());
        int i=0;
        if(brand==null){
            brand=brandVo.toBrand();
            brand.setCreated_by(""+userId);
            brand.setLast_update_by(""+userId);
            brand.setCreation_date(new Date(System.currentTimeMillis()));
            brand.setLast_update_date(new Date(System.currentTimeMillis()));
            brand.setMan_id(manufacturerService.getManIdByUserId(userId));
            i=this.insert(brand);
            if(i==0){
                return 0;
            }
        }
        else{
            brandVo.changeBrand(brand);
            brand.setLast_update_date(new Date(System.currentTimeMillis()));
            i=this.update(brand);
            if(i==0){
                return 0;
            }
        }
        Map<String,Object> map=new HashMap<>();
        map.put("userId",userId);
        map.put("name_en",brandVo.getName_en());
        brand=this.getByNameEn(map);
        if(imgService.getImgByProId(brand.getBrd_id())==null) {
            Img img = brandVo.toImg();
            img.setEntityId(brand.getBrd_id());
            img.setCreatedBy("" + userId);
            img.setLastUpdateBy("" + userId);
            img.setCreationDate(new Date(System.currentTimeMillis()));
            img.setLastUpdateDate(new Date(System.currentTimeMillis()));
            img.setName("brd");
            i = imgService.insert(img);
            if(i==0){
                return 0;
            }
        }
        else{
            Img img=imgService.getImgByProId(brand.getBrd_id());
            brandVo.changeImg(img);
            i=imgService.update(img);
            if(i==0){
                return 0;
            }
        }
        return 1;
    }

    @Override
    public List<BrandVo> brandList(int userId) {
        int i=0;
        Map<String,Object> map = new HashMap<>();
        map.put("user_id",userId);
        List<Brand> brandList= this.getAllByUserId(map);
        List<BrandVo> brandVoList = new ArrayList<>();
        if(brandList.size()!=0) {
            for (Brand brand : brandList) {
                BrandVo brandVo = new BrandVo();
                brandVo=brandVo.getBrandVO(brand);
                brandVo.setUrl(imgService.getUrlByBrdId(brand.getBrd_id()));
                brandVoList.add(brandVo);
            }
        }
        return brandVoList;
    }

    @Override
    public int deleteBrand(BrandVo brandVo, int userId) {
        int i=0;
        if(brandVo.getBrd_id()==0){
            return 0;
        }
        i = this.delete(brandVo.getBrd_id());
        if(i==0){
            return 0;
        }
        imgService.deleteByBrdId(brandVo.getBrd_id());

        return i;
    }


    @Override
    public int insert(Brand brand) {
       return brandMapper.insert(brand);
    }

    @Override
    public int update(Brand brand) {
       return brandMapper.update(brand);
    }

    @Override
    public int delete(int brandid) {
        return brandMapper.delete(brandid);
    }

    @Override
    public Brand getById(int brandid) {
        return brandMapper.getById(brandid);
    }

    @Override
    public Brand getByNameEn(Map map) {
        return brandMapper.getByNameEn(map);
    }


    @Override
    public List<Brand> getAll() {
       return brandMapper.getAll();
    }

    @Override
    public List<Brand> getAllByUserId(Map<String, Object> map) {
        return brandMapper.getAllByUserId(map);
    }

    @Override
    public List<Brand> getAllByFilter(Map<String, Object> map) {
       return brandMapper.getAllByFilter(map);
    }

    @Override
    public PageInfo<Brand> getAll(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize,true);
        List<Brand> Brands = brandMapper.getAll();
        return new PageInfo<>(Brands);
    }

    @Override
    public PageInfo<Brand> getAllByUserId(Integer pageNum, Integer pageSize, Map<String, Object> map) {
       PageHelper.startPage(pageNum,pageSize,true);
       List<Brand> Brands = brandMapper.getAllByUserId(map);
       return new PageInfo<>(Brands);
    }}
