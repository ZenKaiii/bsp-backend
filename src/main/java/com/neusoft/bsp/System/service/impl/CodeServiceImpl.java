package com.neusoft.bsp.System.service.impl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.neusoft.bsp.System.entity.Code;
import com.neusoft.bsp.System.mapper.CodeMapper;
import com.neusoft.bsp.System.service.CodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @quthor: 张晗修
 * @version: v1.0
 * @description: 实现对数据词典的操作方法
 */
@Service ("codeService")
public class CodeServiceImpl implements CodeService {
   @Autowired
   CodeMapper codeMapper;

   @Override
   public int insert(Code code) {
       return codeMapper.insert(code);
   }

   @Override
   public int update(Code code) {
       return codeMapper.update(code);
   }

   @Override
   public int delete(String codeid) {
       return codeMapper.delete(codeid);
   }

   @Override
   public Code getById(String codeid) {
       return codeMapper.getById(codeid);
   }

   @Override
   public List<Code> getAll() {
       return codeMapper.getAll();
   }

   @Override
   public List<Code> getAllByFilter(Map<String, Object> map) {
       return codeMapper.getAllByFilter(map);
   }

   @Override
   public PageInfo<Code> getAllByFilter(Integer pageNum, Integer pageSize) {
       return this.getAllByFilter(pageNum,pageSize,new HashMap());
   }

   @Override
   public PageInfo<Code> getAllByFilter(Integer pageNum, Integer pageSize, Map<String, Object> map) {
       PageHelper.startPage(pageNum,pageSize,true);
       List<Code> Codes = codeMapper.getAllByFilter(map);
       return new PageInfo<>(Codes);
   }
}
