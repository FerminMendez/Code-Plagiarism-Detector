package com.renoux.gael.codejam.utils;

import java.io.Closeable;
import java.io.IOException;


/**
 * <p>
 * Cette classe comporte des méthodes utilitaires de gestion des flux d'entrée/sortie.
 * </p>
 * 
 * @author renouxg
 */
public class FluxUtils {

    /**
     * <p>
     * Constructeur privé : cette classe utilitaire n'est pas destinée à être instanciée.
     * </p>
     */
    private FluxUtils() {
        // classe non instanciable
    }


    /**
     * <p>
     * Cette méthode utilitaire ferme tous les objets <code>Closeable</code> qui lui sont passés en paramètre.
     * Les éléments nuls sont ignorés. Si la fermeture de l'un ou plusieurs d'entre eux renvoie une erreur, on
     * tâche néanmoins de fermer tous les flux ; la première erreur survenue est ensuite relancée.
     * </p>
     * 
     * @param fluxArray les objets implémentant {@link Closeable} qu'il faut fermer.
     * @throws IOException toute exception qui peut se produire à la fermeture d'un {@link Closeable}.
     */
    public static void closeCloseables(final Closeable... fluxArray) {
        IOException relaunch = null;

        for (Closeable flux : fluxArray) {
            if (flux == null) {
                continue;
            }

            try {
                flux.close();
            } catch (IOException lEx) {
                if (relaunch == null) {
                    relaunch = lEx;
                } else {
                    // Nouvelle exception, ignorée
                }
            }
        }

        if (relaunch != null) {
            throw new TechnicalException(relaunch);
        }
    }

}
