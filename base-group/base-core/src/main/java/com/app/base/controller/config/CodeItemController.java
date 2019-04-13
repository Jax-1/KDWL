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
import com.app.base.service.config.CodeItemService;
import com.app.base.dto.config.CodeItem;
import io.swagger.annotations.*;

import com.app.commom.logger.LoggerFactory;

/**
 *
 *   @description : CodeItem 控制器
 *   ---------------------------------
 * 	 @author Jang
 *   @since 2019-04-13
 */
@RestController
@Api(value="/codeItem", description="CodeItem 控制器")
@RequestMapping("/codeItem")
public class CodeItemController extends IController {
private final Logger logger = LoggerFactory.getLogger(CodeItemController.class);

@Autowired
public CodeItemService codeItemService;

/**
 * @description : 获取分页列表
 * ---------------------------------
 * @author : Jang
 * @since : Create in 2019-04-13
 */
@GetMapping("/getCodeItemList")
@ApiOperation(value="/getCodeItemList", notes="获取分页列表")
public ProcessResult<CodeItem> getCodeItemList(@ApiParam(name="CodeItem",value="CodeItem 实体类")CodeItem param ,
                                               @ApiParam(name="length",value="页大小",required=true,defaultValue = "10")Integer length,
                                               @ApiParam(name="pageNo",value="页数",required=true,defaultValue = "1")Integer pageNo) {
        ProcessResult<CodeItem> resJson=new ProcessResult<>();

        try {
        Page<CodeItem> page=new Page<CodeItem>(pageNo,length);
    codeItemService.selectPage(page, new EntityWrapper<CodeItem>(param));
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
 * @description : 通过id获取CodeItem
 * ---------------------------------
 * @author : Jang
 * @since : Create in 2019-04-13
 */
@GetMapping("/getCodeItemById")
@ApiOperation(value="/getCodeItemById", notes="通过id获取CodeItem")
public ProcessResult<CodeItem> getCodeItemById(@ApiParam(name="id",value="CodeItemID",required=true)Long id) {
        ProcessResult<CodeItem> resJson = new ProcessResult<>();
        try {
    CodeItem param= codeItemService.selectById(id);
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
 * @description : 通过id删除CodeItem
 * ---------------------------------
 * @author : Jang
 * @since : Create in 2019-04-13
 */
@PostMapping("/deleteCodeItemById")
@ApiOperation(value="/deleteCodeItemById", notes="通过id删除CodeItem")
public ProcessResult<CodeItem> deleteCodeItemById(@ApiParam(name="id",value="CodeItemID",required=true)Long id) {
        ProcessResult<CodeItem> resJson = new ProcessResult<>();
        try{
        resJson.setRes(codeItemService.deleteById(id));
        }catch (Exception e) {
        resJson.setRes(false);
        resJson.setResult("异常信息:"+e.getClass().getName());
        logger.info("异常信息:{}",e.getMessage());
        }
        return resJson;
        }

/**
 * @description : 通过id更新CodeItem
 * ---------------------------------
 * @author : Jang
 * @since : Create in 2019-04-13
 */
@PostMapping("/updateCodeItemById")
@ApiOperation(value="/updateCodeItemById", notes="通过id更新CodeItem")
public ProcessResult<CodeItem> updateCodeItemById(@ApiParam(name="CodeItem",value="CodeItem 实体类")CodeItem param) {
        ProcessResult<CodeItem> resJson = new ProcessResult<>();
        try{
        resJson.setRes(codeItemService.updateById(param));
        }catch (Exception e) {
        resJson.setRes(false);
        resJson.setResult("异常信息:"+e.getClass().getName());
        logger.info("异常信息:{}",e.getMessage());
        }
        return resJson;
        }

/**
 * @description : 添加CodeItem
 * ---------------------------------
 * @author : Jang
 * @since : Create in 2019-04-13
 */
@PutMapping("/addCodeItem")
@ApiOperation(value="/addCodeItem", notes="添加CodeItem")
public ProcessResult<CodeItem> addCodeItem(@ApiParam(name="CodeItem",value="CodeItem 实体类")CodeItem param) {
        ProcessResult<CodeItem> resJson = new ProcessResult<>();
        try{
        resJson.setRes(codeItemService.insert(param));
        }catch (Exception e) {
        resJson.setRes(false);
        resJson.setResult("异常信息:"+e.getClass().getName());
        logger.info("异常信息:{}",e.getMessage());
        }
        return resJson;
        }
        }