package ryan.kang.withsecuritycontextfactory

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.context.SecurityContext
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.test.context.support.WithSecurityContextFactory

class WithMockCustomUserSecurityContextFactory : WithSecurityContextFactory<WithMockCustomUser> {
    override fun createSecurityContext(annotation: WithMockCustomUser): SecurityContext {
        return SecurityContextHolder.createEmptyContext().apply {
            val principal = CustomUser(annotation.username, annotation.password)
            authentication = UsernamePasswordAuthenticationToken(principal, principal.password)
        }
    }
}