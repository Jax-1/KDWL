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
        DEFAULT_YES_FLG(true),
        DEFAULT_NO_FLG(false);
        private Boolean name;

        BaseDTOCode(Boolean name) {
            this.name = name;
        }

        public Boolean getName() {
            return name;
        }
    }

}
