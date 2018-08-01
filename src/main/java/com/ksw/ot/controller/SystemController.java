package com.ksw.ot.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author KwokSiuWang
 * @date 2018/7/30
 */
@Component("SysController")
@RestController
class SystemController {
    @Value("${version}")
    private String version;

    @RequestMapping(value = "/sys", method = RequestMethod.GET)
    public String getMessage(@RequestParam("code") int code) {
        switch (code) {
            case 7600:
                return version;
        }
        return "404";
    }

    //    http://127.0.0.1:8080/request/requestParam2?ownerId=223&a=4&c=5?
    @RequestMapping(value = "/requestParam2", method = RequestMethod.GET)
    public String requestParam2(@RequestParam Map<String, Object> map) {
//      Map<String,Object> map = new HashMap<String,Object>();
//      map.put("ownerId", ownerId);

//    model.addAttribute("map", map);
        return "reqparameter/showInput";
    }
}
