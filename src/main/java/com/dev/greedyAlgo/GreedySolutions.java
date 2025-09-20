package com.dev.greedyAlgo;

import com.dev.greedyAlgo.pojos.Item;
import com.dev.greedyAlgo.pojos.ItemComparator;
import com.dev.greedyAlgo.pojos.Job;
import com.dev.greedyAlgo.pojos.Meeting;
import com.dev.greedyAlgo.pojos.MeetingComparator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created on 27/12/2024
 * Project -  DsaPractice
 * Author - Devesh Kumar
 */
public class GreedySolutions {

    /**
     * @param greed
     * @param size
     * @return returns max assignable cookies
     * <p>
     * TC = O(n log n) because we are sorting
     */
    public int maxAssignableCookies(int[] greed, int[] size) {
        Arrays.sort(greed);
        Arrays.sort(size);
        int lp = 0;
        int rp = 0;
        while (lp < greed.length && rp < size.length) {
            if (size[rp] >= greed[lp]) {
                lp++;
            }
            rp++;
        }
        return lp + 1;
    }

    public double fractionalKnapsack(int weight, Item[] arr, int n) {

        Arrays.sort(arr, new ItemComparator());
        double totalValue = 0;
        double availableWeight = weight;

        Arrays.stream(arr).forEach(item -> {
            System.out.print(item.getValue() + " - " + item.getWeight() + "\n");
        });

        for (Item item : arr) {
            double itemWeight = item.getWeight();
            double itemValue = item.getValue();
            if (itemWeight <= availableWeight) {
                totalValue = totalValue + itemValue;
                availableWeight = availableWeight - itemWeight;
            } else if (availableWeight > 0) {
                double unitValue = itemValue / itemWeight;
                totalValue += unitValue * availableWeight;
                return totalValue;
            }
        }
        return totalValue;

    }

    public List<Integer> findMinNoOfCoins(int[] coins, int v) {
        Arrays.sort(coins);
        int currentVal = v;
        List<Integer> coinsList = new ArrayList<>();
        int coinCounter = coins.length - 1;
        while (currentVal > 0) {
            if (coins[coinCounter] <= currentVal) {
                currentVal -= coins[coinCounter];
                coinsList.add(coins[coinCounter]);
            } else {
                coinCounter--;
            }
        }
        return coinsList;
    }

    /**
     * Given an array representing a queue of customers and the value of bills they hold, determine if it is
     * possible to provide correct change to each customer. Customers can only pay with 5$, 10$ or 20$ bills
     * and we initially do not have any change at hand. Return true, if it is possible to provide correct
     * change for each customer otherwise return false.
     *
     * @param bills
     * @return
     */
    public boolean lemonadeChange(List<Integer> bills) {
        int five = 0, ten = 0;
        for (Integer bill : bills) {
            if (bill == 5) {
                five++;
            } else if (bill == 10) {
                if (five > 0) {
                    five--;
                    ten++;
                } else {
                    return false;
                }
            } else {
                if (five > 0 && ten > 0) {
                    five--;
                    ten--;
                } else if (five >= 3) {
                    five -= 3;
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * TC = O(n)
     * SC = O(1)
     *
     * @param str
     * @return
     */
    public boolean checkValidParenthesis(String str) {
        int min = 0;
        int max = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(') {
                min++;
                max++;
            } else if (str.charAt(i) == ')') {
                min--;
                max--;
            } else {
                min--;
                max++;
            }
            if (min < 0) {
                min = 0;
            }
            if (max < 0) return false;
        }
        return min == 0;
    }

    /**
     * Problem Statement: There is one meeting room in a firm. You are given two arrays, start and end each of size N.For an index ‘i’,
     * start[i] denotes the starting time of the ith meeting while end[i]  will denote the ending time of the ith meeting. Find the maximum
     * number of meetings that can be
     * accommodated if only one meeting can happen in the room at a  particular time. Print the order in which these meetings will be performed.
     *
     * @param start
     * @param end
     * @param n
     */
    public void maxPossibleMeetings(int[] start, int[] end, int n) {
        List<Meeting> meetings = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            meetings.add(new Meeting(start[i], end[i], i));
        }

        Collections.sort(meetings, new MeetingComparator());

        List<Integer> answer = new ArrayList<>();
        answer.add(meetings.get(0).getPos());
        for (int i = 1; i < start.length; i++) {
            if (meetings.get(i).getStart() > meetings.get(i - 1).getEnd()) {
                answer.add(meetings.get(i).getPos());
            }
        }

        System.out.println("The order in which the meetings will be performed is ");
        for (int i = 0; i < answer.size(); i++) {
            System.out.print(answer.get(i) + " ");
        }
    }

    /**
     * Problem Statement: Given an array where each element represents the maximum number of
     * steps you can jump forward from that element, return true if we can reach the last
     * index starting from the first index. Otherwise, return false.
     *
     * @param nums
     * @return
     */
    public boolean canJump(int[] nums) {
        if (nums.length == 1) return true;
        int max = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (max < i) return false;
            max = Math.max(max, i + nums[i]);
            if (max >= n - 1) return true;
        }
        return false;
    }

    /**
     * You are given a 0-indexed array of integers nums of length n. You are initially positioned at nums[0].
     * <p>
     * Each element nums[i] represents the maximum length of a forward jump from index i. In other words, if you are at nums[i], you can jump to any nums[i + j] where:
     * <p>
     * 0 <= j <= nums[i] and
     * i + j < n
     * Return the minimum number of jumps to reach nums[n - 1]. The test cases are generated such that you can reach nums[n - 1].
     * TODO: Need to check the logic not covering all the test cases
     * @param nums
     * @return
     */
    public int minJumps(int[] nums) {
        if (nums.length <= 1) {
            return 0;
        }

        if (nums[0] == 0) {
            return -1;
        }
        int coverage = 0;
        int lastJumpIndx = 0;
        int totalJump = 0;
        int destination = nums.length - 1;

        for (int i = 0; i <= destination; i++) {
            coverage = Math.max(coverage, i + nums[i]);
            if (i == lastJumpIndx) {
                lastJumpIndx = coverage;
                totalJump++;
                if (coverage >= destination) return totalJump;
            }

        }
        return totalJump;

    }

    public int minJumps1(int[] arr) {
        if (arr.length <= 1) {
            return 0;
        }

        if (arr[0] == 0) {
            return -1;
        }

        int maxReach = arr[0];
        int steps = arr[0];
        int jumps = 1;

        for (int i = 1; i < arr.length; i++) {
            if (i == arr.length - 1) {
                return jumps;
            }
            maxReach = Math.max(maxReach, i + arr[i]);
            steps--;
            if (steps == 0) {
                jumps++;
                if (i >= maxReach) {
                    return -1;
                }
                steps = maxReach - i;
            }
        }

        return -1;
    }
    /**
     * Function to find the minimum number of platforms required at the
     * railway station such that no train waits.
     *
     * @param arr
     * @param dep
     * @return
     */
    public int findPlatform(int arr[], int dep[]) {
        Arrays.sort(arr);
        Arrays.sort(dep);

        int i = 0, j = 0;
        int n = arr.length;
        int count = 0;
        int maxPlatform = 0;
        while (i < n) {
            if (arr[i] <= dep[j]) {
                count++;
                i++;
            } else {
                count--;
                j++;
            }
            maxPlatform = Math.max(maxPlatform, count);

        }
        return maxPlatform;
    }

    /**
     * You are given a set of N jobs where each job comes with a deadline and profit.
     * The profit can only be earned upon completing the job within its deadline.
     * Find the number of jobs done and the maximum profit that can be obtained.
     * Each job takes a single unit of time and only one job can be performed at
     * a time.
     *
     * @param id
     * @param deadline
     * @param profit
     * @return
     */
    public ArrayList<Integer> jobSequencing(int[] id, int[] deadline, int[] profit) {
        List<Job> jobs = new ArrayList<>();
        int maxDeadline = 0;
        for (int i = 0; i < id.length; i++) {
            jobs.add(new Job(id[i], deadline[i], profit[i]));
            maxDeadline = Math.max(maxDeadline, deadline[i]);
        }

        jobs.sort((job1, job2) -> job2.profit - job1.profit);
        int[] jobIds = new int[maxDeadline + 1];

        Integer[] answer = new Integer[]{0, 0};

        jobs.forEach(job -> {
            for (int currId = job.deadline; currId > 0; currId--) {
                if (jobIds[currId] == 0) {
                    jobIds[currId] = job.id;
                    answer[0] = answer[0] + 1;
                    answer[1] = answer[1] + job.profit;
                    break;
                }
            }
        });
        ArrayList<Integer> result = new ArrayList<>();
        result.add(answer[0]);
        result.add(answer[1]);
        return result;
    }

    /**
     * There are n children standing in a line. Each child is assigned a rating value given in the integer array ratings.
     * You are giving candies to these children subjected to the following requirements:
     * Each child must have at least one candy.
     * Children with a higher rating get more candies than their neighbors.
     * Return the minimum number of candies you need to have to distribute the candies to the children.
     *
     * @param ratings
     * @return
     */
    public int candy(int[] ratings) {
        int i = 1;
        int n = ratings.length;

        int sum = 1;
        while (i < n) {
            if (ratings[i] == ratings[i - 1]) {
                i++;
                sum += 1;
                continue;
            }

            int peak = 1;
            while (i < n && ratings[i] > ratings[i - 1]) {
                i++;
                peak++;
                sum += peak;
            }

            int dip = 1;
            while (i < n && ratings[i] < ratings[i - 1]) {
                i++;
                sum += dip;
                dip++;
            }

            if (dip > peak) {
                sum += dip - peak;
            }
        }
        return sum;
    }

    /**
     * He is assigned with the task of calculating average waiting time of all the processes by following
     * shortest job first policy.
     * <p>
     * The shortest job first (SJF) or shortest job next, is a scheduling policy that selects the waiting
     * process with the smallest execution time to execute next.
     * <p>
     * Given an array of integers bt of size n. Array bt denotes the burst time of each process.
     * Calculate the average waiting time of all the processes and return the nearest integer which is
     * smaller or equal to the output.
     *
     * @param bt
     * @return
     */
    public int shortestJobFirst(int bt[]) {

        Arrays.sort(bt);
        int waitTime = 0;
        int totalTime = 0;
        for (int i = 0; i < bt.length; i++) {
            waitTime += totalTime;
            totalTime += bt[i];
        }
        return (int) waitTime / bt.length;
    }

    /**
     * You are given an array of non-overlapping intervals intervals where intervals[i] = [starti, endi] represent the start and the end of the ith interval and intervals is sorted in ascending order by starti. You are also given an interval newInterval = [start, end] that represents the start and end of another interval.
     * <p>
     * Insert newInterval into intervals such that intervals is still sorted in ascending order by starti and intervals still does not have any overlapping intervals (merge overlapping intervals if necessary).
     * <p>
     * Return intervals after the insertion.
     *
     * @param intervals
     * @param newInterval
     * @return
     */
    public int[][] insertIntervalInSortedListOfInterval(int[][] intervals, int[] newInterval) {
        int n = intervals.length;
        int i = 0;
        List<Integer[]> answer = new ArrayList<>();
        while (i < n && newInterval[0] > intervals[i][1]) {
            answer.add(new Integer[]{intervals[i][0], intervals[i][1]});
            i++;
        }

        while (i < n && newInterval[1] >= intervals[i][0]) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        answer.add(new Integer[]{newInterval[0], newInterval[1]});
        while (i < n) {
            answer.add(new Integer[]{intervals[i][0], intervals[i][1]});
            i++;
        }

        int[][] finalAnswer = new int[answer.size()][2];
        for (int k = 0; k < answer.size(); k++) {
            finalAnswer[k][0] = answer.get(k)[0];
            finalAnswer[k][1] = answer.get(k)[1];
        }
        return finalAnswer;
    }

    /**
     * Given an array of intervals where intervals[i] = [starti, endi], merge all
     * overlapping intervals, and return an array of the non-overlapping intervals that cover
     * all the intervals
     * in the input.
     *
     * @param intervals
     * @return
     */
    public int[][] mergeUnsortedIntervals(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        Arrays.stream(intervals).forEach(interval -> {
            System.out.println(interval[0] + " " + interval[1]);
        });
        int start = intervals[0][0];
        int end = intervals[0][1];

        List<int[]> answer = new ArrayList<>();
        for (int[] a : intervals) {
            if (a[0] <= end) {
                end = Math.max(end, a[1]);
            } else {
                answer.add(new int[]{start, end});
                start = a[0];
                end = a[1];
            }
        }
        answer.add(new int[]{start, end});

        return answer.toArray(new int[0][]);

    }

    /**
     * Given an array of intervals intervals where intervals[i] = [starti, endi],
     * return the minimum number of intervals you need to remove to make the rest of the
     * intervals non-overlapping.
     * <p>
     * Note that intervals which only touch at a point are non-overlapping.
     * For example, [1, 2] and [2, 3] are non-overlapping.
     *
     * @param intervals
     * @return
     */
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[1] - b[1]);
        Arrays.stream(intervals).forEach(a -> System.out.println(a[0] + " - " + a[1]));

        int count = 0;
        int last = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < last) {
                count++;
            } else {
                last = intervals[i][1];
            }
        }
        return count;
    }

}
