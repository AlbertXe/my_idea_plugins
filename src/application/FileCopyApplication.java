package application;

import com.intellij.openapi.components.ApplicationComponent;
import com.intellij.openapi.ui.Messages;
import constant.AppProperties;
import org.jetbrains.annotations.NotNull;
import utils.FileUtils;
import utils.ResourcesLoad;

import java.io.File;
import java.util.Properties;

public class FileCopyApplication implements ApplicationComponent {
    @NotNull
    @Override
    public String getComponentName() {
        return "fileCopy";
    }

    public void execute() {
        Properties properties = ResourcesLoad.load(AppProperties.resource);
        String basefile = properties.getProperty(AppProperties.file_copy_basefile);
        String newfile = properties.getProperty(AppProperties.file_copy_newfile);
        int count = Integer.parseInt(properties.getProperty(AppProperties.file_copy_count));
        File file = new File(basefile);
        for (int i = 0; i < count; i++) {
            String target = newfile.replace(AppProperties.file_copy_replace, i + "");
            if (basefile.equals(target)) {
                continue;
            }
            FileUtils.copy(basefile, target);
        }

        Messages.showMessageDialog("一共复制了" + count + "个文件", "文件复制", Messages.getInformationIcon());
    }
}
