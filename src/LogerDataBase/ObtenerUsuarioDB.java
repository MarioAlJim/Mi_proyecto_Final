package LogerDataBase;

import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import LogerDataBase.*;

public class ObtenerUsuarioDB {

    public UsuarioDB obtenerUsuario(){
        UsuarioDB usuarioDB = new UsuarioDB();
        String user;
        String password;
        try{
            FileReader fr= new FileReader("resources/Usuarios.txt");
            BufferedReader br= new BufferedReader(fr);
            try{
                user = br.readLine();
                password = br.readLine();
                usuarioDB.setUser(user);
                usuarioDB.setPassword(password);
                br.close();
            }catch(IOException e1){
                System.out.println("Error en la lectura");
            }
        }catch(FileNotFoundException ex){
            System.out.println("No existe el archivo");
        }
        return usuarioDB;
    }

}
