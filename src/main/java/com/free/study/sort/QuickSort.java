package com.free.study.sort;

import java.util.Arrays;
import java.util.Random;
import java.util.Stack;

/**
 * @description: 快速排序算法
 * @author: chenlongjs
 * @date: 2018/1/7
 */
public class QuickSort {

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        int [] data1 = randomData();
        int [] data2 = Arrays.copyOfRange(data1, 0, data1.length);
        System.out.println("原数组：");
        print(data1);
        long t1 = System.currentTimeMillis();

        sortByRecursion(data1, 0, 9);

        System.out.println("\n递归方式，实现快速排序结果：");
        print(data1);
        long t2 = System.currentTimeMillis();
        System.out.println("\n耗时(ms)：" + (t2 - t1));

        sort(data2, 0, 9, stack);

        System.out.println("非递归方式，实现快速排序结果：");
        print(data2);
        System.out.println("\n耗时(ms)：" + (System.currentTimeMillis() - t2));
    }

    private static int[] randomData() {
        Random random = new Random();
        int data[] = new int[10];
        for (int i = 0; i < 10; i++) {
            data[i] = random.nextInt(100);
        }
        return data;
    }

    private static void print(int data[]) {
        for (int a : data) {
            System.out.print(a + ",");
        }
    }

    /**
     * 快速排序的递归实现
     */
    private static void sortByRecursion(int data[], int start, int end) {
        if (data.length <= 1) {
            return ;
        }
        if (start < end) {
            // 找一个基准，按规则进行置换
            int index = partition(data, start, end);
            // 从基准的位置将数组分成前后两部分，分别递归执行同样的逻辑
            sortByRecursion(data, start, index - 1);
            sortByRecursion(data, index + 1, end);
        }
    }

    /**
     * 快速排序的非递归实现
     */
    private static void sort(int data[], int start, int end, Stack<Integer> stack) {
        doPartition(data, start, end, stack);
        while (!stack.empty()) {
            int high = stack.pop();
            int low = stack.pop();
            doPartition(data, low, high, stack);
        }
    }

    private static void doPartition(int[] data, int start, int end, Stack<Integer> stack) {
        int index = partition(data, start, end);
        if (index - 1 > start) {
            stack.push(start);
            stack.push(index -1);
        }
        if (index + 1 < end) {
            stack.push(index + 1);
            stack.push(end);
        }
    }

    /**
     * 以第一个数作为基准，大于基准的数，换到后边；小于基准的数，换到前边
     * @param data 原数组
     * @param low 开始位置
     * @param high 结束位置
     * @return 基准的下标
     */
    private static int partition(int data[], int low, int high) {
        int pivot = data[low];
        while (low < high ) {
            while (data[high] >= pivot && low < high) {
                high --;
            }
            data[low] = data[high];
            while (data[low] < pivot && low < high) {
                low ++;
            }
            data[high] = data[low];

        }
        data[low] = pivot;
        return low;
    }
}
