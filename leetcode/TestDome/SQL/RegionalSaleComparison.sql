--https://www.testdome.com/questions/sql/regional-sales-comparison/76445

-- the total sales of per region

WITH sales_avg AS(
    SELECT r.name AS regionName,
    (CASE 
        WHEN SUM(s.amount) IS NOT NULL THEN SUM(s.amount) / COUNT(DISTINCT e.id) 
        ELSE 0 
    END) AS averageSales
    FROM regions AS r
    LEFT JOIN states AS st ON r.id = st.regionId
    LEFT JOIN employees AS e ON st.id = e.stateId
    LEFT JOIN sales AS s ON e.id = s.employeeId
    GROUP BY r.name)
select regionName, averageSales, (select MAX(averageSales) from sales_avg)-averageSales as difference
from sales_avg
group by 1

