package cn.ideacs.business.wx.learn.service;

import cn.ideacs.business.wx.learn.entity.dtos.LocationTraceDTO;
import cn.ideacs.business.wx.learn.entity.dtos.LocationTraceListDTO;
import cn.ideacs.business.wx.learn.entity.dtos.LocationTraceReqDTO;

public interface LocationTraceService {

    Boolean insert(LocationTraceDTO locationTraceDTO);

    LocationTraceListDTO getList(LocationTraceReqDTO locationTraceReqDTO);

}
