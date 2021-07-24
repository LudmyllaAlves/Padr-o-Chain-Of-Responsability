/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chainofresponsability;

/**
 *
 * @author tatia
 */
public class Caracterer extends Verifica {
    public Caracterer() {
        super("[\\W]");
    }

    @Override
    public Login handle(Login login) {
        if(match(login.getSenha())){
            super.handle(login);
            //Essa mensagem só será verdade se este item for o ultimo da cadeia
            System.out.println("O ultimo item a ser executado! Login válido!"); 
            return login;
        }
        
        System.out.println("Não há caractere especial na senha!");
        return super.handle(login);
    }
    
}
