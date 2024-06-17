package AddAddress;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class AddressController {

    @FXML
    private TextField textNamaLengkap;
    @FXML
    private TextField textNomorHandphone;
    @FXML
    private TextField textAlamatPenerima;
    @FXML
    private TextField textDetailAlamat;
    @FXML
    private TextField textKodePos;
    @FXML
    private CheckBox checkboxDefault;
    @FXML
    private Button buttonCancel;
    @FXML
    private Button buttonSave;

    @FXML
    public void initialize() {
        textNamaLengkap.setOnKeyPressed(this::handleEnterKey);
        textNomorHandphone.setOnKeyPressed(this::handleEnterKey);
        textAlamatPenerima.setOnKeyPressed(this::handleEnterKey);
        textDetailAlamat.setOnKeyPressed(this::handleEnterKey);
        textKodePos.setOnKeyPressed(this::handleEnterKey);
    }

    @FXML
    private void handleEnterKey(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER) {
            if (event.getSource() == textNamaLengkap) {
                textNomorHandphone.requestFocus();
            } else if (event.getSource() == textNomorHandphone) {
                textAlamatPenerima.requestFocus();
            } else if (event.getSource() == textAlamatPenerima) {
                textDetailAlamat.requestFocus();
            } else if (event.getSource() == textDetailAlamat) {
                textKodePos.requestFocus();
            } else if (event.getSource() == textKodePos) {
                checkboxDefault.requestFocus();
            }
        }
    }

    @FXML
    private void handleRegulerButton() {
        textNamaLengkap.requestFocus();
    }

    @FXML
    private void handleInstanButton() {
        textNamaLengkap.requestFocus();
    }

    @FXML
    private void handleHematButton() {
        textNamaLengkap.requestFocus();
    }

    @FXML
    private void handleCancelButton() {
        clearForm();
    }

    @FXML
    private void handleSaveButton() {
        saveFormData();
    }

    private void clearForm() {
        textNamaLengkap.clear();
        textNomorHandphone.clear();
        textAlamatPenerima.clear();
        textDetailAlamat.clear();
        textKodePos.clear();
        checkboxDefault.setSelected(false);
    }

    private void saveFormData() {
        String namaLengkap = textNamaLengkap.getText();
        String nomorHandphone = textNomorHandphone.getText();
        String alamatPenerima = textAlamatPenerima.getText();
        String detailAlamat = textDetailAlamat.getText();
        String kodePos = textKodePos.getText();
        boolean isDefault = checkboxDefault.isSelected();

        System.out.println("Data Tersimpan:");
        System.out.println("Nama Lengkap: " + namaLengkap);
        System.out.println("Nomor Handphone: " + nomorHandphone);
        System.out.println("Alamat Penerima: " + alamatPenerima);
        System.out.println("Alamat Lengkap: " + detailAlamat);
        System.out.println("Kode Pos: " + kodePos);
        System.out.println("Gunakan sebagai alamat utama: " + (isDefault ? "Ya" : "Tidak"));
    }
}