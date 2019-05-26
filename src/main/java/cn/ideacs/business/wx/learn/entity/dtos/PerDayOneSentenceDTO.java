package cn.ideacs.business.wx.learn.entity.dtos;


import lombok.Data;
import lombok.experimental.Accessors;

import java.time.LocalDate;

@Data
@Accessors(chain = true)
public class PerDayOneSentenceDTO {

    /** 语句日期 */
    private LocalDate day;
    /** 语句 */
    private String sentence;
    /** 语句作者 */
    private String author;
    /** 语句来源 */
    private String source;
}
