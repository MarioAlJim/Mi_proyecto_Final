
package uv.gui.controladores;

import java.awt.HeadlessException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javax.swing.JOptionPane;
import uv.fei.tutorias.bussinesslogic.ExperienciaEducativaDAO;
import uv.fei.tutorias.bussinesslogic.DocenteEEProgramasDAO;
import uv.fei.tutorias.bussinesslogic.TutorTutoradoDAO;
import uv.fei.tutorias.domain.Docente;

import uv.fei.tutorias.domain.ExperienciaEducativa;


/**
 * FXML Controller class
 *
 * @author Valea
 */
public class CU46AsignarEEController implements Initializable {

    @FXML
    private TextField txtEE;
    @FXML
    private Button btnEE;
    @FXML
    private TableView<Docente>tabDocente;
    @FXML
    private TableColumn ColumnNomDocente;
    @FXML
    private TableColumn ColumnCuentaUv;
    @FXML
    private TableView<ExperienciaEducativa>tabEE;
    @FXML
    private TableColumn ColumnEE;
    @FXML
    private TableColumn ColumnNRC;
     @FXML
    private TextField prueba;
    @FXML
    private TableColumn<?, ?> Cmaterno;
     @FXML
    private TextField txtNP;
 
   private final ListChangeListener<ExperienciaEducativa> selectorTablaExperiencias=new ListChangeListener<ExperienciaEducativa> (){
            @Override
            public void onChanged (ListChangeListener.Change<? extends ExperienciaEducativa> c){
             getDatosExperienciaSeleccionada();
       }
    
    };
   
   
   
 public ExperienciaEducativa getTablaExperienciaSeleccionada (){
    if (tabEE != null){
        List<ExperienciaEducativa> tabla=tabEE.getSelectionModel ().getSelectedItems ();
        if (tabla.size ()== 1){
            final ExperienciaEducativa ExperienciaSeleccionada=tabla.get(0);
            return ExperienciaSeleccionada;
        } 
    
      }
    return null;
   }
 
    public int getDatosExperienciaSeleccionada(){
      final ExperienciaEducativa experiencia =getTablaExperienciaSeleccionada ();
      //prueba.setText(experiencia.getNombre());
      return experiencia.getNrc();
    }
    
    private final ListChangeListener<Docente> selectorTablaDocentes=new ListChangeListener<Docente> (){
            @Override
            public void onChanged (ListChangeListener.Change<? extends Docente> c){
             getDatosDocenteSeleccionado();
       }
    
    };
   
   
 public Docente getTablaDocenteSeleccionado (){
    if (tabEE != null){
        List<Docente> tabla=tabDocente.getSelectionModel ().getSelectedItems ();
        if (tabla.size ()== 1){
            final Docente DocenteSeleccionado=tabla.get(0);
            return DocenteSeleccionado;
        } 
    
      }
    return null;
   }
 
    public int getDatosDocenteSeleccionado(){
      final Docente docente =getTablaDocenteSeleccionado ();
      return docente.getNumPersonal();
    }
    
    
    
   private void cargarDatosExperiencias(){ 
        ExperienciaEducativaDAO instance = new  ExperienciaEducativaDAO();
         ArrayList<ExperienciaEducativa> experienciasEducativas= new ArrayList<>();
         experienciasEducativas = instance.consultarExperienciasNoAsignadas();


         this.ColumnEE.setCellValueFactory(new PropertyValueFactory("nombre"));
         this.ColumnNRC.setCellValueFactory(new PropertyValueFactory("nrc"));

         ObservableList<ExperienciaEducativa> experiencias = FXCollections.observableArrayList() ;

         for (ExperienciaEducativa experienciaEducativa1 : experienciasEducativas){
             experiencias.add(experienciaEducativa1); 
         }

          tabEE.setItems(experiencias); 
   }
   
    private void cargarDatosDocentes(){
        TutorTutoradoDAO instance = new  TutorTutoradoDAO();
         ArrayList<Docente> docentes= new ArrayList<>();
         docentes = instance.consultarTodosDocentes();


         this.ColumnNomDocente.setCellValueFactory(new PropertyValueFactory("nombre"));
         this.ColumnCuentaUv.setCellValueFactory(new PropertyValueFactory("NumPersonal"));
       

        

         ObservableList<Docente> docentesTabla = FXCollections.observableArrayList() ;

         for (Docente docente1 : docentes){
             docentesTabla.add(docente1); 
         }

          tabDocente.setItems(docentesTabla); 
   }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.cargarDatosExperiencias();
        this.cargarDatosDocentes();
        final ObservableList<ExperienciaEducativa> tablaExperienciaSeleccionada=tabEE.getSelectionModel().getSelectedItems();
        tablaExperienciaSeleccionada.addListener (selectorTablaExperiencias);
        
        final ObservableList<Docente> tablaDocenteSeleccionado=tabDocente.getSelectionModel().getSelectedItems();
        tablaDocenteSeleccionado.addListener (selectorTablaDocentes);
       
   
    }

    @FXML
    private void guardar(ActionEvent event) {
        
        try {
        
            int nrc= getDatosExperienciaSeleccionada();
            int numpersonal= getDatosDocenteSeleccionado();
            DocenteEEProgramasDAO instance = new  DocenteEEProgramasDAO();
            instance.asignarEEProfesor(nrc, numpersonal);
            ExperienciaEducativa experiencia= getTablaExperienciaSeleccionada ();    
            tabEE.getItems().remove(experiencia);
            this.tabEE.refresh();
            JOptionPane.showMessageDialog(null, "Asignación realizada correctamente");

        
        } catch (HeadlessException error){
        }
        
       
    }

    @FXML
    private void filtrarNumPersonal(KeyEvent event) {
        TutorTutoradoDAO instance = new  TutorTutoradoDAO();
        ArrayList<Docente> docentes= new ArrayList<>();
        docentes = instance.consultarTodosDocentes();
        
        ObservableList<Docente> docentesTabla = FXCollections.observableArrayList() ;
        String filtroDocente =  this.txtNP.getText();
      
        
        if (!(filtroDocente.isEmpty())){
          for (Docente docente1 : docentes){
             if (docente1.getNombre().toLowerCase().contains(filtroDocente.toLowerCase())) 
                     docentesTabla.add(docente1); 
        }
         
             tabDocente.setItems(docentesTabla);  
        }
        else{
            for (Docente docente1 : docentes){

               docentesTabla.add(docente1); 
        
        }
             tabDocente.setItems(docentesTabla);  
            
       
           
        }
    }
    @FXML
    private void filtrarNRC(KeyEvent event) {
    }

    @FXML
    private void buscarEE(ActionEvent event) {
         ExperienciaEducativaDAO instance = new  ExperienciaEducativaDAO();
         ArrayList<ExperienciaEducativa> experienciasEducativas= new ArrayList<>();
         experienciasEducativas = instance.consultarExperienciasNoAsignadas();
        
        ObservableList<Docente> docentesTabla = FXCollections.observableArrayList() ;
        String filtroEE =  this.txtEE.getText();
        
         ObservableList<ExperienciaEducativa> experiencias = FXCollections.observableArrayList() ;

         for (ExperienciaEducativa experienciaEducativa1 : experienciasEducativas){
             experiencias.add(experienciaEducativa1); 
         }
      
        
        if (!(filtroEE.isEmpty())){
         for (ExperienciaEducativa experienciaEducativa1 : experienciasEducativas){
             if (experienciaEducativa1.getNombre().toLowerCase().contains(filtroEE.toLowerCase())) 
                     experiencias.add(experienciaEducativa1); 
        }
         
          tabEE.setItems(experiencias); 
        }
        else{
         
         for (ExperienciaEducativa experienciaEducativa1 : experienciasEducativas){
             experiencias.add(experienciaEducativa1); 
         }
              tabEE.setItems(experiencias); 
            
       
           
        }
        
        
    }
    
      
    
    
    
    
    
}
