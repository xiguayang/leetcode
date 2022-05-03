

select c.name,
    (CASE 
        WHEN COUNT(t.id) IS NOT NULL THEN COUNT(t.id)
        ELSE 0 
    END) AS numOfTransaction
from customers c LEFT join transactions t
on c.id = t.customerId
group by c.id


