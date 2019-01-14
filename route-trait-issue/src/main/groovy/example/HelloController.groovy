package example

import groovy.transform.CompileStatic
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.Produces
import io.micronaut.http.MediaType

import example.ControllerTrait

@CompileStatic
@Controller("/hello") 
class HelloController implements ControllerTrait {
    @Get("/{x}") 
    @Produces(MediaType.TEXT_PLAIN) 
    String index(String x) {
        "Hello World ${x}" 
    }
}
