package com.app.commom.result;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.io.Serializable;
import java.util.List;

@JsonSerialize(include=JsonSerialize.Inclusion.NON_EMPTY)
public class ProcessResult<T> implements Serializable {
    private static final long serialVersionUID = 2273610255200563857L;

    /**
     * 结果
     */
    private Boolean res;

    /**
     * 结果
     */
    private String result;

    /**
     * 主键
     */
    private String privateKey;

    /**
     * code
     */
    private String code;

    /**
     * 消息
     */
    private String msg;

    /**
     * 对象
     */
    private T data;

    /**
     * 结果集
     */
    private List<T> datas;

    private int pageNo;//当前页

    private int pageSize;//条数

    private long total;//总条数

    private int pages;//总页面数目

    private long recordsTotal;

    public ProcessResult(){
        this.res=false;
        this.msg= MessageUtil.getMsgByLan(MsgPoolCode.FAILURE);
    }
    @SuppressWarnings("rawtypes")
    public static ProcessResult success(ProcessResult rocessResult) {
        rocessResult.setRes(true);
        rocessResult.setMsg(MessageUtil.getMsgByLan(MsgPoolCode.SUCCESS));
        return rocessResult;
    }
    public ProcessResult(Boolean res){
        this.res=res;
    }
    public ProcessResult(Boolean res,String result){
        this.res=res;
        this.result=result;
    }
    public Boolean getRes() {
        return res;
    }

    public void setRes(Boolean res) {
        this.res = res;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public List<T> getDatas() {
        return datas;
    }

    public void setDatas(List<T> datas) {
        this.datas = datas;
    }

    public String getPrivateKey() {
        return privateKey;
    }

    public void setPrivateKey(String privateKey) {
        this.privateKey = privateKey;
    }

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public long getRecordsTotal() {
        return recordsTotal;
    }

    public void setRecordsTotal(long recordsTotal) {
        this.recordsTotal = recordsTotal;
    }
}
