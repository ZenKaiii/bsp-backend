package com.neusoft.bsp.MVO.service;

import java.util.List;

.service;
        .entity.Sdi;

/**
 * (Sdi)表服务接口
 *
 * @author makejava
 * @since 2020-07-12 16:14:11
 */
public interface SdiService {

    /**
     * 通过ID查询单条数据
     *
     * @param dilId 主键
     * @return 实例对象
     */
    Sdi queryById(Integer dilId);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<Sdi> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param sdi 实例对象
     * @return 实例对象
     */
    Sdi insert(Sdi sdi);

    /**
     * 修改数据
     *
     * @param sdi 实例对象
     * @return 实例对象
     */
    Sdi update(Sdi sdi);

    /**
     * 通过主键删除数据
     *
     * @param dilId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer dilId);

}