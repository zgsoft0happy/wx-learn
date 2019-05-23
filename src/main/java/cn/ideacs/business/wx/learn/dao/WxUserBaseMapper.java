package cn.ideacs.business.wx.learn.dao;

import cn.ideacs.business.wx.learn.entity.dtos.WxUserBaseDTO;

public interface WxUserBaseMapper {

    Long insert(WxUserBaseDTO wxUserBaseDTO);

    WxUserBaseDTO getById(Long id);

    WxUserBaseDTO getByWxAccount(String wxAccount);

    void updateByWxAccount(WxUserBaseDTO wxUserBaseDTO);

}
