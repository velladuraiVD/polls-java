package com.voting.voting_app.service;

import com.voting.voting_app.model.Poll;
import com.voting.voting_app.repo.PollRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PollService {
    @Autowired
    private  PollRepo pollrepo;


    public Poll createPoll(Poll poll) {

        return pollrepo.save(poll);
    }

    public List<Poll> getAllPolls() {

        return pollrepo.findAll();
    }

    public Optional<Poll> getPollsById(Long id) {
        return pollrepo.findById(id);
    }
}
