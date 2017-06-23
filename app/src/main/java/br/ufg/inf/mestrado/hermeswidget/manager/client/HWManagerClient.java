package br.ufg.inf.mestrado.hermeswidget.manager.client;

//import br.ufg.inf.mestrado.hermesbase.HermesBaseManager;

import br.ufg.inf.mestrado.hermeswidget.manager.services.HWNotificationService;
import br.ufg.inf.mestrado.hermeswidget.manager.transferObject.HWTransferObject;

/**
 * @author Ernesto
 *         <p>
 *         Classe que invoca a inicializacao de um Hermes Widget.
 */

public abstract class HWManagerClient {

    /**
     * @param configuration Metodo abstrato cuja implementacao inicia o Servico de
     *                      Configuracao do Hermes Widget.
     *                      <p>
     *                      O servico de configuracao utiliza o componente Hermes Base
     *                      para criar os topicos que receberao as publicacoes de cada
     *                      Hermes Widget, ou seja, os topicos de notificacao.
     */
    public abstract void startConfigurationService(String configuration);

    /**
     * @return Retorna uma instancia de HermesBaseManager, que realiza o servico
     * de comunicacao do Hermes.
     */
//	public abstract HermesBaseManager getCommunicationService();

    // REMOVENDO O HERMES BASE
//    public abstract HWNotificationService getNotificationService(HermesBaseManager hermesBase, HWTransferObject hermesWidgetTO);

    public abstract HWNotificationService getNotificationService(HWTransferObject hermesWidgetTO);

}
