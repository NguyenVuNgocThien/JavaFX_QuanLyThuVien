/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Response;

import javafx.scene.control.TextField;

/**
 *
 * @author dell
 */
public class TextLimit extends TextField {
    private int limit;
    public TextLimit(){
        this.limit=10;
    }
    @Override
    public void replaceText(int start, int end, String text) {
        // Delete or backspace user input.
        if (text.equals("")) {
            super.replaceText(start, end, text);
        } else if (getText().length() < limit) {
            super.replaceText(start, end, text);
        }
    }
    @Override
    public void replaceSelection(String text) {
        // Delete or backspace user input.
        if (text.equals("")) {
            super.replaceSelection(text);
        } else if (getText().length() < limit) {
            // Add characters, but don't exceed maxlength.
            if (text.length() > limit - getText().length()) {
                text = text.substring(0, limit- getText().length());
            }
            super.replaceSelection(text);
        }
    }
    public void setlimit(int limit){
        this.limit=limit;
    }
   
}
