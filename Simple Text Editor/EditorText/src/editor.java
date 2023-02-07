import java.awt.*;
import javax.swing.*;
import java.io.*;
import java.awt.event.*;
import javax.swing.plaf.metal.*;
import javax.swing.text.*;

public class editor extends JFrame implements ActionListener {
    JTextArea txt;
    JFrame frame;

    editor(){
        frame = new JFrame("editor");

        try{
            UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");

            MetalLookAndFeel.setCurrentTheme(new OceanTheme());
        }
        catch(Exception e){
            System.err.println("Error al establecer la UI Look And Feel." +e.getMessage());
        }

        txt = new JTextArea();

        JMenuBar menuBar = new JMenuBar();


        // Menu File
        JMenu menuFile = new JMenu("File");

        // Cuatro menus items que seran Nuevo, Abrir, Guardar y Mostrar

        JMenuItem menuItemNew = new JMenuItem("New");
        JMenuItem menuItemOpen = new JMenuItem("Open");
        JMenuItem menuItemSave = new JMenuItem("Save");
        JMenuItem menuItemPrint = new JMenuItem("Print");

        //Action listeners para estos items

        menuItemNew.addActionListener(this);
        menuItemOpen.addActionListener(this);
        menuItemSave.addActionListener(this);
        menuItemPrint.addActionListener(this);

        menuFile.add(menuItemNew);
        menuFile.add(menuItemOpen);
        menuFile.add(menuItemSave);
        menuFile.add(menuItemPrint);

        /* Menu Edit ---> Repetimos lo mismo que arriba. Creamos nuevos items de Menu pertenecientes al menu de editor,
        agregamos actionlisteners y luego al menu de editor le añadimos esos submenues.
         */

        JMenu menuEditor = new JMenu("Editor");

        JMenuItem menuItemCut = new JMenuItem("Cut");
        JMenuItem menuItemCopy = new JMenuItem("Copy");
        JMenuItem menuItemPaste = new JMenuItem("Paste");

        menuItemCut.addActionListener(this);
        menuItemCopy.addActionListener(this);
        menuItemPaste.addActionListener(this);

        menuEditor.add(menuItemCut);
        menuEditor.add(menuItemCopy);
        menuEditor.add(menuItemPaste);

        // Menu cerrar.

        JMenu menuClose = new JMenu("Close");

        menuClose.addActionListener(this);

        // A la barra del menu, le agregamos estos tres menus creados anteriormente.

        menuBar.add(menuFile);
        menuBar.add(menuEditor);
        menuBar.add(menuClose);

        // Terminamos configuraciones

        frame.setJMenuBar(menuBar);
        frame.add(txt);
        frame.setSize(500, 500);
        frame.setVisible(true);

    }

        // EN CASO DE QUE SE PRESIONE ALGÚN BOTON:

    public void actionPerformed(ActionEvent event){
        String str = event.getActionCommand();

        if(str.equals("Cut")){
            txt.cut();
        }

        else if(str.equals("Copy")){
            txt.copy();
        }

        else if(str.equals("Paste")){
            txt.paste();
        }

        else if(str.equals("Save")){

            // Creamos una JFileChooser class

            JFileChooser chooser = new JFileChooser("C:/");
            chooser.setCurrentDirectory(new File(System.getProperty("user.home")));

            // Se invoca al metodo 'showSaveDialog' para que muestre el dialogo guardado

            int r = chooser.showSaveDialog(null);

            if(r == JFileChooser.APPROVE_OPTION){
                File fi = new File(chooser.getSelectedFile().getAbsolutePath());

                try{
                    FileWriter fileWriter = new FileWriter(fi, false);

                    BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

                    bufferedWriter.write(txt.getText());
                    bufferedWriter.flush();
                    bufferedWriter.close();

                }
                catch (Exception evt){
                    JOptionPane.showMessageDialog(frame, evt.getMessage());
                }
            }
            else JOptionPane.showMessageDialog(frame, "el usuario ha cancelado la operación");
        }

        // Condiciones para la opcion "Print"

        else if(str.equals("Print")){
            try{
                txt.print();
            }
            catch (Exception evt){
                JOptionPane.showMessageDialog(frame, evt.getMessage());
            }
        }

        // Condiciones para la opción "Open"

        else if (str.equals("Open")){

            // Repetimos utilidades similares a las usadas en la opción "Save"

            JFileChooser chooser = new JFileChooser("C:/");

            int r = chooser.showOpenDialog(null);

            if(r == JFileChooser.APPROVE_OPTION){
                File fi = new File(chooser.getSelectedFile().getAbsolutePath());

                try{
                    String string1 = "", stringl = "";

                    FileReader fileReader = new FileReader(fi);

                    BufferedReader bufferedReader = new BufferedReader(fileReader);

                    stringl = bufferedReader.readLine();

                    while((string1 = bufferedReader.readLine()) != null){
                        stringl = stringl + "\n" + string1;
                    }

                    txt.setText(stringl);
                }
                catch (Exception evt){
                    JOptionPane.showMessageDialog(frame, evt.getMessage());
                }
            }

            else JOptionPane.showMessageDialog(frame, "El usuario ha cancelado la operación.");
        }

        // Definimos la utilidad de New y de Close.

        else if(str.equals("New")){
            txt.setText("");
        }
        else if(str.equals("Close")){
            frame.setVisible(false);
        }


    }


    // Ejecutamos nuestro editor.
    public static void main(String[] args){
        editor editor = new editor();
    }



}
