package com.xinxiaxue.test4hf;

import com.xinxiaxue.test4hf.deal.IInputDeal;
import com.xinxiaxue.test4hf.deal.impl.InputDealer;
import com.xinxiaxue.test4hf.mng.IntMmg;
import org.junit.Test;

import java.util.Map;

/**
 * @author hezf
 * @date 2020/9/15
 */
public class IntLetterTest {

    private IntMmg mng = new IntMmg();

    @Test
    public void test00() {
        //配置数字-字母组合
        String intputConfig = "1";
        IInputDeal iInputDeal = new InputDealer(intputConfig);
        Map<Integer, String[]> config = iInputDeal.deal();
        if (config == null) {
            return;
        }

        mng.init(config);

        //输入要组合的所有数字
        mng.deal(new Integer[]{2});
    }

    @Test
    public void test01() {
        //配置数字-字母组合
        String intputConfig = "1:";
        IInputDeal iInputDeal = new InputDealer(intputConfig);
        Map<Integer, String[]> config = iInputDeal.deal();
        if (config == null) {
            return;
        }

        mng.init(config);

        //输入要组合的所有数字
        mng.deal(new Integer[]{2});
    }

    //测试输入存在重复的情况
    @Test
    public void test02() {
        //配置数字-字母组合
        String intputConfig = "0:;1:;2:A,B,C;3:D,E,F;4:G,H,I;5:J,K,L;6:M,N,O;7:P,Q,R,S;8:T,U,V;9:W,X,Y,Z";
        IInputDeal iInputDeal = new InputDealer(intputConfig);
        Map<Integer, String[]> config = iInputDeal.deal();
        if (config == null) {
            return;
        }

        mng.init(config);

        //输入要组合的所有数字
        mng.deal(new Integer[]{2, 3, 0, 1, 3});
    }

    //测试存在0或者1没有对应字母的情况
    @Test
    public void test03() {
        //配置数字-字母组合
        String intputConfig = "0:;1:;2:A,B,C;3:D,E,F;4:G,H,I;5:J,K,L;6:M,N,O;7:P,Q,R,S;8:T,U,V;9:W,X,Y,Z;99:x,s,d";
        IInputDeal iInputDeal = new InputDealer(intputConfig);
        Map<Integer, String[]> config = iInputDeal.deal();
        if (config == null) {
            return;
        }

        mng.init(config);

        //输入要组合的所有数字
        mng.deal(new Integer[]{4, 0, 1, 99});
    }

    //测试不输入运行的情况
    @Test
    public void test04() {
        //配置数字-字母组合
        String intputConfig = "0:;1:;2:A,B,C;3:D,E,F;4:G,H,I;5:J,K,L;6:M,N,O;7:P,Q,R,S;8:T,U,V;9:W,X,Y,Z;99:x,s,d";
        IInputDeal iInputDeal = new InputDealer(intputConfig);
        Map<Integer, String[]> config = iInputDeal.deal();
        if (config == null) {
            return;
        }

        mng.init(config);

        //输入要组合的所有数字
        mng.deal(null);
    }

    //测试多个选择的情况
    @Test
    public void test05() {
        //配置数字-字母组合
        String intputConfig = "0:;1:;2:A,B,C;3:D,E,F;4:G,H,I;5:J,K,L;6:M,N,O;7:P,Q,R,S;8:T,U,V;9:W,X,Y,Z;99:x,s,d";
        IInputDeal iInputDeal = new InputDealer(intputConfig);
        Map<Integer, String[]> config = iInputDeal.deal();
        if (config == null) {
            return;
        }

        mng.init(config);

        //输入要组合的所有数字
        mng.deal(new Integer[]{4, 0, 1, 5, 6, 8, 9, 99});
    }

    //测试单个选择的情况
    @Test
    public void test06() {
        //配置数字-字母组合
        String intputConfig = "0:;1:;2:A,B,C;3:D,E,F;4:G,H,I;5:J,K,L;6:M,N,O;7:P,Q,R,S;8:T,U,V;9:W,X,Y,Z;99:x,s,d";
        IInputDeal iInputDeal = new InputDealer(intputConfig);
        Map<Integer, String[]> config = iInputDeal.deal();
        if (config == null) {
            return;
        }

        mng.init(config);

        //输入要组合的所有数字
        mng.deal(new Integer[]{9});
    }

    //性能测试，0-99的情况
    /** 打开注释跑即可，注释目的是为了进行快速覆盖测试
    @Test
    public void test07() {
        //配置数字-字母组合
        String intputConfig = "0:;1:;2:A,B,C;3:D,E,F;4:G,H,I;5:J,K,L;6:M,N,O;7:P,Q,R,S;8:T,U,V;9:W,X,Y,Z;99:x,s,d";
        IInputDeal iInputDeal = new InputDealer(intputConfig);
        Map<Integer, String[]> config = iInputDeal.deal();
        if (config == null) {
            return;
        }

        mng.init(config);

        Integer[] input = new Integer[88];
        for (int i = 0; i < 88; i++) {
            input[i] = i % 10;
        }
        //输入要组合的所有数字
        mng.deal(input);
    }
    */
}
