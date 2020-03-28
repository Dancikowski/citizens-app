package com.mycompany.app;

import com.mycompany.app.cli.fileMaker.FileMaker;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.Assert.assertTrue;

public class FileMakerTest {
    FileMaker fileMaker;
    String path;

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
}
