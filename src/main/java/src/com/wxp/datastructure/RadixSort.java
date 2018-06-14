package src.com.wxp.datastructure;

/**
 * Created by v_shampoowang on 2018/4/10.
 */
public class RadixSort {
    public static void sort(int[] number, int d) //d表示最大的数有多少位
    {
        int k = 0;
        int n = 1;
        int m = 1; //控制键值排序依据在哪一位
        int[][]temp = new int[10][number.length]; //数组的第一维表示可能的余数0-9
        int[]order = new int[10]; //数组orderp[i]用来表示该位是i的数的个数
        while(m <= d)
        {
            for(int i = 0; i < number.length; i++)
            {
                //获的各位数的值，并使用二维数组，已不同的个位数值为下标，将数据以个位数值进行一次排序
                int lsd = ((number[i] / n) % 10);
                temp[lsd][order[lsd]] = number[i];
                order[lsd]++;
            }

            //将数据，按照个位数由小大大装进number[] ，相当于一次排序
            for(int i = 0; i < 10; i++)
            {
                if(order[i] != 0)
                    for(int j = 0; j < order[i]; j++)
                    {
                        number[k] = temp[i][j];
                        k++;
                    }
                order[i] = 0;
            }
            n *= 10;
            k = 0;
            m++;
        }
    }
    public static void main(String[] args)
    {
        int[]data =
                {73, 22, 93, 43, 55, 14, 28, 65, 39, 81, 33, 100};
        RadixSort.sort(data, 3);
        for(int i = 0; i < data.length; i++)
        {
            System.out.print(data[i] + "\t");
        }
    }
}
