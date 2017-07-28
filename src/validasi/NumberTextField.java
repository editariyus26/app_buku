/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package validasi;

import javafx.scene.control.TextField;

/**
 *
 * @author ANDROIDA-PC
 */
public class NumberTextField extends TextField {

    public NumberTextField() {
        this.setPromptText("Masukkan Angka Saja..");
    }

    @Override
    public void replaceText(int start, int end, String text) {
        if (text.matches("[0-9]") || text.isEmpty()) {
            super.replaceText(start, end, text);
        }
    }

    @Override
    public void replaceSelection(String text) {
    super.replaceSelection(text);
    }

    
}
