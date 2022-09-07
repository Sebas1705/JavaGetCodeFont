package com.GraphicsSwing.Frames;

import javax.swing.*;

import com.GraphicsSwing.MyComponents.MyButton;
import com.GraphicsSwing.MyComponents.MyLabel;
import com.GraphicsSwing.MyComponents.PanelWithBackImage;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.net.URI;

public class StarterFrame extends JFrame implements ActionListener{
    
    //Atributes
    private Dimension size;
    private Toolkit tk;
    private Dimension screen;
    private Point location;
    private Color back,foreground;
    private Font title,sub,letter,hiper;
    private GridBagConstraints gbc;
    //End Atributes.
    //Components:
    private JPanel panelSouth,panelCenter,panelInitButtom,panelLinksInicio,panelBackground;
    private JButton initSelButton,linkGithubButton,linkGmailButton,linkCodeWarsButton,linkURJCmailButton;
    private JLabel mainTitle,subTitle;
    //End Components

    //Constructors:
    public StarterFrame(String title,String subTitle){
        initAtributes();
        initComponents(title,subTitle);
        initFrame();
    }
    //End Constructors.

    //Privates Methods:
    private void initAtributes(){
        size=new Dimension(700,800);
        tk=Toolkit.getDefaultToolkit();
        screen=tk.getScreenSize();
        location=new Point((int)(screen.getWidth()/2-size.getWidth()/2),(int)(screen.getHeight()/2-size.getHeight()/2));
        back=new Color(79, 12, 12);
        foreground=new Color(255,255,255);
        title=new Font("Script MT Bold",Font.ITALIC,40);
        sub=new Font("Script MT Bold",Font.BOLD,30);
        letter=new Font("Segoe Print", 0, 30);
        hiper=new Font("Rage Italic",0,20);
        gbc=new GridBagConstraints();
        gbc.fill=GridBagConstraints.BOTH;
    }
    private void initComponents(String titleS,String subTitleS) {
        //PanelBackground:
        panelBackground = new PanelWithBackImage("project/demo/src/main/img/backs/backStarterFrame.png");
        panelBackground.setPreferredSize(size);
        panelBackground.setLayout(new BorderLayout());
            //PanelCenter:
            panelCenter = new JPanel();
            panelCenter.setBackground(back);
            panelCenter.setOpaque(false);
            panelCenter.setLayout(new GridBagLayout());
                //MainTitle:
                mainTitle=new MyLabel(titleS,title,foreground,new Dimension(500,400));
                mainTitle.setVerticalAlignment(JLabel.BOTTOM);
                //End MainTitle.
                //SubTitle:
                subTitle=new MyLabel(subTitleS,sub,foreground,new Dimension(500,200));
                subTitle.setVerticalAlignment(JLabel.TOP);
                //End SubTitle.
            //End PanelCenter.
            //PanelSouth:
            panelSouth = new JPanel();
            panelSouth.setBackground(back);
            panelSouth.setPreferredSize(new Dimension((int)size.getWidth(),200));
            panelSouth.setOpaque(false);
            panelSouth.setLayout(new BoxLayout(panelSouth, BoxLayout.Y_AXIS));
                //PanelBotonInicio:
                panelInitButtom = new JPanel();
                panelInitButtom.setOpaque(false);
                panelInitButtom.setMinimumSize(new Dimension((int)size.getWidth(),75));
                panelInitButtom.setLayout(new FlowLayout());
                    //BotonInicio:
                    initSelButton=new MyButton("  Start  ",letter,foreground,new Dimension(200,75),this);
                    //End BotonInicio.
                //End PanelBotonInicio. 
                //PanelLinksInicio:
                panelLinksInicio = new PanelWithBackImage("project/demo/src/main/img/backs/backPanelSouthStarterFrame");
                panelLinksInicio.setMinimumSize(new Dimension((int)size.getWidth(),100));
                panelLinksInicio.setLayout(new GridLayout(2,2));
                    //LinkGithubButton:
                    linkGithubButton=new MyButton("   Sebas1057",hiper,foreground,null,this);
                    linkGithubButton.setIcon(new ImageIcon(tk.getImage("project/demo/src/main/img/icons/github.png")));
                    linkGithubButton.setOpaque(false);
                    linkGithubButton.setFocusable(false);
                    linkGithubButton.setBorderPainted(false);
                    //End LinkGithubButton.
                    //LinkURJCmailButton:
                    linkURJCmailButton=new MyButton(" sr.entrerrios.2020",hiper,foreground,null,this);
                    linkURJCmailButton.setFocusable(false);
                    linkURJCmailButton.setIcon(new ImageIcon(tk.getImage("project/demo/src/main/img/icons/urjc.png")));
                    linkURJCmailButton.setOpaque(false);
                    linkURJCmailButton.setBorderPainted(false);
                    //End LinkURJCmailButton.
                    //LinkGmailButton:
                    linkGmailButton = new MyButton(" sebssgarcia502580",hiper,foreground,null,this);
                    linkGmailButton.setFocusable(false);
                    linkGmailButton.setIcon(new ImageIcon(tk.getImage("project/demo/src/main/img/icons/gmail.png")));
                    linkGmailButton.setOpaque(false);
                    linkGmailButton.setBorderPainted(false);
                    //End LinkGmailButton.
                    //linkCodeWarsButton:
                    linkCodeWarsButton = new MyButton("  Sebas1705",hiper,foreground,null,this);
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
        gbc.gridx=0;gbc.gridy=0;gbc.gridheight=2;gbc.gridwidth=3;
        panelCenter.add(mainTitle,gbc);
        gbc.gridx=0;gbc.gridy=3;gbc.gridheight=1;gbc.gridwidth=3;
        panelCenter.add(subTitle,gbc);
        panelInitButtom.add(initSelButton);
        panelSouth.add(panelInitButtom);
        panelLinksInicio.add(linkGithubButton);
        panelLinksInicio.add(linkURJCmailButton);
        panelLinksInicio.add(linkGmailButton);
        panelLinksInicio.add(linkCodeWarsButton);
        panelSouth.add(panelLinksInicio);
        panelBackground.add(panelSouth, BorderLayout.SOUTH);
        add(panelBackground);
        //End Adds.
    }
    private void initFrame(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocation(location);
        setIconImage(tk.getImage("project/demo/src/main/img/icons/F_512px.png"));
        setTitle("FontApp");
        setResizable(false);
        setVisible(true);
        pack();
    }
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
            new MainFrame();
            dispose();
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
