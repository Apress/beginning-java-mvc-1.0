  cd [GLASSFISH_INST]
  cd bin
  ./asadmin create-jdbc-connection-pool \
     --datasourceclassname \
       org.apache.derby.jdbc.ClientXADataSource \
     --restype javax.sql.XADataSource \
     --property \
       portNumber=1527:password=pw715:user=user0:
       serverName=localhost:databaseName=hello:
       securityMechanism=3 \ 
     HelloPool
			
  ./asadmin create-jdbc-resource \
    --connectionpoolid HelloPool jdbc/Hello
