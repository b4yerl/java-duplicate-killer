package com.github.b4yerl;

import java.io.File;
import java.io.IOException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Assertions;
import com.github.b4yerl.file.DuplicateFileRemover;

public class DuplicateFileRemoverTest {
    @BeforeEach
    void setUpTestFile() throws IOException {
        File testFile = new File("./testingfileremoval");
        testFile.createNewFile();
    }

    @Test
    void shouldRemoveFile() {
        DuplicateFileRemover.killIt("./testingfileremoval");
        Assertions.assertFalse(new File("./testingfileremoval").canRead());
    }
}
