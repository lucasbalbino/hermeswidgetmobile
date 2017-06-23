package br.ufg.inf.mestrado.hermeswidget.manager.facade;

//import br.ufg.inf.mestrado.hermesbase.HermesBaseManager;
import br.ufg.inf.mestrado.hermeswidget.manager.services.HWCommunicationService;
import br.ufg.inf.mestrado.hermeswidget.manager.services.HWConfigurationService;
import br.ufg.inf.mestrado.hermeswidget.manager.services.HWManagerServiceFactory;
import br.ufg.inf.mestrado.hermeswidget.manager.services.HWNotificationService;
import br.ufg.inf.mestrado.hermeswidget.manager.transferObject.HWTransferObject;

/**
 * @author Ernesto
 *         <p>
 *         Classe que realiza a inicializacao de um HermesWidget, juntamento com
 *         o servico de comunicacao do mesmo com a infraestrutura.
 *         <p>
 *         Session Facade: Simplificar a interface do cliente e controlar o
 *         acesso e a comunicacao. Session Facade representa uma funcao ou
 *         varias funcoes exercidas por um sistema.
 *         <p>
 *         Remove dos clientes o acesso direto as camadas de negocio do
 *         componente por meio de uma interface com metodos para registro,
 *         publicacao e assinatura de topicos.
 */

public class HWManagerFacade {

    public HWManagerFacade() {
    }

    /**
     * Inicializa o servico de configuracao, obtendo ou criando uma instancia de
     * HermesWidgetConfigurationService
     */
    public void startHermesWidgetConfigurationService(String configuration) {
        HWConfigurationService configurationService = HWManagerServiceFactory.getConfigurationService();

        /**
         * Invocacao dos metodos do servico de comunicacao para criacao dos
         * topicos, registro de publicadores e assinatura de topcos
         */
        configurationService.createTopics(configuration);

		/*
         * comunicationService.registerPublishers();
		 * comunicationService.subscribeTopics();
		 */
    }

    public HWCommunicationService startHermesWidgetCommunicationService() {
        return HWManagerServiceFactory.getCommunicationService();
    }

    // REMOVENDO O HERMES BASE
//    public HWNotificationService getHermesWidgetNotificationService(HermesBaseManager hermesBase, HWTransferObject hermesWidgetTO) {
//        return HWManagerServiceFactory.getNotificationService(hermesBase, hermesWidgetTO);
//    }

    public HWNotificationService getHermesWidgetNotificationService(HWTransferObject hermesWidgetTO) {
        return HWManagerServiceFactory.getNotificationService(hermesWidgetTO);
    }

}
