package com.algorithm.demo.jianzhi;

/**
 * date: 2021-02-01 13:23
 * description
 *
 * @author qiDing
 */
public class Qingwatiao {
    public int JumpFloor(int target) {
        return this.test(target);
    }

    public int test(int target) {
        if (target <= 0) {
            return 0;
        }
        if (target == 1) {
            return 1;
        }
        if (target == 2) {
            return 2;
        }
        return test(target - 1) + test(target - 2);
    }
}
