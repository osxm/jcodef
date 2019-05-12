/**
 * @Title: StringSub.java
 * @Package cn.osxm.jcodef.func.base
 * @Description: TODO
 * @author osxm:oscarxueming
 * @date 2019年5月12日 下午8:58:24
 * @version V1.0
 */

package cn.osxm.jcodef.func.base;

/**
 * @ClassName: StringSub
 * @Description: TODO
 * @author osxm:oscarxueming
 */

public class StringSub {
	/**
	 * @Title: main
	 * @Description: TODO
	 * @param args
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StringSub stringSub = new StringSub();
		String sProjectNo = stringSub.getNextPrjNoForCreate();
		System.out.println(sProjectNo);
	}

	public String getNextPrjNoForCreate() {
		String projectNo = "A03000";
		String projectNoSub = projectNo.substring(1, 6);
		int iProjectNo = Integer.valueOf(projectNoSub);
		int iNextProjectNo = iProjectNo + 1;
		while (!isProjectNoValid(iNextProjectNo) && iProjectNo < 99999) {
			iNextProjectNo += 1;
		}
		projectNo = String.format("A%05d", iNextProjectNo);
		return projectNo;
	}

	private boolean isProjectNoValid(int iProjectNo) {
		boolean isValid = true;
		if (iProjectNo > 3000 && iProjectNo < 99999) {
			String sProjectNo = String.valueOf(iProjectNo);
			if (sProjectNo.contains("4")) {
				isValid = false;
			}
		}
		return isValid;
	}
}
