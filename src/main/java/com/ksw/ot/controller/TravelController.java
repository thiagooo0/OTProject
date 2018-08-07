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

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
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

    public String login(String id) {
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
    public PhotoList getPhotos(String latLonId) {
        //得到对应地区的目录
        File placeFile = new File(path + File.separator + latLonId);
        PhotoList photoList = new PhotoList();
        if (placeFile.exists()) {
            File[] photoFlies = placeFile.listFiles();
            if (photoFlies != null) {
                //逐个文件判断是否图片
                for (File f : photoFlies) {
                    if (isPhoto(f.getName()))
                        photoList.add(new Photo(File.separator + latLonId + File.separator + f.getName()));
                    logger.info("file name:" + f.getName());
                }
            }
        }
        return photoList;
    }

    @RequestMapping(value = "/places", method = RequestMethod.POST)
    public Places getPlaces(String userId) {
        //得到资源根目录
        File root = new File(path);
        File[] placeFileList = root.listFiles();
        Places places = new Places();
        int id = 1;
        //逐个地点遍历
        if (placeFileList != null && placeFileList.length > 0) {
            for (File place : placeFileList) {
                if (!place.isDirectory()) {
                    continue;
                }
                try {
                    //读取LatLon.txt文件
                    File latLonFile = new File(place.getPath() + "/LatLon.txt");
                    if (!latLonFile.exists()) {
                        continue;
                    }
                    //读取消息
                    Reader reader = new BufferedReader(new FileReader(latLonFile));
                    String firstLine = ((BufferedReader) reader).readLine();
                    String[] msg = firstLine.split(":");
                    if (msg.length == 2) {
                        LatLon latLon = new LatLon(id++,
                                Float.parseFloat(msg[0]), Float.parseFloat(msg[1]),
                                place.getName());
                        places.add(latLon);
                    }
                } catch (IOException e) {
                    logger.info("getPlaces ERROR:\n" + e);
                    e.printStackTrace();
                }
            }
        }
        logger.info("getPlaces:\n" + places.toString());
        return places;
    }

    private boolean isPhoto(String fileName) {
        String suffix = fileName.substring(fileName.lastIndexOf(".") + 1);
        return "jpg".equals(suffix) || "png".equals(suffix);
    }
}