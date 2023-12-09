package com.ecommerce.api.controllers;

import org.springframework.web.bind.annotation.*;

import com.ecommerce.api.models.Candidate;
import com.ecommerce.api.service.CandidateService;

import java.util.List;

@RestController
@RequestMapping("/api")

public class CandidateController {
   
	//private final CandidateService candidateService;

    //public CandidateController(CandidateService candidateService) {
      //  this.candidateService = candidateService;
    //}
	
	private  CandidateService candidateService;

    @PostMapping("/entercandidate")
    public void enterCandidate(@RequestParam String name) {
        candidateService.enterCandidate(name);
    }

    @PostMapping("/castvote")
    public int castVote(@RequestParam String name) {
        return candidateService.castVote(name);
    }

    @GetMapping("/countvote")
    public int countVote(@RequestParam String name) {
        return candidateService.countVote(name);
    }

    @GetMapping("/listvotes")
    public List<Candidate> listVotes() {
        return candidateService.listVotes();
    }

    @GetMapping("/getwinner")
    public String getWinner() {
        return candidateService.getWinner();
    }
}
