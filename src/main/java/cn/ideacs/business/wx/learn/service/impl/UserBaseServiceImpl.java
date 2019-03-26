package cn.ideacs.business.wx.learn.service.impl;

import cn.ideacs.business.wx.learn.converts.UserBaseConvert;
import cn.ideacs.business.wx.learn.dao.UserBaseMapper;
import cn.ideacs.business.wx.learn.entity.bos.UserBaseBO;
import cn.ideacs.business.wx.learn.entity.dos.UserBase;
import cn.ideacs.business.wx.learn.service.UserBaseService;
import cn.ideacs.business.wx.learn.utils.SerialComponent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserBaseServiceImpl implements UserBaseService {

    @Autowired
    private UserBaseMapper userBaseMapper;
    @Autowired
    private SerialComponent serialComponent;

    @Override
    public Long insert(UserBaseBO userBaseBO) {
        UserBase userBase = UserBaseConvert.convertBOToDO(userBaseBO);
        userBase.setInfoNo(serialComponent.nextId());
        userBaseMapper.insert(userBase);
        return userBase.getId();
    }

    @Override
    public UserBaseBO getByInfoNo(String infoNo) {
        UserBase userBase = userBaseMapper.getByInfoNo(infoNo);
        UserBaseBO userBaseBO = UserBaseConvert.convertDOToBo(userBase);
        return userBaseBO;
    }
}
