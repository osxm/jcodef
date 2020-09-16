/**
 * @Title: EnumDemo.java
 * @Package cn.osxm.jcodef.func.base
 * @Description: TODO
 * @author oscarchen
 * @date 2020年7月7日
 * @version V1.0
 */
package cn.osxm.jcodef.func.base;

import org.junit.Assert;
import org.junit.Test;

/**
 * @ClassName: EnumDemo
 * @Description: TODO
 * @author oscarchen
 */
public class EnumDemo {

	@Test
	public void noEnum() {
		int i = 1;
		Assert.assertTrue(Season.SPRING == i);
	}

	@Test
	public void enumBase() {
		SeasonEnum season = SeasonEnum.SPRING;
		Assert.assertTrue(season.equals(SeasonEnum.SPRING));
		Assert.assertTrue(season.compareTo(SeasonEnum.SPRING) == 0);
	}

	@Test
	public void stringVsEnum() {
		String seasonStr = "SPRING";
		// 1. 方式1
		SeasonEnum season = SeasonEnum.valueOf(seasonStr);
		Assert.assertTrue(season.equals(SeasonEnum.SPRING));

		// 2.方式2
		String tranSeasonStr = SeasonEnum.SPRING.toString();
		// 或者
		tranSeasonStr = SeasonEnum.SPRING.name();
		Assert.assertTrue(seasonStr.equals(tranSeasonStr));

	}

	@Test
	public void intVsEnum() {
		int iSeason = 0;
		int iTranSeason = SeasonEnum.SPRING.ordinal();
		Assert.assertTrue(iSeason == iTranSeason);
	}

	@Test
	public void constructEnum() {
		String seasonStr = "Spring";
		String tranSeasonStr = Season2Enum.SPRING.getValue();
		Assert.assertTrue(seasonStr.equals(tranSeasonStr));

	}

	@Test
	public void enumSwitch() {
		SeasonEnum season = SeasonEnum.SPRING;
		switch (season) {
		case SPRING:
			System.out.println("花开了");
			break;
		case SUMMER:
			System.out.println("天热了");
			break;
		case AUTUMN:
			System.out.println("结果了");
			break;
		case WINTER:
			System.out.println("下雪了");
			break;
		default:

		}
	}
}
