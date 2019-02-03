pipeline {
    agent any

    stages {
        stage ('Build Stage') {
            steps {
                sh 'mvn clean verify checkstyle:checkstyle pmd:pmd pmd:cpd-check findbugs:findbugs spotbugs:spotbugs'
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
			recordIssues enabledForFailure: true, aggregatingResults: true, tools: [mavenConsole(), java(), javaDoc()]
            recordIssues enabledForFailure: true, aggregatingResults: true, tool: checkStyle(pattern: 'target/checkstyle.xml'), sourceCodeEncoding: 'UTF-8'
			recordIssues enabledForFailure: true, aggregatingResults: true, tool: cpd(pattern: 'target/cpd.xml'), sourceCodeEncoding: 'UTF-8'
			recordIssues enabledForFailure: true, aggregatingResults: true, tool: pmdParser(pattern: 'target/pmd.xml'), sourceCodeEncoding: 'UTF-8'
            recordIssues enabledForFailure: true, aggregatingResults: true, tool: spotBugs(pattern: 'target/spotbugsXml.xml'), sourceCodeEncoding: 'UTF-8'
        }
    }
}