package com.demoon.uplearning.repository;


import com.demoon.uplearning.entity.Project;
import com.demoon.uplearning.entity.Role;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends CrudRepository<Project, Integer> {
}
