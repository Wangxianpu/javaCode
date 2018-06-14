package src.com.wxp.datastructure.Array;





/**
 * @Author : shampoowang
 * @Date:Created : 2018/6/14 17:00
 * @Description :罗马数转整数
 */
public class RomanToInt {

    public static void main(String[] args) {
        System.out.println(new RomanToInt().romanToInt("III"));
    }

    private boolean isBlank(String str){
        if(str == null || "".equals(str)){
            return true;
        }
        return false;
    }

    public int romanToInt(String romaStr) {
        if(isBlank(romaStr)){
            return 0;
        }
        //罗马数字对应到的： 1000,900, 500, 400, 100, 90, 50, 40,  10,  9,   5,  4,  1
        String[] letters = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        int[] numbers = {1000,900,500,400,100,90,50,40,10,9,5,4,1};

        //游标
        int letterCursor = 0;
        //待返回的值
        int result = 0;

        //记录传入的romaStr的游标
        int cursor = 0;
        while(!isBlank(romaStr)){
            //如果最左边最大数相匹配
            if(romaStr.startsWith(letters[letterCursor])){
                result += numbers[letterCursor];
                romaStr = romaStr.substring(letters[letterCursor].length());
            }else{
                letterCursor++;
            }
            if(letterCursor >= letters.length){
                break;
            }
        }
        return result;
    }

}
