package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ResourcesLoad {
    public static Properties load(String file) {
        Properties properties = new Properties();
        try {
            InputStream inputStream = new FileInputStream(file);
            properties.load(inputStream);
        } catch (IOException e) {
            throw new RuntimeException("加载资源失败" + file, e);
        }
        return properties;
    }
}
