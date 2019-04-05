package com.auth.core.controller;

import com.app.auth.dto.AuthRole;
import com.app.commom.result.ProcessResult;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import org.slf4j.Logger;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.bind.annotation.RequestMapping;

    import org.springframework.web.bind.annotation.RestController;
import com.app.commom.controller.IController;
import org.springframework.beans.factory.annotation.Autowired;
import com.auth.core.service.AuthRoleService;
import io.swagger.annotations.*;

import com.app.commom.logger.LoggerFactory;

/**
 *　　
 *   @description : AuthRole 控制器
 *   ---------------------------------
 * 	 @author Jang
 *   @since 2019-04-04
 */
@RestController
@Api(value= "/mapper/auth/authRole", description="AuthRole 控制器")
@RequestMapping("/mapper/auth/authRole")
public class AuthRoleController extends IController {
    private final Logger logger = LoggerFactory.getLogger(AuthRoleController.class);

    @Autowired
    public AuthRoleService authRoleService;

    /**
     * @description : 获取分页列表
     * ---------------------------------
     * @author : Jang
     * @since : Create in 2019-04-04
     */
    @GetMapping("/getAuthRoleList")
    @ApiOperation(value="/getAuthRoleList", notes="获取分页列表")
    public ProcessResult<AuthRole> getAuthRoleList(@ApiParam(name="AuthRole",value="AuthRole 实体类")AuthRole param ,
                                                   @ApiParam(name="length",value="页大小",required=true,defaultValue = "10")Integer length,
                                                   @ApiParam(name="pageNo",value="页数",required=true,defaultValue = "1")Integer pageNo) {
            ProcessResult<AuthRole> resJson=new ProcessResult<>();

            try {
                Page<AuthRole> page=new Page<AuthRole>(pageNo,length);
                authRoleService.selectPage(page, new EntityWrapper<AuthRole>(param));
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
     * @description : 通过id获取AuthRole
     * ---------------------------------
     * @author : Jang
     * @since : Create in 2019-04-04
     */
    @GetMapping("/getAuthRoleById")
    @ApiOperation(value="/getAuthRoleById", notes="通过id获取AuthRole")
    public ProcessResult<AuthRole> getAuthRoleById(@ApiParam(name="id",value="AuthRoleID",required=true)Long id) {
            ProcessResult<AuthRole> resJson = new ProcessResult<>();
            try {
                AuthRole param= authRoleService.selectById(id);
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
     * @description : 通过id删除AuthRole
     * ---------------------------------
     * @author : Jang
     * @since : Create in 2019-04-04
     */
    @DeleteMapping("/deleteAuthRoleById")
    @ApiOperation(value="/deleteAuthRoleById", notes="通过id删除AuthRole")
    public ProcessResult<AuthRole> deleteAuthRoleById(@ApiParam(name="id",value="AuthRoleID",required=true)Long id) {
            ProcessResult<AuthRole> resJson = new ProcessResult<>();
            try{
                resJson.setRes(authRoleService.deleteById(id));
            }catch (Exception e) {
                resJson.setRes(false);
                resJson.setResult("异常信息:"+e.getClass().getName());
                logger.info("异常信息:{}",e.getMessage());
            }
            return resJson;
    }

    /**
     * @description : 通过id更新AuthRole
     * ---------------------------------
     * @author : Jang
     * @since : Create in 2019-04-04
     */
    @PutMapping("/updateAuthRoleById")
    @ApiOperation(value="/updateAuthRoleById", notes="通过id更新AuthRole")
    public ProcessResult<AuthRole> updateAuthRoleById(@ApiParam(name="AuthRole",value="AuthRole 实体类")AuthRole param) {
            ProcessResult<AuthRole> resJson = new ProcessResult<>();
            try{
                resJson.setRes(authRoleService.updateById(param));
            }catch (Exception e) {
                resJson.setRes(false);
                resJson.setResult("异常信息:"+e.getClass().getName());
                logger.info("异常信息:{}",e.getMessage());
            }
            return resJson;
    }

    /**
     * @description : 添加AuthRole
     * ---------------------------------
     * @author : Jang
     * @since : Create in 2019-04-04
     */
	@PutMapping("/addAuthRole")
    @ApiOperation(value="/addAuthRole", notes="添加AuthRole")
    public ProcessResult<AuthRole> addAuthRole(@ApiParam(name="AuthRole",value="AuthRole 实体类")AuthRole param) {
            ProcessResult<AuthRole> resJson = new ProcessResult<>();
            try{
                resJson.setRes(authRoleService.insert(param));
            }catch (Exception e) {
                resJson.setRes(false);
                resJson.setResult("异常信息:"+e.getClass().getName());
                logger.info("异常信息:{}",e.getMessage());
            }
            return resJson;
    }
}
