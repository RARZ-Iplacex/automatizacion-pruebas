pipeline {
agent any


stages {
    stage('Checkout') {
        steps {
            checkout scm
        }
    }

    stage('Build') {
        steps {
            bat 'mvn -B clean compile'
        }
    }

    stage('Unit Tests') {
        steps {
            bat 'mvn -B test'
        }
    }

    stage('BDD Tests') {
        steps {
            bat 'mvn -B test -Dtest=RunCucumberTest'
        }
    }

    stage('Reports') {
        steps {
            junit 'target/surefire-reports/*.xml'
            archiveArtifacts artifacts: 'target/cucumber-report.html,target/cucumber.json',
                allowEmptyArchive: true
        }
    }
}

post {
    success {
        echo 'Pipeline ejecutado correctamente.'
    }
    failure {
        echo 'El pipeline presentó errores.'
    }
}


}
