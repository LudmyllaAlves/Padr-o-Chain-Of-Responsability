/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chainofresponsability;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author tatia
 */
public abstract class  Verifica {
    
  //Atributos  
    protected Verifica nextHandler = null;
    protected Pattern regex;

  //Construtores  
    public Verifica(String  regex) {
        this.regex = Pattern.compile(regex);
    }

    public Verifica() {
    
    }
    
  //Métodos  
    public Verifica setNextHandler(Verifica handler) {
        this.nextHandler = handler;
        return handler;
    }
  
    public Login handle(Login login){
       if(this.nextHandler != null){
           return this.nextHandler.handle(login);
       }
       
       return login;
   }
    
    protected boolean match(String value){
        Matcher match = regex.matcher(value);
        return match.find();
    }
    
}
