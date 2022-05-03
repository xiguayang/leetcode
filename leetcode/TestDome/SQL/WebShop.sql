-- https://www.testdome.com/questions/sql/web-shop/69934
SELECT i.name, s.name
FROM items AS i JOIN sellers AS s
ON i.sellerId = s.id 
WHERE s.rating>4