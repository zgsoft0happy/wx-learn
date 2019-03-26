package cn.ideacs.business.wx.learn.entity.bos;

import cn.ideacs.business.wx.learn.enums.EduEnum;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.util.Date;

@Data
@Accessors(chain = true)
@ToString(callSuper = false)
@EqualsAndHashCode(callSuper = false)
public class UserBaseBO {

    private Long infoNo;
    private String wxAccount;
    private String realName;
    private String nickName;
    private Integer age;
    private EduEnum edu;
    private String hobit;
    private Integer qq;
    private String weixin;
    private String email;
    private Date createTime;
    private Date updateTime;
    private String remark;

}
