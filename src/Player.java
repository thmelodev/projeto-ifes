
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
public class Player {
    
    private int life;
    private int fire;
    private int coin;
    private int fase;

    public Player(int life, int fire, int coin, int fase) {
        this.life = life;
        this.fire = fire;
        this.coin = coin;
        this.fase = fase;
    }
    
    /**
     * @return the life
     */
    public int getVida() {
        return life;
    }

    /**
     * @param vida the life to set
     */
    public void setVida(int life) {
        this.life = life;
    }

    /**
     * @return the life
     */
    public int getFire() {
        return fire;
    }

    /**
     * @param fire the life to set
     */
    public void setFire(int fire) {
        this.fire = fire;
    }

    /**
     * @return the coin
     */
    public int getCoin() {
        return coin;
    }

    /**
     * @param coin the coin to set
     */
    public void setCoin(int coin) {
        this.coin = coin;
    }
    
    
    
    
    
    
}
