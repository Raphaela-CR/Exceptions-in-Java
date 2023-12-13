package model.exceptions;

public class DomainException extends Exception {
    private static final long serialVersionUID = 1L;

    public DomainException(String msg) {
        super(msg);
    }
    //Se no extends colocar RunTimeException ele não peder pra colocar throws DomainException nas funcoes e tratar os erros
}
