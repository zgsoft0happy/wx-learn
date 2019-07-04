package cn.ideacs.business.wx.learn.controller;

import cn.ideacs.business.wx.learn.dto.PerDayWeightDTO;
import cn.ideacs.business.wx.learn.dto.WeightRecordQuery;
import cn.ideacs.business.wx.learn.service.PerDayWeightService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/per_day/weight")
@Slf4j
public class PerDayWeightController {

    @Autowired
    private PerDayWeightService perDayWeightService;

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public Long save(@RequestBody PerDayWeightDTO perDayWeightDTO) {
        WeightRecordQuery weightRecordQuery = new WeightRecordQuery()
                .setUserNo(perDayWeightDTO.getUserId())
                .setDay(LocalDate.now());
        PerDayWeightDTO old = perDayWeightService.queryByUserNoAndDay(weightRecordQuery);
        if (old == null) {
            return perDayWeightService.insert(perDayWeightDTO);
        } else {
            perDayWeightDTO.setId(old.getId());
            return perDayWeightService.update(perDayWeightDTO).longValue();
        }
    }

    @RequestMapping(value = "/query_by_user_no", method = RequestMethod.POST)
    public List<PerDayWeightDTO> queryByUserNo(@RequestBody WeightRecordQuery weightRecordQuery) {
        return perDayWeightService.querByUserNo(weightRecordQuery);
    }

    @RequestMapping(value = "/query_current_day", method = RequestMethod.POST)
    public PerDayWeightDTO queryCurrentDay(@RequestBody WeightRecordQuery weightRecordQuery) {
        weightRecordQuery.setDay(LocalDate.now());
        return perDayWeightService.queryByUserNoAndDay(weightRecordQuery);
    }
}
