package src.com.wxp.datastructure.Array;

/**
 * @Author : shampoowang
 * @Date:Created : 2018/6/14 15:45
 * @Description : 整数转罗马数字
 */
public class RomaNumber {

    public static void main(String[] args) {
        System.out.println(new RomaNumber().intToRoman(888));
    }

    public String intToRoman(int num) {
        StringBuffer result = new StringBuffer();
        //行存位数 4 代表着个十百千，如reflect[0][0~3] 对应着 1 4 5 9
        String[][] reflect = new String[][]{{"I","IV","V","IX"},{"X","XL","L","XC"},{"C","CD","D","CM"},{"M"}};
        if(num>3999||num<1){
            return "error";
        }
        //当前处理位数字
        int dealPosition = 0;
        //当num > 0 时，继续当前操作
        while(num>0){
            //如果是千位，则对应到 “M” ，此时应该应该循环M来表示千位的大小
            if(num >= 1000){
                dealPosition = num/1000;
                for(int i = 0 ; i < dealPosition ; i++){
                    result.append("M");
                }
                num = num % 1000;
                dealPosition = 0;
            }else{
                //值的长度，位数为numLength
                int numLength = String.valueOf(num).length();
                dealPosition = (int) (num / (Math.pow(10,numLength-1)));
                dealString(dealPosition,numLength,reflect,result);
                num = (int) (num % (Math.pow(10,numLength-1)));
                dealPosition = 0;
            }

        }
        return result.toString();
    }

    private void dealString(int dealPosition, int numLength, String[][] reflect,StringBuffer result) {
        while (dealPosition > 0) {
            if (dealPosition >= 5) {
                if (dealPosition == 9) {
                    result.append(reflect[numLength - 1][3]);
                    dealPosition = dealPosition - 9;
                }else{
                    result.append(reflect[numLength - 1][2]);
                    dealPosition = dealPosition - 5;
                }
            }else if (dealPosition == 4) {
                result.append(reflect[numLength - 1][1]);
                dealPosition = dealPosition - 4;
            }else{
                result.append(reflect[numLength - 1][0]);
                dealPosition = dealPosition - 1;
            }
        }
    }
}


