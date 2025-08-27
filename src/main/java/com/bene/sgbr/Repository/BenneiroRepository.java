package com.bene.sgbr.Repository;

import com.bene.sgbr.model.Benneiro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BenneiroRepository extends JpaRepository<Benneiro, Long> {
}