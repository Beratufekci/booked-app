CREATE KEYSPACE booked
    WITH replication = {'class':'SimpleStrategy', 'replication_factor' : 3};

use booked;

CREATE TABLE emp(
                    emp_id int PRIMARY KEY,
                    emp_name text,
                    emp_city text,
                    emp_sal varint,
                    emp_phone varint
);

select * from booked.customer

INSERT INTO customer (id,mail,name,surname)
VALUES(
          '1',
          'test@hotmail.com',
          'TEST',
          'dede');