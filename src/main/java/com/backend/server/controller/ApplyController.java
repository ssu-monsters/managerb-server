package com.backend.server.controller;

import com.backend.server.domain.Member;
//import com.backend.itfs.Crudinterface;
//import com.backend.model.network.Header;
import com.backend.server.request.ApplyRequest;
import com.backend.server.request.ApplyResponse;

import com.backend.server.service.ApplyService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class ApplyController {

    private final ApplyService applyService;

    @PostMapping(value = "/apply")
    public ResponseEntity<ApplyResponse> apply(@RequestBody ApplyRequest request) throws Exception {

        return new ResponseEntity<>(applyService.create(request), HttpStatus.OK);
    }

    /*@GetMapping("{account}")
    public ApplyResponse read(@PathVariable("account") Long id) {
        return applyService.read(id);
    }
    /*@GetMapping("/user")
    public Header<ApplyResponse> user_read(@PathVariable("organiazaiont") String ){

    }*/


}