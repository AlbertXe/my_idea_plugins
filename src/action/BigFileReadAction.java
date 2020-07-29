package action;

import application.BigFileReadComponent;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import utils.ComponentUtils;

public class BigFileReadAction extends AnAction {

    @Override
    public void actionPerformed(AnActionEvent e) {
        BigFileReadComponent component = ComponentUtils.buildComponent(BigFileReadComponent.class);
        component.execute();
    }
}
