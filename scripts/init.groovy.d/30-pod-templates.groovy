import hudson.model.Node
import jenkins.model.Jenkins
import org.csanchez.jenkins.plugins.kubernetes.ContainerTemplate
import org.csanchez.jenkins.plugins.kubernetes.KubernetesCloud
import org.csanchez.jenkins.plugins.kubernetes.PodTemplate

def podTemplate = { name, imageStream, idleMinutes ->
    def image = "oc get imagestream $imageStream -o jsonpath={.status.dockerImageRepository}".execute().text

    return new PodTemplate().with {
        it.name = name
        it.label = name
        it.nodeUsageMode = Node.Mode.NORMAL
        it.serviceAccount = 'jenkins'
        it.idleMinutes = idleMinutes
        it.containers = [
                new ContainerTemplate('jnlp', image).with {
                    it.alwaysPullImage = true
                    it.workingDir = '/tmp'
                    it.command = ''
                    it.args = '${computer.jnlpmac} ${computer.name}'
                    return it
                }
        ]
        return it
    }
}

def kube = Jenkins.instance.clouds.getByName('openshift') as KubernetesCloud

kube.templates = [
        podTemplate('rourka-maven', 'jenkins-slave-maven', 15),
        podTemplate('rourka-jjb', 'jenkins-slave-jjb', 5),
]
