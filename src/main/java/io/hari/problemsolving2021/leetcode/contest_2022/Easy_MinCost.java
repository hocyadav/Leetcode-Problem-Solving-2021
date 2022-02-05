package io.hari.problemsolving2021.leetcode.contest_2022;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.concurrent.atomic.AtomicReference;

/**
 * https://leetcode.com/contest/biweekly-contest-70/problems/minimum-cost-of-buying-candies-with-discount/
 *
 * Approach : sort in increasing order if not sorted
 *  - iterate : from last to first <--
 *  - take 2 element
 *  - skip 1 element
 */
public class Easy_MinCost {
    @Test
    public void foo() {
        int minimumCost = minimumCost(new int[]{6, 5, 7, 9, 2, 2});
        System.out.println("minimumCost = " + minimumCost);

        Integer minimumCostStream = streamVersion(new int[]{6, 5, 7, 9, 2, 2});
        System.out.println("minimumCostStream = " + minimumCostStream);
    }

    public int minimumCost(int[] cost) {
        int purchase_count = 0;
        int money = 0;
        Arrays.sort(cost);

        System.out.println(Arrays.toString(cost));
        for (int i = cost.length - 1; i >= 0; i--) {
            if (purchase_count < 2) {
                System.out.println(cost[i]);
                money += cost[i];
                purchase_count++;
            } else {
                purchase_count = 0;
                continue;
            }
        }
        return money;
    }

    private Integer streamVersion(int[] cost) {

        AtomicReference<Integer> purchaseCount = new AtomicReference<>(0);
        AtomicReference<Integer> myMoney = new AtomicReference<>(0);

        Arrays.stream(cost)
                .boxed()
                .sorted(Comparator.reverseOrder())
                .peek(System.out::println)
                .forEach(input -> {
                    if (purchaseCount.get() < 2) {
                        purchaseCount.getAndSet(purchaseCount.get() + 1);
                        myMoney.getAndSet(myMoney.get() + input);
                    } else {
                        purchaseCount.set(0);
                    }
                });

        return myMoney.get();
    }
}
