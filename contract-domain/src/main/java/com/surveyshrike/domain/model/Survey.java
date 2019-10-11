package com.surveyshrike.domain.model;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Survey {
  private Long id;
  private String name;
  private String description;
  private String creatorName;
  private Long creatorId;
  private List<QuestionAnswer> questionAnswer;
}
