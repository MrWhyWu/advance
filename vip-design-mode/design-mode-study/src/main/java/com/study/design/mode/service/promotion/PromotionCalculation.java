package com.study.design.mode.service.promotion;

import com.study.design.mode.entity.Order;

/**
 * 对不同促销活动进行算法计算
 */
public interface PromotionCalculation {
    Order calculate(Order order);
}
