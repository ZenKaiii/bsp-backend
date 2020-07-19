package com.neusoft.bsp.BVO.controller;


import com.neusoft.bsp.BVO.entity.Dsr;
import com.neusoft.bsp.BVO.exception.BvoException;
import com.neusoft.bsp.BVO.form.StoreForm;
import com.neusoft.bsp.BVO.service.InfoService;
import com.neusoft.bsp.BVO.service.OrderService;
import com.neusoft.bsp.BVO.service.ProService;
import com.neusoft.bsp.BVO.service.BvoWalletService;
import com.neusoft.bsp.BVO.util.ResultVOUtil;
import com.neusoft.bsp.BVO.vo.BvoUserVO;
import com.neusoft.bsp.BVO.vo.ResultVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/bvo")
@Slf4j
public class BVOController {

    @Autowired
    private InfoService infoService;
    @Autowired
    private ProService productService;
    @Autowired
    private OrderService orderService;
    @Autowired
    private BvoWalletService walletService;

    @GetMapping("/info/{id}")
    public ResultVO getInfo(@PathVariable("id") int id){
        return ResultVOUtil.success(infoService.findUserVo(id));
    }

    @PutMapping("/updateInfo/{id}")
    public ResultVO updateUserInfo(@PathVariable("id") int id ,@RequestBody BvoUserVO bvoUserVO, BindingResult bindingResult){
        infoService.updateUserInfo(id,bvoUserVO);
        return ResultVOUtil.success(null);
    }

    @GetMapping("/store/{id}")
    public ResultVO findStores(@PathVariable("id") Integer id){
        return ResultVOUtil.success(infoService.getStoresByDsrId(id));
    }

    @PostMapping("/addstore")
    public ResultVO addStore(@RequestBody StoreForm storeForm,BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            log.error("添加商店信息错误");
            throw new BvoException(bindingResult.getFieldError().getDefaultMessage());
        }
        infoService.addStore(storeForm);
        return ResultVOUtil.success(null);
    }

    @GetMapping("/product")
    public ResultVO findAllPro(){
        return ResultVOUtil.success(productService.findAllProduct());
    }

    @GetMapping("/product/{proId}")
    public ResultVO findPro(@PathVariable("proId") Integer id){
        return ResultVOUtil.success(productService.findProVOById(id));
    }

    @GetMapping("/wit/{userId}")
    public ResultVO findAllWitByDsrId(@PathVariable("userId") Integer id){
        return ResultVOUtil.success(productService.findProductByWit(id));
    }

    @GetMapping("/addwit/{dsrId}/{proId}")
    public ResultVO addWit(@PathVariable("dsrId")Integer dsrId,@PathVariable("proId")Integer proId){
        productService.addWitbyDsrIdAndProId(dsrId,proId);
        return ResultVOUtil.success(null);
    }

    @DeleteMapping("/deleteWit/{id}")
    public ResultVO deleteWitById(@PathVariable("id")Integer id){
        productService.deleteWitById(id);
        return ResultVOUtil.success(null);
    }

    @DeleteMapping("/deleteWits/{ids}")
    public ResultVO deleteWitByIds(@PathVariable("ids") String ids){
        List<String> idsStringList = Arrays.asList(ids.split(","));
        for (String s : idsStringList) {
            productService.deleteWitById(Integer.valueOf(s));
        }
        return ResultVOUtil.success(null);
    }

    @GetMapping("/getAllOrderByDsrId/{id}")
    public ResultVO getAllOrder(@PathVariable("id") Integer id){
        return ResultVOUtil.success(orderService.getAllOrderByDsrId(id));
    }

    @GetMapping("/getAllOrderByDsrIdAndOrderSts/{dsrid}/{ordersts}")
    public ResultVO getAllOrderByDsrIdAndOrderSts(@PathVariable("dsrid")Integer dsrId, @PathVariable("ordersts")String orderSts){
        return ResultVOUtil.success(orderService.getAllOrderByDsrIdAndStatus(dsrId,orderSts));
    }

    @GetMapping("/wallet/{buyerId}")
    public ResultVO getWallet(@PathVariable("buyerId")Integer buyerId){
        return ResultVOUtil.success(walletService.getWalletVOByBuyerId(buyerId));
    }

    @GetMapping("/deposit/{buyerId}/{amount}")
    public ResultVO deposit(@PathVariable("buyerId") Integer buyerId, @PathVariable("amount")BigDecimal amount){
        walletService.deposit(buyerId,amount);
        return ResultVOUtil.success(null);
    }

    @GetMapping("/pay/{saoId}/{buyerId}/{amount}")
    public ResultVO pay(@PathVariable("saoId")Integer saoId,@PathVariable("buyerId") Integer buyerId, @PathVariable("amount")BigDecimal amount){
        if (walletService.pay(buyerId,amount)){
            orderService.payOrder(saoId);
            return ResultVOUtil.success(null);
        }
        else
            return ResultVOUtil.error("钱包余额不足，请充钱");
    }

    @GetMapping("/dsr")
    public Dsr getDsr(){
        return infoService.getDsr();
    }

}
