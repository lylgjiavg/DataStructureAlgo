package club.lylgjiang.utils;

/**
 * @Classname StringUtils
 * @Description 字符串工具类
 * @Date 2019/9/22 17:34
 * @Created by Jiavg
 */
public class StringUtils {

    private StringUtils() {
    }

    /**
     * 字符串转int数组
     * @param arrayStr
     * @return
     */
    public static int[] stringToIntArray(String arrayStr){
        int[] array;
        
        // 去掉数组字符串两端的[]和空格
        String trim = arrayStr.trim();
        String substring = trim.substring(1, trim.length() - 1);
        
        // 切割字符串
        String[] splitString = substring.split(",");
        
        // 字符串转数字
        array = new int[splitString.length];
        for (int index = 0; index < splitString.length; index++) {
            array[index] = Integer.parseInt(splitString[index]);
        }
        
        return array;
    }

    /**
     * 字符串转String数组
     * @param arrayStr
     * @return
     */
    public static String[] stringToStrArray(String arrayStr){
        String[] array;

        // 去掉数组字符串两端的[]和空格
        String trim = arrayStr.trim();
        String substring = trim.substring(1, trim.length() - 1);

        // 切割字符串
        String[] splitString = substring.split(",");

        return splitString;
    }
    
}
