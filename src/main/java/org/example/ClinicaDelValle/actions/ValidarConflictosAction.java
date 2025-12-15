package org.example.ClinicaDelValle.actions;

import org.example.ClinicaDelValle.model.Cita;
import org.example.ClinicaDelValle.services.CitaService;
import org.openxava.actions.BaseAction;
import org.openxava.actions.ViewBaseAction;

import javax.persistence.OptimisticLockException;

public class ValidarConflictosAction extends ViewBaseAction {
    @Override
    public void execute() throws Exception {
        Cita cita = (Cita) getView().getEntity();
        CitaService service = new CitaService();
        service.validarConflictos(cita);
        addMessage("Conglictos validados exitosamente");
    }


}
