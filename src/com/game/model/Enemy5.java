package com.game.model;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import com.game.view.BaseFrame;
import com.game.view.MyPanel;

public class Enemy5 extends Enemy{

    public Enemy5(MyPanel myPanel) {
        super(myPanel);
        // TODO Auto-generated constructor stub

        this.width = 138;
        this.height = 130;
        this.hp = 5;

        this.x = (int) (Math.random()*(BaseFrame.frameWidth - this.width));
        this.y = - this.height;

        this.image = Toolkit.getDefaultToolkit().getImage("src/images/enemy5.png");

        this.items=new Item[] {
                new Item001(myPanel),
                new Item001(myPanel),
                new Item001(myPanel)
        };
    }




    //敌机爆炸效果，放在放到数组中
    public Image[] dieImages = new Image[] {
            Toolkit.getDefaultToolkit().getImage("src/images/enemy5_down1.png"),
            Toolkit.getDefaultToolkit().getImage("src/images/enemy5_down2.png"),
            Toolkit.getDefaultToolkit().getImage("src/images/enemy5_down3.png"),
            Toolkit.getDefaultToolkit().getImage("src/images/enemy5_down4.png"),
    };

    //存放当前图片的下标
    public int imageIndex = 0;

    //画敌机
    public void drawSelf(Graphics g) {
        //判断敌机是否被击中
        if(hp>0) {
            g.drawImage(this.image,x,y,width,height,null);
            g.drawImage(this.dieImages[imageIndex],x,y,width,height,null);


            //被打中


            //每隔10毫秒切换一张图片
            if(this.myPanel.timer%500==0) {
                imageIndex++;
                while (imageIndex==4){
                    imageIndex=0;
                }
                if(imageIndex>=this.dieImages.length) {
                    //敌机死了
                }

            }
        }

        //敌机向下移动,如果敌机出界就销毁
        if(this.myPanel.timer%35==0) {
            y=y+10;
            if(y>=BaseFrame.frameHeight) {
                killed();
            }
        }
    }

}



