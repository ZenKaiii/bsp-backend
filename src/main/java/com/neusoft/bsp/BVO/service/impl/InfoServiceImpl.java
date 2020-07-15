package com.neusoft.bsp.BVO.service.impl;

import com.neusoft.bsp.BVO.entity.Dsr;
import com.neusoft.bsp.BVO.entity.Str;
import com.neusoft.bsp.BVO.form.StoreForm;
import com.neusoft.bsp.BVO.repository.DsrRepository;
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
    @Autowired
    DsrRepository dsrRepository;

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

    @Override
    public void addStore(StoreForm storeForm) {
        Str store = new Str();
        store.setDsrId(storeForm.getDsrId());
        store.setPlataeformType(storeForm.getPlataeformType());
        store.setStoreName(storeForm.getStoreName());
        strRepository.saveAndFlush(store);
    }

    @Override
    public Dsr getDsr() {
        Dsr dsr = new Dsr();
        dsr.setName("aaa");
        dsrRepository.saveAndFlush(dsr);
        System.out.println(dsr.getDsrId());
        return dsr;
    }


}
