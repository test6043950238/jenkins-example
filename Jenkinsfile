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
            recordIssues enabledForFailure: true, tool: checkStyle()
            recordIssues enabledForFailure: true, tool: spotBugs()
        }
    }
}