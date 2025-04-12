def call(String reportFile = "table-report.html") {
    script {
        sh "trivy fs --format table -o ${reportFile} ."
        archiveArtifacts artifacts: reportFile, fingerprint: true
    }
}
