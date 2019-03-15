package com.kdwl.core.include.page;

import java.util.List;

public class TableJSON<T> {
    private long tableJSON;
    private List<T> data;
    private Boolean success;
    private String message;

    public long getTableJSON() {
        return tableJSON;
    }

    public void setTableJSON(long tableJSON) {
        this.tableJSON = tableJSON;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
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
