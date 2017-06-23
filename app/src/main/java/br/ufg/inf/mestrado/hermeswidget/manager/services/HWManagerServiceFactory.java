package br.ufg.inf.mestrado.hermeswidget.manager.services;

//import br.ufg.inf.mestrado.hermesbase.HermesBaseManager;

import br.ufg.inf.mestrado.hermeswidget.manager.transferObject.HWTransferObject;

/**
 * @author Ernesto
 *         <p>
 *         Fornece objetos singleton para os servicos do Hermes Widget
 *         (comunicacao, persistencia, representacao)
 */

public class HWManagerServiceFactory {

    private static HWConfigurationService hermesWidgetConfiguration;
    private static HWCommunicationService hermesWidgetCommunication;
    private static HWNotificationService hermesWidgetNotification;
    private static HWPersistenceService hermesWidgetPersistence;


    /**
     * @return Meodo que retorna uma instancia do objeto de comunicacao, o qual
     * possui uma instancia de HermesBaseObject
     */
    public static HWConfigurationService getConfigurationService() {
        if (hermesWidgetConfiguration == null) {
            hermesWidgetConfiguration = new HWConfigurationService();
        }
        return hermesWidgetConfiguration;
    }

    /**
     * @return ?
     */
    public static HWCommunicationService getCommunicationService() {
        if (hermesWidgetCommunication == null) {
            hermesWidgetCommunication = new HWCommunicationService();
        }
        return hermesWidgetCommunication;
    }

    /**
     * @return ?
     */
    // REMOVENDO O HERMES BASE
//    public static HWNotificationService getNotificationService(HermesBaseManager hermesBase, HWTransferObject hermesWidgetTO) {
//        hermesWidgetNotification = new HWNotificationService(hermesBase, hermesWidgetTO);
//        return hermesWidgetNotification;
//    }

    public static HWNotificationService getNotificationService(HWTransferObject hermesWidgetTO) {
        hermesWidgetNotification = new HWNotificationService(hermesWidgetTO);
        return hermesWidgetNotification;
    }

    /**
     * @return ?
     */
    public static HWPersistenceService getPersistenceService() {
        if (hermesWidgetPersistence == null) {
            hermesWidgetPersistence = new HWPersistenceService();
        }
        return hermesWidgetPersistence;
    }

}
