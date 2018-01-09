import hudson.markup.RawHtmlMarkupFormatter
import jenkins.model.Jenkins

Jenkins.instance.setMarkupFormatter(new RawHtmlMarkupFormatter(false))
