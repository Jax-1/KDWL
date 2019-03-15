package com.kdwl.invoice.controller;

import org.springframework.web.bind.annotation.*;

import org.springframework.web.bind.annotation.RequestMapping;

    import org.springframework.web.bind.annotation.RestController;
import com.kdwl.core.include.controller.IController;
import org.springframework.beans.factory.annotation.Autowired;
import com.kdwl.invoice.service.ActivityService;
import com.kdwl.invoice.entity.Activity;
import io.swagger.annotations.*;
import com.kdwl.core.include.result.ProcessResult;
import com.baomidou.mybatisplus.plugins.Page;

import com.kdwl.core.include.logger.LoggerFactory;
import org.slf4j.Logger;

/**
 *　　
 *   @description : Activity 控制器
 *   ---------------------------------
 * 	 @author Jang
 *   @since 2019-03-14
 */
@RestController
@Api(value="/activity", description="Activity 控制器")
@RequestMapping("/activity")
public class ActivityController extends IController {
    private final Logger logger = LoggerFactory.getLogger(ActivityController.class);

    @Autowired
    public ActivityService activityService;

    /**
     * @description : 获取分页列表
     * ---------------------------------
     * @author : Jang
     * @since : Create in 2019-03-14
     */
    @GetMapping("/getActivityList")
    @ApiOperation(value="/getActivityList", notes="获取分页列表")
    public ProcessResult<Activity> getActivityList(@ApiParam(name="Activity",value="Activity 实体类")Activity param ,
                                @ApiParam(name="length",value="页大小",required=true,defaultValue = "10")Integer length,
                                @ApiParam(name="pageNo",value="页数",required=true,defaultValue = "1")Integer pageNo) {
            ProcessResult<Activity> resJson=new ProcessResult<>();
            System.out.println("==========："+param.getCreatedBy());
//            try {
                Page<Activity> page=new Page<Activity>(pageNo,length);
                activityService.selectPage(page, param.getPageWrapper());
                resJson.setRecordsTotal(page.getTotal());
                resJson.setDatas(page.getRecords());
                resJson.setRes(true);
//            }catch (Exception e){
//                resJson.setRes(false);
//                resJson.setResult("异常信息:"+e.getClass().getName());
//                logger.info("异常信息:{}",e.getMessage());
//            }
            return resJson;
    }

    /**
     * @description : 通过id获取Activity
     * ---------------------------------
     * @author : Jang
     * @since : Create in 2019-03-14
     */
    @GetMapping("/getActivityById")
    @ApiOperation(value="/getActivityById", notes="通过id获取Activity")
    public ProcessResult<Activity> getActivityById(@ApiParam(name="id",value="ActivityID",required=true)Long id) {
            ProcessResult<Activity> resJson = new ProcessResult<>();
            try {
                Activity param= activityService.selectById(id);
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
     * @description : 通过id删除Activity
     * ---------------------------------
     * @author : Jang
     * @since : Create in 2019-03-14
     */
    @DeleteMapping("/deleteActivityById")
    @ApiOperation(value="/deleteActivityById", notes="通过id删除Activity")
    public ProcessResult<Activity> deleteActivityById(@ApiParam(name="id",value="ActivityID",required=true)Long id) {
            ProcessResult<Activity> resJson = new ProcessResult<>();
            try{
                resJson.setRes(activityService.deleteById(id));
            }catch (Exception e) {
                resJson.setRes(false);
                resJson.setResult("异常信息:"+e.getClass().getName());
                logger.info("异常信息:{}",e.getMessage());
            }
            return resJson;
    }

    /**
     * @description : 通过id更新Activity
     * ---------------------------------
     * @author : Jang
     * @since : Create in 2019-03-14
     */
    @PutMapping("/updateActivityById")
    @ApiOperation(value="/updateActivityById", notes="通过id更新Activity")
    public ProcessResult<Activity> updateActivityById(@ApiParam(name="Activity",value="Activity 实体类")Activity param) {
            ProcessResult<Activity> resJson = new ProcessResult<>();
            try{
                resJson.setRes(activityService.updateById(param));
            }catch (Exception e) {
                resJson.setRes(false);
                resJson.setResult("异常信息:"+e.getClass().getName());
                logger.info("异常信息:{}",e.getMessage());
            }
            return resJson;
    }

    /**
     * @description : 添加Activity
     * ---------------------------------
     * @author : Jang
     * @since : Create in 2019-03-14
     */
	@PutMapping("/addActivity")
    @ApiOperation(value="/addActivity", notes="添加Activity")
    public ProcessResult<Activity> addActivity(@ApiParam(name="Activity",value="Activity 实体类")Activity param) {
            ProcessResult<Activity> resJson = new ProcessResult<>();
            try{
                resJson.setRes(activityService.insert(param));
            }catch (Exception e) {
                resJson.setRes(false);
                resJson.setResult("异常信息:"+e.getClass().getName());
                logger.info("异常信息:{}",e.getMessage());
            }
            return resJson;
    }
}
