package com.sanskar.challenge;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/challenges")
public class challengeController {
    private ChallengeService challengeService;

    public challengeController(ChallengeService challengeService) {
        this.challengeService = challengeService;
    }

    @GetMapping
    public ResponseEntity<List<Challenge>> getAllChallenges() {
        return new ResponseEntity(challengeService.getAllChallenges(),HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String>  addchallenges(@RequestBody Challenge challenge){
        boolean isChallengeAdded=challengeService.addchallenges(challenge);
        if(isChallengeAdded) {
            return new ResponseEntity("challenge added successfully",HttpStatus.OK);
        }else {
            return new ResponseEntity("challenge not added",HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{month}")
    public ResponseEntity<Challenge> getChallenge(@PathVariable String  month){
       Challenge challenge=challengeService.getChallenge(month);
       if(challenge!=null)
           return  new ResponseEntity(challenge, HttpStatus.OK);
       else
            return new ResponseEntity(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/{id}")
    public  ResponseEntity<String > updateChallenge(@PathVariable Long id,@RequestBody Challenge updatedChallange){
        boolean isupdated=challengeService.updateChallange(id,updatedChallange);
        if(isupdated) {
            return new ResponseEntity("challenge updated successfully",HttpStatus.OK);
        }else {
            return new ResponseEntity("challenge not updated",HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String >deleteChallange(@PathVariable Long id){
        boolean isdeleted=challengeService.deleteChallange(id);
        if(isdeleted) {
            return new ResponseEntity("challenge deleted successfully",HttpStatus.OK);
        }else {
            return new ResponseEntity("challenge not deleted",HttpStatus.NOT_FOUND);
        }


    }
}
