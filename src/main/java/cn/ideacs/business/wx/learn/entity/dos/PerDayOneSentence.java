package cn.ideacs.business.wx.learn.entity.dos;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class PerDayOneSentence {

    /** 记录ID */
    private Long id;
    /** 语句日期 */
    private String day;
    /** 语句 */
    private String sentence;
    /** 语句作者 */
    private String author;
    /** 语句来源 */
    private String source;
    /** 备注信息 */
    private String remark;
}
