package com.app.commom.result;

public class SystemCode {
    /**
     * 请求成功
     */
    public static final int SUCCESS=1;
    /**
     * 请求失败
     */
    public static final int FAILURE = 0;

    /**
     * 用户未登录或登录超时
     */
    public static final int NO_LOGIN = 301;
    /**
     *  用户不存在或密码错误
     */
    public static final int NO_OBJ_ERROR_PASS = 302;
    /**
     * 请求频繁
     */
    public static final int OFTEN = 303;
    /**
     * 参数错误
     */
    public static final int PARAM_ERROR=400;
    /**
     * 内部错误
     */
    public static final int INNER_ERROR=401;
    /**
     * 无此权限
     */
    public static final int NO_PRI=402;
    /**
     * 用户名或密码错误
     */
    public static final int WRONG_PASSWORD=403;
    /**
     * 用户名已存在
     */
    public static final int USER_EXISTS=410;
    /**
     * 对象已存在
     */
    public static final int OBJ_EXISTS=411;
    /**
     * 对象不存在
     */
    public static final int OBJ_NOT_EXISTS=413;

    /**
     * 对象未绑定
     */
    public static final int OBJ_NOT_BIND=414;
    /**
     * 用户名不存在
     */
    public static final int USER_NOT_EXISTS=412;

    /**
     * 手机号已存在
     */
    public static final int PHONE_EXISTS=415;
    /**
     * /**
     * 手机号不存在
     */
    public static final int PHONE_NOT_EXISTS=416;
    /**
     *  传入的参数为null
     */
    public static final int NULL_ARGUMENT=501;
    /**
     * 不合法的参数
     */
    public static final int ILLEGAL_ARGUMENT=502;
    /**
     * 超时
     */
    public static final int TIME_OUT=503;
    /**
     * sign 错误
     */
    public static final int SIGN_ERROR=503;
    /**
     * 没有默认地址
     */
    public static final int RECEIVE_NOT_EXISTS=602;
    /**
     * 是指默认地址失败
     */
    public static final int SET_DEFAULTRECEIVE_FAILURE=603;
    /**
     * 表单操作：保存
     */
    public final static String TYPE_SAVE="SAVE";
    /**
     * 表单操作：更新
     */
    public final static String TYPE_UPDATE="UPDATE";
    //状态：开启
    public final static String STATUS_Y="Y";
    //状态：关闭
    public final static String STATUS_N="N";
    //用户默认头像
    public final static String USERINFO_HEADIMGURL="";
    //文件服务器
    public final static String FILE_SERVICE="FILE_SERVICE";
    public final static String FILE_SERVICE_CON="FILE_SERVICE_CON";
    public final static String FILE_SERVICE_URL="URL";
    public final static String FILE_SERVICE_PORT="PORT";
    public final static String FILE_SERVICE_FILES_PATH="FILES_PATH";
    public final static String FILE_SERVICE_PATH="SERVICE_PATH";
    //Sftp
    public final static String FILE_SFTP_SERVICE_HOST="SFTP_SERVICE_HOST";
    public final static String FILE_SFTP_SERVICE_PORT="SFTP_SERVICE_PORT";
    public final static String FILE_SFTP_USERNAME="SFTP_USERNAME";
    public final static String FILE_SFTP_PASSWORD="SFTP_PASSWORD";

    //分页查询记录数配置
    public final static String PAGE="PAGE";
    public final static String ATT_PAGE="ATT_PAGE";
    public final static String AUT_PAGE="AUT_PAGE";
    public final static String MALL_ATT_PAGE="MALL_ATT_PAGE";
    public final static String MALL_AUT_PAGE="MALL_AUT_PAGE";
    public final static String MALL_ATT_REC_PAGE="MALL_ATT_REC_PAGE";
    public final static String MALL_AUT_REC_PAGE="MALL_AUT_REC_PAGE";
    public final static String GOODS_PAGE="GOODS_PAGE";
    public final static String MALL_GOODS_REC_PAGE="MALL_GOODS_REC_PAGE";
    public final static String MALL_GOODS_SHUF_PAGE="MALL_GOODS_SHUF_PAGE";
    public final static String ORDER_PAGE="ORDER_PAGE";
    public final static String MALL_ORDER_PAGE="MALL_ORDER_PAGE";


    //短信配置
    public final static String SMS="SMS";
    public final static String ACCESSSKEYID="ACCESSSKEYID";
    public final static String ACCESSSKEYSECRET="ACCESSSKEYSECRET";
    public final static String SIGNNAME="SIGNNAME";
    //注册短信模板
    public final static String REGISTERED_TEMPLATECODE="REGISTERED_TEMPLATECODE";
    //校验短信模板
    public final static String VARLIDATE_TEMPLATECODE="VARLIDATE_TEMPLATECODE";

    //文件路径
    public final static String PATH="PATH";
    //微信证书
    public final static String WXSSL="WXSSL";

    /**
     * 订单相关
     */
    public final static String DEV_PC="1";
    public final static String DEV_MOBILE="2";
    public final static String BUSINESS_MALL="0";
    public final static String BUSINESS_AUCTION="1";
    public final static String BUSINESS_SECKILL="2";


    /**
     * 发货单相关
     */
    public final static String INVENTORYDEIVERY_SEQUEANCE="INVENTORYDEIVERY_SEQUEANCE";



}
