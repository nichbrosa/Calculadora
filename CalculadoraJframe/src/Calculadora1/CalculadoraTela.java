package Calculadora1;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class CalculadoraTela extends JFrame {

	private JPanel contentPane;
	private JTextField txtcalculo;
	String operacao;
	int keybrd;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CalculadoraTela frame = new CalculadoraTela();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public CalculadoraTela() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(CalculadoraTela.class.getResource("/Calculadora1/calc.jpg")));
		
		Calculos calc = new Calculos();	
		
		
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 489, 363);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
			
		txtcalculo = new JTextField();
		txtcalculo.setText("");
		txtcalculo.setHorizontalAlignment(SwingConstants.RIGHT);
		txtcalculo.setFont(new Font("Tahoma", Font.PLAIN, 30));
		txtcalculo.setBounds(10, 10, 455, 63);
		contentPane.add(txtcalculo);
		txtcalculo.setColumns(10);
		
		//botao para limpeza do textfield
		JButton btnon = new JButton("ON");
		btnon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtcalculo.setText("");
				operacao="";
			}
		});
		btnon.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnon.setBounds(380, 83, 85, 54);
		contentPane.add(btnon);
		
		//botao pra adicionar uma virgula
		JButton btnvirgula = new JButton(".");
		btnvirgula.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtcalculo.setText(txtcalculo.getText()+".");
			}
		});
		btnvirgula.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnvirgula.setBounds(194, 267, 85, 54);
		contentPane.add(btnvirgula);
		
		//botoes de funcoes matematicas
		JButton btndiv = new JButton("/");
		btndiv.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(operacao=="")
				{
				calc.setNum1(Double.parseDouble(txtcalculo.getText()));
				operacao = "/";
				txtcalculo.setText(" ");
				}
				else
				{
					operacao = "/";
				}
			}
		});
		btndiv.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btndiv.setBounds(288, 83, 85, 54);
		contentPane.add(btndiv);
		
		JButton btnvezes = new JButton("X");
		btnvezes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(operacao=="")
				{
				calc.setNum1(Double.parseDouble(txtcalculo.getText()));
				operacao = "*";
				txtcalculo.setText(" ");
				}
				else
				{
					operacao = "*";
				}
			}
		});
		btnvezes.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnvezes.setBounds(288, 147, 85, 54);
		contentPane.add(btnvezes);
				
		JButton btnmais = new JButton("+");
		btnmais.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(operacao=="")
				{
				calc.setNum1(Double.parseDouble(txtcalculo.getText()));
				operacao = "+";
				txtcalculo.setText(" ");
				}
				else
				{
					operacao = "+";
				}
			}
		});
		btnmais.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnmais.setBounds(288, 267, 85, 54);
		contentPane.add(btnmais);
		
		JButton btnmenos = new JButton("-");
		btnmenos.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnmenos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(operacao=="")
				{
				calc.setNum1(Double.parseDouble(txtcalculo.getText()));
				operacao = "-";
				txtcalculo.setText(" ");
				}
				else
				{
					operacao = "-";
				}
			}
		});
		btnmenos.setBounds(288, 207, 85, 54);
		contentPane.add(btnmenos);
		
		JButton btnigual = new JButton("=");
		btnigual.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(operacao=="+") 
				{
					calc.setNum2(Double.parseDouble(txtcalculo.getText()));
					calc.adicao();
					txtcalculo.setText(String.valueOf(calc.result));
				}
				else if(operacao=="*") 
				{
					calc.setNum2(Double.parseDouble(txtcalculo.getText()));
					calc.mult();
					txtcalculo.setText(String.valueOf(calc.result));
				}
				else if(operacao=="/")
				{
					calc.setNum2(Double.parseDouble(txtcalculo.getText()));
					calc.div();
					txtcalculo.setText(String.valueOf(calc.result));
				}
				else if(operacao=="-")
				{
					calc.setNum2(Double.parseDouble(txtcalculo.getText()));
					calc.menos();
					txtcalculo.setText(String.valueOf(calc.result));
				}
			}
		});
		btnigual.setBackground(Color.CYAN);
		btnigual.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnigual.setBounds(380, 149, 85, 170);
		contentPane.add(btnigual);

		//botoes dos numeros 9-0
		JButton btn9 = new JButton("9");
		btn9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {				
	
				txtcalculo.setText(txtcalculo.getText() + "9");			
			
			}
		});
		btn9.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btn9.setBounds(194, 83, 85, 54);
		contentPane.add(btn9);
		
		JButton btn8 = new JButton("8");
		btn8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				txtcalculo.setText(txtcalculo.getText() + "8");			
			
			}
		});
		btn8.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btn8.setBounds(102, 83, 85, 54);
		contentPane.add(btn8);
		
		JButton btn7 = new JButton("7");
		btn7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				txtcalculo.setText(txtcalculo.getText() + "7");			
			
			}
		});
		btn7.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btn7.setBounds(10, 83, 85, 54);
		contentPane.add(btn7);
		
		JButton btn6 = new JButton("6");
		btn6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				txtcalculo.setText(txtcalculo.getText() + "6");			
			
			}
		});
		btn6.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btn6.setBounds(194, 147, 85, 54);
		contentPane.add(btn6);
		
		JButton btn5 = new JButton("5");
		btn5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				txtcalculo.setText(txtcalculo.getText() + "5");			
				
			}
		});
		btn5.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btn5.setBounds(102, 147, 85, 54);
		contentPane.add(btn5);
		
		JButton btn4 = new JButton("4");
		btn4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				txtcalculo.setText(txtcalculo.getText() + "4");			
			
			}
		});
		btn4.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btn4.setBounds(10, 147, 85, 54);
		contentPane.add(btn4);
		
		JButton btn3 = new JButton("3");
		btn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				txtcalculo.setText(txtcalculo.getText() + "3");			
			
			}
		});
		btn3.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btn3.setBounds(194, 207, 85, 54);
		contentPane.add(btn3);
		
		JButton btn2 = new JButton("2");
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				txtcalculo.setText(txtcalculo.getText() + "2");			
			
			}
		});
		btn2.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btn2.setBounds(102, 209, 85, 54);
		contentPane.add(btn2);
		
		JButton btn1 = new JButton("1");
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				txtcalculo.setText(txtcalculo.getText() + "1");			
			
			}
		});
		btn1.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btn1.setBounds(10, 209, 85, 54);
		contentPane.add(btn1);
		
		
		
		JButton btn0 = new JButton("0");	
		btn0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				txtcalculo.setText(txtcalculo.getText() + "0");			
			
			}
		});
		btn0.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btn0.setBounds(10, 267, 177, 54);
		contentPane.add(btn0);
		
	}
	
}
