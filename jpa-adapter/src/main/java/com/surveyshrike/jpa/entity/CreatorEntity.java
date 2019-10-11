package com.surveyshrike.jpa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Table(name = "T_CREATOR")
@Entity
@Data
public class CreatorEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "CREATOR_ID")
  private Long id;

  @Column(name = "NAME")
  private String name;
}
