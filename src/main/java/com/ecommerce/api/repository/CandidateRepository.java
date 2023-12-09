package com.ecommerce.api.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.ecommerce.api.models.Candidate;

@Repository
public interface CandidateRepository {
    Candidate save(Candidate candidate);

    Candidate findByName(String name);

    List<Candidate> findAll();
}