package com.xinxiaxue.test4hf.deal.impl;

/**
 * 数字字母映射处理器
 * @author hezf
 * @date 2020/9/15
 */
public class IntDealer {

    private int iFlag;  //数字
    private String[] letters;   //数字对应字母表

    public IntDealer(String[] letters) {
        this.iFlag = 0;
        this.letters = letters;
    }

    /*
    加一操作，进行进制累计
     */
    public boolean add() {
        if (iFlag + 1 == letters.length) {
            iFlag = 0;  //置0，后续位上升一位
            return true;
        } else {
            iFlag++;
            return false;
        }
    }

    public String load() {
        return this.letters[iFlag];
    }

    /**
     *  联结本处理器的字母
     * @param preLetters    上一次字母组合
     * @return  组合本处理器所有字段的组合结果
     */
//    public List<String> deal(String preLetters) {
//        if (letters == null || letters.length == 0) {
//            return null;
//        }
//
//        List<String> result = new ArrayList<String>();
//        for (int i = 0; i < letters.length; i++) {
//            result.add(preLetters + letters[i]);
//        }
//
//        return result;
//    }


}
