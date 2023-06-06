/*package com.backend.server.repository;

import com.backend.server.domain.Organization;
import com.backend.server.domain.Recruit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
public interface RecruitRepository extends JpaRepository<Recruit, Long> {

    List<Recruit> findByOrganization(String organization);

    Optional<Recruit> findByaccount(String step);

}
*/