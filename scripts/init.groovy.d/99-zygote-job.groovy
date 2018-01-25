import hudson.model.FreeStyleProject
import hudson.model.labels.LabelAtom
import hudson.plugins.git.GitSCM
import hudson.tasks.Shell
import jenkins.model.Jenkins

if (Jenkins.instance.items.size() == 0) {
    def job = Jenkins.instance.createProject(FreeStyleProject.class, 'zygote')
    job.assignedLabel = new LabelAtom('jjb')
    job.scm = new GitSCM('https://github.com/rhoar-ci/jenkins-jobs')
    job.buildersList.add(new Shell('jjb update jobs && jjb delete zygote'))
}
