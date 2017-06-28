package br.ufg.inf.mestrado.hermeswidget.manager.services;

import org.json.JSONException;

import java.util.ArrayList;

//import br.ufg.inf.mestrado.hermesbase.HermesBaseManager;
import br.ufg.inf.mestrado.hermeswidget.manager.configurator.HWManagerConfigurator;

/**
 * @author Ernesto
 *         <p>
 *         Classe responsavel pela configuracao do HermesWidget, no que diz
 *         respeito a criacao do topicos para publicacao do contexto obtido e
 *         representado.
 *         <p>
 *         Realiza interface com o componente Hermes Base.
 */

public class HWConfigurationService {

    /**
     * Instancia do componente Hermes Base, responsavel pela comunicacao da
     * infraestrutura Hermes.
     */
//	private HermesBaseManager hermesBaseManager = HWManagerServiceFactory.getCommunicationService().getHermesBaseManager();

    /**
     * Realiza a criacao dos topicos especificados no arquivo topicos.json
     */
    public void createTopics(String configuration) {

        ArrayList<String> topicosParaNotificacao = null;
        try {
            topicosParaNotificacao = HWManagerConfigurator
                    .getNotificationTopicsForRegistry(configuration);
            for (int i = 0; i < topicosParaNotificacao.size(); i++) {
                String nomeTopicoNotificacao = topicosParaNotificacao.get(i);
                //hermesBaseManager.createNotificationTopic(nomeTopicoNotificacao);

                //System.out.println("Topico criado: " + nomeTopicoNotificacao);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

	/*
     * public void notifyContext(HermesWidgetTransferObject hermesWidgetTO) {
	 * 
	 * }
	 */
}
