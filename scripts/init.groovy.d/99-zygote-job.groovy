import hudson.model.FreeStyleProject
import hudson.model.labels.LabelAtom
import hudson.plugins.git.GitSCM
import hudson.tasks.Shell
import jenkins.model.Jenkins

def job = Jenkins.instance.createProject(FreeStyleProject.class, 'zygote')
job.assignedLabel = new LabelAtom('rourka-jjb')
job.scm = new GitSCM('https://github.com/Ladicek/rourka')
job.buildersList.add(new Shell('jjb update jenkins-jobs && jjb delete zygote'))
