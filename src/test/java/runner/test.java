package runner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.alibaba.fastjson.JSONObject;

public class test {
	String name;
	int age;
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		test other = (test) obj;
		if (age != other.age)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
	/*public static void main(String[] args) {
		int[] aa= {1,9,8,6};
		//sortTest(aa);
		for(int i=0;i<aa.length;i++) {
			System.out.println(aa[i]);
		}
		Arrays.sort(aa);
		
		for(int i=0;i<aa.length;i++) {
			System.out.println(aa[i]);
		}
		String[] bb= {"qwe","uio"};
		char[] charArray = new String("我是测试工程师").toCharArray();
		System.out.println(Arrays.toString(charArray));
		//int cc[]=new int [3];
		char[] dd= {'q','w','e'};
		System.arraycopy(dd, 0, dd, 1, 2);
		System.out.println(Arrays.toString(charArray));
		System.out.println(Arrays.toString(dd));
		int[] arr = {0,1,2,3,4,5};
		int [] arr2=new int[8];
		System.arraycopy(arr,2,arr2,3,4);
		System.out.println(Arrays.toString(arr2));
        String s2="^[1]([3|5|8][\\d]|[4][4,5,6,7,8,9]|[6][2,5,6,7]|[7][^9]|[9][1,8,9])[\\d]{8}$";// 验证手机号
        String s3="^[1][456789]\\d{9}$";
        String s4="\\w";
        Pattern compile = Pattern.compile(s4);
        Matcher matcher = compile.matcher("");
        System.out.println(matcher.matches());
        

		
	}*/
	public String name() {
		return "";
	}
	public static void sortTest(int [] arr) {
		int a = 0;
		for(int i=0;i<arr.length-1;i++) {
			for(int j=0;j<arr.length-1-i;j++) {
				if (arr[j]>arr[j+1]) {
					a = arr[j];
	                arr[j] = arr[j+1];
	                arr[j+1] = a;
					
				}
				
			}
			
		}
		
	}
	/*public static void main(String[] args) {

        int arr[] = {8, 5, 3, 2, 4};
        

        //冒泡
        for (int i = 0; i < arr.length; i++) {
            //外层循环，遍历次数
            for (int j = 0; j < arr.length - i - 1; j++) {
                //内层循环，升序（如果前一个值比后一个值大，则交换）
                //内层循环一次，获取一个最大值
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = temp;
                }
            }
			System.out.println(Arrays.toString(arr));
 
        }

		for(int i=0;i<arr.length;i++) {
			System.out.println(arr[i]);
		}
		Map<String, String> map=new HashMap<String, String>();
		map.put("name", "wu");
		System.out.println(map.toString());
		
		Class<? extends Map> class1 = map.getClass();
		String name = class1.getName();
		System.out.println(class1);
		System.out.println(name);
    }*/
	
	public static void main(String[] args) {
		double random = Math.random();
		int a=(int)(random*100);
		for(int i=0;i<10;i++) {
			System.out.println(a);
			System.out.println("随机数："+(new Random()).nextInt(20));
		}
		ArrayList<Object> arrayList = new ArrayList<Object>();
		arrayList.add(1);
		arrayList.add("name");
		
		System.out.println(arrayList.isEmpty());
		System.out.println(arrayList.get(0));
		System.out.println(arrayList.get(1));
		Class<? extends ArrayList> class1 = arrayList.getClass();
		System.out.println(class1);
		System.out.println(arrayList.contains("name"));
		Iterator<Object> iterator = arrayList.iterator();
		
		
		arrayList.set(1, "age");
		while (iterator.hasNext()) {
			Object next = iterator.next();
			System.out.println("---"+next);
			
		}
		HashSet<Integer> hashSet = new HashSet<Integer>();
		boolean add = hashSet.add(123);
		
		
		
	}
}
