package org.andrea.connection;

import java.io.Serializable;

public interface Response extends Serializable {

    public String getMessage();

    public Status getStatus();

    public String getContextType();

    public String getContextLength();

    public String getHost();
}
