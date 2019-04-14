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
import com.app.bns.service.account.AccountService;
import com.app.bns.dto.account.Account;
import io.swagger.annotations.*;

import com.app.commom.logger.LoggerFactory;

/**
 *
 *   @description : Account 控制器
 *   ---------------------------------
 * 	 @author Jang
 *   @since 2019-04-14
 */
@RestController
@Api(value="/account", description="Account 控制器")
@RequestMapping("/account")
public class AccountController extends IController {
private final Logger logger = LoggerFactory.getLogger(AccountController.class);

@Autowired
public AccountService accountService;

/**
 * @description : 获取分页列表
 * ---------------------------------
 * @author : Jang
 * @since : Create in 2019-04-14
 */
@GetMapping("/getAccountList")
@ApiOperation(value="/getAccountList", notes="获取分页列表")
public ProcessResult<Account> getAccountList(@ApiParam(name="Account",value="Account 实体类")Account param ,
                                             @ApiParam(name="length",value="页大小",required=true,defaultValue = "10")Integer length,
                                             @ApiParam(name="pageNo",value="页数",required=true,defaultValue = "1")Integer pageNo) {
        ProcessResult<Account> resJson=new ProcessResult<>();

        try {
        Page<Account> page=new Page<Account>(pageNo,length);
    accountService.selectPage(page, new EntityWrapper<Account>(param));
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
 * @description : 通过id获取Account
 * ---------------------------------
 * @author : Jang
 * @since : Create in 2019-04-14
 */
@GetMapping("/getAccountById")
@ApiOperation(value="/getAccountById", notes="通过id获取Account")
public ProcessResult<Account> getAccountById(@ApiParam(name="id",value="AccountID",required=true)Long id) {
        ProcessResult<Account> resJson = new ProcessResult<>();
        try {
    Account param= accountService.selectById(id);
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
 * @description : 通过id删除Account
 * ---------------------------------
 * @author : Jang
 * @since : Create in 2019-04-14
 */
@PostMapping("/deleteAccountById")
@ApiOperation(value="/deleteAccountById", notes="通过id删除Account")
public ProcessResult<Account> deleteAccountById(@ApiParam(name="id",value="AccountID",required=true)Long id) {
        ProcessResult<Account> resJson = new ProcessResult<>();
        try{
        resJson.setRes(accountService.deleteById(id));
        }catch (Exception e) {
        resJson.setRes(false);
        resJson.setResult("异常信息:"+e.getClass().getName());
        logger.info("异常信息:{}",e.getMessage());
        }
        return resJson;
        }

/**
 * @description : 通过id更新Account
 * ---------------------------------
 * @author : Jang
 * @since : Create in 2019-04-14
 */
@PostMapping("/updateAccountById")
@ApiOperation(value="/updateAccountById", notes="通过id更新Account")
public ProcessResult<Account> updateAccountById(@ApiParam(name="Account",value="Account 实体类")Account param) {
        ProcessResult<Account> resJson = new ProcessResult<>();
        try{
        resJson.setRes(accountService.updateById(param));
        }catch (Exception e) {
        resJson.setRes(false);
        resJson.setResult("异常信息:"+e.getClass().getName());
        logger.info("异常信息:{}",e.getMessage());
        }
        return resJson;
        }

/**
 * @description : 添加Account
 * ---------------------------------
 * @author : Jang
 * @since : Create in 2019-04-14
 */
@PutMapping("/addAccount")
@ApiOperation(value="/addAccount", notes="添加Account")
public ProcessResult<Account> addAccount(@ApiParam(name="Account",value="Account 实体类")Account param) {
        ProcessResult<Account> resJson = new ProcessResult<>();
        try{
        resJson.setRes(accountService.insert(param));
        }catch (Exception e) {
        resJson.setRes(false);
        resJson.setResult("异常信息:"+e.getClass().getName());
        logger.info("异常信息:{}",e.getMessage());
        }
        return resJson;
        }
        }