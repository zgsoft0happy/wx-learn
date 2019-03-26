package cn.ideacs.business.wx.learn.enums;

import lombok.Getter;

import java.util.Arrays;

@Getter
public enum EduEnum {
    UN_KNOWN(0, "未知")
    ,PRESCHOOL(1, "学前")
    ,PRIMARY_SCHOOL(2, "小学")
    ,JUNIOR_HIGH_SCHOOL(3, "初中")
    ,SENIOR_HIGH_SCHOOL(4, "高中")
    ,BACHELOR(5, "本科")
    ,MASTER(6, "硕士")
    ,DOCTOR(7, "博士")
    ,SECONDARY(8, "中专")
    ,SPECIALIST(9, "专科")
    ,Audlt_EDU(10, "成人")
    ,OTHERS(11, "其他")

    ;
    private Integer code;
    private String name;

    EduEnum(Integer code, String name) {
        this.code = code;
        this.name = name;
    }

    public static EduEnum findByCode(Integer code) {
        return Arrays.stream(EduEnum.values())
                .filter(t -> t.code.equals(code))
                .findFirst()
                .orElse(null);
    }
}
