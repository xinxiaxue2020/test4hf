本项目主要解决字数-字母组合算法的问题


核心算法思路为数字进制不断添加方式，如下：
0123456789对应的进制为（0)(0)(3)(3)(3)(3)(3)(4)(3)(4)
不断由右边的低位加1，这样可以覆盖所有情况




主程序入口主要由以下代码组成：
//配置数字-字母组合
String intputConfig = "1:;2:A,B,C;3:D,E,F;4:G,H,I;5:J,K,L;6:M,N,O;7:P,Q,R,S;8:T,U,V;9:W,X,Y,Z;99:x,s,d";

IInputDeal iInputDeal = new InputDealer(intputConfig);

Map<Integer, String[]> config = iInputDeal.deal();
if (config == null) {
    return;
}

IntMmg mng = new IntMmg();
mng.init(config);

//输入要组合的所有数字
mng.deal(new Integer[]{2, 3, 0, 1, 99});