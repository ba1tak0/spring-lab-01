package kz.iitu.spring_lab_01.scope;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import java.util.UUID;

@Service
@Scope("prototype")
public class PrototypeService {

    private final String id = UUID.randomUUID().toString().substring(0, 8);

    public String getId() {
        return id;
    }
}