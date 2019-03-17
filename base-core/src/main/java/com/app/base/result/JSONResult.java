package com.app.base.result;

import java.util.List;

public class JSONResult<T> {
    private long tableJSON;
    private T data;
    private Boolean success;
    private String message;

    public long getTableJSON() {
        return tableJSON;
    }

    public void setTableJSON(long tableJSON) {
        this.tableJSON = tableJSON;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
