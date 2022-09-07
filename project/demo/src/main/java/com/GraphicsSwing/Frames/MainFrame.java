package com.GraphicsSwing.Frames;

import java.awt.*;
import javax.swing.*;

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
    private JPanel panelBack,panelRadio,panelArea,panelField;
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
            listFonts.addItemListener(e->changeFontArea());
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
                radioPlain.addActionListener(e->changeTypeArea(Font.PLAIN));
                group.add(radioPlain);
                radioBold=new MyRadio("Bold",letter,foreground);
                radioBold.addActionListener(e->changeTypeArea(Font.BOLD));
                group.add(radioBold);
                radioItalic=new MyRadio("Italic",letter,foreground);
                radioItalic.addActionListener(e->changeTypeArea(Font.ITALIC));
                group.add(radioItalic);
                //End RadiosTypes.
            //End PanelRadios.
            //PanelArea:
            panelArea=new JPanel();
            panelArea.setOpaque(false);
            panelArea.setPreferredSize(new Dimension(400,300));
                //WriteArea:
                writeArea=new JTextArea();
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
            tamSlider.addChangeListener(e->changeSizeArea());
            //End TamScroll.
            //LabelFont:
            labelFont=new MyLabel("Your Code: ",letter,foreground,null);
            labelFont.setHorizontalAlignment(JLabel.RIGHT);
            //End LabelFont.
            //PanelField:
            panelField=new JPanel(new FlowLayout(FlowLayout.CENTER));
            panelField.setOpaque(false);
            panelField.setPreferredSize(new Dimension(230,50));
                //FontCode:
                fontCode=new JTextField("new Font(\"Agency FB\",Font.PLAIN,20);");
                fontCode.setPreferredSize(new Dimension(230,50));
                fontCode.setFont(new Font("Segoe Print",Font.PLAIN,10));
                fontCode.setHorizontalAlignment(JTextField.CENTER);
                //End FontCode.
            //End PanelField.
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
        gbc.gridx=0;gbc.gridy=9;gbc.gridwidth=3;gbc.gridheight=2;
        panelBack.add(labelFont,gbc);
        panelField.add(fontCode);
        gbc.gridx=3;gbc.gridy=9;gbc.gridwidth=3;gbc.gridheight=2;
        panelBack.add(panelField,gbc);
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
    private void changeFontArea(){
        writeArea.setFont(new Font(listFonts.getSelectedItem().toString(),writeArea.getFont().getStyle(),writeArea.getFont().getSize()));
        String[] s=fontCode.getText().split(",");
        s[0]="new Font(\""+listFonts.getSelectedItem().toString()+"\"";
        fontCode.setText(s[0]+","+s[1]+","+s[2]);
    }
    private void changeTypeArea(int type){
        writeArea.setFont(new Font(writeArea.getFont().getFontName(),type,writeArea.getFont().getSize()));
        String[] s=fontCode.getText().split(",");
        switch(type){
            case Font.PLAIN: s[1]="Font.PLAIN";break;
            case Font.BOLD: s[1]="Font.BOLD";break;
            case Font.ITALIC: s[1]="Font.ITALIC";break;
        }
        fontCode.setText(s[0]+","+s[1]+","+s[2]);
    }
    private void changeSizeArea(){
        writeArea.setFont(new Font(writeArea.getFont().getFontName(),writeArea.getFont().getSize(),tamSlider.getValue()));
        String[] s=fontCode.getText().split(",");
        s[2]=tamSlider.getValue()+");";
        fontCode.setText(s[0]+","+s[1]+","+s[2]);
    }
    //End Private Methods.
}
