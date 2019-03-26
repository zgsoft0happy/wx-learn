package cn.ideacs.business.wx.learn.entity.dtos;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.util.Date;

@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
public class UserBaseDTO {

    private Long infoNo;
    private String wxAccount;
    private String realName;
    private String nickName;
    private Integer age;
    private Integer edu;
    private String hobit;
    private Integer qq;
    private String weixin;
    private String email;
    private Date createTime;
    private Date updateTime;
    private String remark;

}
