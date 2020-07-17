package com.neusoft.bsp.BVO.repository;

import com.neusoft.bsp.BVO.entity.SysUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SysUserRepository extends JpaRepository<SysUser,Integer> {
    public SysUser getSysUserByUserId(Integer userId);
}
