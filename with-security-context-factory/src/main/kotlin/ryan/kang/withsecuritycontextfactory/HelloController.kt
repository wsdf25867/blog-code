package ryan.kang.withsecuritycontextfactory

import org.springframework.security.core.annotation.AuthenticationPrincipal
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class HelloController {

    @GetMapping("/hello")
    fun hello(@AuthenticationPrincipal principal: CustomUser): String = "Hello"
}