create table comment (
    id            bigint auto_increment primary key comment 'ID',
    member_id     bigint not null comment '회원 id',
    post_id       bigint not null comment '게시판 id',
    content       varchar(500) not null comment '댓글 내용',
    status        varchar(30)  not null default 'ACTIVE' comment '상태',
    created_at    datetime(6) not null comment '생성 일시',
    updated_at    datetime(6) null comment '수정 일시'
) comment '게시판 댓글' charset = utf8mb4;

create
index comment_idx01 on comment (member_id);

create
index comment_idx02 on comment (post_id);
