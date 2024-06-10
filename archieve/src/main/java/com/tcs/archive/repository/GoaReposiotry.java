package com.tcs.archive.repository;

import com.tcs.archive.model.GoaTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GoaReposiotry extends JpaRepository<GoaTable,Integer> {
}
