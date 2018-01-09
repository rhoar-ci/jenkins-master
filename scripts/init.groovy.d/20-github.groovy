import org.jenkinsci.plugins.github.GitHubPlugin
import org.jenkinsci.plugins.github.config.GitHubServerConfig

def data = [
        'credentialsId': 'rhoar-bot-github-token',
        'manageHooks'  : true,
        'githubUrl'    : 'https://api.github.com',
]

def github = new GitHubServerConfig(data.credentialsId)
github.manageHooks = data.manageHooks
github.apiUrl = data.githubUrl

GitHubPlugin.configuration().configs << github
