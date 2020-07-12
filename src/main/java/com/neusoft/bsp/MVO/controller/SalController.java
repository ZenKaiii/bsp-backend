package com.neusoft.bsp.MVO.controller;

import com.neusoft.bsp.MVO.entity.Sal;
import com.neusoft.bsp.MVO.service.SalService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * (Sal)表控制层
 *
 * @author makejava
 * @since 2020-07-12 16:13:17
 */
@RestController
@RequestMapping("sal")
public class SalController {
    /**
     * 服务对象
     */
    @Resource
    private SalService salService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public Sal selectOne(Integer id) {
        return this.salService.queryById(id);
    }

}