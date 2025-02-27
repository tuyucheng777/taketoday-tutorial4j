DROP SCHEMA PUBLIC CASCADE;

create table AUDIT_LOG
(
   ID           INTEGER IDENTITY PRIMARY KEY,
   FROM_ACCOUNT varchar(8),
   TO_ACCOUNT   varchar(8),
   AMOUNT       numeric(28, 10)
);