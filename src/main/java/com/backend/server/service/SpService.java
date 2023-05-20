/*package com.backend.server.service;

import com.backend.server.domain.Member;
import com.backend.server.repository.SpRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SpService {
    private final SpRepository spRepository;


    @Autowired
    public SpService(SpRepository spRepository) {
        this.spRepository = spRepository;
    }
    public Member create(Member member){
        return spRepository.save(member);
    }
    public Optional<Member> read(Long id){
        return spRepository.findById(id);
    }
    public Optional<Member> update(Long id, String kind){
        Member member = read(id).get();
        member.setKind(kind);
        return Optional.ofNullable(spRepository.save(member));
    }
    public void delete(Long id){
        spRepository.deleteById(id);
    }
}
*/