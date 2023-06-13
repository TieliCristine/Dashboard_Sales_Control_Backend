package com.br.interfaceAdmin.model.projection;

import java.util.Date;

public interface UserProjection {
    long getId();
    String  getEmail();
    String getName();
    Date getBirthdate();
    String getJobPosition();
}
