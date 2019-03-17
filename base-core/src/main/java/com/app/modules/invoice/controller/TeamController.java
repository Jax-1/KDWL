package com.app.modules.invoice.controller;

import org.springframework.web.bind.annotation.*;

import org.springframework.web.bind.annotation.RequestMapping;

    import org.springframework.web.bind.annotation.RestController;
import com.app.base.controller.IController;
import org.springframework.beans.factory.annotation.Autowired;
import com.app.modules.invoice.service.TeamService;
import com.app.modules.invoice.entity.Team;
import io.swagger.annotations.*;

import com.app.base.logger.LoggerFactory;
import org.slf4j.Logger;
import  com.app.base.result.ProcessResult;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.mapper.EntityWrapper;

/**
 *　　
 *   @description : Team 控制器
 *   ---------------------------------
 * 	 @author Jang
 *   @since 2019-03-17
 */
@RestController
@Api(value="/invoice/team", description="Team 控制器")
@RequestMapping("/invoice/team")
public class TeamController extends IController {
    private final Logger logger = LoggerFactory.getLogger(TeamController.class);

    @Autowired
    public TeamService teamService;

    /**
     * @description : 获取分页列表
     * ---------------------------------
     * @author : Jang
     * @since : Create in 2019-03-17
     */
    @GetMapping("/getTeamList")
    @ApiOperation(value="/getTeamList", notes="获取分页列表")
    public ProcessResult<Team> getTeamList(@ApiParam(name="Team",value="Team 实体类")Team param ,
                                @ApiParam(name="length",value="页大小",required=true,defaultValue = "10")Integer length,
                                @ApiParam(name="pageNo",value="页数",required=true,defaultValue = "1")Integer pageNo) {
            ProcessResult<Team> resJson=new ProcessResult<>();

            try {
                Page<Team> page=new Page<Team>(pageNo,length);
                teamService.selectPage(page, new EntityWrapper<Team>(param));
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
     * @description : 通过id获取Team
     * ---------------------------------
     * @author : Jang
     * @since : Create in 2019-03-17
     */
    @GetMapping("/getTeamById")
    @ApiOperation(value="/getTeamById", notes="通过id获取Team")
    public ProcessResult<Team> getTeamById(@ApiParam(name="id",value="TeamID",required=true)Long id) {
            ProcessResult<Team> resJson = new ProcessResult<>();
            try {
                Team param= teamService.selectById(id);
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
     * @description : 通过id删除Team
     * ---------------------------------
     * @author : Jang
     * @since : Create in 2019-03-17
     */
    @DeleteMapping("/deleteTeamById")
    @ApiOperation(value="/deleteTeamById", notes="通过id删除Team")
    public ProcessResult<Team> deleteTeamById(@ApiParam(name="id",value="TeamID",required=true)Long id) {
            ProcessResult<Team> resJson = new ProcessResult<>();
            try{
                resJson.setRes(teamService.deleteById(id));
            }catch (Exception e) {
                resJson.setRes(false);
                resJson.setResult("异常信息:"+e.getClass().getName());
                logger.info("异常信息:{}",e.getMessage());
            }
            return resJson;
    }

    /**
     * @description : 通过id更新Team
     * ---------------------------------
     * @author : Jang
     * @since : Create in 2019-03-17
     */
    @PutMapping("/updateTeamById")
    @ApiOperation(value="/updateTeamById", notes="通过id更新Team")
    public ProcessResult<Team> updateTeamById(@ApiParam(name="Team",value="Team 实体类")Team param) {
            ProcessResult<Team> resJson = new ProcessResult<>();
            try{
                resJson.setRes(teamService.updateById(param));
            }catch (Exception e) {
                resJson.setRes(false);
                resJson.setResult("异常信息:"+e.getClass().getName());
                logger.info("异常信息:{}",e.getMessage());
            }
            return resJson;
    }

    /**
     * @description : 添加Team
     * ---------------------------------
     * @author : Jang
     * @since : Create in 2019-03-17
     */
	@PutMapping("/addTeam")
    @ApiOperation(value="/addTeam", notes="添加Team")
    public ProcessResult<Team> addTeam(@ApiParam(name="Team",value="Team 实体类")Team param) {
            ProcessResult<Team> resJson = new ProcessResult<>();
            try{
                resJson.setRes(teamService.insert(param));
            }catch (Exception e) {
                resJson.setRes(false);
                resJson.setResult("异常信息:"+e.getClass().getName());
                logger.info("异常信息:{}",e.getMessage());
            }
            return resJson;
    }
}
