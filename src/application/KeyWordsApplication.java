package application;

import com.intellij.openapi.components.ApplicationComponent;
import com.intellij.openapi.ui.Messages;
import constant.AppProperties;
import org.jetbrains.annotations.NotNull;
import utils.ContentUtils;
import utils.FileUtils;
import utils.ResourcesLoad;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.stream.Collectors;

public class KeyWordsApplication implements ApplicationComponent {


    @Override
    public void initComponent() {
    }

    @NotNull
    @Override
    public String getComponentName() {
        return "keyWords";
    }

    public void execute() {
        Properties properties = ResourcesLoad.load(AppProperties.resource);
        String dir = properties.getProperty(AppProperties.key_words_package);
        String key = properties.getProperty(AppProperties.key_words_key);

        List<String> paths = FileUtils.listFiles(dir);
        System.out.println(paths);
        List<String> result = new ArrayList<>();
        for (String path : paths) {
            List<String> keyWords = ContentUtils.qryKeyWords(path, key);
            result.addAll(keyWords);
        }
        String collect = result.stream().collect(Collectors.joining(","));
        Messages.showMessageDialog(collect, "查找关键词", Messages.getInformationIcon());
    }
}
