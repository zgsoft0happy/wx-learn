package cn.ideacs.business.wx.learn.dto;

import lombok.Data;
import lombok.experimental.Accessors;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Accessors(chain = true)
public class PerDayWeightDTO {

    /** 主键 */
    private Long id;
    /** 用户编号 */
    private String userId;
    /** 体重日期 */
    private LocalDate day;
    /** 体重 单位kg */
    private BigDecimal weight;
    /** 创建时间 */
    private LocalDateTime createTime;
    /** 更新时间 */
    private LocalDateTime updateTime;
    /** 备注信息 */
    private String remark;
}
