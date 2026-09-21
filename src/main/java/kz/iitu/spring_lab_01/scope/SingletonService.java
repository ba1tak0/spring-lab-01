package kz.iitu.spring_lab_01.scope;

import org.springframework.stereotype.Service;
import java.util.UUID;

@Service
public class SingletonService {

    private final String id = UUID.randomUUID().toString().substring(0, 8);

    public String getId() {
        return id;
    }
}