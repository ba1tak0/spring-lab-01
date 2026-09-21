package kz.iitu.spring_lab_01.web;

import kz.iitu.spring_lab_01.notify.NotificationService;
import kz.iitu.spring_lab_01.scope.PrototypeService;
import kz.iitu.spring_lab_01.scope.RequestScopedService;
import kz.iitu.spring_lab_01.scope.SingletonService;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/lab2")
public class Lab2Controller {

    private final NotificationService notifications;
    private final SingletonService singletonService;
    private final ObjectProvider<PrototypeService> prototypeProvider;
    private final RequestScopedService requestScopedService;

    public Lab2Controller(NotificationService notifications,
                          SingletonService singletonService,
                          ObjectProvider<PrototypeService> prototypeProvider,
                          RequestScopedService requestScopedService) {
        this.notifications = notifications;
        this.singletonService = singletonService;
        this.prototypeProvider = prototypeProvider;
        this.requestScopedService = requestScopedService;
    }

    @GetMapping("/kz/iitu/spring_lab_01/notify")
    public Map<String, Object> notify(@RequestParam(defaultValue = "Hello") String text) {
        return Map.of("primary",   notifications.viaPrimary(text),
                "console",   notifications.viaConsole(text),
                "all",       notifications.viaAll(text),
                "beanNames", notifications.names());
    }

    @GetMapping("/kz/iitu/spring_lab_01/scope")
    public Map<String, String> checkScope() {
        return Map.of(
                "singleton_1", singletonService.getId(),
                "singleton_2", singletonService.getId(),
                "prototype_1", prototypeProvider.getObject().getId(),
                "prototype_2", prototypeProvider.getObject().getId(),
                "request_1",   requestScopedService.getId(),
                "request_2",   requestScopedService.getId()
        );
    }
}