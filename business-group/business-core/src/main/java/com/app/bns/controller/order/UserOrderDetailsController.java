package com.app.bns.controller.order;

import com.app.commom.result.ProcessResult;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import org.slf4j.Logger;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.bind.annotation.RequestMapping;

    import org.springframework.web.bind.annotation.RestController;
    import com.app.commom.controller.IController;
import org.springframework.beans.factory.annotation.Autowired;
import com.app.bns.service.order.UserOrderDetailsService;
import com.app.bns.dto.order.UserOrderDetails;
import io.swagger.annotations.*;

import com.app.commom.logger.LoggerFactory;

/**
 *
 *   @description : UserOrderDetails 控制器
 *   ---------------------------------
 * 	 @author Jang
 *   @since 2019-04-14
 */
@RestController
@Api(value="/userOrderDetails", description="UserOrderDetails 控制器")
@RequestMapping("/userOrderDetails")
public class UserOrderDetailsController extends IController {
private final Logger logger = LoggerFactory.getLogger(UserOrderDetailsController.class);

@Autowired
public UserOrderDetailsService userOrderDetailsService;

/**
 * @description : 获取分页列表
 * ---------------------------------
 * @author : Jang
 * @since : Create in 2019-04-14
 */
@GetMapping("/getUserOrderDetailsList")
@ApiOperation(value="/getUserOrderDetailsList", notes="获取分页列表")
public ProcessResult<UserOrderDetails> getUserOrderDetailsList(@ApiParam(name="UserOrderDetails",value="UserOrderDetails 实体类")UserOrderDetails param ,
                                                               @ApiParam(name="length",value="页大小",required=true,defaultValue = "10")Integer length,
                                                               @ApiParam(name="pageNo",value="页数",required=true,defaultValue = "1")Integer pageNo) {
        ProcessResult<UserOrderDetails> resJson=new ProcessResult<>();

        try {
        Page<UserOrderDetails> page=new Page<UserOrderDetails>(pageNo,length);
    userOrderDetailsService.selectPage(page, new EntityWrapper<UserOrderDetails>(param));
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
 * @description : 通过id获取UserOrderDetails
 * ---------------------------------
 * @author : Jang
 * @since : Create in 2019-04-14
 */
@GetMapping("/getUserOrderDetailsById")
@ApiOperation(value="/getUserOrderDetailsById", notes="通过id获取UserOrderDetails")
public ProcessResult<UserOrderDetails> getUserOrderDetailsById(@ApiParam(name="id",value="UserOrderDetailsID",required=true)Long id) {
        ProcessResult<UserOrderDetails> resJson = new ProcessResult<>();
        try {
    UserOrderDetails param= userOrderDetailsService.selectById(id);
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
 * @description : 通过id删除UserOrderDetails
 * ---------------------------------
 * @author : Jang
 * @since : Create in 2019-04-14
 */
@PostMapping("/deleteUserOrderDetailsById")
@ApiOperation(value="/deleteUserOrderDetailsById", notes="通过id删除UserOrderDetails")
public ProcessResult<UserOrderDetails> deleteUserOrderDetailsById(@ApiParam(name="id",value="UserOrderDetailsID",required=true)Long id) {
        ProcessResult<UserOrderDetails> resJson = new ProcessResult<>();
        try{
        resJson.setRes(userOrderDetailsService.deleteById(id));
        }catch (Exception e) {
        resJson.setRes(false);
        resJson.setResult("异常信息:"+e.getClass().getName());
        logger.info("异常信息:{}",e.getMessage());
        }
        return resJson;
        }

/**
 * @description : 通过id更新UserOrderDetails
 * ---------------------------------
 * @author : Jang
 * @since : Create in 2019-04-14
 */
@PostMapping("/updateUserOrderDetailsById")
@ApiOperation(value="/updateUserOrderDetailsById", notes="通过id更新UserOrderDetails")
public ProcessResult<UserOrderDetails> updateUserOrderDetailsById(@ApiParam(name="UserOrderDetails",value="UserOrderDetails 实体类")UserOrderDetails param) {
        ProcessResult<UserOrderDetails> resJson = new ProcessResult<>();
        try{
        resJson.setRes(userOrderDetailsService.updateById(param));
        }catch (Exception e) {
        resJson.setRes(false);
        resJson.setResult("异常信息:"+e.getClass().getName());
        logger.info("异常信息:{}",e.getMessage());
        }
        return resJson;
        }

/**
 * @description : 添加UserOrderDetails
 * ---------------------------------
 * @author : Jang
 * @since : Create in 2019-04-14
 */
@PutMapping("/addUserOrderDetails")
@ApiOperation(value="/addUserOrderDetails", notes="添加UserOrderDetails")
public ProcessResult<UserOrderDetails> addUserOrderDetails(@ApiParam(name="UserOrderDetails",value="UserOrderDetails 实体类")UserOrderDetails param) {
        ProcessResult<UserOrderDetails> resJson = new ProcessResult<>();
        try{
        resJson.setRes(userOrderDetailsService.insert(param));
        }catch (Exception e) {
        resJson.setRes(false);
        resJson.setResult("异常信息:"+e.getClass().getName());
        logger.info("异常信息:{}",e.getMessage());
        }
        return resJson;
        }
        }