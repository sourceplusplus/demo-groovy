package spp.demo.indicator

import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get

/**
 * This class is used to demonstrate the `Slow Endpoint` indicator. This indicator will be automatically added to
 * endpoints with the highest response times and is visible in the gutter to the left of the editor.
 * <p>
 * <b>Usage:</b>
 * N/A (automatically added)
 * </p>
 * <p>
 * <b>Indicator source code:</b>
 * <a href="https://github.com/sourceplusplus/jetbrains-commander/blob/master/resources/.spp/plugins/slow-endpoint/plugin.kts">Slow Endpoint</a>
 * </p>
 */
@Controller("/indicator")
class SlowEndpoint {

    /**
     * Hover your mouse over the turtle icon on line 26 to see the response time (~2000ms).
     */
    @Get("/slow-2000ms")
    HttpResponse<Void> slow2000ms() {
        try {
            Thread.sleep(2000)
        } catch (InterruptedException ignore) {
        }
        return HttpResponse.ok()
    }

    /**
     * Hover your mouse over the turtle icon on line 38 to see the response time (~1000ms).
     */
    @Get("/slow-1000ms")
    HttpResponse<Void> slow1000ms() {
        try {
            Thread.sleep(1000)
        } catch (InterruptedException ignore) {
        }
        return HttpResponse.ok()
    }
}
