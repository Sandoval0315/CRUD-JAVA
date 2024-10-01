package controlador;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;
import modelo.mdlBiologo;
import vistas.jfrBiologo; 

//////////////////////////1- Implementar herencia: ActionListener
public class ctrlBiologo implements MouseListener, KeyListener {

    //////////////////////////2- Parametros
    private mdlBiologo modelo;
    private jfrBiologo vista;

    //////////////////////////3- Constructor de la clase
    public ctrlBiologo(mdlBiologo modelo, jfrBiologo vista) {
        this.modelo = modelo;
        this.vista = vista;

        //Siempre poner todos los botones que vamos a detectar
        vista.btnGuardar.addMouseListener(this);
        vista.btnEliminar.addMouseListener(this);
        vista.btnActualizar.addMouseListener(this);
        vista.btnLimpiar.addMouseListener(this);
        vista.txtBuscarBiologo.addKeyListener(this);
        vista.tbBiologo.addMouseListener(this);

        modelo.Mostrar(vista.tbBiologo);
    }

    /////////////////////////////////////////Eventos
    @Override
    public void mouseClicked(MouseEvent e) {
        //////////////////////////4- Detección de clicks en la vista
        if (e.getSource() == vista.btnGuardar) {
            if (vista.txtCorreoBiologo.getText().isEmpty() || vista.txtEdadBiologo.getText().isEmpty() || vista.txtPesoBiologo.getText().isEmpty()|| vista.txtNombreBiologo.getText().isEmpty()) {
                JOptionPane.showMessageDialog(vista, "Debes llenar todos los campos", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                try {
                    //Asignar lo de la vista al modelo
                    modelo.setNombre_Biologo(vista.txtNombreBiologo.getText());
                    modelo.setEdad_Biologo(Integer.parseInt(vista.txtEdadBiologo.getText()));
                    modelo.setPeso_Biologo(Double.parseDouble(vista.txtPesoBiologo.getText()));
                    modelo.setCorreo_Biologo(vista.txtCorreoBiologo.getText());
                    //Ejecutar el metodo 
                    modelo.Guardar();
                    modelo.Mostrar(vista.tbBiologo);
                    modelo.limpiar(vista);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(vista, "La edad debe ser un número", "Error", JOptionPane.WARNING_MESSAGE);
                }
            }
        }

        if (e.getSource() == vista.btnEliminar) {
            if (vista.txtCorreoBiologo.getText().isEmpty() || vista.txtEdadBiologo.getText().isEmpty() || vista.txtPesoBiologo.getText().isEmpty()) {
                JOptionPane.showMessageDialog(vista, "Debes seleccionar un registro para eliminar", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                modelo.Eliminar(vista.tbBiologo);
                modelo.Mostrar(vista.tbBiologo);
                modelo.limpiar(vista);
            }
        }

        if (e.getSource() == vista.btnActualizar) {
            if (vista.txtCorreoBiologo.getText().isEmpty() || vista.txtEdadBiologo.getText().isEmpty() || vista.txtPesoBiologo.getText().isEmpty()) {
                JOptionPane.showMessageDialog(vista, "Debes seleccionar un registro para actualizar", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                try {
                    //Asignar lo de la vista al modelo al momento de darle clic a actualizar
                    modelo.setNombre_Biologo(vista.txtNombreBiologo.getText());
                    modelo.setEdad_Biologo(Integer.parseInt(vista.txtEdadBiologo.getText()));
                    modelo.setPeso_Biologo(Double.parseDouble(vista.txtPesoBiologo.getText()));
                    modelo.setCorreo_Biologo(vista.txtCorreoBiologo.getText());

                    //Ejecutar el método    
                    modelo.Actualizar(vista.tbBiologo);
                    modelo.Mostrar(vista.tbBiologo);
                    modelo.limpiar(vista);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(vista, "La edad debe ser un número", "Error", JOptionPane.WARNING_MESSAGE);
                }
            }
        }

        if (e.getSource() == vista.btnLimpiar) {
            modelo.limpiar(vista);
        }

        if (e.getSource() == vista.tbBiologo) {
            modelo.cargarDatosTabla(vista);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getSource() == vista.txtBuscarBiologo) {
            modelo.Buscar(vista.tbBiologo, vista.txtBuscarBiologo);
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
    }

}
