pipeline {
    agent any

    stages {
        stage ('Build Stage') {
            steps {
                sh 'mvn clean verify checkstyle:checkstyle pmd:pmd pmd:cpd-check findbugs:findbugs spotbugs:spotbugs jacoco:prepare-agent test'
            }
        }

        stage ('Testing Stage') {
            steps {
                sh 'mvn test jacoco:report'
            }
        }
    }
	post {
        always {
			junit testResults: '**/target/*-reports/TEST-*.xml'
			recordIssues enabledForFailure: true, tools: [mavenConsole(), java(), javaDoc()]
            recordIssues enabledForFailure: true, tool: checkStyle(pattern: 'target/checkstyle-result.xml'), sourceCodeEncoding: 'UTF-8'
			recordIssues enabledForFailure: true, tool: cpd(pattern: 'target/cpd.xml'), sourceCodeEncoding: 'UTF-8'
			recordIssues enabledForFailure: true, tool: pmdParser(pattern: 'target/pmd.xml'), sourceCodeEncoding: 'UTF-8'
            recordIssues enabledForFailure: true, tool: spotBugs(pattern: 'target/spotbugsXml.xml'), sourceCodeEncoding: 'UTF-8'
			jacoco()
        }
    }
}