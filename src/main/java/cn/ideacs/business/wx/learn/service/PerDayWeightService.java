package cn.ideacs.business.wx.learn.service;

import cn.ideacs.business.wx.learn.dto.PerDayWeightDTO;
import cn.ideacs.business.wx.learn.dto.WeightRecordQuery;

import java.util.List;

public interface PerDayWeightService {

    Long insert(PerDayWeightDTO perDayWeightDTO);

    Integer update(PerDayWeightDTO perDayWeightDTO);

    List<PerDayWeightDTO> querByUserNo(WeightRecordQuery weightRecordQuery);

    PerDayWeightDTO queryByUserNoAndDay(WeightRecordQuery weightRecordQuery);
}
