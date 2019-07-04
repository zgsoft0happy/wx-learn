package cn.ideacs.business.wx.learn.service.impl;

import cn.ideacs.business.wx.learn.converts.PerDayWeightConvert;
import cn.ideacs.business.wx.learn.dao.PerDayWeightMapper;
import cn.ideacs.business.wx.learn.dto.PerDayWeightDTO;
import cn.ideacs.business.wx.learn.dto.WeightRecordQuery;
import cn.ideacs.business.wx.learn.entity.dos.PerDayWeight;
import cn.ideacs.business.wx.learn.service.PerDayWeightService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
@Slf4j
public class PerDayWeightServiceImpl implements PerDayWeightService {

    @Autowired
    private PerDayWeightMapper perDayWeightMapper;

    @Override
    public Long insert(PerDayWeightDTO perDayWeightDTO) {
        perDayWeightDTO.setCreateTime(LocalDateTime.now())
                .setUpdateTime(LocalDateTime.now())
                .setDay(LocalDate.now());
        PerDayWeight perDayWeight = PerDayWeightConvert.convertDTOToDO(perDayWeightDTO);
        perDayWeightMapper.insert(perDayWeight);
        return perDayWeightMapper.queryByUserNoAndDate(perDayWeight.getUserNo(), perDayWeight.getDay()).getId();
    }

    @Override
    public Integer update(PerDayWeightDTO perDayWeightDTO) {
        perDayWeightDTO.setUpdateTime(LocalDateTime.now());
        PerDayWeight perDayWeight = PerDayWeightConvert.convertDTOToDO(perDayWeightDTO);
        return perDayWeightMapper.update(perDayWeight);
    }

    @Override
    public List<PerDayWeightDTO> querByUserNo(WeightRecordQuery weightRecordQuery) {
        return PerDayWeightConvert.convertDOsToDTOs(
                perDayWeightMapper.queryByUserNo(
                        weightRecordQuery.getUserNo(),
                        (weightRecordQuery.getPage() - 1) * weightRecordQuery.getPageSize(),
                        weightRecordQuery.getPageSize()
                )
        );
    }

    @Override
    public PerDayWeightDTO queryByUserNoAndDay(WeightRecordQuery weightRecordQuery) {
        return PerDayWeightConvert.convertDOToDTO(perDayWeightMapper.queryByUserNoAndDate(weightRecordQuery.getUserNo(), weightRecordQuery.getDay().toString()));
    }
}
