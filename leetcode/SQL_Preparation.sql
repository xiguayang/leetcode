-- FUNCTIONS 
-- select ... from
-- where; having
-- Count/Sum/Avg/Max/Min(Aggregation)
-- Group by 
-- Case when
-- Join
-- Window Function(rank, 累计求和)
-- Date, %like%, ...


-- Framework #1 #2
--#1 Group by
SELECT 
    e.instructor_id,
    c.name course_name
    COUNT/SUM/MAX/MIN/AVG(
        CASE
            WHEN NOT e.grade= 'f' THEN 1
            ELSE 0
        END
    )/ COUNT(1) pass_rate
FROM table_1
WHERE
GROUP BY...
(having ...)
ORDER BY columnname DESC/ASC

-- #Join
-- select
--     a.c1, a.c2, ...b.d1, b.d2...
-- from 
--     table_1 a (LEFT/FULL OUTER) join table_2 b
-- on 
--     a.xx= b.xx and a.xx between b.xxx and b.xxx+3
-- where...

-- default is inner join

-- #Self join questions
-- leetcode 180 https://leetcode.com/problems/consecutive-numbers/
-- # 找出表中连续出现三次的数字 

SELECT
    distinct a.num ConsecutiveNums
FROM 
    logs a, logs b, logs c
WHERE
    a.id + 1 = b.id AND a.id +2 =c.id
    AND a.num = b.num AND b.num = c.num    
-- #   logs a.  logs b.   logs c
-- #   id.  num. id. num. id  num
-- #   1.   1.   2.   1.  3.   1
-- #   2.   1.   3.   1.  4    2
-- #   3.   1.   4.   2   5.   1
-- #   4.   2.   5.   1.  6.   2
-- #   5.   1.   6.   2.  7.   2

-- leetcode 181 https://leetcode.com/problems/employees-earning-more-than-their-managers/
-- # find the employees who earn more than their managers.
SELECT a.name Employee
FROM Employee a, Employee b
WHERE a.managerId = b.id AND a.salary>b.salary


-- #CASE WHEN
CASE
    when condition1 then result1
    when condition2 then result2
    when conditionN then resultN
    else result
END
-- Sample questions
-- 1. name height, create a new column groun height_group
select player_name,
        height,
        Case
            when height >74 then 'over 74'
            when height >72 AND height <=74 then '73-74'
            when height >70 AND height <=72 then '71-72'
            else 'under 71' 
        End As height_group
from tablename

--2. Type of Triangle 
--https://www.hackerrank.com/challenges/what-type-of-triangle/problem?h_r=internal-search
-- Equilateral: It's a triangle with  sides of equal length.
-- Isosceles: It's a triangle with  sides of equal length.
-- Scalene: It's a triangle with  sides of differing lengths.
-- Not A Triangle: The given values of A, B, and C don't form a triangle.
select 
    (Case
        when a+b<=c or a+c<=b or b+c<=a then 'Not A Triangle'
        when a = b and b = c then 'Equilateral'
        when a = b or b=c or a=c then 'Isosceles'
        else 'Scalene'
    End) as triangleType
from TRIANGLES

--3. Market product on sale or not  ---> Pivote table(for each market, show all the product on sale or not status)
-- market_id  product_type  is_onSale
--   1          a            Y
--   1          b            N
--   1          c            y
--  --->
--pivot table
-- market_id  a_onsale  b_onsale   c_onsale
--  1           y         n         y
select market_id,
    Case
        when product_type = 'a' then is_onSale 
        else null
    end as a_onsale
    Case
        when product_type = 'b' then is_onSale 
        else null
    end as b_onsale
    Case
        when product_type = 'c' then is_onSale 
        else null
    end as c_onsale
from table_1
order by market_id;
-- Using Group by to reduce redunt, for last query, each row is a market only with on product, other product is null
select market_id,
    MAX(Case when product_type = 'a' then is_onSale else null end) as a_onsale
    MAX(Case
        when product_type = 'b' then is_onSale 
        else null
    end) as b_onsale
    MAX(Case
        when product_type = 'c' then is_onSale 
        else null
    end) as c_onsale
from table_1
GROUP BY market_id
order by market_id;



-- # Group By 
-- 将数据根据某些特定列进行分组，再进行组内运算， 两种用法
-- ID type size
-- 1  a     small
-- 1  a     large
-- 2  b     medium
-- 3  a     medium
-- 3  c     small

-- 1. same as distinct 
select distinct id, type from table_1;

select id, type from table_1
group by id, type;

-- id  type
-- 1   a
-- 2   b
-- 3   a
-- 3   c

-- 2. with aggregate function
select id, type, COUNT(*) 
from table_1
group by id, type;
-- id  type   count
-- 1   a       2
-- 2   b       1
-- 3   a       1
-- 3   c       1



-- The order of sql execute
-- filter all the rows 
1. FROM: find the data source
2. WHERE: filter the rows by columns conditions 
    * (LEFT) JOIN execute before where, so when using JOIN, conside the condition in JOIN or WHERE
-- calculation
3. GROUP BY
4. aggregate functions(COUNT, SUM, AVG, MIN, MAX)
5. HAVING: filter the results of aggrate functions
-- show what you need
6. SELECT
7. ORDER BY 

-- 链条逻辑
--184. Department Highest Salary



