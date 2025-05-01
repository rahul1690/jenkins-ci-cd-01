pipeline{
    agent any

    tools{
        // This below name is from manage jenkins/Tools tool id
        maven "maven"
    }

    stages{
        stage("SCM checkout"){
            steps{
                checkout scmGit(branches: [[name: '*/main']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/rahul1690/jenkins-ci-cd-01.git']])
            }
        }

        stage("Build process"){
            steps{
                script{
                    sh 'mvn clean install'
                }
            }
        }

        stage("Deploy to container"){
            steps{
                deploy adapters: [tomcat9(credentialsId: 'tomcat-pwd', path: '', url: 'http://localhost:9090')], contextPath: 'jenkinsCiCd', war: '**/*.war'
            }
        }

    }

    post{
        always{
            emailext attachLog: true,
            body: '''<html>
<body>
<p>Build Status : ${BUILD_STATUS}</p>
<p>Build Number : ${BUILD_NUMBER}</p>
<p>Check the <a href=${BUILD_URL}>console output</a></p>
</body>
</html>''',
mimeType: 'text/html', replyTo: 'rahb78205@gmail.com', subject: 'Pipeline Status: ${BUILD_NUMBER}', to: 'rahb78205@gmail.com'
        }
    }

}
//Steps
//SCM Checkout
//Build process
//Deploy to Container
//Notification