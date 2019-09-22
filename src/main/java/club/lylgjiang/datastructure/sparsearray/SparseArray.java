package club.lylgjiang.datastructure.sparsearray;

import org.junit.Test;

/**
 * @Classname SparseArray
 * @Description 稀疏数组
 *  当一个数组中大部分元素为０，或者为同一个值的数组时，可以使用稀疏数组来保存该数组。
 *
 *  稀疏数组的处理方法是:
 *      记录数组一共有几行几列，有多少个不同的值
 *      把具有不同值的元素的行列及值记录在一个小规模的数组中，从而缩小程序的规模
 * @Date 2019/9/22 16:05
 * @Created by Jiavg
 */
public class SparseArray {

    
    @Test
    public void test(){
        
        int[][] array = new int[10][10];
        array[0][1] = 1;
        array[2][3] = 2;
        array[4][5] = 3;

        // 测试数组转稀疏数组
        int[][] sparseArray = SparseArray.arrayToSparseArray(array);
        
        // 遍历验证
        System.out.printf("%s\t%s\t%s\t\n", "row", "line", "value");
        for (int[] ints : sparseArray) {
            System.out.printf("%d\t%d\t%d\t\n", ints[0], ints[1], ints[2]);
        }
        
        // 测试稀疏数组转数组
        int[][] array2 = SparseArray.sparseArrayToArray(sparseArray);
        
        // 遍历验证
        for (int[] ints : array2) {
            for (int anInt : ints) {
                System.out.printf(anInt + "\t");
            }
            System.out.println("");
        }


    }
    
    
    /**
     * 数组转稀疏数组
     * @param arrays
     * @return
     */
    public static int[][] arrayToSparseArray(int[][] arrays){
        if(arrays == null){
            return null;
        }
        
        // 遍历数组,查找数组中元素个数
        int arraySize = 0;
        for (int[] array : arrays) {
            for (int number : array) {
                if(number != 0){
                    arraySize++;
                }
            }
        }
        
        // 创建稀疏数组,数组行数为元素个数加1,加上的一行为记录稀疏数组的行和列值以及多少个不同的值
        int[][] sparseArray = new int[arraySize+1][3];
        
        // 稀疏数组第一行记录数组一共有几行几列，有多少个不同的值
        sparseArray[0][0] = arrays.length;
        if(arrays[0] != null){
            sparseArray[0][1] = arrays[0].length;
        }
        sparseArray[0][2] = arraySize;
        
        // 把数组中的元素信息放入稀疏数组中
        int numberIndex = 0;
        for (int raw = 0; raw < arrays.length; raw++) {
            for (int line = 0; line < arrays[raw].length; line++) {
                if(arrays[raw][line] != 0){
                    numberIndex++;
                    // 记录数组中元素的行,列,值的信息
                    sparseArray[numberIndex][0] = raw;
                    sparseArray[numberIndex][1] = line;
                    sparseArray[numberIndex][2] = arrays[raw][line];  
                }
            }
        }

        return sparseArray;
    }

    /**
     * 稀疏数组转数组
     * @param sparseArray
     * @return
     */
    public static int[][] sparseArrayToArray(int[][] sparseArray){
        
        // 根据稀疏数组的第一行创建原数组
        int[][]  array = new int[sparseArray[0][0]][sparseArray[0][1]];
        
        // 根据稀疏数组中元素信息对原数组进行初始化
        // 跳过稀疏数组的第一行(非元素信息,是数组信息)
        boolean isOne = true;
        for (int[] numberInfo : sparseArray) {
            if(isOne){
                isOne = false;
                continue;
            }
            // numberInfo[0]:元素的行
            // numberInfo[1]:元素的列
            // numberInfo[2]:元素的值
            array[numberInfo[0]][numberInfo[1]] = numberInfo[2];
        }
        
        return array;
    }
    
}
