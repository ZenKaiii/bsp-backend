package com.neusoft.bsp.Wallet.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.neusoft.bsp.Wallet.entiity.Wallet;
import com.neusoft.bsp.Wallet.mapper.WalletMapper;
import com.neusoft.bsp.Wallet.service.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service ("WalletService")
public class WalletServiceImpl implements WalletService {
   @Autowired
   WalletMapper walletMapper;


    @Override
    public int insert(Wallet wallet) {
        return walletMapper.insert(wallet);
    }

    @Override
    public int update(Wallet wallet) {
        return walletMapper.update(wallet);
    }

    @Override
   public int delete(String walletid) {
       return walletMapper.delete(walletid);
   }

   @Override
   public Wallet getById(String walletid) {
       return walletMapper.getById(walletid);
   }

   @Override
   public List<Wallet> getAll() {
       return walletMapper.getAll();
   }

   @Override
   public List<Wallet> getAllByFilter(Map<String, Object> map) {
       return walletMapper.getAllByFilter(map);
   }

   @Override
   public PageInfo<Wallet> getAllByFilter(Integer pageNum, Integer pageSize) {
       return this.getAllByFilter(pageNum,pageSize,new HashMap());
   }

   @Override
   public PageInfo<Wallet> getAllByFilter(Integer pageNum, Integer pageSize, Map<String, Object> map) {
       PageHelper.startPage(pageNum,pageSize,true);
       List<Wallet> Wallets = walletMapper.getAllByFilter(map);
       return new PageInfo<>(Wallets);
   }
}
