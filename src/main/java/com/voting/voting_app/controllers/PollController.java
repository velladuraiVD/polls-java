package com.voting.voting_app.controllers;

import com.voting.voting_app.model.Poll;
import com.voting.voting_app.service.PollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/polls")
public class PollController {

    @Autowired
    private  PollService pollService;



    @PostMapping
    public Poll createPoll(@RequestBody Poll poll) {
        return pollService.createPoll(poll);
    }

    @GetMapping
    public List<Poll> getAllPolls(){
        return pollService.getAllPolls();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Poll> getPollsById(@PathVariable Long id){
        return pollService.getPollsById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

}
