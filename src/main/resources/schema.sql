CREATE TABLE answer (
id                      serial      NOT NULL PRIMARY KEY,
ans_content             text        NOT NULL,
image                   text,
question_id             int         NOT NULL,
delete_flag             smallint    NOT NULL,
createTime              timestamp   NOT NULL,
update                  timestamp   NOT NULL
);
CREATE TABLE respondent (
ans_id                  int         NOT NULL,
question_id             int         NOT NULL,
respondent              varchar(50) NOT NULL,
delete_flag             smallint    NOT NULL,
createTime              timestamp    NOT NULL,
update                  timestamp    NOT NULL
);
CREATE TABLE genre (
id                      serial      NOT NULL PRIMARY KEY,
genrename               varchar(50) NOT NULL,
creater                 varchar(50) NOT NULL,
enabled                 smallint    NOT NULL,
createTime              timestamp    NOT NULL,
update                  timestamp    NOT NULL
);
CREATE TABLE question_genre (
genre_id                int        NOT NULL,
question_id             int        NOT NULL,
createTime              timestamp   NOT NULL,
update                  timestamp   NOT NULL
);
CREATE TABLE question_like (
id                      serial     NOT NULL PRIMARY KEY,
question_id             int        NOT NULL,
user_id                 int        NOT NULL,
like_flag               smallint   NOT NULL,
createTime              timestamp   NOT NULL,
update                  timestamp   NOT NULL
);
CREATE TABLE comment (
id                      serial     NOT NULL PRIMARY KEY,
comment_content         text       NOT NULL,
question_id             int        NOT NULL,
user_id                 int        NOT NULL,
delete_flag             smallint   NOT NULL,
createTime              timestamp   NOT NULL,
update                  timestamp   NOT NULL
);
CREATE TABLE comment_like (
id                      serial     NOT NULL PRIMARY KEY,
comment_id              int        NOT NULL,
user_id                 int        NOT NULL,
like_flag               smallint   NOT NULL,
createTime              timestamp   NOT NULL,
update                  timestamp   NOT NULL
);
CREATE TABLE keep (
id                      serial     NOT NULL PRIMARY KEY,
question_id             int        NOT NULL,
user_id                 int        NOT NULL,
createTime              timestamp   NOT NULL,
update                  timestamp   NOT NULL
);
CREATE TABLE share (
id                      serial     NOT NULL PRIMARY KEY,
share_flag              smallint   NOT NULL,
question_id             int        NOT NULL,
user_id                 int        NOT NULL,
createTime              timestamp   NOT NULL,
update                  timestamp   NOT NULL
);
CREATE TABLE follow (
id                      serial     NOT NULL PRIMARY KEY,
follow_flag             smallint   NOT NULL,
follow_id               int        NOT NULL,
follower_id             int        NOT NULL,
createTime              timestamp   NOT NULL,
update                  timestamp   NOT NULL
);
CREATE TABLE message (
id                      serial     NOT NULL PRIMARY KEY,
message_content         text       NOT NULL,
sender_id               int        NOT NULL,
reception_id            int        NOT NULL,
createTime              timestamp   NOT NULL,
update                  timestamp   NOT NULL
);
CREATE TABLE notification(
notification_flag       smallint   NOT NULL,
user_id                 int        NOT NULL,
answer_id               int        NOT NULL,
question_like_id        int        NOT NULL,
comment_id              int        NOT NULL,
comment_like_id         int        NOT NULL,
follow_id               int        NOT NULL,
keep_id                 int        NOT NULL,
share_id                int        NOT NULL,
message_id              int        NOT NULL,
createTime              timestamp   NOT NULL,
update                  timestamp   NOT NULL
);
CREATE TABLE question (
id                      serial      NOT NULL PRIMARY KEY,
title                   varchar(50) NOT NULL,
ques_content            text        NOT NULL,
image                   text,
user_id                 int         NOT NULL,
delete_flag             smallint    NOT NULL,
createTime              timestamp   NOT NULL,
update                  timestamp   NOT NULL
);
CREATE TABLE users (
id                      serial   PRIMARY KEY  NOT NULL,
username                varchar(50)           NOT NULL,
email                   varchar(70)           NOT NULL,
address                 varchar(255),
profession              varchar(255),
background              varchar(255),
introduction            varchar(255),
password                varchar(500)          NOT NULL,
enabled                 smallint              NOT NULL,
authority               varchar(50)           NOT NULL,
createTime              timestamp             NOT NULL,
update                  timestamp             NOT NULL
);

CREATE TABLE task_type (
id                      serial      NOT NULL PRIMARY KEY,
type                    varchar(20) NOT NULL,
comment                 varchar(50) DEFAULT NULL
);

CREATE TABLE task (
id                      serial      NOT NULL PRIMARY KEY,
user_id                 int         NOT NULL,
type_id                 int         NOT NULL,
title                   varchar(50) NOT NULL,
detail                  text,
deadline                timestamp    NOT NULL
);