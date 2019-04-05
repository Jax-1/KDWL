package com.app.commom.enumerate;

/**
 * @Class AppEnum
 * @Author zhangjie
 * @Description //TODO
 * @Date 2019/4/5 17:51
 * @Version 1.0
 **/
public interface AppEnum {
    enum BaseDTOCode{
        //是否已删除
        DEFAULT_YES_FLG("1"),
        DEFAULT_NO_FLG("0");
        private String name;

        BaseDTOCode(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }
}
