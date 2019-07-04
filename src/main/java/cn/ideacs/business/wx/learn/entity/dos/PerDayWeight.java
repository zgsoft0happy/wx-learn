package cn.ideacs.business.wx.learn.entity.dos;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class PerDayWeight {

    /** 主键 */
    private Long id;
    /** 用户编号 */
    private String userNo;
    /** 体重日期 */
    private String day;
    /** 体重 单位g */
    private Integer weight;
    /** 创建时间 */
    private Long createTime;
    /** 更新时间 */
    private Long updateTime;
    /** 备注信息 */
    private String remark;
}
