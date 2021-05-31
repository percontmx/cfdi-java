package mx.gob.sat.complementos.nómina.v1_1.adapters;

import mx.gob.sat.catálogos.nómina.Catálogo;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.util.Optional;
import java.util.function.Function;

public abstract class CatálogoAdapter<ValueType, CatalogType extends Catálogo>
        extends XmlAdapter<ValueType, CatalogType> {

    private final Function<? super ValueType, ? extends CatalogType> toCatalogMapperFunction;
    private final Function<? super CatalogType,? extends ValueType> fromCatalogMapperFunction;

    protected CatálogoAdapter(Function<? super ValueType, ? extends CatalogType> toCatalog,
                              Function<? super CatalogType, ? extends ValueType> fromCatalog){
        toCatalogMapperFunction = toCatalog;
        fromCatalogMapperFunction = fromCatalog;
    }

    @Override
    public ValueType marshal(CatalogType bound) {
        return applyFunctionOrNull(bound, fromCatalogMapperFunction);
    }

    @Override
    public CatalogType unmarshal(ValueType value) {
        return applyFunctionOrNull(value, toCatalogMapperFunction);
    }

    private <Target, Source> Target applyFunctionOrNull(Source source, Function<Source, Target> mapperFunction){
        return Optional.ofNullable(source)
                .map(mapperFunction)
                .orElse(null);
    }
}
