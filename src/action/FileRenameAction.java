package action;

import application.FileRenameApplication;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.application.Application;
import com.intellij.openapi.application.ApplicationManager;

public class FileRenameAction extends AnAction {

    @Override
    public void actionPerformed(AnActionEvent e) {
        Application application = ApplicationManager.getApplication();
        FileRenameApplication component = application.getComponent(FileRenameApplication.class);
        component.execute();
    }
}
