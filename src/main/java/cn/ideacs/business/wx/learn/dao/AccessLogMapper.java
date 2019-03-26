package cn.ideacs.business.wx.learn.dao;

import cn.ideacs.business.wx.learn.entity.dos.AccessLog;

import java.util.List;

public interface AccessLogMapper {

    public Integer insert(AccessLog accessLog);

    public List<AccessLog> getByWxAccount(String wxAccount);

}
