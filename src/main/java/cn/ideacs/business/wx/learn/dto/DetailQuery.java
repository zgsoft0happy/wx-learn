package cn.ideacs.business.wx.learn.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@ToString
@EqualsAndHashCode(callSuper = false)
public class DetailQuery {

    private String renMinBi;
    /** 币种编号 */
    private Integer biNo;

}
