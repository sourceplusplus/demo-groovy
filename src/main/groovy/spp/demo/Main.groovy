package spp.demo

import spp.demo.command.TailLogs

class Main {

    private static TailLogs tailLogs = new TailLogs()

    static void main(String[] args) throws Exception {
        while (true) {
            executeDemos()
            Thread.sleep(1000)
        }
    }

    static void executeDemos() {
        triggerTailLogs()
    }

    static void triggerTailLogs() {
        tailLogs.tailClassLogs()
        tailLogs.tailMethodLogs()
        tailLogs.tailStatementLogs()
    }
}
