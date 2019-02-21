package cn.ideacs.business.wx.learn.service;

import cn.ideacs.business.wx.learn.entity.AccessLog;

import java.util.List;

public interface AccessLogService {

    Integer insert(AccessLog accessLog);

    List<AccessLog> getByWxAccount(String wxAccount);
}
