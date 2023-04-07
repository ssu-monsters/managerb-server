package com.backend.server.controller;

import com.backend.server.domain.Member;
import com.backend.server.service.SpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000")//프로트 백엔드가 분리되어있어서 cors문제발생 이걸로 해결 도메인에 접근허용
@RestController
@RequestMapping("/member")//member로요청이 들어오면 해당 클래스 매핑
public class SpController {

    private final SpService spService;

    @Autowired//Constructor를 통한 Di
    public SpController(SpService spService) {
        this.spService = spService;
    }

    @PostMapping("/create")
    public ResponseEntity<Member> create(@RequestBody Member member) {
        return ResponseEntity.ok()
                .body(spService.create(member));
    }

    @GetMapping("/read/{id}")
    public ResponseEntity<Member> read(@PathVariable Long id) {
        return ResponseEntity.ok()
                .body(spService.read(id).get());
    }

    @PutMapping("/update")
    public ResponseEntity<Optional<Member>> read(@RequestParam Long id, @RequestParam int master) {
        return ResponseEntity.ok()
                .body(spService.update(id, master));
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id) {
        spService.delete(id);

    }
}