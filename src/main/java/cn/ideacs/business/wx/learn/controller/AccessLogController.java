package cn.ideacs.business.wx.learn.controller;

import cn.ideacs.business.wx.learn.entity.dos.AccessLog;
import cn.ideacs.business.wx.learn.service.AccessLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/access/log")
public class AccessLogController {

    @Autowired
    private AccessLogService accessLogService;

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public Integer add(String wxAccount) {
        return accessLogService.insert(new AccessLog().setWxAccount(wxAccount));
    }

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public List<AccessLog> getByWxAccount(String wxAccount) {
        return accessLogService.getByWxAccount(wxAccount);
    }

}