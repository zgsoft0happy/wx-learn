package cn.ideacs.business.wx.learn.service.impl;

import cn.ideacs.business.wx.learn.dao.LocationTraceMapper;
import cn.ideacs.business.wx.learn.entity.dos.LocationTrace;
import cn.ideacs.business.wx.learn.entity.dtos.LocationTraceDTO;
import cn.ideacs.business.wx.learn.entity.dtos.LocationTraceListDTO;
import cn.ideacs.business.wx.learn.entity.dtos.LocationTraceReqDTO;
import cn.ideacs.business.wx.learn.service.LocationTraceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class LocationTraceServiceImpl implements LocationTraceService {

    @Resource
    private LocationTraceMapper locationTraceMapper;

    @Override
    public Boolean insert(LocationTraceDTO locationTraceDTO) {
        if (locationTraceDTO == null) {
            return false;
        }
        LocationTrace locationTrace = new LocationTrace()
                .setAddress(locationTraceDTO.getAddress())
                .setCreateTime(locationTraceDTO.getCreateTime().toEpochSecond(ZoneOffset.of("+8")))
                .setLatitude(locationTraceDTO.getLatitude())
                .setLongitude(locationTraceDTO.getLongitude())
                .setType(locationTraceDTO.getType())
                .setWxAccount(locationTraceDTO.getWxAccount());
        locationTraceMapper.insert(locationTrace);
        return true;
    }

    @Override
    public LocationTraceListDTO getList(LocationTraceReqDTO locationTraceReqDTO) {
        List<LocationTraceDTO> list = locationTraceMapper.getByWxAccount(locationTraceReqDTO)
                .stream()
                .map(this::convertDOToDTO)
                .collect(Collectors.toList());
        Long count = locationTraceMapper.countByWxAccount(locationTraceReqDTO.getWxAccount());
        return new LocationTraceListDTO()
                .setList(list)
                .setCount(count)
                .setCurrentPage(locationTraceReqDTO.getPage())
                .setSize(list.size());
    }

    private LocationTraceDTO convertDOToDTO(LocationTrace locationTrace) {
        return new LocationTraceDTO()
                .setAddress(locationTrace.getAddress())
                .setCreateTime(LocalDateTime.ofInstant(Instant.ofEpochMilli(locationTrace.getCreateTime() * 1000), ZoneId.systemDefault()))
                .setLatitude(locationTrace.getLatitude())
                .setLongitude(locationTrace.getLongitude())
                .setAddress(locationTrace.getAddress())
                .setType(locationTrace.getType())
                .setWxAccount(locationTrace.getWxAccount());
    }
}
