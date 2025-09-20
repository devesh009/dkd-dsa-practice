package com.dev.arrays;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created on 13/09/2025
 * Project -  DsaPracticeProject
 * Author - Devesh Kumar
 */

@Slf4j
class ArrayEasySolTest {

    ArrayEasySol sol = new ArrayEasySol();

    @Test
    void countDigits() {
        int rs1 = sol.countDigits(989796513);
        int rs2 = sol.countDigits(-989796513);
        assertThat(rs1).isEqualTo(9);
        assertThat(rs2).isEqualTo(9);
    }

    @Test
    void countDigits1() {
        int rs1 = sol.findCount1(989796513);
        int rs2 = sol.findCount1(-989796513);
        assertThat(rs1).isEqualTo(9);
        assertThat(rs2).isEqualTo(9);
    }

    @Test
    void findEvenCount() {
        int[] arr = {2, 5, 6, 8, 4, 5, 7, 9, 10};
        int evenCount = sol.findEvenCount(arr);
        assertThat(evenCount).isEqualTo(5);
    }

    @Test
    void findRichest_returnsMaxWealth() {
        ArrayEasySol sol = new ArrayEasySol();
        int[][] accounts = {
                {1, 2, 3},
                {3, 2, 1},
                {10, 0, 0},
                {4, 5, 6}
        };
        int richest = sol.findRichest(accounts);
        assertThat(richest).isEqualTo(15); // 4+5+6=15 is the richest
    }

    @Test
    void binarySearch_returnsIndexOrMinusOne() {
        int[] arr = {1, 3, 5, 7, 9, 11};
        assertThat(sol.binarySearch(arr, 7)).isEqualTo(3); // Expected index for 7
        assertThat(sol.binarySearch(arr, 1)).isEqualTo(0); // Expected index for 1
        assertThat(sol.binarySearch(arr, 11)).isEqualTo(5); // Expected index for 11
        assertThat(sol.binarySearch(arr, 4)).isEqualTo(-1); // 4 not present
    }

    @Test
    void orderAgnosticBinarySearch_ascendingArray() {
        int[] arr1 = {1, 3, 5, 7, 9, 11};
        assertThat(sol.orderAgnosticBinarySearch(arr1, 7)).isEqualTo(3);
        assertThat(sol.orderAgnosticBinarySearch(arr1, 1)).isEqualTo(0);
        assertThat(sol.orderAgnosticBinarySearch(arr1, 11)).isEqualTo(5);
        assertThat(sol.orderAgnosticBinarySearch(arr1, 4)).isEqualTo(-1);

        int[] arr = {11, 9, 7, 5, 3, 1};
        assertThat(sol.orderAgnosticBinarySearch(arr, 7)).isEqualTo(2);
        assertThat(sol.orderAgnosticBinarySearch(arr, 11)).isEqualTo(0);
        assertThat(sol.orderAgnosticBinarySearch(arr, 1)).isEqualTo(5);
        assertThat(sol.orderAgnosticBinarySearch(arr, 4)).isEqualTo(-1);

    }

    @Test
    void findCeilNumInSortedArr_returnsCeilOrMaxValue() {
        int[] arr = {2, 4, 6, 8, 10};
        assertThat(sol.findCeilNumInSortedArr(arr, 5)).isEqualTo(6); // 6 is the ceil of 5
        assertThat(sol.findCeilNumInSortedArr(arr, 10)).isEqualTo(10); // 10 is the ceil of 10
        assertThat(sol.findCeilNumInSortedArr(arr, 11)).isEqualTo(Integer.MAX_VALUE); // No ceil for 11
        assertThat(sol.findCeilNumInSortedArr(arr, 1)).isEqualTo(2); // 2 is the ceil of 1
    }

}