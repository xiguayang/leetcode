
620. Not Boring Movies
Please write a SQL query to output movies
with an odd numbered ID and a description that is not 'boring'.
Order the result by rating.


For example, table cinema:

+---------+-----------+--------------+-----------+
|   id    | movie     |  description |  rating   |
+---------+-----------+--------------+-----------+
|   1     | War       |   great 3D   |   8.9     |
|   2     | Science   |   fiction    |   8.5     |
|   3     | irish     |   boring     |   6.2     |
|   4     | Ice song  |   Fantacy    |   8.6     |
|   5     | House card|   Interesting|   9.1     |
+---------+-----------+--------------+-----------+

# Write your MySQL query statement below
select * from cinema
where description not in ("boring")
and mod(id,2)=1
order by rating DESC;
