show tables;

desc guestbook;

-- insert
insert into guestbook values(null, 'jw', '1234', 'hi', now());

-- select
select no, name, date_format(reg_date, '%Y/%m/%d %H:%i:%s') as reg_date, message 
from guestbook 
order by reg_date desc;

-- delete
delete from guestbook where no = 1 and password = '1234';