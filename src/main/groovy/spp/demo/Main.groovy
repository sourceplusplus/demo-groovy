package spp.demo

import io.micronaut.runtime.Micronaut
import spp.demo.command.AddBreakpoint
import spp.demo.command.AddLog
import spp.demo.command.TailLogs

import java.util.concurrent.Executor
import java.util.concurrent.Executors

class Main {

    private static final Executor executor = Executors.newCachedThreadPool()

    static void main(String[] args) throws Exception {
        Micronaut.run(Main.class, args)

        while (true) {
            executeDemos()
            Thread.sleep(1000)
        }
    }

    static void executeDemos() {
        triggerAddBreakpoint()
        triggerAddLog()
        triggerTailLogs()
        triggerEndpoints()
    }

    static void triggerAddBreakpoint() {
        AddBreakpoint addBreakpoint = new AddBreakpoint()
        addBreakpoint.simpleBreakpoint()
        addBreakpoint.breakpointWithRedactedData()
    }

    static void triggerAddLog() {
        AddLog addLog = new AddLog()
        addLog.simpleLog()
        addLog.simpleLogWithTailLogs()
    }

    static void triggerTailLogs() {
        TailLogs tailLogs = new TailLogs()
        tailLogs.tailClassLogs()
        tailLogs.tailMethodLogs()
        tailLogs.tailStatementLogs()
    }

    static void triggerEndpoints() {
        //view activity command
        callEndpoint("/command/view-activity")

        //view traces command
        callEndpoint("/command/view-traces")

        //failing endpoint indicator
        callEndpoint("/indicator/fail-100-percent")
        callEndpoint("/indicator/fail-50-percent")

        //slow endpoint indicator
        callEndpoint("/indicator/slow-2000ms")
        callEndpoint("/indicator/slow-1000ms")

        //high load endpoint indicator
        for (int i = 0; i < 6; i++) {
            callEndpoint("/indicator/high-load-six-per-second")
        }
        for (int i = 0; i < 3; i++) {
            callEndpoint("/indicator/high-load-three-per-second")
        }
    }

    private static void callEndpoint(String endpoint) {
        executor.execute(() -> {
            try {
                new URL("http://localhost:8080" + endpoint).openStream().close()
            } catch (Exception ignore) {
            }
        })
    }
}
