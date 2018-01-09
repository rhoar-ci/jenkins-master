FROM openshift/jenkins-2-centos7:latest
MAINTAINER Ladislav Thon <lthon@redhat.com>

COPY plugins.txt /opt/openshift/configuration/
RUN /usr/local/bin/install-plugins.sh /opt/openshift/configuration/plugins.txt

COPY plugins /opt/openshift/plugins

COPY scripts /opt/openshift/configuration/
