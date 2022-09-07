package com.GraphicsSwing.Frames;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.event.*;

import com.GraphicsSwing.Components.*;
import com.Launcher.FontDesktop;

public class MainFrame extends JFrame{
    
    //Atributes:
    private Dimension size;
    private FontDesktop fonts;
    private Toolkit tk;
    private Dimension screen;
    private Point location;
    private Font letter,title,actual;
    private Color foreground;
    private GridBagConstraints gbc;
    //End Atributes.

    //Components:
    private JPanel panelBack,panelRadio,panelArea;
    private JLabel labelLetter,labelType,labelFont,labelTitle;
    private JRadioButton radioItalic,radioPlain,radioBold;
    private ButtonGroup group;
    private JSlider tamSlider;
    private JTextArea writeArea;
    private JComboBox<String> listFonts;
    private JTextField fontCode;
    //End Components:

    //Constructors:
    public MainFrame() {
        initAtributes();
        initComponents();
        initFrame();
    }
    //End Constructors.

    //Private Methods:
    private void initAtributes(){
        size=new Dimension(600,600);
        fonts=new FontDesktop();
        tk=Toolkit.getDefaultToolkit();
        screen=tk.getScreenSize();
        location=new Point((int)(screen.getWidth()/2-size.getWidth()/2),(int)(screen.getHeight()/2-size.getHeight()/2));
        letter=new Font("Segoe Print", 0, 15);
        title=new Font("Segoe Print", 0, 30);
        actual=new Font("Agency FB",Font.PLAIN,20);
        foreground=new Color(255,255,255);
        gbc=new GridBagConstraints();
    }
    private void initComponents(){
        //PanelBack:
        panelBack=new PanelWithBackImage("project/demo/src/main/img/backs/back600pxDeg.png");
        panelBack.setPreferredSize(size);
        panelBack.setLayout(new GridBagLayout());
            //LabelTitle:
            labelTitle=new MyLabel("Generator of font code:",title,foreground,null);
            //End LabelTitle.
            //LabelLetters:
            labelLetter=new MyLabel("Select type of letter:  ",letter,foreground,null);
            //End LabelLetters.
            //ListFonts:
            listFonts=new JComboBox<String>();
            for(String s : fonts.getFonts()) listFonts.addItem(s);
            listFonts.setFont(letter);
            listFonts.addItemListener(e->writeArea.setFont(new Font(listFonts.getSelectedItem().toString(),writeArea.getFont().getStyle(),writeArea.getFont().getSize())));
            //End ListFonts.
            //LabelType:
            labelType=new MyLabel("Select form of letter:  ",letter,foreground,null);
            //End LabelType.
            //PanelRadios:
            panelRadio=new JPanel(new FlowLayout(FlowLayout.CENTER));
            panelRadio.setOpaque(false);
                //RadiosTypes:
                group=new ButtonGroup();
                radioPlain=new MyRadio("Plain",letter,foreground);
                radioPlain.setSelected(true);
                radioPlain.addActionListener(e->writeArea.setFont(new Font(writeArea.getFont().getFontName(),Font.PLAIN,writeArea.getFont().getSize())));
                group.add(radioPlain);
                radioBold=new MyRadio("Bold",letter,foreground);
                radioBold.addActionListener(e->writeArea.setFont(new Font(writeArea.getFont().getFontName(),Font.BOLD,writeArea.getFont().getSize())));
                group.add(radioBold);
                radioItalic=new MyRadio("Italic",letter,foreground);
                radioItalic.addActionListener(e->writeArea.setFont(new Font(writeArea.getFont().getFontName(),Font.ITALIC,writeArea.getFont().getSize())));
                group.add(radioItalic);
                //End RadiosTypes.
            //End PanelRadios.
            //PanelArea:
            panelArea=new JPanel();
            panelArea.setOpaque(false);
            panelArea.setPreferredSize(new Dimension(400,300));
                //WriteArea:
                writeArea=new JTextArea(10,10);
                writeArea.setPreferredSize(new Dimension(400,300));
                writeArea.setFont(actual);
                writeArea.setText("Example");
                //End WriteArea.
            //End PanelArea.
            //TamScroll:
            tamSlider=new JSlider(0,100,20);
            tamSlider.setOrientation(JSlider.VERTICAL);
            tamSlider.setOpaque(false);
            tamSlider.setFont(letter);
            tamSlider.setForeground(foreground);
            tamSlider.setPaintTicks(true);
            tamSlider.setMinorTickSpacing(10);
            tamSlider.setPaintTrack(true);
            tamSlider.setMajorTickSpacing(25);
            tamSlider.setPaintLabels(true);
            tamSlider.addChangeListener(e->writeArea.setFont(new Font(writeArea.getFont().getFontName(),writeArea.getFont().getSize(),tamSlider.getValue())));
            //End TamScroll.
            //LabelFont:
            labelFont=new MyLabel("Your Code: ",letter,foreground,null);
            //End LabelFont.
            //FontCode:
            fontCode=new JTextField("new Font(\"Agency FB\",Font.PLAIN,20)");
            //End FontCode.
        //End PanelBack.
        //Adds:
        gbc.gridx=0;gbc.gridy=0;gbc.gridwidth=6;gbc.gridheight=1;
        panelBack.add(labelTitle,gbc);
        gbc.gridx=0;gbc.gridy=1;gbc.gridwidth=3;gbc.gridheight=1;
        panelBack.add(labelLetter,gbc);
        gbc.gridx=3;gbc.gridy=1;gbc.gridwidth=2;gbc.gridheight=1;
        panelBack.add(listFonts,gbc);
        gbc.gridx=0;gbc.gridy=2;gbc.gridwidth=3;gbc.gridheight=1;
        panelBack.add(labelType,gbc);
        panelRadio.add(radioPlain);
        panelRadio.add(radioBold);
        panelRadio.add(radioItalic);
        gbc.gridx=3;gbc.gridy=2;gbc.gridwidth=3;gbc.gridheight=1;
        panelBack.add(panelRadio,gbc);
        panelArea.add(writeArea);
        gbc.gridx=0;gbc.gridy=3;gbc.gridwidth=5;gbc.gridheight=4;
        panelBack.add(panelArea,gbc);
        gbc.gridx=5;gbc.gridy=3;gbc.gridwidth=2;gbc.gridheight=4;
        panelBack.add(tamSlider,gbc);
        gbc.gridx=0;gbc.gridy=8;gbc.gridwidth=3;gbc.gridheight=2;
        panelBack.add(labelFont,gbc);
        gbc.gridx=3;gbc.gridy=8;gbc.gridwidth=3;gbc.gridheight=2;
        panelBack.add(fontCode,gbc);
        add(panelBack);
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
    //End Private Methods.
}
