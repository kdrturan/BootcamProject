package com.BootCampProject.BootCampProject.repository;

import com.BootCampProject.BootCampProject.entity.Application;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApplicationRepository extends JpaRepository<Application,Integer> {
}
