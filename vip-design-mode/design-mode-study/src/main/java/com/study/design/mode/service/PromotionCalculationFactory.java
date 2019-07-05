package com.study.design.mode.service;

import java.util.Map;

import com.study.design.mode.service.promotion.PromotionCalculation;
import com.study.design.mode.service.promotion.PromotionCalculation1;
import com.study.design.mode.service.promotion.PromotionCalculation2;
import com.study.design.mode.service.promotion.PromotionCalculation3;
import org.springframework.stereotype.Component;

@Component
public class PromotionCalculationFactory {

	//1.简单工厂模式
//	public PromotionCalculation getPromotionCalculation(String promotion) {
//
//		switch (promotion) {
//			case "promotion-1":
//				//促销1的算法
//				return new PromotionCalculation1();
//			case "promotion-2":
//				//促销2的算法
//				return new PromotionCalculation2();
//			case "promotion-3":
//				//促销3的算法
//				return new PromotionCalculation3();
//		}
//		return null;
//	}

	//TODO 2.promotion = beanName（利用SpringApplication）


	//3.配置promotion与实现类的对应关系(可以利用xml，property和数据库)
	private Map<String, PromotionCalculation> maps;

	public void init() {
		//配置的格式： promotion1=com.study.dn.promotion.calculation.Promotion1
		// 第一次将所有的促销策略都加载到Map中
	}

	public PromotionCalculation getPromotionCalculation(String promotion) {
		PromotionCalculation prom = maps.get(promotion);
		if (prom == null) {
			// 从配置的地方加载
			prom = getFromDb(promotion);
			if (prom != null){
				maps.put(promotion, prom);
			}
		}
		return prom;
	}

	private PromotionCalculation getFromDb(String promotion) {
		// 从数据库中取到对应的类名
		String className = "com.study.design.mode.service.promotion.PromotionCalculation1";
		PromotionCalculation pc = null;
		try {
			//先通过jvm类加载来获取类
			Class c = Class.forName(className);
			// 实例化
			pc = (PromotionCalculation)c.newInstance();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		// 返回
		return pc;
	}


}



