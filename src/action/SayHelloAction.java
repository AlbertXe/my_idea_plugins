package action;

import application.MyApplication;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.application.Application;
import com.intellij.openapi.application.ApplicationManager;
import org.jetbrains.annotations.NotNull;

public class SayHelloAction extends AnAction {
    @Override
    public void actionPerformed(@NotNull AnActionEvent anActionEvent) {
        Application application = ApplicationManager.getApplication();
        MyApplication component = application.getComponent(MyApplication.class);

        System.out.println(anActionEvent);
        System.out.println("project - name" + anActionEvent.getProject());
        component.sayHello();
    }

    @Override
    public boolean isDumbAware() {
        return false;
    }
}
