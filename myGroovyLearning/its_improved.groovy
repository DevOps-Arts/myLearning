properties([pipelineTriggers([githubPush()])])
 
pipeline {

    agent any

    stage("Gitwebhook"){
        steps {
            checkout([
                $class: 'GitSCM'
                branches: [[name: 'master']],
                userRemoteConfigs: [[
                    url: 'https://github.com/DevOps-Arts/practice2'
                ]]
            ])
        }
    stage("Do Deploy") {
        steps {
            sh echo "Runnning Deployment Code"
            sh mkdir ~/workspace
            sh cd ~/workspace
            sh git clone https://github.com/DevOps-Arts/practice2
            sh cd practice2
            sh python3 -m http.server 6767 &
        }

    }
    }
}