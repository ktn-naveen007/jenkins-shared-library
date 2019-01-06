package com.jenkins.pipeline

class YamlTest {
    public void start(jenkins, node){

        jenkins.node(node){

            jenkins.checkout jenkins.scm

            def props = jenkins.readYaml(text: jenkins.libraryResource('sample.yaml'))

            def command = props?.compile?.command?:'compile'
            jenkins.stage('compile'){

                jenkins.sh """
                     mvn ${command}
                """
            }
        }
    }
}
