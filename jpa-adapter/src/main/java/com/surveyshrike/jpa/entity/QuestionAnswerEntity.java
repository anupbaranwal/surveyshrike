package com.surveyshrike.jpa.entity;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Data;

@Table(name = "T_QUESTION_ANSWER")
@Entity
@Data
public class QuestionAnswerEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "QUESTION_ID")
  private Long id;

  @Column(name = "QUESTION")
  private String question;

  @Column(name = "TYPE")
  private String type;

  @Column(name= "OPTIONS")
  private String questionOptions;

  @Column(name = "ANSWERS")
  private String answers;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "SURVEY_ID")
  private SurveyEntity survey;
}
