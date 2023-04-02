create table post (
    id            bigint auto_increment primary key comment 'ID',
    member_id     bigint not null comment '회원 id',
    title         varchar(255) not null comment '게시판 제목',
    content       varchar(2000) not null comment '게시판 내용',
    status        varchar(30)  not null default 'ACTIVE' comment '상태',
    created_at    datetime(6) not null comment '생성 일시',
    updated_at    datetime(6) null comment '수정 일시'
) comment '게시판' charset = utf8mb4;

create
index post_idx01 on post (member_id);

create
index post_idx02 on post (title);

create
index post_idx03 on post (content);
