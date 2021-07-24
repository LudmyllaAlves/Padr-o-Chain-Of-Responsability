/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chainofresponsability;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import chainofresponsability.Login;

/**
 *
 * @author tatia
 */
public class Minusculas extends Verifica{
     public Minusculas() {
        super("[a-z]");
    }
    
    public Login handle(Login login) {

        if(match(login.getSenha())){
            super.handle(login);
            return login;
        }
        
        System.out.println("A senha não possui caracter minusculo!");
        return super.handle(login);
    }
    
}
