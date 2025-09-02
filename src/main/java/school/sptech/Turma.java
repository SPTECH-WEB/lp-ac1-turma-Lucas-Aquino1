package school.sptech;

public class Turma {
    private String nome;
    private Double mensalidade;
    private Integer qtdAluno;
    private Boolean ativa;

    public Turma(String nome, Double mensalidade){
        this.nome = nome;
        this.mensalidade = mensalidade;
        this.qtdAluno = 0;
        this.ativa = true;
    }

        public void matricular(Integer qtd){
            if(qtd != null && qtd > 0 && ativa){
              qtdAluno += qtd;
            }
        }

        public Integer cancelar(Integer qtd){
            if(ativa && qtd != null && qtd > 0 && qtd <= qtdAluno){
                qtdAluno -= qtdAluno - qtd;
                return qtdAluno;
            } else {
                return null;
            }
        }

        public Integer desativar(){
            if(!ativa){
                return null;
            }  else {
                ativa = false;
                Integer qtdAlunoAntes = qtdAluno;
                qtdAluno = 0;
                return qtdAlunoAntes;
            }
        }

        public void transferir(Turma destino, Integer qtdATransferir){
            if(destino != null && destino.ativa && ativa && qtdATransferir != null && qtdATransferir > 0 && qtdATransferir <= destino.qtdAluno){
                destino.qtdAluno += qtdATransferir;
                qtdAluno = destino.qtdAluno - qtdATransferir;
            }
        }

        public Boolean reajustarMensalidade(Double reajuste){
            if(reajuste == null || reajuste <= 0.0){
                mensalidade *= 1;
                return false;
            } else {
                mensalidade += (mensalidade * reajuste);
                return true;
            }
        }

    public String getNome() {
        return nome;
    }

    public Boolean getAtiva() {
        return ativa;
    }

    public Integer getQtdAluno() {
        return qtdAluno;
    }

    public Double getMensalidade() {
        return mensalidade;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
