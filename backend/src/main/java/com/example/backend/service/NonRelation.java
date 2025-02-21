package com.example.backend.service;

import com.example.backend.domain.Child;
import com.example.backend.domain.Parent;
import com.example.backend.domain.Personality;
import com.example.backend.dto.request.ChildRequest;
import com.example.backend.dto.request.ParentRequest;
import com.example.backend.repository.ChildRepository;
import com.example.backend.repository.ParentRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class NonRelation {
    private final ChildRepository childRepository;
    private final ParentRepository parentRepository;


    public NonRelation(ChildRepository childRepository, ParentRepository parentRepository) {
        this.childRepository = childRepository;
        this.parentRepository = parentRepository;

    }

    @Transactional
    public void testChildRelational(ParentRequest parentRequest, ChildRequest childRequest){
        // 인수를 비어있어면 기본생성자를 불러옴
        Parent parent = new Parent(parentRequest.getEmail(), parentRequest.getName());
        parentRepository.save(parent);


        //child 에 parent 에 넣음
        Child child = new Child(childRequest.getLoginId(),childRequest.getPassword(),childRequest.getName());
        child.setParent(parent);
        childRepository.save(child);

        Parent saveParent = parentRepository.findById(parent.getId()).orElseThrow();
        System.out.println("Parent 정보" +saveParent.getChildList());

    }

    @Transactional
    public  void relationmethod(ParentRequest parentRequest, ChildRequest childRequest){
        Parent parent = new Parent(parentRequest.getEmail(), parentRequest.getName());
        parentRepository.save(parent);

        Child child = new Child(childRequest.getLoginId(),childRequest.getPassword(),childRequest.getName());
        parent.addChild(child);
        childRepository.save(child);

        Parent saveParent = parentRepository.findById(parent.getId()).orElseThrow();
        System.out.println("Parent 정보" +saveParent.getChildList());
    }


}
