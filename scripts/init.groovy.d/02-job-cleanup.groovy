import jenkins.model.Jenkins

Jenkins.instance.items.findAll { it.name == 'OpenShift Sample' }.each { it.delete() }
