package com.neusoft.bsp.MVO.service;

import com.neusoft.bsp.MVO.entity.Sal;

import java.util.List;

/**
 * (Sal)表服务接口
 *
 * @author makejava
 * @since 2020-07-12 16:13:16
 */
public interface SalService {

    /**
     * 通过ID查询单条数据
     *
     * @param salId 主键
     * @return 实例对象
     */
    Sal queryById(Integer salId);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<Sal> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param sal 实例对象
     * @return 实例对象
     */
    Sal insert(Sal sal);

    /**
     * 修改数据
     *
     * @param sal 实例对象
     * @return 实例对象
     */
    Sal update(Sal sal);

    /**
     * 通过主键删除数据
     *
     * @param salId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer salId);

}