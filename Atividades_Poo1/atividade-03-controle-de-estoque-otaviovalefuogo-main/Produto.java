public class Produto {
    private String codigo;
    private String nome;
    private double preco;
    private int quantidade;
    private int estoqueMinimo;
    private static int c=0;

    public Produto(String codigo, String nome, double preco, int quantidade, int estoqueMinimo) {
        this.codigo = gerarcod();
        this.nome = nome;
        this.preco = preco;
        this.quantidade = quantidade;
        this.estoqueMinimo = estoqueMinimo;
    }
    private String gerarcod() {
        c++;
        String cod = String.valueOf(c);
        return cod;
    }
    public String getCodigo() {
        return codigo;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public double getPreco() {
        return preco;
    }
    public void setPreco(double preco) {
       if(preco > 0){
              this.preco = preco;
       }
        else{
            System.out.println("Preço inválido.");
        }
    }
    public int getQuantidade() {
        return quantidade;
    }
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
    public int getEstoqueMinimo() {
        return estoqueMinimo;
    }
    public boolean vender(int qtd) {
        if (qtd > 0 && qtd <= this.quantidade) {
            this.quantidade -= qtd;
            System.out.println("Venda de " + qtd + " unidades realizada com sucesso.");
            return true;
        } else {
            System.out.println("Quantidade inválida para venda.");
            return false;
        }
    }
    public void repor(int qtd) {
        if (qtd > 0) {
            this.quantidade += qtd;
            System.out.println("Reposição de " + qtd + " unidades realizada com sucesso.");
        } else {
            System.out.println("Quantidade inválida para reposição.");
        }
    }
    public void aplicarDesconto(double percentual) {
        if (percentual > 0 && percentual <= 100) {
            double desconto = (percentual / 100) * this.preco;
            this.preco -= desconto;
            System.out.println("Desconto de " + percentual + "% aplicado com sucesso.");
        } else {
            System.out.println("Percentual de desconto inválido.");
        }
    }
    private boolean VerificarEstoqueBaixo() {
        return this.quantidade < this.estoqueMinimo;
    }
    public void exibirDados() {
        System.out.println("Código: " + this.codigo);
        System.out.println("Nome: " + this.nome);
        System.out.println("Preço: R$" + this.preco);
        System.out.println("Quantidade em estoque: " + this.quantidade);
        System.out.println("Estoque mínimo: " + this.estoqueMinimo);
        if (VerificarEstoqueBaixo()) {
            System.out.println("Atenção: Estoque abaixo do mínimo!");
        }
    }
    
}
