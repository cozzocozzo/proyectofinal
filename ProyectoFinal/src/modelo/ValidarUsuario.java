
package modelo;


public class ValidarUsuario {
    
    public static void autenticar(Usuario u) throws Exception{
        
        if (!(u.getLogin().equals("alexis")&&u.getPassword().equals("17655001")))throw new UsuarioNoValidoException();
            
            
        }
     
     
       
       
        
        
    
    }

