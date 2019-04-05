package com.auth.core.controller;

import com.app.auth.dto.AuthUser;
import com.app.commom.result.ProcessResult;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import org.slf4j.Logger;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.bind.annotation.RequestMapping;

    import org.springframework.web.bind.annotation.RestController;
import com.app.commom.controller.IController;
import org.springframework.beans.factory.annotation.Autowired;
import com.auth.core.service.AuthUserService;
import io.swagger.annotations.*;

import com.app.commom.logger.LoggerFactory;

/**
 *　　
 *   @description : AuthUser 控制器
 *   ---------------------------------
 * 	 @author Jang
 *   @since 2019-04-04
 */
@RestController
@Api(value= "/mapper/auth/authUser", description="AuthUser 控制器")
@RequestMapping("/mapper/auth/authUser")
public class AuthUserController extends IController {
    private final Logger logger = LoggerFactory.getLogger(AuthUserController.class);

    @Autowired
    public AuthUserService authUserService;

    /**
     * @description : 获取分页列表
     * ---------------------------------
     * @author : Jang
     * @since : Create in 2019-04-04
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
     * @since : Create in 2019-04-04
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
     * @since : Create in 2019-04-04
     */
    @DeleteMapping("/deleteAuthUserById")
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
     * @since : Create in 2019-04-04
     */
    @PutMapping("/updateAuthUserById")
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
     * @since : Create in 2019-04-04
     */
	@PutMapping("/addAuthUser")
    @ApiOperation(value="/addAuthUser", notes="添加AuthUser")
    public ProcessResult<AuthUser> addAuthUser(@ApiParam(name="AuthUser",value="AuthUser 实体类")AuthUser param) {
            ProcessResult<AuthUser> resJson = new ProcessResult<>();
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
