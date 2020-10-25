-- Main Task Task => 7 

-- Additional Exercise
-- Please also write the SQL queries needed to perform the following tasks:

-- 1. Return all users who are friends with Kermit, make sure their names are displayed in results.
-- TODO mergie frind first name with first name + frind last name with last name

select users.first_name,users.last_name,friend.first_name as 'friend_first_name',friend.last_name as 'friend_last_name'
from friendships.users
join friendships.friendships on friendships.user_id = users.id
right join friendships.users as friend on friendships.friend_id = friend.id
where users.first_name = 'Kermit'
or friend.first_name = 'Kermit';

-- 2. Return the count of all friendships
-- TODO 

-- show me all my friends and count them !

select *
from friendships.friendships;

-- -- find number of friends to
		select users.id,COUNT(*) as 'friends_to'
		from friendships.friendships
		left join friendships.users on friendships.friend_id = users.id
		group by users.id;

-- -- find my friends 
		select users.id,COUNT(*) as 'my_friends'
		from friendships.friendships
		left join friendships.users on friendships.user_id = users.id
		group by users.id;
-- ------
 		select users.id,COUNT(*) as 'my_friends'
		from friendships.users
		left join friendships.friendships on friendships.user_id = users.id
        left join friendships.friendships as friends_to on friends_to.friend_id = users.id
		group by users.id;

-- -- -- -- -- Sum is here. 

		select u.id,(IFNULL((select COUNT(*)
				from friendships.friendships
				left join friendships.users on friendships.friend_id = users.id
				where u.id = users.id
				group by users.id),0) +
				IFNULL((select COUNT(*)
				from friendships.friendships
				left join friendships.users on friendships.user_id = users.id
				where u.id = users.id
				group by users.id
				),0)) as 'my_friends'
		from friendships.users u;

-- 		select u.id,(select COUNT(*)
-- 				from friendships.friendships
-- 				left join friendships.users on friendships.friend_id = users.id
-- 				where u.id = users.id
-- 				group by users.id),
-- 				(select COUNT(*)
-- 				from friendships.friendships
-- 				left join friendships.users on friendships.user_id = users.id
-- 				where u.id = users.id
-- 				group by users.id
-- 				)
-- 		from friendships.users u;

-- 3. Find out who has the most friends and return the count of their friends.
-- TODO -

-- 		select u.id,MAX((IFNULL((select COUNT(*)
-- 				from friendships.friendships
-- 				left join friendships.users on friendships.friend_id = users.id
-- 				where u.id = users.id
-- 				group by users.id),0) +
-- 				IFNULL((select COUNT(*)
-- 				from friendships.friendships
-- 				left join friendships.users on friendships.user_id = users.id
-- 				where u.id = users.id
-- 				group by users.id
-- 				),0))) as 'my_friends'
-- 		from friendships.users u;

-- 4. Create a new user and make them friends with Eli Byers, Kermit The Frog, and Marky Mark
-- new user insertion 
insert into friendships.users (first_name,last_name,created_at)
	   values ('Murtada','Almutawah',NOW());

select * from friendships.users;

insert into friendships.friendships (user_id,friend_id,created_at)
	   values ((select users.id from friendships.users where users.first_name = 'Murtada'),(select users.id from friendships.users where users.first_name = 'Eli'),NOW());

insert into friendships.friendships (user_id,friend_id,created_at)
	   values ((select users.id from friendships.users where users.first_name = 'Murtada'),(select users.id from friendships.users where users.first_name = 'Kermit'),NOW());

insert into friendships.friendships (user_id,friend_id,created_at)
	   values ((select users.id from friendships.users where users.first_name = 'Murtada'),(select users.id from friendships.users where users.first_name = 'Marky'),NOW());
       
select * from friendships.friendships;

-- 5. Return the friends of Eli in alphabetical order
-- TODO mergie frind first name with first name + frind last name with last name

select users.first_name,users.last_name,friend.first_name as 'friend_first_name',friend.last_name as 'friend_last_name'
from friendships.users
join friendships.friendships on friendships.user_id = users.id
join friendships.users as friend on friendships.friend_id = friend.id
where (users.first_name= 'Eli' or friend.first_name = 'Eli')
order by friend.first_name asc;

-- 6. Remove Marky Mark from Eli’s friends.
-- running both commands 

DELETE from friendships.friendships 
		where user_id = (select users.id from friendships.users where users.first_name = 'Eli')
        and friend_id = (select users.id from friendships.users where users.first_name = 'Marky');

DELETE from friendships.friendships 
		where friend_id = (select users.id from friendships.users where users.first_name = 'Eli')
        and  user_id = (select users.id from friendships.users where users.first_name = 'Marky');        

-- To reverse it 
insert into friendships.friendships (user_id,friend_id,created_at)
	   values ((select users.id from friendships.users where users.first_name = 'Eli'),(select users.id from friendships.users where users.first_name = 'Marky'),NOW());
    

-- 7. Return all friendships, displaying just the first and last name of both friends
select users.first_name,users.last_name,friend.first_name as 'friend_first_name',friend.last_name as 'friend_last_name'
from friendships.users
join friendships.friendships on friendships.user_id = users.id
left join friendships.users as friend on friendships.friend_id = friend.id;