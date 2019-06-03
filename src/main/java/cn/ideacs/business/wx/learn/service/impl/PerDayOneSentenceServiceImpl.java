package cn.ideacs.business.wx.learn.service.impl;

import cn.ideacs.business.wx.learn.dao.PerDayOneSentenceMapper;
import cn.ideacs.business.wx.learn.entity.dos.PerDayOneSentence;
import cn.ideacs.business.wx.learn.entity.dtos.PerDayOneSentenceDTO;
import cn.ideacs.business.wx.learn.service.PerDayOneSentenceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDate;

@Service
@Slf4j
public class PerDayOneSentenceServiceImpl implements PerDayOneSentenceService {

    @Resource
    private PerDayOneSentenceMapper perDayOneSentenceMapper;

    @Override
    public Long insert(PerDayOneSentenceDTO perDayOneSentenceDTO) {
        PerDayOneSentence perDayOneSentence = new PerDayOneSentence();
        BeanUtils.copyProperties(perDayOneSentenceDTO, perDayOneSentence);
        perDayOneSentence.setDay(perDayOneSentenceDTO.getDay().toString());
        perDayOneSentenceMapper.insert(perDayOneSentence);
        return perDayOneSentence.getId();
    }

    /**
     * 获得当日的每日一句
     * 当数据库中不存在当日一句的时候，就可以获得最近的一条。
     * @param date
     * @return
     */
    @Override
    public PerDayOneSentenceDTO getByDay(LocalDate date) {
        PerDayOneSentence perDayOneSentence = perDayOneSentenceMapper.getByDay(date.toString());
        PerDayOneSentenceDTO perDayOneSentenceDTO = new PerDayOneSentenceDTO();
        if (perDayOneSentence == null) {
            perDayOneSentence = perDayOneSentenceMapper.getLastOne();
            perDayOneSentence.setDay(LocalDate.now().toString());
        }
        BeanUtils.copyProperties(perDayOneSentence, perDayOneSentenceDTO);
        perDayOneSentenceDTO.setDay(LocalDate.parse(perDayOneSentence.getDay()));
        return perDayOneSentenceDTO;
    }


}
