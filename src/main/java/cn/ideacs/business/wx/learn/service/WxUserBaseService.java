package cn.ideacs.business.wx.learn.service;

import cn.ideacs.business.wx.learn.entity.dtos.WxUserBaseDTO;

public interface WxUserBaseService {

    WxUserBaseDTO insert(WxUserBaseDTO wxUserBaseDTO);

    WxUserBaseDTO getByAccount(String wxAccount);
}
