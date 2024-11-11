pipeline {
    agent any
    
    environment {
        SONAR_PROJECT_KEY = 'elmarrhoubchaimae_scolarite'
        SONAR_ORGANIZATION = 'elmarrhoubchaimae'
        SONAR_TOKEN = credentials('SonarToken')
    }

    stages {
        stage('Checkout') {
            steps {
                git url: 'https://github.com/elmarrhoubchaimae/scolarite.git'
            }
        }

        stage('Build') {
            steps {
                bat 'mvn clean install'
            }
        }

        stage('SonarQube Analysis') {
            steps {
                withSonarQubeEnv('SonarCloud') {
                    bat """
                    mvn sonar:sonar ^
                      -Dsonar.projectKey=%SONAR_PROJECT_KEY% ^
                      -Dsonar.organization=%SONAR_ORGANIZATION% ^
                      -Dsonar.host.url=https://sonarcloud.io ^
                      -Dsonar.login=%SONAR_TOKEN%
                    """
                }
            }
        }

        stage('Quality Gate') {
            steps {
                script {
                    timeout(time: 5, unit: 'MINUTES') {
                        waitForQualityGate abortPipeline: true
                    }
                }
            }
        }
    }
}
