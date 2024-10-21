/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dialog;

import interface_noyau_fonctionnel.InterfaceNoyauFonctionnel;
import java.awt.EventQueue;
import java.time.LocalDate;
import presentation.FrameReservation;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

public class DialogReservation {

    private FrameReservation frameReservation;
    private InterfaceNoyauFonctionnel inf;
    private LocalDate selectedDate;
    private String selectedTime;
    private int selectedNumOfPersons;
    private int selectedTable;
    private String[] availableTables;

    public DialogReservation(InterfaceNoyauFonctionnel inf) {
        this.inf = inf;
    }

    public void initDialog() {
        frameReservation = new FrameReservation();
        frameReservation.initFrame();
        frameReservation.setDialog(this);
        frameReservation.setVisible(true);
    }

    public void handleDateSelectedEvent(LocalDate date) {
    	selectedDate = date;
        throw new UnsupportedOperationException("Not implemented yet");
    }

    public void handleTimeSelectedEvent(String time) {
    	selectedTime = time;
        throw new UnsupportedOperationException("Not implemented yet");
    }

    public void handleNumOfPersonsSelectedEvent(int nbPersons) {
    	selectedNumOfPersons = nbPersons;
        availableTables = inf.trouverTableDisponible(selectedDate.getDayOfMonth(), selectedDate.getMonthValue(), selectedNumOfPersons, selectedTime);
        DefaultListModel<String> model = new DefaultListModel<>();
        for (String table : availableTables) {
            model.addElement(table);
        }
        frameReservation.updateTablePicker(model);
        throw new UnsupportedOperationException("Not implemented yet");
    }

    public void handleTableSelectedEvent(int numTable) {
    	selectedTable = numTable;
        String selectedTableString = frameReservation.getSelectedTable();
        if (selectedTableString != null) {
            selectedTable = Integer.parseInt(selectedTableString.split(" ")[1]);
        }
        if (selectedDate != null && selectedTime != null && selectedNumOfPersons > 0 && selectedTable > 0) {
            frameReservation.getConfirmButton().setEnabled(true);
    }
        throw new UnsupportedOperationException("Not implemented yet");
    }

    public void handleCancelEvent() {
    	selectedDate = null;
        selectedTime = null;
        selectedNumOfPersons = 0; 
        availableTables = null;
        frameReservation.init();
        throw new UnsupportedOperationException("Not implemented yet");
    }

    public void handleValidationEvent() {
    	JOptionPane.showMessageDialog(null, "Réservation validée pour le "+selectedDate+" à "+selectedTime+" pour " +selectedNumOfPersons+" personnes à la table"+selectedTable, "Confirmation de réservation", JOptionPane.INFORMATION_MESSAGE);
        throw new UnsupportedOperationException("Not implemented yet");
    }

    public static void main(String[] args) {
        DialogReservation dialog = new DialogReservation(new InterfaceNoyauFonctionnel());
        EventQueue.invokeLater(() -> {
            dialog.initDialog();
        });
    }

}
