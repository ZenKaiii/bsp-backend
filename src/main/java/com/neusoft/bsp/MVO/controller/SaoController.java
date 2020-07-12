package com.neusoft.bsp.MVO.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.neusoft.bsp.MVO.entity.Sao;
import com.neusoft.bsp.MVO.service.SaoService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * (Sao)表控制层
 *
 * @author makejava
 * @since 2020-07-11 21:43:26
 */
@RestController
@RequestMapping("sao")
public class SaoController extends ApiController {
    /**
     * 服务对象
     */
    @Resource
    private SaoService saoService;

    /**
     * 分页查询所有数据
     *
     * @param page 分页对象
     * @param sao  查询实体
     * @return 所有数据
     */
    @GetMapping
    public R selectAll(Page<Sao> page, Sao sao) {
        return success(this.saoService.page(page, new QueryWrapper<>(sao)));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public R selectOne(@PathVariable Serializable id) {
        return success(this.saoService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param sao 实体对象
     * @return 新增结果
     */
    @PostMapping
    public R insert(@RequestBody Sao sao) {
        return success(this.saoService.save(sao));
    }

    /**
     * 修改数据
     *
     * @param sao 实体对象
     * @return 修改结果
     */
    @PutMapping
    public R update(@RequestBody Sao sao) {
        return success(this.saoService.updateById(sao));
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @DeleteMapping
    public R delete(@RequestParam("idList") List<Long> idList) {
        return success(this.saoService.removeByIds(idList));
    }
}