package com.neusoft.bsp.MVO.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.neusoft.bsp.MVO.entity.Manufacturer;
import com.neusoft.bsp.MVO.mapper.ManufacturerMapper;
import com.neusoft.bsp.MVO.service.ManufacturerService;
import com.neusoft.bsp.MVO.vo.ManufacturerVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
@Service ("manufacturerService")
public class ManufacturerServiceImpl implements ManufacturerService {
    @Autowired
    ManufacturerMapper manufacturerMapper;


    @Override
    public int alterManufacturer(ManufacturerVo manufacturerVo, int userId) {
        int i=0;
        Map<String,Object> map = new HashMap<>();
        Manufacturer manufacturer=this.selectByUserId(userId);
//            Manufacturer manufacturer=new Manufacturer();
        if(manufacturer==null){
            manufacturer=new Manufacturer();
        }
        manufacturer=manufacturerVo.changeManufacturer(manufacturer);
        map.put("man_id",manufacturer.getMan_id());
        map.put("name_en",manufacturer.getName_en());
        map.put("name_cn",manufacturer.getName_cn());
        map.put("gmc_report_type",manufacturer.getGmc_report_type());
        map.put("gmc_report_url",manufacturer.getGmc_report_url());
        map.put("description",manufacturer.getDescription());
        map.put("created_by",userId);
        map.put("last_update_by",userId);
        map.put("call_cnt",manufacturer.getCall_cnt());
        map.put("remark",manufacturer.getRemark());
        map.put("sts_cd",manufacturer.getSts_cd());
        map.put("user_id",userId);
        if(this.getManIdByUserId(userId)!=0){
            manufacturer.setLast_update_date(new Date(System.currentTimeMillis()));
            i=this.update(manufacturer);
        }
        else {
            map.put("created_date",new Date(System.currentTimeMillis()).toString());
            i=this.insert(map);
        }
        return i;
    }


    @Override
    public int insert(Map<String, Object> map) {
        return manufacturerMapper.insert(map);
    }

    @Override
    public int update(Manufacturer manufacturer) {
       return manufacturerMapper.update(manufacturer);
    }

    @Override
    public int delete(int manufacturerid) {
        return 0;
    }

    @Override
    public Manufacturer selectByUserId(int userId) {
        return manufacturerMapper.selectByUserId(userId);
    }

    @Override
    public int getManIdByUserId(int userId) {
        return manufacturerMapper.getManIdByUserId(userId);
    }

    @Override
    public List<Manufacturer> getAll() {
       return manufacturerMapper.getAll();
    }

    @Override
    public List<Manufacturer> getAllByFilter(Map<String, Object> map) {
       return manufacturerMapper.getAllByFilter(map);
    }

    @Override
    public PageInfo<Manufacturer> getAllByFilter(Integer pageNum, Integer pageSize) {
       return this.getAllByFilter(pageNum,pageSize,new HashMap());
    }

    @Override
    public PageInfo<Manufacturer> getAllByFilter(Integer pageNum, Integer pageSize, Map<String, Object> map) {
       PageHelper.startPage(pageNum,pageSize,true);
       List<Manufacturer> Manufacturers = manufacturerMapper.getAllByFilter(map);
       return new PageInfo<>(Manufacturers);
    }}
