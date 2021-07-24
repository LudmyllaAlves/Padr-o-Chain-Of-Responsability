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
public class SeqNumero extends Verifica {
     public SeqNumero() {
        super("\\d{3,}");
    }

    @Override
    public Login handle(Login login) {
        if(!match(login.getSenha())){
            super.handle(login);
            return login;
        }
        
        System.out.println("A senha não pode ter números consecutivos!");
        return super.handle(login);
    }
    
}
