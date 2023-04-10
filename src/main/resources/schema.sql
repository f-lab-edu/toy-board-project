drop table if exists member;

create table member (
    id         bigint auto_increment primary key comment 'ID',
    login_id   varchar(255) not null comment '회원 id',
    user_name   varchar(255) not null comment '회원 이름',
    password   varchar(255) not null comment '비밀번호',
    email         varchar(255) not null comment 'email',
    status        varchar(30)  not null default 'ENABLE' comment '상태',
    created_at    datetime(6) null comment '생성 일시',
    updated_at    datetime(6) null comment '수정 일시'
);
