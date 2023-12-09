CREATE TABLE member
(
    `id`            INT            NOT NULL    AUTO_INCREMENT,
    `email`         VARCHAR(50)    NOT NULL    COMMENT '구글이메일. UNIQUE',
    `password`      VARCHAR(50)    NOT NULL    COMMENT '비밀번호',
    `name`          VARCHAR(50)    NULL        COMMENT '이름',
    `nickname`      VARCHAR(50)    NULL        COMMENT '닉네임',
    `gender`        VARCHAR(50)    NULL        COMMENT '성별',
    `phone_number`  VARCHAR(50)    NULL        COMMENT '전화번호',
    `created_at`    TIMESTAMP      NULL        COMMENT '생성일',
    PRIMARY KEY (id)
);

ALTER TABLE member COMMENT '유저';

CREATE TABLE decoration
(
    `id`           INT            NOT NULL    AUTO_INCREMENT,
    `description`  VARCHAR(50)    NULL        COMMENT '장식품 종류',
    `file`         BLOB           NULL        COMMENT '3D파일',
    `created_at`   TIMESTAMP      NULL        COMMENT '생성일',
    PRIMARY KEY (id)
);

CREATE TABLE submission
(
    `id`             INT              NOT NULL    AUTO_INCREMENT,
    `member_id`      INT              NOT NULL    COMMENT '후원한 사람',
    `decoration_id`  INT              NOT NULL    COMMENT '장식품 종류',
    `amount`         INT              NOT NULL    COMMENT '후원 금액',
    `card_message`   VARCHAR(2048)    NULL        COMMENT '카드 문구. metadata',
    `location`       VARCHAR(2048)    NOT NULL    COMMENT '위치',
    `label`          VARCHAR(50)      NULL        COMMENT '라벨',
    `color`          VARCHAR(50)      NULL        COMMENT '색상',
    `scale`          INT              NOT NULL    DEFAULT 100 COMMENT '크기',
    `created_at`     TIMESTAMP        NULL        COMMENT '생성일',
    `is_actived`     BIT              NULL        DEFAULT 0 COMMENT '활성여부',
    PRIMARY KEY (id)
);

ALTER TABLE submission
    ADD CONSTRAINT FK_submission_decoration_id_decoration_id FOREIGN KEY (decoration_id)
        REFERENCES decoration (id) ON DELETE RESTRICT ON UPDATE RESTRICT;

ALTER TABLE submission
    ADD CONSTRAINT FK_submission_member_id_member_id FOREIGN KEY (member_id)
        REFERENCES member (id) ON DELETE RESTRICT ON UPDATE RESTRICT;

CREATE TABLE designated_person
(
    `id`             INT              NOT NULL    AUTO_INCREMENT,
    `submission_id`  INT              NULL        COMMENT '제출',
    `member_id`      INT              NULL        COMMENT '후원한 사람',
    `send_message`   VARCHAR(2048)    NULL        COMMENT '전송 문구',
    `send_email`     VARCHAR(50)      NULL        COMMENT '전송 이메일',
    `created_at`     TIMESTAMP        NULL        COMMENT '생성일',
    PRIMARY KEY (id)
);

)
ALTER TABLE designated_person
    ADD CONSTRAINT FK_designated_person_member_id_member_id FOREIGN KEY (member_id)
        REFERENCES member (id) ON DELETE RESTRICT ON UPDATE RESTRICT;

ALTER TABLE designated_person
    ADD CONSTRAINT FK_designated_person_submission_id_submission_id FOREIGN KEY (submission_id)
        REFERENCES submission (id) ON DELETE RESTRICT ON UPDATE RESTRICT;


