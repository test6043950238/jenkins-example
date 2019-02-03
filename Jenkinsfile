pipeline {
    agent any

    stages {
        stage ('Build Stage') {
            steps {
                sh 'mvn clean verify checkstyle:checkstyle pmd:pmd findbugs:findbugs'
            }
        }

        stage ('Testing Stage') {
            steps {
                sh 'mvn test'
            }
        }
    }
	post {
        always {
			junit testResults: '**/target/*-reports/TEST-*.xml'
            recordIssues enabledForFailure: true, tool: checkStyle(pattern: 'target/checkstyle.xml'), sourceCodeEncoding: 'UTF-8'
			recordIssues enabledForFailure: true, tool: cpd(pattern: 'target/cpd.xml'), sourceCodeEncoding: 'UTF-8'
			recordIssues enabledForFailure: true, tool: pmdParser(pattern: 'target/pmd.xml'), sourceCodeEncoding: 'UTF-8'
            recordIssues enabledForFailure: true, tool: spotBugs(pattern: 'target/spotbugsXml.xml'), sourceCodeEncoding: 'UTF-8'
        }
    }
}