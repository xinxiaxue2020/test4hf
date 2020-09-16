package com.xinxiaxue.test4hf.mng;

import com.xinxiaxue.test4hf.deal.impl.IntDealer;
import com.xinxiaxue.test4hf.print.Printer;

import java.util.*;

/**
 * 映射管理器
 * @author hezf
 * @date 2020/9/15
 */
public class IntMmg {

    private static Map<Integer, String[]> dataLetterMap = new HashMap<Integer, String[]>();   //数字-字母映射表


    /**
     * 初妈化数字-字母映射
     * @param dataMap
     */
    public void init(Map<Integer, String[]> dataMap) {
        dataLetterMap = dataMap;
    }

    /**
     * 开始进行数字对应的字母组合
     * @param ints  输入的数字
     */
    public void deal(Integer[] ints) {
        Printer.print("开始组合字母\n");
        if (ints == null || ints.length == 0) {
            Printer.print("============无输入============\n");
            return;
        }


        List<IntDealer> dealerList = new ArrayList<IntDealer>();
        for (int i = 0; i < ints.length; i++) {
            String[] letters = dataLetterMap.get(ints[i]);

            if (letters == null) {
                Printer.print(ints[i] + "配置不存在，忽略\n");
                continue;
            }
            dealerList.add(new IntDealer(letters));
        }
        if (dealerList.isEmpty()) {
            Printer.print("组合不出结果\n");
            return;
        }

        //进行进制位不断增加，覆盖所有情况
        boolean isBreak = false;
        printOne(dealerList);
        while (true) {
            for (int i = dealerList.size() - 1; i >= 0; i--) {
                IntDealer dealer = dealerList.get(i);
                boolean add4After = dealer.add();
                if (!add4After) {   //不用处理后续进制问题
                    printOne(dealerList);
                    break;
                }
                if (i == 0) {
                    isBreak = true;
                    break;
                }
            }
            if (isBreak) {  //进制位已经到头，退出循环
                break;
            }
        }

        Printer.print("\n结束组合字母");
    }

    private int count = 0;  //为了打印时分行打好而设置的计数器
    private void printOne(List<IntDealer> dealerList) {
        StringBuffer buff = new StringBuffer();
        for (int i = 0; i < dealerList.size(); i++) {
            buff.append(dealerList.get(i).load());
        }
        if (count > 0 && count % 10 > 0) {  //添加组合字母的空格分隔
            Printer.print(" ");
        }
        Printer.print(buff.toString());
        count++;
        if (count % 10 == 0) {//每打印10字母组合就换行
            Printer.print("\n");
        }
    }

}
