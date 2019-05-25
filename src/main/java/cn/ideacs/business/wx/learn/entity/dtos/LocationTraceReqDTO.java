package cn.ideacs.business.wx.learn.entity.dtos;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class LocationTraceReqDTO {

    private String wxAccount;

    private Integer page;

    private Integer pageSize = 10;
}
