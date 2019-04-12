package org.sheng.leetcode.dynamic.programming;

import java.util.Comparator;

/**
 * @author sheng 2019/3/20
 * @desc todo
 */
public class NonOverlappingIntervals {
    public static void main(String[] args) {
        Interval[] intervals = new Interval[3];
        Interval interval1 = new Interval(1, 2);
        Interval interval2 = new Interval(2, 3);
        Interval interval3 = new Interval(2, 4);
        intervals[0] = interval1;
        intervals[1] = interval2;
        intervals[2] = interval3;

        int i = new NonOverlappingIntervals().eraseOverlapIntervals(intervals);
        System.out.println(i);

    }

    /**
     * 动态规划解法，类似于 最常上升子序列问题(LCS)
     * 状态转移方程：F(n) = max(1 + (F(i)(if(si) >= (sj)))
     */
    private int eraseOverlapIntervals(Interval[] intervals) {
        int length = intervals.length;

        if (length <= 1) {
            return 0;
        }

        // 前提是 intervals 是有序的
        sort(intervals);

        // 开始计算每个以他为结尾的区间所能形成的最长的没有发生覆盖的连续区间，初始化都为1
        int[] resultArray = initIntArray(length, 1);

        for (int i = 1; i < intervals.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (intervals[i].start >= intervals[j].end && resultArray[i] <= resultArray[j]) {
                    resultArray[i] = resultArray[j] + 1;
                }
            }
        }

        int max = 1;
        for (int i = 1; i < intervals.length; i++) {
            if (resultArray[i] > max) {
                max = resultArray[i];
            }
        }

        return intervals.length - max;

    }

    private void sort(Interval[] interval) {
        int n = interval.length - 1;

        for (int i = 0; i < n; i++) {
            int min = chooseMin(interval, i, n, Comparator.comparingInt(o -> o.start));

            swap(interval, i, min);
        }

    }

    private int chooseMin(Interval[] interval, int begin, int end, Comparator<Interval> comparator) {
        int min = begin;
        for (int i = begin + 1; i <= end; i++) {
            int result = comparator.compare(interval[min], interval[i]);
            if (result > 0) {
                min = i;
            }
        }
        return min;
    }

    private void swap(Interval[] intervals, int left, int right) {
        Interval temp = intervals[left];
        intervals[left] = intervals[right];
        intervals[right] = temp;
    }

    private int[] initIntArray(int length, int initValue) {
        int[] result = new int[length];
        for (int i = 0; i < length; i++) {
            result[i] = initValue;
        }

        return result;
    }
}

class Interval {
    int start;
    int end;

    Interval() {
        start = 0;
        end = 0;
    }

    Interval(int s, int e) {
        start = s;
        end = e;
    }
}
