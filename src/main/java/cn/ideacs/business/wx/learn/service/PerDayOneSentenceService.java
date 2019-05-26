package cn.ideacs.business.wx.learn.service;

import cn.ideacs.business.wx.learn.entity.dtos.PerDayOneSentenceDTO;

import java.time.LocalDate;

public interface PerDayOneSentenceService {

    public Long insert(PerDayOneSentenceDTO perDayOneSentenceDTO);

    public PerDayOneSentenceDTO getByDay(LocalDate date);
}
