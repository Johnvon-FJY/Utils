package com.johnvon.fjy.configuration;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.MoreExecutors;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.*;

/**
 * @author johnvon
 * @desc LoadingCache Config
 * @date 2019-05-25
 */
@Configuration
class LocalCacheConfig {

    ListeningExecutorService reloadPool =
            MoreExecutors.listeningDecorator(new ThreadPoolExecutor(10, 10 , 20, TimeUnit.MINUTES, new LinkedBlockingQueue<Runnable>(1000)));

    @Bean
    public LoadingCache<String, String> localCache() {
        return CacheBuilder.newBuilder().maximumSize(1000)
                .expireAfterWrite(30, TimeUnit.SECONDS)
                .refreshAfterWrite(20, TimeUnit.SECONDS)
                .build(new CacheLoader<String, String>() {
                    @Override
                    public String load(String key) throws Exception {
                        System.out.println("缓存不存在，加载ing->" + key);
                        String result = key + ":one";
                        return result;
                    }


                    @Override
                    public ListenableFuture<String> reload(String key,
                                                           String oldValue) throws Exception {
                        return reloadPool.submit(new Callable<String>() {

                            @Override
                            public String call() throws Exception {
                                System.out.println("缓存不存在，加载ing->reload");
                                return load(key);
                            }
                        });
                    }

                });
    }

}
