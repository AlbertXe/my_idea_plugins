package application;

import com.intellij.openapi.components.ApplicationComponent;
import com.intellij.openapi.ui.Messages;
import org.jetbrains.annotations.NotNull;

public class MyApplication implements ApplicationComponent {
    @Override
    public void initComponent() {

    }

    @Override
    public void disposeComponent() {

    }

    @NotNull
    @Override
    public String getComponentName() {
        return "MyFirstComponent";
    }

    public void sayHello() {
        Messages.showMessageDialog("hello world", "sample", Messages.getInformationIcon());
    }
}
