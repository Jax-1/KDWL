package com.app.pay.core.controller;

import com.app.commom.result.ProcessResult;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import org.slf4j.Logger;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.bind.annotation.RequestMapping;

    import org.springframework.web.bind.annotation.RestController;
import com.app.commom.controller.IController;
import org.springframework.beans.factory.annotation.Autowired;
import com.app.pay.core.service.PaymentMethodService;
import com.app.pay.dto.PaymentMethod;
import io.swagger.annotations.*;

import com.app.commom.logger.LoggerFactory;

/**
 *　　
 *   @description : PaymentMethod 控制器
 *   ---------------------------------
 * 	 @author Jang
 *   @since 2019-04-07
 */
@RestController
@Api(value="/paymentMethod", description="PaymentMethod 控制器")
@RequestMapping("/paymentMethod")
public class PaymentMethodController extends IController {
    private final Logger logger = LoggerFactory.getLogger(PaymentMethodController.class);

    @Autowired
    public PaymentMethodService paymentMethodService;

    /**
     * @description : 获取分页列表
     * ---------------------------------
     * @author : Jang
     * @since : Create in 2019-04-07
     */
    @GetMapping("/getPaymentMethodList")
    @ApiOperation(value="/getPaymentMethodList", notes="获取分页列表")
    public ProcessResult<PaymentMethod> getPaymentMethodList(@ApiParam(name="PaymentMethod",value="PaymentMethod 实体类")PaymentMethod param ,
                                                             @ApiParam(name="length",value="页大小",required=true,defaultValue = "10")Integer length,
                                                             @ApiParam(name="pageNo",value="页数",required=true,defaultValue = "1")Integer pageNo) {
            ProcessResult<PaymentMethod> resJson=new ProcessResult<>();

            try {
                Page<PaymentMethod> page=new Page<PaymentMethod>(pageNo,length);
                paymentMethodService.selectPage(page, new EntityWrapper<PaymentMethod>(param));
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
     * @description : 通过id获取PaymentMethod
     * ---------------------------------
     * @author : Jang
     * @since : Create in 2019-04-07
     */
    @GetMapping("/getPaymentMethodById")
    @ApiOperation(value="/getPaymentMethodById", notes="通过id获取PaymentMethod")
    public ProcessResult<PaymentMethod> getPaymentMethodById(@ApiParam(name="id",value="PaymentMethodID",required=true)Long id) {
            ProcessResult<PaymentMethod> resJson = new ProcessResult<>();
            try {
                PaymentMethod param= paymentMethodService.selectById(id);
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
     * @description : 通过id删除PaymentMethod
     * ---------------------------------
     * @author : Jang
     * @since : Create in 2019-04-07
     */
    @DeleteMapping("/deletePaymentMethodById")
    @ApiOperation(value="/deletePaymentMethodById", notes="通过id删除PaymentMethod")
    public ProcessResult<PaymentMethod> deletePaymentMethodById(@ApiParam(name="id",value="PaymentMethodID",required=true)Long id) {
            ProcessResult<PaymentMethod> resJson = new ProcessResult<>();
            try{
                resJson.setRes(paymentMethodService.deleteById(id));
            }catch (Exception e) {
                resJson.setRes(false);
                resJson.setResult("异常信息:"+e.getClass().getName());
                logger.info("异常信息:{}",e.getMessage());
            }
            return resJson;
    }

    /**
     * @description : 通过id更新PaymentMethod
     * ---------------------------------
     * @author : Jang
     * @since : Create in 2019-04-07
     */
    @PutMapping("/updatePaymentMethodById")
    @ApiOperation(value="/updatePaymentMethodById", notes="通过id更新PaymentMethod")
    public ProcessResult<PaymentMethod> updatePaymentMethodById(@ApiParam(name="PaymentMethod",value="PaymentMethod 实体类")PaymentMethod param) {
            ProcessResult<PaymentMethod> resJson = new ProcessResult<>();
            try{
                resJson.setRes(paymentMethodService.updateById(param));
            }catch (Exception e) {
                resJson.setRes(false);
                resJson.setResult("异常信息:"+e.getClass().getName());
                logger.info("异常信息:{}",e.getMessage());
            }
            return resJson;
    }

    /**
     * @description : 添加PaymentMethod
     * ---------------------------------
     * @author : Jang
     * @since : Create in 2019-04-07
     */
	@PutMapping("/addPaymentMethod")
    @ApiOperation(value="/addPaymentMethod", notes="添加PaymentMethod")
    public ProcessResult<PaymentMethod> addPaymentMethod(@ApiParam(name="PaymentMethod",value="PaymentMethod 实体类")PaymentMethod param) {
            ProcessResult<PaymentMethod> resJson = new ProcessResult<>();
            try{
                resJson.setRes(paymentMethodService.insert(param));
            }catch (Exception e) {
                resJson.setRes(false);
                resJson.setResult("异常信息:"+e.getClass().getName());
                logger.info("异常信息:{}",e.getMessage());
            }
            return resJson;
    }
}
