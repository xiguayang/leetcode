182. Duplicate Emails [E]
Write a SQL query to find all duplicate emails in a table named Person.

+----+---------+
| Id | Email   |
+----+---------+
| 1  | a@b.com |
| 2  | c@d.com |
| 3  | a@b.com |
+----+---------+
For example, your query should return the following for the above table:

+---------+
| Email   |
+---------+
| a@b.com |
+---------+
Note: All emails are in lowercase.


SELECT Email FROM(
    SELECT Email, COUNT(Email) AS num
    FROM Person
    GROUP BY Email
)as a
WHERE num >1;


SELECT Email From Person
GROUP BY Email
Having Count(*)>1;


SELECT DISTINCT a.Email
FROM Person a JOIN Person b
ON (a.Email = b.Email)
WHERE a.Id <> b.Id
