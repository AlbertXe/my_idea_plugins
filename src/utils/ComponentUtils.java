package utils;

import com.intellij.openapi.application.Application;
import com.intellij.openapi.application.ApplicationManager;

public class ComponentUtils {
    public static <T> T buildComponent(Class<T> t) {
        Application application = ApplicationManager.getApplication();
        return application.getComponent(t);
    }

}
