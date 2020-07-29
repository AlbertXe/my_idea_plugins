package action;

import application.FileCopyApplication;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import utils.ComponentUtils;

public class FileCopyAction extends AnAction {

    @Override
    public void actionPerformed(AnActionEvent e) {
        FileCopyApplication component = ComponentUtils.buildComponent(FileCopyApplication.class);
        component.execute();
    }
}
