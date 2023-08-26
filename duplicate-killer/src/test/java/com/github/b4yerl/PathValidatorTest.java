package com.github.b4yerl;

import com.github.b4yerl.file.PathValidator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;

public class PathValidatorTest {
    @Test
    @EnabledOnOs(value = OS.WINDOWS, disabledReason = "Path for windows systems")
    void shouldValidateWindowsPath() {
        Assertions.assertTrue(PathValidator.isValidPath("c:/"));
    }

    @Test
    @EnabledOnOs(value = OS.LINUX, disabledReason = "Path for linux systems")
    void shouldValidateLinuxPath() {
        Assertions.assertTrue(PathValidator.isValidPath("/home"));
    }
}
