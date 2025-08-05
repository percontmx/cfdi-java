package io.github.percontmx.cfdi.utils.parsers;

import org.w3c.dom.Document;

/**
 * Interfaz para detectar el contexto de un documento XML dado.
 * Las implementaciones de esta interfaz deben definir la lógica para determinar
 * si el contexto aplica a un documento XML específico y proporcionar la
 * ruta de contexto correspondiente.
 */
public interface ContextDetector {

    /**
     * Determina si el contexto aplica al documento XML proporcionado.
     *
     * @param document el documento XML a evaluar
     * @return true si el contexto aplica al documento, false en caso contrario
     */
    boolean apply(Document document);

    /**
     * Obtiene la ruta de contexto asociada a este detector.
     *
     * @return la ruta de contexto como una cadena de texto
     */
    String getContextPath();

}