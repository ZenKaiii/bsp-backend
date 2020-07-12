package com.neusoft.bsp.MVO.service.impl;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

.service.impl;
        .entity.Sdi;
        .dao.SdiDao;
        .service.SdiService;

/**
 * (Sdi)表服务实现类
 *
 * @author makejava
 * @since 2020-07-12 16:14:11
 */
@Service("sdiService")
public class SdiServiceImpl implements SdiService {
    @Resource
    private SdiDao sdiDao;

    /**
     * 通过ID查询单条数据
     *
     * @param dilId 主键
     * @return 实例对象
     */
    @Override
    public Sdi queryById(Integer dilId) {
        return this.sdiDao.queryById(dilId);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<Sdi> queryAllByLimit(int offset, int limit) {
        return this.sdiDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param sdi 实例对象
     * @return 实例对象
     */
    @Override
    public Sdi insert(Sdi sdi) {
        this.sdiDao.insert(sdi);
        return sdi;
    }

    /**
     * 修改数据
     *
     * @param sdi 实例对象
     * @return 实例对象
     */
    @Override
    public Sdi update(Sdi sdi) {
        this.sdiDao.update(sdi);
        return this.queryById(sdi.getDilId());
    }

    /**
     * 通过主键删除数据
     *
     * @param dilId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer dilId) {
        return this.sdiDao.deleteById(dilId) > 0;
    }
}