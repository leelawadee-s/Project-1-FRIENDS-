package javaapplication99;
import java.applet.Applet;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.geom.Rectangle2D;
import java.net.URL;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.util.Random;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import java.io.*;
import java.util.Scanner;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;
        

public class playstate1 extends JPanel implements ActionListener,KeyListener{
   //playstate1 playstate1; 
   Thread thread;
   public int y=150;//////////////////////
    public int x=10;
        
    
	private final ImageIcon imgstate1 = new ImageIcon(this.getClass().getResource("pp.jpg"));
        private final ImageIcon imgstate11 = new ImageIcon(this.getClass().getResource("level.jpg"));
	private final ImageIcon imgstate2 = new ImageIcon(this.getClass().getResource("lq.jpg"));
        private final ImageIcon imgstate22 = new ImageIcon(this.getClass().getResource("pp.jpg"));
	private final ImageIcon imgme = new ImageIcon(this.getClass().getResource("ff.jpg"));
	private final ImageIcon pause = new ImageIcon(this.getClass().getResource("puse.png"));
	private final ImageIcon resum = new ImageIcon(this.getClass().getResource("resum.png"));
        private final ImageIcon f = new ImageIcon(this.getClass().getResource("JR.png"));
        private final ImageIcon c = new ImageIcon(this.getClass().getResource("COOK.png"));
	
	Me m = new Me();
        
        
        
	homegames hg = new homegames();
	ImageIcon feildover = new ImageIcon(this.getClass().getResource("55.jpg"));
	
	ImageIcon exitover = new ImageIcon(this.getClass().getResource("exit.jpg"));
	ImageIcon restart = new ImageIcon(this.getClass().getResource("start.jpg"));
        JButton BStartover = new JButton(restart);
	JButton BExitover  = new JButton(exitover);
        
        
	
	public JLabel score = new JLabel(); 
        public JButton BPause  = new JButton(pause);
	
	public JButton Bresum  = new JButton(resum);
	public ArrayList<Me> Me = new ArrayList<Me>();
	public ArrayList<ball1> ba1 = new ArrayList<ball1>();
	public ArrayList<ball2> ba2 = new ArrayList<ball2>();
        public ArrayList<ball3> ba3 = new ArrayList<ball3>();
         public ArrayList<ball4> ba4 = new ArrayList<ball4>();
	public ArrayList<ball5> ba5 = new ArrayList<ball5>();
        
	public int times ;
	public int rs1 = 1;
	public int rs2 = 2;
	boolean timestart = true;
	boolean startball = false;
	
	private gameover gover = new gameover();
	public int scor = 0;
	boolean paralyze1 = false;
	int time_paralyze=5;
        public void start( ) {
            
            thread.start( );						
        }
	
	Thread time = new Thread(new Runnable(){
            
        public void run(){
			while(true){
				try{
					Thread.sleep(20);
				}catch(Exception e){
					
				}
				if(timestart == false){
				repaint();
				}
			}
		}
	});
	
	Thread actor = new Thread(new Runnable(){
            public void run(){
		while(true){
                	try{
                            Thread.sleep(1);
			}catch(Exception e){}
                            repaint();
		}
            }
	});
	Thread tballs1 = new Thread(new Runnable(){
            public void run() {
                while(true){
                	try{
                            if(startball == false){
				Thread.sleep((long)(Math.random()*10000)+2000);
                            }
			}catch(InterruptedException e){
                            e.printStackTrace();
			}
			if(startball == false){
                            ba1.add(new ball1());
			}
		}
            }
	});
        public void update(Graphics g) {
            paint(g);
	}
	Thread tballs2 = new Thread(new Runnable(){
            public void run() {
		while(true){
			try{
                            if(startball==false){
				Thread.sleep((long)(Math.random()*10000)+2000);
                            }
			}catch(InterruptedException e){
                            e.printStackTrace();
			}
			if(startball == false){
                            ba2.add(new ball2());
			}
		}
            }
	});
        Thread tballs3 = new Thread(new Runnable(){
            public void run() {
		while(true){
			try{
                            if(startball==false){
				Thread.sleep((long)(Math.random()*10000)+2000);
                            }
			}catch(InterruptedException e){
                            e.printStackTrace();
			}
			if(startball == false){
                            ba3.add(new ball3());
			}
		}
            }
	});
        
        Thread tballs4 = new Thread(new Runnable(){
            public void run() {
		while(true){
			try{
                            if(startball==false){
				Thread.sleep((long)(Math.random()*10000)+2000);
                            }
			}catch(InterruptedException e){
                            e.printStackTrace();
			}
			if(startball == false){
                            ba4.add(new ball4());
			}
		}
            }
	});
	
	Thread tballs5 = new Thread(new Runnable(){
            public void run() {
            	while(true){
			try{
                            if(startball==false){
                                Thread.sleep((long)(Math.random()*10000)+2000);
                            }
			}catch(InterruptedException e){
                            e.printStackTrace();
			}
			if(startball == false){
                            ba5.add(new ball5());
			}
		}
            }
	});
	Thread paralyze = new Thread(new Runnable(){
            public void run(){
		while (true){
			if(time_paralyze < 1){
                            paralyze1 = false;
                            time_paralyze = 5;
			}
			try{
                            Thread.sleep(5000);
			}catch(InterruptedException e){e.printStackTrace();}
		}
            } 
	});
        Thread t = new Thread(new Runnable(){
            public void run() {
		while(true){
                	if(timestart == false){
                            times = (times-1) ;
                            if(paralyze1){
				time_paralyze--;
                            }
			}
			try{
                            Thread.sleep(1000);
			}catch(InterruptedException e)
			{
                            e.printStackTrace();
			}
		}
            }
	});
	
	playstate1(){
		this.setFocusable(true);
		this.setLayout(null);
		BPause.setBounds(910,20,40,40);//910 20
		
		Bresum.setBounds(910,65, 40,40);
                //this.setLayout(null);
                //g.drawImage(f.getImage(), 0, 0, 100, 100, this);
		BPause.addActionListener(this);
		
		Bresum.addActionListener(this);
		
		this.add(BPause);
		
		this.add(score);
		this.add(Bresum);
		
		this.addKeyListener(new KeyAdapter(){
                    public void keyPressed(KeyEvent e){
                        
                        int a = e.getKeyCode();
			if(!paralyze1){
                            
			    if(a==KeyEvent.VK_LEFT){
			     	m.x-=10;
                                m.count++;
                               // m.count=5;
			       Me.add(new Me(m.x,m.y));
                            }
                            else if(a == KeyEvent.VK_RIGHT){
                              m.x+=10;
                               m.count++;
                              
                               Me.add(new Me(m.x,m.y));
                            }
                            else if(a == KeyEvent.VK_DOWN){
                               //m.x-=10;
                               m.y+=10;///////////////////////
                               m.count++;
                              // m.count=5;
                               Me.add(new Me(m.y,m.x));
                               
                            }
                             
                          
                            else if(a == KeyEvent.VK_UP){
                                //m.x+=10;
                                m.y-=10;
                               m.count++;
                              
                              Me.add(new Me(m.y,m.x));
			    }
			}
                    }
                    public void keyReleased(KeyEvent e){
			m.count=0;
		    }
		});
		
		m.x = 600;
                m.y = 400;
		time.start();
		actor.start();
		t.start();
		tballs1.start();
		tballs2.start();
                tballs3.start();
                tballs4.start();
		tballs5.start();
		paralyze.start();
	}
	
	
	
	public void paintComponent(Graphics g){
            super.paintComponent(g);
            if(times <= 70 ){
                this.remove(BPause);
                this.remove(Bresum);
                
                //this.setLayout(null);
                //g.drawImage(f.getImage(), 0, 0, 100, 100, this);
		g.setColor(Color.white);
                g.setFont(new Font("Hobo Std",Font.HANGING_BASELINE,70));		
                g.drawString("SCORE   "+scor,360,250);
                
                this.setLayout(null);
                g.drawImage(imgme.getImage(), 0, 0, 990, 700, this);//990  700
                g.setColor(Color.white);
                g.setFont(new Font("Hobo Std",Font.HANGING_BASELINE,70));
                g.drawString("END GAME",300,300);
                
                
		g.setColor(Color.white);
                g.setFont(new Font("Hobo Std",Font.HANGING_BASELINE,70));		
                g.drawString("SCORE   "+scor,300,400);
                
		
                
                
                
            }else if(times <= 80){
                //พื่นหลัง2
                g.drawImage(imgstate22.getImage(),0,0,985,125,this);
                g.drawImage(imgstate2.getImage(),0,125,1000,800,this);
                //this.setLayout(null);
                //g.drawImage(f.getImage(),800,590,110,110,this);//0,125,1000,800
                //g.drawImage(c.getImage(),715,590,110,110,this);
                if(paralyze1){
                    g.setColor(Color.WHITE);
                    g.setFont(new Font("Hobo Std",Font.BOLD,50));
                   
                }else{
                    g.drawImage(m.im[m.count].getImage(), m.x,m.y,/* 550,*/100,100, this);
                }
   		if(m.x<0){
                    m.x=this.getWidth()-10;
		}
		if(m.x>this.getWidth()){
                    m.x=20;
		}
                if(m.y<0){
                    m.y=this.getHeight()-10;
		}
		if(m.y>this.getHeight()){
                    m.y=20;
		}
                
   		
 		//===========friends1================
		for(int i=0 ; i<ba1.size();i++){
                    g.drawImage( ba1.get(i).getImage() ,ba1.get(i).getX(),ba1.get(i).getY(),100,100,this);
		}
                for(int i=0 ; i<Me.size();i++){
		    for(int j=0 ; j<ba1.size();j++){
		    	if(Intersect(Me.get(i).getbound(),ba1.get(j).getbound())){
                            scor += 30;
			    ba1.remove(j);
                          
			    g.drawString("+10",m.x+100,650);
			} 
		    }
		}
              
		//===========friends2================
		for(int i=0 ; i<ba2.size();i++){
                    g.drawImage(ba2.get(i).getImage(),ba2.get(i).getX(),ba2.get(i).getY(),100,100,this);
		}
                for(int i=0 ; i<Me.size();i++){
		    for(int j=0 ; j<ba2.size();j++){
		    	if(Intersect(Me.get(i).getbound(),ba2.get(j).getbound())){
                            scor += 30;
			    ba2.remove(j);
                           
			    g.drawString("+10",m.x+100,650);
			} 
		    }
		}
		
                //===========friends3================
		for(int i=0 ; i<ba3.size();i++){
                    g.drawImage(ba3.get(i).getImage(),ba3.get(i).getX(),ba3.get(i).getY(),100,100,this);
		}
                for(int i=0 ; i<Me.size();i++){
		    for(int j=0 ; j<ba3.size();j++){
		    	if(Intersect(Me.get(i).getbound(),ba3.get(j).getbound())){
                          
                             ba3.remove(j);
			     scor += 30;
			    g.drawString("+10",m.x+100,650);
			} 
		    }
		}
		
                //===========friends4================
		for(int i=0 ; i<ba4.size();i++){
                    g.drawImage(ba4.get(i).getImage(),ba4.get(i).getX(),ba4.get(i).getY(),100,100,this);
		}
                for(int i=0 ; i<Me.size();i++){
		    for(int j=0 ; j<ba4.size();j++){
		    	if(Intersect(Me.get(i).getbound(),ba4.get(j).getbound())){
                            scor += 30;
			    ba4.remove(j);
                          
			    g.drawString("+10",m.x+100,650);
			} 
		    }
		}
		
		
		//===========friends5================
		for(int i=0 ; i<ba5.size();i++){
		    g.drawImage(ba5.get(i).getImage(),ba5.get(i).getX(),ba5.get(i).getY(),60,60,this);
		}
                for(int i=0 ; i<Me.size();i++){
		    for(int j=0 ; j<ba5.size();j++){
		    	if(Intersect(Me.get(i).getbound(),ba5.get(j).getbound())){
                            scor -= 10;
			    ba5.remove(j);
                           
			    g.drawString("+10",m.x+100,650);
			} 
		    }
		}
		     
		g.setFont(new Font("Hobo Std",Font.HANGING_BASELINE,20));
		g.setColor(Color.WHITE);
		g.drawString("SCORE =  "+scor,40,100);	     
		
		g.drawString("STATE "+rs2,40,50); 
               
		g.drawString("Time "+times,180,100);
		
		      
            }else if(times <= 0 ){
		this.remove(BPause);
		this.remove(Bresum);
		
                this.setLayout(null);
                g.drawImage(feildover.getImage(),0,0,1000,800,this);
                g.setColor(Color.white);
                g.setFont(new Font("Hobo Std",Font.HANGING_BASELINE,40));		
		g.drawString("SCORE   "+scor,380,200);	     
		g.setFont(new Font("Hobo Std",Font.HANGING_BASELINE,70));
		g.drawString("GAME OVER",290,150);
		g.drawImage(imgme.getImage(), 580, 370, 400, 400, this);//580 360
            }else{
                //เปลี่ยนรูปพื้นหลัง 1
                g.drawImage(imgstate11.getImage(),0,125,1000,800,this);//0,125,1000,800
                g.drawImage(imgstate1.getImage(),0,0,985,125,this); //0,0,985,125
                //this.setLayout(null);
                //g.drawImage(f.getImage(),800,590,110,110,this);//0,125,1000,800
                //g.drawImage(c.getImage(),715,590,110,110,this);
                if(paralyze1){
                    g.setColor(Color.white);
                    
                }else{
                    g.drawImage(m.im[m.count].getImage(), m.x,m.y, /*550,*/100,100, this);/*110,160*/
                }
		if(m.x<0){
                    m.x=this.getWidth()-10;
		}
		if(m.x>this.getWidth()){
                    m.x=20;
		}
                if(m.y<0){
                    m.y=this.getHeight()-10;
		}
		if(m.y>this.getHeight()){
                    m.y=20;
		}
		
		  
		//========================================friends1================= 
                for(int i=0 ; i<ba1.size();i++){
                    g.drawImage(ba1.get(i).getImage(),ba1.get(i).getX(),ba1.get(i).getY(),100,100,this);
 		}
		for(int i=0 ; i<Me.size();i++){
		    for(int j=0 ; j<ba1.size();j++){
		    	if(Intersect(Me.get(i).getbound(),ba1.get(j).getbound())){
                            scor += 30;
			    ba1.remove(j);
                          
			    g.drawString("+10",m.x+100,650);
			} 
		    }
		}
		//========================friends2=========================
		for(int i=0 ; i<ba2.size();i++){
		    g.drawImage(ba2.get(i).getImage(),ba2.get(i).getX(),ba2.get(i).getY(),100,100,this);
		 }
		for(int i=0 ; i<Me.size();i++){
		    for(int j=0 ; j<ba2.size();j++){
		    	if(Intersect(Me.get(i).getbound(),ba1.get(j).getbound())){
                            scor += 30;
			    ba2.remove(j);
                          
			    g.drawString("+10",m.x+100,650);
			} 
		    }
		}
                //========================friends3=========================
		for(int i=0 ; i<ba3.size();i++){
		    g.drawImage(ba3.get(i).getImage(),ba3.get(i).getX(),ba3.get(i).getY(),100,100,this);
		 }
		for(int i=0 ; i<Me.size();i++){
		    for(int j=0 ; j<ba3.size();j++){
		    	if(Intersect(Me.get(i).getbound(),ba3.get(j).getbound())){
                            
                             ba3.remove(j);
			     scor += 30;
			    g.drawString("+10",m.x+100,650);
			} 
		    }
		}
                //========================friends4=========================
		for(int i=0 ; i<ba4.size();i++){
		    g.drawImage(ba4.get(i).getImage(),ba4.get(i).getX(),ba4.get(i).getY(),100,100,this);
		 }
		for(int i=0 ; i<Me.size();i++){
		    for(int j=0 ; j<ba4.size();j++){
		    	if(Intersect(Me.get(i).getbound(),ba4.get(j).getbound())){
                            scor += 30;
			    ba4.remove(j);
                           
			    g.drawString("+10",m.x+100,650);
			} 
		    }
		}
		//=================================apple=============
		for(int i=0 ; i<ba5.size();i++){
		    g.drawImage(ba5.get(i).getImage(),ba5.get(i).getX(),ba5.get(i).getY(),60,60,this);
		}
		
                for(int i=0 ; i<Me.size();i++){
		    for(int j=0 ; j<ba5.size();j++){
		    	if(Intersect(Me.get(i).getbound(),ba5.get(j).getbound())){
                            scor -= 10;                          
			    ba5.remove(j);
                            
			    g.drawString("+10",m.x+100,650);
			} 
		    }
		}
		g.setFont(new Font("Hobo Std",Font.HANGING_BASELINE,20));
		g.setColor(Color.white);
		g.drawString("SCORE =  "+scor,40,100);	     
		g.setFont(new Font("Hobo Std",Font.HANGING_BASELINE,30));
		g.drawString("STATE "+rs1,40,50);
                g.setFont(new Font("Hobo Std",Font.HANGING_BASELINE,20));
		g.drawString("Time "+times,180,100);//180 100
		
		      
	    }

	}

	public boolean Intersect(Rectangle2D a, Rectangle2D b){
		return (a.intersects(b));
	}
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()== BStartover){		
                    this.setSize(1000,800);
                    this.add(hg);
                    this.setLocation(null);
                    timestart = true;
                    startball = true;
		}else if(e.getSource() == BExitover){
                    System.exit(0);
		}		
	}
public void stop( )	{
            thread = null;						
	}



        
        
    @Override
    public void keyTyped(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyPressed(KeyEvent e) {
        
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    

    @Override
    public void keyReleased(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void add(int score) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
