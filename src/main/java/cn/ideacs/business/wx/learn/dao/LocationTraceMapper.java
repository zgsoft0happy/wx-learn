package cn.ideacs.business.wx.learn.dao;

import cn.ideacs.business.wx.learn.entity.dos.LocationTrace;
import cn.ideacs.business.wx.learn.entity.dtos.LocationTraceReqDTO;

import java.util.List;

public interface LocationTraceMapper {

    int insert(LocationTrace locationTrace);

    LocationTrace getById(Long id);

    List<LocationTrace> getByWxAccount(LocationTraceReqDTO locationTraceReqDTO);

    Long countByWxAccount(String wxAccount);

}
