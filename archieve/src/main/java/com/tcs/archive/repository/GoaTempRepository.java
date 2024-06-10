package com.tcs.archive.repository;

import com.tcs.archive.model.GoaTempTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GoaTempRepository extends JpaRepository<GoaTempTable,Integer> {
}
