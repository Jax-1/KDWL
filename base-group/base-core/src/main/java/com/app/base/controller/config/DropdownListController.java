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
import com.app.base.service.config.DropdownListService;
import com.app.base.dto.config.DropdownList;
import io.swagger.annotations.*;

import com.app.commom.logger.LoggerFactory;

/**
 *
 *   @description : DropdownList 控制器
 *   ---------------------------------
 * 	 @author Jang
 *   @since 2019-04-13
 */
@RestController
@Api(value="/dropdownList", description="DropdownList 控制器")
@RequestMapping("/dropdownList")
public class DropdownListController extends IController {
private final Logger logger = LoggerFactory.getLogger(DropdownListController.class);

@Autowired
public DropdownListService dropdownListService;

/**
 * @description : 获取分页列表
 * ---------------------------------
 * @author : Jang
 * @since : Create in 2019-04-13
 */
@GetMapping("/getDropdownListList")
@ApiOperation(value="/getDropdownListList", notes="获取分页列表")
public ProcessResult<DropdownList> getDropdownListList(@ApiParam(name="DropdownList",value="DropdownList 实体类")DropdownList param ,
                                                       @ApiParam(name="length",value="页大小",required=true,defaultValue = "10")Integer length,
                                                       @ApiParam(name="pageNo",value="页数",required=true,defaultValue = "1")Integer pageNo) {
        ProcessResult<DropdownList> resJson=new ProcessResult<>();

        try {
        Page<DropdownList> page=new Page<DropdownList>(pageNo,length);
    dropdownListService.selectPage(page, new EntityWrapper<DropdownList>(param));
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
 * @description : 通过id获取DropdownList
 * ---------------------------------
 * @author : Jang
 * @since : Create in 2019-04-13
 */
@GetMapping("/getDropdownListById")
@ApiOperation(value="/getDropdownListById", notes="通过id获取DropdownList")
public ProcessResult<DropdownList> getDropdownListById(@ApiParam(name="id",value="DropdownListID",required=true)Long id) {
        ProcessResult<DropdownList> resJson = new ProcessResult<>();
        try {
    DropdownList param= dropdownListService.selectById(id);
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
 * @description : 通过id删除DropdownList
 * ---------------------------------
 * @author : Jang
 * @since : Create in 2019-04-13
 */
@PostMapping("/deleteDropdownListById")
@ApiOperation(value="/deleteDropdownListById", notes="通过id删除DropdownList")
public ProcessResult<DropdownList> deleteDropdownListById(@ApiParam(name="id",value="DropdownListID",required=true)Long id) {
        ProcessResult<DropdownList> resJson = new ProcessResult<>();
        try{
        resJson.setRes(dropdownListService.deleteById(id));
        }catch (Exception e) {
        resJson.setRes(false);
        resJson.setResult("异常信息:"+e.getClass().getName());
        logger.info("异常信息:{}",e.getMessage());
        }
        return resJson;
        }

/**
 * @description : 通过id更新DropdownList
 * ---------------------------------
 * @author : Jang
 * @since : Create in 2019-04-13
 */
@PostMapping("/updateDropdownListById")
@ApiOperation(value="/updateDropdownListById", notes="通过id更新DropdownList")
public ProcessResult<DropdownList> updateDropdownListById(@ApiParam(name="DropdownList",value="DropdownList 实体类")DropdownList param) {
        ProcessResult<DropdownList> resJson = new ProcessResult<>();
        try{
        resJson.setRes(dropdownListService.updateById(param));
        }catch (Exception e) {
        resJson.setRes(false);
        resJson.setResult("异常信息:"+e.getClass().getName());
        logger.info("异常信息:{}",e.getMessage());
        }
        return resJson;
        }

/**
 * @description : 添加DropdownList
 * ---------------------------------
 * @author : Jang
 * @since : Create in 2019-04-13
 */
@PutMapping("/addDropdownList")
@ApiOperation(value="/addDropdownList", notes="添加DropdownList")
public ProcessResult<DropdownList> addDropdownList(@ApiParam(name="DropdownList",value="DropdownList 实体类")DropdownList param) {
        ProcessResult<DropdownList> resJson = new ProcessResult<>();
        try{
        resJson.setRes(dropdownListService.insert(param));
        }catch (Exception e) {
        resJson.setRes(false);
        resJson.setResult("异常信息:"+e.getClass().getName());
        logger.info("异常信息:{}",e.getMessage());
        }
        return resJson;
        }
        }