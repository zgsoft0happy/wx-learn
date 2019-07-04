package cn.ideacs.business.wx.learn.dao;

import cn.ideacs.business.wx.learn.entity.dos.PerDayWeight;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PerDayWeightMapper {

    Long insert(PerDayWeight perDayWeight);

    Integer update(PerDayWeight perDayWeight);

    List<PerDayWeight> queryByUserNo(@Param("userNo") String userNo,
                                     @Param("offset") Integer offset,
                                     @Param("pageSize") Integer pageSize);

    PerDayWeight queryByUserNoAndDate(@Param("userNo") String userNo,
                                      @Param("day")String day);
}
