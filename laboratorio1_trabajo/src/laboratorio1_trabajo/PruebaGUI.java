package laboratorio1_trabajo;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
public class PruebaGUI extends JFrame{
	
	private static final long serialVersionUID = 1L;
	
	// COMPONENTES DE LA GUI
	private JPanel panelFuente = new JPanel();
	private JPanel panelResultado = new JPanel();
	private JButton botonAnalizar;
	private JTextArea textoPrograma;
	private JScrollPane textoProgramaConScroll;
	private JTextArea resultadoComando;
	private JScrollPane resultadoConScroll;
	
	public PruebaGUI()
	{
		super("Prueba de análisis léxico");
		initGUI();
		
	}
	private void initGUI() {
		
		panelFuente.setLayout(new FlowLayout(FlowLayout.CENTER,6,30));
		
	
		textoPrograma = new JTextArea();	
		textoProgramaConScroll = new JScrollPane(textoPrograma, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		textoProgramaConScroll.setPreferredSize(new Dimension(400,200));
		panelFuente.add(textoProgramaConScroll);
		panelFuente.setBackground(new Color(0,173,213));
		
		botonAnalizar = new JButton("Analizar");
		panelFuente.add(botonAnalizar);
				
		// DECLARACIÓN DEL MANEJADOR DE EVENTOS DEL BOTÓN
		botonAnalizar.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				 File archivo = new File("archivo.txt");
			        PrintWriter escribir;
			        try {
			            escribir = new PrintWriter(archivo);
			            escribir.print(textoPrograma.getText());
			            escribir.close();
			        } catch (FileNotFoundException ex) {
			            System.out.println(ex.getMessage());
			        }
			       
			        try {
			            Reader lector = new BufferedReader(new FileReader("archivo.txt"));
			            Scanner scanner = new Scanner(lector);
			            String resultado = "";
			            while (true) {
			                Tokens token = scanner.yylex();
			                if ((token == null) || (token == Tokens.TOK_ERROR)){
			                    //resultado += "FIN";
			                    resultadoComando.setText(resultado);
			                    return;
			                }
			                        resultado += token + "\t" + scanner.yytext() + "\n";
			            }
			        } catch (FileNotFoundException ex) {
			        	System.out.println(ex.getMessage());
			        } catch (IOException ex) {
			        	System.out.println(ex.getMessage());
			        }			       
			}
			});
		
		
		resultadoComando = new JTextArea();	
		resultadoConScroll = new JScrollPane(resultadoComando, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		resultadoConScroll.setPreferredSize(new Dimension(600,300));
		panelResultado.add(resultadoConScroll);
		
		this.add(panelFuente,BorderLayout.PAGE_START);
		this.add(panelResultado,BorderLayout.PAGE_END);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.pack();
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		}
	
	
	public static void main(String[] args) {
			
			new PruebaGUI();
	}	
}
