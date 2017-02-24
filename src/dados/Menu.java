package dados;



//import dados.AgendaDeContatos;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

//import java.awt.BorderLayout;
import java.awt.Container;
//import java.awt.event.WindowAdapter;
//import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;

//import java.awt.FlowLayout;

import javax.swing.JLabel;
//import javax.swing.SwingConstants;





//import java.util.Collections;

//import java.awt.BorderLayout;
//import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
//import java.util.ArrayList;
import java.util.Scanner;

//import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
//import javax.swing.Icon;
//import javax.swing.ImageIcon;


public class Menu extends JFrame
{		 
	static Scanner input;
	
	JButton gravar, consultar, visualizar;
	JLabel menu, texto, imagem;
	//private ButtonGroup grupo1;
	
	public Menu(){
		super("Agenda de contatos");
	        GridBagLayout gridbag = new GridBagLayout();
                GridBagConstraints c = new GridBagConstraints();
                Container container = getContentPane();	   
                container.setLayout(gridbag);
		


                // Os componentes podem ser esticados nas duas direções
                // para ocupar todo o espaço disponível
                c.fill = GridBagConstraints.BOTH;
                c.insets = new Insets(10,  // Acima por fora
                                      10,  // À esquerda por fora
                                      10,  // Abaixo por fora
                                      10);
                c.ipadx = 200;
                c.ipady = 20;
                c.gridwidth = GridBagConstraints.REMAINDER;
                
                texto = new JLabel("Digite o que gostaria de fazer:", SwingConstants.CENTER);
                gridbag.setConstraints(texto, c);
                container.add( texto);

                gravar = new JButton("Gravar Contato");
                gravar.setToolTipText( "Clique aqui para gravar um contato." );
                gridbag.setConstraints(gravar, c);
                container.add(gravar);
                
                consultar = new JButton("Consultar Contatos");
                consultar.setToolTipText( "Clique aqui para consultar um contato." );
                gridbag.setConstraints(consultar, c);
                container.add(consultar);
                
                visualizar = new JButton("Visualizar Contatos");
                visualizar.setToolTipText( "Clique aqui para visualizar todos os contatos gravados na agenda.");
                gridbag.setConstraints(visualizar, c);
                container.add(visualizar);

                
		
		visualizar.addActionListener( new VisualizarListener() );
                consultar.addActionListener( new ConsultarListener() );
		gravar.addActionListener( new GravarListener() );
               
		
	 }
	
	
	private class GravarListener implements ActionListener {
	    public void actionPerformed( ActionEvent e ) { 	    	    	
	    	
	    	Gravar application;
			try {
				application = new Gravar();
				application.setTitle("Gravar Contato");
				application.setSize(600,400);
				application.setVisible(true);
				application.setResizable(false);
				application.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
	    	
                    
	    }
	}
        
        
        private class ConsultarListener implements ActionListener {
	    public void actionPerformed( ActionEvent e ) { 	    	    	
	    	//JOptionPane.showMessageDialog(null, "O botao Consultar foi clicado");
	    	Consultar application = new Consultar();
			
	    	application.setTitle("Consultar Contatos");
			application.setSize(400,450);
			application.setVisible(true);
			application.setResizable(false);
			application.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
              	
	    }
	}
        
        private class VisualizarListener implements ActionListener {
		    public void actionPerformed( ActionEvent e ) { 	    	    	
		    	//JOptionPane.showMessageDialog(null, "O botao Visualizar foi clicado");
		    	Visualizar application = new Visualizar();
				
		    	application.setTitle("Visualizar Contatos");
				application.setSize(500,500);
				application.setVisible(true);
				application.setResizable(false);
				application.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		    }
        }
        
}
       
	
	    

