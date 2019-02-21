package cn.ideacs.business.wx.learn.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.util.Date;

@Data
@ToString
@Accessors(chain = true)
@EqualsAndHashCode
public class AccessLog {

    private Integer id;
    private String wxAccount;
    private Date accessTime;
}
