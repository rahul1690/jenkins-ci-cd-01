pipeline{
    agent any

    tools{
        // This below name is from manage jenkins/Tools tool id
        maven "maven"
    }

    environment{
        APP_NAME : "spring-docker-cicd"
        RELEASE_NO : "1.0.0"
        DOCKER_USER : "rahulbhoje09"
        IMAGE_NAME : "${DOCKER_USER}/${APP_NAME}"
        IMAGE_TAG : "${RELEASE_NO}-${BUILD_NUMBER}"
    }

    stages{
        stage("SCM checkout"){
            steps{
                checkout scmGit(branches: [[name: '*/main']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/rahul1690/jenkins-ci-cd-01.git']])
            }
        }

        stage("Build process"){
            steps{
                bat 'mvn clean install'
            }
        }

//         stage("Deploy to container"){
//             steps{
//                 deploy adapters: [tomcat9(credentialsId: 'tomcat-pwd', path: '', url: 'http://localhost:9090')], contextPath: 'jenkinsCiCd', war: '**/*.war'
//             }
//         }
       stage("Build Image"){
            steps{
                bat 'docker build %IMAGE_NAME%/%IMAGE_TAG%'
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