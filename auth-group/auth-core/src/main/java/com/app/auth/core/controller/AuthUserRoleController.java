package com.app.auth.core.controller;

import com.app.commom.result.ProcessResult;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import org.slf4j.Logger;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.bind.annotation.RequestMapping;

    import org.springframework.web.bind.annotation.RestController;
    import com.app.commom.controller.IController;
import org.springframework.beans.factory.annotation.Autowired;
import com.app.auth.core.service.AuthUserRoleService;
import com.app.auth.dto.AuthUserRole;
import io.swagger.annotations.*;

import com.app.commom.logger.LoggerFactory;

/**
 *
 *   @description : AuthUserRole 控制器
 *   ---------------------------------
 * 	 @author Jang
 *   @since 2019-04-05
 */
@RestController
@Api(value="/authUserRole", description="AuthUserRole 控制器")
@RequestMapping("/authUserRole")
public class AuthUserRoleController extends IController {
private final Logger logger = LoggerFactory.getLogger(AuthUserRoleController.class);

@Autowired
public AuthUserRoleService authUserRoleService;

/**
 * @description : 获取分页列表
 * ---------------------------------
 * @author : Jang
 * @since : Create in 2019-04-05
 */
@GetMapping("/getAuthUserRoleList")
@ApiOperation(value="/getAuthUserRoleList", notes="获取分页列表")
public ProcessResult<AuthUserRole> getAuthUserRoleList(@ApiParam(name="AuthUserRole",value="AuthUserRole 实体类")AuthUserRole param ,
                                                       @ApiParam(name="length",value="页大小",required=true,defaultValue = "10")Integer length,
                                                       @ApiParam(name="pageNo",value="页数",required=true,defaultValue = "1")Integer pageNo) {
        ProcessResult<AuthUserRole> resJson=new ProcessResult<>();

        try {
        Page<AuthUserRole> page=new Page<AuthUserRole>(pageNo,length);
    authUserRoleService.selectPage(page, new EntityWrapper<AuthUserRole>(param));
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
 * @description : 通过id获取AuthUserRole
 * ---------------------------------
 * @author : Jang
 * @since : Create in 2019-04-05
 */
@GetMapping("/getAuthUserRoleById")
@ApiOperation(value="/getAuthUserRoleById", notes="通过id获取AuthUserRole")
public ProcessResult<AuthUserRole> getAuthUserRoleById(@ApiParam(name="id",value="AuthUserRoleID",required=true)Long id) {
        ProcessResult<AuthUserRole> resJson = new ProcessResult<>();
        try {
    AuthUserRole param= authUserRoleService.selectById(id);
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
 * @description : 通过id删除AuthUserRole
 * ---------------------------------
 * @author : Jang
 * @since : Create in 2019-04-05
 */
@DeleteMapping("/deleteAuthUserRoleById")
@ApiOperation(value="/deleteAuthUserRoleById", notes="通过id删除AuthUserRole")
public ProcessResult<AuthUserRole> deleteAuthUserRoleById(@ApiParam(name="id",value="AuthUserRoleID",required=true)Long id) {
        ProcessResult<AuthUserRole> resJson = new ProcessResult<>();
        try{
        resJson.setRes(authUserRoleService.deleteById(id));
        }catch (Exception e) {
        resJson.setRes(false);
        resJson.setResult("异常信息:"+e.getClass().getName());
        logger.info("异常信息:{}",e.getMessage());
        }
        return resJson;
        }

/**
 * @description : 通过id更新AuthUserRole
 * ---------------------------------
 * @author : Jang
 * @since : Create in 2019-04-05
 */
@PutMapping("/updateAuthUserRoleById")
@ApiOperation(value="/updateAuthUserRoleById", notes="通过id更新AuthUserRole")
public ProcessResult<AuthUserRole> updateAuthUserRoleById(@ApiParam(name="AuthUserRole",value="AuthUserRole 实体类")AuthUserRole param) {
        ProcessResult<AuthUserRole> resJson = new ProcessResult<>();
        try{
        resJson.setRes(authUserRoleService.updateById(param));
        }catch (Exception e) {
        resJson.setRes(false);
        resJson.setResult("异常信息:"+e.getClass().getName());
        logger.info("异常信息:{}",e.getMessage());
        }
        return resJson;
        }

/**
 * @description : 添加AuthUserRole
 * ---------------------------------
 * @author : Jang
 * @since : Create in 2019-04-05
 */
@PutMapping("/addAuthUserRole")
@ApiOperation(value="/addAuthUserRole", notes="添加AuthUserRole")
public ProcessResult<AuthUserRole> addAuthUserRole(@ApiParam(name="AuthUserRole",value="AuthUserRole 实体类")AuthUserRole param) {
        ProcessResult<AuthUserRole> resJson = new ProcessResult<>();
        try{
        resJson.setRes(authUserRoleService.insert(param));
        }catch (Exception e) {
        resJson.setRes(false);
        resJson.setResult("异常信息:"+e.getClass().getName());
        logger.info("异常信息:{}",e.getMessage());
        }
        return resJson;
        }
        }