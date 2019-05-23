package cn.ideacs.business.wx.learn.controller;

import cn.ideacs.business.wx.learn.entity.dtos.LocationTraceDTO;
import cn.ideacs.business.wx.learn.service.LocationTraceService;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.time.LocalDateTime;

@RestController
@Slf4j
@RequestMapping("/location")
public class LocationController {

    private static final String DOMAIN =  "https://restapi.amap.com/v3/geocode/regeo?key=f053e3f8fde5b90d286d603663a698f9&radius=500&location=";
    private static final String SEPARATOR = ",";

    @Resource
    private LocationTraceService locationTraceService;

    @RequestMapping(value = "/upload/location", method = RequestMethod.POST)
    public String uploadLocation(@RequestBody LocationTraceDTO locationTraceDTO) {
        String address = getAddress(locationTraceDTO.getLatitude(), locationTraceDTO.getLongitude());
        locationTraceDTO.setAddress(address);
        locationTraceDTO.setCreateTime(LocalDateTime.now());
        locationTraceService.insert(locationTraceDTO);
        return address;
    }


    private String getAddress(String latitude, String longitude) {

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.parseMediaType("application/json; charset=UTF-8"));
        HttpEntity<String> entity = new HttpEntity<>(null, httpHeaders);
        ResponseEntity<JSONObject> response = restTemplate
                .exchange(DOMAIN + longitude + SEPARATOR + latitude, HttpMethod.GET, entity, JSONObject.class);
        return response.getBody().getJSONObject("regeocode").getString("formatted_address");
    }
}
