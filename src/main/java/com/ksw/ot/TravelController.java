package com.ksw.ot;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author KwokSiuWang
 * @date 2018/7/27
 */

@RestController
@RequestMapping("/travel")
class TravelController {

    @RequestMapping("/location")
    public String getLocations() {
        return "123.3433|32.34234";
    }

    @RequestMapping(params = "getAd")
    public String getAD(String userInfo, String name) {
        return userInfo + "+" + name;
    }
}
