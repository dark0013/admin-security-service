package com.darkross.adminsecurityservice.service;
import com.darkross.adminsecurityservice.dto.AuditInfo;
import com.darkross.adminsecurityservice.dto.request.CreateUserRequest;
import com.darkross.adminsecurityservice.service.IUserService;
import com.darkross.adminsecurityservice.util.RequestContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class UserService implements IUserService {

    @Override
    public void createUser(CreateUserRequest request) {

        AuditInfo audit = RequestContext.get();
        log.info("🔥 LOG service OK");
//        log.info("""
//            Creating user
//            Name: {} {}
//            IP: {}
//            App: {}
//            RequestId: {}
//            """,
//                request.getNombre(),
//                request.getApellido(),
//                audit.getIp(),
//                audit.getApplication(),
//                audit.getRequestId()
//        );

        // aquí iría persistencia, auditoría DB, etc.
    }
}

