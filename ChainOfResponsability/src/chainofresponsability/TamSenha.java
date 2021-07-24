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
public class TamSenha extends Verifica{
    @Override
    public Login handle(Login login) {
        String senha = login.getSenha();
        
        if(senha.length() >= 8 && senha.length() <= 16){
            super.handle(login);
            return login;
        }
        
        System.out.println("A senha não tem um tamanho adequado!");
        return super.handle(login);
    }
    
}
