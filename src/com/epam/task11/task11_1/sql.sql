ALTER TABLE task_11_1.tasks
add constraint FK_1
foreign key(Employee_number)
references task_11_1.employees (Employee_number)
on delete set null
on update set null;

ALTER TABLE task_11_1.employees
add constraint FK_2
foreign key(Department_number)
references task_11_1.departments (department_number)
on delete set null
on update set null;

alter table task_11_1.departments
add constraint PK_1
primary key(Department_number);

alter table task_11_1.employees
add constraint PK_1
primary key(Employee_number);

alter table task_11_1.tasks
add constraint PK_1
primary key(Task_number);