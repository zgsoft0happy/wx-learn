package cn.ideacs.business.wx.learn.entity.dos;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
public class UserBase {

    private Long id;
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
    private Long createTime;
    private Long updateTime;
    private String remark;

}
