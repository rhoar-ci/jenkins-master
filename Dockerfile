FROM openshift/jenkins-2-centos7:latest
MAINTAINER Ladislav Thon <lthon@redhat.com>

ADD ./plugins.txt /opt/openshift/configuration/plugins.txt
RUN /usr/local/bin/install-plugins.sh /opt/openshift/configuration/plugins.txt

