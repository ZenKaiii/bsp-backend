package com.neusoft.bsp.Wallet.service;

import com.github.pagehelper.PageInfo;
import com.neusoft.bsp.Wallet.entiity.Wallet;

import java.util.List;
import java.util.Map;

public interface WalletService {

    int insert(Wallet wallet);

    int update(Wallet wallet);

    int delete(String walletid);

    Wallet getById(String walletid);

    List<Wallet> getAll();

    List<Wallet> getAllByFilter(Map<String, Object> map);

    PageInfo<Wallet> getAllByFilter(Integer pageNum, Integer pageSize);

    PageInfo<Wallet> getAllByFilter(Integer pageNum, Integer pageSize, Map<String, Object> map);
}
