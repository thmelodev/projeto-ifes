
import javax.swing.ImageIcon;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Peppão
 */
public class Fases {
    
    
    ImageIcon faseIcon;
    ImageIcon backGround;
    private boolean open;
    private String[] conj1;
    private String[] conj2;
    private String[] conj3;

    public Fases(ImageIcon faseIcon, ImageIcon backGround, boolean open, String[] conj1, String[] conj2, String[] conj3) {
        this.faseIcon = faseIcon;
        this.backGround = backGround;
        this.open = open;
        this.conj1 = conj1;
        this.conj2 = conj2;
        this.conj3 = conj3;
    }

    public boolean isOpen() {
        return open;
    }

    public void setOpen(boolean open) {
        this.open = open;
    }
    
    

    

    
    
    
            
}
