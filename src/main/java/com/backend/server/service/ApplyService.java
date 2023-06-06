package com.backend.server.service;

//import com.backend.itfs.Crudinterface;
import com.backend.server.domain.Apply;
//import com.backend.model.network.Header;
import com.backend.server.domain.Member;
import com.backend.server.request.ApplyRequest;
import com.backend.server.request.ApplyResponse;
import com.backend.server.repository.ApplyRepository;
import com.backend.server.repository.OrganizationRepository;
import com.backend.server.repository.SpRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class ApplyService {//implements Crudinterface<ApplyRequest, ApplyResponse> {

    private final ApplyRepository applyRepository;



    public ApplyResponse create(ApplyRequest request) throws Exception{
       // ApplyRequest body = request.getData()
        Apply apply = applyRepository.findByAccount(request.getAccount()).orElseThrow(() ->
                new BadCredentialsException("잘못된 계정정보입니다."));




        return ApplyResponse.builder()
                .account(apply.getAccount())
                .organizationsId(apply.getOrganizationsId())
                .state(apply.getState())
                .contentUrl(apply.getContentUrl())
                //.createdAt(LocalDateTime.now())
                //.updatedAt(LocalDateTime.now())
                .build();
    }

    /*public ApplyResponse read(Long id) {
        return applyRepository.findById(id)
                .map(apply->response(apply));

    }*/

}