package com.example.backend.repository;

import com.example.backend.domain.Parent;
import com.example.backend.domain.Personality;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ParentRepository extends JpaRepository<Parent,Long> {

}
