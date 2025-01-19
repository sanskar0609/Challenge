package com.sanskar.challenge;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ChallengeService {
    private List<Challenge>challenges=new ArrayList<>();
    private Long nextId=1L;

    public ChallengeService(){

    }

    public List<Challenge> getAllChallenges(){
        return challenges;
    }

    public boolean addchallenges(Challenge challenge){
        if(challenge!=null){
            challenge.setId(nextId++);
        challenges.add(challenge);
        return true;
        }
        else {
            return false;
        }
    }

    public Challenge getChallenge(String  month) {
        for(Challenge challenge:challenges){
            if(challenge.getMonth().equals(month)){
                return challenge;
            }
        }
        return null;

    }

    public boolean updateChallange(Long id, Challenge updatedChallange) {
        for(Challenge challenge:challenges){
            if(challenge.getId().equals(id)){
                challenge.setMonth(updatedChallange.getMonth());
                challenge.setDescription(updatedChallange.getDescription());
                return true;
            }
        }
        return false;
    }

    public boolean deleteChallange(Long id) {
        return challenges.removeIf(challenge -> challenge.getId().equals(id));
    }
}
