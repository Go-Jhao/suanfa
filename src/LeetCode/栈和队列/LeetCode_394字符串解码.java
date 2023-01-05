package LeetCode.栈和队列;

import java.util.Stack;

public class LeetCode_394字符串解码 {
    public String decodeString(String s) {
        String res = "";
        Stack<Integer> countStack = new Stack<Integer>();
        Stack<String> resStack = new Stack<String>();
        int idx = 0;
        while (idx < s.length()){
            char cur = s.charAt(idx);
            //处理数字
            if(Character.isDigit(cur)){
                StringBuffer ret = new StringBuffer();
                while (Character.isDigit(s.charAt(idx))){
                    ret.append(s.charAt(idx++));
                }
                countStack.push(Integer.parseInt(ret.toString()));
            }
            else if (cur == '['){
                //处理“[”
                resStack.push(res);
                res = "";
                idx++;
            }
            else if (cur == ']'){
                //处理“]”，处理相互匹配的“[”之间的字符
                StringBuffer temp = new StringBuffer(resStack.pop());
                int repeatTimes = countStack.pop();
                for (int i = 0; i < repeatTimes; i++) {
                    temp.append(res);
                }
                res = temp.toString();
                idx++;
            }
            else {
                //处理普通字符
                res += s.charAt(idx++);
            }

        }
        return res;
    }
}
