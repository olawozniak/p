/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.prz.validators;

import org.prz.dao.EmailChange;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 *
 * @author Ola
 */
@Component
public class EmailChangeValidator implements Validator{
    protected final Logger log = LoggerFactory.getLogger(getClass());

    @Override
    public boolean supports(Class<?> type) {
        return EmailChange.class.equals(type);
    }
    
    @Override
    public void validate(Object o, Errors errors) {
        EmailChange model = (EmailChange) o;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", null, "Pole jest wymagane.");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", null, "Pole jest wymagane.");

        if (model.getEmail() != null && !model.getEmail()
                .matches("^[\\w-\\+]+(\\.[\\w-]+)*@"
                        + "[A-Za-z\\d-]+(\\.[A-Za-z\\d]+)*(\\.[A-Za-z]{2,})$")) {
            log.debug("Nieprawidłowy email: {}", model.getEmail());
            errors.rejectValue("email", null, "Nieprawidłowy adres e-mail.");
        }
    }
}
