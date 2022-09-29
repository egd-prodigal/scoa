create table people
(
    firstName varchar2(10),
    lastName  varchar2(10),
    styleName varchar2(10),
    birth     varchar2(64),
    dead      varchar2(64)
);
create unique index people_name on people (firstName, lastName, styleName);

insert into people(firstName, lastName, styleName, birth, dead)
values ( '关', '羽', '云长', 'Not Record', 'Nil' ),
       ( '曹', '操', '孟德', '东汉永寿元年', 'Nil' ),
       ( '颜', '良', '文恒', 'Not Record', 'Nil' ),
       ( '袁', '绍', '本初', 'Not Record', 'Nil' );

create table camp
(
    lord varchar2(10),
    firstName varchar2(10),
    lastName  varchar2(10),
    styleName varchar2(10),
    official varchar2(10)
);

insert into camp(lord, firstName, lastName, styleName, official)
values ( '曹操', '关', '羽', '云长', 'general' ),
       ( '曹操', '曹', '操', '孟德', 'lord' ),
       ( '袁绍', '颜', '良', '文恒', 'general' ),
       ( '袁绍', '袁', '绍', '本初', 'lord' );

create table history
(
    reign_title varchar2(64),
    history varchar2(2048)
);
