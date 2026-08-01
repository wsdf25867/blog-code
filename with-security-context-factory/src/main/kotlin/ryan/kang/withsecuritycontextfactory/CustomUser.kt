package ryan.kang.withsecuritycontextfactory

import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.userdetails.UserDetails

class CustomUser(val userName: String, val userPassword: String) : UserDetails {

    override fun getAuthorities(): Collection<GrantedAuthority> {
        throw UnsupportedOperationException()
    }

    override fun getPassword(): String = this.userPassword

    override fun getUsername(): String = this.userName
}
