package com.xinxiaxue.test4hf.deal.impl;

import com.xinxiaxue.test4hf.deal.IInputDeal;
import com.xinxiaxue.test4hf.print.Printer;

import java.util.HashMap;
import java.util.Map;

/**
 * 输入数字-字母映射处理器（以字符串方式输入）
 * 格式：数字1:字母1,字母2,字母N;数字2:字母11,字母12,字母1N;
 * 例如：1:;2:A,B,C;3:D,E,F;4:G,H,I;5:J,K,L;6:M,N,O;7:P,Q,R,S;8:T,U,V;9:W,X,Y,Z
 * @author hezf
 * @date 2020/9/15
 */
public class InputDealer implements IInputDeal {

    private String inputStr;

    public InputDealer(String inputStr) {
        this.inputStr = inputStr;
    }

    public Map<Integer, String[]> deal() {
        Map<Integer, String[]> map = new HashMap<Integer, String[]>();
        String[] arr = this.inputStr.split(";");
        for (int i = 0; i < arr.length; i++) {
            String item = arr[i];
            if (!item.contains(":")) {
                Printer.print("格式错误，缺少:号");
                return null;
            }
            item = item.trim();
            String[] intLetters = item.split(":");
            if (intLetters.length != 2) {
                continue;
            }
            map.put(Integer.parseInt(intLetters[0]), intLetters[1].split(","));
        }
        return map;
    }
}
