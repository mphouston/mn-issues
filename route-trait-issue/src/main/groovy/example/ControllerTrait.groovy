package example

import groovy.transform.CompileStatic
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.PathVariable
import io.micronaut.http.annotation.Produces
import io.micronaut.http.MediaType

@CompileStatic
trait ControllerTrait {

    @Get("/trait/{x}") 
    @Produces(MediaType.TEXT_PLAIN) 
    String indexT(@PathVariable(name = 'x') String x) {
        "Hello World Trait ${x}" 
    }


}