package com.neusoft.bsp.MVO.service;

import com.github.pagehelper.PageInfo;
import com.neusoft.bsp.MVO.entity.Product;
import com.neusoft.bsp.MVO.vo.ProductDetailVo;
import com.neusoft.bsp.MVO.vo.ProductVo;

import java.util.List;
import java.util.Map;

public interface ProductService {

    int alterProduct(ProductVo productVo, int userId);

    int alterProductDetail(ProductDetailVo productDetailVo, int userId);

    List<ProductVo> getProductList(int userId);

    List<ProductDetailVo> getProductDetailList(int userId);

    int insert(Product product);

    int update(Product product);

    int delete(int pro_id);

    Product getById(int pro_id);

    Product getBySku(String sku);

    Product getByTitle(Map<String,Object> map);

    List<Product> getAll();

    List<Product> getAllByFilter(Map<String, Object> map);

    PageInfo<Product> getAllByFilter(Integer pageNum, Integer pageSize);

    PageInfo<Product> getAllByFilter(Integer pageNum, Integer pageSize, Map<String, Object> map);
}
