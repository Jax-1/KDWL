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
import com.app.bns.service.account.AccountWarrantService;
import com.app.bns.dto.account.AccountWarrant;
import io.swagger.annotations.*;

import com.app.commom.logger.LoggerFactory;

/**
 *
 *   @description : AccountWarrant 控制器
 *   ---------------------------------
 * 	 @author Jang
 *   @since 2019-04-14
 */
@RestController
@Api(value="/accountWarrant", description="AccountWarrant 控制器")
@RequestMapping("/accountWarrant")
public class AccountWarrantController extends IController {
private final Logger logger = LoggerFactory.getLogger(AccountWarrantController.class);

@Autowired
public AccountWarrantService accountWarrantService;

/**
 * @description : 获取分页列表
 * ---------------------------------
 * @author : Jang
 * @since : Create in 2019-04-14
 */
@GetMapping("/getAccountWarrantList")
@ApiOperation(value="/getAccountWarrantList", notes="获取分页列表")
public ProcessResult<AccountWarrant> getAccountWarrantList(@ApiParam(name="AccountWarrant",value="AccountWarrant 实体类")AccountWarrant param ,
                                                           @ApiParam(name="length",value="页大小",required=true,defaultValue = "10")Integer length,
                                                           @ApiParam(name="pageNo",value="页数",required=true,defaultValue = "1")Integer pageNo) {
        ProcessResult<AccountWarrant> resJson=new ProcessResult<>();

        try {
        Page<AccountWarrant> page=new Page<AccountWarrant>(pageNo,length);
    accountWarrantService.selectPage(page, new EntityWrapper<AccountWarrant>(param));
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
 * @description : 通过id获取AccountWarrant
 * ---------------------------------
 * @author : Jang
 * @since : Create in 2019-04-14
 */
@GetMapping("/getAccountWarrantById")
@ApiOperation(value="/getAccountWarrantById", notes="通过id获取AccountWarrant")
public ProcessResult<AccountWarrant> getAccountWarrantById(@ApiParam(name="id",value="AccountWarrantID",required=true)Long id) {
        ProcessResult<AccountWarrant> resJson = new ProcessResult<>();
        try {
    AccountWarrant param= accountWarrantService.selectById(id);
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
 * @description : 通过id删除AccountWarrant
 * ---------------------------------
 * @author : Jang
 * @since : Create in 2019-04-14
 */
@PostMapping("/deleteAccountWarrantById")
@ApiOperation(value="/deleteAccountWarrantById", notes="通过id删除AccountWarrant")
public ProcessResult<AccountWarrant> deleteAccountWarrantById(@ApiParam(name="id",value="AccountWarrantID",required=true)Long id) {
        ProcessResult<AccountWarrant> resJson = new ProcessResult<>();
        try{
        resJson.setRes(accountWarrantService.deleteById(id));
        }catch (Exception e) {
        resJson.setRes(false);
        resJson.setResult("异常信息:"+e.getClass().getName());
        logger.info("异常信息:{}",e.getMessage());
        }
        return resJson;
        }

/**
 * @description : 通过id更新AccountWarrant
 * ---------------------------------
 * @author : Jang
 * @since : Create in 2019-04-14
 */
@PostMapping("/updateAccountWarrantById")
@ApiOperation(value="/updateAccountWarrantById", notes="通过id更新AccountWarrant")
public ProcessResult<AccountWarrant> updateAccountWarrantById(@ApiParam(name="AccountWarrant",value="AccountWarrant 实体类")AccountWarrant param) {
        ProcessResult<AccountWarrant> resJson = new ProcessResult<>();
        try{
        resJson.setRes(accountWarrantService.updateById(param));
        }catch (Exception e) {
        resJson.setRes(false);
        resJson.setResult("异常信息:"+e.getClass().getName());
        logger.info("异常信息:{}",e.getMessage());
        }
        return resJson;
        }

/**
 * @description : 添加AccountWarrant
 * ---------------------------------
 * @author : Jang
 * @since : Create in 2019-04-14
 */
@PutMapping("/addAccountWarrant")
@ApiOperation(value="/addAccountWarrant", notes="添加AccountWarrant")
public ProcessResult<AccountWarrant> addAccountWarrant(@ApiParam(name="AccountWarrant",value="AccountWarrant 实体类")AccountWarrant param) {
        ProcessResult<AccountWarrant> resJson = new ProcessResult<>();
        try{
        resJson.setRes(accountWarrantService.insert(param));
        }catch (Exception e) {
        resJson.setRes(false);
        resJson.setResult("异常信息:"+e.getClass().getName());
        logger.info("异常信息:{}",e.getMessage());
        }
        return resJson;
        }
        }