package com.app.base.page;

import com.baomidou.mybatisplus.mapper.Wrapper;

public interface WhereFun {
    void whereFunc(Wrapper wrapper, String field, Object vaule);
}
