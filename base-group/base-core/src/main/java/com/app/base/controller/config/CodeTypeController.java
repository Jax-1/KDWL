package com.app.base.controller.config;

import com.app.commom.result.ProcessResult;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import org.slf4j.Logger;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.bind.annotation.RequestMapping;

    import org.springframework.web.bind.annotation.RestController;
    import com.app.commom.controller.IController;
import org.springframework.beans.factory.annotation.Autowired;
import com.app.base.service.config.CodeTypeService;
import com.app.base.dto.config.CodeType;
import io.swagger.annotations.*;

import com.app.commom.logger.LoggerFactory;

/**
 *
 *   @description : CodeType 控制器
 *   ---------------------------------
 * 	 @author Jang
 *   @since 2019-04-13
 */
@RestController
@Api(value="/codeType", description="CodeType 控制器")
@RequestMapping("/codeType")
public class CodeTypeController extends IController {
private final Logger logger = LoggerFactory.getLogger(CodeTypeController.class);

@Autowired
public CodeTypeService codeTypeService;

/**
 * @description : 获取分页列表
 * ---------------------------------
 * @author : Jang
 * @since : Create in 2019-04-13
 */
@GetMapping("/getCodeTypeList")
@ApiOperation(value="/getCodeTypeList", notes="获取分页列表")
public ProcessResult<CodeType> getCodeTypeList(@ApiParam(name="CodeType",value="CodeType 实体类")CodeType param ,
                                               @ApiParam(name="length",value="页大小",required=true,defaultValue = "10")Integer length,
                                               @ApiParam(name="pageNo",value="页数",required=true,defaultValue = "1")Integer pageNo) {
        ProcessResult<CodeType> resJson=new ProcessResult<>();

        try {
        Page<CodeType> page=new Page<CodeType>(pageNo,length);
    codeTypeService.selectPage(page, new EntityWrapper<CodeType>(param));
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
 * @description : 通过id获取CodeType
 * ---------------------------------
 * @author : Jang
 * @since : Create in 2019-04-13
 */
@GetMapping("/getCodeTypeById")
@ApiOperation(value="/getCodeTypeById", notes="通过id获取CodeType")
public ProcessResult<CodeType> getCodeTypeById(@ApiParam(name="id",value="CodeTypeID",required=true)Long id) {
        ProcessResult<CodeType> resJson = new ProcessResult<>();
        try {
    CodeType param= codeTypeService.selectById(id);
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
 * @description : 通过id删除CodeType
 * ---------------------------------
 * @author : Jang
 * @since : Create in 2019-04-13
 */
@PostMapping("/deleteCodeTypeById")
@ApiOperation(value="/deleteCodeTypeById", notes="通过id删除CodeType")
public ProcessResult<CodeType> deleteCodeTypeById(@ApiParam(name="id",value="CodeTypeID",required=true)Long id) {
        ProcessResult<CodeType> resJson = new ProcessResult<>();
        try{
        resJson.setRes(codeTypeService.deleteById(id));
        }catch (Exception e) {
        resJson.setRes(false);
        resJson.setResult("异常信息:"+e.getClass().getName());
        logger.info("异常信息:{}",e.getMessage());
        }
        return resJson;
        }

/**
 * @description : 通过id更新CodeType
 * ---------------------------------
 * @author : Jang
 * @since : Create in 2019-04-13
 */
@PostMapping("/updateCodeTypeById")
@ApiOperation(value="/updateCodeTypeById", notes="通过id更新CodeType")
public ProcessResult<CodeType> updateCodeTypeById(@ApiParam(name="CodeType",value="CodeType 实体类")CodeType param) {
        ProcessResult<CodeType> resJson = new ProcessResult<>();
        try{
        resJson.setRes(codeTypeService.updateById(param));
        }catch (Exception e) {
        resJson.setRes(false);
        resJson.setResult("异常信息:"+e.getClass().getName());
        logger.info("异常信息:{}",e.getMessage());
        }
        return resJson;
        }

/**
 * @description : 添加CodeType
 * ---------------------------------
 * @author : Jang
 * @since : Create in 2019-04-13
 */
@PutMapping("/addCodeType")
@ApiOperation(value="/addCodeType", notes="添加CodeType")
public ProcessResult<CodeType> addCodeType(@ApiParam(name="CodeType",value="CodeType 实体类")CodeType param) {
        ProcessResult<CodeType> resJson = new ProcessResult<>();
        try{
        resJson.setRes(codeTypeService.insert(param));
        }catch (Exception e) {
        resJson.setRes(false);
        resJson.setResult("异常信息:"+e.getClass().getName());
        logger.info("异常信息:{}",e.getMessage());
        }
        return resJson;
        }
        }