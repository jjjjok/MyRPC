package com.myrpc.common.entity;

import com.myrpc.common.info.ResponseCode;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
@Data
@NoArgsConstructor
//服务端调用后返回给客户端的信息
public class RpcResponse<T> implements Serializable {

    private String requestId;
    //响应状态码
    private Integer statusCode;

    //响应状态补充信息
    private String message;

    //响应数据
    private T data;



    public static <T> RpcResponse<T> success(T data,String requestId) {
        RpcResponse<T> response = new RpcResponse<>();
        response.setRequestId(requestId);
        response.setStatusCode(ResponseCode.SUCCESS.getCode());
        response.setData(data);
        return response;
    }

    public static <T> RpcResponse<T> fail(ResponseCode code, String requestId) {
        RpcResponse<T> response = new RpcResponse<>();
        response.setRequestId(requestId);
        response.setStatusCode(code.getCode());
        response.setMessage(code.getMessage());
        return response;
    }
}
