import jenkins.model.Jenkins
import org.codefirst.SimpleThemeDecorator

def descriptor = Jenkins.instance.getDescriptorByType(SimpleThemeDecorator.class)
descriptor.cssUrl = '/userContent/neo-light.css'
descriptor.save()
