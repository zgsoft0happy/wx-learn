package cn.ideacs.business.wx.learn.entity.dtos;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@Accessors(chain = true)
public class LocationTraceListDTO {

    private List<LocationTraceDTO> list;

    private Long count;

    private Integer currentPage;

    private Integer size;
}
