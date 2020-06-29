/*package utils;

import java.util.Map;

public class PoiInfo {
	public  static PoiMethod poiMethod;
	
	//提供请求的数据源
	public static void poiData(int rowNum,int titleNum,int urlNum,int paramNum,int tokenNum,int assertNum,int actualNum,int resultNum) {
		//获取测试标题
		String  titil=PoiMethod.getData(rowNum, titleNum);
		//获取请求的地址
		String url = PoiMethod.getData(rowNum, urlNum);
		//获取参数信息
		String paramData = PoiMethod.getData(rowNum, paramNum);
		//打印获取的参数信息
		System.out.println(PoiMethod.getData(rowNum, paramNum));
		//获取请求的返回值
		Map<String, Object> map = null;
		try {
			map = RequestMethod.postMethod(url, paramData);
		} catch (Exception e) {
			e.printStackTrace();
		}
		//获取判断的信息
		String assertData = PoiMethod.getData(rowNum, assertNum);
		Object result = map.get("result").toString();
		//将返回值写入文件中
		PoiMethod.setData(rowNum, actualNum, result);
		//System.out.println(result);
		//写入测试结果
		if (getAssert(result, assertData,titil)) {
			PoiMethod.setData(rowNum, resultNum, "OK");

		} else {
			PoiMethod.setData(rowNum, resultNum, "NG");
		}

	}
	//提供判断方法
	public static boolean getAssert(String strOne, String strtTwo,String title) {

		if (strOne.indexOf(strtTwo) >= 0) {
			//System.out.println(strOne.indexOf(strtTwo));
			System.out.println(title+"测试通过");
			return true;
		} else {
			System.out.println(title+"测试未通过");
			return false;
		}

	}
	//直接用户 Assert.assertEquals(statusCode,200);判断也可以
	

	
	
	
	

}
*/