/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package com.demo.rpc.benchmark;

import com.alipay.sofa.ms.service.SofaEchoService;
import com.opensource.rpc.benchmark.InvokeOption;

/**
 * @author yiji
 * @version : BenchmarkBoltRpcInvoke.java, v 0.1 2020年04月21日 4:43 下午 yiji Exp $
 */
public class BenchmarkBoltRpcInvoke extends AbstractBenchmarkRunnable {

    public BenchmarkBoltRpcInvoke(InvokeOption option) {
        super(option);
    }

    public Object doInvoke() {
        SofaEchoService sofaEchoService = (SofaEchoService) serviceFactory.getReference(SofaEchoService.class);
        return sofaEchoService.echo(REQUEST_TEMPLATE);
    }
}