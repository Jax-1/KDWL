package com.app.commom.util;

import java.util.UUID;

/**
 * @Class UUIDUtil
 * @Author zhangjie
 * @Description //生成UUID
 * @Date 2019/4/5 17:43
 * @Version 1.0
 **/
public class UUIDUtil {
    public static String getUUID(){
        return UUID.randomUUID().toString().replace("-", "");
    }
}
