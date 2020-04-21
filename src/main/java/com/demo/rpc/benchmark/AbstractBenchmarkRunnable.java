/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package com.demo.rpc.benchmark;

import com.opensource.rpc.benchmark.AbstractBoltExchangeRunnable;
import com.opensource.rpc.benchmark.InvokeOption;

/**
 * @author yiji
 * @version : AbstractRandomRunnable.java, v 0.1 2020年04月10日 1:58 下午 yiji Exp $
 */
public abstract class AbstractBenchmarkRunnable extends AbstractBoltExchangeRunnable {

    protected static final String REQUEST_TEMPLATE;

    static {
        StringBuffer buf = new StringBuffer();
        //noinspection SpellCheckingInspection
        buf.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n")
                .append("<stream> \n")
                    .append("<CSTNAME>张三</CSTNAME>  \n")
                    .append("<WEBADDR>3A:CC:8A:56:33:0A</WEBADDR>  \n")
                    .append("<CLIENTIP>28.3.26.133</CLIENTIP>  \n")
                    .append("<BUSTYPE>06</BUSTYPE>  \n")
                    .append("<ENTIDTYPE>AAA</ENTIDTYPE>  \n")
                    .append("<ENTIDNUM>1111111111111111</ENTIDNUM>  \n")
                    .append("<ENTNAME>张三小企业一</ENTNAME> \n")
                .append("</stream>");

        // build request content
        REQUEST_TEMPLATE = buf.toString();
    }

    public AbstractBenchmarkRunnable(InvokeOption option) {
        super(option);
    }
}