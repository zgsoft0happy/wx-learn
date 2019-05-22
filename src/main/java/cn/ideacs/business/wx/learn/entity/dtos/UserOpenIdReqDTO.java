package cn.ideacs.business.wx.learn.entity.dtos;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class UserOpenIdReqDTO {

    private String code;
}
