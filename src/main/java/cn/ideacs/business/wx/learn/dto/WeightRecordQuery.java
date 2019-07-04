package cn.ideacs.business.wx.learn.dto;

import lombok.Data;
import lombok.experimental.Accessors;

import java.time.LocalDate;

@Data
@Accessors(chain = true)
public class WeightRecordQuery {

    private String userNo;
    private LocalDate day;
    private Integer page = 0;
    private Integer pageSize = 20;
}
