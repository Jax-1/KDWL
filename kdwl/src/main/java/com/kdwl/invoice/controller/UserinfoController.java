package com.kdwl.invoice.controller;

import org.springframework.web.bind.annotation.*;

import org.springframework.web.bind.annotation.RequestMapping;

    import org.springframework.web.bind.annotation.RestController;
import com.kdwl.core.include.controller.IController;
import org.springframework.beans.factory.annotation.Autowired;
import com.kdwl.invoice.service.UserinfoService;
import com.kdwl.invoice.entity.Userinfo;
import io.swagger.annotations.*;
import com.kdwl.core.include.result.ProcessResult;
import com.baomidou.mybatisplus.plugins.Page;

import com.kdwl.core.include.logger.LoggerFactory;
import org.slf4j.Logger;

/**
 *　　
 *   @description : Userinfo 控制器
 *   ---------------------------------
 * 	 @author Jang
 *   @since 2019-03-14
 */
@RestController
@Api(value="/userinfo", description="Userinfo 控制器")
@RequestMapping("/userinfo")
public class UserinfoController extends IController {
    private final Logger logger = LoggerFactory.getLogger(UserinfoController.class);

    @Autowired
    public UserinfoService userinfoService;

    /**
     * @description : 获取分页列表
     * ---------------------------------
     * @author : Jang
     * @since : Create in 2019-03-14
     */
    @GetMapping("/getUserinfoList")
    @ApiOperation(value="/getUserinfoList", notes="获取分页列表")
    public ProcessResult<Userinfo> getUserinfoList(@ApiParam(name="Userinfo",value="Userinfo 实体类")Userinfo param ,
                                @ApiParam(name="length",value="页大小",required=true,defaultValue = "10")Integer length,
                                @ApiParam(name="pageNo",value="页数",required=true,defaultValue = "1")Integer pageNo) {
            ProcessResult<Userinfo> resJson=new ProcessResult<>();

            try {
                Page<Userinfo> page=new Page<Userinfo>(pageNo,length);
                userinfoService.selectPage(page, param.getPageWrapper());
                resJson.setRecordsTotal(page.getTotal());
                resJson.setDatas(page.getRecords());
                resJson.setRes(true);
            }catch (Exception e){
                resJson.setRes(false);
                resJson.setResult("异常信息:"+e.getClass().getName());
                logger.info("异常信息:{}",e.getMessage());
            }
            return resJson;
    }

    /**
     * @description : 通过id获取Userinfo
     * ---------------------------------
     * @author : Jang
     * @since : Create in 2019-03-14
     */
    @GetMapping("/getUserinfoById")
    @ApiOperation(value="/getUserinfoById", notes="通过id获取Userinfo")
    public ProcessResult<Userinfo> getUserinfoById(@ApiParam(name="id",value="UserinfoID",required=true)Long id) {
            ProcessResult<Userinfo> resJson = new ProcessResult<>();
            try {
                Userinfo param= userinfoService.selectById(id);
                resJson.setData(param);
                resJson.setRes(true);
            }catch (Exception e) {
                resJson.setRes(false);
                resJson.setResult("异常信息:"+e.getClass().getName());
                logger.info("异常信息:{}",e.getMessage());
            }
            return resJson;
    }

    /**
     * @description : 通过id删除Userinfo
     * ---------------------------------
     * @author : Jang
     * @since : Create in 2019-03-14
     */
    @DeleteMapping("/deleteUserinfoById")
    @ApiOperation(value="/deleteUserinfoById", notes="通过id删除Userinfo")
    public ProcessResult<Userinfo> deleteUserinfoById(@ApiParam(name="id",value="UserinfoID",required=true)Long id) {
            ProcessResult<Userinfo> resJson = new ProcessResult<>();
            try{
                resJson.setRes(userinfoService.deleteById(id));
            }catch (Exception e) {
                resJson.setRes(false);
                resJson.setResult("异常信息:"+e.getClass().getName());
                logger.info("异常信息:{}",e.getMessage());
            }
            return resJson;
    }

    /**
     * @description : 通过id更新Userinfo
     * ---------------------------------
     * @author : Jang
     * @since : Create in 2019-03-14
     */
    @PutMapping("/updateUserinfoById")
    @ApiOperation(value="/updateUserinfoById", notes="通过id更新Userinfo")
    public ProcessResult<Userinfo> updateUserinfoById(@ApiParam(name="Userinfo",value="Userinfo 实体类")Userinfo param) {
            ProcessResult<Userinfo> resJson = new ProcessResult<>();
            try{
                resJson.setRes(userinfoService.updateById(param));
            }catch (Exception e) {
                resJson.setRes(false);
                resJson.setResult("异常信息:"+e.getClass().getName());
                logger.info("异常信息:{}",e.getMessage());
            }
            return resJson;
    }

    /**
     * @description : 添加Userinfo
     * ---------------------------------
     * @author : Jang
     * @since : Create in 2019-03-14
     */
	@PutMapping("/addUserinfo")
    @ApiOperation(value="/addUserinfo", notes="添加Userinfo")
    public ProcessResult<Userinfo> addUserinfo(@ApiParam(name="Userinfo",value="Userinfo 实体类")Userinfo param) {
            ProcessResult<Userinfo> resJson = new ProcessResult<>();
            try{
                resJson.setRes(userinfoService.insert(param));
            }catch (Exception e) {
                resJson.setRes(false);
                resJson.setResult("异常信息:"+e.getClass().getName());
                logger.info("异常信息:{}",e.getMessage());
            }
            return resJson;
    }
}
