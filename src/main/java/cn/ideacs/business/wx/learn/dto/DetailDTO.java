package cn.ideacs.business.wx.learn.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

@Data
@Accessors(chain = true)
@ToString
@EqualsAndHashCode(callSuper = false)
public class DetailDTO {

    private LocalDateTime caclTime;

    private String renMinBi;

    private String dollar;

    private Long caclUseTime;

}
