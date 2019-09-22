package club.lylgjiang.datastructure.sparsearray;

import club.lylgjiang.utils.StringUtils;
import org.junit.Test;

import java.io.*;
import java.net.URL;
import java.util.Arrays;

/**
 * @Classname Issue01
 * @Description 问题:见本包下图问题1
 * @Date 2019/9/22 16:52
 * @Created by Jiavg
 */
public class Issue01 {
    
    @Test
    public void solve() throws IOException {
        // 棋盘数据,1代表黑子,2代表白子
        int[][] array = new int[10][10];
        array[0][1] = 1;
        array[2][3] = 2;
        array[4][5] = 1;
        
        // 
        URL classPath = this.getClass().getResource("/");
        System.out.println();
        // Issue01.writeInfo(array, classPath.getPath(), "a.txt");

        int[][] ints = Issue01.readInfo(classPath.getPath(), "a.txt");
        for (int[] anInt : ints) {
            for (int i : anInt) {
                System.out.printf(i + "\t");
            }
            System.out.println();
        }

    }

    /**
     * 把文件中数据读取成棋盘数组
     * @param path
     * @param filename
     * @return
     * @throws IOException
     */
    public static int[][] readInfo(String path, String filename) throws IOException {

        File file = new File(path + "/" + filename);

        FileInputStream inputStream = new FileInputStream(file);

        StringBuilder builder = new StringBuilder();
        
        byte[] readArr = new byte[1024];
        
        while (inputStream.read(readArr) != -1){
            builder.append(Arrays.toString(readArr));
        }

        String sparseStrArray = builder.toString();

        String[] strings = StringUtils.stringToStrArray(sparseStrArray);
        int[][] array = new int[strings.length][];
        for (int i = 0; i < strings.length; i++) {
            array[i] = StringUtils.stringToIntArray(strings[i]);
        }

        return array;
    }
    
    
    /**
     * 把棋盘数据写出到文件
     * @param array
     * @param path
     * @param filename
     * @throws IOException
     */
    public static void writeInfo(int[][] array, String path, String filename) throws IOException {

        // 创建文件
        File file = new File(path + "/" + filename);

        // 把数组转换为稀疏数组(压缩)
        int[][] sparseArray = SparseArray.arrayToSparseArray(array);

        // 创建文件输出流
        FileOutputStream inputStream = new FileOutputStream(file);

        // 把稀疏数组转换成字符串
        String[] sparseStrArray = new String[array.length];
        for (int row = 0; row < array.length; row++) {
            sparseStrArray[row] = Arrays.toString(array[row]);
        }
        
        // 把信息写出到文件
        inputStream.write(Arrays.toString(sparseStrArray).getBytes());

        // 关闭流
        inputStream.flush();
        inputStream.close();
    }
    
}
