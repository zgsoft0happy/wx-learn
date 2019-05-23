package cn.ideacs.business.wx.learn.service.impl;

import cn.ideacs.business.wx.learn.dao.LocationTraceMapper;
import cn.ideacs.business.wx.learn.entity.dos.LocationTrace;
import cn.ideacs.business.wx.learn.entity.dtos.LocationTraceDTO;
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
    public List<LocationTraceDTO> getByWxAccount(String wxAccount) {

        return locationTraceMapper.getByWxAccount(wxAccount)
                .stream()
                .map(t -> {
                    return new LocationTraceDTO()
                            .setAddress(t.getAddress())
                            .setCreateTime(LocalDateTime.ofInstant(Instant.ofEpochMilli(t.getCreateTime()), ZoneId.systemDefault()))
                            .setLatitude(t.getLatitude())
                            .setLongitude(t.getLongitude())
                            .setAddress(t.getAddress())
                            .setType(t.getType())
                            .setWxAccount(wxAccount);
                }).collect(Collectors.toList());
    }
}
