def call(){
  dependencyCheck additionalArguments: '--scan ./', odcInstallation: 'dc'
  dependencyCheckPublisher pattern: '**/dependency-check-report.xml'
}
