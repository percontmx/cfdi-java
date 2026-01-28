package io.github.percontmx.cfdi.comparators;

import io.github.percontmx.cfdi.Cfdi;

import java.util.Comparator;

public class CfdiPorFechaEmisionComparator implements Comparator<Cfdi> {

    @Override
    public int compare(Cfdi cfdi1, Cfdi cfdi2) {
        return cfdi1.getFechaEmision().compareTo(cfdi2.getFechaEmision());
    }
}
