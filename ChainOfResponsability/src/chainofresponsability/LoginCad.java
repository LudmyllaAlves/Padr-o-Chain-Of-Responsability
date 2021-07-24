/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chainofresponsability;

import java.util.ArrayList;
import chainofresponsability.Login;

/**
 *
 * @author tatia
 */
public class LoginCad extends Verifica{
     private ArrayList<Login> logins;

    public LoginCad(ArrayList<Login> logins) {
        this.logins = logins;
    }
    
    @Override
    public Login handle(Login login) {
        String loginOut = login.getEmail(), 
                senhaOut = login.getSenha();
        
        for(Login arrayLogin : logins){
            String loginIn = arrayLogin.getEmail(), 
                    senhaIn = arrayLogin.getSenha();
            
            if(loginIn.equals(loginOut) 
                && senhaIn.equals(senhaOut)){
                super.handle(login);
                return login;
            }
        }
        
        System.out.println("O login não encontrado!");
        return super.handle(login);
    }

    
}
