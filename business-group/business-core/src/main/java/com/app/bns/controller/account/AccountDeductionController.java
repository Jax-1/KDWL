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
import com.app.bns.service.account.AccountDeductionService;
import com.app.bns.dto.account.AccountDeduction;
import io.swagger.annotations.*;

import com.app.commom.logger.LoggerFactory;

/**
 *
 *   @description : AccountDeduction 控制器
 *   ---------------------------------
 * 	 @author Jang
 *   @since 2019-04-14
 */
@RestController
@Api(value="/accountDeduction", description="AccountDeduction 控制器")
@RequestMapping("/accountDeduction")
public class AccountDeductionController extends IController {
private final Logger logger = LoggerFactory.getLogger(AccountDeductionController.class);

@Autowired
public AccountDeductionService accountDeductionService;

/**
 * @description : 获取分页列表
 * ---------------------------------
 * @author : Jang
 * @since : Create in 2019-04-14
 */
@GetMapping("/getAccountDeductionList")
@ApiOperation(value="/getAccountDeductionList", notes="获取分页列表")
public ProcessResult<AccountDeduction> getAccountDeductionList(@ApiParam(name="AccountDeduction",value="AccountDeduction 实体类")AccountDeduction param ,
                                                               @ApiParam(name="length",value="页大小",required=true,defaultValue = "10")Integer length,
                                                               @ApiParam(name="pageNo",value="页数",required=true,defaultValue = "1")Integer pageNo) {
        ProcessResult<AccountDeduction> resJson=new ProcessResult<>();

        try {
        Page<AccountDeduction> page=new Page<AccountDeduction>(pageNo,length);
    accountDeductionService.selectPage(page, new EntityWrapper<AccountDeduction>(param));
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
 * @description : 通过id获取AccountDeduction
 * ---------------------------------
 * @author : Jang
 * @since : Create in 2019-04-14
 */
@GetMapping("/getAccountDeductionById")
@ApiOperation(value="/getAccountDeductionById", notes="通过id获取AccountDeduction")
public ProcessResult<AccountDeduction> getAccountDeductionById(@ApiParam(name="id",value="AccountDeductionID",required=true)Long id) {
        ProcessResult<AccountDeduction> resJson = new ProcessResult<>();
        try {
    AccountDeduction param= accountDeductionService.selectById(id);
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
 * @description : 通过id删除AccountDeduction
 * ---------------------------------
 * @author : Jang
 * @since : Create in 2019-04-14
 */
@PostMapping("/deleteAccountDeductionById")
@ApiOperation(value="/deleteAccountDeductionById", notes="通过id删除AccountDeduction")
public ProcessResult<AccountDeduction> deleteAccountDeductionById(@ApiParam(name="id",value="AccountDeductionID",required=true)Long id) {
        ProcessResult<AccountDeduction> resJson = new ProcessResult<>();
        try{
        resJson.setRes(accountDeductionService.deleteById(id));
        }catch (Exception e) {
        resJson.setRes(false);
        resJson.setResult("异常信息:"+e.getClass().getName());
        logger.info("异常信息:{}",e.getMessage());
        }
        return resJson;
        }

/**
 * @description : 通过id更新AccountDeduction
 * ---------------------------------
 * @author : Jang
 * @since : Create in 2019-04-14
 */
@PostMapping("/updateAccountDeductionById")
@ApiOperation(value="/updateAccountDeductionById", notes="通过id更新AccountDeduction")
public ProcessResult<AccountDeduction> updateAccountDeductionById(@ApiParam(name="AccountDeduction",value="AccountDeduction 实体类")AccountDeduction param) {
        ProcessResult<AccountDeduction> resJson = new ProcessResult<>();
        try{
        resJson.setRes(accountDeductionService.updateById(param));
        }catch (Exception e) {
        resJson.setRes(false);
        resJson.setResult("异常信息:"+e.getClass().getName());
        logger.info("异常信息:{}",e.getMessage());
        }
        return resJson;
        }

/**
 * @description : 添加AccountDeduction
 * ---------------------------------
 * @author : Jang
 * @since : Create in 2019-04-14
 */
@PutMapping("/addAccountDeduction")
@ApiOperation(value="/addAccountDeduction", notes="添加AccountDeduction")
public ProcessResult<AccountDeduction> addAccountDeduction(@ApiParam(name="AccountDeduction",value="AccountDeduction 实体类")AccountDeduction param) {
        ProcessResult<AccountDeduction> resJson = new ProcessResult<>();
        try{
        resJson.setRes(accountDeductionService.insert(param));
        }catch (Exception e) {
        resJson.setRes(false);
        resJson.setResult("异常信息:"+e.getClass().getName());
        logger.info("异常信息:{}",e.getMessage());
        }
        return resJson;
        }
        }