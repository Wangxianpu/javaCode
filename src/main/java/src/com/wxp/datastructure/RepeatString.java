package src.com.wxp.datastructure;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by v_shampoowang on 2018/4/8.
 */
public class RepeatString {
    public static void main(String[] args){
        System.out.println("最长重复字段长：" + lengthOfLongestSubstring(""));
    }

    public static int lengthOfLongestSubstring(String s) {
        if(s == null || s.length()==0)
            return 0;
        List<StringBuffer> list = new ArrayList<StringBuffer>();
        list.add(new StringBuffer());
        int index = 0;
        for(int i = 0;i<s.length();i++){
            String word = String.valueOf(s.charAt(i));

            //如果不包含 则可以拼接到list中
            if(!list.get(index).toString().contains(word)){
                list.get(index).append(word);
            }else{
                //发现重复字符串，需要新增元素，并且将前面不重复的部分拷贝过来
                index++;
                list.add(new StringBuffer(word));
                int indexOfWord = list.get(index-1).toString().indexOf(word);//前一个字符串该字出现的位置
                list.get(index).insert(0,list.get(index-1).substring(indexOfWord+1,list.get(index-1).length()));
            }

        }
        List<Integer> nums = new ArrayList<Integer>(list.size());
        for(int i = 0 ; i<list.size() ; i++){
            nums.add(list.get(i).toString().length());
        }
        Collections.sort(nums);
        return  nums.get(nums.size()-1);
    }


    public static int lengthOfLongestSubstring2(String s) {
        int[] list = new int[256]; // 初始化asc码数的字符数值，都默认为 -1
        int previous = -1, right = 0, max_len = 0;
        for(int i=0;i<list.length;i++){
            list[i]=-1;
        }
        //进行遍历，每王右走一个字符，right就增加一，代表着第几个字符。
        //如果出现重复的字符，那么当前的 list[(int)c] 的值就会>-1（出现过的字符的值为对应right值，即第几个）
        //同时precious也一直保持着最近出现的 重复字符的上此次出现的 坐标
        //因此，每次出现重复字符，并且重复字符的坐标在previous之后的，这可以表示为在之后出现了重复字符串，
        // 同时记录该字符串起始位置 previous = list[(int)c] (该字符串结束位置为list[(int)c] = right++)
        //Math.max(max_len, right - previous) 一直保持着最长字符串的长度
        while(right<s.length()){
            char c = s.charAt(right);
            if(list[(int)c] > previous)
                previous = list[(int)c];
            max_len = Math.max(max_len, right - previous);
            list[(int)c] = right++;
        }
        return max_len;
    }

}
