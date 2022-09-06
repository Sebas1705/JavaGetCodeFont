package com.GraphicsSwing.Frames;

import javax.swing.*;
import javax.swing.event.*;


import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.net.URI;

public class StarterFrame extends JFrame implements ActionListener{
    
    private Dimension size = new Dimension(700,800);
    private Toolkit tk = Toolkit.getDefaultToolkit();
    private Dimension screen = tk.getScreenSize();
    private Point location  = new Point((int)(screen.getWidth()/2-size.getWidth()/2),(int)(screen.getHeight()/2-size.getHeight()/2));
    private Color back = new Color(79, 12, 12),foreground = new Color(255,255,255);
    private Font letter = new Font("Segoe Print", 0, 30), hiper = new Font("Rage Italic",0,20);
    //Componentes:
    private JPanel panelSouth,panelCenter,panelInitButtom,panelLinksInicio,panelBackground;
    private JButton initSelButton,linkGithubButton,linkGmailButton,linkCodeWarsButton,linkURJCmailButton;

    public StarterFrame(){
        initComponents();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocation(location);
        setSize(size);
        setIconImage(tk.getImage("project/demo/src/main/img/icons/tic-tac-toe.png"));
        setTitle("Ventana de Inicio");
        setResizable(false);
        setVisible(true);
    }

    
    private void initComponents() {
        //PanelBackground:
        panelBackground = new PanelWithBackImage("project/demo/src/main/img/backgrounds/backStarterFrame.png");
        panelBackground.setBounds(0,0,(int)size.getWidth(),(int)size.getHeight());
        panelBackground.setLayout(new BorderLayout());
            //PanelCenter:
            panelCenter = new JPanel();
            panelCenter.setBackground(back);
            panelCenter.setOpaque(false);
            //End PanelCenter.
            //PanelSouth:
            panelSouth = new JPanel();
            panelSouth.setBackground(back);
            panelSouth.setPreferredSize(new Dimension((int)size.getWidth(),175));
            panelSouth.setOpaque(false);
            panelSouth.setLayout(new BoxLayout(panelSouth, BoxLayout.Y_AXIS));
                //PanelBotonInicio:
                panelInitButtom = new JPanel();
                panelInitButtom.setOpaque(false);
                panelInitButtom.setMinimumSize(new Dimension((int)size.getWidth(),75));
                panelInitButtom.setLayout(new FlowLayout());
                    //BotonInicio:
                    initSelButton=new MyButton("  Seleccion de app  ",letter,foreground,new Dimension(200,75),this);
                    //End BotonInicio.
                //End PanelBotonInicio. 
                //PanelLinksInicio:
                panelLinksInicio = new PanelWithBackImage("project/demo/src/main/img/backgrounds/backPanelSouthStarterFrame");
                panelLinksInicio.setMinimumSize(new Dimension((int)size.getWidth(),100));
                panelLinksInicio.setLayout(new GridLayout(2,2));
                    //LinkGithubButton:
                    linkGithubButton=new MyButton("   Sebas1057",hiper,foreground,null,this);
                    linkGithubButton.setAlignmentX(JButton.LEFT_ALIGNMENT);
                    linkGithubButton.setIcon(new ImageIcon(tk.getImage("project/demo/src/main/img/icons/github.png")));
                    linkGithubButton.setOpaque(false);
                    linkGithubButton.setFocusable(false);
                    linkGithubButton.setBorderPainted(false);
                    //End LinkGithubButton.
                    //LinkURJCmailButton:
                    linkURJCmailButton=new MyButton(" sr.entrerrios.2020",hiper,foreground,null,this);
                    linkURJCmailButton.setAlignmentX(JButton.LEFT_ALIGNMENT);
                    linkURJCmailButton.setFocusable(false);
                    linkURJCmailButton.setIcon(new ImageIcon(tk.getImage("project/demo/src/main/img/icons/urjc.png")));
                    linkURJCmailButton.setOpaque(false);
                    linkURJCmailButton.setBorderPainted(false);
                    //End LinkURJCmailButton.
                    //LinkGmailButton:
                    linkGmailButton = new MyButton(" sebssgarcia502580",hiper,foreground,null,this);
                    linkGmailButton.setAlignmentX(JButton.LEFT_ALIGNMENT);
                    linkGmailButton.setFocusable(false);
                    linkGmailButton.setIcon(new ImageIcon(tk.getImage("project/demo/src/main/img/icons/gmail.png")));
                    linkGmailButton.setOpaque(false);
                    linkGmailButton.setBorderPainted(false);
                    //End LinkGmailButton.
                    //linkCodeWarsButton:
                    linkCodeWarsButton = new MyButton("  Sebas1705",hiper,foreground,null,this);
                    linkCodeWarsButton.setAlignmentX(JButton.LEFT_ALIGNMENT);
                    linkCodeWarsButton.setIcon(new ImageIcon(tk.getImage("project/demo/src/main/img/icons/codewars.png")));
                    linkCodeWarsButton.setOpaque(false);
                    linkCodeWarsButton.setFocusable(false);
                    linkCodeWarsButton.setBorderPainted(false);
                    //End LinkCodeWarsButton.
                //End PanelLinksInicio.
            //End PanelSouth
        //End PanelBackground.
        //Adds:
        panelBackground.add(panelCenter,BorderLayout.CENTER);
        panelInitButtom.add(initSelButton);
        panelSouth.add(panelInitButtom);
        panelLinksInicio.add(linkGithubButton);
        panelLinksInicio.add(linkURJCmailButton);
        panelLinksInicio.add(linkGmailButton);
        panelLinksInicio.add(linkCodeWarsButton);
        panelSouth.add(panelLinksInicio);
        panelBackground.add(panelSouth, BorderLayout.SOUTH);
        this.add(panelBackground);
        //End Adds.
    }

    //Private Methods:
    private void openLink(URI uri) throws IOException{
        Desktop.getDesktop().browse(uri);
    }
    private void openEmail(String email) throws IOException{
        URI uri = URI.create("mailto:"+email);
        Desktop.getDesktop().mail(uri);
    }
    //End private Methods.

    //Public Methods:
    public Font getLetter(){return letter;}
    //End Public Methods.

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==initSelButton){
            setVisible(false);
            new SelectFrame(this);
        }else if(e.getSource()==linkGithubButton){
            try {
                openLink(new URI("https://github.com/Sebas1705"));
            } catch (Exception e1) {
                String message="The URI just failed or your browse can't open it.\n"+"Message error: "+e1.getMessage(); 
                JOptionPane.showMessageDialog(this,message,"Link Error", JOptionPane.ERROR_MESSAGE);
            }
        }else if(e.getSource()==linkURJCmailButton){
            try {
                openEmail("sr.entrerrios.2020@alumnos.urjc.es");
            } catch (Exception e1) {
                String message="The email couldn't be opened.\n"+"Message error: "+e1.getMessage(); 
                JOptionPane.showMessageDialog(this,message,"Link Error", JOptionPane.ERROR_MESSAGE);
            }
        }else if(e.getSource()==linkGmailButton){
            try {
                openEmail("sebssgarcia502580@gmail.com");
            } catch (Exception e1) {
                String message="The email couldn't be opened.\n"+"Message error: "+e1.getMessage(); 
                JOptionPane.showMessageDialog(this,message,"Link Error", JOptionPane.ERROR_MESSAGE);
            }
        }else if(e.getSource()==linkCodeWarsButton){
            try {
                openLink(new URI("https://www.codewars.com/users/Sebas1705"));
            } catch (Exception e1) {
                String message="The URI just failed or your browse can't open it.\n"+"Message error: "+e1.getMessage(); 
                JOptionPane.showMessageDialog(this,message,"Link Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
