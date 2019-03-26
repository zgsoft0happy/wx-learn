package cn.ideacs.business.wx.learn.converts;

import cn.ideacs.business.wx.learn.entity.bos.UserBaseBO;
import cn.ideacs.business.wx.learn.entity.dos.UserBase;
import cn.ideacs.business.wx.learn.entity.dtos.UserBaseDTO;
import cn.ideacs.business.wx.learn.enums.EduEnum;
import com.google.common.collect.Lists;

import java.util.Date;
import java.util.List;

public class UserBaseConvert {

    public static UserBaseBO convertDOToBo(UserBase userBase) {
        return new UserBaseBO()
                .setInfoNo(userBase.getInfoNo())
                .setWxAccount(userBase.getWxAccount())
                .setRealName(userBase.getRealName())
                .setNickName(userBase.getNickName())
                .setAge(userBase.getAge())
                .setEdu(EduEnum.findByCode(userBase.getEdu()))
                .setHobit(userBase.getHobit())
                .setQq(userBase.getQq())
                .setWeixin(userBase.getWeixin())
                .setEmail(userBase.getEmail())
                .setCreateTime(new Date(userBase.getCreateTime()))
                .setUpdateTime(new Date(userBase.getUpdateTime()))
                .setRemark(userBase.getRemark());
    }

    public static UserBase convertBOToDO(UserBaseBO userBaseBO) {
        return new UserBase()
                .setInfoNo(userBaseBO.getInfoNo())
                .setWxAccount(userBaseBO.getWxAccount())
                .setRealName(userBaseBO.getRealName())
                .setNickName(userBaseBO.getNickName())
                .setAge(userBaseBO.getAge())
                .setEdu(userBaseBO.getEdu() == null ? 0 : userBaseBO.getEdu().getCode())
                .setHobit(userBaseBO.getHobit())
                .setQq(userBaseBO.getQq())
                .setWeixin(userBaseBO.getWeixin())
                .setEmail(userBaseBO.getEmail())
                .setCreateTime(userBaseBO.getCreateTime() == null ? System.currentTimeMillis() : userBaseBO.getCreateTime().getTime())
                .setUpdateTime(userBaseBO.getUpdateTime() == null ? System.currentTimeMillis() : userBaseBO.getUpdateTime().getTime())
                .setRemark(userBaseBO.getRemark());
    }

    public static List<UserBaseBO> convertDOsToBOs(List<UserBase> userBases) {
        List<UserBaseBO> userBaseBOS = Lists.newArrayList();
        if (userBases != null && !userBases.isEmpty()) {
            for (UserBase userBase : userBases) {
                userBaseBOS.add(convertDOToBo(userBase));
            }
        }
        return userBaseBOS;
    }


    public static UserBaseBO convertDTOToBO(UserBaseDTO userBaseDTO) {
        return new UserBaseBO()
                .setInfoNo(userBaseDTO.getInfoNo())
                .setWxAccount(userBaseDTO.getWxAccount())
                .setRealName(userBaseDTO.getRealName())
                .setNickName(userBaseDTO.getNickName())
                .setAge(userBaseDTO.getAge())
                .setEdu(EduEnum.findByCode(userBaseDTO.getEdu()))
                .setHobit(userBaseDTO.getHobit())
                .setQq(userBaseDTO.getQq())
                .setWeixin(userBaseDTO.getWeixin())
                .setEmail(userBaseDTO.getEmail())
                .setCreateTime(userBaseDTO.getCreateTime() == null ? new Date() : userBaseDTO.getCreateTime())
                .setUpdateTime(userBaseDTO.getUpdateTime() == null ? new Date() : userBaseDTO.getUpdateTime())
                .setRemark(userBaseDTO.getRemark());
    }

    public static UserBaseDTO convertBOToDTO(UserBaseBO userBaseBO) {
        return new UserBaseDTO()
                .setInfoNo(userBaseBO.getInfoNo())
                .setWxAccount(userBaseBO.getWxAccount())
                .setRealName(userBaseBO.getRealName())
                .setNickName(userBaseBO.getNickName())
                .setAge(userBaseBO.getAge())
                .setEdu(userBaseBO.getEdu().getCode())
                .setHobit(userBaseBO.getHobit())
                .setQq(userBaseBO.getQq())
                .setWeixin(userBaseBO.getWeixin())
                .setEmail(userBaseBO.getEmail())
                .setCreateTime(userBaseBO.getCreateTime())
                .setUpdateTime(userBaseBO.getUpdateTime())
                .setRemark(userBaseBO.getRemark());
    }

}
