package src.com.wxp.datastructure;

/**
 * Created by v_shampoowang on 2018/4/12.
 */
public class Atoi8 {
    public static void main(String[] args){
        Atoi8 test = new Atoi8();
        System.out.println(test.myAtoi("--123"));
    }
    public int myAtoi(String str) {
        char[] c = str.toCharArray();
        long number = 0;
        int cursor=0;//用于记录目标char[]的下标
        //用于存储用来转换成数字的字符
        char[] target = new char[c.length];
        boolean flag = false;//是否变动标志，因为+-2是0，所以贼坑
        int signTimes = 0;//变动次数，如果变了，times还为0，则表示+-数量相同，并且>0表示+，<0表示-
        int changes = 0;
        for(int i = 0;i<c.length;i++){
            //如果是数字
            if((int)c[i]>=48&&(int)c[i]<=57){
                if(changes>=2) return 0;
                if(flag&&target[0]=='\u0000'){
                    if(signTimes==0){
                        return 0;
                    }else if(signTimes>0){
                        target[0]='+';
                    }else{
                        target[0]='-';
                    }
                    cursor++;
                }
                target[cursor]=c[i];
                cursor++;
            }else if(((int)c[i]==43||(int)c[i]==45)
                    &&i<c.length-1
                    &&target[0]=='\u0000'){
                while(i<c.length-1&&(((int)c[i+1]>=48&&(int)c[i+1]<=57)||(int)c[i+1]==43||(int)c[i+1]==45||c[i+1]==' ')){
                    if(c[i]==' '){
                        i++;
                        signTimes=0;
                        continue;
                    }
                    //如果下一位是数字，则结束循环
                    if((int)c[i]>=48&&(int)c[i]<=57){
                        if(flag){
                            if(signTimes==0){
                                return 0;
                            }else if(signTimes>0){
                                target[0]='+';
                            }else{
                                target[0]='-';
                            }
                            cursor++;
                        }
                        break;
                    }else if((int)c[i]==43){//如果当前是+
                        signTimes += 1;
                        flag = true;
                        changes++;
                    }else if((int)c[i]==45){//如果当前是-
                        signTimes -= 1;
                        flag = true;
                        changes++;
                    }
                    i++;
                }
                //符号修改过，并且是数字
                if(flag&&(int)c[i]>=48&&(int)c[i]<=57) i--;
            }else{//如果是字符
                if(target[0]!='\u0000'){
                    break;
                }
            }
        }

        String numStr = String.valueOf(target).substring(0,cursor);
        if(numStr.length()==0||numStr.equals("+")||numStr.equals("-")){
            return 0;
        }
        //如果带符号的字符串长度>=12则已经超过了int的最大范围，返回最大值或是最小值
        if(numStr.length()>=12){
            //如果是负数,则返回最小int值
            if((int)target[0]==45){
                return Integer.MIN_VALUE;
            }
            return Integer.MAX_VALUE;
        }
        //装换成long
        number = Long.valueOf(numStr);
        if(number<=Integer.MIN_VALUE){
            return Integer.MIN_VALUE;
        }else if(number>Integer.MAX_VALUE){
            return Integer.MAX_VALUE;
        }
        return (int)number;
    }
}
