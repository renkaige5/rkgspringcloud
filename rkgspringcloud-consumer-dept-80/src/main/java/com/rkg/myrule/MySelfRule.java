package com.rkg.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * The FooConfiguration has to be @Configuration but take care that it is not in a
 *  @ComponentScan for the main application context, otherwise it will be shared by
 * all the @RibbonClients. If you use @ComponentScan (or @SpringBootApplication) you
 * need to take steps to avoid it being included (for instance put it in a separate,
 * non-overlapping package, or specify the packages to scan explicitly in the @ComponentScan).
 *
 * 大体意思是对于Ribbon的配置必须用@Configuration注解标识，并
 * 且不能被@Component注解或者@SpringBootApplication（因为里面包含了@Component）扫描到。
 * 因为如果被@ComponetScan扫描到会导致所有的RibbonClient都去共享这个配置。从而达不到特殊定制的目的
 */
@Configuration
public class MySelfRule
{
	@Bean
	public IRule myRule()
	{
//		return new RandomRule();// Ribbon默认是轮询，我自定义为随机
		//return new RoundRobinRule();// Ribbon默认是轮询，我自定义为随机
		
		return new RandomRule_ZY();// 我自定义为每台机器5次
	}
}
