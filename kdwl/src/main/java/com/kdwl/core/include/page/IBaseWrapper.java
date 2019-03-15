package com.kdwl.core.include.page;
import com.kdwl.core.include.basic.IBaseBean;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.kdwl.core.include.logger.LoggerFactory;
import org.slf4j.Logger;

import java.lang.reflect.Field;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class IBaseWrapper<T> extends Wrapper<T> {
    private static Map<WhereTypeEnum, WhereFun> typeFunc;
    private final Logger logger = LoggerFactory.getLogger(IBaseWrapper.class);

    static {
        if (typeFunc == null) {
            typeFunc = new HashMap<>();
            typeFunc.put(WhereTypeEnum.EQ, (w, k, v) -> {
                w.eq(k, v);
            });
            typeFunc.put(WhereTypeEnum.NEQ, (w, k, v) -> {
                w.ne(k, v);
            });
            typeFunc.put(WhereTypeEnum.IN, (w, k, v) -> {
                if (v instanceof Collection) {
                    w.in(k, (Collection<?>) v);
                } else if (v instanceof Object[]) {
                    w.in(k, (Object[]) v);
                } else {
                    w.in(k, v.toString());
                }
            });
            typeFunc.put(WhereTypeEnum.LIKE, (w, k, v) -> {
                w.like(k, v.toString());
            });
            typeFunc.put(WhereTypeEnum.LE, (w, k, v) -> {
                w.le(k, v);
            });
            typeFunc.put(WhereTypeEnum.LT, (w, k, v) -> {
                w.lt(k, v);
            });
            typeFunc.put(WhereTypeEnum.GE, (w, k, v) -> {
                w.ge(k, v);
            });
            typeFunc.put(WhereTypeEnum.GT, (w, k, v) -> {
                w.gt(k, v);
            });
        }
    }

    public  EntityWrapper entityWrapper;

    public IBaseWrapper(){
        super();
    }
    public IBaseWrapper(T entity){
        super();
        EntityWrapper ew=new EntityWrapper();
        ew.setEntity(entity);
        this.entityWrapper=ew;
    }

    public  String getSqlSegment(){
        return null;
    }
    public Wrapper<T> execute(){

        T entity =(T)entityWrapper.getEntity();
        logger.info("===========构建SQL："+entity.getClass()+"==========");
//        Field[] fields=entity.getClass().getDeclaredFields();
        entityWrapper.where("deleted = {0}",0);//全局条件，0“未删除
//        for (Field field: fields) {//反射获取字段信息


//            field.setAccessible(true);
//            try {

//                Object value=field.get(entity);
//                if (value != null && !"".equals(value.toString())) {
//
//                    TableField tableField=field.getAnnotation(TableField.class);
//                    WhereType whereType=field.getAnnotation(WhereType.class);
//                    if (tableField == null) {
//                        if (whereType == null) {
//                            typeFunc.get(WhereTypeEnum.EQ).whereFunc(entityWrapper, field.getName(), value);
//                        }else{
//                            typeFunc.get(whereType).whereFunc(entityWrapper, field.getName(), value);
//                        }
//                    }else{
//                        if (whereType == null) {
//                            typeFunc.get(WhereTypeEnum.EQ).whereFunc(entityWrapper,tableField.value(), value);
//                        }else{
//                            typeFunc.get(whereType).whereFunc(entityWrapper, tableField.value(), value);
//                        }
//
//                    }
//                    System.out.println("构建条件："+field.getName()+"---"+value);
//                    logger.info("构建条件："+field.getName()+"---"+value);
//                }
////            }catch (Exception e){
////                e.printStackTrace();
////            }


//        }
        return entityWrapper;
    }

}
