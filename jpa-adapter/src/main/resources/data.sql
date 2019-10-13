INSERT INTO T_CREATOR(CREATOR_ID, NAME) VALUES
(100, 'anup'),
(200, 'ansh');

INSERT INTO T_SURVEY(SURVEY_ID, NAME, DESCRIPTION, CREATOR_ID) VALUES
(111, 'Survey 1','Survey 1 desc',100),
(222, 'Survey 2','Survey 2 desc',100),
(333, 'Survey 3','Survey 3 desc',200),
(444, 'Survey 4','Survey 4 desc',200);

INSERT INTO T_QUESTION_ANSWER(QUESTION_ID, QUESTION, TYPE, ANSWERS, OPTIONS, SURVEY_ID) values
(100, 'Question 1', 'M', '', 'CHOICE1;CHOICE2;CHOICE3', 111),
(200, 'Question 2', 'T', '', '', 111),
(300, 'Question 1', 'S', '', 'Agree;Disagree', 222),
(400, 'Question 1', 'T', '', '', 222);
