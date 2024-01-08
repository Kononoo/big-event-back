create table bg_user
(
    id          int unsigned auto_increment comment 'ID'
        primary key,
    username    varchar(20)  not null comment '用户名',
    password    varchar(60)  not null comment '密码',
    nickname    varchar(20)  null comment '昵称',
    email       varchar(50)  null comment '邮箱',
    user_pic    varchar(255) null comment '用户头像',
    create_time datetime     not null comment '创建时间',
    update_time datetime     not null comment '更新时间',
    constraint uq_username
        unique (username) comment '用户名唯一'
);

create table bg_category
(
    id             int unsigned auto_increment comment 'ID'
        primary key,
    category_name  varchar(40)  not null comment '种类名称',
    category_alias varchar(40)  null comment '种类别名',
    create_user    int unsigned null comment '创建人Id',
    create_time    datetime     not null comment '创建时间',
    update_time    datetime     not null comment '更新时间',
    constraint fk_category_user
        foreign key (create_user) references bg_user (id)
);

create table bg_article
(
    id          int unsigned auto_increment comment 'ID'
        primary key,
    title       varchar(50)               not null comment '文章标题',
    content     varchar(2000)             not null comment '文章内容',
    cover_img   varchar(255)              null comment '文章封面',
    state       varchar(3) default '草稿' not null comment '文章状态: 只能是[已发布] 或者 [草稿]',
    category_id int unsigned              not null comment '文章分类ID',
    create_user int unsigned              not null comment '创建用户ID',
    create_time datetime                  not null comment '创建时间',
    update_time datetime                  not null comment '更新时间',
    constraint fk_article_category
        foreign key (category_id) references bg_category (id),
    constraint fk_article_user
        foreign key (create_user) references bg_user (id)
);


