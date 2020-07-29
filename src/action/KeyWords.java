package action;

import application.KeyWordsApplication;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.application.Application;
import com.intellij.openapi.application.ApplicationManager;

/**
 * 用于搜索包下 所有的job
 */
public class KeyWords extends AnAction {

    @Override
    public void actionPerformed(AnActionEvent e) {

        Application application = ApplicationManager.getApplication();
        KeyWordsApplication keyWordApplication = application.getComponent(KeyWordsApplication.class);

        keyWordApplication.execute();
    }
}
