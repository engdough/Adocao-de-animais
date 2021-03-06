package ufsc.br.ine5605.adocaoAnimais.Controller;
import ufsc.br.ine5605.adocaoAnimais.Model.Gato;
import ufsc.br.ine5605.adocaoAnimais.Enum.Idade;
import ufsc.br.ine5605.adocaoAnimais.Enum.Porte;
import ufsc.br.ine5605.adocaoAnimais.Enum.Sexo;
import ufsc.br.ine5605.adocaoAnimais.Interfaces.IControladorCadastroGato;
import ufsc.br.ine5605.adocaoAnimais.View.TelaAnimal;

/**
 *
 * @author Ana Elisa Kruger
 */
public class ControladorCadastroGato implements IControladorCadastroGato{
    private Gato gato = new Gato();
    private final TelaAnimal telaAnimal = new TelaAnimal();
    
    public Gato pegaInformacoesTela(String codigoAnimal) {
        this.gato.setCodigo(codigoAnimal);
        pegaInfoSexo();
        pegaInfoIdade();
        pegaInfoPorte();
        pegaInfoPeso();
        pegaInfoRaca();
        pegaInfoFoiCastrado();
        pegaInfoApresentaDeficiencia();
        return gato;
    }
    
    public void pegaInfoSexo() {
        Sexo sexo = validaSexo("> Selecione o SEXO animal:\n" +
                "Digite uma das opcoes: FEMEA ou MACHO.");
        this.gato.setSexo(sexo); 
    }
    
    public void pegaInfoIdade() {
        Idade idade = validaIdade("\n> Selecione a opcao que melhor define " +
                "a IDADE do animal:\nDigite uma das opoces: FILHOTE, " +
                "ADULTO ou VELHO.");
        this.gato.setIdade(idade);
    }
    
    public void pegaInfoPorte() {
        Porte porte = validaPorte("\n> Selecione a opcoo que melhor define " +
                "o porte do animal:\nDigite uma das opcoes: PEQUENO, " +
                " MEDIO ou GRANDE.");
        this.gato.setPorte(porte);
    }
    
    public void pegaInfoRaca(){
        String raca = this.telaAnimal.getCampo("Digite aqui a RACA do animal:");
        this.gato.setRacaGato(raca);
    }
    
    public void pegaInfoPeso() {
        String peso = this.telaAnimal.getCampo("\nDigite aqui o peso do " +
                "ANIMAL:");
        this.gato.setPeso(peso);
    }
    
    public void pegaInfoFoiCastrado() {       
        boolean foiCastrado = pegaInfoBooleana("\n > O animal ja foi" +
                " CASTRADO? Responda com SIM ou NAO");
        this.gato.setFoiCastrado(foiCastrado);
    }
     
    public void pegaInfoApresentaDeficiencia() {
        boolean apresentaDeficiencia = pegaInfoBooleana("\n > O animal apresenta" +
                " DEFICIENCIA? Responda com SIM ou NAO");
        this.gato.setApresentaDeficiencia(apresentaDeficiencia);
    }
       
    public Idade validaIdade(String mensagem) {
        boolean correto = false;
        Idade idade = Idade.ADULTO;
        while(!correto){
            try{
            idade = this.telaAnimal.getCampoIdade(mensagem);
            correto = true;
            } catch(Exception respostaInvalidaException){
                telaAnimal.imprimeMensagem
                            (respostaInvalidaException.getMessage());
                correto = false;
            }
        }
        return idade;
    }
    public Porte validaPorte(String mensagem) {
        boolean correto = false;
        Porte porte = Porte.PEQUENO;
        while(!correto){
            try{
            porte = this.telaAnimal.getCampoPorte(mensagem);
            correto = true;
            } catch(Exception respostaInvalidaException){
                telaAnimal.imprimeMensagem
                            (respostaInvalidaException.getMessage());
                correto = false;
            }
        }
        return porte;
    }
    public Sexo validaSexo(String mensagem){
        boolean correto = false;
        Sexo sexo = Sexo.FEMEA;
        while(!correto){
            try{
            sexo = this.telaAnimal.getCampoSexo(mensagem);
            correto = true;
            } catch(Exception respostaInvalidaException){
                telaAnimal.imprimeMensagem
                            (respostaInvalidaException.getMessage());
                correto = false;
            }
        }
        return sexo;
    }
    public boolean pegaInfoBooleana(String mensagem){
        boolean correto = false;
        boolean resposta = false;
        while(!correto){
            try{
            resposta = this.telaAnimal.getCampoBoolean(mensagem);
            correto = true;
            } catch(Exception respostaInvalidaException){
                telaAnimal.imprimeMensagem
                            (respostaInvalidaException.getMessage());
                correto = false;
            }
        } 
         return resposta;
    }
}
