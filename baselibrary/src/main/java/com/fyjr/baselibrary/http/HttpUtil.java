package com.fyjr.baselibrary.http;


import android.text.TextUtils;

import com.fyjr.baselibrary.http.url.HttpUrl;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Callback;

/**
 * Created by QNapex on 2016/12/5.
 * 网络请求
 */

public class HttpUtil {

    private RetrofitInstance retrofitInstance;

    private HttpUtil() {
        retrofitInstance = RetrofitInstance.getInstance();
    }

    public static HttpUtil getInstance() {
        return HttpUtilHolder.HTTP_UTIL;
    }

    private static class HttpUtilHolder {
        private static final HttpUtil HTTP_UTIL = new HttpUtil();
    }

    private String token;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    /**
     * post请求
     *
     * @param path
     * @param map
     * @param callBack
     */
    private void doPost(String path, Map map, Callback callBack) {
        if (TextUtils.isEmpty(token)) {
            retrofitInstance.post(path, map, callBack);
        } else {
            retrofitInstance.postWithToken(path, token, map, callBack);
        }
    }


    /**
     * get请求
     *
     * @param path
     * @param callBack
     */
    private void doGet(String path, Callback callBack) {
        retrofitInstance.get(path, callBack);
    }

    /**
     * 登录
     *
     * @param callBack
     */
    public void login(String userName, String passWord, String deviceCode, String nickName, String headUrl, int loginType, Callback callBack) {
        Map<String, Object> map = new HashMap<>();
        map.put("userName", userName);
        map.put("passWord", passWord);
        map.put("deviceCode", deviceCode);
        map.put("nickName", nickName);
        map.put("headUrl", headUrl);
        map.put("loginType", loginType);
        doPost(HttpUrl.LOGIN, map, callBack);
    }



    /**
     * 上传用户信息
     *
     * @param img      用户头像
     * @param userId   用户ID
     * @param nickName 昵称
     * @param remarks  个性签名
     * @param province 所在省
     * @param city     所在市
     * @param birthday 生日
     * @param callback
     */
    public void updateData(File img, String userId, String nickName, String remarks, String province, String city, String birthday
            , String favoriteCuisine, String favoriteDrink, String favoriteEatPlace, String appetite, String drinker, Callback callback) {
        try {
            RequestBody rheadImg = null, ruserId = null, rnickName = null, rremarks = null, rprovince = null, rcity = null, rbirthday = null, rfavoriteCuisine = null, rfavoriteDrink = null, rfavoriteEatPlace = null, rappetite = null, rdrinker = null;
            if (img != null) {
                rheadImg = RequestBody.create(MediaType.parse("image/jpg"), img);
            }
            if (!TextUtils.isEmpty(userId)) {
                ruserId = RequestBody.create(MediaType.parse("text/plain"), userId);
            }
            if (!TextUtils.isEmpty(nickName)) {
                rnickName = RequestBody.create(MediaType.parse("text/plain"), nickName);
            }
            if (!TextUtils.isEmpty(remarks)) {
                rremarks = RequestBody.create(MediaType.parse("text/plain"), remarks);
            }
            if (!TextUtils.isEmpty(province)) {
                rprovince = RequestBody.create(MediaType.parse("text/plain"), province);
            }
            if (!TextUtils.isEmpty(city)) {
                rcity = RequestBody.create(MediaType.parse("text/plain"), city);
            }
            if (!TextUtils.isEmpty(birthday)) {
                rbirthday = RequestBody.create(MediaType.parse("text/plain"), birthday);
            }
            if (!TextUtils.isEmpty(favoriteCuisine)) {
                rfavoriteCuisine = RequestBody.create(MediaType.parse("text/plain"), favoriteCuisine);
            }
            if (!TextUtils.isEmpty(favoriteDrink)) {
                rfavoriteDrink = RequestBody.create(MediaType.parse("text/plain"), favoriteDrink);
            }
            if (!TextUtils.isEmpty(favoriteEatPlace)) {
                rfavoriteEatPlace = RequestBody.create(MediaType.parse("text/plain"), favoriteEatPlace);
            }
            if (!TextUtils.isEmpty(appetite)) {
                rappetite = RequestBody.create(MediaType.parse("text/plain"), appetite);
            }
            if (!TextUtils.isEmpty(drinker)) {
                rdrinker = RequestBody.create(MediaType.parse("text/plain"), drinker);
            }
            retrofitInstance.updateData(HttpUrl.UPDATEDATA, rheadImg, ruserId, rnickName, rremarks,
                    rprovince, rcity, rbirthday, rfavoriteCuisine, rfavoriteDrink, rfavoriteEatPlace, rappetite, rdrinker, callback);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    /**
     * 添加视频个人动态
     *
     * @param photo     预览图
     * @param video     视频文件
     * @param type      1纯文字/2图片/3视频
     * @param context   文本内容
     * @param longitude 经度
     * @param latitude  纬度
     * @param address   地址
     * @param callback
     */
    public void publishVideo(File photo, File video, String type, String context, String longitude, String latitude, String address, Callback callback) {
        try {
            RequestBody rbPhoto = null, rbVideo = null, rbtype = null, rbContext = null, rbLongitude = null, rbLatitude = null, rbAddress = null;
            if (photo != null) {
                rbPhoto = RequestBody.create(MediaType.parse("image/jpg"), photo);
            }
            if (video != null) {
                rbVideo = RequestBody.create(MediaType.parse("video/mp4"), video);
            }
            if (!TextUtils.isEmpty(type)) {
                rbtype = RequestBody.create(MediaType.parse("text/plain"), type);
            }
            if (!TextUtils.isEmpty(context)) {
                rbContext = RequestBody.create(MediaType.parse("text/plain"), context);
            }
            if (!TextUtils.isEmpty(longitude)) {
                rbLongitude = RequestBody.create(MediaType.parse("text/plain"), longitude);
            }
            if (!TextUtils.isEmpty(latitude)) {
                rbLatitude = RequestBody.create(MediaType.parse("text/plain"), latitude);
            }
            if (!TextUtils.isEmpty(address)) {
                rbAddress = RequestBody.create(MediaType.parse("text/plain"), address);
            }
            retrofitInstance.publishVideo(HttpUrl.ADDVIDEODYNAMIC, token, rbPhoto, rbVideo, rbtype, rbContext, rbLongitude, rbLatitude, rbAddress, callback);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * 添加图文个人动态
     *
     * @param imges     图片集合
     * @param type      1纯文字/2图片/3视频
     * @param context   文本内容
     * @param longitude 经度
     * @param latitude  纬度
     * @param address   地址
     * @param callback
     */
    public void publishImages(ArrayList<File> imges, String type, String context, String longitude, String latitude, String address, Callback callback) {
        try {
            RequestBody rbtype = null, rbContext = null, rbLongitude = null, rbLatitude = null, rbAddress = null;
            Map<String, RequestBody> mImages = new HashMap<>();
            for (int i = 0; i < imges.size(); i++) {
                mImages.put("photo" + i + "\"; filename=\"" + imges.get(i).getName(), RequestBody.create(MediaType.parse("image/jpg"), imges.get(i)));
            }
            if (!TextUtils.isEmpty(type)) {
                rbtype = RequestBody.create(MediaType.parse("text/plain"), type);
            }
            if (!TextUtils.isEmpty(context)) {
                rbContext = RequestBody.create(MediaType.parse("text/plain"), context);
            }
            if (!TextUtils.isEmpty(longitude)) {
                rbLongitude = RequestBody.create(MediaType.parse("text/plain"), longitude);
            }
            if (!TextUtils.isEmpty(latitude)) {
                rbLatitude = RequestBody.create(MediaType.parse("text/plain"), latitude);
            }
            if (!TextUtils.isEmpty(address)) {
                rbAddress = RequestBody.create(MediaType.parse("text/plain"), address);
            }
            retrofitInstance.publishImages(HttpUrl.ADDDYNAMIC, token, mImages, rbtype, rbContext, rbLongitude, rbLatitude, rbAddress, callback);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * 添加文本动态
     *
     * @param type
     * @param context
     * @param longitude
     * @param latitude
     * @param address
     * @param callback
     */
    public void publishText(String type, String context, String longitude, String latitude, String address, Callback callback) {
        try {
            RequestBody rbtype = null, rbContext = null, rbLongitude = null, rbLatitude = null, rbAddress = null;
            if (!TextUtils.isEmpty(type)) {
                rbtype = RequestBody.create(MediaType.parse("text/plain"), type);
            }
            if (!TextUtils.isEmpty(context)) {
                rbContext = RequestBody.create(MediaType.parse("text/plain"), context);
            }
            if (!TextUtils.isEmpty(longitude)) {
                rbLongitude = RequestBody.create(MediaType.parse("text/plain"), longitude);
            }
            if (!TextUtils.isEmpty(latitude)) {
                rbLatitude = RequestBody.create(MediaType.parse("text/plain"), latitude);
            }
            if (!TextUtils.isEmpty(address)) {
                rbAddress = RequestBody.create(MediaType.parse("text/plain"), address);
            }
            retrofitInstance.publishText(HttpUrl.ADDTEXTDYNAMIC, token, rbtype, rbContext, rbLongitude, rbLatitude, rbAddress, callback);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * 最新版本
     *
     * @param callBack
     */
    public void checkVersion(Callback callBack) {
        Map<String, Object> map = new HashMap<>();
        doPost(HttpUrl.GETVERSION, map, callBack);
    }
}
