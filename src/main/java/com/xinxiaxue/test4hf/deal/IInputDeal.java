package com.xinxiaxue.test4hf.deal;

import java.util.Map;

/**
 * 输入格式处理器，根据自己需要实现，可以配置文件输入、字符串输入、数据库输入
 * @author hezf
 * @date 2020/9/15
 */
public interface IInputDeal {

    Map<Integer, String[]> deal();
}
