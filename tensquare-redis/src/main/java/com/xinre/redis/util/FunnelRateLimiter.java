package com.xinre.redis.util;

import java.util.HashMap;
import java.util.Map;

/**
 * 单机漏斗限流
 *
 * @author xinre
 * @date 2019/1/25 17:18
 */
public class FunnelRateLimiter {
    static class Funnel {
        // 漏斗容量
        int capacity;
        // 漏嘴流速
        float leakingRate;
        // 漏斗剩余空间（left：leave 离开 过去式）
        int leftQuota;
        // 上一次漏水时间戳
        long leakingTs;

        public Funnel(int capacity, float leakingRate) {
            this.capacity = capacity;
            this.leakingRate = leakingRate;
            this.leftQuota = capacity;
            this.leakingTs = System.currentTimeMillis();
        }

        void makeSpace() {
            long nowTs = System.currentTimeMillis();
            long deltaTs = nowTs - leakingTs;
            int deltaQuota = (int) (deltaTs * leakingRate);
            // 间隔时间太长，整数数字过大溢出
            if (deltaQuota < 0) {
                this.leftQuota = capacity;
                this.leakingTs = nowTs;
                return;
            }
            // 腾出空间太小，最小单位是1
            if (deltaQuota < 1) {
                return;
            }
            this.leftQuota += deltaQuota;
            this.leakingTs = nowTs;
            if (this.leftQuota > this.capacity) {
                this.leftQuota = this.capacity;
            }
        }


        boolean watering(int quota) {
            makeSpace();
            if (this.leftQuota >= quota) {
                this.leftQuota -= quota;
                return true;
            }
            return false;
        }

    }


    private Map<String, Funnel> funnels = new HashMap<>();


    public boolean isActionAllowed(String userId, String actionKey, int capacity, float leakingRate) {
        String key = String.format("%s:%s", userId, actionKey);
        Funnel funnel = funnels.get(key);
        if (funnel == null) {
            funnel = new Funnel(capacity, leakingRate);

            funnels.put(key, funnel);
        }
        return funnel.watering(1); // 需要1个quota
    }

    public static void main(String[] args) {
        FunnelRateLimiter limiter = new FunnelRateLimiter();

        for (int i = 0; i < 20000; i++) {

            boolean actionAllowed = limiter.isActionAllowed("laoqian", "reply", 100, 1);
            if (i % 20 == 0) {
                System.out.println("i = " + i);
                System.out.println(actionAllowed);
                System.out.println(" =================over================= ");
            }
        }
    }
}
