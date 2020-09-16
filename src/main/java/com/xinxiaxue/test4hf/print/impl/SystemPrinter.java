package com.xinxiaxue.test4hf.print.impl;

import com.xinxiaxue.test4hf.print.IPrinter;

/**
 * 系统输出
 * @author hezf
 * @date 2020/9/15
 */
public class SystemPrinter implements IPrinter {

    public void print(String msg) {
        System.out.print(msg);
    }
}
