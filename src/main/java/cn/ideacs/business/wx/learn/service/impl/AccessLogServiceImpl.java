package cn.ideacs.business.wx.learn.service.impl;

import cn.ideacs.business.wx.learn.dao.AccessLogMapper;
import cn.ideacs.business.wx.learn.entity.AccessLog;
import cn.ideacs.business.wx.learn.service.AccessLogService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Data
@Service
public class AccessLogServiceImpl implements AccessLogService {

    @Autowired
    private AccessLogMapper accessLogMapper;

    @Override
    public Integer insert(AccessLog accessLog) {
        accessLog.setAccessTime(new Date());
        accessLogMapper.insert(accessLog);
        return accessLog.getId();
    }

    @Override
    public List<AccessLog> getByWxAccount(String wxAccount) {
        return accessLogMapper.getByWxAccount(wxAccount);
    }
}
