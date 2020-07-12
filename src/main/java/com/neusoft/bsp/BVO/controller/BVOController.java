package com.neusoft.bsp.BVO.controller;


import com.neusoft.bsp.BVO.service.InfoService;
import com.neusoft.bsp.BVO.vo.BvoUserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/bvo")
public class BVOController {

    @Autowired
    private InfoService infoService;

    @GetMapping("/info/{id}")
    public BvoUserVO getInfo(@PathVariable("id") String id){
        return infoService.findUserVo(id);
    }

    @PutMapping("/update/{id}")
    public void updateUserInfo(@PathVariable("id") String id ,@RequestBody BvoUserVO bvoUserVO, BindingResult bindingResult){
        infoService.updateUserInfo(id,bvoUserVO);
    }
}
