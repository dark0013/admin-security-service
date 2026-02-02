package com.darkross.adminsecurityservice.service;

import com.darkross.adminsecurityservice.domain.User;
import com.darkross.adminsecurityservice.exception.ModelNotFoundException;
import com.darkross.adminsecurityservice.repository.IGenericRepo;
import com.darkross.adminsecurityservice.repository.IUserReporitory;
import com.darkross.adminsecurityservice.service.interfaces.IUserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@AllArgsConstructor
public class UserServiceImpl extends CRUDImpl<User, Integer> implements IUserService {

    private final IUserReporitory repository;

    @Override
    protected IGenericRepo<User, Integer> getRepo() {
        return repository;
    }


   /*
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
    }*/
}

