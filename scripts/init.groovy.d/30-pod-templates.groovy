import hudson.model.Node
import jenkins.model.Jenkins
import org.csanchez.jenkins.plugins.kubernetes.ContainerTemplate
import org.csanchez.jenkins.plugins.kubernetes.KubernetesCloud
import org.csanchez.jenkins.plugins.kubernetes.PodTemplate

def kube = Jenkins.instance.clouds.getByName("openshift") as KubernetesCloud

kube.templates = [
        new PodTemplate().with {
            it.name = "rourka-maven"
            it.label = "rourka-maven"
            it.nodeUsageMode = Node.Mode.NORMAL
            it.serviceAccount = "jenkins"
            it.containers = [
                    new ContainerTemplate("jnlp", "ladicek/rourka-jenkins-slave-maven").with {
                        it.alwaysPullImage = true
                        it.workingDir = "/tmp"
                        it.command = ""
                        it.args = '${computer.jnlpmac} ${computer.name}'
                        return it
                    }
            ]
            return it
        }
]
