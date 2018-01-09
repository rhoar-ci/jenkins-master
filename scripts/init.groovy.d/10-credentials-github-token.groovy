import com.cloudbees.plugins.credentials.CredentialsScope
import com.cloudbees.plugins.credentials.SystemCredentialsProvider
import com.cloudbees.plugins.credentials.domains.Domain
import hudson.util.Secret
import org.jenkinsci.plugins.plaincredentials.impl.StringCredentialsImpl

def data = [
        'id'         : 'rhoar-bot-github-token',
        'description': 'Access token for the rhoar-bot GitHub account',
        'token'      : new File("/my-secrets/github/token").text.trim(),
]

def credentials = new StringCredentialsImpl(CredentialsScope.GLOBAL, data.id, data.description, Secret.fromString(data.token))

def credentialsStore = SystemCredentialsProvider.getInstance().getStore()
credentialsStore.addCredentials(Domain.global(), credentials)
