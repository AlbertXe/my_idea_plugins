package application;

import com.intellij.openapi.components.ApplicationComponent;
import com.intellij.openapi.ui.Messages;
import constant.AppProperties;
import org.jetbrains.annotations.NotNull;
import utils.FileUtils;
import utils.ResourcesLoad;

import java.io.File;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.atomic.AtomicInteger;

public class FileRenameApplication implements ApplicationComponent {
    @NotNull
    @Override
    public String getComponentName() {
        return "fileRename";
    }

    public void execute() {
        Properties properties = ResourcesLoad.load(AppProperties.resource);
        String dir = properties.getProperty(AppProperties.file_rename_package);
        String oldname = properties.getProperty(AppProperties.file_rename_oldname);
        String newname = properties.getProperty(AppProperties.file_rename_newname);
        List<String> files = FileUtils.listFiles(dir);
        AtomicInteger count = new AtomicInteger(0);
        files.stream().filter(file -> {
            return file.contains(oldname);
        }).forEach(file -> {
            count.incrementAndGet();
            File f = new File(file);
            String newfile = file.replace(oldname, newname);
            f.renameTo(new File(newfile));
        });

        Messages.showMessageDialog("一共" + count.get() + "重命名成功", "文件重命名", Messages.getInformationIcon());
    }
}
