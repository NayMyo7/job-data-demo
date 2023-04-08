package com.springframework.jobdata.config;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.stereotype.Component;

/**
 * Created by Nay Myo Htet on 4/8/2023.
 */
@Component
public class Messages {
    @Autowired
    private MessageSource messageSource;

    private MessageSourceAccessor accessor;

    @PostConstruct
    private void init() {
        accessor = new MessageSourceAccessor(messageSource, LocaleContextHolder.getLocale());
    }

    public String get(String code) {
        //return accessor.getMessage(code);
        return messageSource.getMessage(code, null, LocaleContextHolder.getLocale());
    }

    public String get(String code, Object... args) {
        //return accessor.getMessage(code);
        return messageSource.getMessage(code, args, LocaleContextHolder.getLocale());
    }
}
