package cn.ideacs.business.wx.learn.entity.dtos;

import lombok.Data;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

@Data
@Accessors(chain = true)
public class LocationTraceDTO {

    private String wxAccount;

    private String latitude;

    private String longitude;

    private String address;

    private LocalDateTime createTime;

    /**
     * 上报类型，1主动上报，2自动上报
     */
    private Integer type;
}
