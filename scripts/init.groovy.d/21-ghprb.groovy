import jenkins.model.Jenkins
import org.jenkinsci.plugins.ghprb.GhprbGitHubAuth
import org.jenkinsci.plugins.ghprb.GhprbTrigger

def data = [
        'id'           : 'rhoar-bot-github-account',
        'description'  : 'The rhoar-bot GitHub account',
        'credentialsId': 'rhoar-bot-github-token',
        'githubUrl'    : 'https://api.github.com',
        'jenkinsUrl'   : null,
        'sharedSecret' : null,
]

def descriptor = Jenkins.instance.getDescriptorByType(GhprbTrigger.DescriptorImpl.class)

descriptor.githubAuth = [
        new GhprbGitHubAuth(data.githubUrl, data.jenkinsUrl, data.credentialsId, data.description, data.id, data.sharedSecret)
]

descriptor.save()
