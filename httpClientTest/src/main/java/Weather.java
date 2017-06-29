import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

public class Weather {

	/**
	 * 通过GET方式发起http请求
	 */
	@Test
	public void requestByGetMethod() {
		// 创建默认的httpClient实例
		CloseableHttpClient httpClient = getHttpClient();
		try {
			// 用get方法发送http请求http://php.weather.sina.com.cn/xml.php
			// HttpGet get = new HttpGet(
			// "http://124.207.49.62:8004/lcss/Communication/userSelect");
			String strCity = URLEncoder.encode("十堰", "GB2312");
			HttpGet get = new HttpGet(
					"http://php.weather.sina.com.cn/xml.php?city="+strCity+"&password=DJOYnieT8234jlsK&day=0");
			System.out.println("执行get请求:...." + get.getURI());
			CloseableHttpResponse httpResponse = null;
			// 发送get请求
			httpResponse = httpClient.execute(get);
			try {
				// response实体
				HttpEntity entity = httpResponse.getEntity();
				if (null != entity) {
					System.out.println("响应状态码:" + httpResponse.getStatusLine());
					System.out
							.println("-------------------------------------------------");
					OutputStream os = new FileOutputStream("1.xml");
					os.write(EntityUtils.toByteArray(entity));
					os.flush();
					os.close();
					// System.out.println("响应内容:" +
					// EntityUtils.toString(entity));
					System.out.println(URLEncoder.encode("上海", "GB2312"));
					System.out
							.println("-------------------------------------------------");
				}
			} finally {
				httpResponse.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				closeHttpClient(httpClient);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

	/**
	 * POST方式发起http请求
	 */
	@Test
	public void requestByPostMethod() {
		CloseableHttpClient httpClient = getHttpClient();
		try {
			HttpPost post = new HttpPost(
					"http://php.weather.sina.com.cn/xml.php"); // 这里用上本机的某个工程做测试
			// 创建参数列表
			// String strCity = URLEncoder.encode("南昌", "GB2312");
			List<NameValuePair> list = new ArrayList<NameValuePair>();
			list.add(new BasicNameValuePair("city", "上海"));
			list.add(new BasicNameValuePair("password", "DJOYnieT8234jlsK"));
			list.add(new BasicNameValuePair("day", "0"));
			// url格式编码
			UrlEncodedFormEntity uefEntity = new UrlEncodedFormEntity(list,
					"gbk");
			post.setEntity(uefEntity);
			System.out.println("POST 请求...." + post.getURI());
			// 执行请求
			CloseableHttpResponse httpResponse = httpClient.execute(post);
			try {
				HttpEntity entity = httpResponse.getEntity();
				if (null != entity) {
					System.out
							.println("-------------------------------------------------------");
					System.out.println(EntityUtils.toString(uefEntity));
					// System.out.println(EntityUtils.toString(entity));
					try {
						OutputStream os = new FileOutputStream("d:/1.xml");
						os.write(EntityUtils.toByteArray(entity));
						os.flush();
						os.close();
					} catch (Exception e) {
						// TODO: handle exception
						e.printStackTrace();
					}

					System.out
							.println("-------------------------------------------------------");
				}
			} finally {
				httpResponse.close();
			}

		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				closeHttpClient(httpClient);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	private CloseableHttpClient getHttpClient() {
		return HttpClients.createDefault();
	}

	private void closeHttpClient(CloseableHttpClient client) throws IOException {
		if (client != null) {
			client.close();
		}
	}
}