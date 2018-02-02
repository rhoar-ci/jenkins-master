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

// some of these variables are not initialized to a value
// some other are, but the source code says it's only meant for testing and shouldn't be considered a default value
// so here we set all the relevant values explicitly
descriptor.manageWebhooks = true
descriptor.whitelistPhrase = '.*add\\W+to\\W+whitelist.*'
descriptor.okToTestPhrase = '.*ok\\W+to\\W+test.*'
descriptor.retestPhrase = '.*test\\W+this\\W+please.*'
descriptor.skipBuildPhrase = '.*\\[skip\\W+ci\\].*'
descriptor.requestForTestingPhrase = 'Can one of the admins verify this patch?'
descriptor.cron = 'H/5 * * * *'
descriptor.githubAuth = [
        new GhprbGitHubAuth(data.githubUrl, data.jenkinsUrl, data.credentialsId, data.description, data.id, data.sharedSecret)
]

descriptor.save()
