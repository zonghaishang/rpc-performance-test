/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package com.demo.rpc.benchmark;

import com.alipay.sofa.ms.service.BenchmarkService;
import com.opensource.rpc.benchmark.InvokeOption;

/**
 * @author yiji
 * @version : BenchmarkRandom_1k.java, v 0.1 2020年04月10日 10:49 上午 yiji Exp $
 */
public class BenchmarkRandom_1k extends AbstractRandomRunnable {

    public BenchmarkRandom_1k(InvokeOption option) {
        super(option);
    }

    @Override
    public Object doInvoke() {
        /**
         * 通过serviceFactory获取接口proxy,
         * 如果返回值不为空并且没有异常抛出，认为调用成功.
         */
        BenchmarkService benchmarkService = (BenchmarkService) serviceFactory.getReference(BenchmarkService.class);
        return benchmarkService.send_1k(randomString(1024));
    }
}