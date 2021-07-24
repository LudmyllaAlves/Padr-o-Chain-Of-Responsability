/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chainofresponsability;
import java.util.ArrayList;
import java.util.Scanner;
import chainofresponsability.Login;
import chainofresponsability.Verifica;


/**
 *
 * @author tatia
 */
public class ChainOfResponsability {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
         ArrayList logins = new ArrayList<>();
        Scanner scan = new Scanner(System.in);
        String email, senha;
        
        logins.add(new Login("Jurema@ludys.com", "jfkfr@74FF"));
        logins.add(new Login("Dinah@ludys.com", "758//POUç9"));
        logins.add(new Login("Jhoana@ludys.com", "RCA&55a"));
        logins.add(new Login("Manuel@ludys.com", "neu32()45TR"));
        logins.add(new Login("email", "senha"));
        
        System.out.println("------------------------");
        
        System.out.print("E-mail: ");
        email = scan.next();
        System.out.print("Senha: ");
        senha = scan.next();
        
        Login login = new Login(email, senha);
        
        LoginCad verificarLogin = new LoginCad(logins);
        
        verificarLogin
                .setNextHandler(new TamSenha())
                .setNextHandler(new Maiusculas())
                .setNextHandler(new Minusculas())
                .setNextHandler(new Numero())
                .setNextHandler(new SeqNumero())
                .setNextHandler(new Caracterer());

        System.out.println("------------------------");
        
        Login log = verificarLogin.handle(login);
        
        System.out.println("------------------------");
        
        if(log != null)
            System.out.println("Login verificado: " + log.getEmail() + " Senha verificada" + log.getSenha());
    }
    
    
}
