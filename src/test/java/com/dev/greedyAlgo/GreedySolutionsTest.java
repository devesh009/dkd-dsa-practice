package com.dev.greedyAlgo;

import com.dev.greedyAlgo.pojos.Item;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


/**
 * Created on 27/12/2024
 * Project -  DsaPracticeProject
 * Author - Devesh Kumar
 */
class GreedySolutionsTest {
    Logger logger = Logger.getLogger(GreedySolutionsTest.class.getName());
    private final GreedySolutions greedySolutions = new GreedySolutions();

    @Test
    void maxAssignableCookies() {
        int[] greed = new int[]{1, 5, 3, 3, 4};
        int[] size = new int[]{4, 2, 1, 2, 1, 3};
        int ans = greedySolutions.maxAssignableCookies(greed, size);
        logger.info("" + ans);
        assertThat(ans).isEqualTo(4);
    }

    @Test
    void fractionalKnapsack() {
        int n = 3, weight = 90;
        Item arr[] = {new Item(100, 20), new Item(60, 10), new Item(100, 50), new Item(200, 50)};
        double ans = greedySolutions.fractionalKnapsack(weight, arr, n);
        logger.info("The maximum value is " + ans);
        assertThat(ans).isEqualTo(380);
    }

    @Test
    void findMinNoOfCoins() {
        int V = 49;
        ArrayList<Integer> ans = new ArrayList<>();
        int coins[] = {1, 2, 5, 10, 20, 50, 100, 500, 1000};
        List<Integer> minNoOfCoins = greedySolutions.findMinNoOfCoins(coins, V);
        minNoOfCoins.forEach(System.out::println);
        assertThat(minNoOfCoins).satisfies(minNoOfCoins::contains);
    }


    @Test
    void lemonadeChange() {
        List<Integer> bills = new ArrayList<>();
        bills.add(5);
        bills.add(5);
        bills.add(5);
        bills.add(10);
        bills.add(20);

        System.out.print("Queues of customers: ");
        for (int bill : bills) {
            System.out.print(bill + " ");
        }
        System.out.println();

        boolean ans = greedySolutions.lemonadeChange(bills);
        if (ans)
            System.out.println("It is possible to provide change for all customers.");
        else
            System.out.println("It is not possible to provide change for all customers.");

        assertThat(ans).isTrue();
    }

    @Test
    void checkValidParenthesis() {
        String str = "()*((";
        boolean ans = greedySolutions.checkValidParenthesis(str);
        assertThat(ans).isFalse();
    }

    @Test
    void maxPossibleMeetings() {
        int n = 6;
        int start[] = {1, 3, 0, 5, 8, 5};
        int end[] = {2, 4, 5, 7, 9, 9};
        greedySolutions.maxPossibleMeetings(start, end, n);
    }

    @Test
    void canJump() {
        int[] nums = {4, 3, 7, 1, 2};

        System.out.print("Array representing maximum jump from each index: ");
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println();

        boolean ans = greedySolutions.canJump(nums);

        if (ans) {
            System.out.println("It is possible to reach the last index.");
        } else {
            System.out.println("It is not possible to reach the last index.");
        }
    }

    @Test
    void minJumps() {
        int[] nums = {4, 3, 7, 1, 2};

        System.out.print("Array representing maximum jump from each index: ");
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println();

        int ans = greedySolutions.minJumps(nums);
    }

    @Test
    void findPlatform() {
        int[] arr ={900,945,955,1100,1500,1800};
        int[] dep={920,1200,1130,1150,1900,2000};
        int totalCount=greedySolutions.findPlatform(arr,dep);
        System.out.println("Minimum number of Platforms required "+totalCount);
    }

    @Test
    void jobSequencing() {
        int[] id ={1,2,3,4};
        int[] deadline={4,1,1,1};
        int[] profit={20,10,40,30};
        ArrayList<Integer> answer = greedySolutions.jobSequencing(id,deadline,profit);
        assertThat(answer.get(0)).isEqualTo(2);
        assertThat(answer.get(1)).isEqualTo(60);

    }

    @Test
    void mergeUnsortedIntervals() {
        int[][] intervals = new int[][]{{8,10},{1,3},{15,18},{2,6}};
       greedySolutions.mergeUnsortedIntervals(intervals);


    }
}