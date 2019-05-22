package cn.ideacs.business.wx.learn.entity.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class UserOpenIdInfo {

    @JsonProperty("session_key")
    private String sessionKey;

    private String openid;
}
