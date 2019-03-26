package cn.ideacs.business.wx.learn.dao;

import cn.ideacs.business.wx.learn.entity.dos.UserBase;

public interface UserBaseMapper {

    Integer insert(UserBase userBase);

    UserBase getByInfoNo(String infoNo);

}
