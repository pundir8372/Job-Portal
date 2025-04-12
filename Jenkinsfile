pipeline {
    agent { label 'node' }
    environment {
        SONAR_HOME = tool "Sonar"
    }
    stages {
        stage("Clone Code from Github") {
            steps {
                git url: "https://github.com/pundir8372/Job-Portal.git", branch: "main"
            }
        }
        stage("SonarQube Quality analysis") {
            steps {
                withSonarQubeEnv("Sonar") {
                    sh "${SONAR_HOME}/bin/sonar-scanner -Dsonar.projectName=jobPortal -Dsonar.projectKey=jobPortal"
                }
            }
        }
        stage("OWASP Dependency Check") {
            steps {
                dependencyCheck additionalArguments: '--scan ./', odcInstallation: "dc"
                dependencyCheckPublisher pattern: '**/dependency-check-report.xml'
            }
        }
        stage("Sonar Quality Gate Scan") {
            steps {
                timeout(time: 2, unit: "MINUTES") {
                    waitForQualityGate abortPipeline: false
                }
            }
        }
        stage("Trivy file System Scan") {
            steps {
                sh "trivy fs --format table -o trivy-fs-report.html ."
            }
        }
        stage("Deploy with Docker Compose") {
            steps {
                script {
                    sh "docker compose down && docker compose up -d"
                }
            }
        }
    }
}
