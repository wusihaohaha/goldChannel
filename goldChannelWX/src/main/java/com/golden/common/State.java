package com.golden.common;
public enum State {
	OK(200, "上传成功"),  
    ERROR(500, "上传失败"),  
    OVER_FILE_LIMIT(501, "超过上传大小限制"),  
    NO_SUPPORT_EXTENSION(502, "不支持的扩展名"),
	NO_FILE(503, "未选择图片"),
	FILE_NUM_LIMIT(601,"文件上传数超过限制");

    private int code;  
    private String message;  
    private State(int code, String message) {  
        this.code = code;  
        this.message = message;  
    }  

    public int getCode() {  
        return code;  
    }  
    public String getMessage() {  
        return message;  
    }
}