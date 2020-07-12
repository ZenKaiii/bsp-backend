package com.neusoft.bsp.MVO.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.neusoft.bsp.MVO.dao.SaoDao;
import com.neusoft.bsp.MVO.entity.Sao;
import com.neusoft.bsp.MVO.service.SaoService;
import org.springframework.stereotype.Service;

/**
 * (Sao)表服务实现类
 *
 * @author makejava
 * @since 2020-07-11 21:43:26
 */
@Service("saoService")
public class SaoServiceImpl extends ServiceImpl<SaoDao, Sao> implements SaoService {

}