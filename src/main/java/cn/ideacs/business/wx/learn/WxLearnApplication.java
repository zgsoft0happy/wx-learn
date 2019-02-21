package cn.ideacs.business.wx.learn;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = {"cn.ideacs.business.wx.learn.dao"})
public class WxLearnApplication {

    public static void main(String[] args) {
        SpringApplication.run(WxLearnApplication.class, args);
    }

}

