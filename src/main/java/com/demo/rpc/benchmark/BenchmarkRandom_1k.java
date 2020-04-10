/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package com.demo.rpc.benchmark;

import com.alipay.sofa.ms.service.BenchmarkService;
import com.opensource.rpc.benchmark.AbstractExchangeRunnable;
import com.opensource.rpc.benchmark.InvokeOption;
import org.apache.commons.lang3.RandomStringUtils;

/**
 * @author yiji
 * @version : BenchmarkRandom_1k.java, v 0.1 2020年04月10日 10:49 上午 yiji Exp $
 */
public class BenchmarkRandom_1k  extends AbstractExchangeRunnable {

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

    static char[] chars = new char[] {
            '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
            'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j',
            'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't',
            'u', 'v', 'w', 'x', 'y', 'z', 'A', 'B', 'C', 'D',
            'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N',
            'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X',
            'Y', 'Z',
    };

    public static String randomString(int len) {
        return RandomStringUtils.random(len, 0, chars.length, true, true, chars);
    }
}