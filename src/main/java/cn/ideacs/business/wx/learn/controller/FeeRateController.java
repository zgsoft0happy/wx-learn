package cn.ideacs.business.wx.learn.controller;

import cn.ideacs.business.wx.learn.dto.DetailDTO;
import cn.ideacs.business.wx.learn.dto.DetailQuery;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/fee/rate")
@Slf4j
public class FeeRateController {

    private static final Map<Integer, BigDecimal> rates = new HashMap<>();
    static {
        rates.put(1, new BigDecimal("6.67"));
    }

    @RequestMapping(value = "/tryCacl", method = RequestMethod.POST)
    public DetailDTO tryCacl(@RequestBody DetailQuery detailQuery) {
        Long start = System.currentTimeMillis();
        log.info("请求：{}", detailQuery);
        DetailDTO detailDTO = new DetailDTO()
                .setCaclTime(LocalDateTime.now())
                .setRenMinBi(detailQuery.getRenMinBi())
                .setDollar(new BigDecimal(detailQuery.getRenMinBi()).multiply(rates.get(detailQuery.getBiNo())).toString());
        log.info("结果：{}.\n一共用时：{}", detailDTO, System.currentTimeMillis() - start);
        return detailDTO;
    }

}
