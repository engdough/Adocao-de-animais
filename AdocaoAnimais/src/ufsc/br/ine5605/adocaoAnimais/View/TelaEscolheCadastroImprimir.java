/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ufsc.br.ine5605.adocaoAnimais.View;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ScrollPaneLayout;
import ufsc.br.ine5605.adocaoAnimais.Controller.ControladorPessoa;
import ufsc.br.ine5605.adocaoAnimais.Mapeadores.MapeadorPessoa;

/**
 *
 * @author Ana Elisa Kruger
 */
public class TelaEscolheCadastroImprimir extends JFrame{
    private GerenciadorBotoes btManager; 
    private JLabel lbTituloTela;
    private JLabel lbEmBranco;
    private JLabel lbMensagemRemover;
    private JTextField tfInfoCpf;
    private JButton btOk;
    private JButton btVoltar;
    private TelaCadastroNaoEncontrado telaCadastroNaoEncontrado =
                                     new TelaCadastroNaoEncontrado();
    
    public TelaEscolheCadastroImprimir(){
        super("Imprimir Cadastro Pessoa");
        btManager = new GerenciadorBotoes();
        configuraTela();
    }
   
    private void configuraTela() {
        JPanel container = new JPanel();
        container.setLayout(new GridBagLayout());
        GridBagConstraints cons = new GridBagConstraints();
        JScrollPane scrPane = new JScrollPane(container);
        scrPane.setLayout(new ScrollPaneLayout());
        getContentPane().add(scrPane);
        
        //Configura JLabel lbTituloTela
        lbTituloTela = new JLabel("IMPRIMIR CADASTRO PESSOA");
        cons.fill = GridBagConstraints.HORIZONTAL;
        cons.gridx = 0;
        cons.gridy = 0;
        container.add(lbTituloTela, cons);
        
        //Configura label lbEmBranco
        lbEmBranco = new JLabel("");
        cons.fill = GridBagConstraints.HORIZONTAL;
        cons.gridx = 0;
        cons.gridy = 1;
        container.add(lbEmBranco, cons);
         
        //Configura JLabel lbMensagemRemover
        lbMensagemRemover = new JLabel("Insira o Cpf: ");
        cons.fill = GridBagConstraints.HORIZONTAL;
        cons.gridx = 0;
        cons.gridy = 2;
        container.add(lbMensagemRemover, cons);
        
        //Configura JTextField tfInfoCpf
        tfInfoCpf = new JTextField("");
        cons.gridx = 0;
        cons.gridy = 3;
        cons.fill = GridBagConstraints.HORIZONTAL;
        container.add(tfInfoCpf, cons);
        
        //Configura Botao btOk
        btOk = new JButton("OK");
        cons.fill = GridBagConstraints.HORIZONTAL;
        cons.gridx = 0;
        cons.gridy = 4;
        container.add(btOk, cons);
        cons.anchor = GridBagConstraints.PAGE_END;
        btOk.addActionListener(btManager);
        
        //Configura Botao btVoltar
        btVoltar = new JButton("VOLTAR");   
        cons.anchor = GridBagConstraints.PAGE_END;
        cons.gridx = 0;
        cons.gridy ++;
        container.add(btVoltar, cons);
        btVoltar.addActionListener(btManager);
        
        // Configura Frame        
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);  
    }
    
    private class GerenciadorBotoes implements ActionListener { 
        public void actionPerformed(ActionEvent ae) {    
            if (ae.getSource().equals(btOk)){
                setVisible(false);
                try
                {
                    ControladorPessoa.getInstancia().buscaPessoaCPF(tfInfoCpf.getText());
                    ControladorPessoa.getInstancia()
                           .imprimeInformacoesPessoa(tfInfoCpf.getText());
                }catch(Exception CadastroNaoEncontradoException){
                     telaCadastroNaoEncontrado.setVisible(true);
                }
                   
                
            }else if(ae.getSource().equals(btVoltar)){
                setVisible(false);
                ControladorPessoa.getInstancia().iniciaMenuPessoa();
            }
        }
           
    }
}
