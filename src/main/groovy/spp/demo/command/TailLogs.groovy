package spp.demo.command

import org.slf4j.Logger
import org.slf4j.LoggerFactory

/**
 * This class is used to demonstrate the `Tail Logs` command.
 * <p>
 * <b>Usage:</b>
 * Open the Source++ Command Palette with `Ctrl+Shift+S` and search for `Tail Logs`.
 * </p>
 * <p>
 * <b>Command source code:</b>
 * <a href="https://github.com/sourceplusplus/jetbrains-commander/blob/master/resources/.spp/plugins/tail-logs/plugin.kts">Tail Logs</a>
 * </p>
 */
class TailLogs {

    private static final Logger log = LoggerFactory.getLogger(TailLogs.class)

    /**
     * Execute the `Tail Logs` command with your cursor on line 25 to see logs for this whole class.
     */
    void tailClassLogs() {
        Math.random()
    }

    /**
     * Execute the `Tail Logs` command with your cursor on line 32 to see logs for this whole method.
     */
    void tailMethodLogs() {
        var randomNumber1 = Math.random()
        var randomNumber2 = Math.random()
        log.info("Tailing method logs. First random number: {}", randomNumber1)
        log.info("Tailing method logs. Second random number: {}", randomNumber2)
    }

    /**
     * Execute the `Tail Logs` command with your cursor on line 43 to see logs for that specific statement.
     */
    void tailStatementLogs() {
        var randomNumber = Math.random()
        log.info("Tailing statement logs. Random number: {}", randomNumber)
    }
}
