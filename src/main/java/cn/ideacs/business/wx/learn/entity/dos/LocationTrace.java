package cn.ideacs.business.wx.learn.entity.dos;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class LocationTrace {

    private Long id;

    private String wxAccount;

    private String latitude;

    private String longitude;

    private String address;

    private Long createTime;

    private Integer type;

}
