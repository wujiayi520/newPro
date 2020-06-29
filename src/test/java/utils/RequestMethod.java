package utils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import com.alibaba.fastjson.JSONObject;


public class RequestMethod {
	private static Logger logger = Logger.getLogger(RequestMethod.class.getName());
	

	//创建请求的客户端
		private  static  CloseableHttpClient client=HttpClients.custom().build();
		private  static  CloseableHttpResponse response;
	//构建超时等配置信息
        @SuppressWarnings("deprecation")
		static RequestConfig config = RequestConfig.custom().setConnectTimeout(1000) //连接超时时间
                .setConnectionRequestTimeout(1000) //从连接池中取的连接的最长时间
                .setSocketTimeout(10 *1000) //请求获取数据的超时时间(单位毫秒)
                .setStaleConnectionCheckEnabled(true) //提交请求前测试连接是否可用
                .build();
        
        
       // static Logger logger = LogManager.getLogger(RequestMethod.class.getName());


        /**
         * 向指定URL发送GET方法的请求
         * 
         * @param url
         *            发送请求的URL
         * @param param
         *            请求参数，请求参数应该是 name1=value1&name2=value2 的形式。
         * @return resulit 所代表远程资源的响应结果
         */
        
        
        public static Map<String, Object> getParam(String url, String param) {
        	Map<String, Object> map=new HashMap<String, Object>();
        	String result="";
        	StringBuffer buffer=new StringBuffer(url);
        	buffer.append("?");
        	String newUrl = buffer.append(param).toString();
        	
        			
    		HttpGet httpGet =new HttpGet(newUrl);
    		//设置请求配置时间
    		httpGet.setConfig(config);
    		httpGet.addHeader("Content-Type", "application/json;charset=utf-8");
    		/*//设置头部
    		for (Map.Entry<Object, Object> entry: header.entrySet()) {
    			//get.setHeader(entry.getKey().toString(), entry.getValue().toString());
    			buffer.append(url+"?"+entry.getKey().toString()+"="+entry.getValue().toString())
    		
			}*/
    		try {
				response=client.execute(httpGet);
			} catch (ClientProtocolException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
    		map.put("httpcode", response.getStatusLine().getStatusCode());
    		try {
                HttpEntity entity = response.getEntity();
                int statusCode = response.getStatusLine().getStatusCode();
                System.out.println("状态码："+statusCode);
                if (entity != null) {
                    result = EntityUtils.toString(entity);
                    
                }
            } catch (IOException e) {
                e.printStackTrace();
                
            } finally {
                try {
                    response.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
    		map.put("result", result);
            return map;        	
        	
        }
        
        
        /**
         * 向指定URL发送GET方法的请求,拼接参数
         * 
         * @param url
         *            发送请求的URL
         * 
         * @return result 所代表远程资源的响应结果
         */
        public static  Map<String, Object>  getMethod(String url ) {
        	Map<String, Object> map=new HashMap<String, Object>();
        	String result="";
    		HttpGet httpGet =new HttpGet(url);
    		//设置请求配置时间
    		httpGet.setConfig(config);
    		//get.addHeader("Content-Type", "application/json;charset=utf-8");
    		try {
    			response=client.execute(httpGet);
			} catch (ClientProtocolException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    		  HttpEntity entity = response.getEntity();
    		  int statusCode = response.getStatusLine().getStatusCode();
    		  map.put("httpcode", statusCode);
              System.out.println("状态码："+statusCode);
    		  if (entity!=null) {
                  try {
					result = EntityUtils.toString(entity);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
                   
			}
    		  map.put("result", result);
            return map;
        	
        	
        }
        

        /**
         * 向指定URL发送POST方法的请求,拼接参数
         * 
         * @param url
         *            发送请求的URL
         * @param param
         *            请求参数,String类型
         * 
         * @return result 所代表远程资源的响应结果
         */
        
        public static  Map<String, Object>  postMethod(String url,String param) throws Exception {
        	Map<String, Object> map=new HashMap<String, Object>();
        	JSONObject jsonObject=JSONObject.parseObject(param);
            for (Entry<String, Object> sEntry : jsonObject.entrySet()){
            	map.put(sEntry.getKey(), sEntry.getValue());
            }
            
    		HttpPost httpPost=new HttpPost(url);
    		ArrayList<NameValuePair> pairList = new ArrayList<NameValuePair>();
    		for (Entry<String, Object> entry: map.entrySet()) {
    			//get.setHeader(entry.getKey().toString(), entry.getValue().toString());
                BasicNameValuePair data=new BasicNameValuePair(entry.getKey().toString(),entry.getValue().toString());
                pairList.add(data);
			}
    		
    		//post.addHeader("Content-Type", "application/x-www-form-urlencoded");
    		/*ArrayList<NameValuePair> pairList = new ArrayList<NameValuePair>();
            BasicNameValuePair datapa=new BasicNameValuePair("data",sendData);
            pairList.add(pairList);*/

            try {
            	httpPost.setEntity(new UrlEncodedFormEntity(pairList,"utf-8"));
    		} catch (UnsupportedEncodingException e) {
    			e.printStackTrace();
    		}
    		try {
    			response = client.execute(httpPost);
    		} catch (ClientProtocolException e) {
    			e.printStackTrace();
    		} catch (IOException e) {
    			e.printStackTrace();
    		}
    		int statusCode = response.getStatusLine().getStatusCode();
    		map.put("httpcode", statusCode);
    		HttpEntity postentry=response.getEntity();
    		String result=null;
    		try {
    			result = EntityUtils.toString(postentry, "utf-8");
    		} catch (ParseException e) {			
    			e.printStackTrace();
    		} catch (IOException e) {
    			e.printStackTrace();
    		}
    		//System.out.println(result);
    		map.put("result", result);
    		return map;
    		
    		//获取状态值：
    		
    		
    	}
        
        
        
        public static void main(String[] args) {
			String url="https://xcx.hteacher.net/wechat3/san_qi/getPayOn";
			String param= "token=4678eed69d884c2bb1c9db22287de67b";
			Map<String, Object> result = getParam(url,param);
			System.out.println(result);
			String url1="https://xcx.hteacher.net/wechat3/san_qi/appDataIndex?token=4678eed69d884c2bb1c9db22287de67b";
			Map<String, Object> result1= getMethod(url1);
			System.out.println(result1);
        	
        	String url2="https://xcx.hteacher.net/wechat3/san_qi/insertOrder";
        	String data="{\"goods_id\":33,"
        			+ "\"goods_parent_id\":25,"
        			+ "\"data_type\":1,"
        			+ "\"openid\":\"oPbkJ0WgpPqR57ww6R_6wdMGKf50\","
        			+ "\"token\":\"4678eed69d884c2bb1c9db22287de67b\","
        			+ "\"user_info\":[{\"id\":1,\"name\":\"报名手机\",\"value\":\"18910590141\",\"placeholder\":\"请填写\",\"currentWordNum\":0},{\"id\":7,\"name\":\"省/市/区\",\"value\":\"北京市/北京市/东城区\",\"placeholder\":\"省/市/区\",\"currentWordNum\":0}]}";
        	
            Map<String, Object> newPost=null;
            try {
            	newPost=postMethod(url2, data);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            System.out.println(newPost);
            System.out.println(newPost.get("httpcode"));
            System.out.println(newPost.get("result"));
           
			
        	
        	
		}
        
        //@Test
        public void test() {
        	String url2="https://xcx.hteacher.net/wechat3/san_qi/insertOrder";
        	String data="{\"goods_id\":33,"
        			+ "\"goods_parent_id\":25,"
        			+ "\"data_type\":1,"
        			+ "\"openid\":\"oPbkJ0WgpPqR57ww6R_6wdMGKf50\","
        			+ "\"token\":\"4678eed69d884c2bb1c9db22287de67b\","
        			+ "\"user_info\":[{\"id\":1,\"name\":\"报名手机\",\"value\":\"18910590141\",\"placeholder\":\"请填写\",\"currentWordNum\":0},{\"id\":7,\"name\":\"省/市/区\",\"value\":\"北京市/北京市/东城区\",\"placeholder\":\"省/市/区\",\"currentWordNum\":0}]}";
        	
    		JSONObject jsonObject=JSONObject.parseObject(data);
            Map<String,Object>  map=new HashMap<String , Object>();
            for (Entry<String, Object> sEntry : jsonObject.entrySet()){
            	map.put(sEntry.getKey(), sEntry.getValue());
            }
            HttpPost post=new HttpPost(url2);
            ArrayList<NameValuePair> pairList = new ArrayList<NameValuePair>();
    		for (Entry<String, Object> entry: map.entrySet()) {
    			//get.setHeader(entry.getKey().toString(), entry.getValue().toString());
                BasicNameValuePair data2=new BasicNameValuePair(entry.getKey().toString(),entry.getValue().toString());
                pairList.add(data2);
			}
			try {
				post.setEntity(new UrlEncodedFormEntity(pairList,"utf-8"));
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    		try {
				response=client.execute(post);
			} catch (ClientProtocolException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    		System.out.println(response.getStatusLine().getStatusCode());
    		try {
				System.out.println(EntityUtils.toString(response.getEntity(),"utf-8"));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    		logger.info("cehsi jieshu");
            
            
        	
        }
        
        @Test
        public void test1() {
    		logger.info("开始测试啦");
        }
		
}
