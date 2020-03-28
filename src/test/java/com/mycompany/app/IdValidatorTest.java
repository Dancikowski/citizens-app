package com.mycompany.app;

import com.mycompany.app.cli.validator.IdValidator;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class IdValidatorTest {
    String correctPersonId = "04222685555";
    String invalidPersonId =  "04222685551";

    @Test
    public void personIdShouldFail() {
        IdValidator idValidator = new IdValidator(invalidPersonId);
        assertFalse(idValidator.validate());
    }

    @Test
    public void personIdShouldPass() {
        IdValidator idValidator = new IdValidator(correctPersonId);
        assertTrue(idValidator.validate());
    }
}
