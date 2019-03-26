package cn.ideacs.business.wx.learn.controller;

import cn.ideacs.business.wx.learn.converts.UserBaseConvert;
import cn.ideacs.business.wx.learn.entity.bos.UserBaseBO;
import cn.ideacs.business.wx.learn.entity.dtos.UserBaseDTO;
import cn.ideacs.business.wx.learn.service.UserBaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user/base")
public class UserBaseController {

    @Autowired
    private UserBaseService userBaseService;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Long insert(@RequestBody UserBaseDTO userBaseDTO) {
        UserBaseBO userBaseBO = UserBaseConvert.convertDTOToBO(userBaseDTO);
        return userBaseService.insert(userBaseBO);
    }

    @RequestMapping(value = "/get/{infoNo}", method = RequestMethod.GET)
    public UserBaseDTO getByInfo(@PathVariable("infoNo") String infoNo) {
        UserBaseBO userBaseBO = userBaseService.getByInfoNo(infoNo);
        UserBaseDTO userBaseDTO = UserBaseConvert.convertBOToDTO(userBaseBO);
        return userBaseDTO;
    }

}
