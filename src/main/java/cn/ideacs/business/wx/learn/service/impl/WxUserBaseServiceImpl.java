package cn.ideacs.business.wx.learn.service.impl;

import cn.ideacs.business.wx.learn.dao.WxUserBaseMapper;
import cn.ideacs.business.wx.learn.entity.dtos.WxUserBaseDTO;
import cn.ideacs.business.wx.learn.service.WxUserBaseService;
import cn.ideacs.business.wx.learn.utils.SerialComponent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
@Slf4j
public class WxUserBaseServiceImpl implements WxUserBaseService {

    @Resource
    private SerialComponent serialComponent;

    @Resource
    private WxUserBaseMapper wxUserBaseMapper;

    @Override
    public WxUserBaseDTO insert(WxUserBaseDTO wxUserBaseDTO) {
        wxUserBaseDTO.setInfoNo(serialComponent.nextId());
        Long id = wxUserBaseMapper.insert(wxUserBaseDTO);
        return wxUserBaseMapper.getById(id);
    }

    @Override
    public WxUserBaseDTO getByAccount(String wxAccount) {
        if (wxAccount == null || "".equals(wxAccount)) {
            return null;
        }
        return wxUserBaseMapper.getByWxAccount(wxAccount);
    }
}
