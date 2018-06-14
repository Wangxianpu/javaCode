package src.com.wxp.datastructure.Array;

/**
 * @Author : shampoowang
 * @Date:Created : 2018/6/14 17:35
 * @Description : 最长公共前缀
 */
public class LongestCommonPrefix {

    public static void main(String[] args) {
        System.out.println(new LongestCommonPrefix().longestCommonPrefix(new String[]{"aa","a"}));
    }

    public String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length<1){
            return "";
        }
        //记录相同前缀的游标
        int cursor = 0;
        //记录是否存在相同前缀的状态
        boolean flag = true;
        while(flag){
            //对字符串进行校验，判断是否还存在继续下去的元素
            if(!check(strs[0],cursor,flag)){
                break;
            }
            char temp = strs[0].charAt(cursor);
            for(String str : strs){
                //对字符串进行校验，判断是否还存在继续下去的元素
                flag = check(str,cursor,flag);
                if(flag){
                    if(str.charAt(cursor) != temp){
                        flag = false;
                        break;
                    }
                }
            }
            if(flag){
                cursor++;
            }
        }
        return strs[0].substring(0,cursor);
    }

    private boolean check(String str,int cursor,boolean flag){
        if(str.length()<=cursor){
            flag = false;
        }
        return flag;
    }
}
