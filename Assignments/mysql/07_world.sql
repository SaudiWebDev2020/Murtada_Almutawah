-- 1. What query would you run to get all the countries that speak Slovene? 
--    Your query should return the name of the country, language and language percentage. 
--    Your query should arrange the result by language percentage in descending order. (1)

SELECT world.countries.name,world.languages.language,world.languages.percentage
FROM world.languages
JOIN world.countries
ON  world.languages.country_id = world.countries.id
where world.languages.language = 'Slovene'
order by world.languages.percentage desc;

-- 2. What query would you run to display the total number of cities for each country? 
-- 	  Your query should return the name of the country and the total number of cities. 
-- 	  Your query should arrange the result by the number of cities in descending order. (3)

SELECT world.countries.name,count(world.cities.id) as 'cities'
FROM world.cities
JOIN world.countries
ON  world.cities.country_id = world.countries.id
group by world.countries.id
order by count(world.cities.id) desc;

-- 3. What query would you run to get all the cities in Mexico with a population of greater than 500,000? 
-- 		Your query should arrange the result by population in descending order. (1)
select world.cities.name,world.cities.population,world.cities.country_id
from world.countries
join world.cities on world.cities.country_id = world.countries.id
where world.countries.name = 'Mexico'
and world.cities.population > 500000
order by world.cities.population desc;

-- 4. What query would you run to get all languages in each country with a percentage greater than 89%? 
-- 		Your query should arrange the result by percentage in descending order. (1)

SELECT world.countries.name,world.languages.language,world.languages.percentage
FROM world.countries
JOIN world.languages
ON  world.languages.country_id = world.countries.id
where world.languages.percentage > 89
order by world.languages.percentage desc;


-- 5. What query would you run to get all the countries with Surface Area below 501 and Population greater than 100,000? (2)

select world.countries.name,world.countries.surface_area,world.countries.population
from world.countries
where world.countries.surface_area<501
and world.countries.population > 100000;


-- 6. What query would you run to get countries with only Constitutional Monarchy with a capital greater than 200 and a life expectancy greater than 75 years? (1)

select name,government_form,capital,life_expectancy
from world.countries
where life_expectancy>75
and government_form='Constitutional Monarchy'
and capital>200;


-- 7. What query would you run to get all the cities of Argentina inside the Buenos Aires district and have the population greater than 500, 000? 
-- 		The query should return the Country Name, City Name, District and Population. (2)

select countries.name as 'country_name',cities.name as 'city_name',cities.district,cities.population
from world.cities
join world.countries on countries.id = cities.country_id
where countries.name = 'Argentina'
AND cities.district = 'Buenos Aires'
AND cities.population > 500000;


-- 8. What query would you run to summarize the number of countries in each region? 
-- 		The query should display the name of the region and the number of countries. 
-- 		Also, the query should arrange the result by the number of countries in descending order. (2)

select countries.region, count(countries.region) as 'countries'
from world.countries
group by countries.region
order by count(countries.region) desc;
