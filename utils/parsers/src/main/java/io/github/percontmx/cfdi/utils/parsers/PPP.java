package io.github.percontmx.cfdi.utils.parsers;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import mx.gob.sat.cfdi.v32.ObjectFactory;

import java.io.StringReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


public class PPP {

    public static <T> T parse(String xml, Class<T> destinyClass) throws JAXBException {
        // Del xml hay que determinar primero los object factories que utilizaremos.
        // para determinar esto, cada parser tiene un xpath para determinar si ese factory aplica.
        // Luego, con los object factories, se crea un JAXBContext.
        // Finalmente, se utiliza el JAXBContext para deserializar el XML en un objeto de tipo T.

        StringReader r = new StringReader(xml);
        List<Class<?>> objectFactories = getFactories(xml);
        JAXBContext context = JAXBContext.newInstance();
        Object x = context.createUnmarshaller().unmarshal(r);
        return destinyClass.cast(x);
    }

    private static List<Class<?>> getFactories(String xml) {
        // Aquí se debe implementar la lógica para obtener las clases de ObjectFactory
        // basadas en el XML proporcionado. Por ahora, retornamos una lista con un solo
        // ObjectFactory de ejemplo.

        return Arrays.stream(Tilinga.values())
                .map(Tilinga::getTilingaLungaClass)
                .map(Class::newInstance)
                .filter(tilingaLunga -> tilingaLunga.apply(xml))
                .map(TilingaLunga::getObjectFactory)
                .collect(Collectors.toList());



    }
}
