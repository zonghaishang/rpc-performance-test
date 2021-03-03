/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package com.demo.rpc.benchmark;

import com.opensource.rpc.benchmark.AbstractExchangeRunnable;
import com.opensource.rpc.benchmark.InvokeOption;
import org.apache.commons.lang3.RandomStringUtils;

/**
 * @author yiji
 * @version : AbstractRandomRunnable.java, v 0.1 2020年04月10日 1:58 下午 yiji Exp $
 */
public abstract class AbstractRandomRunnable extends AbstractExchangeRunnable {

    static char[] chars = new char[] {
            '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
            'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j',
            'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't',
            'u', 'v', 'w', 'x', 'y', 'z', 'A', 'B', 'C', 'D',
            'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N',
            'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X',
            'Y', 'Z',
    };

    public AbstractRandomRunnable(InvokeOption option) {
        super(option);
    }

    protected String randomString(int len) {
        return RandomStringUtils.random(len, 0, chars.length, true, true, chars);
    }
}