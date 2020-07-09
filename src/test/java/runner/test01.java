package runner;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.swing.event.ListDataListener;
import javax.swing.plaf.basic.BasicComboBoxUI.ListDataHandler;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.testng.annotations.Test;

import com.alibaba.fastjson.JSONObject;

public class test01 {
	@Test
	public  void nahao() {
		String  data="{\"stream_info_id\":\"\",\"third_app_name\": \"qa-test\",\n" + 
				"    \"app_secret\": \"OirABqmP9OWhYTpp\","
				+ "\"stream_name\":\"${__RandomString(10,测试数据12345,)}\","
				+ "\"psm\":\"ea.sre.zlatest\","
				+ "\"stages\":[{\"atomic_operation_id\":5,\"stage_nice_name\":\"Sonar检查\",\"global_stage_model_id\":2,\"atomic_operation_code\":\"sonar_check\","
				+ "\"atomic_operation_param\":{\"sonar_project_key\":\"ea-sre-zlatest\",\"ea_gitlab_url\":\"http://eatools.bytedance.net/gitlab/ea/zlatest\",\"language\":\"Java\"},"
				+ "\"configed\":true}]}";
		JSONObject jsonObject=JSONObject.parseObject(data);
		Map<String, String> map =new HashMap<String, String>();
		for (Entry<String, Object> entry : jsonObject.entrySet()) {
			map.put(entry.getKey(), String.valueOf(entry.getValue()));
			
			
		}
		System.out.println(map);
		List<NameValuePair> list=new ArrayList<NameValuePair>();
		for (Entry<String, String> name: map.entrySet()) {
			BasicNameValuePair nameValuePair2=new BasicNameValuePair(name.getKey(),name.getValue());
			list.add(nameValuePair2);
		}
		Iterator<NameValuePair> iterator = list.iterator();
		while(iterator.hasNext()) {
			System.out.println(iterator.next());
		}
	}
	@Test
	public void test5() {
		List<String> list=new ArrayList<>();
		list.add("name");
		list.add("get");
		for (int i = 0; i< list.size()+1; i++) {
			list.get(i);
			System.out.println(list.get(i));
			
		}
	}

}
