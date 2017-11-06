"# test-transaction" 
1. Have local instance of MYSQL 5.7

Create a Database - SQL
CREATE DATABASE `tranpoc` /*!40100 DEFAULT CHARACTER SET utf8 */;


Create a table - SQL
CREATE TABLE `tran_action` (
  `Tran_From` varchar(50) NOT NULL,
  `Tran_To` varchar(55) DEFAULT NULL,
  `Tran_Amount` int(11) DEFAULT NULL,
  `Tran_When` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`Tran_From`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


2. Install Active MQ - apache-activemq-5.15.2

Create 2 Queue - inboundPay and inboundPayArchieve	

3. Run JBOSS in STS

4. Import test-transaction as a Maven Project

5. Build Deploy - and run 

http://localhost:8080/test-transaction/pay

Reference
Acrive MQ - http://127.0.0.1:8161/admin/queues.jsp

Rest URL - http://localhost:8080/test-rest/account/from/Pete/to/Matt/amount/100/when/now
