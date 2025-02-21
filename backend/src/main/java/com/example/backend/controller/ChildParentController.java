package com.example.backend.controller;


import com.example.backend.domain.Child;
import com.example.backend.domain.Personality;
import com.example.backend.service.ChildPersonality;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ChildParentController {

//    private final NonRelation nonRelation;
    private final ChildPersonality childPersonality;

//    public ChildParentController(NonRelation nonRelation) {
//        this.nonRelation = nonRelation;
//    }

    public ChildParentController(ChildPersonality childPersonality) {
        this.childPersonality = childPersonality;
    }

//    @PostMapping("/childparent")
//    public void testChildRelational(@RequestBody ChildParentRequest request){
//        nonRelation.testChildRelational(request.getParentRequest(), request.getChildRequest());
//    }
//
//    @PostMapping("/relationmethod")
//    public void relationmethod(@RequestBody ChildParentRequest request){
//        nonRelation.relationmethod(request.getParentRequest(), request.getChildRequest());
//    }

    @PostMapping("/{childID}/personality")
    public ResponseEntity<String> addPersonalityToChild(
            @PathVariable Long childID,
            @RequestParam String personalityName)
    {
        childPersonality.addPersonalityToChild(childID, personalityName);
        return ResponseEntity.ok("추가 성공");
    }

    @GetMapping("/{childID}/personality")
    public ResponseEntity<List<Personality>> getChildPersonality(
            @PathVariable Long childID)
    {
        return ResponseEntity.ok(childPersonality.getChildPersonality(childID));
    }

    @GetMapping("/{personalityID}/child")
    public ResponseEntity<List<Child>> getPersonalityChild(
            @PathVariable Long personalityID
    ){
        return ResponseEntity.ok(childPersonality.getPersonalityChild(personalityID));
    }

}
