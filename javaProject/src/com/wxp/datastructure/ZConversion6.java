package com.wxp.datastructure;

/**
 * Z字形转换
 * Created by v_shampoowang on 2018/4/12.
 */
public class ZConversion6 {
    public static void main(String[] args){
        ZConversion6 test = new ZConversion6();
        System.out.print(test.convert("PAYPALISHIRING",3));

    }

    public String convert(String s, int numRows) {
        //如果字符串只有一个字符或是空，或者转换为z的边为1，则直接返回s
        if(s.length()<=1||numRows==1){
            return s;
        }
        char[] c = s.toCharArray();
        int top = 1 ;
        int cross = 1 ;
        //是否向下延伸 1:向下，-1：向上
        int isDown = 1;
        //用于存放z型字符
        char[][] zChars = new char[c.length/(numRows-1) +1][numRows];

        for(int i = 0 ;i<c.length;){
            if(top<numRows && top > 1){
                zChars[cross-1][top-1] = c[i];
                if(isDown == 1){
                    top++;
                }else{
                    top--;
                }
                i++;
            }
            //当延伸到头尾的时候，并且不是第一列的时候变向
            if(top==1&&i<c.length){
                if(cross>1){
                    //改变延伸方向
                    isDown = - isDown;
                    cross++;
                }
                zChars[cross-1][top-1] = c[i];
                top++;
                i++;
            }

            //如果延伸到了尾，则变向，并且另起一行
            if(top == numRows&&i<c.length){
                zChars[cross-1][top-1] = c[i];
                isDown = -isDown;
                cross++;
                top--;
                i++;
            }
        }
        char[] result = new char[c.length];
        int cursor=0;
        for(int i = 0;i<zChars[0].length;i++){
            for(int j = 0;j<zChars.length;j++){
                if(zChars[j][i] != '\u0000'){
                    result[cursor] = zChars[j][i];
                    cursor++;
                }
//                System.out.print(zChars[j][i]+"\t");
            }
//            System.out.println();
        }

        return String.copyValueOf(result);
    }
}
