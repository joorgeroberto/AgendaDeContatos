/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dados;
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Iterator;
 
public class Visualizar extends JFrame{
private static ArrayList<Contato> contatos;// = new ArrayList<Contato>();    
//JButton pesquisar, apagar;
//JTextField dados;
JTextArea area;
JLabel label;
JButton sair;
int num;
public Visualizar(){
	
	contatos = new ArrayList<Contato>();  
	contatos.clear();
    GridBagLayout gridbag = new GridBagLayout();
    GridBagConstraints c = new GridBagConstraints();
    Container container = getContentPane();	   
    container.setLayout(gridbag);

    // Os componentes podem ser esticados nas duas dire√ß√µes
    // para ocupar todo o espa√ßo dispon√≠vel
    c.fill = GridBagConstraints.HORIZONTAL;
    c.insets = new Insets(10,  // Acima por fora
                          10,  // √Ä esquerda por fora
                          10,  // Abaixo por fora
                          10);
    c.weightx = 1.0;
    c.weighty = 1.0;
    c.ipadx = 100;
    c.ipady = 10;
    c.gridwidth = GridBagConstraints.REMAINDER;
    
    label = new JLabel("Lista de Contatos Armazenados");
    label.setHorizontalAlignment( SwingConstants.CENTER );
    gridbag.setConstraints(label, c);
    container.add(label);
    
    c.ipadx = 10;
    
    area = new JTextArea(20, 20);
    JScrollPane spTextArea = new JScrollPane(area,
                                             JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                                             JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
    
    gridbag.setConstraints(spTextArea, c);
    
    container.add(spTextArea);
   
    Iterator it0 = contatos.iterator();
    File file = new File("C:\\arqs\\agenda.ser");
	if (!file.exists()){
		//if (fileFolder.exists)
        area.append("Nenhum contato gravado!\nPor favor, primeiro grave um contato para poder visualiz·-lo.\n");}
	else{
		FileInputStream fis;
		try {
			fis = new FileInputStream("C:\\arqs\\agenda.ser");
			ObjectInputStream ois = new ObjectInputStream(fis);
			
			num = ois.readInt();
			System.out.print("Existem: "+num+" arquivos.");
		
            	// ObtÈm os objetos do arquivo e adiciona na coleÁ„o
            	for (int i = 0; i < num; i++) {
            		contatos.add((Contato) ois.readObject());
            	}
            	if (!it0.hasNext()){
            	area.append("Nenhum contato gravado!\nPor favor, primeiro grave um contato para poder visualiz·-lo.\n");}
            	ois.close();
            	fis.close();
		} catch (FileNotFoundException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
    
    Iterator it = contatos.iterator();
    area.append("Existem: "+contatos.size()+" contatos.");
    area.append("\n==================================================================\n");
    while (it.hasNext()) {
    	area.append((it.next().toString()));  
    	area.append("\n==================================================================\n\n");
    }
    
    contatos.clear();
    sair = new JButton("Sair");
    sair.setToolTipText( "Clique aqui para sair." );
    gridbag.setConstraints(sair, c);
    container.add(sair);
    
    //apagar = new JButton("Apagar");
    //apagar.setToolTipText( "Clique aqui para apagar o contato." );
    //gridbag.setConstraints(apagar, c);
    //container.add(apagar);
    //apagar.setEnabled(false);
    sair.addActionListener( new SairListener() );
    
    setSize(500, 500);
    setVisible(true);
    setResizable(false);

    }

    private class SairListener implements ActionListener {
             public void actionPerformed(ActionEvent e){
                  dispose();
             }
        }
}