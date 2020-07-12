package com.neusoft.bsp.MVO.service.impl;

import com.neusoft.bsp.MVO.dao.SalDao;
import com.neusoft.bsp.MVO.entity.Sal;
import com.neusoft.bsp.MVO.service.SalService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Sal)表服务实现类
 *
 * @author makejava
 * @since 2020-07-12 16:13:16
 */
@Service("salService")
public class SalServiceImpl implements SalService {
    @Resource
    private SalDao salDao;

    /**
     * 通过ID查询单条数据
     *
     * @param salId 主键
     * @return 实例对象
     */
    @Override
    public Sal queryById(Integer salId) {
        return this.salDao.queryById(salId);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<Sal> queryAllByLimit(int offset, int limit) {
        return this.salDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param sal 实例对象
     * @return 实例对象
     */
    @Override
    public Sal insert(Sal sal) {
        this.salDao.insert(sal);
        return sal;
    }

    /**
     * 修改数据
     *
     * @param sal 实例对象
     * @return 实例对象
     */
    @Override
    public Sal update(Sal sal) {
        this.salDao.update(sal);
        return this.queryById(sal.getSalId());
    }

    /**
     * 通过主键删除数据
     *
     * @param salId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer salId) {
        return this.salDao.deleteById(salId) > 0;
    }
}