package org.example.ClinicaDelValle.actions;

import org.example.ClinicaDelValle.model.ExpedienteDigital;
import org.example.ClinicaDelValle.services.ExpedienteDigitalService;
import org.openxava.actions.BaseAction;

import javax.persistence.OptimisticLockException;

public class GenerarPdfAction extends BaseAction {
    @Override
    public void execute() throws Exception {
        ExpedienteDigital exp = (ExpedienteDigital) getView().getEntity();
        ExpedienteDigitalService service = new ExpedienteDigitalService();
        byte[] pdf = service.generarPdfConsolidado(exp.getId());
        // Lógica para descargar PDF (ej. stream a response)
        addMessage("PDF generado");
    }

}
