package com.BootCampProject.BootCampProject.repository;

import com.BootCampProject.BootCampProject.entity.Applicant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApplicantRepository extends JpaRepository<Applicant,Integer> {
}
