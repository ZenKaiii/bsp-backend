package com.neusoft.bsp.MVO.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

.controller;
        .entity.Sdi;
        .service.SdiService;

/**
 * (Sdi)表控制层
 *
 * @author makejava
 * @since 2020-07-12 16:14:11
 */
@RestController
@RequestMapping("sdi")
public class SdiController {
    /**
     * 服务对象
     */
    @Resource
    private SdiService sdiService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public Sdi selectOne(Integer id) {
        return this.sdiService.queryById(id);
    }

}