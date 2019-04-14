package com.app.bns.controller.account;

import com.app.commom.result.ProcessResult;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import org.slf4j.Logger;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.bind.annotation.RequestMapping;

    import org.springframework.web.bind.annotation.RestController;
    import com.app.commom.controller.IController;
import org.springframework.beans.factory.annotation.Autowired;
import com.app.bns.service.account.AccountRefundConfigService;
import com.app.bns.dto.account.AccountRefundConfig;
import io.swagger.annotations.*;

import com.app.commom.logger.LoggerFactory;

/**
 *
 *   @description : AccountRefundConfig 控制器
 *   ---------------------------------
 * 	 @author Jang
 *   @since 2019-04-14
 */
@RestController
@Api(value="/accountRefundConfig", description="AccountRefundConfig 控制器")
@RequestMapping("/accountRefundConfig")
public class AccountRefundConfigController extends IController {
private final Logger logger = LoggerFactory.getLogger(AccountRefundConfigController.class);

@Autowired
public AccountRefundConfigService accountRefundConfigService;

/**
 * @description : 获取分页列表
 * ---------------------------------
 * @author : Jang
 * @since : Create in 2019-04-14
 */
@GetMapping("/getAccountRefundConfigList")
@ApiOperation(value="/getAccountRefundConfigList", notes="获取分页列表")
public ProcessResult<AccountRefundConfig> getAccountRefundConfigList(@ApiParam(name="AccountRefundConfig",value="AccountRefundConfig 实体类")AccountRefundConfig param ,
                                                                     @ApiParam(name="length",value="页大小",required=true,defaultValue = "10")Integer length,
                                                                     @ApiParam(name="pageNo",value="页数",required=true,defaultValue = "1")Integer pageNo) {
        ProcessResult<AccountRefundConfig> resJson=new ProcessResult<>();

        try {
        Page<AccountRefundConfig> page=new Page<AccountRefundConfig>(pageNo,length);
    accountRefundConfigService.selectPage(page, new EntityWrapper<AccountRefundConfig>(param));
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
 * @description : 通过id获取AccountRefundConfig
 * ---------------------------------
 * @author : Jang
 * @since : Create in 2019-04-14
 */
@GetMapping("/getAccountRefundConfigById")
@ApiOperation(value="/getAccountRefundConfigById", notes="通过id获取AccountRefundConfig")
public ProcessResult<AccountRefundConfig> getAccountRefundConfigById(@ApiParam(name="id",value="AccountRefundConfigID",required=true)Long id) {
        ProcessResult<AccountRefundConfig> resJson = new ProcessResult<>();
        try {
    AccountRefundConfig param= accountRefundConfigService.selectById(id);
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
 * @description : 通过id删除AccountRefundConfig
 * ---------------------------------
 * @author : Jang
 * @since : Create in 2019-04-14
 */
@PostMapping("/deleteAccountRefundConfigById")
@ApiOperation(value="/deleteAccountRefundConfigById", notes="通过id删除AccountRefundConfig")
public ProcessResult<AccountRefundConfig> deleteAccountRefundConfigById(@ApiParam(name="id",value="AccountRefundConfigID",required=true)Long id) {
        ProcessResult<AccountRefundConfig> resJson = new ProcessResult<>();
        try{
        resJson.setRes(accountRefundConfigService.deleteById(id));
        }catch (Exception e) {
        resJson.setRes(false);
        resJson.setResult("异常信息:"+e.getClass().getName());
        logger.info("异常信息:{}",e.getMessage());
        }
        return resJson;
        }

/**
 * @description : 通过id更新AccountRefundConfig
 * ---------------------------------
 * @author : Jang
 * @since : Create in 2019-04-14
 */
@PostMapping("/updateAccountRefundConfigById")
@ApiOperation(value="/updateAccountRefundConfigById", notes="通过id更新AccountRefundConfig")
public ProcessResult<AccountRefundConfig> updateAccountRefundConfigById(@ApiParam(name="AccountRefundConfig",value="AccountRefundConfig 实体类")AccountRefundConfig param) {
        ProcessResult<AccountRefundConfig> resJson = new ProcessResult<>();
        try{
        resJson.setRes(accountRefundConfigService.updateById(param));
        }catch (Exception e) {
        resJson.setRes(false);
        resJson.setResult("异常信息:"+e.getClass().getName());
        logger.info("异常信息:{}",e.getMessage());
        }
        return resJson;
        }

/**
 * @description : 添加AccountRefundConfig
 * ---------------------------------
 * @author : Jang
 * @since : Create in 2019-04-14
 */
@PutMapping("/addAccountRefundConfig")
@ApiOperation(value="/addAccountRefundConfig", notes="添加AccountRefundConfig")
public ProcessResult<AccountRefundConfig> addAccountRefundConfig(@ApiParam(name="AccountRefundConfig",value="AccountRefundConfig 实体类")AccountRefundConfig param) {
        ProcessResult<AccountRefundConfig> resJson = new ProcessResult<>();
        try{
        resJson.setRes(accountRefundConfigService.insert(param));
        }catch (Exception e) {
        resJson.setRes(false);
        resJson.setResult("异常信息:"+e.getClass().getName());
        logger.info("异常信息:{}",e.getMessage());
        }
        return resJson;
        }
        }