package com.voting.voting_app.service;

import com.voting.voting_app.model.OptionVote;
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

    public void vote(Long pollId, int optionIndex) {
        //get poll from DB
        Poll poll = pollrepo.findById(pollId).orElseThrow(()->new RuntimeException("Poll NotFound"));
        //Get All option of poll
        List<OptionVote> options=poll.getOptions();
        //if index is not valid throw error
        if(optionIndex<0 || optionIndex>= options.size()){
            throw new IllegalArgumentException("Invalid option index");
        }
        //Get Selected Option
        OptionVote selectedOption = options.get(optionIndex);
        //Increment Vote for Slected Option
        selectedOption.setVoteCount(selectedOption.getVoteCount()+1);
        //save incremented vote option into DB
        pollrepo.save(poll);
    }
}
