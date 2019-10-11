package com.surveyshrike.jpa.entity;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Data;

@Table(name = "T_SURVEY")
@Entity
@Data
public class SurveyEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "SURVEY_ID")
  private Long id;

  @Column(name = "NAME")
  private String name;

  @Column(name = "DESCRIPTION")
  private String description;

  @ManyToOne
  @JoinColumn(name="CREATOR_ID",referencedColumnName="CREATOR_ID")
  private CreatorEntity creator;

  @OneToMany(mappedBy = "survey", cascade = CascadeType.ALL, orphanRemoval = true)
  private List<QuestionAnswerEntity> questionAnswers;
}
