package club.lylgjiang.datastructure.arrayqueue;

import java.util.Arrays;

/**
 * @Classname ArrayQueue
 * @Description 队列:数组实现
 * @Date 2019/9/22 23:17
 * @Created by Jiavg
 */
public class ArrayQueue {
    
    // 队列最大容量
    private int maxSize;
    // 队列头(指向队列第一个元素的前一个位置)
    private int front;
    // 队列尾(指向队列最后一个元素的位置)
    private int tail;
    // 模拟队列的数组
    private int[] queue;

    public ArrayQueue(int maxSize) {
        this.maxSize = maxSize;
        queue = new int[maxSize];
        front = -1;
        tail = -1;
    }

    /**
     * 判断队列是否为空
     * @return
     */
    public boolean isEmpty(){
        return front == tail;
    }

    /**
     * 判断队列是否满
     * @return
     */
    public boolean isFull(){
        return tail == maxSize - 1;
    }

    /**
     * 添加数据到队列
     * @param number
     */
    public void addQueue(int number){
        if(isFull()){
            throw new RuntimeException("队列已满!");
        }
        
        tail++;
        queue[tail] = number;
    }

    /**
     * 取出队列头数据并返回
     * @return
     */
    public int getQueue(){
        if (isEmpty()) {
            throw new RuntimeException("队列为空!");
        }
        
        return queue[++front];
    }

    /**
     * 显示队列
     * @return
     */
    public String showQueue(){
        return Arrays.toString(queue);
    }
    
    /**
     * 获取队列头数据并返回
     * @return
     */
    public int getHeader(){
        if (isEmpty()) {
            throw new RuntimeException("队列为空!");
        }
        
        return queue[front + 1];
    }
    
}
