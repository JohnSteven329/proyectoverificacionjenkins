pipeline {

    agent any

    tools {
        maven 'maven-jenkins'
    }

    stages {

        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Build y pruebas') {
            steps {
                sh 'mvn clean verify'
            }

            post {
                always {
                    junit testResults: 'target/surefire-reports/*.xml',
                          allowEmptyResults: false
                }
            }
        }

        stage('Análisis con SonarQube') {
            steps {
                withSonarQubeEnv('SonarQube-Local') {
                    sh '''
                        mvn sonar:sonar \
                        -Dsonar.projectKey=proyecto-verificacion-jenkins \
                        -Dsonar.projectName=proyecto-verificacion-jenkins \
                        -Dsonar.coverage.jacoco.xmlReportPaths=target/site/jacoco/jacoco.xml
                    '''
                }
            }
        }

        stage('Validación del Quality Gate') {
            steps {
                timeout(time: 3, unit: 'MINUTES') {
                    waitForQualityGate abortPipeline: true
                }
            }
        }

    }

    post {

        success {
            echo 'Pipeline ejecutado correctamente.'
            echo 'El Quality Gate fue aprobado.'
        }

        failure {
            echo 'El pipeline falló.'
            echo 'Revisar pruebas, análisis de SonarQube o Quality Gate.'
        }

        always {
            echo 'Ejecución del pipeline finalizada.'
        }

    }

}