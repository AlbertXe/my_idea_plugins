package application;

import com.intellij.openapi.components.ApplicationComponent;
import com.intellij.openapi.ui.Messages;
import constant.AppProperties;
import org.jetbrains.annotations.NotNull;
import utils.FileUtils;
import utils.ResourcesLoad;

import java.util.Properties;

public class BigFileReadComponent implements ApplicationComponent {

    @NotNull
    @Override
    public String getComponentName() {
        return "bigFileRead";
    }

    public void execute() {
        Properties properties = ResourcesLoad.load(AppProperties.resource);
        String bigfile = properties.getProperty(AppProperties.bigfile_url);
        String smallfile = bigfile + ".small";
        int size = 10 << 20;
        FileUtils.copy(bigfile, smallfile, size);

        Messages.showMessageDialog("小文件地址:" + smallfile, "大文件读一部分", Messages.getInformationIcon());
    }
}
