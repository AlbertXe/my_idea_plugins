import com.intellij.openapi.components.ServiceManager;

public interface MyApplicationService {
    static MyApplicationService getInstance() {
        return ServiceManager.getService(MyApplicationService.class);
    }
}
