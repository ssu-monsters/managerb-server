package com.backend.server.controller;

import com.backend.server.request.SignRequest;
import com.backend.server.request.SignResponse;
import com.backend.server.repository.SpRepository;
import com.backend.server.service.SignService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

//@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequiredArgsConstructor
public class SignController {

    private final SpRepository memberRepository;
    private final SignService memberService;
    private final SignService organizationService;


    @PostMapping(value = "/login")
    public ResponseEntity<SignResponse> signin(@RequestBody SignRequest request) throws Exception {
        return new ResponseEntity<>(memberService.login(request), HttpStatus.OK);
    }

    @PostMapping(value = "/register")
    public ResponseEntity<Boolean> membersignup(@RequestBody SignRequest request) throws Exception {
        return new ResponseEntity<>(memberService.register(request), HttpStatus.OK);
    }
    @PostMapping(value = "/og_login")
    public ResponseEntity<SignResponse> organizationsignin(@RequestBody SignRequest request) throws Exception {
        return new ResponseEntity<>(organizationService.og_login(request), HttpStatus.OK);
    }
    @PostMapping(value = "/og_register")
    public ResponseEntity<Boolean> organizationsignup(@RequestBody SignRequest request) throws Exception {
        return new ResponseEntity<>(organizationService.og_register(request), HttpStatus.OK);
    }
    @GetMapping("/user/get")
    public ResponseEntity<SignResponse> getUser(@RequestParam String account) throws Exception {
        return new ResponseEntity<>( memberService.getMember(account), HttpStatus.OK);
    }

    @GetMapping("/organization/get")
    public ResponseEntity<SignResponse> getOrganization(@RequestParam String account) throws Exception {
        return new ResponseEntity<>( organizationService.getOrganization(account), HttpStatus.OK);
    }


}
