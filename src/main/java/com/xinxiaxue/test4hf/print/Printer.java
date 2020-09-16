package com.xinxiaxue.test4hf.print;

import com.xinxiaxue.test4hf.print.impl.SystemPrinter;

/**
 * 输出器，当前默认为系统输出，如想更换其他，例如log4j之类，可自行实现接口IPrinter类
 * @author hezf
 * @date 2020/9/15
 */
public class Printer {

    public static IPrinter printer = new SystemPrinter();

    public static void print(String msg) {
        printer.print(msg);
    }
}
