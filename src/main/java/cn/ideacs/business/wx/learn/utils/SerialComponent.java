package cn.ideacs.business.wx.learn.utils;

import org.springframework.stereotype.Component;

@Component
public class SerialComponent {

    private static SnowFlake snowFlake = new SnowFlake(0,0);

    public Long nextId() {
        return snowFlake.nextId();
    }

}
