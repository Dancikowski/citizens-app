package com.mycompany.app;
import com.mycompany.app.cli.fileMaker.FileMaker;
import com.mycompany.app.cli.validator.IdValidator;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.Assert.*;

public class AppTest 
{
    FileMaker fileMaker;
    String path;
    String correctPersonId = "04222685555";
    String invalidPersonId =  "04222685551";

    @Before
    public void setUp(){
        path = "src/test/resources/citizens2.txt";
        fileMaker = new FileMaker(path);
    }

    @Test
    public void shouldCorrectlyCreateFile() throws IOException {
     fileMaker.createFile();
     File file = new File(path);
     assertTrue(file.exists());
    }

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
