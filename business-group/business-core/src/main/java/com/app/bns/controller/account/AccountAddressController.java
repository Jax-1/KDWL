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
import com.app.bns.service.account.AccountAddressService;
import com.app.bns.dto.account.AccountAddress;
import io.swagger.annotations.*;

import com.app.commom.logger.LoggerFactory;

/**
 *
 *   @description : AccountAddress 控制器
 *   ---------------------------------
 * 	 @author Jang
 *   @since 2019-04-14
 */
@RestController
@Api(value="/accountAddress", description="AccountAddress 控制器")
@RequestMapping("/accountAddress")
public class AccountAddressController extends IController {
private final Logger logger = LoggerFactory.getLogger(AccountAddressController.class);

@Autowired
public AccountAddressService accountAddressService;

/**
 * @description : 获取分页列表
 * ---------------------------------
 * @author : Jang
 * @since : Create in 2019-04-14
 */
@GetMapping("/getAccountAddressList")
@ApiOperation(value="/getAccountAddressList", notes="获取分页列表")
public ProcessResult<AccountAddress> getAccountAddressList(@ApiParam(name="AccountAddress",value="AccountAddress 实体类")AccountAddress param ,
                                                           @ApiParam(name="length",value="页大小",required=true,defaultValue = "10")Integer length,
                                                           @ApiParam(name="pageNo",value="页数",required=true,defaultValue = "1")Integer pageNo) {
        ProcessResult<AccountAddress> resJson=new ProcessResult<>();

        try {
        Page<AccountAddress> page=new Page<AccountAddress>(pageNo,length);
    accountAddressService.selectPage(page, new EntityWrapper<AccountAddress>(param));
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
 * @description : 通过id获取AccountAddress
 * ---------------------------------
 * @author : Jang
 * @since : Create in 2019-04-14
 */
@GetMapping("/getAccountAddressById")
@ApiOperation(value="/getAccountAddressById", notes="通过id获取AccountAddress")
public ProcessResult<AccountAddress> getAccountAddressById(@ApiParam(name="id",value="AccountAddressID",required=true)Long id) {
        ProcessResult<AccountAddress> resJson = new ProcessResult<>();
        try {
    AccountAddress param= accountAddressService.selectById(id);
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
 * @description : 通过id删除AccountAddress
 * ---------------------------------
 * @author : Jang
 * @since : Create in 2019-04-14
 */
@PostMapping("/deleteAccountAddressById")
@ApiOperation(value="/deleteAccountAddressById", notes="通过id删除AccountAddress")
public ProcessResult<AccountAddress> deleteAccountAddressById(@ApiParam(name="id",value="AccountAddressID",required=true)Long id) {
        ProcessResult<AccountAddress> resJson = new ProcessResult<>();
        try{
        resJson.setRes(accountAddressService.deleteById(id));
        }catch (Exception e) {
        resJson.setRes(false);
        resJson.setResult("异常信息:"+e.getClass().getName());
        logger.info("异常信息:{}",e.getMessage());
        }
        return resJson;
        }

/**
 * @description : 通过id更新AccountAddress
 * ---------------------------------
 * @author : Jang
 * @since : Create in 2019-04-14
 */
@PostMapping("/updateAccountAddressById")
@ApiOperation(value="/updateAccountAddressById", notes="通过id更新AccountAddress")
public ProcessResult<AccountAddress> updateAccountAddressById(@ApiParam(name="AccountAddress",value="AccountAddress 实体类")AccountAddress param) {
        ProcessResult<AccountAddress> resJson = new ProcessResult<>();
        try{
        resJson.setRes(accountAddressService.updateById(param));
        }catch (Exception e) {
        resJson.setRes(false);
        resJson.setResult("异常信息:"+e.getClass().getName());
        logger.info("异常信息:{}",e.getMessage());
        }
        return resJson;
        }

/**
 * @description : 添加AccountAddress
 * ---------------------------------
 * @author : Jang
 * @since : Create in 2019-04-14
 */
@PutMapping("/addAccountAddress")
@ApiOperation(value="/addAccountAddress", notes="添加AccountAddress")
public ProcessResult<AccountAddress> addAccountAddress(@ApiParam(name="AccountAddress",value="AccountAddress 实体类")AccountAddress param) {
        ProcessResult<AccountAddress> resJson = new ProcessResult<>();
        try{
        resJson.setRes(accountAddressService.insert(param));
        }catch (Exception e) {
        resJson.setRes(false);
        resJson.setResult("异常信息:"+e.getClass().getName());
        logger.info("异常信息:{}",e.getMessage());
        }
        return resJson;
        }
        }