package com.jenkins.pipeline

class Pipeline {

    public void start(jenkins, node){

        jenkins.node(node){

            jenkins.checkout scm

            jenkins.stage('compile'){

                jenkins.sh '''
                    mvn compile
                '''
            }
        }
    }
}
