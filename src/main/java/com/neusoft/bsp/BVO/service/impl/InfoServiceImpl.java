package com.neusoft.bsp.BVO.service.impl;

import com.neusoft.bsp.BVO.entity.Str;
import com.neusoft.bsp.BVO.repository.StrRepository;
import com.neusoft.bsp.BVO.service.InfoService;
import com.neusoft.bsp.BVO.vo.BvoUserVO;
import com.neusoft.bsp.System.entity.User;
import com.neusoft.bsp.System.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InfoServiceImpl implements InfoService {

    @Autowired
    UserMapper userMapper;
    @Autowired
    StrRepository strRepository;

    @Override
    public BvoUserVO findUserVo(int userId) {
        User user = userMapper.getById(userId);
        return new BvoUserVO(user.getName(),user.getEmail(),user.getPhone());
    }

    @Override
    public void updateUserInfo(int id,BvoUserVO bvoUserVO) {
        User user = userMapper.getById(id);
        user.setName(bvoUserVO.getName());
        user.setEmail(bvoUserVO.getEmail());
        user.setPhone(bvoUserVO.getPhone());
        userMapper.update(user);
    }

    @Override
    public List<Str> getStoresByDsrId(Integer id) {
        return strRepository.getStrByDsrId(id);
    }




}
