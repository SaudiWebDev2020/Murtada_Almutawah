-- 1. What query would you run to get the total revenue for March of 2012?
select 'month',sum(billing.amount) as 'revenue'
from lead_gen_business.billing
where billing.charged_datetime between str_to_date('2012-03-01','%Y-%m-%d') and str_to_date('2012-03-31','%Y-%m-%d');

-- 2. What query would you run to get total revenue collected from the client with an id of 2?
select client_id,sum(billing.amount) as 'total_revenue'
from lead_gen_business.billing
where billing.client_id = 2;

-- 3. What query would you run to get all the sites that client with an id of 10 owns?
select domain_name as 'website',client_id
from lead_gen_business.sites
where sites.client_id = 10;

-- 4. What query would you run to get total # of sites created per month per year for the client with an id of 1? What about for client with an id of 20?
select client_id,COUNT(*) as 'number_of_website',MONTHNAME(created_datetime),year(created_datetime)
from lead_gen_business.sites
where sites.client_id = 1
GROUP BY  Year(created_datetime),Month(created_datetime);

select client_id,COUNT(*) as 'number_of_website',MONTHNAME(created_datetime),year(created_datetime)
from lead_gen_business.sites
where sites.client_id = 20
GROUP BY  Year(created_datetime),Month(created_datetime);

-- 5. What query would you run to get the total # of leads generated for each of the sites between January 1, 2011 to February 15, 2011?
select sites.domain_name as 'website',count(*) as 'number_of_leads'
from lead_gen_business.leads
join lead_gen_business.sites on leads.site_id = sites.site_id
where leads.registered_datetime between '2011-01-1' and '2011-02-15'
group by domain_name;

-- 6. What query would you run to get a list of client names and the total # of leads we've generated for each of our clients between January 1, 2011 to December 31, 2011?
select concat_ws(' ',clients.first_name,clients.last_name) as 'client',count(*) as 'number_of_leads'
from lead_gen_business.leads
join lead_gen_business.sites on leads.site_id = sites.site_id
join lead_gen_business.clients on sites.client_id = clients.client_id
where leads.registered_datetime between '2011-01-1' and '2011-12-31'
group by clients.client_id;

-- 7. What query would you run to get a list of client names and the total # of leads we've generated for each client each month between months 1 - 6 of Year 2011?

select concat_ws(' ',clients.first_name,clients.last_name) as 'client',count(*) as 'number_of_leads',MonthName(registered_datetime)
from lead_gen_business.leads
join lead_gen_business.sites on leads.site_id = sites.site_id
join lead_gen_business.clients on sites.client_id = clients.client_id
where leads.registered_datetime between '2011-01-1' and '2011-06-30'
group by month(registered_datetime),clients.client_id;

-- 8. What query would you run to get a list of client names and the total # of leads we've generated for each of our clients' sites between January 1, 2011 to December 31, 2011? Order this query by client id.  
-- 		Come up with a second query that shows all the clients, the site name(s), and the total number of leads generated from each site for all time.

-- a 
select concat_ws(' ',clients.first_name,clients.last_name) as 'client',sites.domain_name as 'website',count(*) as 'number_of_leads'
from lead_gen_business.leads
join lead_gen_business.sites on leads.site_id = sites.site_id
join lead_gen_business.clients on sites.client_id = clients.client_id
where leads.registered_datetime between '2011-01-1' and '2011-12-31'
group by sites.domain_name
order by clients.client_id asc;

-- b

select concat_ws(' ',clients.first_name,clients.last_name) as 'client',sites.domain_name as 'website',count(*) as 'number_of_leads'
from lead_gen_business.clients
left join lead_gen_business.sites on clients.client_id = sites.client_id
left join lead_gen_business.leads on leads.site_id = sites.site_id
group by clients.client_id,sites.site_id;

-- 9. Write a single query that retrieves total revenue collected from each client for each month of the year. Order it by client id. 
-- First try this with integer month, second with month name.  A SELECT subquery will be needed for the second challenge.  Look at this for a hint.
-- a 
select concat_ws(' ',clients.first_name,clients.last_name),sum(amount) as 'total_revenue',DATE_FORMAT(charged_datetime,'%m') as 'month_cahrged',DATE_FORMAT(charged_datetime,'%Y') as 'year_cahrged'
from lead_gen_business.clients
join lead_gen_business.billing on billing.client_id = clients.client_id
Group by billing.client_id,month(billing.charged_datetime),year(billing.charged_datetime)
order by clients.client_id,billing.charged_datetime asc;

-- b
select concat_ws(' ',clients.first_name,clients.last_name),sum(amount) as 'total_revenue',DATE_FORMAT(charged_datetime,'%M') as 'month_cahrged',DATE_FORMAT(charged_datetime,'%Y') as 'year_cahrged'
from lead_gen_business.clients
join lead_gen_business.billing on billing.client_id = clients.client_id
Group by billing.client_id,month(billing.charged_datetime),year(billing.charged_datetime)
order by clients.client_id,billing.charged_datetime asc;

-- 10. Write a single query that retrieves all the sites that each client owns. Group the results so that all of the sites for each client are displayed in a single field. 
-- It will become clearer when you add a new field called 'sites' that has all the sites that the client owns. (HINT: use GROUP_CONCAT)

select concat_ws(' ',clients.first_name,clients.last_name) as name,group_concat(domain_name SEPARATOR ' / ') as 'sites'
from lead_gen_business.sites
right join lead_gen_business.clients on sites.client_id = clients.client_id
group by clients.client_id;

