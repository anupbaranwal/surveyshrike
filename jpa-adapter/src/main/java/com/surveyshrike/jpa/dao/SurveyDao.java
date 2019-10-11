package com.surveyshrike.jpa.dao;

import com.surveyshrike.jpa.entity.SurveyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SurveyDao extends JpaRepository<SurveyEntity, Long> {

}
