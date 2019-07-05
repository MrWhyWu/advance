package com.study.design.mode.service;

import com.study.design.mode.service.promotion.PromotionCalculation1;
import com.study.design.mode.service.promotion.PromotionCalculation2;
import com.study.design.mode.service.promotion.PromotionCalculation3;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.study.design.mode.entity.Order;

@Service
public class OrderService {

	@Autowired
	private PromotionCalculationFactory promotionCalculationFactory;


	//1.最原始的方式
//	public Order prepareOrder(Order order, String promotion) {
//
//		switch (promotion) {
//			case "promotion-1":
//				//促销1的算法
//				//......
//				break;
//			case "promotion-2":
//				//促销2的算法
//				//......
//
//				break;
//			case "promotion-3":
//				//促销3的算法
//				//......
//				break;
//		}
//		return order;
//	}


	//2.利用方法单一原则
//	public Order prepareOrder(Order order, String promotion) {
//
//		switch (promotion) {
//			case "promotion-1":
//				//促销1的算法
//				return calPromotion1(order);
//			case "promotion-2":
//				//促销2的算法
//				return calPromotion2(order);
//			case "promotion-3":
//				//促销3的算法
//				return calPromotion3(order);
//
//		}
//		return order;
//	}
//
//
//	private Order calPromotion1(Order order) {
//		System.out.println("执行促销1的计算");
//		return order;
//	}
//
//	private Order calPromotion2(Order order) {
//		System.out.println("执行促销1的计算");
//		return order;
//	}
//
//	private Order calPromotion3(Order order) {
//		System.out.println("执行促销1的计算");
//		return order;
//	}

	//3.策略模式：利用开闭原则和面向接口原则
//	public Order prepareOrder(Order order, String promotion) {
//		switch (promotion) {
//			case "promotion-1":
//				return new PromotionCalculation1().culculate(order);
//
//			case "promotion-2":
//				return new PromotionCalculation2().culculate(order);
//
//			case "promotion-3":
//				return new PromotionCalculation3().culculate(order);
//		}
//		return order;
//	}

	//4.简单工厂模式
//	public Order prepareOrder(Order order, String promotion) {
//		return promotionCalculationFactory.getPromotionCalculation(promotion).culculate(order);
//	}

	//5.如果促销活动多重叠加，用装饰者模式，看samples下的decorator
	public Order prepareOrder(Order order, String... promotion) {
		for (String p : promotion) {
			order = promotionCalculationFactory.getPromotionCalculation(p).calculate(order);
		}
		return order;
	}

}
















