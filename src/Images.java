
import java.util.ArrayList;
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
public class Images {

   
    
    
        //Icones principais
        final ImageIcon chapter1Icon = new ImageIcon("src/SPRITES/Chapter/DINO 1.png");
        final ImageIcon chapter2Icon = new ImageIcon("src/SPRITES/Chapter/DINO 2.png");
        final ImageIcon chapter2IconBlock = new ImageIcon("src/SPRITES/Chapter/DINO 2 - DARK.png");
        final ImageIcon chapter3Icon = new ImageIcon("src/SPRITES/Chapter/DINO 3.png");
        final ImageIcon chapter3IconBlock = new ImageIcon("src/SPRITES/Chapter/DINO 3 - DARK.png");
        final ImageIcon chapter4Icon = new ImageIcon("src/SPRITES/Chapter/DINO 4.png");
        final ImageIcon chapter4IconBlock = new ImageIcon("src/SPRITES/Chapter/DINO 4 - DARK.png");
        
        //Players icones
        final ImageIcon coin = new ImageIcon("src/SPRITES/Player/coin.png");
        final ImageIcon fire = new ImageIcon("src/SPRITES/Player/fire.png");
        final ImageIcon heart = new ImageIcon("src/SPRITES/Player/heart.png"); 
        
        //Buttons icones
        final ImageIcon buttonIcone = new ImageIcon("src/SPRITES/Player/search.png");
       
        //icones categorias
        final ImageIcon chapter1icons = new ImageIcon("src/SPRITES/Chapter/FIRST CHAPTER - THEMES_2.png");
        final ImageIcon chapter2icons = new ImageIcon("src/SPRITES/Chapter/SECOND CHAPTER.png");
        
        //FASE 1 
        
        //BackGround
        final ImageIcon fase1Background = new ImageIcon("src/SPRITES/Chapter/fase1Background.jpeg");
        
        //animals
        final ImageIcon cat = new ImageIcon("src/SPRITES/Animals/cat.png");
        final ImageIcon cow = new ImageIcon("src/SPRITES/Animals/cow.png");
        final ImageIcon dog = new ImageIcon("src/SPRITES/Animals/dog.png");
        final ImageIcon elephant = new ImageIcon("src/SPRITES/Animals/elephant.png");
        final ImageIcon fox = new ImageIcon("src/SPRITES/Animals/fox.png");
        final ImageIcon lion = new ImageIcon("src/SPRITES/Animals/lion.png");
        final ImageIcon monkey = new ImageIcon("src/SPRITES/Animals/monkey.png");
        final ImageIcon mouse = new ImageIcon("src/SPRITES/Animals/mouse.png");
        final ImageIcon owl = new ImageIcon("src/SPRITES/Animals/owl.png");
        final ImageIcon panda = new ImageIcon("src/SPRITES/Animals/panda.png");
        final ImageIcon pig = new ImageIcon("src/SPRITES/Animals/pig.png");
        final ImageIcon turtle = new ImageIcon("src/SPRITES/Animals/turtle.png");
        final ImageIcon[] animals = {elephant,lion,monkey,panda,fox,pig
                                        ,owl,turtle,dog,cat,cow,mouse};
        
        //foods
        final ImageIcon apple = new ImageIcon("src/SPRITES/Foods/apple.png");
        final ImageIcon cake = new ImageIcon("src/SPRITES/Foods/cake.png");
        final ImageIcon cheese = new ImageIcon("src/SPRITES/Foods/cheese.png");
        final ImageIcon chocolate = new ImageIcon("src/SPRITES/Foods/chocolate.png");
        final ImageIcon egg = new ImageIcon("src/SPRITES/Foods/egg.png");
        final ImageIcon grape = new ImageIcon("src/SPRITES/Foods/grape.png");
        final ImageIcon hamburger = new ImageIcon("src/SPRITES/Foods/hamburguer.png");
        final ImageIcon iceCream = new ImageIcon("src/SPRITES/Foods/ice cream.png");
        final ImageIcon orange = new ImageIcon("src/SPRITES/Foods/orange.png");
        final ImageIcon pineapple = new ImageIcon("src/SPRITES/Foods/pineapple.png");
        final ImageIcon pizza = new ImageIcon("src/SPRITES/Foods/pizza.png");
        final ImageIcon watermelon = new ImageIcon("src/SPRITES/Foods/watermelon.png");
        final ImageIcon[]foods = {cake,egg,pizza,orange,watermelon,chocolate,pineapple,iceCream
                                 ,hamburger,apple,grape,cheese}; 
        
        //colors
        final ImageIcon black = new ImageIcon("src/SPRITES/Color/black.png");
        final ImageIcon blue = new ImageIcon("src/SPRITES/Color/blue.png");
        final ImageIcon green = new ImageIcon("src/SPRITES/Color/green.png");
        final ImageIcon orangeColor = new ImageIcon("src/SPRITES/Color/orange.png");
        final ImageIcon pink = new ImageIcon("src/SPRITES/Color/pink.png");
        final ImageIcon purple = new ImageIcon("src/SPRITES/Color/purple.png");
        final ImageIcon red = new ImageIcon("src/SPRITES/Color/red.png");
        final ImageIcon white = new ImageIcon("src/SPRITES/Color/white.png");
        final ImageIcon yellow = new ImageIcon("src/SPRITES/Color/yellow.png");
        final ImageIcon[] colors = {yellow,green,red,blue,purple,black,white,orangeColor,pink};
        
        //Fase 2
        
        //city
        final ImageIcon airport = new ImageIcon("src/SPRITES/City/airport.png");
        final ImageIcon bank = new ImageIcon("src/SPRITES/City/bank.png");
        final ImageIcon car = new ImageIcon("src/SPRITES/City/car.png");
        final ImageIcon church = new ImageIcon("src/SPRITES/City/church.png");
        final ImageIcon harbor = new ImageIcon("src/SPRITES/City/harbor.png");
        final ImageIcon hospital = new ImageIcon("src/SPRITES/City/hospital.png");
        final ImageIcon motorcycle = new ImageIcon("src/SPRITES/City/motorcycle.png");
        final ImageIcon ship = new ImageIcon("src/SPRITES/City/ship.png");
        final ImageIcon[] city = {ship,bank,car,hospital,harbor,church,motorcycle,airport};
        
        //objects
        final ImageIcon bath = new ImageIcon("src/SPRITES/Objects/bath.png");
        final ImageIcon bed = new ImageIcon("src/SPRITES/Objects/bed.png");
        final ImageIcon blender = new ImageIcon("src/SPRITES/Objects/blender.png");
        final ImageIcon chair = new ImageIcon("src/SPRITES/Objects/chair.png");
        final ImageIcon door = new ImageIcon("src/SPRITES/Objects/door.png");
        final ImageIcon key = new ImageIcon("src/SPRITES/Objects/key.png");
        final ImageIcon mirror = new ImageIcon("src/SPRITES/Objects/mirror.png");
        final ImageIcon sofa = new ImageIcon("src/SPRITES/Objects/sofa.png");
        final ImageIcon tv = new ImageIcon("src/SPRITES/Objects/tv.png");
        final ImageIcon[] objects = {mirror,bed,bath,key,blender,door,tv,chair,sofa};
        
        //humanParts
        final ImageIcon arm = new ImageIcon("src/SPRITES/HumanParts/arm.png");
        final ImageIcon ear = new ImageIcon("src/SPRITES/HumanParts/ear.png");
        final ImageIcon feet = new ImageIcon("src/SPRITES/HumanParts/feet.png");
        final ImageIcon heartPart = new ImageIcon("src/SPRITES/HumanParts/heart.png");
        final ImageIcon leg = new ImageIcon("src/SPRITES/HumanParts/leg.png");
        final ImageIcon mouth = new ImageIcon("src/SPRITES/HumanParts/mouth.png");
        final ImageIcon nose = new ImageIcon("src/SPRITES/HumanParts/nose.png");
        final ImageIcon[] humanParts = {feet,nose,mouth,leg,arm,heartPart,ear};
        
        
        
        //background
        final ImageIcon fase2Background = new ImageIcon("src/SPRITES/Chapter/fase2Background.jpeg");
        
        //Fase 3
        
        //background
        final ImageIcon fase3Background = new ImageIcon("src/SPRITES/Chapter/fase3Background.jpeg");
        
        //Fase 4
        
        //background
        final ImageIcon fase4Background = new ImageIcon("src/SPRITES/Chapter/fase4Background.jpeg");
        
        //Others
        final ImageIcon returnArrowGreen = new ImageIcon("src/SPRITES/Chapter/returnArrowGreen.png");
        final ImageIcon returnArrowYellow = new ImageIcon("src/SPRITES/Chapter/returnArrowYellow.png");
        final ImageIcon returnArrowBlue = new ImageIcon("src/SPRITES/Chapter/returnArrowBlue.png");
        final ImageIcon returnArrowRed = new ImageIcon("src/SPRITES/Chapter/returnArrowRed.png");
        final ImageIcon circle = new ImageIcon("src/SPRITES/Chapter/circle.png");
        
        
        
        
        
         
        
        
        
    
    
    //Classes com sobrecarga para ajustar imagens
    public ImageIcon ajustaIcone(ImageIcon icon, javax.swing.JLabel label){
        ImageIcon icon2 = new ImageIcon();
        icon2.setImage(icon.getImage().getScaledInstance(
                label.getWidth(),
                label.getHeight(),
                1));
        return icon2;
    }
    
    public ImageIcon ajustaIcone(ImageIcon icon, javax.swing.JButton button){
        ImageIcon icon2 = new ImageIcon();
        icon2.setImage(icon.getImage().getScaledInstance(
                button.getWidth(),
                button.getHeight(),
                1));
        return icon2;
    }
    
    
}
