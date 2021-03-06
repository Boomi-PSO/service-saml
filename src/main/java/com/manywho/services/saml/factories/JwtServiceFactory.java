package com.manywho.services.saml.factories;

import com.manywho.services.saml.security.SecurityConfiguration;
import com.manywho.services.saml.services.JwtService;
import org.glassfish.hk2.api.Factory;

import javax.inject.Inject;
import javax.inject.Singleton;

public class JwtServiceFactory implements Factory<JwtService> {

    private SecurityConfiguration securityConfiguration;

    @Inject
    JwtServiceFactory(SecurityConfiguration securityConfiguration) {
        this.securityConfiguration = securityConfiguration;
    }
    @Singleton
    public JwtService provide() {
        return new JwtService(securityConfiguration.getSecret());
    }

    @Override
    public void dispose(JwtService jwtSigner) {

    }
}
