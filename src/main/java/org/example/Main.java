package org.example;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Main {

    public String MESSAGE = "test_message";
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, InstantiationException {
        String url = "https://baidu.com";

        String className = Arrays.asList("org", "example", "Main").stream().collect(Collectors.joining("."));
        Class<?> aClass = Class.forName(className);
        Main o = (Main)aClass.getConstructor().newInstance();
        System.out.println(o.MESSAGE);
        OkHttpClient client = new OkHttpClient();
        //创建一个Request
        Request request = new Request.Builder()
                .get()
                .url(url)
                .build();
        //通过client发起请求
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }
            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (response.isSuccessful()) {
                     String str = response.body().string();
                    System.out.println(str);
                }
                call.cancel();
            }
        });
    }
}
