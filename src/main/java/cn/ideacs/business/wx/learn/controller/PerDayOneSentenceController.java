package cn.ideacs.business.wx.learn.controller;

import cn.ideacs.business.wx.learn.entity.dtos.PerDayOneSentenceDTO;
import cn.ideacs.business.wx.learn.service.PerDayOneSentenceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.time.LocalDate;

@RestController
@Slf4j
@RequestMapping("/per_day/one_sentence")
public class PerDayOneSentenceController {

    @Resource
    private PerDayOneSentenceService perDayOneSentenceService;

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public PerDayOneSentenceDTO get() {
        log.info("获得当前每日一句！");
        return perDayOneSentenceService.getByDay(LocalDate.now());
    }
}
