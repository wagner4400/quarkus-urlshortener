package wsr.codetest.com.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import wsr.codetest.com.repository.UrlRepository;

@ApplicationScoped
public class UrlService {
    @Inject
    UrlRepository urlRepository;
}
