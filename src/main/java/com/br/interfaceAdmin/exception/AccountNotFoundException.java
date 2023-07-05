package com.br.interfaceAdmin.exception;

import java.io.Serial;

public class AccountNotFoundException extends Exception {

    @Serial
    private static final long serialVersionUID = 7139304880555402679L;

    public AccountNotFoundException() {
        super();
    }

    public AccountNotFoundException(String msg) {
        super(msg);
    }

    public AccountNotFoundException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
