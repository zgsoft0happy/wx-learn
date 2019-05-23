package cn.ideacs.business.wx.learn.entity.dtos;

import lombok.Data;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

@Data
@Accessors(chain = true)
public class WxUserBaseDTO {

    /** 记录编号 */
    private Long infoNo;
    /** 微信openId */
    private String wxAccount;
    /** 微信昵称 */
    private String nickName;
    /** 性别。 1男，2女 */
    private Integer gender;
    /** 用户使用微信语言 */
    private String language;
    /** 用户国家 */
    private String country;
    /** 用户省份 */
    private String province;
    /** 用户城市 */
    private String city;
    /** 创建时间，第一次加入的时间 */
    private LocalDateTime createTime;

}
