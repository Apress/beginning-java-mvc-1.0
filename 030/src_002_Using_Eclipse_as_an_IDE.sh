cd /opt
groupadd eclipse
chgrp -R eclipse eclipse-2019-09
chmod -R g+w eclipse-2019-09         
USER=...  # enter your username here
usermod -a -G eclipse $USER
