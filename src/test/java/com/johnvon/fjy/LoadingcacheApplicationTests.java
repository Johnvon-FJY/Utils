package com.johnvon.fjy;

import com.google.common.cache.LoadingCache;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.ExecutionException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LoadingcacheApplicationTests {

	@Autowired
	private LoadingCache<String, String> localCache;

	@Test
	public void dataCacheGetValueTest() throws ExecutionException {
		
		for (int i = 0; i < 1000; i++) {
			System.out.println( i + "次取值：" + localCache.get("test"));
			try {
				//sleep 
				Thread.sleep(1000L);
			} catch (Exception e) {
				//no handle
			}
		}
	}

}
