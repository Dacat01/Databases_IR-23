package com.hamal.lab6.repository;

import com.hamal.lab6.domain.CurrentLocation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CurrentLocationRepository extends JpaRepository<CurrentLocation, Integer> {
}
