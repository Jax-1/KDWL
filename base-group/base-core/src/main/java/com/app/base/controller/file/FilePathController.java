package com.app.base.controller.file;

import com.app.commom.result.ProcessResult;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import org.slf4j.Logger;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.bind.annotation.RequestMapping;

    import org.springframework.web.bind.annotation.RestController;
    import com.app.commom.controller.IController;
import org.springframework.beans.factory.annotation.Autowired;
import com.app.base.service.file.FilePathService;
import com.app.base.dto.file.FilePath;
import io.swagger.annotations.*;

import com.app.commom.logger.LoggerFactory;

/**
 *
 *   @description : FilePath 控制器
 *   ---------------------------------
 * 	 @author Jang
 *   @since 2019-04-13
 */
@RestController
@Api(value="/filePath", description="FilePath 控制器")
@RequestMapping("/filePath")
public class FilePathController extends IController {
private final Logger logger = LoggerFactory.getLogger(FilePathController.class);

@Autowired
public FilePathService filePathService;

/**
 * @description : 获取分页列表
 * ---------------------------------
 * @author : Jang
 * @since : Create in 2019-04-13
 */
@GetMapping("/getFilePathList")
@ApiOperation(value="/getFilePathList", notes="获取分页列表")
public ProcessResult<FilePath> getFilePathList(@ApiParam(name="FilePath",value="FilePath 实体类")FilePath param ,
                                               @ApiParam(name="length",value="页大小",required=true,defaultValue = "10")Integer length,
                                               @ApiParam(name="pageNo",value="页数",required=true,defaultValue = "1")Integer pageNo) {
        ProcessResult<FilePath> resJson=new ProcessResult<>();

        try {
        Page<FilePath> page=new Page<FilePath>(pageNo,length);
    filePathService.selectPage(page, new EntityWrapper<FilePath>(param));
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
 * @description : 通过id获取FilePath
 * ---------------------------------
 * @author : Jang
 * @since : Create in 2019-04-13
 */
@GetMapping("/getFilePathById")
@ApiOperation(value="/getFilePathById", notes="通过id获取FilePath")
public ProcessResult<FilePath> getFilePathById(@ApiParam(name="id",value="FilePathID",required=true)Long id) {
        ProcessResult<FilePath> resJson = new ProcessResult<>();
        try {
    FilePath param= filePathService.selectById(id);
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
 * @description : 通过id删除FilePath
 * ---------------------------------
 * @author : Jang
 * @since : Create in 2019-04-13
 */
@PostMapping("/deleteFilePathById")
@ApiOperation(value="/deleteFilePathById", notes="通过id删除FilePath")
public ProcessResult<FilePath> deleteFilePathById(@ApiParam(name="id",value="FilePathID",required=true)Long id) {
        ProcessResult<FilePath> resJson = new ProcessResult<>();
        try{
        resJson.setRes(filePathService.deleteById(id));
        }catch (Exception e) {
        resJson.setRes(false);
        resJson.setResult("异常信息:"+e.getClass().getName());
        logger.info("异常信息:{}",e.getMessage());
        }
        return resJson;
        }

/**
 * @description : 通过id更新FilePath
 * ---------------------------------
 * @author : Jang
 * @since : Create in 2019-04-13
 */
@PostMapping("/updateFilePathById")
@ApiOperation(value="/updateFilePathById", notes="通过id更新FilePath")
public ProcessResult<FilePath> updateFilePathById(@ApiParam(name="FilePath",value="FilePath 实体类")FilePath param) {
        ProcessResult<FilePath> resJson = new ProcessResult<>();
        try{
        resJson.setRes(filePathService.updateById(param));
        }catch (Exception e) {
        resJson.setRes(false);
        resJson.setResult("异常信息:"+e.getClass().getName());
        logger.info("异常信息:{}",e.getMessage());
        }
        return resJson;
        }

/**
 * @description : 添加FilePath
 * ---------------------------------
 * @author : Jang
 * @since : Create in 2019-04-13
 */
@PutMapping("/addFilePath")
@ApiOperation(value="/addFilePath", notes="添加FilePath")
public ProcessResult<FilePath> addFilePath(@ApiParam(name="FilePath",value="FilePath 实体类")FilePath param) {
        ProcessResult<FilePath> resJson = new ProcessResult<>();
        try{
        resJson.setRes(filePathService.insert(param));
        }catch (Exception e) {
        resJson.setRes(false);
        resJson.setResult("异常信息:"+e.getClass().getName());
        logger.info("异常信息:{}",e.getMessage());
        }
        return resJson;
        }
        }