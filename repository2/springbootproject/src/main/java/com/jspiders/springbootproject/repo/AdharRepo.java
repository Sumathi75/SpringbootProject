package com.jspiders.springbootproject.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.jspiders.springbootproject.Entity.Adhar;

public interface  AdharRepo extends JpaRepository<Adhar, Integer> {

	@Query("select a from Adhar a where a.number =?1")
	public Adhar findByNumber(long adharnumber);
}
