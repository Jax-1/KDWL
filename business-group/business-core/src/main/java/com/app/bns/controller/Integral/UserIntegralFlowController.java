package com.app.bns.controller.Integral;

import com.app.commom.result.ProcessResult;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import org.slf4j.Logger;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.bind.annotation.RequestMapping;

    import org.springframework.web.bind.annotation.RestController;
    import com.app.commom.controller.IController;
import org.springframework.beans.factory.annotation.Autowired;
import com.app.bns.service.Integral.UserIntegralFlowService;
import com.app.bns.dto.Integral.UserIntegralFlow;
import io.swagger.annotations.*;

import com.app.commom.logger.LoggerFactory;

/**
 *
 *   @description : UserIntegralFlow 控制器
 *   ---------------------------------
 * 	 @author Jang
 *   @since 2019-04-14
 */
@RestController
@Api(value="/userIntegralFlow", description="UserIntegralFlow 控制器")
@RequestMapping("/userIntegralFlow")
public class UserIntegralFlowController extends IController {
private final Logger logger = LoggerFactory.getLogger(UserIntegralFlowController.class);

@Autowired
public UserIntegralFlowService userIntegralFlowService;

/**
 * @description : 获取分页列表
 * ---------------------------------
 * @author : Jang
 * @since : Create in 2019-04-14
 */
@GetMapping("/getUserIntegralFlowList")
@ApiOperation(value="/getUserIntegralFlowList", notes="获取分页列表")
public ProcessResult<UserIntegralFlow> getUserIntegralFlowList(@ApiParam(name="UserIntegralFlow",value="UserIntegralFlow 实体类")UserIntegralFlow param ,
                                                               @ApiParam(name="length",value="页大小",required=true,defaultValue = "10")Integer length,
                                                               @ApiParam(name="pageNo",value="页数",required=true,defaultValue = "1")Integer pageNo) {
        ProcessResult<UserIntegralFlow> resJson=new ProcessResult<>();

        try {
        Page<UserIntegralFlow> page=new Page<UserIntegralFlow>(pageNo,length);
    userIntegralFlowService.selectPage(page, new EntityWrapper<UserIntegralFlow>(param));
        resJson.setRecordsTotal(page.getTotal());
        resJson.setDatas(page.getRecords());
        resJson.setData(param);
        resJson.setRes(true);
        }catch (Exception e){
        resJson.setRes(false);
        resJson.setResult("异常信息:"+e.getClass().getName());
        logger.info("异常信息:{}",e.getMessage());
        }
        return resJson;
        }

/**
 * @description : 通过id获取UserIntegralFlow
 * ---------------------------------
 * @author : Jang
 * @since : Create in 2019-04-14
 */
@GetMapping("/getUserIntegralFlowById")
@ApiOperation(value="/getUserIntegralFlowById", notes="通过id获取UserIntegralFlow")
public ProcessResult<UserIntegralFlow> getUserIntegralFlowById(@ApiParam(name="id",value="UserIntegralFlowID",required=true)Long id) {
        ProcessResult<UserIntegralFlow> resJson = new ProcessResult<>();
        try {
    UserIntegralFlow param= userIntegralFlowService.selectById(id);
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
 * @description : 通过id删除UserIntegralFlow
 * ---------------------------------
 * @author : Jang
 * @since : Create in 2019-04-14
 */
@PostMapping("/deleteUserIntegralFlowById")
@ApiOperation(value="/deleteUserIntegralFlowById", notes="通过id删除UserIntegralFlow")
public ProcessResult<UserIntegralFlow> deleteUserIntegralFlowById(@ApiParam(name="id",value="UserIntegralFlowID",required=true)Long id) {
        ProcessResult<UserIntegralFlow> resJson = new ProcessResult<>();
        try{
        resJson.setRes(userIntegralFlowService.deleteById(id));
        }catch (Exception e) {
        resJson.setRes(false);
        resJson.setResult("异常信息:"+e.getClass().getName());
        logger.info("异常信息:{}",e.getMessage());
        }
        return resJson;
        }

/**
 * @description : 通过id更新UserIntegralFlow
 * ---------------------------------
 * @author : Jang
 * @since : Create in 2019-04-14
 */
@PostMapping("/updateUserIntegralFlowById")
@ApiOperation(value="/updateUserIntegralFlowById", notes="通过id更新UserIntegralFlow")
public ProcessResult<UserIntegralFlow> updateUserIntegralFlowById(@ApiParam(name="UserIntegralFlow",value="UserIntegralFlow 实体类")UserIntegralFlow param) {
        ProcessResult<UserIntegralFlow> resJson = new ProcessResult<>();
        try{
        resJson.setRes(userIntegralFlowService.updateById(param));
        }catch (Exception e) {
        resJson.setRes(false);
        resJson.setResult("异常信息:"+e.getClass().getName());
        logger.info("异常信息:{}",e.getMessage());
        }
        return resJson;
        }

/**
 * @description : 添加UserIntegralFlow
 * ---------------------------------
 * @author : Jang
 * @since : Create in 2019-04-14
 */
@PutMapping("/addUserIntegralFlow")
@ApiOperation(value="/addUserIntegralFlow", notes="添加UserIntegralFlow")
public ProcessResult<UserIntegralFlow> addUserIntegralFlow(@ApiParam(name="UserIntegralFlow",value="UserIntegralFlow 实体类")UserIntegralFlow param) {
        ProcessResult<UserIntegralFlow> resJson = new ProcessResult<>();
        try{
        resJson.setRes(userIntegralFlowService.insert(param));
        }catch (Exception e) {
        resJson.setRes(false);
        resJson.setResult("异常信息:"+e.getClass().getName());
        logger.info("异常信息:{}",e.getMessage());
        }
        return resJson;
        }
        }