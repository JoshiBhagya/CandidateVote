package com.ecommerce.api.service;

import org.springframework.stereotype.Service;

import com.ecommerce.api.models.Candidate;
import com.ecommerce.api.repository.CandidateRepository;

import java.util.List;

@Service
public class CandidateService {
   // private final CandidateRepository candidateRepository;

    //public CandidateService(CandidateRepository candidateRepository) {
       // this.candidateRepository = candidateRepository;
    //}

	private CandidateRepository candidateRepository;


    public Candidate enterCandidate(String name) {
        Candidate candidate = new Candidate(name);
        Candidate dbcandidate =  candidateRepository.save(candidate);
       return  dbcandidate;
    }

    public int castVote(String name) {
        Candidate candidate = candidateRepository.findByName(name);
        if (candidate != null) {
            candidate.setVoteCount(candidate.getVoteCount() + 1);
            return candidate.getVoteCount();
        } else {
            throw new IllegalArgumentException("Invalid candidate name");
        }
    }

    public int countVote(String name) {
        Candidate candidate = candidateRepository.findByName(name);
        if (candidate != null) {
            return candidate.getVoteCount();
        } else {
            throw new IllegalArgumentException("Invalid candidate name");
        }
    }

    public List<Candidate> listVotes() {
        return candidateRepository.findAll();
    }

    public String getWinner() {
        List<Candidate> candidates = candidateRepository.findAll();
        Candidate winner = candidates.stream()
                .max((c1, c2) -> Integer.compare(c1.getVoteCount(), c2.getVoteCount()))
                .orElse(null);

        return (winner != null) ? winner.getName() : null;
    }
}
