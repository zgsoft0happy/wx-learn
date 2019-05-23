package cn.ideacs.business.wx.learn.controller;

import cn.ideacs.business.wx.learn.converts.UserBaseConvert;
import cn.ideacs.business.wx.learn.dao.WxUserBaseMapper;
import cn.ideacs.business.wx.learn.entity.bos.UserBaseBO;
import cn.ideacs.business.wx.learn.entity.dtos.UserBaseDTO;
import cn.ideacs.business.wx.learn.entity.dtos.UserOpenIdInfo;
import cn.ideacs.business.wx.learn.entity.dtos.UserOpenIdReqDTO;
import cn.ideacs.business.wx.learn.entity.dtos.WxUserBaseDTO;
import cn.ideacs.business.wx.learn.service.UserBaseService;
import cn.ideacs.business.wx.learn.service.WxUserBaseService;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
@RequestMapping("/user/base")
@Slf4j
public class UserBaseController {

    private final String url =
            "https://api.weixin.qq.com/sns/jscode2session?appid=wx906e30f0d2dccb9a"
                    + "&secret=edc85aac1266d298fde2acbaf58d64a1&grant_type=authorization_code"
                    + "&js_code=";


    @Resource
    private UserBaseService userBaseService;
    @Resource
    private WxUserBaseService wxUserBaseService;

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

    @RequestMapping(value = "/get/openid", method = RequestMethod.POST)
    public UserOpenIdInfo getOpenId(@RequestBody UserOpenIdReqDTO userOpenIdReqDTO) {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.parseMediaType("application/json; charset=UTF-8"));
        HttpEntity<String> entity = new HttpEntity<>(null, httpHeaders);
        ResponseEntity<String> userOpenIdInfo = restTemplate
                .exchange(url + userOpenIdReqDTO.getCode(), HttpMethod.GET, entity, String.class);
        log.info("{}", userOpenIdInfo);
        UserOpenIdInfo info = JSON.parseObject(userOpenIdInfo.getBody(), UserOpenIdInfo.class);
        return info;
    }

    @RequestMapping(value = "/add/wx/user", method = RequestMethod.POST)
    public Boolean addWxAccount(@RequestBody WxUserBaseDTO wxUserBaseDTO) {
        log.info("addWxAccount ： {}", wxUserBaseDTO);
        WxUserBaseDTO old = wxUserBaseService.getByAccount(wxUserBaseDTO.getWxAccount());
        if (old == null) {
            wxUserBaseService.insert(wxUserBaseDTO);
        }
        return true;
    }

}
