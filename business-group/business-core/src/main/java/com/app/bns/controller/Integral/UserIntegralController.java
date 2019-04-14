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
import com.app.bns.service.Integral.UserIntegralService;
import com.app.bns.dto.Integral.UserIntegral;
import io.swagger.annotations.*;

import com.app.commom.logger.LoggerFactory;

/**
 *
 *   @description : UserIntegral 控制器
 *   ---------------------------------
 * 	 @author Jang
 *   @since 2019-04-14
 */
@RestController
@Api(value="/userIntegral", description="UserIntegral 控制器")
@RequestMapping("/userIntegral")
public class UserIntegralController extends IController {
private final Logger logger = LoggerFactory.getLogger(UserIntegralController.class);

@Autowired
public UserIntegralService userIntegralService;

/**
 * @description : 获取分页列表
 * ---------------------------------
 * @author : Jang
 * @since : Create in 2019-04-14
 */
@GetMapping("/getUserIntegralList")
@ApiOperation(value="/getUserIntegralList", notes="获取分页列表")
public ProcessResult<UserIntegral> getUserIntegralList(@ApiParam(name="UserIntegral",value="UserIntegral 实体类")UserIntegral param ,
                                                       @ApiParam(name="length",value="页大小",required=true,defaultValue = "10")Integer length,
                                                       @ApiParam(name="pageNo",value="页数",required=true,defaultValue = "1")Integer pageNo) {
        ProcessResult<UserIntegral> resJson=new ProcessResult<>();

        try {
        Page<UserIntegral> page=new Page<UserIntegral>(pageNo,length);
    userIntegralService.selectPage(page, new EntityWrapper<UserIntegral>(param));
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
 * @description : 通过id获取UserIntegral
 * ---------------------------------
 * @author : Jang
 * @since : Create in 2019-04-14
 */
@GetMapping("/getUserIntegralById")
@ApiOperation(value="/getUserIntegralById", notes="通过id获取UserIntegral")
public ProcessResult<UserIntegral> getUserIntegralById(@ApiParam(name="id",value="UserIntegralID",required=true)Long id) {
        ProcessResult<UserIntegral> resJson = new ProcessResult<>();
        try {
    UserIntegral param= userIntegralService.selectById(id);
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
 * @description : 通过id删除UserIntegral
 * ---------------------------------
 * @author : Jang
 * @since : Create in 2019-04-14
 */
@PostMapping("/deleteUserIntegralById")
@ApiOperation(value="/deleteUserIntegralById", notes="通过id删除UserIntegral")
public ProcessResult<UserIntegral> deleteUserIntegralById(@ApiParam(name="id",value="UserIntegralID",required=true)Long id) {
        ProcessResult<UserIntegral> resJson = new ProcessResult<>();
        try{
        resJson.setRes(userIntegralService.deleteById(id));
        }catch (Exception e) {
        resJson.setRes(false);
        resJson.setResult("异常信息:"+e.getClass().getName());
        logger.info("异常信息:{}",e.getMessage());
        }
        return resJson;
        }

/**
 * @description : 通过id更新UserIntegral
 * ---------------------------------
 * @author : Jang
 * @since : Create in 2019-04-14
 */
@PostMapping("/updateUserIntegralById")
@ApiOperation(value="/updateUserIntegralById", notes="通过id更新UserIntegral")
public ProcessResult<UserIntegral> updateUserIntegralById(@ApiParam(name="UserIntegral",value="UserIntegral 实体类")UserIntegral param) {
        ProcessResult<UserIntegral> resJson = new ProcessResult<>();
        try{
        resJson.setRes(userIntegralService.updateById(param));
        }catch (Exception e) {
        resJson.setRes(false);
        resJson.setResult("异常信息:"+e.getClass().getName());
        logger.info("异常信息:{}",e.getMessage());
        }
        return resJson;
        }

/**
 * @description : 添加UserIntegral
 * ---------------------------------
 * @author : Jang
 * @since : Create in 2019-04-14
 */
@PutMapping("/addUserIntegral")
@ApiOperation(value="/addUserIntegral", notes="添加UserIntegral")
public ProcessResult<UserIntegral> addUserIntegral(@ApiParam(name="UserIntegral",value="UserIntegral 实体类")UserIntegral param) {
        ProcessResult<UserIntegral> resJson = new ProcessResult<>();
        try{
        resJson.setRes(userIntegralService.insert(param));
        }catch (Exception e) {
        resJson.setRes(false);
        resJson.setResult("异常信息:"+e.getClass().getName());
        logger.info("异常信息:{}",e.getMessage());
        }
        return resJson;
        }
        }