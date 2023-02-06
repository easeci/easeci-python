package io.easeci.python;

import io.easeci.extension.command.Command;
import io.easeci.extension.command.Directive;
import io.easeci.extension.directive.CodeChunk;
import io.easeci.extension.directive.CodeLanguage;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Collections;
import java.util.List;

public class PythonPerformer implements Directive {

    @Override
    public String getDirectiveName() {
        return "python";
    }

    @Override
    public List<Command> getAvailableCommandList() throws IllegalAccessException {
        return Collections.emptyList();
    }

    @Override
    public CodeChunk provideCode(String base64PythonCode) throws IllegalAccessException {
        final String plainPythonCode = new String(Base64.getDecoder().decode(base64PythonCode.getBytes(StandardCharsets.UTF_8)));
        return CodeChunk.of(0, getDirectiveName(), CodeLanguage.PYTHON_3, plainPythonCode, "UTF-8");
    }
}
