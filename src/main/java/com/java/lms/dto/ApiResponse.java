package com.java.lms.dto;

public class ApiResponse {
    private String errorCode = null;
    private String errorMessage ;
    private boolean result = false;;
    private Object data;
    public ApiResponse(boolean result, Object data){
        this.result = result;
        this.data = data;
        if(!result){
            errorCode = "500";
        }
    }
    public ApiResponse(String errorCode, String errorMessage){
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public boolean isResult() {
        return result;
    }

    public Object getData() {
        return data;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public void setResult(boolean result) {
        this.result = result;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
