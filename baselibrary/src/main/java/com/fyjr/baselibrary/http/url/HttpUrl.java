package com.fyjr.baselibrary.http.url;

/**
 * Created by QNapex on 2016/12/4.
 * 接口地址
 */

public class HttpUrl {

    /**
     * 线上服务器
     */
    public static String BASE_URL = "http://www.shijiupindao.com/";

    /**
     * 测试服务器
     */
//    public static String BASE_URL = "http://192.168.0.17:8080/";

    /**
     * 登录
     */
    public static String LOGIN = "clubApp/login";

    /**
     * 修改资料
     */
    public static String UPDATEDATA = "clubApp/clubuser/update";
    /**
     * 添加视频个人动态
     */
    public static String ADDVIDEODYNAMIC = "clubApp/userdynamic/addVideoDynamic";
    /**
     * 添加图文个人动态
     */
    public static String ADDDYNAMIC = "clubApp/userdynamic/addDynamic";
    /**
     * 添加文本个人动态
     */
    public static String ADDTEXTDYNAMIC = "clubApp/userdynamic/addTextDynamic";
    /**
     * 最新版本
     */
    public static String GETVERSION = "clubApp/system/getVersion";
}
