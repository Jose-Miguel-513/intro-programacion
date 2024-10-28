import javax.swing.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List; 

public class Formulario {
    
    public static void main(String[] args) {
        
        JFrame formulario = new JFrame("Formulario");
        formulario.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        formulario.setSize(900, 700);
        formulario.setLocationRelativeTo(null);
        formulario.setResizable(false);

        JPanel panel = new JPanel();
        panel.setBounds(0, 0, 900, 700);
        panel.setLayout(null);
        panel.setOpaque(false);

        PanelConFondo fondo = new PanelConFondo("Fondo.jpeg");
        fondo.setLayout(null);
        
        ImageIcon logo = new ImageIcon("Logo.png");
        JButton botonLogo = new JButton(logo);
        botonLogo.setBounds(675, 500, 200, 150);
        botonLogo.setIcon(new ImageIcon(logo.getImage().getScaledInstance(200, 150, Image.SCALE_SMOOTH)));
        botonLogo.setOpaque(false);
        botonLogo.setContentAreaFilled(false);
        botonLogo.setBorderPainted(false);
        panel.add(botonLogo);

        JLabel jlbTitulo =new JLabel("Ingrese sus datos");
        jlbTitulo.setBounds(200, 20,400, 100);
        jlbTitulo.setFont(new Font("Edwardian Script ITC", Font.BOLD, 75));
        jlbTitulo.setForeground(Color.RED);
        panel.add(jlbTitulo);

        JLabel jlbNombre = new JLabel("Nombre");
        jlbNombre.setBounds(50, 120, 200, 30);
        jlbNombre.setFont(new Font("Time New Roman", Font.BOLD, 20));
        jlbNombre.setForeground(Color.WHITE);
        panel.add(jlbNombre);

        JTextField jtxNombre = new JTextField();
        jtxNombre.setBounds(50, 150, 200, 30);
        panel.add(jtxNombre);

        JLabel jlbApellido = new JLabel("Apellido");
        jlbApellido.setBounds(400, 120, 200, 30);
        jlbApellido.setFont(new Font("Time New Roman", Font.BOLD, 20));
        jlbApellido.setForeground(Color.WHITE);
        panel.add(jlbApellido);

        JTextField jtxApellido = new JTextField();
        jtxApellido.setBounds(400, 150, 200, 30);
        panel.add(jtxApellido);

        JLabel jlbFechaNacimiento = new JLabel("Fecha de Nacimiento");
        jlbFechaNacimiento.setBounds(50, 200, 200, 30);
        jlbFechaNacimiento.setFont(new Font("Time New Roman", Font.BOLD, 20));
        jlbFechaNacimiento.setForeground(Color.WHITE);
        panel.add(jlbFechaNacimiento);

        List<Integer> dias = new ArrayList<>();
        int ultimoDia = 31; 
        for (int i = ultimoDia - 30; i <= ultimoDia; i++) {
            dias.add(i);
        }

        JComboBox<Object> jcbDias = new JComboBox<>(dias.toArray(new Integer[0]));
        jcbDias.setBounds(50, 230, 60, 30);
        jcbDias.insertItemAt("=Dia=",0);
        jcbDias.setSelectedItem("=Dia=");
        panel.add(jcbDias);

        String[] meses = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"};

        JComboBox<String> jcbMeses = new JComboBox<>(meses);
        jcbMeses.setBounds(130, 230, 95, 30);
        jcbMeses.insertItemAt("=Mes=",0);
        jcbMeses.setSelectedItem("=Mes=");
        panel.add(jcbMeses);
       
        List<Integer> años = new ArrayList<>();
        int añoCien = 1924; 
        for (int i = añoCien + 100; i >= añoCien; i--) {
            años.add(i);
        }

        JComboBox<Object> jcbAños = new JComboBox<>(años.toArray(new Integer[0]));
        jcbAños.setBounds(245, 230, 65, 30);
        jcbAños.insertItemAt("=Año=",0);
        jcbAños.setSelectedItem("=Año=");
        panel.add(jcbAños);

        JLabel jlbEstadoCivil = new JLabel("Estado Civil");
        jlbEstadoCivil.setBounds(400, 200, 200, 30);
        jlbEstadoCivil.setFont(new Font("Time New Roman", Font.BOLD, 20));
        jlbEstadoCivil.setForeground(Color.WHITE);
        panel.add(jlbEstadoCivil);
        
        JRadioButton soltero = new JRadioButton("Soltero/a");
        soltero.setBounds(400, 230, 100, 30);
        soltero.setOpaque(false);
        soltero.setFont(new Font("Arial", Font.PLAIN, 15));
        soltero.setForeground(Color.WHITE);
        panel.add(soltero);

        JRadioButton casado = new JRadioButton("Casado/a");
        casado.setBounds(525, 230, 100, 30);
        casado.setOpaque(false);
        casado.setFont(new Font("Arial", Font.PLAIN, 15));
        casado.setForeground(Color.WHITE);
        panel.add(casado);

        JRadioButton divorciado = new JRadioButton("Divorciado/a");
        divorciado.setBounds(400, 250, 120, 30);
        divorciado.setOpaque(false);
        divorciado.setFont(new Font("Arial", Font.PLAIN, 15));
        divorciado.setForeground(Color.WHITE);
        panel.add(divorciado);

        JRadioButton viudo = new JRadioButton("Viudo/a");
        viudo.setBounds(525, 250, 100, 30);
        viudo.setOpaque(false);
        viudo.setFont(new Font("Arial", Font.PLAIN, 15));
        viudo.setForeground(Color.WHITE);
        panel.add(viudo);

        ButtonGroup estadoCivil = new ButtonGroup();
        estadoCivil.add(soltero);
        estadoCivil.add(casado);
        estadoCivil.add(divorciado);
        estadoCivil.add(viudo);

        JButton boton = new JButton("Ingresar Datos");
        boton.setBounds(270, 300, 130, 50);
        boton.setEnabled(true);
        panel.add(boton);

        JTextArea jtaDatos = new JTextArea();
        jtaDatos.setBounds(100, 400, 440, 150);
        jtaDatos.setFont(new Font("Arial", Font.PLAIN, 20));
        jtaDatos.setOpaque(false);
        jtaDatos.setForeground(Color.WHITE);
        jtaDatos.setEditable(false);
        panel.add(jtaDatos);

        boton.addMouseListener(new MouseAdapter() {
         
            @Override
            public void mouseEntered(MouseEvent e) {
                boton.setBackground(Color.GRAY);
                boton.setForeground(Color.WHITE);
            }

            @Override
            public void mouseExited(MouseEvent e) {
              boton.setBackground(null);
              boton.setForeground(null);
            }
        });

        botonLogo.addMouseListener(new MouseAdapter() {
         
            @Override
            public void mouseEntered(MouseEvent e) {
                botonLogo.setBorderPainted(true);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                botonLogo.setBorderPainted(false);
            }
        });

        boton.addActionListener (new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String nombre = jtxNombre.getText();
                String apellido = jtxApellido.getText();
                String dianacimiento = jcbDias.getSelectedItem().toString();
                String mesnacimiento = jcbMeses.getSelectedItem().toString();
                String añonacimiento = jcbAños.getSelectedItem().toString();
                jtaDatos.setText("DATOS INGRESADOS:\n");
                jtaDatos.append("\nNombre: " + nombre + "\nApellido: " + apellido + "\nFecha de Nacimiento: " + dianacimiento + " de " + mesnacimiento + " del " + añonacimiento + "\nEstado Civil: ");
                for (Enumeration<AbstractButton> botones = estadoCivil.getElements(); botones.hasMoreElements();) {
                    AbstractButton boton = botones.nextElement();

                    if (boton.isSelected())
                    jtaDatos.append(boton.getText()); 
                }
            }
        });

        botonLogo.addActionListener (new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               jtxNombre.setText(null);
               jtxApellido.setText(null);
               jcbDias.setSelectedIndex(0);
               jcbMeses.setSelectedIndex(0);
               jcbAños.setSelectedIndex(0);
               estadoCivil.clearSelection();
               jtaDatos.setText(null);
            }
        });

        formulario.add(panel);
        formulario.add(fondo);
        formulario.setVisible(true);
    }
}