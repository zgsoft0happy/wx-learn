package cn.ideacs.business.wx.learn.dao;

import cn.ideacs.business.wx.learn.entity.dos.PerDayOneSentence;

public interface PerDayOneSentenceMapper {

    Long insert(PerDayOneSentence perDayOneSentence);

    PerDayOneSentence getByDay(String day);

    PerDayOneSentence getById(Long id);

    PerDayOneSentence getLastOne();
}
