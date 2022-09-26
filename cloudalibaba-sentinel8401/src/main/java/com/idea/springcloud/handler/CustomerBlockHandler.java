package com.idea.springcloud.handler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.idea.springcloud.entities.CommonResult;

public class CustomerBlockHandler {
    public static CommonResult handleException(BlockException exception){
        return new CommonResult(2020,"自定义的限流处理信息......CustomerBlockHandler");
    }
    public static CommonResult handleException2(BlockException exception){
        return new CommonResult(2020,"自定义的限流处理信息2......CustomerBlockHandler2");
    }
}
