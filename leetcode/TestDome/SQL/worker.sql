-- https://www.testdome.com/questions/sql/workers/69921
-- The following data definition defines an organization's employee hierarchy.

-- An employee is a manager if any other employee has their managerId set to this employee's id. That means John is a manager if at least one other employee has their managerId set to John's id.

-- TABLE employees
--   id INTEGER NOT NULL PRIMARY KEY
--   managerId INTEGER
--   name VARCHAR(30) NOT NULL
--   FOREIGN KEY (managerId) REFERENCES employees(id)
-- Write a query that selects only the names of employees who are not managers.


-- Write only the SQL statement that solves the problem and nothing else
select name 
from employees 
where id not in(
    select e1.id
    from employees e1 join employees e2
    on e1.id= e2.managerId
)

select name 
from employees 
where id not in(
    select managerId
    from employees 
    where managerId is not null
)