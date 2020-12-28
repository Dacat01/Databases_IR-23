package com.hamal.lab6.repository;

import com.hamal.lab6.domain.PlaneInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlaneInfoRepository extends JpaRepository<PlaneInfo, Integer> {
}
