package com.app.auth.core.controller;

import com.app.auth.util.ProcessDTO;
import com.app.commom.enumerate.AppEnum;
import com.app.commom.result.ProcessResult;
import com.app.commom.util.MD5Util;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import org.slf4j.Logger;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.bind.annotation.RequestMapping;

    import org.springframework.web.bind.annotation.RestController;
    import com.app.commom.controller.IController;
import org.springframework.beans.factory.annotation.Autowired;
import com.app.auth.core.service.AuthUserService;
import com.app.auth.dto.AuthUser;
import io.swagger.annotations.*;

import com.app.commom.logger.LoggerFactory;

/**
 *
 *   @description : AuthUser 控制器
 *   ---------------------------------
 * 	 @author Jang
 *   @since 2019-04-05
 */
@RestController
@Api(value="/authUser", description="AuthUser 控制器")
@RequestMapping("/authUser")
public class AuthUserController extends IController {
private final Logger logger = LoggerFactory.getLogger(AuthUserController.class);

@Autowired
public AuthUserService authUserService;

/**
 * @description : 获取分页列表
 * ---------------------------------
 * @author : Jang
 * @since : Create in 2019-04-05
 */
@GetMapping("/getAuthUserList")
@ApiOperation(value="/getAuthUserList", notes="获取分页列表")
public ProcessResult<AuthUser> getAuthUserList(@ApiParam(name="AuthUser",value="AuthUser 实体类")AuthUser param ,
                                               @ApiParam(name="length",value="页大小",required=true,defaultValue = "10")Integer length,
                                               @ApiParam(name="pageNo",value="页数",required=true,defaultValue = "1")Integer pageNo) {
        ProcessResult<AuthUser> resJson=new ProcessResult<>();

        try {
        Page<AuthUser> page=new Page<AuthUser>(pageNo,length);
    authUserService.selectPage(page, new EntityWrapper<AuthUser>(param));
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
 * @description : 通过id获取AuthUser
 * ---------------------------------
 * @author : Jang
 * @since : Create in 2019-04-05
 */
@GetMapping("/getAuthUserById")
@ApiOperation(value="/getAuthUserById", notes="通过id获取AuthUser")
public ProcessResult<AuthUser> getAuthUserById(@ApiParam(name="id",value="AuthUserID",required=true)Long id) {
        ProcessResult<AuthUser> resJson = new ProcessResult<>();
        try {
    AuthUser param= authUserService.selectById(id);
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
 * @description : 通过id删除AuthUser
 * ---------------------------------
 * @author : Jang
 * @since : Create in 2019-04-05
 */
@PostMapping("/deleteAuthUserById")
@ApiOperation(value="/deleteAuthUserById", notes="通过id删除AuthUser")
public ProcessResult<AuthUser> deleteAuthUserById(@ApiParam(name="id",value="AuthUserID",required=true)Long id) {
        ProcessResult<AuthUser> resJson = new ProcessResult<>();
        try{
        resJson.setRes(authUserService.deleteById(id));
        }catch (Exception e) {
        resJson.setRes(false);
        resJson.setResult("异常信息:"+e.getClass().getName());
        logger.info("异常信息:{}",e.getMessage());
        }
        return resJson;
        }

/**
 * @description : 通过id更新AuthUser
 * ---------------------------------
 * @author : Jang
 * @since : Create in 2019-04-05
 */
@PostMapping("/updateAuthUserById")
@ApiOperation(value="/updateAuthUserById", notes="通过id更新AuthUser")
public ProcessResult<AuthUser> updateAuthUserById(@ApiParam(name="AuthUser",value="AuthUser 实体类")AuthUser param) {
        ProcessResult<AuthUser> resJson = new ProcessResult<>();
        try{
        resJson.setRes(authUserService.updateById(param));
        }catch (Exception e) {
        resJson.setRes(false);
        resJson.setResult("异常信息:"+e.getClass().getName());
        logger.info("异常信息:{}",e.getMessage());
        }
        return resJson;
        }

/**
 * @description : 添加AuthUser
 * ---------------------------------
 * @author : Jang
 * @since : Create in 2019-04-05
 */
@PostMapping("/addAuthUser")
@ResponseBody
@ApiOperation(value="/addAuthUser", notes="添加AuthUser")
public ProcessResult<AuthUser> addAuthUser(@ApiParam(name="AuthUser",value="AuthUser 实体类")AuthUser param) {
        ProcessResult<AuthUser> resJson = new ProcessResult<>();
        //密码加密
    param.setRand(MD5Util.getRand());
    param.setPassword(MD5Util.encoder(param.getPassword(),param.getRand()));
    ProcessDTO.setBaseInfo(param);
    param.setEnableFlg(AppEnum.BaseDTOCode.DEFAULT_NO_FLG.getName());
        try{
        resJson.setRes(authUserService.insert(param));
        }catch (Exception e) {
        resJson.setRes(false);
        resJson.setResult("异常信息:"+e.getClass().getName());
        logger.info("异常信息:{}",e.getMessage());
        }
        return resJson;
        }
        }