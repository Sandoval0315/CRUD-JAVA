package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.util.UUID;
import javax.swing.JTable;
import javax.swing.JTextField;
import vistas.jfrBiologo;

/**
 *
 * @author exequ
 */
public class mdlBiologo {

    ////////////////////////1- Parametros
    private String Nombre_Biologo;
    private int Edad_Biologo;
    private Double Peso_Biologo;
    private String Correo_Biologo;
    
            ////////////////////////2- Metodos get y set

    public String getNombre_Biologo() {
        return Nombre_Biologo;
    }

    public void setNombre_Biologo(String Nombre_Biologo) {
        this.Nombre_Biologo = Nombre_Biologo;
    }

    public int getEdad_Biologo() {
        return Edad_Biologo;
    }

    public void setEdad_Biologo(int Edad_Biologo) {
        this.Edad_Biologo = Edad_Biologo;
    }

    public Double getPeso_Biologo() {
        return Peso_Biologo;
    }

    public void setPeso_Biologo(Double Peso_Biologo) {
        this.Peso_Biologo = Peso_Biologo;
    }

    public String getCorreo_Biologo() {
        return Correo_Biologo;
    }

    public void setCorreo_Biologo(String Correo_Biologo) {
        this.Correo_Biologo = Correo_Biologo;
    }

    
    ////////////////////////3- Métodos 
    public void Guardar() {
        //Creamos una variable igual a ejecutar el método de la clase de conexión
        Connection conexion = ClaseConexion.getConexion();
        try {
            //Variable que contiene la Query a ejecutar
            String sql = "INSERT INTO TbBiologo(UUID_Biologo, Nombre_Biologo, Edad_Biologo, Peso_Biologo, Correo_Biologo) VALUES (?, ?, ?, ?,?)";
            //Creamos el PreparedStatement que ejecutará la Query
            PreparedStatement pstmt = conexion.prepareStatement(sql);
            //Establecer valores de la consulta SQL
            pstmt.setString(1, UUID.randomUUID().toString());
            pstmt.setString(2, getNombre_Biologo());
            pstmt.setInt(3, getEdad_Biologo());
            pstmt.setDouble(4, getPeso_Biologo());
            pstmt.setString(5, getCorreo_Biologo());


            //Ejecutar la consulta
            pstmt.executeUpdate();

        } catch (SQLException ex) {
            System.out.println("este es el error en el modelo:metodo guardar " + ex);
        }
    }

    public void Mostrar(JTable tabla) {
        //Creamos una variable de la clase de conexion
        Connection conexion = ClaseConexion.getConexion();
        //Definimos el modelo de la tabla
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.setColumnIdentifiers(new Object[]{ "UUID_Biologo", "Nombre_Biologo", "Edad_Biologo" , "Peso_Biologo","Correo_Biologo"});
        try {
            //Consulta a ejecutar
            String query = "SELECT * FROM TbBiologo";
            //Creamos un Statement
            Statement statement = conexion.createStatement();
            //Ejecutamos el Statement con la consulta y lo asignamos a una variable de tipo ResultSet
            ResultSet rs = statement.executeQuery(query);
            //Recorremos el ResultSet
            while (rs.next()) {
                //Llenamos el modelo por cada vez que recorremos el resultSet
                modelo.addRow(new Object[]{
               rs.getString("UUID_Biologo"),
               rs.getString("Nombre_Biologo"), 
               rs.getInt("Edad_Biologo"), 
               rs.getDouble("Peso_Biologo"),
               rs.getString("Correo_Biologo")
               });
            }
            //Asignamos el nuevo modelo lleno a la tabla
            tabla.setModel(modelo);
            tabla.getColumnModel().getColumn(0).setMinWidth(0);
            tabla.getColumnModel().getColumn(0).setMaxWidth(0);
            tabla.getColumnModel().getColumn(0).setWidth(0);
        } catch (Exception e) {
            System.out.println("Este es el error en el modelo, metodo mostrar " + e);
        }
    }

    public void Eliminar(JTable tabla) {
        //Creamos una variable igual a ejecutar el método de la clase de conexión
        Connection conexion = ClaseConexion.getConexion();

        //obtenemos que fila seleccionó el usuario
        int filaSeleccionada = tabla.getSelectedRow();
        //Obtenemos el id de la fila seleccionada

        String miId = tabla.getValueAt(filaSeleccionada, 0).toString();
        //borramos 
        try {
            String sql = "delete from TbBiologo where UUID_Biologo = ?";
            PreparedStatement deleteBiologo = conexion.prepareStatement(sql);
            deleteBiologo.setString(1, miId);
            deleteBiologo.executeUpdate();
        } catch (Exception e) {
            System.out.println("este es el error metodo de eliminar" + e);
        }
    }

    public void Actualizar(JTable tabla) {
        //Creamos una variable igual a ejecutar el método de la clase de conexión
        Connection conexion = ClaseConexion.getConexion();

        //obtenemos que fila seleccionó el usuario
        int filaSeleccionada = tabla.getSelectedRow();

        if (filaSeleccionada != -1) {
            //Obtenemos el id de la fila seleccionada
            String miUUId = tabla.getValueAt(filaSeleccionada, 0).toString();

            try {
                //Ejecutamos la Query
                String sql = "update TbBiologo set Nombre_Biologo= ?, Edad_Biologo = ?, Peso_Biologo = ? , Correo_Biologo = ? where UUID_Biologo = ?";
                PreparedStatement updateUser = conexion.prepareStatement(sql);

                updateUser.setString(1, getNombre_Biologo());
                updateUser.setInt(2, getEdad_Biologo());
                updateUser.setDouble(3, getPeso_Biologo());
                updateUser.setString(4, getCorreo_Biologo());
                updateUser.setString(5, miUUId);
                updateUser.executeUpdate();

            } catch (Exception e) {
                System.out.println("este es el error en el metodo de actualizar" + e);
            }
        } else {
            System.out.println("no");
        }
    }

    public void Buscar(JTable tabla, JTextField miTextField) {
        //Creamos una variable igual a ejecutar el método de la clase de conexión
        Connection conexion = ClaseConexion.getConexion();
        
        //Definimos el modelo de la tabla
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.setColumnIdentifiers(new Object[]{"Nombre", "Edad", "Peso", "Correo"});
        try {
            String sql = "SELECT * FROM TbBiologo WHERE Nombre_Biologo LIKE ? || '%'";
            PreparedStatement deleteBiologo = conexion.prepareStatement(sql);
            deleteBiologo.setString(1, miTextField.getText());
            ResultSet rs = deleteBiologo.executeQuery();

            while (rs.next()) {
                //Llenamos el modelo por cada vez que recorremos el resultSet
                modelo.addRow(new Object[]{rs.getString("Nombre"), rs.getInt("Edad"), rs.getDouble("Peso"), rs.getString("Correo")});
            }

            
            //Asignamos el nuevo modelo lleno a la tabla
            tabla.setModel(modelo);
            tabla.getColumnModel().getColumn(0).setMinWidth(0);
            tabla.getColumnModel().getColumn(0).setMaxWidth(0);
            tabla.getColumnModel().getColumn(0).setWidth(0);
        } catch (Exception e) {
            System.out.println("Este es el error en el modelo, metodo de buscar " + e);
        }
    }

    public void limpiar(jfrBiologo vista) {
        vista.txtNombreBiologo.setText("");
        vista.txtEdadBiologo.setText("");
        vista.txtPesoBiologo.setText("");
        vista.txtCorreoBiologo.setText("");
    }

    public void cargarDatosTabla(jfrBiologo vista) {
        // Obtén la fila seleccionada 
        int filaSeleccionada = vista.tbBiologo.getSelectedRow();

        // Debemos asegurarnos que haya una fila seleccionada antes de acceder a sus valores
        if (filaSeleccionada != -1) {
            String NombreDeTB = vista.tbBiologo.getValueAt(filaSeleccionada, 1).toString();
            String EdadDeTb = vista.tbBiologo.getValueAt(filaSeleccionada, 2).toString();
            String PesoDeTb = vista.tbBiologo.getValueAt(filaSeleccionada, 3).toString();
            String CorreoDeTB = vista.tbBiologo.getValueAt(filaSeleccionada, 4).toString();

            // Establece los valores en los campos de texto
            vista.txtNombreBiologo.setText(NombreDeTB);
            vista.txtEdadBiologo.setText(EdadDeTb);
            vista.txtPesoBiologo.setText(PesoDeTb);
            vista.txtCorreoBiologo.setText(CorreoDeTB);
        }
    }

}
