class PipeLine1 {

    static public def int chk(int x = 0) {
    if (x == 1){
        return 1
    }
    }


    static public def int webhook() {
        sleep(10000)
        println("Git WebHook Detected !")
        println("This must be built")
        int req
        req = chk(1)
        if (req == 1) {
            println("Building wait till finished")
            Build()
        }
    
    
    }
    
    static def int Build() {
        sleep(3000)
        println("Pipe line built successfully without any errors")
        int res
        res = chk(1)
        if (res == 1){
            println("The program is going to be deployed cause it is built with no errors")
            deploy()
        }
    
    }
    
    static def deploy() {
        println("App is deployed after the Build was good")

        
    }
    
    static void main(String[] args) {
        println("Waiting for WebHook from github")
        webhook()
    }
}