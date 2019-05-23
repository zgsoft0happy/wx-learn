package cn.ideacs.business.wx.learn.service;

import cn.ideacs.business.wx.learn.entity.dtos.LocationTraceDTO;

import java.util.List;

public interface LocationTraceService {

    Boolean insert(LocationTraceDTO locationTraceDTO);

    List<LocationTraceDTO> getByWxAccount(String wxAccount);

}
