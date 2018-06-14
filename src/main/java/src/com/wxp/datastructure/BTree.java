package src.com.wxp.datastructure;

/**
 * Created by v_shampoowang on 2018/4/8.
 */
public class BTree {

    public static void main(String[] args){
        int[] nums1 = new int[]{1,3,4};
        int[] nums2 = new int[]{2};
        System.out.println("最后的结果是："+findMedianSortedArrays(nums1,nums2));
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1 == null || nums2 == null)
            return  0.0;
        int[] arraySum ;
        if(nums1.length==0){
            arraySum = nums2;
        }else if(nums2.length == 0){
            arraySum = nums1;
        }else{
            arraySum = new int[nums1.length + nums2.length];

            for(int i = 0 , j = 0;i<nums1.length  ;i++){
                if((j < nums2.length && nums1[i] <= nums2[j])){
                    arraySum[i+j] = nums1[i];
                }else{
                    while(i<nums1.length && j<nums2.length
                            && nums1[i] > nums2[j]){
                        arraySum[i+j] = nums2[j];
                        j++;
                    }
                    arraySum[i+j] = nums1[i];
                }
                //如果nums2没有处理完,而nums1已经处理完，这时nums2的最大值会大于或是等于nums1的最大值
                if( i == nums1.length-1  && nums2[nums2.length-1]>=nums1[nums1.length-1]){
                    while(j<nums2.length){
                        arraySum[i+j+1] = nums2[j];
                        j++;
                    }
                }
            }
        }
        if(arraySum.length%2 == 0 && arraySum.length > 1){
            return (arraySum[arraySum.length/2-1]+arraySum[arraySum.length/2])/2.0;
        }else if(arraySum.length <= 1 ){
            return arraySum.length == 1 ? arraySum[0] : 0.0 ;
        }
        return arraySum[(arraySum.length/2 + 1)-1];
    }
}
