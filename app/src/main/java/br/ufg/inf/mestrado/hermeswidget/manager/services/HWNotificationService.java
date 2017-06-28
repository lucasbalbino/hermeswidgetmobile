package br.ufg.inf.mestrado.hermeswidget.manager.services;

import java.util.Date;

//import br.ufg.inf.mestrado.hermesbase.HermesBaseManager;
import br.ufg.inf.mestrado.hermeswidget.client.utils.HWLog;
import br.ufg.inf.mestrado.hermeswidget.manager.transferObject.HWTransferObject;

/**
 * @author Ernesto
 *         <p>
 *         Classe usada pelos Hermes Widgets para enviar (notificar) o contexto
 *         utilizando o Hermes Base.
 */

public class HWNotificationService implements Runnable {

    //	private HermesBaseManager hermesBaseManager;
    private HWTransferObject hermesWidgetTO;

// REMOVENDO O HERMES BASE
//    public HWNotificationService(HermesBaseManager hermesBaseManager, HWTransferObject hermesWidgetTO) {
//        this.hermesBaseManager = hermesBaseManager;
//        this.hermesWidgetTO = hermesWidgetTO;
//    }

    public HWNotificationService(HWTransferObject hermesWidgetTO) {
        this.hermesWidgetTO = hermesWidgetTO;
    }

    @Override
    public void run() {
//        if (hermesBaseManager.publishNotification(
//                hermesWidgetTO.getIdEntidade(), hermesWidgetTO.getNomeTopico() + "H",
//                hermesWidgetTO.getComplementoTopico(),
//                hermesWidgetTO.getCaminhoOntologia(),
//                hermesWidgetTO.getContexto(),
//                hermesWidgetTO.getTipoSerializacao())) {
            // hermesWidgetTO.getTipoTopico()

            String log = "Thread " + hermesWidgetTO.getThreadAtual() + " de "
                    + hermesWidgetTO.getTotalThreads() + " - "
                    + hermesWidgetTO.getIdEntidade()
                    + " HW.Sensor.Msg--> Vital Sign: "
                    + hermesWidgetTO.getNomeTopico() + ", Value: "
                    + hermesWidgetTO.getSensorValue() + ", for patient: "
                    + hermesWidgetTO.getIdEntidade() + ", broadcast on topic: "
                    + hermesWidgetTO.getNomeTopico() + "H" + ", at: " + new Date();

//            HWLog.recordLog(log);

            //System.out.println("\n" + log);

//        } else {
//            System.out.println("Erro de publicacao no topico "
//                    + hermesWidgetTO.getNomeTopico());
//        }
    }

}
