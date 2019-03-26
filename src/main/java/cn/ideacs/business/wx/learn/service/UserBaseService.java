package cn.ideacs.business.wx.learn.service;

import cn.ideacs.business.wx.learn.entity.bos.UserBaseBO;

public interface UserBaseService {

    Long insert(UserBaseBO userBaseBO);

    UserBaseBO getByInfoNo(String infoNo);

}
