INSERT INTO T_CREATOR(CREATOR_ID, NAME) VALUES
(1, 'anup'),
(2, 'ansh');

INSERT INTO T_SURVEY(SURVEY_ID, NAME, DESCRIPTION, CREATOR_ID) VALUES
(1, 'Survey 1','Survey 1 desc',1),
(2, 'Survey 2','Survey 2 desc',1),
(3, 'Survey 3','Survey 3 desc',2),
(4, 'Survey 4','Survey 4 desc',2);

INSERT INTO T_QUESTION_ANSWER(QUESTION_ID, QUESTION, TYPE, ANSWERS, OPTIONS, SURVEY_ID) values
(1, 'Question 1', 'M', '', 'CHOICE1;CHOICE2;CHOICE3', 1),
(2, 'Question 2', 'T', '', '', 1),
(3, 'Question 1', 'S', '', 'Agree;Disagree', 2),
(4, 'Question 1', 'T', '', '', 2);
