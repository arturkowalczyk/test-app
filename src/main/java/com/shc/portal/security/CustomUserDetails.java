package com.shc.portal.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * @author kul_viswanath
 */
public class CustomUserDetails extends User
{

    private static final long serialVersionUID = 6115040791566524984L;

    private static final Logger LOGGER = LoggerFactory.getLogger( CustomUserDetails.class );

    public static final String AUTHORITY_PREFIX = "ROLE_";

    public CustomUserDetails( String userName, String password, List<String> roles )
    {
        super( userName, password, true, true, true, true, getGrantedAuthorities( roles ) );
    }

    private static List<GrantedAuthority> getGrantedAuthorities( List<String> roles )
    {
        List<GrantedAuthority> authorities = roles.stream()
                .map( CustomUserDetails::createAuthority )
                .collect( toList() );

        LOGGER.info( "Roles : {}", roles );
        LOGGER.info( "Authorities : {}", authorities );

        return authorities;
    }

    private static GrantedAuthority createAuthority( String roleName )
    {
        String authority = AUTHORITY_PREFIX + roleName;
        return new SimpleGrantedAuthority( authority );
    }
}
