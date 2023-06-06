package com.backend.server.service;

import com.backend.server.domain.*;
import com.backend.server.repository.OrganizationRepository;
//import com.backend.server.repository.RecruitRepository;
import com.backend.server.repository.SpRepository;
import com.backend.server.request.SignRequest;
import com.backend.server.request.SignResponse;
import com.backend.server.security.JwtProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;

@Service
@Transactional
@RequiredArgsConstructor
public class SignService {

    private final SpRepository memberRepository;
    private final OrganizationRepository organizationRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtProvider jwtProvider;

    //private final RecruitRepository recruitRepository;
    public SignResponse login(SignRequest request) throws Exception {
        Member member = memberRepository.findByAccount(request.getAccount()).orElseThrow(() ->
                new BadCredentialsException("잘못된 계정정보입니다."));

        if (!passwordEncoder.matches(request.getPassword(), member.getPassword())) {
            throw new BadCredentialsException("잘못된 계정정보입니다.");
        }

        return SignResponse.builder()
                .id(member.getId())
                .account(member.getAccount())
                .name(member.getName())
                .email(member.getEmail())
                .roles(member.getRoles())
                .gender(member.getGender())
                .thumbnail(member.getThumbnail())
                .token(jwtProvider.createToken(member.getAccount(), member.getRoles()))
                .build();

    }
    public SignResponse og_login(SignRequest request) throws Exception {
        Organization organization = organizationRepository.findByAccount(request.getAccount()).orElseThrow(() ->
                new BadCredentialsException("잘못된 계정정보입니다."));

        if (!passwordEncoder.matches(request.getPassword(), organization.getPassword())) {
            throw new BadCredentialsException("잘못된 계정정보입니다.");
        }

        return SignResponse.builder()
                .id(organization.getId())
                .account(organization.getAccount())
                .name(organization.getName())
                .email(organization.getEmail())
                .og_roles(organization.getOg_roles())
                .thumbnail(organization.getThumbnail())
                .token(jwtProvider.createToken2(organization.getAccount(), organization.getOg_roles()))
                .build();

    }
    public boolean register(SignRequest request) throws Exception {
        try {
            Member member = Member.builder()
                    .account(request.getAccount())
                    .password(passwordEncoder.encode(request.getPassword()))
                    .name(request.getName())
                    .email(request.getEmail())
                    .gender(request.getGender())
                    .thumbnail(request.getThumbnail())
                    .build();

            member.setRoles(Collections.singletonList(Authority1.builder().name("ROLE_USER").build()));

            memberRepository.save(member);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new Exception("잘못된 요청입니다.");
        }
        return true;
    }

    public boolean og_register(SignRequest request) throws Exception {
        try {
            Organization organization = Organization.builder()
                    .account(request.getAccount())
                    .password(passwordEncoder.encode(request.getPassword()))
                    .name(request.getName())
                    .email(request.getEmail())
                    .thumbnail(request.getThumbnail())
                    .build();

            organization.setRoles(Collections.singletonList(Authority2.builder().name("ROLE_USER").build()));

            organizationRepository.save(organization);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new Exception("잘못된 요청입니다.");
        }
        return true;
    }

    public SignResponse getMember(String account) throws Exception {
        Member member = memberRepository.findByAccount(account)
                .orElseThrow(() -> new Exception("계정을 찾을 수 없습니다."));
        return new SignResponse(member);
    }
    public SignResponse getOrganization(String account) throws Exception {
        Organization organization = organizationRepository.findByAccount(account)
                .orElseThrow(() -> new Exception("계정을 찾을 수 없습니다."));
        return new SignResponse(organization);
    }

}
