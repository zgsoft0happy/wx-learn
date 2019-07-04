package cn.ideacs.business.wx.learn.converts;

import cn.ideacs.business.wx.learn.dto.PerDayWeightDTO;
import cn.ideacs.business.wx.learn.entity.dos.PerDayWeight;
import org.springframework.util.CollectionUtils;

import java.math.BigDecimal;
import java.time.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PerDayWeightConvert {

    public static PerDayWeight convertDTOToDO(PerDayWeightDTO perDayWeightDTO) {
        if (perDayWeightDTO == null) {
            return null;
        }
        return new PerDayWeight()
                .setCreateTime(perDayWeightDTO.getCreateTime().toEpochSecond(ZoneOffset.of("+8")))
                .setDay(perDayWeightDTO.getDay().toString())
                .setId(perDayWeightDTO.getId())
                .setRemark(perDayWeightDTO.getRemark())
                .setUpdateTime(perDayWeightDTO.getUpdateTime().toEpochSecond(ZoneOffset.of("+8")))
                .setUserNo(perDayWeightDTO.getUserId())
                .setWeight(perDayWeightDTO.getWeight().multiply(new BigDecimal(1000)).intValue());
    }

    public static PerDayWeightDTO convertDOToDTO(PerDayWeight perDayWeight) {
        if (perDayWeight == null) {
            return null;
        }
        return new PerDayWeightDTO()
                .setCreateTime(LocalDateTime.ofInstant(Instant.ofEpochMilli(perDayWeight.getCreateTime()), ZoneId.systemDefault()))
                .setDay(LocalDate.parse(perDayWeight.getDay()))
                .setId(perDayWeight.getId())
                .setRemark(perDayWeight.getRemark())
                .setUpdateTime(LocalDateTime.ofInstant(Instant.ofEpochMilli(perDayWeight.getUpdateTime()), ZoneId.systemDefault()))
                .setUserId(perDayWeight.getUserNo())
                .setWeight(new BigDecimal(perDayWeight.getWeight()).divide(new BigDecimal(1000)));
    }

    public static List<PerDayWeightDTO> convertDOsToDTOs(List<PerDayWeight> list) {
        if (CollectionUtils.isEmpty(list)) {
            return new ArrayList<>();
        }
        return list.stream()
                .map(PerDayWeightConvert::convertDOToDTO)
                .collect(Collectors.toList());
    }
}
