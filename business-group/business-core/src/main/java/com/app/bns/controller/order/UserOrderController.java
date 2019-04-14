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
import com.app.bns.service.order.UserOrderService;
import com.app.bns.dto.order.UserOrder;
import io.swagger.annotations.*;

import com.app.commom.logger.LoggerFactory;

/**
 *
 *   @description : UserOrder 控制器
 *   ---------------------------------
 * 	 @author Jang
 *   @since 2019-04-14
 */
@RestController
@Api(value="/userOrder", description="UserOrder 控制器")
@RequestMapping("/userOrder")
public class UserOrderController extends IController {
private final Logger logger = LoggerFactory.getLogger(UserOrderController.class);

@Autowired
public UserOrderService userOrderService;

/**
 * @description : 获取分页列表
 * ---------------------------------
 * @author : Jang
 * @since : Create in 2019-04-14
 */
@GetMapping("/getUserOrderList")
@ApiOperation(value="/getUserOrderList", notes="获取分页列表")
public ProcessResult<UserOrder> getUserOrderList(@ApiParam(name="UserOrder",value="UserOrder 实体类")UserOrder param ,
                                                 @ApiParam(name="length",value="页大小",required=true,defaultValue = "10")Integer length,
                                                 @ApiParam(name="pageNo",value="页数",required=true,defaultValue = "1")Integer pageNo) {
        ProcessResult<UserOrder> resJson=new ProcessResult<>();

        try {
        Page<UserOrder> page=new Page<UserOrder>(pageNo,length);
    userOrderService.selectPage(page, new EntityWrapper<UserOrder>(param));
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
 * @description : 通过id获取UserOrder
 * ---------------------------------
 * @author : Jang
 * @since : Create in 2019-04-14
 */
@GetMapping("/getUserOrderById")
@ApiOperation(value="/getUserOrderById", notes="通过id获取UserOrder")
public ProcessResult<UserOrder> getUserOrderById(@ApiParam(name="id",value="UserOrderID",required=true)Long id) {
        ProcessResult<UserOrder> resJson = new ProcessResult<>();
        try {
    UserOrder param= userOrderService.selectById(id);
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
 * @description : 通过id删除UserOrder
 * ---------------------------------
 * @author : Jang
 * @since : Create in 2019-04-14
 */
@PostMapping("/deleteUserOrderById")
@ApiOperation(value="/deleteUserOrderById", notes="通过id删除UserOrder")
public ProcessResult<UserOrder> deleteUserOrderById(@ApiParam(name="id",value="UserOrderID",required=true)Long id) {
        ProcessResult<UserOrder> resJson = new ProcessResult<>();
        try{
        resJson.setRes(userOrderService.deleteById(id));
        }catch (Exception e) {
        resJson.setRes(false);
        resJson.setResult("异常信息:"+e.getClass().getName());
        logger.info("异常信息:{}",e.getMessage());
        }
        return resJson;
        }

/**
 * @description : 通过id更新UserOrder
 * ---------------------------------
 * @author : Jang
 * @since : Create in 2019-04-14
 */
@PostMapping("/updateUserOrderById")
@ApiOperation(value="/updateUserOrderById", notes="通过id更新UserOrder")
public ProcessResult<UserOrder> updateUserOrderById(@ApiParam(name="UserOrder",value="UserOrder 实体类")UserOrder param) {
        ProcessResult<UserOrder> resJson = new ProcessResult<>();
        try{
        resJson.setRes(userOrderService.updateById(param));
        }catch (Exception e) {
        resJson.setRes(false);
        resJson.setResult("异常信息:"+e.getClass().getName());
        logger.info("异常信息:{}",e.getMessage());
        }
        return resJson;
        }

/**
 * @description : 添加UserOrder
 * ---------------------------------
 * @author : Jang
 * @since : Create in 2019-04-14
 */
@PutMapping("/addUserOrder")
@ApiOperation(value="/addUserOrder", notes="添加UserOrder")
public ProcessResult<UserOrder> addUserOrder(@ApiParam(name="UserOrder",value="UserOrder 实体类")UserOrder param) {
        ProcessResult<UserOrder> resJson = new ProcessResult<>();
        try{
        resJson.setRes(userOrderService.insert(param));
        }catch (Exception e) {
        resJson.setRes(false);
        resJson.setResult("异常信息:"+e.getClass().getName());
        logger.info("异常信息:{}",e.getMessage());
        }
        return resJson;
        }
        }