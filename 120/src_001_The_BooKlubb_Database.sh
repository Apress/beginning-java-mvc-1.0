cd [GLASSFISH_INST]
cd javadb/bin
# start the DB client
./ij
ij> connect 'jdbc:derby://localhost:1527/booklubb;
    create=true;user=bk';
ij> call SYSCS_UTIL.SYSCS_CREATE_USER('bk','pw715');
