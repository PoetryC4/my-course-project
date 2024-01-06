package com.companypowernode;

import java.io.BufferedReader;
import java.io.InputStreamReader;
public class pyTest1 {



        /**
         * 将整型state数组转换为带分隔符的字符串，方便以命令方式传递给Python文件以进行计算
         * @param stateInt 当前虚机 + 所有主机状态向量
         * @return
         */
        public static String state2str(int[][] stateInt){
            String stateStr = "";
            for (int i = 0; i < stateInt.length; i++) {
                for (int j = 0; j < stateInt[0].length; j++) {
                    if (j == 0)  stateStr += String.valueOf(stateInt[i][j]);
                    else         stateStr += " " + String.valueOf(stateInt[i][j]);
                }
                if (i != stateInt.length - 1)  stateStr += ";";
            }
            return stateStr;
        }

        public static void main(String[] args) throws Exception {
            // Python文件地址(Linux)
            String pyPath = "D:\\Javaproj\\company\\src\\main\\resources\\py\\test2.py";

            int[][] stateInt = new int[][]{{2500, 5, 2610, 2620, 2630, 2640, 2650, 2660},  // Mips
                    {870,  5, 4091, 4092, 4093, 4094, 4095, 4096}}; // RAM
            // 将整型state数组转换为带分隔符的字符串，方便以命令方式传递给Python文件以进行计算
            String stateStr = state2str(stateInt);
            String[] args1 = new String[] {"python", pyPath, stateStr};
            // 执行Python文件，并传入参数
            Process proc = Runtime.getRuntime().exec(args1);
            // 获取Python输出字符串作为输入流被Java读取
            BufferedReader in = new BufferedReader(new InputStreamReader( proc.getInputStream() ));
            String actionStr = in.readLine();
            if (actionStr != null)
                System.out.println(actionStr);

            in.close();
            proc.waitFor();

            // 将获取的字符串分割为字符串数组，然后逐个元素转换为int并求和
            assert actionStr != null;
            String[] nums = actionStr.split("");
            int sum = 0;
            for (String num : nums) sum += Integer.parseInt(num);
            System.out.println("求和为：" + sum);
        }
    }



