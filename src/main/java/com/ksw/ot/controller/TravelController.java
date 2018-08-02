package com.ksw.ot.controller;

import com.ksw.ot.entity.LatLon;
import com.ksw.ot.entity.Photo;
import com.ksw.ot.entity.PhotoList;
import com.ksw.ot.entity.Places;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * @author KwokSiuWang
 * @date 2018/7/27
 */

@RestController
@RequestMapping("/travel")
class TravelController {
    private Logger logger = LoggerFactory.getLogger(getClass().getName());

    private List<String> userList = new ArrayList<>();

    @Value("${web.upload-path}")
    private String path;

    /**
     * 登陆
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@ModelAttribute String id) {
        if (id != null && !userList.contains(id)) {
            userList.add(id);
        }
        logger.info("login : " + id);
        return "success";
    }

//    @RequestMapping("/location")
//    public String getLocations() {
//        return "123.3433|32.34234";
//    }
//
//    @RequestMapping(params = "getAd")
//    public String getAD(String userInfo, String name) {
//        return userInfo + "+" + name;
//    }

    @RequestMapping(value = "/photos", method = RequestMethod.POST)
    public PhotoList getPhotos(@ModelAttribute String latLonId) {
        File file = new File(path);
        PhotoList photoList = new PhotoList();
        if (file.isDirectory()) {
            File[] fileList = file.listFiles();
            if (fileList != null) {
                for (File f : fileList) {
                    photoList.add(new Photo(f.getName()));
                    logger.info("file name:" + f.getName());
                }
            }
        }
        return photoList;
    }

    @RequestMapping(value = "/places", method = RequestMethod.POST)
    public Places getPlaces(@ModelAttribute String userId) {
        Places places = new Places();
        places.add(new LatLon(1, (float) 123.3433, (float) 32.34234));
        places.add(new LatLon(2, (float) 123.3733, (float) 32.37234));
        places.add(new LatLon(3, (float) 123.3133, (float) 32.39234));
        logger.info("getPlaces:\n" + places.toString());
        return places;
    }
}
