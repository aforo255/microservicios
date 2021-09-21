--Registro de estados de una factura
INSERT INTO invoice_state(status_id,description) VALUES (1,'Pagado');
INSERT INTO invoice_state(status_id,description) VALUES (2,'Pendiente de Pago');
INSERT INTO invoice_state(status_id,description) VALUES (3,'Reembolso');


--Registro de Clientes
INSERT INTO customer(customer_id,full_name) VALUES(1,'Ronaldo Sai');
INSERT INTO customer(customer_id,full_name) VALUES(2,'Lionel Messi');
INSERT INTO customer(customer_id,full_name) VALUES(3,'Cristiano Ronaldo');


--Registro de Facturas
INSERT INTO invoice(amount,status_id,cutomer_id) VALUES (1000,1,1);
INSERT INTO invoice(amount,status_id,cutomer_id) VALUES (2000,2,2);
INSERT INTO invoice(amount,status_id,cutomer_id) VALUES (3000,2,2);
INSERT INTO invoice(amount,status_id,cutomer_id) VALUES (4000,2,3);


