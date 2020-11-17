  cd [GLASSFISH_INST]
  cd bin
  ./asadmin create-jdbc-connection-pool \
     --datasourceclassname \
       org.apache.derby.jdbc.ClientXADataSource \
     --restype javax.sql.XADataSource \
     --property \
       portNumber=1527:password=pw715:user=bk:
       serverName=localhost:databaseName=booklubb:
       securityMechanism=3 \ 
     BooKlubbPool
			
  ./asadmin create-jdbc-resource \
    --connectionpoolid BooKlubbPool jdbc/BooKlubb
