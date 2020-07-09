package runner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.testng.annotations.Test;

public class test02 {
	@Test
	public void test() {
		System.out.println("+++++++"+"这是另一个测试任务");
	}
	
	@Test
	public void send() {
		List<String> list=new ArrayList<String>();
		list.add("name");
		list.add("age");
		list.add("凤凰");
		Iterator<String> iterator = list.iterator();
		while (iterator.hasNext()) {
			String next = iterator.next();
			System.out.println(next);
			
		}
	}

}
