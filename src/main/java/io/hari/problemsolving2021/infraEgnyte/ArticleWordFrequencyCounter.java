package io.hari.problemsolving2021.infraEgnyte;

import org.apache.commons.io.IOUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author Hariom Yadav
 * @create 11-04-2021
 */
public class ArticleWordFrequencyCounter {

    public static Map<String, Integer> map = new ConcurrentHashMap<>();

    static class HelperClass {
        private String readArticle(String articleUrl) throws Exception {
            URL url = new URL(articleUrl);
            return IOUtils.toString(url, "utf-8");
        }
    }

    public static ThreadLocal<HelperClass> threadLocal = ThreadLocal.withInitial(() -> new HelperClass());

    private static List<String> readUrls(String filePath) {
        try {
            InputStream inputStream = new FileInputStream(new File(filePath));
            List<String> urls = IOUtils.readLines(inputStream);
            inputStream.close();
            return urls;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new LinkedList<>();
    }

    public static synchronized void task(String url) {
        final HelperClass helperClass = threadLocal.get();
        try {
            final String article = helperClass.readArticle(url);
            final String[] words = article.split(" ");
            for (String w : words) {
                map.put(w, map.getOrDefault(w, 0) + 1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private static void countMultiThreaded(String filePath) {
        List<String> urls = readUrls(filePath);
        ExecutorService service = Executors.newFixedThreadPool(10);
        urls.parallelStream().forEach(url -> {
            service.execute(() -> task(url));
        });
    }

    public static void main(String[] args) {
        String filePath = args[0];
        countMultiThreaded(filePath);
        System.out.println("map = " + map);
    }
}


