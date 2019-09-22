package club.lylgjiang.datastructure.arrayqueue;

import java.util.Scanner;

/**
 * @Classname Test
 * @Description 测试类
 * @Date 2019/9/22 23:38
 * @Created by Jiavg
 */
public class Test {

    public static void main(String[] args) {
        ArrayQueue arrayQueue = new ArrayQueue(3);

        Scanner scanner = new Scanner(System.in);

        char cmd = ' ';

        boolean isLoop = true;
        while (isLoop){
            System.out.println("① a(add):添加元素");
            System.out.println("② g(get):取出元素");
            System.out.println("③ h(head):获取元素");
            System.out.println("④ s(show):展示队列");
            System.out.println("⑤ e(exit):退出程序");
            String cmdStr = scanner.next();
            cmd = cmdStr.charAt(0);

            switch (cmd){
                case 'a':
                    System.out.println("请输入一个数据(Int):");
                    arrayQueue.addQueue(scanner.nextInt());
                    break;
                case 'g':
                    System.out.println(arrayQueue.getQueue());
                    break;
                case 'h':
                    System.out.println(arrayQueue.getHeader());
                    break;
                case 's':
                    System.out.println(arrayQueue.showQueue());
                    break;
                case 'e':
                    isLoop = false;
                    break;
            }

        }
        System.out.println("退出程序~");
    }
    
}
