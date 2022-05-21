
import java.awt.Color;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Peppão
 */
public class Game extends javax.swing.JFrame implements Runnable {

    /**
     * Creates new form Game
     */
    
    
    
    private int fase = 1;
    private int resp = 0;
    private boolean temVida = true;
    private boolean foiProMenu = false;
    private boolean trocouDeFase = false;
    
    //create objects
    Chapters chapters;
    Words words = new Words();
    Images images = new Images();
    Random random = new Random();
    Thread t1 = new Thread(this);
    Player player = new Player(0,0,0,0);
    Fases fases;
    
    
    
    Fase1 fase1;
    Fase2 fase2;
    //Fase3 fase3;
    //Fase4 fase4;
    
    
    public Game() {
        initComponents();
        gameIcon.setIcon(images.ajustaIcone(images.chapter1Icon,gameIcon));
        t1.start();
        hideButton(this.next);
    }
    public void disableButtons(){
        resp0.setEnabled(false);
        resp1.setEnabled(false);
        resp2.setEnabled(false);
    }
    public void hideButton(JButton button){
        button.setEnabled(false);
        button.setOpaque(false);
        button.setContentAreaFilled(false);
        button.setBorderPainted(false);
        button.setText(null);
    }
    public void showButton(JButton button,String string){
        button.setEnabled(true);
        button.setOpaque(true);
        button.setContentAreaFilled(true);
        button.setBorderPainted(true);
        button.setText(string);
    }
            
    public void enableButtons(){
        resp0.setEnabled(true);
        resp1.setEnabled(true);
        resp2.setEnabled(true);
    }
    
    public void ajustaNoStaticIcons(){
        circle.setIcon(images.ajustaIcone(images.circle, circle));
        fireIcon.setIcon(images.ajustaIcone(images.fire, fireIcon));
        heartIcon.setIcon(images.ajustaIcone(images.heart, heartIcon));
        coinIcon.setIcon(images.ajustaIcone(images.coin, coinIcon));   
    }
    //sobrecarga ajustaIcons
    public void ajustaIcons(JLabel faseIcon,Fase1 fase1){
        faseIcon.setIcon(images.ajustaIcone(fase1.faseIcon, faseIcon));
        background.setIcon(images.ajustaIcone(images.fase1Background, background));
        ajustaNoStaticIcons(); 
    }
    
    public void ajustaIcons(JLabel faseIcon,Fase2 fase2){
        faseIcon.setIcon(images.ajustaIcone(fase2.faseIcon, faseIcon));
        background.setIcon(images.ajustaIcone(images.fase2Background, background));
        ajustaNoStaticIcons(); 
    }
    
//    public void ajustaIcons(JLabel faseIcon,Fase3 fase3){
//            ajustaIconsStatus(); 
//    }
    
//    public void ajustaIcons(JLabel faseIcon,Fase4 fase4){
//            ajustaIconsStatus(); 
//    }
    public void ajustaTitleAndImage(int num,int fase,int cat){
        ImageIcon[] imageIcon;
        if(fase==1){
            if(cat==0){
                this.getCat().setText("ANIMALS");
                imageIcon = images.animals;
                this.getGameIcon().setIcon(images.ajustaIcone(imageIcon[num],this.getGameIcon()));
                
            }else if(cat==1){
                this.getCat().setText("FOODS");
                imageIcon = images.foods;
                this.getGameIcon().setIcon(images.ajustaIcone(imageIcon[num],this.getGameIcon()));
            }
            else{
                this.getCat().setText("COLORS");
                imageIcon = images.colors;
                this.getGameIcon().setIcon(images.ajustaIcone(imageIcon[num],this.getGameIcon()));
            }
                
        }else if(fase==2){
            if(cat==0){
                this.getCat().setText("CITY");
                imageIcon = images.city;
                this.getGameIcon().setIcon(images.ajustaIcone(imageIcon[num],this.getGameIcon()));
                
            }else if(cat==1){
                this.getCat().setText("HUMAN PARTS");
                imageIcon = images.humanParts;
                this.getGameIcon().setIcon(images.ajustaIcone(imageIcon[num],this.getGameIcon()));
            }
            else{
                this.getCat().setText("OBJECTS");
                imageIcon = images.objects;
                this.getGameIcon().setIcon(images.ajustaIcone(imageIcon[num],this.getGameIcon()));
            }
        }else if(fase==3){
            
        }else if(fase ==4){
            
        }
    }
    
    public void ajustaResp(String[] words,int buttonResp,int num,int tamanhoDoVet,JButton respCerta,JButton respErrada1,JButton respErrada2){
        this.setResp(buttonResp);
        this.getResp0().setText(words[num]);
        this.getResp1().setText(words[num]);
        this.getResp2().setText(words[num]);
        while(respCerta.getText() == respErrada1.getText()){
            respErrada1.setText(words[random.nextInt(tamanhoDoVet)]);
        }
        while(respCerta.getText() == respErrada2.getText() ||
            respErrada1.getText() == respErrada2.getText()){
            respErrada2.setText(words[random.nextInt(tamanhoDoVet)]);
        }
        
    }
    public void ajustaButtons(String[]words,int tamanhoDoVet,int fase,int cat){
        int num = random.nextInt(tamanhoDoVet);
        int buttonResp = random.nextInt(3);
        ajustaTitleAndImage(num,fase,cat);
        if(buttonResp ==0){
            this.ajustaResp(words,buttonResp, num,tamanhoDoVet, resp0, resp1, resp2);
        }else if(buttonResp == 1){
            this.ajustaResp(words,buttonResp, num,tamanhoDoVet, resp1, resp0, resp2);
        }else{
            this.ajustaResp(words,buttonResp, num,tamanhoDoVet, resp2, resp0, resp1);
        }
    }
    public void ajustaGame(){
        verificaVida();
        if(temVida && (!foiProMenu || trocouDeFase)){
            hideButton(next);
            if(this.getFase()== 1){
                int cat = random.nextInt(3);
                if(cat==0){
                    ajustaButtons(words.animals,images.animals.length,this.getFase(),cat);
                }else if(cat==1){
                    ajustaButtons(words.food,images.foods.length,this.getFase(),cat);
                }else{
                    ajustaButtons(words.colors,images.colors.length,this.getFase(),cat);
                }
            }else if(this.getFase()==2){
                int cat = random.nextInt(3);
                if(cat==0){
                    ajustaButtons(words.city,images.city.length,this.getFase(),cat);
                }else if(cat==1){
                    ajustaButtons(words.humanParts,images.humanParts.length,this.getFase(),cat);
                }else{
                    ajustaButtons(words.objects,images.objects.length,this.getFase(),cat);
                }
            }else if(this.getFase()==3){

            }else if(this.getFase()==4){

            }
        }
        
        this.moreCoin.setText(null);
        this.moreFire.setText(null);
    }
    public void menu(){
        
        chapters.player = this.player;
        chapters.game = this;
        foiProMenu = true;
        this.setVisible(false);
        chapters.setVisible(true);
        
        
        
    }
    
    public void verificaVida(){
        if(player.getVida()==0){
            this.next.setEnabled(false);
            this.disableButtons();
            temVida = false;
            
        }else{
            this.next.setEnabled(true);
            this.enableButtons();
            temVida = true;
        }
    }
    
    public void acertou(){
        if(player.getCoin()<=999-3*player.getFire())this.getMoreCoin().setText("+"+(3*player.getFire()));
        else{
            this.getMoreCoin().setText(null);
            player.setCoin(999);
        }
        
        if(player.getFire()<5)this.getMoreFire().setText("+"+1);
        else this.getMoreFire().setText(null);
        
        this.disableButtons();
    }
    
    public void errou(){
        if(player.getCoin()>10)this.getMoreCoin().setText("-"+10);
        else if(player.getCoin()>0) this.getMoreCoin().setText("-"+player.getCoin());
        else  this.getMoreCoin().setText(null)  ;
        if(player.getFire()>1)this.getMoreFire().setText("-" + (player.getFire()-1));    
        else this.getMoreFire().setText(null);
        if(player.getVida()>0)player.setVida(player.getVida()-1);
        
        this.disableButtons();
    }
    
    public void corrigir(int resp){
        if(this.resp == resp)acertou();  
        else errou();
        
        int moreCoin2 = 0;
        int moreFire2 = 0;
        if(this.moreCoin.getText() != null)moreCoin2 = Integer.parseInt(this.moreCoin.getText());
        if(this.moreFire.getText() != null)moreFire2 = Integer.parseInt(this.moreFire.getText());
        player.setCoin(player.getCoin()+ moreCoin2);
        player.setFire(player.getFire()+ moreFire2);
        
        showButton(next,"NEXT");
    }
    
    public void alteraConfig(){
        if(fase==1){
            ajustaIcons(faseIcon,fase1);
            exitFase.setIcon(images.ajustaIcone(images.returnArrowGreen, exitFase));
       
        }
        
        if(fase==2){
            ajustaIcons(faseIcon,fase2);
            exitFase.setIcon(images.ajustaIcone(images.returnArrowYellow, exitFase));
        }
        
        if(fase==3){
            //this.faseIcon.setIcon(fase3.faseIcon);
            exitFase.setIcon(images.ajustaIcone(images.returnArrowBlue, exitFase));
        }
            //this.faseIcon.setIcon(fase4.faseIcon);
        if(fase==4){
            exitFase.setIcon(images.ajustaIcone(images.returnArrowRed, exitFase));
        }
        
    }
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        gameIcon = new javax.swing.JLabel();
        heartIcon = new javax.swing.JLabel();
        coinIcon = new javax.swing.JLabel();
        fireIcon = new javax.swing.JLabel();
        heartNumber = new javax.swing.JLabel();
        coinNumber = new javax.swing.JLabel();
        moreCoin = new javax.swing.JLabel();
        moreFire = new javax.swing.JLabel();
        fireNumber = new javax.swing.JLabel();
        faseIcon = new javax.swing.JLabel();
        exitFase = new javax.swing.JLabel();
        circle = new javax.swing.JLabel();
        resp0 = new javax.swing.JButton();
        resp1 = new javax.swing.JButton();
        resp2 = new javax.swing.JButton();
        cat = new javax.swing.JLabel();
        next = new javax.swing.JButton();
        background = new javax.swing.JLabel();
        exitButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);
        getContentPane().add(gameIcon);
        gameIcon.setBounds(280, 90, 150, 150);
        getContentPane().add(heartIcon);
        heartIcon.setBounds(610, 20, 30, 30);
        getContentPane().add(coinIcon);
        coinIcon.setBounds(458, 20, 30, 30);
        getContentPane().add(fireIcon);
        fireIcon.setBounds(540, 20, 30, 30);

        heartNumber.setFont(new java.awt.Font("Monospaced", 1, 24)); // NOI18N
        heartNumber.setForeground(new java.awt.Color(255, 51, 51));
        heartNumber.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        heartNumber.setText("0");
        getContentPane().add(heartNumber);
        heartNumber.setBounds(640, 20, 30, 30);

        coinNumber.setFont(new java.awt.Font("Monospaced", 1, 24)); // NOI18N
        coinNumber.setForeground(new java.awt.Color(255, 255, 0));
        coinNumber.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        coinNumber.setText("999");
        getContentPane().add(coinNumber);
        coinNumber.setBounds(493, 20, 42, 30);

        moreCoin.setFont(new java.awt.Font("Monospaced", 1, 24)); // NOI18N
        moreCoin.setForeground(new java.awt.Color(255, 255, 0));
        moreCoin.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(moreCoin);
        moreCoin.setBounds(490, 60, 50, 30);

        moreFire.setFont(new java.awt.Font("Monospaced", 1, 24)); // NOI18N
        moreFire.setForeground(new java.awt.Color(255, 102, 0));
        moreFire.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(moreFire);
        moreFire.setBounds(560, 60, 50, 30);

        fireNumber.setFont(new java.awt.Font("Monospaced", 1, 24)); // NOI18N
        fireNumber.setForeground(new java.awt.Color(255, 102, 0));
        fireNumber.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        fireNumber.setText("1");
        getContentPane().add(fireNumber);
        fireNumber.setBounds(570, 20, 30, 30);
        getContentPane().add(faseIcon);
        faseIcon.setBounds(90, 30, 60, 60);
        getContentPane().add(exitFase);
        exitFase.setBounds(19, 35, 50, 50);
        getContentPane().add(circle);
        circle.setBounds(14, 30, 60, 60);

        resp0.setText("SANDWICHE");
        resp0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resp0ActionPerformed(evt);
            }
        });
        getContentPane().add(resp0);
        resp0.setBounds(100, 310, 120, 40);

        resp1.setText("SANDWICHE");
        resp1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resp1ActionPerformed(evt);
            }
        });
        getContentPane().add(resp1);
        resp1.setBounds(300, 310, 120, 40);

        resp2.setText("SANDWICHE");
        resp2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resp2ActionPerformed(evt);
            }
        });
        getContentPane().add(resp2);
        resp2.setBounds(510, 310, 120, 40);

        cat.setFont(new java.awt.Font("Monospaced", 1, 24)); // NOI18N
        cat.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cat.setText("ANIMAL");
        getContentPane().add(cat);
        cat.setBounds(250, 40, 200, 33);

        next.setText("NEXT");
        next.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextActionPerformed(evt);
            }
        });
        getContentPane().add(next);
        next.setBounds(330, 380, 73, 30);

        background.setFont(new java.awt.Font("Monospaced", 0, 18)); // NOI18N
        getContentPane().add(background);
        background.setBounds(0, 0, 710, 442);

        exitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitButtonActionPerformed(evt);
            }
        });
        getContentPane().add(exitButton);
        exitButton.setBounds(14, 30, 60, 60);

        setSize(new java.awt.Dimension(723, 481));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void resp1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resp1ActionPerformed
        // TODO add your handling code here:
        corrigir(1);
    }//GEN-LAST:event_resp1ActionPerformed

    private void exitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitButtonActionPerformed
        // TODO add your handling code here:
        menu();
    }//GEN-LAST:event_exitButtonActionPerformed

    private void resp0ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resp0ActionPerformed
        // TODO add your handling code here:
        corrigir(0);
    }//GEN-LAST:event_resp0ActionPerformed

    private void resp2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resp2ActionPerformed
        // TODO add your handling code here:
        corrigir(2);
    }//GEN-LAST:event_resp2ActionPerformed

    private void nextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextActionPerformed
        // TODO add your handling code here:
        
        enableButtons();
        ajustaGame();
    }//GEN-LAST:event_nextActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Game.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Game.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Game.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Game.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Game().setVisible(true);
            }
        });
        
    }

    public JButton getResp0() {
        return resp0;
    }

    public void setResp0(JButton resp0) {
        this.resp0 = resp0;
    }

    public JButton getResp1() {
        return resp1;
    }

    public void setResp1(JButton resp1) {
        this.resp1 = resp1;
    }

    public JButton getResp2() {
        return resp2;
    }

    public void setResp2(JButton resp2) {
        this.resp2 = resp2;
    }

    public JLabel getCat() {
        return cat;
    }

    public void setCat(JLabel cat) {
        this.cat = cat;
    }

    public JLabel getGameIcon() {
        return gameIcon;
    }

    public void setGameIcon(JLabel gameIcon) {
        this.gameIcon = gameIcon;
    }

    public JLabel getMoreCoin() {
        return moreCoin;
    }

    public void setMoreCoin(JLabel moreCoin) {
        this.moreCoin = moreCoin;
    }

    public JLabel getMoreFire() {
        return moreFire;
    }

    public void setMoreFire(JLabel moreFire) {
        this.moreFire = moreFire;
    }

    public JLabel getCoinNumber() {
        return coinNumber;
    }

    public void setCoinNumber(JLabel coinNumber) {
        this.coinNumber = coinNumber;
    }

    public JLabel getFireNumber() {
        return fireNumber;
    }

    public void setFireNumber(JLabel fireNumber) {
        this.fireNumber = fireNumber;
    }

    public boolean isTrocouDeFase() {
        return trocouDeFase;
    }

    public void setTrocouDeFase(boolean trocouDeFase) {
        this.trocouDeFase = trocouDeFase;
    }
    
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel background;
    private javax.swing.JLabel cat;
    private javax.swing.JLabel circle;
    private javax.swing.JLabel coinIcon;
    private javax.swing.JLabel coinNumber;
    private javax.swing.JButton exitButton;
    private javax.swing.JLabel exitFase;
    private javax.swing.JLabel faseIcon;
    private javax.swing.JLabel fireIcon;
    private javax.swing.JLabel fireNumber;
    private javax.swing.JLabel gameIcon;
    private javax.swing.JLabel heartIcon;
    private javax.swing.JLabel heartNumber;
    private javax.swing.JLabel moreCoin;
    private javax.swing.JLabel moreFire;
    private javax.swing.JButton next;
    private javax.swing.JButton resp0;
    private javax.swing.JButton resp1;
    private javax.swing.JButton resp2;
    // End of variables declaration//GEN-END:variables

    /**
     * @return the fase
     */
    public int getFase() {
        return fase;
    }

    /**
     * @param fase the fase to set
     */
    public void setFase(int fase) {
        this.fase = fase;
    }

    /**
     * @return the player
     */
    public Player getPlayer() {
        return player;
    }

    /**
     * @param player the player to set
     */
    public void setPlayer(Player player) {
        this.player = player;
    }

    public int getResp() {
        return resp;
    }

    public void setResp(int resp) {
        this.resp = resp;
    }
    
    @Override
    public void run() {
        while(true){
            
            this.fireNumber.setText(""+this.player.getFire());
            this.coinNumber.setText(""+this.player.getCoin());
            this.heartNumber.setText(""+this.player.getVida());
        }
    }
    
    
}
