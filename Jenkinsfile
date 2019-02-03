pipeline {
    agent any

    stages {
        stage ('Compile Stage') {
            steps {
                sh 'mvn clean compile'
            }
        }

        stage ('Testing Stage') {
            steps {
                sh 'mvn test'
            }
        }

        stage ('Deployment Stage') {
            steps {
                sh 'mvn deploy'
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