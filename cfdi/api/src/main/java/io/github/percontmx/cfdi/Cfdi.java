package io.github.percontmx.cfdi;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public interface Cfdi {
    BigDecimal getTotal();
    LocalDateTime getFechaEmision();
}
