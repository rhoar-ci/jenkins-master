import jenkins.model.JenkinsLocationConfiguration

// some plugins (e.g. the GitHub plugin) need to know the Jenkins root URL early
JenkinsLocationConfiguration.get().url = "oc get route -o jsonpath=https://{.spec.host}/ jenkins".execute().text
