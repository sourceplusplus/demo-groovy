package spp.demo

import spp.demo.command.AddBreakpoint
import spp.demo.command.TailLogs

class Main {

    private static AddBreakpoint addBreakpoint = new AddBreakpoint()
    private static TailLogs tailLogs = new TailLogs()

    static void main(String[] args) throws Exception {
        while (true) {
            executeDemos()
            Thread.sleep(1000)
        }
    }

    static void executeDemos() {
        triggerAddBreakpoint()
        triggerTailLogs()
    }


    static void triggerAddBreakpoint() {
        addBreakpoint.simpleBreakpoint()
    }

    static void triggerTailLogs() {
        tailLogs.tailClassLogs()
        tailLogs.tailMethodLogs()
        tailLogs.tailStatementLogs()
    }
}
